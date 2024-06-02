/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.facade;


import dz.airalgerie.commun.model.entities.commun.CountUsers;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Root
 */
@Stateless
public class CountUsersFacade extends AbstractFacade<CountUsers> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public CountUsersFacade() {
    super(CountUsers.class);
  }

  /**
   * Augmenter le nombre Utilisation à chaque connexion
   *
   * @param domaine le domaine connecté.
   * @param date    le jour connecté.
   */

  public void updateUsersCount(String domaine, Date date) {
    em.createQuery(
        "UPDATE CountUsers s SET s.nbUtilisateur  = s.nbUtilisateur + 1 WHERE s.countUsersPK.date = :date AND s.countUsersPK.domaine = :domaine")
        .setParameter("domaine", domaine).setParameter("date", date).executeUpdate();
  }

  /**
   * réduire le nombre Utilisation à chaque déconnexion
   *
   * @param domaine le domaine déconnecté.
   * @param date    le jour déconnecté.
   */
  public void decreaseUsersCount(String domaine, Date date) {
    em.createQuery(
        "UPDATE CountUsers s SET s.nbUtilisateur=s.nbUtilisateur - 1 WHERE s.countUsersPK.date = :date AND s.countUsersPK.domaine = :domaine")
        .setParameter("domaine", domaine).setParameter("date", date).executeUpdate();
  }

  /**
   * récupérer les informations de connexion pendant une semaine
   *
   * @return
   */
  public List<Object[]> findBarChart() {
    return em.createNativeQuery("SELECT\n" + "    *\n" + "FROM\n" + "(\n"
        + "select	 top 7       CONVERT(varchar, c0.DATE, 23) DATE\n"
        + "            , c0.[PEAK] GRH, c1.[PEAK] GFC, c2.[PEAK] REF,c3.[PEAK] OPS,c4.[PEAK] PORTAIL\n"
        + "                 FROM AUTH.[COUNT_USERS] c0\n"
        + "                 join AUTH.[COUNT_USERS] c1 on c1.DATE = c0.DATE and c1.[DOMAINE] = 'GFC' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c2 on c2.DATE = c0.DATE and c2.[DOMAINE] = 'REF' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c3 on c3.DATE = c0.DATE and c3.[DOMAINE] = 'OPS' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c4 on c4.DATE = c0.DATE and c4.[DOMAINE] = 'PORTAIL' and c0.[DOMAINE] = 'GRH'\n"
        + "         			Order by c0.DATE Desc\n" + "					) SQ\n"
        + "ORDER BY\n" + "     DATE ASC").getResultList();
  }

  /**
   * récupérer les informations de connexion pendant un mois
   * 
   * @return
   */
  public List<Object[]> findBarChartLastMonth() {
    return em.createNativeQuery("SELECT\n" + "    *\n" + "FROM\n" + "(\n"
        + "select	 top 30       CONVERT(varchar, c0.DATE, 23) DATE\n"
        + "            , c0.[PEAK] GRH, c1.[PEAK] GFC, c2.[PEAK] REF,c3.[PEAK] OPS,c4.[PEAK] PORTAIL\n"
        + "                 FROM AUTH.[COUNT_USERS] c0\n"
        + "                 join AUTH.[COUNT_USERS] c1 on c1.DATE = c0.DATE and c1.[DOMAINE] = 'GFC' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c2 on c2.DATE = c0.DATE and c2.[DOMAINE] = 'REF' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c3 on c3.DATE = c0.DATE and c3.[DOMAINE] = 'OPS' and c0.[DOMAINE] = 'GRH'\n"
        + "                 join AUTH.[COUNT_USERS] c4 on c4.DATE = c0.DATE and c4.[DOMAINE] = 'PORTAIL' and c0.[DOMAINE] = 'GRH'\n"
        + "         			Order by c0.DATE Desc\n" + "					) SQ\n"
        + "ORDER BY\n" + "     DATE ASC").getResultList();
  }

  /**
   * récupérer les informations de connexion pour chaque domaine
   * 
   * @param date le jour spécifié.
   * @return
   */
  public List<CountUsers> retrieveData(Date date) {
    return em
        .createNativeQuery("SELECT [DOMAINE], [DATE],[NB_UTILISATEUR] \n"
            + "  FROM AUTH.COUNT_USERS WHERE DATE = ?1 order by DOMAINE", CountUsers.class)
        .setParameter(1, date).getResultList();
  }

  /**
   * initialisé le nombre des utilisateurs
   *
   * @param domaine le domaine spécifié.
   * @param date    le jour spécifié.
   */
  public void resetCount(String domaine, Date date) {
    try {
      em.createQuery(
          "UPDATE CountUsers s SET s.nbUtilisateur = 0 WHERE s.countUsersPK.date = :date  AND s.countUsersPK.domaine = :domaine")
          .setParameter("domaine", domaine).setParameter("date", date).executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * récupérer le pic Global
   * 
   * @return
   */
  public Object[] retrievePeakGlobal() {
    return (Object[]) em.createQuery(
        "SELECT s.countUsersPK.date, s.peak from CountUsers s WHERE s.countUsersPK.domaine = 'TOP'")
        .getSingleResult();
  }
}
