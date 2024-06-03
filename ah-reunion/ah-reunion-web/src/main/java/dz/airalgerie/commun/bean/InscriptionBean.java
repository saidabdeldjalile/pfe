/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.exception.InvalideInscriptionPortaillException;
import dz.airalgerie.commun.facade.CommunManagerFacade;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.ref.entities.RefInscription;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.ref.facade.RefGroupeFacade;
import dz.airalgerie.commun.ref.facade.RefInscriptionFacade;
import dz.airalgerie.commun.ref.facade.RefUserFacade;
import dz.airalgerie.commun.reunion.Employe;
import dz.airalgerie.commun.reunion.EmployeFacade;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.Messages;
import dz.airalgerie.commun.utils.PasswordHash;
import dz.airalgerie.commun.utils.UtilsLogger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import org.slf4j.LoggerFactory;
import dz.airalgerie.commun.utils.Strings;

/**
 *
 * @author AGHA Riadh
 */
@Named(value = "inscriptionBean")
@SessionScoped
public class InscriptionBean extends AbstractBeanManager {
  private static final long serialVersionUID = 1L;

  @EJB
  private CommunManagerFacade communManagerFacade;
  @EJB
  private RefUserFacade refUserFacade;
  @EJB
  private RefInscriptionFacade refInscriptionFacade;
  @EJB
  private EmployeFacade personnelFacade;
  @EJB
  private RefGroupeFacade refGroupeFacade;
  private RefUser refUser;
  private RefInscription refInscription;
  private String inscriptionEmail;
  private Integer matricule;
  private boolean nextStep;
  private String inscriptionCode;
  private String password;
  private String passwordConfirm;
  private boolean userExist;
  Employe personnel;
  RefGroupe defaulUserGroupeRoles;
  static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InscriptionBean.class);


  @PostConstruct
  public void init() {
    nextStep = false;
    inscriptionCode = null;
    inscriptionEmail = null;
    passwordConfirm = null;
    password = null;
  }

  public void switchNextStep() {
    nextStep = true;
  }

  /**
   * Permet d'envoyer le code d'inscription par email
   */
  public void sendInscriptionCode() {

    try {
      UtilsLogger.doLog(LOGGER, ErpConstante.LoggerAction.EXECUTE,
          "ENVOIE CODE INSCRIPTION PAR EMAIL", "INSCRIPTION");
      try {
        personnel = personnelFacade.findByMatricule(matricule);
      } catch (Exception e) {
        throw new InvalideInscriptionPortaillException(
            Messages.INSCRIPTION_USER_MATRICULE_NOT_FOUND_ERROR);
      }
      userExist = checkDuplicationInscription(matricule, inscriptionEmail);
      if (userExist) {
        this.sendFacesMessage(Messages.INSCRIPTION_USER_FOUND_ERROR, FacesMessage.SEVERITY_ERROR,
            false);
        getFacesContext().validationFailed();

      } else if (!inscriptionEmail.contains("@airalgerie.dz")) {
        this.sendFacesMessage(Messages.INSCRIPTION_USER_EMAIL_ERROR, FacesMessage.SEVERITY_ERROR,
            false);
        getFacesContext().validationFailed();
      } else if (personnel == null
          || !Strings.equalsIgnoreCaseWithTrim(personnel.getMail(), inscriptionEmail)) {
        this.sendFacesMessage(Messages.INSCRIPTION_USER_MATRICULE_MAIL_FOUND_ERROR,
            FacesMessage.SEVERITY_ERROR, false);
        getFacesContext().validationFailed();
      } else {
        refInscription = new RefInscription();
        String emailSubject = Messages.INSCRIPTION_CODE_PASSWORD_EMAIL_SUBJECT;
        String newInscriptionCode = this.generateInscriptionCode();
        refInscription.setMatricule(matricule);
        refInscription.setLogin(inscriptionEmail);
        refInscription.setInscriptionCode(newInscriptionCode);
        refInscriptionFacade.edit(refInscription);
        nextStep = true;
        refInscription = null;
        refUser = null;
        personnel = null;
      }
    } catch (InvalideInscriptionPortaillException e) {
      LOGGER.error("Erreur on send inscription code portail ", e);
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(Messages.GENERIC_ERROR);
      LOGGER.error("Erreur on send  registration code   ", e);
    }
  }


  /**
   * Permet de générer le code d'inscription
   * 
   * @return
   */
  private String generateInscriptionCode() {
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
   * Permet de vérifier si le code d'inscription n'est pas expiré
   * 
   * @param inscriptionCode : code de confirmation
   * 
   * @return
   */
  private boolean isExpidedInscriptionCode(String inscriptionCode) {

    boolean isExpided = false;
    int EXPIRATION_TIME = 5;
    Calendar today = Calendar.getInstance();
    Calendar confirmationDate = Calendar.getInstance();
    confirmationDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inscriptionCode.substring(0, 2)));
    confirmationDate.set(Calendar.MINUTE, Integer.parseInt(inscriptionCode.substring(8, 10)));

    long seconds = (today.getTimeInMillis() - confirmationDate.getTimeInMillis()) / 1000;
    int min = (int) (seconds / 60);
    if (min < 0 || min > EXPIRATION_TIME) {
      isExpided = true;
    }
    return isExpided;
  }

  /**
   * Permet l'inscription de l'employé via portail et l'attribution des roles par defaut suivant la
   * technicité.
   */
  public void inscription() {
    try {
      UtilsLogger.doLog(LOGGER, ErpConstante.LoggerAction.ADD, " INSCRIPTION UTILISATEUR PORTAIL ",
          "USER");
      if (!inscriptionEmail.contains("@airalgerie.dz")) {
        throw new InvalideInscriptionPortaillException(Messages.INSCRIPTION_USER_EMAIL_ERROR);
      }
      userExist = checkDuplicationInscription(matricule, inscriptionEmail);
      if (userExist) {
        throw new InvalideInscriptionPortaillException(Messages.INSCRIPTION_USER_FOUND_ERROR);
      }
      try {
        personnel = personnelFacade.findByMatricule(matricule);
      } catch (Exception e) {
        throw new InvalideInscriptionPortaillException(
            Messages.INSCRIPTION_USER_MATRICULE_NOT_FOUND_ERROR);
      }

      if (personnel == null
          || !Strings.equalsIgnoreCaseWithTrim(personnel.getMail(), inscriptionEmail)) {
        throw new InvalideInscriptionPortaillException(
            Messages.INSCRIPTION_USER_MATRICULE_MAIL_FOUND_ERROR);
      }

      this.refInscription = refInscriptionFacade.findByMatriculeLogin(matricule, inscriptionEmail);

      if (refInscription != null) {
        if (!inscriptionCode.equals(refInscription.getInscriptionCode())) {
          throw new InvalideInscriptionPortaillException(
              Messages.INSCRIPTION_USER_CODE_FOUND_ERROR);
        }
        if (!password.equals(passwordConfirm)) {
          throw new InvalideInscriptionPortaillException(
              Messages.INSCRIPTION_USER_PASSWORD_ERROR_IDENTIFICATION);
        }

        if (!PasswordHash.verifyPassword(password)) {
          throw new InvalideInscriptionPortaillException(
              Messages.INSCRIPTION_USER_PASSWORD_ERROR_EXIGENCES);
        }

        boolean isExpired = this.isExpidedInscriptionCode(inscriptionCode);
        if (isExpired) {
          throw new InvalideInscriptionPortaillException(
              Messages.INSCRIPTION_USER_CODE_FOUND_EXPIRED);
        }

        refUser = new RefUser();
        refUser.setLogin(inscriptionEmail);
        refUser.setMatricule(matricule);
        refUser.setMotDePasse(PasswordHash.hash(password));
        refUser.setIsInscriptionPortail(true);
        communManagerFacade.inscriptionUserPortail(refUser);
        refUser.addGroupe(defaulUserGroupeRoles);
        communManagerFacade.updateUserPortail(refUser);
        alertBean.getAlerts().addSuccess(Messages.INSCRIPTION_USER_SUCCESS);
        cleanerInscriptionCode();
      } else {
        this.sendFacesMessage(Messages.INSCRIPTION_USER_EMAIL_NOT_FOUND_ERROR,
            FacesMessage.SEVERITY_ERROR, false);
        getFacesContext().validationFailed();
      }
      inscriptionEmail = null;
      matricule = null;
      inscriptionCode = null;
      password = null;
      passwordConfirm = null;
      nextStep = false;
      refInscription = null;
      refUser = null;
      defaulUserGroupeRoles = null;
      personnel = null;
    } catch (InvalideInscriptionPortaillException e) {
      LOGGER.error("Erreur on inscription portail ", e);
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();
    } catch (Exception e) {
      LOGGER.error("Erreur on inscription portail ", e);
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();

    }
  }

  /**
   * Permet supprimer les demandes d'inscription ayant un code d'inscription expiré.
   */
  public void cleanerInscriptionCode() {
    List<RefInscription> inscriptionListe = refInscriptionFacade.findAll();
    for (int i = 0; i < inscriptionListe.size(); i++) {
      if (this.isExpidedInscriptionCode(inscriptionListe.get(i).getInscriptionCode())) {
        refInscriptionFacade.remove(inscriptionListe.get(i));
      }
    }
  }

  /**
   * Permet de verifier la duplication d'un utilisateur suivant :
   * 
   * @param matricule : matricule
   * @param login     : login
   * @return
   */
  public boolean checkDuplicationInscription(Integer matricule, String login) {
    refUser = new RefUser();
    refUser.setMatricule(matricule);
    refUser.setLogin(inscriptionEmail);
    return refUserFacade.checkDuplication(refUser);
  }

  /** Creates a new instance of InscriptionBean */
  public InscriptionBean() {
  }

  public String getInscriptionEmail() {
    return inscriptionEmail;
  }

  public void setInscriptionEmail(String inscriptionEmail) {
    this.inscriptionEmail = inscriptionEmail;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public boolean isNextStep() {
    return nextStep;
  }

  public void setNextStep(boolean nextStep) {
    this.nextStep = nextStep;
  }

  public String getInscriptionCode() {
    return inscriptionCode;
  }

  public void setInscriptionCode(String inscriptionCode) {
    this.inscriptionCode = inscriptionCode;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public boolean isUserExist() {
    return userExist;
  }

  public void setUserExist(boolean userExist) {
    this.userExist = userExist;
  }

  public Employe getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Employe personnel) {
    this.personnel = personnel;
  }

  public RefUser getRefUser() {
    return refUser;
  }

  public void setRefUser(RefUser refUser) {
    this.refUser = refUser;
  }

  public RefInscription getRefInscription() {
    return refInscription;
  }

  public void setRefInscription(RefInscription refInscription) {
    this.refInscription = refInscription;
  }

  public RefGroupe getDefaulUserGroupeRoles() {
    return defaulUserGroupeRoles;
  }

  public void setDefaulUserGroupeRoles(RefGroupe defaulUserGroupeRoles) {
    this.defaulUserGroupeRoles = defaulUserGroupeRoles;
  }



}
