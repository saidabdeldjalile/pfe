/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import static org.omnifaces.util.Faces.responseComplete;
import static org.omnifaces.util.Faces.validationFailed;
import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.exception.InvalidPasswordException;
import dz.airalgerie.commun.facade.CommunManagerFacade;
import dz.airalgerie.commun.utils.Messages;
import dz.airalgerie.commun.facade.PersonnelFacade;
import dz.airalgerie.commun.facade.SignalitiqueFacade;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.ref.facade.RefUserFacade;
import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import java.security.Principal;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.UtilsLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Sofyane MAKERRI
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private CommunManagerFacade communManagerFacade;
  @EJB
  private SignalitiqueFacade signalitiqueFacade;
  @EJB
  private RefUserFacade refUserFacade;
  @EJB
  private PersonnelFacade personnelFacade;
  private String login;
  private String password;
  private String passwordResetEmail;
  private String newPassword;
  private String passwordConfirm;
  private String confirmationCode;
  private RefUser refUser;
  @Inject
  private ApplicationBean applicationBean;
  private boolean nextStep;
  @Inject
  SecurityContext securityContext;
  @Inject
  private HttpServletRequest request;

  @PostConstruct
  public void init() {
    nextStep = false;
    confirmationCode = null;
    passwordConfirm = null;
    passwordResetEmail = null;
    newPassword = null;
  }

  public void execute() {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
      Credential credential = new UsernamePasswordCredential(login, new Password(password));

      AuthenticationStatus status = securityContext.authenticate(getRequest(context),
          getResponse(context), withParams().credential(credential));

      if (status == SEND_FAILURE) {
        throw new Exception();
      } else if (status == SEND_CONTINUE) {
        responseComplete();
      }

      String caller = ((UsernamePasswordCredential) credential).getCaller();
      this.refUser = refUserFacade.findByLogin(caller);
      PersonnelDTO loggedUser = personnelFacade.findByMatricule(this.refUser.getMatricule());
      UtilsLogger.userDetails(loggedUser);
      Object[] user = signalitiqueFacade.findUserInfos(this.refUser.getMatricule());
      ExternalContext externalContext = context.getExternalContext();
      Map<String, Object> sessionMap = externalContext.getSessionMap();
      sessionMap.put("User", refUser);
      userBean.setRefUser(refUser);
      userBean.setUser(user);
      userBean.setLoggedUser(loggedUser);
      sessionMap.put(ErpConstante.SessionKey.LOGGED_USER, loggedUser);    
      userBean.initNotifications(); 
      
    } catch (Exception e) {
      context.addMessage(null, new FacesMessage(SEVERITY_ERROR,
          "Une erreur est survenue, Veuillez vérifier vos identifiants", null));
      validationFailed();
    }
  }

  private static HttpServletResponse getResponse(FacesContext context) {
    return (HttpServletResponse) context.getExternalContext().getResponse();
  }

  private static HttpServletRequest getRequest(FacesContext context) {
    return (HttpServletRequest) context.getExternalContext().getRequest();
  }

  /**
   * Permet la réinitialisation du mot de passe
   */
  public void resetPassword() {
    try {

      this.refUser = refUserFacade.findByLogin(passwordResetEmail);
      if (refUser != null) {
        if (!confirmationCode.equals(refUser.getConfirmationCode())) {
          throw new InvalidPasswordException("Le code de confirmation est erroné.");
        }
        if (!newPassword.equals(passwordConfirm)) {
          throw new InvalidPasswordException("Les mots de passe ne sont pas identiques.");
        }
        boolean isExpired = this.isExpidedConfirmationCode(confirmationCode);
        if (isExpired) {
          throw new InvalidPasswordException(
              "Le code de confirmation est expiré, veuillez demander un autre code");
        }

        communManagerFacade.updatePassword(refUser, newPassword);
        userBean.setRefUser(communManagerFacade.findByMatricule(refUser.getMatricule()));
        alertBean.getAlerts().addSuccess(Messages.PASSWORD_RESET_SUCCESS);
      } else {
        this.sendFacesMessage(Messages.PASSWORD_RESET_EMAIL_NOT_FOUND_ERROR,
            FacesMessage.SEVERITY_ERROR, false);
        getFacesContext().validationFailed();
      }

      passwordResetEmail = null;
      newPassword = null;
      nextStep = false;
    } catch (InvalidPasswordException e) {
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();
    } catch (Exception e) {
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();

    }
  }

  /**
   * Permet d'envoyer le code de confirmation de changement de mot de passe par email
   */
  public void sendConfiramtionCode() {

    try {
      String emailSubject = Messages.CONFIRMATION_CODE_PASSWORD_RESET_EMAIL_SUBJECT;
      this.refUser = refUserFacade.findByLogin(passwordResetEmail);
      if (refUser != null) {
        String newConfirmationCode = this.generateConfirmationCode();
        refUser.setConfirmationCode(newConfirmationCode);
        refUserFacade.edit(refUser);
        nextStep = true;
      } else {
        this.sendFacesMessage(Messages.PASSWORD_RESET_EMAIL_NOT_FOUND_ERROR,
            FacesMessage.SEVERITY_ERROR, false);
        getFacesContext().validationFailed();
      }
    } catch (Exception e) {
      alertBean.getAlerts().addError(Messages.GENERIC_ERROR);
    }
  }

  /**
   * Permet de générer le code de confiramtion de changement de mot de passe
   * 
   * @return
   */
  private String generateConfirmationCode() {
    int count = 6;
    String ALPHA_NUMERIC_STRING = "0123456789";
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    Date date = new Date();
    DateFormat format = new SimpleDateFormat("HHmm");

    String output = (format.format(date).substring(0, 2).concat(builder.toString()))
        .concat(format.format(date).substring(2, 4));

    return output;
  }

  /**
   * Permet de vérifier si le code confirmation n'est pas expiré
   * 
   * @param confirmationCode : code de confirmation
   * 
   * @return
   */
  private boolean isExpidedConfirmationCode(String confirmationCode) {

    boolean isExpided = false;
    int EXPIRATION_TIME = 5;
    Calendar today = Calendar.getInstance();
    Calendar confirmationDate = Calendar.getInstance();
    confirmationDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(confirmationCode.substring(0, 2)));
    confirmationDate.set(Calendar.MINUTE, Integer.parseInt(confirmationCode.substring(8, 10)));

    long seconds = (today.getTimeInMillis() - confirmationDate.getTimeInMillis()) / 1000;
    int min = (int) (seconds / 60);
    if (min < 0 || min > EXPIRATION_TIME) {
      isExpided = true;
    }
    return isExpided;
  }

  public void switchNextStep() {
    nextStep = true;
  }

  /**
   * verifier si l'utilisateur est connecté
   * 
   * @throws IOException
   */
  public void isLoggedUser() throws IOException {
    if (userBean.getRefUser() != null) {
      redirectUser();
    }
  }

  /**
   * redirection vers page d'accueil
   * 
   */
  private void redirectUser() {
    try {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      String page = request.getServletPath();
      String contextPath = request.getContextPath();
      if (page.equalsIgnoreCase("/login.xhtml")) {
        ec.redirect(contextPath + "/index.xhtml");
      }
    } catch (IOException e) {
    }
  }

  public LoginBean() {
    // Bean consturtor.
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public UserBean getUserBean() {
    return userBean;
  }

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

  public String getPasswordResetEmail() {
    return passwordResetEmail;
  }

  public void setPasswordResetEmail(String passwordResetEmail) {
    this.passwordResetEmail = passwordResetEmail;
  }

  public boolean isNextStep() {
    return nextStep;
  }

  public void setNextStep(boolean nextStep) {
    this.nextStep = nextStep;
  }

  public String getConfirmationCode() {
    return confirmationCode;
  }

  public void setConfirmationCode(String confirmationCode) {
    this.confirmationCode = confirmationCode;
  }
}
