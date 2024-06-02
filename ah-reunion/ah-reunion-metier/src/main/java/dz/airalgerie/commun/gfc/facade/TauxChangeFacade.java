/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.facade;

import dz.airalgerie.commun.model.entities.commun.PaysTauxChange;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.Util;
import dz.airalgerie.gfc.model.entities.commun.MonnaieTauxchange;
import dz.airalgerie.gfc.model.entities.commun.ReportTauxChange;
import dz.airalgerie.gfc.model.entities.commun.TauxDeChange;
import dz.airalgerie.gfc.model.entities.commun.TauxPK;
import dz.airalgerie.portail.model.dto.bkr.TauxChangeBkr;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author KEHLI Moussab Amine
 */
@Stateless
public class TauxChangeFacade {

  @PersistenceContext(unitName = ErpConstante.UnitName.TAUX_CHANGE_PU_NAME)
  private EntityManager em;

  protected EntityManager getEntityManager() {
    return em;
  }

  public TauxChangeFacade() {
  }

  /**
   * Permet de récupérer la liste des taux de change
   *
   * @param date
   * 
   * @return
   */
  public List<TauxDeChange> getTauxChangeList(Date date) {

    Query query;

    int dateTrt = Util.getNumericDate(date);

    query = em.createNativeQuery("SELECT * " + " FROM [CHANGE].TAUX_CHANGE_GLOBAL "
        + " WHERE [CHANGE].TAUX_CHANGE_GLOBAL.DATE_TRAITEMENT = ?1 "
        + " ORDER BY [CHANGE].TAUX_CHANGE_GLOBAL.MONNAIE_ID").setParameter(1, dateTrt);

    List<TauxDeChange> finalResult = new ArrayList<TauxDeChange>();

    List<Object[]> res = query.getResultList();

    for (Object[] object : res) {
      TauxDeChange tauxChange = new TauxDeChange();
      TauxPK tauxPK = new TauxPK();

      tauxPK.setMonnaieId(Integer.parseInt("" + object[0]));
      tauxPK.setDateTraitement((int) object[1]);

      tauxChange.setTauxPK(tauxPK);

      tauxChange.setValeur((BigDecimal) object[2]);
      tauxChange.setValeurUSD((BigDecimal) object[4]);

      finalResult.add(tauxChange);
    }
    return finalResult;
  }

