/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.facade.CommunManagerFacade;
import dz.airalgerie.commun.ref.entities.Notifications;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 */
@Named(value = "notificationBean")
@ViewScoped
public class NotificationBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private CommunManagerFacade communManagerFacade;

  private Long nbUnreadNotifs;

  private List<Notifications> notifications;

  @Inject
  private ApplicationBean applicationBean;

  /**
   * Bean init.
   */
  @PostConstruct
  public void init() {
    initNotifications();
    findUnreadNotifications();
  }

  /**
   * Permet d'initialiser les vars liées aux notifications.
   */
  public void initNotifications() {
    if (this.getNotifications() != null) {
      this.getNotifications().clear();
    }
    if (this.userBean.getLoggedUser() != null) {
    this.setNotifications(communManagerFacade.findNotificationsByUser(applicationBean.getAppCode(),
        this.userBean.getLoggedUser().getMatricule()));
    }
  }

  /**
   * Permet de rechercher les notifications non-lues.
   */
  public void findUnreadNotifications() {
    if (this.getNotifications() != null && !this.getNotifications().isEmpty()) {
      nbUnreadNotifs = this.getNotifications().stream()
          .filter(n -> n.getIsRead() == null || !n.getIsRead()).count();
    } else {
      nbUnreadNotifs = 0L;
    }
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
  @Override
  public void sendNotification(Integer userMatricule, List<Integer> matricules,
      List<String> roleNames, String notifiableType, Integer notifiableId, String data) {
    try {
      communManagerFacade.addNotification(userMatricule, matricules, roleNames,
          applicationBean.getAppCode(), notifiableType, notifiableId, data);
    } catch (Exception e) {
      log.error("Error on notification.", e);
    }
  }

  /**
   * Permet d'envoyer une notification.
   * 
   * @param userMatricule  Matricule de l'employé notifieur.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   */
  @Override
  public void readNotification(Integer userMatricule, String notifiableType, Integer notifiableId) {
    try {
      communManagerFacade.readNotification(applicationBean.getAppCode(), userMatricule,
          notifiableType, notifiableId);
    } catch (Exception e) {
      log.error("Error on notification read.", e);
    }
  }

  /** Creates a new instance of NotificationBean */
  public NotificationBean() {
  }

  public Long getNbUnreadNotifs() {
    return nbUnreadNotifs;
  }

  public void setNbUnreadNotifs(Long nbUnreadNotifs) {
    this.nbUnreadNotifs = nbUnreadNotifs;
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
