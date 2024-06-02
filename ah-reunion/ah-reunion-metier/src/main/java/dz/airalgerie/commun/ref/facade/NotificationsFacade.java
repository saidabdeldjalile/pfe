/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.ref.entities.Notifications;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Stateless
public class NotificationsFacade extends AbstractFacade<Notifications> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public NotificationsFacade() {
    super(Notifications.class);
  }

  /**
   * Permet de rechercher les notifications d'un utilisateur, par domaine.
   * 
   * @param domaine   Domaine sélectionné.
   * @param matricule Matricule de l'utilisateur.
   * @return Liste des notifications.
   */
  public List<Notifications> findByDomaineAndMatricule(String domaine, Integer matricule) {
    return em.createQuery(
        "SELECT n FROM Notifications n WHERE n.domaine = :domaine AND n.matricule = :matricule ORDER BY n.createdAt DESC")
        .setParameter("domaine", domaine).setParameter("matricule", matricule).setMaxResults(7)
        .getResultList();
  }

  /**
   * Permet de rechercher les notifications non lue d'un utilisateur, par domaine et notifiable.
   * 
   * @param domaine        Domaine sélectionné.
   * @param matricule      Matricule de l'utilisateur.
   * @param notifiableType Type de l'objet notifié.
   * @param notifiableId   ID de l'objet notifié.
   * @return Liste des notifications non lues.
   */
  public List<Notifications> findByDomaineAndMatriculeAndNotifiableTypeAndNotifiableId(
      String domaine, Integer matricule, String notifiableType, Integer notifiableId) {
    return em.createQuery(
        "SELECT n FROM Notifications n WHERE n.domaine = :domaine AND n.matricule = :matricule AND n.notifiableType = :notifiableType AND n.notifiableId = :notifiableId",
        Notifications.class).setParameter("domaine", domaine).setParameter("matricule", matricule)
        .setParameter("notifiableType", notifiableType).setParameter("notifiableId", notifiableId)
        .getResultList();
  }

}
