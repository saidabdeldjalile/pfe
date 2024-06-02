/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.gfc.model.view.cg.CentreComptableDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrateur
 */
@Stateless
public class CentreComptableDirectionFacade extends AbstractFacade<CentreComptableDirection> {

  @PersistenceContext(unitName = ErpConstante.UnitName.CPTA_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public CentreComptableDirectionFacade() {
    super(CentreComptableDirection.class);
  }

  
  /**
   * Permet de récupérer la liste des directions de le centre comptable 
   * 
   * @param codeDir
   * @return 
   */
  public List<CentreComptableDirection> findDirectionsByCentre(String codeDir) {
    List<CentreComptableDirection> results = new ArrayList<>();
    try {
      results = em.createNativeQuery(
          "SELECT DISTINCT CODE_DIR , CODE_CENTRE_CPT , LIBELLE\n"
              + " FROM [CF].[V_CENTRE_CPT_DIRECTION]\n" 
              + " WHERE [CODE_CENTRE_CPT] = ?1\n"
              + " AND CODE_CENTRE_CPT IS NOT NULL\n"
              + " AND CODE_DIR IS NOT NULL"
              + " ORDER BY CODE_DIR",
          CentreComptableDirection.class).setParameter(1, codeDir).getResultList();

      return results;
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Permet de récupérer la liste des directions autorisés avec le centre comptable 
   * 
   * @param codeDir
   * @return 
   */
  public List<CentreComptableDirection> findDirectionsByCentreAndDirectionAutorisee(Set<String> codeDir) {
    List<CentreComptableDirection> results = new ArrayList<>();
    try {
      StringBuilder sb = new StringBuilder("(");
      
      for (String value : codeDir) {
            sb.append("'").append(value).append("', ");
      }
      
      if (!codeDir.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
      }
      sb.append(")");
      
      results = em.createNativeQuery(
          "SELECT DISTINCT CODE_DIR , CODE_CENTRE_CPT , LIBELLE\n"
              + " FROM [CF].[V_CENTRE_CPT_DIRECTION]\n" 
              + " WHERE [CODE_CENTRE_CPT] IN ?1\n"
              + " AND CODE_CENTRE_CPT IS NOT NULL\n"
              + " AND CODE_DIR IS NOT NULL"
              + " ORDER BY CODE_DIR",
          CentreComptableDirection.class).setParameter(1, codeDir).getResultList();

      return results;
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Trouver tous les centres comptables
   * 
   * @return
   */
  public List<CentreComptableDirection> findAllCentreComptableDirection() {
    List<CentreComptableDirection> results = new ArrayList<>();
    try {
      results = em.createQuery(
              " SELECT DISTINCT d FROM CentreComptableDirection d "
            + " WHERE d.centreComptablePK.codeDir IS NOT NULL "
            + " AND d.centreComptablePK.codeCentreCpt IS NOT NULL " 
            + " ORDER BY d.centreComptablePK.codeDir ")
          .getResultList();

      return results;
    } catch (Exception e) {
      return null;
    }
  }

}
