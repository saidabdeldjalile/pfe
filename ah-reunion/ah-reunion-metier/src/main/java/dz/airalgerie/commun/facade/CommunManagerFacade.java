/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.facade;

import dz.airalgerie.commun.exception.CustomException;
import dz.airalgerie.commun.exception.InvalidPasswordException;
import dz.airalgerie.commun.ref.entities.Notifications;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.ref.facade.NotificationsFacade;
import dz.airalgerie.commun.ref.facade.RefUserFacade;
import dz.airalgerie.commun.utils.PasswordHash;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
public class CommunManagerFacade {

  @EJB
  private RefUserFacade refUserFacade;
  @EJB
  private NotificationsFacade notificationsFacade;

  /**
   * Permet de trouver un utilisateur d'après son login.
   *
   * @param matricule : Matricule de l'utilisateur.
   * 
   * @return
   */
  public RefUser findByMatricule(Integer matricule) {
    return refUserFacade.find(matricule);
  }

  /**
   * Permet de trouver un utilisateur d'après son login.
   *
   * @param login : Login de l'utilisateur.
   * 
   * @return
   */
  public RefUser findByLogin(String login) {
    return refUserFacade.findByLogin(login);
  }

  /**
   * Permet de mettre à jour le mot de passe de l'utilisateur connecté.
   *
   * @param user        : User connecté.
   * @param oldPassword : Ancien mot de passe.
   * @param newPassword : Nouveau mot de passe.
   */
  public void updatePassword(RefUser user, String oldPassword, String newPassword) {
    try {

      if (!PasswordHash.verifyHash(oldPassword, user.getMotDePasse())) {
        throw new InvalidPasswordException(
            "Votre ancien mot de passe ne correspond pas. Veuillez vérifier votre mot de passe.");
      }

      if (oldPassword.equals(newPassword)) {
        throw new InvalidPasswordException(
            "Le nouveau mot de passe ne doit pas être identique avec l'ancien.");
      }

      if (!PasswordHash.verifyPassword(newPassword)) {
        throw new InvalidPasswordException("Votre nouveau mot de passe ne répond pas exigences.");
      }

      user.setMotDePasse(PasswordHash.hash(newPassword));

      user.setIsPasswordReset(false);

      refUserFacade.edit(user);

    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de mettre à jour le mot de passe avant l'autentification.
   *
   * @param user        : User a modifier.
   * @param newPassword : Nouveau mot de passe.
   */
  public void updatePassword(RefUser user, String newPassword) {
    try {

      if (!PasswordHash.verifyPassword(newPassword)) {
        throw new InvalidPasswordException("Votre nouveau mot de passe ne répond pas exigences.");
      }

      user.setMotDePasse(PasswordHash.hash(newPassword));

      user.setIsPasswordReset(false);

      user.setConfirmationCode(null);

      refUserFacade.edit(user);

    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet d'inscrire un employé via portail applicatif
   *
   * @param user : User a crée.
   */
  public void inscriptionUserPortail(RefUser user) {
    try {

      refUserFacade.create(user);

    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }


  /**
   * Permet de mettre a jour un utilisateur
   *
   * @param user : User a crée.
   */
  public void updateUserPortail(RefUser user) {
    try {

      refUserFacade.edit(user);

    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de rechercher les notifications d'un utilisateur, par domaine.
   * 
   * @param domaine   Domaine sélectionné.
   * @param matricule Matricule de l'utilisateur.
   * @return Liste des notifications.
   */
  public List<Notifications> findNotificationsByUser(String domaine, Integer matricule) {
    return notificationsFacade.findByDomaineAndMatricule(domaine, matricule);
  }

  /**
   * Permet d'ajouter une notification.
   * 
   * @param notification Notification à ajouter.
   */
  public void addNotification(Notifications notification) {
    notificationsFacade.create(notification);
  }

  /**
   * Permet d'ajouter une notification.
   * 
   * @param userMatricule  Matricule de l'employé notifieur.
   * @param matricules     Liste des employés à notifier.
   * @param roleNames      Liste des rôles d'utilisateurs à notifier.
   * @param domaine        Domaine applicatif.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   * @param data           Contenu de la notification.
   */
  public void addNotification(Integer userMatricule, List<Integer> matricules,
      List<String> roleNames, String domaine, String notifiableType, Integer notifiableId,
      String data) {
    List<Integer> notifiers;
    if (matricules == null || matricules.isEmpty()) {
      notifiers = refUserFacade.findByRoleName(roleNames);
    } else if (roleNames != null && !roleNames.isEmpty()) {
      notifiers = refUserFacade.findByMatriculesOrRoleName(matricules, roleNames);
    } else {
      notifiers = matricules;
    }

    if (notifiers != null) {
      notifiers.forEach(n -> {
        if (userMatricule != null && n != userMatricule) {
          Notifications notification = new Notifications();
          notification.setMatricule(n);
          notification.setNotifiableId(notifiableId);
          notification.setNotifiableType(notifiableType);
          notification.setData(data);
          notification.setDomaine(domaine);
          notification.setIsRead(Boolean.FALSE);
          notification.setCreatedAt(LocalDateTime.now());

          this.addNotification(notification);
        }
      });
    }

  }

  /**
   * Permet de marquer une notification comme lue.
   * 
   * @param domaine        Domaine applicatif.
   * @param matricule      Matricule de l'employé.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   */
  public void readNotification(String domaine, Integer matricule, String notifiableType,
      Integer notifiableId) {
    List<Notifications> notifications =
        notificationsFacade.findByDomaineAndMatriculeAndNotifiableTypeAndNotifiableId(domaine,
            matricule, notifiableType, notifiableId);

    notifications.forEach(notification -> {
      notification.setIsRead(Boolean.TRUE);
      notification.setReadAt(LocalDateTime.now());

      notificationsFacade.edit(notification);
    });

  }

}
