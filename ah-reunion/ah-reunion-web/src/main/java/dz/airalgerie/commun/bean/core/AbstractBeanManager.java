/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.core;

import dz.airalgerie.commun.bean.NotificationBean;
import dz.airalgerie.commun.bean.UserBean;
import dz.airalgerie.commun.bean.core.utils.AlertBean;
import dz.airalgerie.commun.utils.UtilsLogger;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.primefaces.PrimeFaces;

/**
 *
 */
public abstract class AbstractBeanManager implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  protected AlertBean alertBean;
  @Inject
  protected UserBean userBean;
  @Inject
  protected NotificationBean notificationBean;

  public String getResourcesAbsoluteDiskPath() {
    String relativeWebPath = "/resources/";
    ServletContext servletContext =
        (ServletContext) getFacesContext().getExternalContext().getContext();
    String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);
    if (!Files.exists(Paths.get(resourcesAbsoluteDiskPath))) {
      resourcesAbsoluteDiskPath = null;
    }

    return resourcesAbsoluteDiskPath;
  }

  public FacesContext getFacesContext() {
    return FacesContext.getCurrentInstance();
  }

  /**
   * Envoi d'un message.
   *
   * @param text            : Texte du message.
   * @param severity        : Gravité du message.
   * @param useFlashContext : Utilisation du contexte flash (dans le cadre d'une redirection)
   */
  public void sendFacesMessage(String text, Severity severity, boolean useFlashContext) {
    FacesContext facesContext = getFacesContext();

    facesContext.getExternalContext().getFlash().setKeepMessages(useFlashContext);

    if (severity == null) {
      severity = FacesMessage.SEVERITY_INFO;
    }

    FacesMessage facesMessage = new FacesMessage(severity, null, text);

    facesContext.addMessage(null, facesMessage);
  }

  /**
   * Envoi un message toastr.
   *
   * @param severity : Gravité du message.
   * @param summary  : Text du header de la notification.
   * @param message  : Texte du message. d'une redirection)
   */
  public static void sendToastr(String severity, String summary, String message) {
    PrimeFaces.current()
        .executeScript("showToast('" + severity + "', '" + summary + "', '" + message + "');");
  }

  /**
   * Permet d'envoyer une notification.
   * 
   * @param userMatricule  Matricule de l'employé notifieur.
   * @param matricules     Liste des employés à notifier.
   * @param roleNames      Liste des rôles d'utilisateurs à notifier.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   * @param data           Contenu de la notification.
   */
  public void sendNotification(Integer userMatricule, List<Integer> matricules,
      List<String> roleNames, String notifiableType, Integer notifiableId, String data) {
    this.notificationBean.sendNotification(userMatricule, matricules, roleNames, notifiableType,
        notifiableId, data);
  }

  /**
   * Permet de marquer une notification comme lue.
   * 
   * @param userMatricule  Matricule de l'employé notifieur.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   */
  public void readNotification(Integer userMatricule, String notifiableType, Integer notifiableId) {
    this.notificationBean.readNotification(userMatricule, notifiableType, notifiableId);
  }

  /**
   * Permet d'avoir les informations de log.
   * 
   * @return Nom d'utilisateur + timestamp.
   */
  public String userLog() {
    DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String agent = userBean.getLoggedUser().getMatricule().toString() + " - "
        + userBean.getLoggedUser().getNom();
    agent = agent.substring(0, Math.min(80, agent.length()));

    agent += " - " + (LocalDateTime.now()).format(datePattern);

    return agent;
  }

  /**
   * Permet de vider les valeurs de MDC
   */
  public void clearLog() {
    UtilsLogger.clear();
  }

  // Getters & Setters
  public AlertBean getAlertBean() {
    return alertBean;
  }

  public void setAlertBean(AlertBean alertBean) {
    this.alertBean = alertBean;
  }

  public UserBean getUserBean() {
    return userBean;
  }

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

  public NotificationBean getNotificationBean() {
    return notificationBean;
  }

  public void setNotificationBean(NotificationBean notificationBean) {
    this.notificationBean = notificationBean;
  }
}
