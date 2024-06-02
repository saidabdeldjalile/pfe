
/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */



package dz.airalgerie.commun.bean;

import dz.airalgerie.commun.facade.CommunManagerFacade;
import dz.airalgerie.commun.facade.SignalitiqueFacade;
import dz.airalgerie.commun.gfc.facade.CentreComptableDirectionFacade;
import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.commun.ref.entities.Notifications;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.utils.FTP;
import dz.airalgerie.gfc.model.view.cg.CentreComptableDirection;
import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import dz.airalgerie.grh.model.entities.carriere.Signalitique;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Diaf
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

  static final Logger LOGGER = LoggerFactory.getLogger(UserBean.class);
  private static final long serialVersionUID = 1L;

  @EJB
  SignalitiqueFacade SignalitiqueFacade;
  @EJB
  CentreComptableDirectionFacade centreComptableDirectionFacade;
  @EJB
  private CommunManagerFacade communManagerFacade;

  private Integer selectedMatricule;
  private final Integer codeApp = 5;
  private String query;
  private String role;
  private Object[] queryObject;
  private String logPath;
  private String context;
  private String homeLink;

  private PersonnelDTO loggedUser;

  private boolean show_photo;
  private boolean show_mobile;
  private Object[] user;
  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
  SimpleDateFormat formath = new SimpleDateFormat("HH:mm:ss");
  private Signalitique signalitique;
  private Object[] Profile;
  private Object[] ProfileEdit;
  private String userCondition;
  private final String FIL = Utils.dbSchema;
  private List<CentreComptableDirection> listDirections;
  // private User activUser = null;
  private String selectedYear;
  private String communPath;
  private Integer matricule;
  private RefUser refUser;
  private Map<String, List<RefPermission>> refPermissions;

  private List<Notifications> notifications = new ArrayList<>();

  @Inject
  private ApplicationBean applicationBean;

  /**
   * Permet d'initialiser les notifications d'un utilisateur.
   */
  public void initNotifications() {
    if (this.getNotifications() != null) {
      this.getNotifications().clear();
    }
    this.setNotifications(communManagerFacade.findNotificationsByUser(applicationBean.getAppCode(),
        this.getLoggedUser().getMatricule()));
  }

  public boolean isShow_photo() {
    return show_photo;
  }

  public void setShow_photo(boolean show_photo) {
    this.show_photo = show_photo;
  }

  public boolean isShow_mobile() {
    return show_mobile;
  }

  public void setShow_mobile(boolean show_mobile) {
    this.show_mobile = show_mobile;
  }

  public void toggleSrc(ActionEvent evt) {
    try {
      Integer matricule = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
          .getRequestParameterMap().get("matricule"));
      String searchMod = String.valueOf(FacesContext.getCurrentInstance().getExternalContext()
          .getRequestParameterMap().get("searchMod"));

      ProfileEdit = SignalitiqueFacade.searchProfile(matricule, searchMod);
      if (ProfileEdit != null) {
        show_photo = (boolean) ProfileEdit[16];
        show_mobile = (boolean) ProfileEdit[17];
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public Object[] getProfileEdit() {
    return ProfileEdit;
  }

  public void setProfileEdit(Object[] ProfileEdit) {
    this.ProfileEdit = ProfileEdit;
  }

  public void editContact() {
    if (Profile != null) {
      try {
        SignalitiqueFacade.editContact(Profile, show_photo, show_mobile);
      } catch (Exception e) {
        FacesContext.getCurrentInstance().validationFailed();
        e.printStackTrace();
      }
    }
  }

  public void editProfileContact() {
    if (ProfileEdit != null) {
      try {
        SignalitiqueFacade.editContact(ProfileEdit, show_photo, show_mobile);
      } catch (Exception e) {
        FacesContext.getCurrentInstance().validationFailed();
        e.printStackTrace();
      }
    }
  }

  public void redirectRole() throws IOException {
    homeLink = "inputPaie/saisiPaie.xhtml";
    if (refUser != null) {
      if (queryObject != null && queryObject[3] != null && !queryObject[3].toString().isEmpty()) {
        homeLink = queryObject[3].toString();
      }
      if (!homeLink.startsWith("\\/")) {
        homeLink = "/" + homeLink;
      }
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + homeLink);
    }
  }

  // IMMO
  public void redirectToHome() {
    try {
      FacesContext.getCurrentInstance().getExternalContext()
          .redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
              + "/pages/suivi-immo/responsable.xhtml");
      // TODO
      /**
       * ** Gestion des roles et permissions ****
       */
      // FacesContext context = FacesContext.getCurrentInstance();
      // if (context.getExternalContext().isUserInRole("responsable")) {
      // FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
      // + "/pages/suivi-immo/responsable.xhtml");
      // } else if (context.getExternalContext().isUserInRole("pdg")) {
      // FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
      // + "/pages/suivi-immo/pdg.xhtml");
      // } else if (context.getExternalContext().isUserInRole("divisionaire")) {
      // FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
      // + "/pages/suivi-immo/divisionaire.xhtml");
      // }

    } catch (IOException ex) {

      // Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Object[] getProfile() {
    if (Profile == null && signalitique != null) {
      Profile = SignalitiqueFacade.searchProfile(signalitique.getMatricule(), null);
      if (Profile != null) {
        show_photo = (boolean) Profile[16];
        show_mobile = (boolean) Profile[17];
      }
    }
    return Profile;
  }

  public String getProfileDir() {
    Object[] Profile = SignalitiqueFacade.searchProfile(getSelectedMatricule(), null);

    if (Profile != null) {
      return (String) Profile[18];
    }

    return "";
  }

  public void myProfile() {
    if (Profile != null) {
      show_photo = (boolean) Profile[16];
      show_mobile = (boolean) Profile[17];
    }
  }

  public void findUserDirections() {
    try {
      if (this.loggedUser != null && this.loggedUser.getGrpChap() != null
          && (listDirections == null || listDirections.isEmpty())) {
        if(refUser.getDirectionAutorisee().isEmpty()){
            listDirections = centreComptableDirectionFacade
            .findDirectionsByCentre(this.loggedUser.getGrpChap().substring(0, 2));  
        } else{
           Set<String> directionAutorisees = refUser.getDirectionAutorisee();
           directionAutorisees.add(this.loggedUser.getGrpChap().substring(0, 2));
           listDirections = centreComptableDirectionFacade
            .findDirectionsByCentreAndDirectionAutorisee(directionAutorisees);  
        }

      }
    } catch (Exception e) {
      LOGGER.error("Error on finding logged user directions", e);
    }
  }

  public void setProfile(Object[] Profile) {
    this.Profile = Profile;
  }

  public Signalitique getSignalitique() {
    if (signalitique == null) {
      try {
        signalitique = SignalitiqueFacade.find(getSelectedMatricule());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Object[] getQueryObject() {
    return queryObject;
  }

  public void setQueryObject(Object[] queryObject) {
    this.queryObject = queryObject;
  }

  public String getLogPath() {
    return logPath;
  }

  public void setLogPath(String logPath) {
    this.logPath = logPath;
  }

  public Object[] getUser() {
    return user;
  }

  public void setUser(Object[] user) {
    this.user = user;
  }

  public Integer getSelectedMatricule() {
    if (selectedMatricule == null && refUser != null) {
      selectedMatricule = Integer.valueOf(refUser.getMatricule());
    }
    return selectedMatricule;
  }

  public void setSelectedMatricule(Integer selectedMatricule) {
    this.selectedMatricule = selectedMatricule;
  }

  public void logout() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath());
  }

  public UserBean() {
  }


  public void setQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    if (query == null) {
      if (getQueryObject() != null && getQueryObject()[0] != null) {
        query = String.valueOf(getQueryObject()[0]);
      }
    }
    return query;
  }

  public String getCommunPath() {
    return communPath;
  }

  public String getSelectedYear() {
    return selectedYear;
  }

  public void setSelectedYear(String selectedYear) {
    this.selectedYear = selectedYear;
  }

  public void log(final String contenu) {
    TimerTask log = new TimerTask() {
      @Override
      public void run() {
        try {
          String nj = "";
          String content = null;
          String path = logPath + "GRH_" + format.format(new Date()) + ".txt";
          // if (refUser.getNjFille() != null) {
          // nj = String.valueOf(refUser.getNjFille());
          // }
          if (contenu != null) {
            content = contenu;
          } else {
            // content = "Access to GRH System : " + formath.format(new Date()) + " " +
            // getSelectedMatricule() + " " + refUser.getNom() + " " + refUser.getPrenoms() + " " +
            // nj /*+ "
            // " + user[4]*/ + " \r\n";
          }

          File file = new File(path);
          if (!file.exists()) {
            try {
              file.createNewFile();
            } catch (Exception e) {
            }
          }
          if (file.exists()) {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    };
    Timer timer = new Timer();
    timer.schedule(log, 0);
  }

  @PostConstruct
  public void init() {
    try {
      logPath = getDirectoryPath();
    } catch (IOException ex) {
      logPath = "";
      java.util.logging.Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (getSelectedMatricule() != null) {
      String app = FIL;// "PAIE";
      // String app = "ANNU";
      queryObject = SignalitiqueFacade.getUserQuery(selectedMatricule, codeApp);

      log(null);

      try {
        redirectRole();
      } catch (IOException ex) {
        System.out.println("Error");
      }
    }
  }

  public String getDirectoryPath() throws IOException {
    String relativeWebPath = "/resources/";
    ServletContext servletContext =
        (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String directoryPath = servletContext.getRealPath(relativeWebPath) + File.separator + "logs"
        + File.separator + applicationBean.getAppCode() + File.separator;

    if (!Files.exists(Paths.get(directoryPath))) {
      Files.createDirectories(Paths.get(directoryPath));
    }
    return directoryPath;
  }

  public String getHomeLink() {
    return homeLink;
  }

  public void setHomeLink(String homeLink) {
    this.homeLink = homeLink;
  }

  public Integer getCodeApp() {
    return codeApp;
  }

  public String getFIL() {
    return FIL;
  }

  public PersonnelDTO getLoggedUser() {
    return loggedUser;
  }

  public void setLoggedUser(PersonnelDTO loggedUser) {
    this.loggedUser = loggedUser;
  }

  public List<CentreComptableDirection> getListDirections() {
    this.findUserDirections();
    return listDirections;
  }

  public void setListDirections(List<CentreComptableDirection> listDirections) {
    this.listDirections = listDirections;
  }

  public String getRole() {
    if (role == null) {
      if (getRefUser() != null && getRefUser().getUserRole() != null) {
        role = getRefUser().getUserRole().getLabel();
      }
    }
    return role;
  }

  public String getUserCondition() {
    return userCondition;
  }

  public void setUserCondition(String userCondition) {
    this.userCondition = userCondition;
  }

  public RefUser getRefUser() {
    return refUser;
  }

  public void setRefUser(RefUser refUser) {
    this.refUser = refUser;
  }

  public void copyPhotoFromFTP(Integer matricule) {
    try {
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources/PhotosAH/";
      URL ireportUrl = getClass().getResource("/ireport/PhotosAH/");
      FTP.copyPhotoFromFTP(matricule, servletContext.getRealPath(relativeWebPath),
          applicationBean.getFtpConfigGRH());
      // System.out.println("***********************le Path Utilisé Est " +
      // ireportUrl.getPath().replaceFirst("%20", " "));
      // TO DO
      // FTP.copyPhotoFromFTP(matricule, ireportUrl.getPath().replaceFirst("%20", " "));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public Map<String, List<RefPermission>> getRefPermissions() {
    return refPermissions;
  }

  public void setRefPermissions(Map<String, List<RefPermission>> refPermissions) {
    this.refPermissions = refPermissions;
  }

  public List<Notifications> getNotifications() {
    return notifications;
  }

  public void setNotifications(List<Notifications> notifications) {
    this.notifications = notifications;
  }

  public ApplicationBean getApplicationBean() {
    return applicationBean;
  }

  public void setApplicationBean(ApplicationBean applicationBean) {
    this.applicationBean = applicationBean;
  }
}