  /**
   * Permete de vérifier le la monnaie exisit dans la table
   *
   * @param monnaie
   * 
   * @return
   */
  public boolean existMonnaie(MonnaieTauxchange monnaie) {

    Query query;

    query = em
        .createNativeQuery(
            "SELECT COUNT(*) " + " FROM [CHANGE].MONNAIE" + " WHERE CODE_MONNAIE = ?1 ")
        .setParameter(1, monnaie.getMonnaieId());

    int result = (Integer) query.getSingleResult();

    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Permet d'inserer un nouvelle monnaie
   *
   * @param monnaie
   * 
   * @return
   */
  public boolean insertMonnaie(MonnaieTauxchange monnaie) {

    try {

      Query query;

      query = em
          .createNativeQuery("INSERT INTO [CHANGE].MONNAIE(CODE_MONNAIE,CODE_ALPHA_NUM,LIBELLE)"
              + " VALUES ( ?1 , ?2 , ?3)")
          .setParameter(1, monnaie.getMonnaieId()).setParameter(2, monnaie.getMonnaieCode())
          .setParameter(3, monnaie.getLibelle());

      query.executeUpdate();

      return false;

    } catch (Exception e) {
      return true;
    }
  }

  /**
   * Permete de vérfiier si le pays exist dans la table
   *
   * @param pays
   * 
   * @return
   */
  public boolean existPays(PaysTauxChange pays) {

    Query query;

    query = em
        .createNativeQuery("SELECT COUNT(*) " + " FROM [CHANGE].PAYS" + " WHERE NAME = ?1"
            + " AND CODE_MONNAIE = ?2")
        .setParameter(1, pays.getName()).setParameter(2, pays.getCodeMonnaie());

    int result = (Integer) query.getSingleResult();

    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Permete de récupérer le code pays
   *
   * @return
   */
  public ArrayList<String> getPaysCodeList() {

    Query query;

    query = em.createNativeQuery("SELECT * FROM [CHANGE].PAYS");

    ArrayList<String> finalResult = new ArrayList<String>();

    List<Object[]> res = query.getResultList();

    for (Object[] object : res) {
      String name = (String) object[1];
      name = name.replace(".", "");
      name = name.replace(" ", "");
      name = name.toLowerCase();
      String code = "" + (int) object[3];
      String str = name + code;
      finalResult.add(str);
    }

    return finalResult;
  }

  /**
   * Permet d'inserer un nouveau pays
   *
   * @param pays
   * 
   * @return
   */
  public boolean insertPays(PaysTauxChange pays) {

    try {

      Query query;

      query = em
          .createNativeQuery("INSERT INTO [CHANGE].PAYS(NAME,CODE_MONNAIE)" + " VALUES ( ?1 , ?2)")
          .setParameter(1, pays.getName()).setParameter(2, pays.getCodeMonnaie());

      query.executeUpdate();

      return false;

    } catch (Exception e) {
      return true;
    }
  }

  /**
   * Permet de vérifier si le taux de change exist dans la table
   *
   * @param tauxChange
   * 
   * @return
   */
  public boolean existTauxChange(TauxDeChange tauxChange) {

    Query query;

    query = em
        .createNativeQuery("SELECT COUNT(*) " + " FROM [CHANGE].TAUX_CHANGE_GLOBAL"
            + " WHERE MONNAIE_ID = ?1" + " AND DATE_TRAITEMENT = ?2")
        .setParameter(1, tauxChange.getTauxPK().getMonnaieId())
        .setParameter(2, tauxChange.getTauxPK().getDateTraitement());

    int result = (Integer) query.getSingleResult();

    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Permet d'inserer un nouveau taux de change
   *
   * @param tauxChange
   * 
   * @return
   */
  public boolean insertTauxChange(TauxDeChange tauxChange) {

    try {
      boolean resultGlobal = false;
      boolean resultFret = false;

      BigDecimal newValue = Util.formatBigDecimal(tauxChange.getValeur());

      Query query;

      query = em
          .createNativeQuery(
              "INSERT INTO [CHANGE].TAUX_DE_CHANGE(MONNAIE_ID,DATE_TRAITEMENT,VALEUR)"
                  + " VALUES ( ?1 , ?2, ?3)")
          .setParameter(1, tauxChange.getTauxPK().getMonnaieId())
          .setParameter(2, tauxChange.getTauxPK().getDateTraitement()).setParameter(3, newValue);

      int result = query.executeUpdate();

      if (result == 1) {
        resultGlobal = insertTauxChangeGlobal(tauxChange);

      } else {
        return true;
      }

      if (!resultGlobal) {
        return false;
      } else {
        return true;
      }

    } catch (Exception e) {
      return true;
    }
  }

  /**
   * Permet d'inserer le taux de change dans la table TAUX_CHANGE_GLOBAL
   *
   * @param tauxChange
   * 
   * @return
   */
  public boolean insertTauxChangeGlobal(TauxDeChange tauxChange) {

    try {

      BigDecimal newValue = Util.formatBigDecimal(tauxChange.getValeur());
      BigDecimal newValueDZD = Util.formatBigDecimal(
          (new BigDecimal(1)).divide(tauxChange.getValeur(), 30, RoundingMode.DOWN));

      Query query;

      query = em.createNativeQuery(
          "INSERT INTO [CHANGE].TAUX_CHANGE_GLOBAL(MONNAIE_ID,DATE_TRAITEMENT,VALEUR,VALEUR_USD,VALEUR_DZD)"
              + " VALUES ( ?1, ?2,?3 , ?4, ?5 )")
          .setParameter(1, tauxChange.getTauxPK().getMonnaieId())
          .setParameter(2, tauxChange.getTauxPK().getDateTraitement()).setParameter(3, newValue)
          .setParameter(4,
              tauxChange.getValeurUSD().divide(new BigDecimal(100000), 16, RoundingMode.DOWN))
          .setParameter(5, newValueDZD);

      query.executeUpdate();

      return false;

    } catch (Exception e) {
      return true;
    }
  }

  /**
   * Permet de récupérer la liste des taux de change pour l'exporation PDF
   *
   * @param date
   * 
   * @return
   */
  public List<ReportTauxChange> getTauxChangeGlobalList(Date date) {

    Query query;
    int dateNumeric = Util.getNumericDate(date);

    query = em
        .createNativeQuery("SELECT  [CHANGE].[PAYS].[NAME] as PAYS,\n"
            + "		[CHANGE].[PAYS].[CODE_MONNAIE] as CODE_NUM,\n"
            + "		[CHANGE].[MONNAIE].[CODE_ALPHA_NUM] as CODE_ALPH,\n"
            + "		[CHANGE].[TAUX_CHANGE_GLOBAL].[VALEUR_USD] ,\n"
            + "		[CHANGE].[TAUX_CHANGE_GLOBAL].[VALEUR_DZD] ,\n"
            + "		[CHANGE].[TAUX_CHANGE_GLOBAL].[VALEUR],\n"
            + "		[CHANGE].[TAUX_CHANGE_GLOBAL].[DATE_TRAITEMENT]\n"
            + "FROM  [CHANGE].[PAYS], [CHANGE].[TAUX_CHANGE_GLOBAL],[CHANGE].[MONNAIE]\n" + "\n"
            + "WHERE  [CHANGE].[PAYS].[CODE_MONNAIE] = [CHANGE].[TAUX_CHANGE_GLOBAL].[MONNAIE_ID]  "
            + "AND  [CHANGE].[PAYS].[CODE_MONNAIE] = [CHANGE].[MONNAIE].CODE_MONNAIE \n"
            + "AND [CHANGE].[TAUX_CHANGE_GLOBAL].DATE_TRAITEMENT = ?1")
        .setParameter(1, dateNumeric);

    List<ReportTauxChange> finalResult = new ArrayList<ReportTauxChange>();

    List<Object[]> res = query.getResultList();

    for (Object[] object : res) {
      ReportTauxChange reportTauxChange = new ReportTauxChange();

      reportTauxChange.setPays((String) object[0]);
      reportTauxChange.setCodeMonnaie((int) object[1]);
      reportTauxChange.setCodeAlphaNum((String) object[2]);
      reportTauxChange.setValueUSD((BigDecimal) object[3]);
      reportTauxChange.setValueDZD((BigDecimal) object[4]);
      reportTauxChange.setValue((BigDecimal) object[5]);

      finalResult.add(reportTauxChange);
    }
    return finalResult;
  }

  /**
   * Permet de vérifier si les taux de change exist pour un mois donnée
   *
   * @param date
   * 
   * @return
   */
  public boolean existDate(int date) {

    Query query;

    query = em.createNativeQuery(
        "SELECT COUNT(*) " + " FROM [CHANGE].TAUX_CHANGE_GLOBAL" + " WHERE DATE_TRAITEMENT = ?1")
        .setParameter(1, date);

    int result = (Integer) query.getSingleResult();

    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Permete de supprimer les taux de change pour un mois donnée
   *
   * @param date
   * 
   * @return
   */
  public boolean deleteData(int date) {

    Query query;

    query =
        em.createNativeQuery("DELETE FROM [CHANGE].TAUX_DE_CHANGE" + " WHERE DATE_TRAITEMENT = ?1")
            .setParameter(1, date);

    int result = (Integer) query.executeUpdate();

    query = em
        .createNativeQuery(
            "DELETE FROM [CHANGE].TAUX_CHANGE_GLOBAL" + " WHERE DATE_TRAITEMENT = ?1")
        .setParameter(1, date);

    result = (Integer) query.executeUpdate();

    return true;

  }

  /**
   * Permet de supprimer les pays
   *
   * @return
   */
  public int deletePays() {

    Query query;

    query = em.createNativeQuery("DELETE FROM [CHANGE].PAYS");

    int result = (Integer) query.executeUpdate();

    return result;
  }

  /**
   * Permet de récuprer les taux de changes en format BKR ( body du fichier )
   * 
   * @param dateTrt
   * @return
   */
  public List<TauxChangeBkr> findTauxChangeBkr(int dateTrt) {


    return em
        .createNativeQuery(
            "SELECT M.[CODE_ALPHA_NUM] as CODE_ALPH_NUM,\n"
                + "	   RIGHT('00000000000000000'+REPLACE(TCG.VALEUR,'.','')+'000', 17) VALEUR\n"
                + "FROM CHANGE.MONNAIE M \n"
                + "INNER JOIN CHANGE.TAUX_CHANGE_GLOBAL TCG ON TCG.MONNAIE_ID = M.CODE_MONNAIE\n"
                + "where DATE_TRAITEMENT = ?1" + " ORDER BY M.[CODE_ALPHA_NUM]",
            "TauxChangeBrkMapping")
        .setParameter(1, dateTrt).getResultList();
  }

  /**
   * Permet de récuprer les taux de changes en format BKR ( footer du fichier )
   * 
   * @param dateTrt
   * @return
   */
  public String findFooterBkr(int dateTrt) {

    return (String) em.createNativeQuery(
        "SELECT RIGHT('00000'+REPLACE(COUNT(VALEUR),'.',''), 5) + RIGHT('00000000000000000'+REPLACE(SUM(VALEUR),'.','')+'000', 17) TOTAL \n"
            + "FROM CHANGE.TAUX_CHANGE_GLOBAL\n" + "WHERE DATE_TRAITEMENT = ?1")
        .setParameter(1, dateTrt).getSingleResult();
  }

  /**
   * Permet de récupérer le taux de change M-1
   * 
   * @param dateTrt
   * @param codeMonnaie
   * @return
   */
  public BigDecimal findTauxChangeByDateAndCodeMonnaie(int dateTrt, String codeMonnaie) {
    return (BigDecimal) em
        .createNativeQuery("SELECT VALEUR FROM [TAUX_CHANGE].[CHANGE].[MONNAIE] M\n"
            + "  LEFT JOIN TAUX_CHANGE.CHANGE.TAUX_DE_CHANGE TG on TG.MONNAIE_ID = M.CODE_MONNAIE\n"
            + "  WHERE M.CODE_ALPHA_NUM = ?1 AND TG.DATE_TRAITEMENT = ?2")
        .setParameter(1, codeMonnaie).setParameter(2, dateTrt).getSingleResult();
  }
}
