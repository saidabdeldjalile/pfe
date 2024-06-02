/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.ref.entities.RefInscription;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AGHA Riadh
 */
@Stateless
public class RefInscriptionFacade extends AbstractFacade<RefInscription> {
  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;


  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefInscriptionFacade() {
    super(RefInscription.class);
  }



  public RefInscription findByMatriculeLogin(Integer matricule, String login) {
    if (login != null && !login.isEmpty() && matricule != null) {
      List<RefInscription> list = em
          .createQuery(
              "SELECT u FROM RefInscription u where u.login =:login  or u.matricule=:matricule ",
              RefInscription.class)
          .setParameter("login", login).setParameter("matricule", matricule).getResultList();

      if (list != null && !list.isEmpty()) {
        return list.get(0);
      }

    }
    return null;
  }


}
