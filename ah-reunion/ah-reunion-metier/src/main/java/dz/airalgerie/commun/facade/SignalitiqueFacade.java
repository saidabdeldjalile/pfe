/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.facade;

import dz.airalgerie.commun.model.utils.DataAccessQueryBuilder;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.UserRole;
import dz.airalgerie.grh.model.entities.carriere.Signalitique;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Administrateur
 */
@Stateless
public class SignalitiqueFacade extends AbstractFacade<Signalitique> {

  @PersistenceContext(unitName = ErpConstante.UnitName.GRH_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!?";

  public String contactAction(Integer matricule) {
    try {
      Integer singleResult = (Integer) em.createNativeQuery(
          "SELECT c.MATRICULE  FROM CAR.CONTACT c where c.STATUT = 0 and c.MATRICULE = '"
              + matricule + "' ")
          .getSingleResult();
      if (singleResult != null) {
        return "update";
      } else if (singleResult != null) {
        return "no thing";
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "insert";
  }

  public boolean isValidUser(Integer matricule, String nom, String Prenom, String codeDir,
      String codeFonctioin) {
    try {
      em.createNativeQuery("select s.MATRICULE from [CAR].[SIGNALITIQUE] s\n"
          + "left join [CAR].CARRIERE c on s.matricule = c.matricule and c.date_fin = '2100-12-31'\n"
          + "where s.[MATRICULE] = " + matricule + "\n" + "and c.DATE_SORTIE is null\n"
          + "and s.NOM = '" + nom + "'\n" + "and s.PRENOMS = '" + Prenom + "'\n"
          + "and c.CODE_DIR = '" + codeDir + "'\n" + "and c.CODE_PSTR = '" + codeFonctioin + "'")
          .getSingleResult();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean isValidRetrait(Integer matricule, String nom, String Prenom) {
    try {
      em.createNativeQuery("select s.MATRICULE from [CAR].[SIGNALITIQUE] s\n"
          + "left join [CAR].CARRIERE c on s.matricule = c.matricule and c.date_fin = '2100-12-31'\n"
          + "where s.[MATRICULE] = " + matricule + "\n" + "and c.DATE_SORTIE is not null\n"
          + "and s.NOM = '" + nom + "'\n" + "and s.PRENOMS = '" + Prenom + "'").getSingleResult();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void insertRetraite(Integer matricule, String mobile, String fix, String Email) {

    String pwd = RandomStringUtils.random(10, characters);

    em.createNativeQuery("INSERT INTO [CAR].[CONTACT]\n" + "           ([MATRICULE]\n"
        + "           ,[MOBILE]\n" + "           ,[LIGNE_DIRECTE]\n" + "           ,[MAIL_RET]\n"
        + "           ,[DATE_INSCRIP_RET]\n" + "           ,MOT_DE_PASSE) \n" + "     VALUES\n"
        + "           (" + matricule + "\n" + "           ,'" + mobile + "'\n" + "           ,'"
        + fix + "'\n" + "           ,'" + Email + "'\n" + "           ,GETDATE()" + "           ,'"
        + pwd + "')").executeUpdate();

    // else if (action != null && action.equals("update")) {
    // em.createNativeQuery("UPDATE [CAR].[CONTACT] SET\n"
    // + " MOBILE = '" + mobile + "'\n"
    // + " ,LIGNE_DIRECTE = '" + fix + "'\n"
    // + " ,MAIL = '" + Email + "'\n"
    // + " ,DATE_INSCRIP = GETDATE()"
    // + " ,MOT_DE_PASSE = '"+pwd+"' ")
    // .executeUpdate();
    // }
  }

  public void updateRetraite(Integer matricule, String mobile, String fix, String Email) {

    String pwd = RandomStringUtils.random(10, characters);

    em.createNativeQuery("UPDATE [CAR].[CONTACT] SET\n" + "           MOBILE = '" + mobile + "'\n"
        + "           ,LIGNE_DIRECTE = '" + fix + "'\n" + "           ,MAIL_RET = '" + Email + "'\n"
        + "           ,DATE_INSCRIP_RET = GETDATE()" + "           ,MOT_DE_PASSE = '" + pwd + "' "
        + " where MATRICULE = '" + matricule + "'").executeUpdate();

    // else if (action != null && action.equals("update")) {
    // em.createNativeQuery("UPDATE [CAR].[CONTACT] SET\n"
    // + " MOBILE = '" + mobile + "'\n"
    // + " ,LIGNE_DIRECTE = '" + fix + "'\n"
    // + " ,MAIL = '" + Email + "'\n"
    // + " ,DATE_INSCRIP = GETDATE()"
    // + " ,MOT_DE_PASSE = '"+pwd+"' ")
    // .executeUpdate();
    // }
  }

  public void insertContact(Integer matricule, Integer quarteChifre, String mobile,
      String LigneDirecte, String Fax, Integer LigneIP, String TELEX, String Email, String action) {

    String pwd = RandomStringUtils.random(10, characters);

    if (action != null && action.equals("insert")) {
      em.createNativeQuery("INSERT INTO [CAR].[CONTACT]\n" + "           ([MATRICULE]\n"
          + "           ,[QUATRE_CHIFFRE]\n" + "           ,[MOBILE]\n" + "           ,[LIGNE_IP]\n"
          + "           ,[FAX]\n" + "           ,[LIGNE_DIRECTE]\n" + "           ,[MAIL_2]\n"
          + "           ,[ADRESSE_SITA]\n" + "           ,[DATE_INSCRIP]\n"
          + "           ,MOT_DE_PASSE) \n" + "     VALUES\n" + "           (" + matricule + "\n"
          + "           ," + (quarteChifre) + "\n" + "           ,'" + mobile + "'\n"
          + "           ," + LigneIP + "\n" + "           ,'" + Fax + "'\n" + "           ,'"
          + LigneDirecte + "'\n" + "           ,'" + Email + "'\n" + "           ,'" + TELEX + "'\n"
          + "           ,GETDATE()" + "           ,'" + pwd + "')").executeUpdate();
    } else if (action != null && action.equals("update")) {
      em.createNativeQuery("UPDATE [CAR].[CONTACT] SET\n" + "           QUATRE_CHIFFRE = "
          + (quarteChifre) + "\n" + "           ,MOBILE = '" + mobile + "'\n"
          + "           ,LIGNE_IP = " + LigneIP + "\n" + "           ,FAX = '" + Fax + "'\n"
          + "           ,LIGNE_DIRECTE = '" + LigneDirecte + "'\n" + "           ,MAIL_2 = '"
          + Email + "'\n" + "           ,ADRESSE_SITA = '" + TELEX + "'\n"
          + "           ,DATE_INSCRIP = GETDATE()" + "           ,MOT_DE_PASSE = '" + pwd
          + "' where MATRICULE = " + matricule + " ").executeUpdate();
    }

  }

  @Deprecated
  public Object[] getMatriculeByMail(String mail) {
    try {
      return (Object[]) em
          .createNativeQuery("SELECT TOP 1 P.[MATRICULE]\n" + "	, P.NOM\n" + "	, P.PRENOM\n"
              + "	, P.NJFILLE\n" + "	, P.DIR_LIBELLE\n" + "	, P.CODE_DIR\n"
              + "	, (CASE WHEN P.CODE_WIL = 99 THEN 'L''' ELSE '' END) + W.[DESC_WIL] DESC_WIL \n"
              + "FROM [CAR].V_PERSONNEL P\n"
              + "LEFT JOIN CAR.WILAYA W ON W.CODE_WIL = P.CODE_WIL \n" + "WHERE P.[MAIL] = ?1")
          .setParameter(1, mail).getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Object[] getUserQuery(Integer matricule, Integer codeApp) {
    try {
      return (Object[]) em.createNativeQuery(
          "SELECT [STRUCT_ADMIN],[ROLE],[TYPE_STRUCT], [INDEX_PAGE] FROM [AUTH].[USERS_APPLICATIONS] where MATRICULE = ?1 and CODE_APP = ?2")
          .setParameter(1, matricule).setParameter(2, codeApp).getSingleResult();
    } catch (Exception e) {
      // e.printStackTrace();
      return null;
    }
  }

  public SignalitiqueFacade() {
    super(Signalitique.class);
  }

  public List<Integer> autocompleatMatricule(String mat, RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("C.CODE_FIL", "")
              .withDirectionNativeConstraint("C.CODE_DIR", "")
              .withTechNativeConstraint("C.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(C.GRP_CHAP, 1, 3)", "").build();
      return em.createNativeQuery("SELECT DISTINCT TOP 10 C.MATRICULE \n"
          + " FROM CAR.V_PERSONNEL C INNER JOIN CAR.CARRIERE CAR ON C.MATRICULE = CAR.MATRICULE"
          + " WHERE C.MATRICULE LIKE ?1 AND (CAR.DATE_SORTIE IS NULL) AND CAR.DATE_FIN = '31-12-2100' \n"
          + " " + dataQuery.getQuery() + "\n" + "  ORDER BY C.MATRICULE").setParameter(1, mat + "%")
          .getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public List<Integer> autocompleatMatriculeRet(String mat) {
    try {
      return em.createNativeQuery("SELECT DISTINCT TOP 10 MATRICULE\n"
          + " FROM CAR.CARRIERE C WHERE (C.CODE_ACT = '092' OR C.CODE_ACT = '091') AND C.MATRICULE LIKE ?1\n"
          + " ORDER BY C.MATRICULE").setParameter(1, mat + "%").getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public boolean checkRet(Integer mat) {
    try {
      int k = (int) em
          .createNativeQuery(
              "SELECT count(*) FROM CAR.CARRIERE WHERE MATRICULE = ?1 AND CODE_ACT = '092'")
          .setParameter(1, mat).getSingleResult();
      return k > 0;
    } catch (Exception e) {
      return false;
    }
  }

  // @author sidali bougarne
  public List<String> autocompleatMatriculeNom(String mat, Character sexe) {
    try {
      return em.createNativeQuery(
          "SELECT top 20 cast(sig.[MATRICULE] as varchar) + ' - '+[NOM]+' '+[PRENOMS]\n"
              + "                  FROM [CAR].[SIGNALITIQUE] sig, [CAR].[SIT_FAMILIALE] sit  \n"
              + "			 WHERE sig.matricule = sit.matricule  AND sexe != ?1  AND sit.DATE_FIN = '2100-12-31' --AND sit.CODE_CIV != 'M' \n"
              + "                  AND sig.matricule like ?2 ORDER BY sig.matricule DESC")
          .setParameter(1, sexe).setParameter(2, mat + "%").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<String> autocompleatMatriculeNom(String mat, Date dateNaissance) {
    try {
      return em.createNativeQuery(
          "select top 20 cast([MATRICULE] as varchar) + ' - '+[NOM]+' '+[PRENOMS] from car.SIGNALITIQUE where DATE_NAIS > ?1  \n"
              + "			 and matricule like ?2 ORDER BY matricule DESC")
          .setParameter(1, dateNaissance).setParameter(2, mat + "%").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<String> autocompleatMatriculeNom(String mat, Date dateNaissance,
      Character lienParente) {
    try {
      return em.createNativeQuery(
          "select top 20 cast([MATRICULE] as varchar) + ' - '+[NOM]+' '+[PRENOMS] from car.SIGNALITIQUE where DATE_NAIS < '"
              + (new SimpleDateFormat("yyyy-MM-dd")).format(dateNaissance) + "'  \n"
              + "	AND SEXE = '" + (lienParente.equals('M') ? "F" : "M")
              + "' and matricule like ?2 ORDER BY matricule DESC")
          .setParameter(2, mat + "%").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<String> autocompleatNom(String nom, RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("C.CODE_FIL", "")
              .withDirectionNativeConstraint("C.CODE_DIR", "")
              .withTechNativeConstraint("C.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(C.GRP_CHAP, 1, 3)", "").build();

      Query q = em
          .createNativeQuery(
              "SELECT DISTINCT TOP 10 NOM + ' - ' + CAST(C.MATRICULE AS VARCHAR) RES\n"
                  + "  FROM  CAR.V_PERSONNEL C \n"
                  + "  WHERE (NOM + ' - ' + CAST(C.MATRICULE AS VARCHAR)) LIKE ?1 \n" + " "
                  + dataQuery.getQuery() + "\n" + "  ORDER BY RES")
          .setParameter(1, "%" + nom + "%");

      // dataQuery.getParametersList().forEach((p) -> {
      // q.setParameter(p.getAlias(), p.getValue());
      // });

      return q.getResultList();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  //

  public List<String> autocompleatNomProfil(String nom, RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("C.CODE_FIL", "")
              .withDirectionNativeConstraint("C.CODE_DIR", "")
              .withTechNativeConstraint("C.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(C.GRP_CHAP, 1, 3)", "").build();
      return em.createNativeQuery(
          "SELECT distinct TOP 10 q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar)\n"
              + "  FROM  car.SIGNALITIQUE Q\n"
              + "			 OUTER APPLY (SELECT TOP 1 * FROM CAR.V_PERSONNEL C WHERE C.MATRICULE = Q.MATRICULE ) C\n"
              + "  where (q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar)) like ?1 "
              + " " + dataQuery.getQuery()
              + "  order by q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar) ")
          .setParameter(1, "%" + nom + "%").getResultList();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  //

  public List<Object[]> autocompleatNomAnnuaire(String nom) {
    try {

      return em.createNativeQuery(
          "SELECT distinct  q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end),c.MATRICULE\n"
              + "  FROM CAR.CARRIERE c \n"
              + "  left join CAR.SIGNALITIQUE q on c.MATRICULE = q.MATRICULE\n"
              + "  left join CAR.CONTACT CN on c.MATRICULE = CN.MATRICULE\n"
              + "  where (q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)) like ?1 "
              + " AND c.DATE_FIN = '2100-12-31' "
              + " AND (c.DATE_SORTIE is null or c.code_act = 100) AND CN.MATRICULE is not null"
              // + " group by c.MATRICULE,c.CODE_TECH,q.NOM,q.PRENOMS,q.NJFILLE\n"
              // + " --having max(c.DATE_DEB) != (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
              // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.CODE_ACT in ('092') \n"
              // + " having max(c.DATE_DEB) = (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
              // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.CODE_DIR = '11' and
              // s.MATRICULE = c.MATRICULE) "

              + "  order by  q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)")
          .setParameter(1, nom + "%").getResultList();

      // return em.createNativeQuery("SELECT q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null
      // and q.NJFILLE != '') then 'NEE' +q.NJFILLE else ' ' end),c.MATRICULE\n"
      // + " FROM CAR.CARRIERE c \n"
      // + " left join SIGNALITIQUE q on c.MATRICULE = q.MATRICULE\n"
      // + " left join CONTACT t on c.MATRICULE = t.MATRICULE\n"
      // + " where (q.NOM+' '+q.PRENOMS) like ?1 and t.MATRICULE is not null\n"
      // + " group by c.MATRICULE,q.NOM,q.PRENOMS,q.NJFILLE\n"
      // + " --having max(c.DATE_DEB) != (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
      // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.DATE_SORTIE is not null and
      // s.MATRICULE = c.MATRICULE) \n"
      // + " order by c.MATRICULE desc")
      // .setMaxResults(50)
      // .setParameter(1, nom + "%")
      // .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer findLastMatricule() {
    try {
      return (Integer) em
          .createQuery("SELECT s.matricule FROM Signalitique s ORDER BY s.matricule DESC")
          .setMaxResults(1).getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  // public Object[] getAff(Integer matricule) {
  // try {
  // return (Object[]) em.createNativeQuery("SELECT top 1
  // p.LIBELLE,c.GRP_CHAP,c.COMPTE_ANAL,c.DATE_DEB,c.CODE_ACT,a.LIBELLE,\n"
  // + "g.LIBELLE as CODE_GEOGRAPHIQUE ,\n"
  // + "n.LIBELLE as NATIONALITE,\n"
  // + "niv.[DATE] as Date_Niveau,\n"
  // + "Refniv.LIBELLE as Refniv,c.CODE_CORPS,c.SECTION\n"
  // + "\n"
  // + " FROM CAR.CARRIERE c left join POSTE_TRAVAIL p\n"
  // + " on c.CODE_PSTR = p.CODE_PSTR\n"
  // + " left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
  // + " left join SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
  // + " left join CODE_GEOGRAPHIQUE g on s.LIEU_NAIS = g.CODE_GEO\n"
  // + " left join NATIONALITE n on s.NATIONALITE = n.CODE_NAT\n"
  // + " left join FRM.NIVEAU niv on niv.MATRICULE = s.MATRICULE\n"
  // + " left join FRM.REF_NIVEAU Refniv on Refniv.CODE_NIV = niv.CODE_NIV\n"
  // + " WHERE c.MATRICULE = ?1\n"
  // + " order by c.DATE_FIN desc")
  // .setParameter(1, matricule)
  // .getSingleResult();
  // } catch (Exception e) {
  // return null;
  // }
  // }
  //
  // public Object[] getAff(Integer matricule) {
  // try {
  // return (Object[]) em.createNativeQuery("SELECT top 1
  // p.LIBELLE,c.GRP_CHAP,c.COMPTE_ANAL,c.DATE_DEB,c.CODE_ACT,a.LIBELLE, \n"
  // + " g.LIBELLE as CODE_GEOGRAPHIQUE ,\n"
  // + " n.LIBELLE as NATIONALITE,c.CODE_CORPS,c.SECTION\n"
  // + " --niv.[DATE] as Date_Niveau,\n"
  // + " --Refniv.LIBELLE as Refniv,c.CODE_CORPS,c.SECTION\n"
  // + " \n"
  // + " FROM CAR.CARRIERE c left join CAR.POSTE_TRAVAIL p\n"
  // + " on c.CODE_PSTR = p.CODE_PSTR\n"
  // + " left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
  // + " left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
  // + " left join CAR.CODE_GEOGRAPHIQUE g on s.LIEU_NAIS = g.CODE_GEO\n"
  // + " left join CAR.NATIONALITE n on s.NATIONALITE = n.CODE_NAT\n"
  // + " --left join FRM.NIVEAU niv on niv.MATRICULE = s.MATRICULE\n"
  // + " --left join FRM.REF_NIVEAU Refniv on Refniv.CODE_NIV = niv.CODE_NIV\n"
  // + " WHERE c.MATRICULE =?1 AND C.CODE_ACT != '013'\n"
  // + " order by c.DATE_FIN desc")
  // .setParameter(1, matricule)
  // .getSingleResult();
  // } catch (Exception e) {
  // return null;
  // }
  // }
  public Object[] getAff(Integer matricule) {
    try {
      return (Object[]) em.createNativeQuery(
          "SELECT top 1 p.LIBELLE,c.GRP_CHAP,c.COMPTE_ANAL,c.DATE_DEB,c.CODE_ACT,a.LIBELLE,\n"
              + "g.LIBELLE as CODE_GEOGRAPHIQUE ,\n" + "n.LIBELLE as NATIONALITE,\n"
              + "niv.[DATE] as Date_Niveau,\n"
              + "Refniv.LIBELLE as Refniv,c.CODE_CORPS,c.SECTION,c.SECTION,pa.LIBELLE,niv.CODE_NIV\n"
              + " , niv.statut\n" + " , C.date_sortie\n"
              + ", case when (C.CODE_ACT='013') then ( select top 1 pst.LIBELLE from CAR.CARRIERE c1   left join  car.POSTE_TRAVAIL pst  on pst.CODE_PSTR=c1.CODE_PSTR where C.MATRICULE=c1.MATRICULE and c1.DATE_FIN=DATEADD(DAY,-1,C.DATE_DEB)) else '' end as Fct\n"
              + ",case when (C.DATE_FIN_CONTRAT<GETDATE() and C.DATE_SORTIE is null ) then '1' else case when (C.DATE_FIN_CONTRAT between GETDATE() \n"
              + " and DATEADD(M, DATEDIFF(M, '1990-01-01T00:00:00.000', CURRENT_TIMESTAMP), '1990-01-31T00:00:00.000')\n"
              + " and C.DATE_SORTIE is null)then '2' else '' end end  "
              + ",case when (year(C.DATE_ENTREE)=(YEAR(GETDATE()))) then '1' else '2' end"
              + ",case when (C.DATE_SORTIE is null or C.DATE_SORTIE='') then '0' else '1' end"
              + ",case when ((S.NUM_SS is null or S.NUM_SS='') and c.CODE_TECH!='L') then '1' else '0' end"
              + ",case when (gg.LIBELLE is null or gg.LIBELLE='') then '1' else '0' end"
              + " FROM CAR.SIGNALITIQUE S \n"
              + " OUTER APPLY (SELECT TOP 1 * FROM CAR.CARRIERE C WHERE S.MATRICULE = C.MATRICULE AND DATE_FIN = '31-12-2100' ORDER BY DATE_FIN DESC, DATE_DEB DESC) C \n"
              + " outer apply (select top 1 * from car.GRP_CHAP gg where C.GRP_CHAP = gg.GRP_CHAP  and C.COMPTE_ANAL=gg.COMPTE_ANAL  order by gg.DATE_FIN desc ) gg  \n"
              + "left join car.POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR\n"
              + "	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "	left join car.CODE_GEOGRAPHIQUE g on s.LIEU_NAIS = g.CODE_GEO\n"
              + "	left join car.PAYS pa on s.PAYS_NAIS = pa.CODE_PAY\n"
              + "	left join car.NATIONALITE n on s.NATIONALITE = n.CODE_NAT\n"
              + "	left join FRM.NIVEAU niv on niv.MATRICULE = s.MATRICULE\n"
              + "	left join FRM.REF_NIVEAU Refniv on Refniv.CODE_NIV = niv.CODE_NIV\n"
              + "	WHERE S.MATRICULE = ?1\n" + "	order by c.DATE_FIN desc")
          .setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      return null;
    }
  }

  public Integer searchCount(String codDir, String grp, boolean actif, boolean inactif, String tech,
      String corps, String fonction, String categ, String coll, String contrat, boolean mas,
      boolean fem, Integer searchIndex, RefUser user) {
    try {

      String where = "1 = 1";

      if (user != null && user.getUserRole() != null
          && user.getUserRole().getLabel().equals(UserRole.AdministrateurPN.getLabel())) {
        where = where + " AND "
            + user.getDirectionAutorisee().toString().replace("[", "").replace("]", "") + " ";
      } else if (user != null && user.getUserRole() != null
          && (user.getUserRole().getLabel().equals(UserRole.SousDirecteur.getLabel()))) {
        DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)

            .withDirectionNativeConstraint("c.CODE_DIR", "")
            .withTechNativeConstraint("c.CODE_TECH", "")
            .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP, 1, 3)", "").build();

        where = where + " " + dataQuery.getQuery() + " ";
      }

      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }
      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (tech != null && !tech.isEmpty()) {
        where = where + " AND c.CODE_TECH = '" + tech + "' ";
      }

      if (corps != null && !corps.isEmpty()) {
        where = where + " AND c.CODE_CORPS = '" + corps + "' ";
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (categ != null && !categ.isEmpty()) {
        where = where + " AND c.CODE_CATG = '" + categ + "' ";
      }

      if (coll != null && !coll.isEmpty()) {
        where = where + " AND c.CODE_COLLECTIF = '" + coll + "' ";
      }

      if (contrat != null && !contrat.isEmpty()) {
        where = where + " AND c.TYPE_CONTRAT = '" + contrat + "' ";
      }

      if (where.length() > 5) {
        if (actif && !inactif) {
          where = where + " and c.DATE_SORTIE is null";
        }
        if (!actif && inactif) {
          where = where + " and c.DATE_SORTIE is not null";
        }
        if (!actif && !inactif) {
          return null;
        }
        if (mas && !fem) {
          where = where + " and s.SEXE = 'M'";
        }
        if (!mas && fem) {
          where = where + " and s.SEXE = 'F'";
        }
        if (!mas && !fem) {
          return null;
        }
        return (Integer) em.createNativeQuery("with search as (SELECT c.MATRICULE"
            // + ",ROW_NUMBER() OVER (ORDER BY (case when cn.CODE_RANG is not null then cn.CODE_RANG
            // else 9999 end) ASC) AS ROWID\n"
            + "  FROM CAR.CARRIERE c \n"
            // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL =
            // '31-12-2100'\n"
            + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
            + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
            + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
            + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
            + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n" + "	WHERE " + where
            + " "
            + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')"
            + "     and c.DATE_FIN = '31-12-2100'  )\n" + "select count(*) from search "
            // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
            + "").getSingleResult();
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Object[]> search(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, RefUser user) {
    try {

      String where = "1 = 1";

      if (user != null && user.getUserRole() != null
          && (user.getUserRole().getLabel().equals(UserRole.AdministrateurPN.getLabel()))) {

        where = where + " AND "
            + user.getDirectionAutorisee().toString().replace("[", "").replace("]", "") + " ";
      } else if (user != null && user.getUserRole() != null
          && (user.getUserRole().getLabel().equals(UserRole.SousDirecteur.getLabel()))) {
        DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)

            .withDirectionNativeConstraint("c.CODE_DIR", "")
            .withTechNativeConstraint("c.CODE_TECH", "")
            .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP, 1, 3)", "").build();
        where = where + " " + dataQuery.getQuery() + " ";
      }

      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }

      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (tech != null && !tech.isEmpty()) {
        where = where + " AND c.CODE_TECH = '" + tech + "' ";
      }

      if (corps != null && !corps.isEmpty()) {
        where = where + " AND c.CODE_CORPS = '" + corps + "' ";
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (categ != null && !categ.isEmpty()) {
        where = where + " AND c.CODE_CATG = '" + categ + "' ";
      }

      if (coll != null && !coll.isEmpty()) {
        where = where + " AND c.CODE_COLLECTIF = '" + coll + "' ";
      }

      if (contrat != null && !contrat.isEmpty()) {
        where = where + " AND c.TYPE_CONTRAT = '" + contrat + "' ";
      }

      if (where.length() > 5) {
        if (actif && !inactif) {
          where = where + " and c.DATE_SORTIE is null";
        }
        if (!actif && inactif) {
          where = where + " and c.DATE_SORTIE is not null";
        }
        if (!actif && !inactif) {
          return null;
        }
        if (mas && !fem) {
          where = where + " and s.SEXE = 'M'";
        }
        if (!mas && fem) {
          where = where + " and s.SEXE = 'F'";
        }
        if (!mas && !fem) {
          return null;
        }
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction "
                + ",g.LIBELLE as affectation," + "s.SEXE\n"
                + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC,case when c.CODE_CORPS = 'E' then 1 when c.CODE_CORPS = 'M' then 2 when c.CODE_CORPS IN ('C','N') then  3 else 0 end desc,s.matricule asc) AS ROWID "
                // + ",ROW_NUMBER() OVER (ORDER BY (case when cn.CODE_RANG is not null then
                // cn.CODE_RANG else 9999 end) ASC) AS ROWID\n"
                + "  FROM CAR.CARRIERE c \n"
                // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL =
                // '31-12-2100'\n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
                + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
                + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n" + "	WHERE " + where
                + " "
                + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100') "
                + "     and c.DATE_FIN = '31-12-2100'  )\n" + "select * from search "
                + " where ROWID between (" + searchIndex + "-1)*9+1 and " + searchIndex + "*9 "
                // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
                + "")
            .getResultList();
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Object[]> searchReport(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, RefUser user, String select) {
    try {

      String where = "1 = 1";

      if (user != null && user.getUserRole() != null
          && user.getUserRole().getLabel().equals(UserRole.AdministrateurPN.getLabel())) {
        where = where + " AND "
            + user.getDirectionAutorisee().toString().replace("[", "").replace("]", "") + " ";
      }

      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }

      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (tech != null && !tech.isEmpty()) {
        where = where + " AND c.CODE_TECH = '" + tech + "' ";
      }

      if (corps != null && !corps.isEmpty()) {
        where = where + " AND c.CODE_CORPS = '" + corps + "' ";
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (categ != null && !categ.isEmpty()) {
        where = where + " AND c.CODE_CATG = '" + categ + "' ";
      }

      if (coll != null && !coll.isEmpty()) {
        where = where + " AND c.CODE_COLLECTIF = '" + coll + "' ";
      }

      if (contrat != null && !contrat.isEmpty()) {
        where = where + " AND c.TYPE_CONTRAT = '" + contrat + "' ";
      }

      if (where.length() > 5) {
        if (actif && !inactif) {
          where = where + " and c.DATE_SORTIE is null";
        }
        if (!actif && inactif) {
          where = where + " and c.DATE_SORTIE is not null";
        }
        if (!actif && !inactif) {
          return null;
        }
        if (mas && !fem) {
          where = where + " and s.SEXE = 'M'";
        }
        if (!mas && fem) {
          where = where + " and s.SEXE = 'F'";
        }
        if (!mas && !fem) {
          return null;
        }
        return em.createNativeQuery("with search as (SELECT " + select
            + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC,case when c.CODE_CORPS = 'E' then 1 when c.CODE_CORPS = 'M' then 2 when c.CODE_CORPS IN ('C','N') then  3 else 0 end desc,s.matricule asc) AS ROWID "
            // + ",ROW_NUMBER() OVER (ORDER BY (case when cn.CODE_RANG is not null then cn.CODE_RANG
            // else 9999 end) ASC) AS ROWID\n"
            + "  FROM CAR.CARRIERE c \n"
            + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
            + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
            + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
            + "	left join CAR.DIRECTION dr on dr.CODE_DIR = c.CODE_DIR \n"
            + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
            + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
            + "     left join car.[CATEGORIE] cat on c.code_catg = cat.code_catg \n"
            + "     left join car.[CONTRAT] con on con.[TYPE_CONTRAT] = c.[TYPE_CONTRAT] \n"
            + "     left join car.[TECHNICITE] tech on tech.[CODE_TECH] = c.[CODE_TECH] \n"
            + "     left join car.[CORPS] cor on cor.[CODE_CORPS] = c.[CODE_CORPS] \n"
            + "     left join car.[COLLECTIF] col on col.[CODE_COLLECTIF] = c.[CODE_COLLECTIF] \n"
            + "     left join car.ACTE act on act.CODE_ACT = c.code_act \n"
            + "     outer apply (select top 1 civ.LIBELLE from SIT_FAMILIALE s \n"
            + "                    left join CIVILE civ on s.CODE_CIV = civ.CODE_CIV\n"
            + "                    where s.MATRICULE = c.matricule\n"
            + "                    order by s.DATE_FIN desc) fam \n" + "	WHERE " + where + " "
            + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100') \n"
            + "     and c.DATE_FIN = '31-12-2100')\n" + "select * from search "
            // + " where ROWID between (" + searchIndex + "-1)*9+1 and " + searchIndex + "*9 "
            // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
            + "").getResultList();
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer searchAnnuaireCount(Integer searchIndex) {
    try {
      String sql = "1 = 1";
      if (searchIndex != null) {
        if (searchIndex == 1) {
          sql = "SELECT COUNT(*)  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join CAR.ACTE  a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null  AND (cn.MAIL  is null or  cn.MAIL  = '') and c.DATE_SORTIE is null  	"
              + " and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100'";
        }
        if (searchIndex == 3) {
          sql = "SELECT COUNT(*)   FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join CAR.ACTE  a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null and 1 = 1 AND cn.STATUT  = 0 and cn.[MAIL_RET] is not null and cn.[MAIL_RET] != '' and c.DATE_SORTIE is not null  	"
              + " and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')    "
              + " and c.DATE_FIN = '31-12-2100'";
        }
        if (searchIndex == 2) {
          sql = "SELECT COUNT(*)  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join CAR.ACTE  a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null and 1 = 1 AND (cn.MAIL  is not null and  cn.MAIL  != '') and c.DATE_SORTIE is not null and c.CODE_ACT != 100  	"
              + "and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + "and c.DATE_FIN = '31-12-2100' ";
        }
        if (searchIndex == 5) {
          sql = "SELECT COUNT(*)   FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join CAR.ACTE  a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null and 1 = 1 AND cn.STATUT  = 1 and cn.[MAIL_RET] is not null and cn.[MAIL_RET] != '' and c.DATE_SORTIE is not null  	"
              + " and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100'";
        }
        return (Integer) em.createNativeQuery(sql).getSingleResult();

      }
      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public List<Object[]> searchAnnuaire(Integer mode, Integer searchIndex) {
    try {
      String where = "1 = 1";
      String order = "";
      if (mode != null) {
        if (mode == 1) {
          where = where + " AND (cn.MAIL  is null or  cn.MAIL  = '') and c.DATE_SORTIE is null ";
          order = "order by DATE_INSCRIP";
        }
        if (mode == 3) {
          where = where
              + " AND cn.STATUT  = 0 and cn.[MAIL_RET] is not null and cn.[MAIL_RET] != '' and c.DATE_SORTIE is not null ";
        }
        if (mode == 5) {
          where = where
              + " AND cn.STATUT  = 1 and cn.[MAIL_RET] is not null and cn.[MAIL_RET] != '' and c.DATE_SORTIE is not null ";
        }
        if (mode == 2) {
          where = where
              + " AND (cn.MAIL  is not null and  cn.MAIL  != '') and c.DATE_SORTIE is not null and c.CODE_ACT != '100' ";
        }
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction "
                + ",g.LIBELLE as affectation," + "s.SEXE,cn.[QUATRE_CHIFFRE]\n"
                + "      ,cn.[MOBILE]\n" + "      ,cn.[LIGNE_IP]\n" + "      ,cn.[FAX]\n"
                + "      ,cn.[LIGNE_DIRECTE]\n" + "      ,cn.[MAIL]\n" + "      ,cn.[MAIL_2]\n"
                + "      ,cn.[ADRESSE_SITA]\n" + "      ,cn.[ADRESSE]\n" + "      ,cn.MOT_DE_PASSE"
                + "      ,cn.MAIL_RET" + "      ,cn.DATE_INSCRIP_RET" + "      ,cn.SHOW_PHOTO"
                + "      ,cn.SHOW_MOBILE" + "      ,cn.DATE_INSCRIP" + "      ,c.DATE_SORTIE"
                + "      ,c.GRP_CHAP" + "      ,c.DATE_ENTREE" + "      ,c.CODE_CORPS\n"
                + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC,case when c.CODE_CORPS = 'E' then 1 when c.CODE_CORPS = 'M' then 2 when c.CODE_CORPS IN ('C','N') then  3 else 0 end desc,s.matricule asc) AS ROWID "
                // + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null
                // then cn.CODE_RANG else 9999 end) ASC) AS ROWID\n"
                + "  FROM CAR.CARRIERE c \n"
                // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL =
                // '31-12-2100'\n"
                // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
                // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100'\n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
                + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
                + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
                + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	WHERE  cn.MATRICULE is not null and " + where + " "
                + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')"
                + "     and c.DATE_FIN = '31-12-2100'  )\n" + "select * from search "
                + " where ROWID between (" + searchIndex + "-1)*21+1 and " + searchIndex + "*21 "
                // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
                + order)
            .getResultList();

      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer searchAnnuaireCount(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, String keyWord, String nom,
      Integer matricule) {
    try {
      String where = "1 = 1";
      if (matricule != null) {
        where = where + " AND c.matricule = " + matricule;
      }
      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }
      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (nom != null && !nom.trim().isEmpty()) {
        where = where
            + " AND s.NOM+' '+s.PRENOMS+(CASE WHEN (s.NJFILLE is not null and s.NJFILLE != '') then ' NÉE '+s.NJFILLE else '' end)+' - '+cast(s.MATRICULE as varchar) like '"
            + nom.trim() + "%' ";
      }

      if (keyWord != null && !keyWord.trim().isEmpty()) {
        String[] parts = keyWord.trim().split(" ");
        if (parts != null) {
          for (String part : parts) {
            if (!part.trim().isEmpty()) {
              where = where + " AND (s.NOM like '%" + part.trim() + "%' or s.PRENOMS like '%"
                  + part.trim() + "%' or s.NJFILLE like '%" + part.trim()
                  + "%' or c.CODE_WIL like '%" + part.trim() + "%' or w.DESC_WIL like '%"
                  + part.trim() + "%' or p.LIBELLE like '%" + part.trim()
                  + "%' or g.LIBELLE like '%" + part.trim() + "%'\n" + "	or d.DESC_DIR like '%"
                  + part.trim() + "%'  or cn.[QUATRE_CHIFFRE] like '%" + part.trim()
                  + "%' or cn.[LIGNE_IP] like '%" + part.trim() + "%' or cn.[FAX] like '%"
                  + part.trim() + "%' or cn.[LIGNE_DIRECTE] like '%" + part.trim()
                  + "%' or cn.[MAIL] like '%" + part.trim() + "%'\n" + "	)";
            }

          }
        }
      }

      // if (where.length() > 5) {
      return (Integer) em
          .createNativeQuery("with search as (SELECT COUNT(*) AS CC  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL =
              // '31-12-2100'\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
              // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100'\n"
              + " outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
              + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + " left join CAR.DIRECTION d on c.CODE_DIR = d.CODE_DIR\n"
              + "	WHERE  cn.MATRICULE is not null and " + where + " "
              + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100' "
              + " and cn.[MAIL] is not null and cn.[MAIL] != '' and  (c.DATE_SORTIE is null or (c.code_act = 100)))\n"
              + " select * from search ")
          .getSingleResult();
      // }
      // return null;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public List<Object[]> searchAnnuaire(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, String keyWord, String nom,
      Integer matricule) {
    try {
      String where = "1 = 1";
      if (matricule != null) {
        where = where + " AND c.matricule = " + matricule;
      }
      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }
      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (nom != null && !nom.trim().isEmpty()) {
        where = where
            + " AND s.NOM+' '+s.PRENOMS+(CASE WHEN (s.NJFILLE is not null and s.NJFILLE != '') then ' NÉE '+s.NJFILLE else '' end)+' - '+cast(s.MATRICULE as varchar) like '"
            + nom.trim() + "%' ";
      }

      if (keyWord != null && !keyWord.trim().isEmpty()) {
        String[] parts = keyWord.trim().split(" ");
        if (parts != null) {
          for (String part : parts) {
            if (!part.trim().isEmpty()) {
              where = where + " AND (s.NOM like '%" + part.trim() + "%' or s.PRENOMS like '%"
                  + part.trim() + "%' or s.NJFILLE like '%" + part.trim()
                  + "%' or c.CODE_WIL like '%" + part.trim() + "%' or w.DESC_WIL like '%"
                  + part.trim() + "%' or p.LIBELLE like '%" + part.trim()
                  + "%' or g.LIBELLE like '%" + part.trim() + "%'\n"
                  + "		or cn.[QUATRE_CHIFFRE] like '%" + part.trim()
                  + "%' or cn.[LIGNE_IP] like '%" + part.trim() + "%' or cn.[FAX] like '%"
                  + part.trim() + "%' " + " or d.DESC_DIR like '%" + part.trim()
                  + "%' or cn.[LIGNE_DIRECTE] like '%" + part.trim() + "%' or cn.[MAIL] like '%"
                  + part.trim() + "%'\n" + "	)";
            }

          }
        }
      }

      // if (where.length() > 5) {
      return em.createNativeQuery(
          "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction "
              + ",g.LIBELLE as affectation," + "s.SEXE,cn.[QUATRE_CHIFFRE]\n"
              + "      ,cn.[MOBILE]\n" + "      ,cn.[LIGNE_IP]\n" + "      ,cn.[FAX]\n"
              + "      ,cn.[LIGNE_DIRECTE]\n" + "      ,cn.[MAIL]\n" + "      ,cn.[MAIL_2]\n"
              + "      ,cn.[ADRESSE_SITA]\n" + "      ,cn.[ADRESSE]\n" + "      ,cn.MOT_DE_PASSE"
              + "      ,cn.MAIL_RET" + "      ,cn.DATE_INSCRIP_RET" + "      ,cn.SHOW_PHOTO"
              + "      ,cn.SHOW_MOBILE" + "      ,cn.DATE_INSCRIP" + "      ,c.DATE_SORTIE"
              + "      ,c.GRP_CHAP\n"
              + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC,case when c.CODE_CORPS = 'E' then 1 when c.CODE_CORPS = 'M' then 2 when c.CODE_CORPS IN ('C','N') then  3 else 0 end desc,s.matricule asc) AS ROWID "
              // + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then
              // cn.CODE_RANG else 9999 end) ASC) AS ROWID\n"
              + "  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
              // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100'\n"
              + " outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
              + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + " left join CAR.DIRECTION d on c.CODE_DIR = d.CODE_DIR\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null and " + where + " "
              + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100' "
              + " and cn.[MAIL] is not null and cn.[MAIL] != '' and (c.DATE_SORTIE is null or (c.code_act = 100)))\n"
              + "select * from search " + " where ROWID between (" + searchIndex + "-1)*21+1 and "
              + searchIndex + "*21 "
              // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
              + "")
          .getResultList();
      // }
      // return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void editContact(Object[] Profile, boolean show_photo, boolean show_mobile) {
    try {
      em.createNativeQuery("UPDATE CAR.CONTACT SET QUATRE_CHIFFRE = '" + Profile[7]
          + "', MOBILE = '" + Profile[8] + "' , LIGNE_IP='" + Profile[9] + "' , FAX = '"
          + Profile[10] + "' , LIGNE_DIRECTE = '" + Profile[11] + "' , MAIL = '" + Profile[12]
          + "' , ADRESSE_SITA = '" + Profile[14] + "', SHOW_PHOTO = " + (show_photo ? "1" : "0")
          + ", SHOW_MOBILE = " + (show_mobile ? "1" : "0") + " where MATRICULE = " + Profile[0]
          + "").executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void validateRet(Integer matricule) {
    try {
      em.createNativeQuery("UPDATE CAR.CONTACT SET  STATUT = 1 where MATRICULE = " + matricule + "")
          .executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object[] searchProfile(Integer Matricule, String searchMod) {
    try {
      String where = "1 = 1";
      if (Matricule != null) {
        where = where + " AND c.matricule = " + Matricule;
      }

      if (where.length() > 5) {
        if (searchMod != null && !searchMod.isEmpty()) {
          if (searchMod.equals("1")) {
            where = where + " and (c.DATE_SORTIE is null or c.code_act = 100) ";
          } else if (searchMod.equals("2")) {
            where = where + " and DATE_SORTIE is not null ";
          }
        } else {
          where = where + " and (c.DATE_SORTIE is null or c.code_act = 100) ";
        }
        return (Object[]) em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction "
                + ",g.LIBELLE as affectation," + "s.SEXE,cn.[QUATRE_CHIFFRE]\n"
                + "      ,cn.[MOBILE]\n" + "      ,cn.[LIGNE_IP]\n" + "      ,cn.[FAX]\n"
                + "      ,cn.[LIGNE_DIRECTE]\n" + "      ,cn.[MAIL]\n" + "      ,cn.[MAIL_2]\n"
                + "      ,cn.[ADRESSE_SITA]\n" + "      ,cn.[ADRESSE]" + "      ,cn.SHOW_PHOTO"
                + "      ,cn.SHOW_MOBILE" + "      ,dr.DESC_DIR as direction\n"
                + ",ROW_NUMBER() OVER (ORDER BY (case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC) AS ROWID\n"
                + "  FROM CAR.CARRIERE c \n"
                // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
                // p.DATE_VAL\n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
                + "     outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g"
                // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
                // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' \n"
                + "	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "     left join CAR.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
                + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	left join CAR.DIRECTION dr on c.CODE_DIR = dr.CODE_DIR\n"
                + "	WHERE  cn.MATRICULE is not null and " + where + " "
                + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100') "
                + "     and c.DATE_FIN = '31-12-2100'  )\n" + "select * from search "
                // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
                + "")
            .getSingleResult();
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Object> getFormations(Integer matricule) {
    try {
      return em.createNativeQuery(
          "select f.DATE_FIN,t.LIBELLE as 'TYPE_FORMATION',d.LIBELLE as 'DIPLOME',e.LIBELLE as 'ETUDE',f.DUREE, f.statut, f.id from FRM.FORMATION f \n"
              + "left join FRM.TYPE_FORMATION t on f.TYPE_FRM = t.TYPE_FRM\n"
              + "left join FRM.ETUDE e on e.CODE_ETU = f.CODE_ETU\n"
              + "left join FRM.DIPLOME d on d.CODE_DIP = f.CODE_DIP\n" + "where f.MATRICULE = ?1 \n"
              + "order by f.DATE_FIN desc")
          .setParameter(1, matricule).getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public List<Object> getSERVICE_NAT(Integer matricule) {
    try {
      return em
          .createNativeQuery("SELECT s.DATE_DEB,s.DATE_FIN,n.LIBELLE,s.CODE_SCE_NAT \n"
              + "	FROM [CAR].[SIT_ADMINISTRATIVE] s\n"
              + "	left join car.SERVICE_NAT n on s.CODE_SCE_NAT = n.CODE_SCE_NAT\n"
              + "where s.MATRICULE = ?1\n" + "order by s.DATE_DEB desc")
          .setParameter(1, matricule).getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public List<Object> getSitsSYNDICALE(Integer matricule) {
    try {
      return em
          .createNativeQuery("SELECT s.DATE_DEB,s.DATE_FIN,n.LIBELLE, n.CODE_SYN\n"
              + "	FROM [CAR].SIT_SYNDICALE s\n"
              + "	left join car.SYNDICAT n on s.CODE_SYN = n.CODE_SYN\n"
              + "	where MATRICULE = ?1 \n" + "order by s.DATE_DEB desc")
          .setParameter(1, matricule).getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public Object[] getSituationFam(Integer matricule) {
    try {
      return (Object[]) em
          .createNativeQuery(
              " select top 1 c.LIBELLE,c.CODE_CIV,DATE_DEB from car.SIT_FAMILIALE s \n"
                  + "left join car.CIVILE c on s.CODE_CIV = c.CODE_CIV\n"
                  + "where s.MATRICULE =?1 and  DATE_FIN = '2100-12-31'")
          .setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      // e.printStackTrace();
      return null;
    }
  }

  /**
   * Récuperer le matricule de employe depuis son nom.
   *
   * @param nom Nom de l'employé.
   * 
   * @return Matricule de l'employé.
   */
  public Integer findMatriculeByNomMatricule(String nom) {
    try {
      return (Integer) em
          .createNativeQuery("SELECT Q.MATRICULE \n" + " FROM CAR.V_PERSONNEL Q \n"
              + " WHERE Q.NOM + ' - ' + CAST(Q.MATRICULE AS VARCHAR(200)) LIKE ?1")
          .setParameter(1, "%" + nom + "%").getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Récuperer le matricule de employe suivant son nom
   *
   * @param nomAuth
   * 
   * @return
   */
  // TO-DO : Refactor cette méthode.
  public Integer findMatriculeByNom(String nomAuth) {
    try {

      return (Integer) em.createNativeQuery(""
          + "select q.MATRICULE from car.SIGNALITIQUE q where q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+CAST(q.matricule as varchar(200)) like ?1")
          .setParameter(1, '%' + nomAuth.split("'")[0] + '%').getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String findNomByMatricule(Integer mat) {
    try {
      return (String) em.createNativeQuery(
          "select q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+CAST(q.matricule as varchar(200)) from CAR.SIGNALITIQUE q where q.MATRICULE = '"
              + mat + "'")
          .getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void editSignalitqueConjoint(Integer matricule, String nJFille, String nomConjoint) {
    try {
      em.createNativeQuery(
          "update car.signalitique set nom = ?1, NJFILLE = ?2 where matricule = ?3")
          .setParameter(1, nomConjoint).setParameter(2, nJFille).setParameter(3, matricule)
          .executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object[] getSignaletiqueEtat(Integer matricule) {
    try {
      return (Object[]) em.createNativeQuery("" + "SELECT \n" + "CASE\n"
          + "	WHEN S.SEXE='M' THEN 'Monsieur'\n" + "	ELSE 'Madame'\n" + "	END CIVILITE,\n"
          + "	S.NOM + CASE WHEN S.SEXE = 'F' AND S.NJFILLE IS NOT NULL AND S.NJFILLE != '' THEN ' Née ' + S.NJFILLE ELSE '' END + ' ' + S.PRENOMS\n"
          + "	, CONVERT(VARCHAR, vp.DATE_ENTREE, 105)\n" + "	, P.LIBELLE, C.DESC_CONTRAT\n"
          + "FROM CAR.SIGNALITIQUE S\n"
          + "OUTER APPLY (SELECT TOP 1 * FROM CAR.CARRIERE WHERE MATRICULE = S.MATRICULE ORDER BY DATE_FIN DESC, DATE_DEB DESC) CAR\n"
          + "OUTER APPLY (SELECT TOP 1 * FROM CAR.POSTE_TRAVAIL P WHERE CAR.CODE_PSTR = P.CODE_PSTR AND P.DATE_VAL = '31-12-2100' ORDER BY DATE_DEB DESC) P\n"
          + "LEFT JOIN CAR.V_PERSONNEL vp ON  vp.MATRICULE = S.MATRICULE \n"
          + "LEFT JOIN CAR.CONTRAT C ON C.TYPE_CONTRAT = VP.TYPE_CONTRAT \n"
          + "WHERE S.MATRICULE = ?1").setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  public Object[] findBanqueInfos(Integer matricule, boolean nature) {
    try {
      return (Object[]) em
          .createNativeQuery("SELECT TOP 1 \n" + "		C.CODE_BANQUE\n" + "		, LIBELLE\n"
              + "		, NUM_CPT\n" + "  FROM [CAR].[COMPTE_BANCAIRE] C\n"
              + "	LEFT JOIN CAR.BANQUE B ON B.CODE_BANQUE = C.CODE_BANQUE\n"
              + "  WHERE MATRICULE = ?1 AND IS_DEVISE = ?2\n" + "  ORDER BY DATE_DEB DESC")
          .setParameter(1, matricule).setParameter(2, nature).getSingleResult();
    } catch (javax.persistence.NoResultException e) {
      return new Object[] {0, "", 0};
    }
  }

  public Integer countActifs() {
    try {
      return (Integer) em.createNativeQuery(
          "SELECT count(distinct(c.MATRICULE)) FROM [CAR].[CARRIERE] c where c.DATE_FIN = '31-12-2100' and c.DATE_SORTIE is null")
          .getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Object[]> findAttentes2(String matricules, String ditections) {
    try {
      if (ditections != null) {
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction ,g.LIBELLE as affectation,s.SEXE,c.code_dir\n"
                + "FROM CAR.CARRIERE c \n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p      \n"
                + "	 outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	WHERE s.STATUT = 0  and g.CODE_UNIT != 99 and c.code_dir in (" + ditections
                + ") and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')      \n"
                + "	and c.DATE_FIN = '31-12-2100'  )\n"
                // + "select * from search where MATRICULE in " + matricules + " order by
                // MATRICULE")
                + "select * from search  order by MATRICULE")
            .getResultList();
      } else {
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction ,g.LIBELLE as affectation,s.SEXE,c.code_dir\n"
                + "FROM CAR.CARRIERE c \n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p      \n"
                + "	 outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	WHERE s.STATUT = 0  and g.CODE_UNIT != 99  and  c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')      \n"
                + "	and c.DATE_FIN = '31-12-2100'  )\n"
                // + "select * from search where MATRICULE in " + matricules + " order by
                // MATRICULE")
                + "select * from search order by MATRICULE")
            .getResultList();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  public List<Object[]> findAttentes(String matricules, String ditections) {
    try {
      if (ditections != null) {
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction ,g.LIBELLE as affectation,s.SEXE,c.code_dir\n"
                + "FROM CAR.CARRIERE c \n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p      \n"
                + "	 outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	WHERE  g.CODE_UNIT != 99 and (s.statut = 0 or s.statut = 1) and c.code_dir in ("
                + ditections
                + ") and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')      \n"
                + "	and c.DATE_FIN = '31-12-2100'  )\n"
                // + "select * from search where MATRICULE in " + matricules)
                + "select * from search order by MATRICULE")
            .getResultList();
      } else {
        return em.createNativeQuery(
            "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction ,g.LIBELLE as affectation,s.SEXE,c.code_dir\n"
                + "FROM CAR.CARRIERE c \n"
                + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p      \n"
                + "	 outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
                + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
                + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
                + "	WHERE g.CODE_UNIT != 99 and (s.statut = 0 or s.statut = 1) and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')      \n"
                + "	and c.DATE_FIN = '31-12-2100'  )\n"
                // + "select * from search where MATRICULE in " + matricules)
                + "select * from search order by MATRICULE")
            .getResultList();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  public List<Integer> findEnAttente() {
    try {
      return em.createNativeQuery("SELECT MATRICULE FROM [CAR].[SIGNALITIQUE] where [STATUT] = 0")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Integer> autocompleteFreeMatricule(String matricule) {
    try {
      return em.createNativeQuery("SELECT T1.MATRICULE+1 \n" + "FROM car.SIGNALITIQUE T1\n"
          + "WHERE NOT EXISTS(SELECT * FROM car.SIGNALITIQUE T2 WHERE T2.MATRICULE = T1.MATRICULE + 1)\n"
          + "AND MATRICULE > 36000 AND MATRICULE LIKE ?1\n" + "ORDER BY T1.MATRICULE")
          .setParameter(1, matricule + "%").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean checkMatriculeExist(Integer matricule) {
    return em.createNativeQuery("SELECT * FROM CAR.SIGNALITIQUE WHERE MATRICULE = ?1")
        .setParameter(1, matricule).getResultList().size() > 0;
  }

  public Object[] getSituationsFam(Integer matricule) {
    try {
      return (Object[]) em.createNativeQuery(
          " select top 1 c.LIBELLE,c.CODE_CIV,DATE_DEB from car.SIT_FAMILIALE s \n"
              + "left join car.CIVILE c on s.CODE_CIV = c.CODE_CIV\n" + "where s.MATRICULE = "
              + matricule + " and  DATE_FIN = '2100-12-31'")
          .getSingleResult();
    } catch (Exception e) {
      // e.printStackTrace();
      return null;
    }
  }

  public String getSituationFam1(Integer matricule) {
    try {
      return (String) em.createNativeQuery("select top 1 c.LIBELLE from CAR.SIT_FAMILIALE s \n"
          + "left join CAR.CIVILE c on s.CODE_CIV = c.CODE_CIV\n" + "where s.MATRICULE = ?1\n"
          + "order by s.DATE_FIN desc").setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      return null;
    }
  }

  public List<Object[]> findInscriptions() {
    return em.createNativeQuery(
        "SELECT i.* FROM [CAR].[INSCRIPTION] i left join CAR.CONTACT c on i.MATRICULE = c.MATRICULE\n"
            + "where c.MAIL is null")
        .getResultList();
  }

  public boolean isValidSoftUser(Integer matricule) {
    try {
      em.createNativeQuery("SELECT S.MATRICULE FROM [CAR].[SIGNALITIQUE] S\n"
          + "	LEFT JOIN [CAR].CARRIERE C ON S.MATRICULE = C.MATRICULE AND C.DATE_FIN = '2100-12-31'\n"
          + "	LEFT JOIN [CAR].CONTACT CO ON CO.MATRICULE = S.MATRICULE\n"
          + "WHERE S.[MATRICULE] = ?1\n" + "	AND C.DATE_SORTIE IS NULL\n"
          + "	AND (CO.MAIL IS NULL OR CO.MAIL = '')").setParameter(1, matricule)
          .getSingleResult();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void insertInscription(Integer matricule, String Nom, String Prenom, String Direction,
      String Fonction, Integer quarteChifre, String mobile, String LigneDirecte, String Fax,
      Integer LigneIP, String TELEX, String Email) {

    // em.createNativeQuery("INSERT INTO [CAR].[CONTACT]\n"
    // + " ([MATRICULE]\n"
    // + " ,[MOBILE]\n"
    // + " ,[LIGNE_DIRECTE]\n"
    // + " ,[MAIL_RET]\n"
    // + " ,[DATE_INSCRIP_RET]\n"
    // + " ,MOT_DE_PASSE) \n"
    // + " VALUES\n"
    // + " (" + matricule + "\n"
    // + " ,'" + mobile + "'\n"
    // + " ,'" + fix + "'\n"
    // + " ,'" + Email + "'\n"
    // + " ,GETDATE()"
    // + " ,'" + pwd + "')")
    // .executeUpdate();
    String pwd = RandomStringUtils.random(10, characters);

    em.createNativeQuery("DELETE from [CAR].[INSCRIPTION] where MATRICULE = ?1; \n"
        + " INSERT INTO [CAR].[INSCRIPTION]\n" + "           ([MATRICULE]\n" + "           ,[NOM]\n"
        + "           ,[PRENOM]\n" + "           ,[FONCTION]\n" + "           ,[DIRECTION]\n"
        + "           ,[MAIL]\n" + "           ,[QUATRE_CHIFFRE]\n" + "           ,[MOBILE]\n"
        + "           ,[LIGNE_IP]\n" + "           ,[LIGNE_DIRECTE]\n" + "           ,[FAX]\n"
        + "           ,[ADRESSE_SITA] \n" + "           ,[MOT_DE_PASSE] \n"
        + "           ,[STATUT])\n" + "     VALUES\n" + "           ( ?1 \n" + "           , ?2 \n"
        + "           , ?3 \n"
        + "           ,(SELECT top 1 [LIBELLE] FROM [GRH].[CAR].[POSTE_TRAVAIL] where DATE_VAL = '2100-12-31' and CODE_PSTR = ?4)  \n"
        + "           ,(SELECT top 1 [LIBELLE] FROM [GRH].[CAR].GRP_CHAP where DATE_FIN = '2100-12-31' and GRP_CHAP = ?5) "
        + "           , ?6 \n" + "           , ?7 \n" + "           , ?8 \n" + "           , ?9 \n"
        + "           , ?10 \n" + "           , ?11 \n" + "           , ?12 \n"
        + "           , ?13 \n" + "           , 0 ) \n").setParameter(1, matricule)
        .setParameter(2, Nom).setParameter(3, Prenom).setParameter(4, Fonction)
        .setParameter(5, Direction + "01").setParameter(6, Email).setParameter(7, quarteChifre)
        .setParameter(8, mobile).setParameter(9, LigneIP).setParameter(10, LigneDirecte)
        .setParameter(11, Fax).setParameter(12, TELEX).setParameter(13, pwd).executeUpdate();

    // else if (action != null && action.equals("update")) {
    // em.createNativeQuery("UPDATE [CAR].[CONTACT] SET\n"
    // + " MOBILE = '" + mobile + "'\n"
    // + " ,LIGNE_DIRECTE = '" + fix + "'\n"
    // + " ,MAIL = '" + Email + "'\n"
    // + " ,DATE_INSCRIP = GETDATE()"
    // + " ,MOT_DE_PASSE = '"+pwd+"' ")
    // .executeUpdate();
    // }
  }

  public String inscAction(Integer matricule) {
    try {
      Integer singleResult = (Integer) em.createNativeQuery(
          "SELECT c.MATRICULE  FROM CAR.CONTACT c where (c.mail is null or c.mail = '') and c.MATRICULE = '"
              + matricule + "' ")
          .getSingleResult();
      System.out.println("HERE " + singleResult);
      if (singleResult != null) {
        return "update";
      } else if (singleResult == null) {
        return "insert";
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "insert";
  }

  public Integer countNbrTotal(RefUser user, Integer s) {
    try {
      String where = "1 = 1 ";
      if (s != null && s == 0) {
        where = where + " and (s.statut = 0 or  s.statut = 1 ) ";
      }
      if (s != null && s == 1) {
        where = where + " and (s.statut = 1 )  ";
      }

      if (s == null) {
        where = where + " AND c.DATE_SORTIE is null ";
      }

      if (user != null) {
        DataAccessQueryBuilder dataQuery =
            new DataAccessQueryBuilder.Builder(user).withDirectionNativeConstraint("c.CODE_DIR", "")
                .withTechNativeConstraint("c.CODE_TECH", "")
                .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP, 1, 3)", "").build();
        where = where + dataQuery.getQuery();
      }
      return (Integer) em
          .createNativeQuery("with search as (SELECT c.MATRICULE  FROM CAR.CARRIERE c \n"
              + "  outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p      \n"
              + "	 outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g 	left join CAR.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "	left join CAR.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join CAR.CONTACT cn on s.MATRICULE = cn.MATRICULE\n" + "	WHERE " + where
              + " and g.CODE_UNIT != 99 	\n"
              + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')     and c.DATE_FIN = '31-12-2100'  )\n"
              + " select count(*) from search ")
          .getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public Object[] getSignaletiqueEtatnew(Integer matricule) {
    try {
      String dateEntre = "select p.DATE_ENTREE from CAR.V_PERSONNEL p where p.MATRICULE=?1";

      return (Object[]) em.createNativeQuery("" + "SELECT \n" + "CASE\n"
          + "	WHEN S.SEXE='M' THEN 'Monsieur'\n" + "	ELSE 'Madame'\n" + "	END CIVILITE,\n"
          + "	S.NOM + CASE WHEN S.SEXE = 'F' AND S.NJFILLE IS NOT NULL AND S.NJFILLE != '' THEN ' Née ' + S.NJFILLE ELSE '' END + ' ' + S.PRENOMS\n"
          + "	, CONVERT(VARCHAR,(" + dateEntre + "), 105)\n"
          + "	, CASE WHEN CAR.CODE_ACT='013' THEN p.LIBELLE+' PAR INTÉRIM' ELSE p.LIBELLE END \n"
          + ", CONVERT(VARCHAR,(S.DATE_NAIS), 105) \n" + "FROM car.SIGNALITIQUE S\n"
          + "OUTER APPLY (SELECT TOP 1 * FROM CAR.CARRIERE WHERE MATRICULE = S.MATRICULE ORDER BY DATE_FIN DESC, DATE_DEB DESC) CAR\n"
          + "OUTER APPLY (SELECT TOP 1 * FROM CAR.POSTE_TRAVAIL P WHERE CAR.CODE_PSTR = P.CODE_PSTR AND P.DATE_VAL = '31-12-2100' ORDER BY DATE_DEB DESC) P\n"
          + "WHERE S.MATRICULE = ?1").setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  public List<Integer> autocompleatMatricule(String mat, RefUser user, String role) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withDirectionNativeConstraint("C.CODE_DIR", "")
              .withTechNativeConstraint("C.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(C.GRP_CHAP, 1, 3)", "").build();

      return em.createNativeQuery("SELECT distinct TOP 50 q.MATRICULE\n"
          + "  FROM  car.SIGNALITIQUE Q\n"
          + "			 OUTER APPLY (SELECT TOP 1 * FROM CAR.CARRIERE C WHERE C.MATRICULE = Q.MATRICULE ORDER BY DATE_FIN DESC, DATE_DEB DESC) C\n"
          + "  where q.MATRICULE like ?1 " + "" + dataQuery.getQuery() + "  order by q.MATRICULE")
          .setParameter(1, mat + "%").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<String> autocompleatNom(String nom, RefUser user, String role) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withDirectionNativeConstraint("C.CODE_DIR", "")
              .withTechNativeConstraint("C.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(C.GRP_CHAP, 1, 3)", "").build();

      return em.createNativeQuery(
          "SELECT distinct TOP 50 q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar)\n"
              + "  FROM  car.SIGNALITIQUE Q\n"
              + "			 OUTER APPLY (SELECT TOP 1 * FROM CAR.CARRIERE C WHERE C.MATRICULE = Q.MATRICULE ORDER BY DATE_FIN DESC, DATE_DEB DESC) C\n"
              + "  where (q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar)) like ?1 "
              + " " + dataQuery.getQuery()
              + "  order by q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)+' - '+cast(c.MATRICULE as varchar) ")
          .setParameter(1, "%" + nom + "%").getResultList();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer validateEtudesFormation(Integer matricule) {
    return em.createNativeQuery("SET XACT_ABORT ON;\n" + "                \n" + "BEGIN TRY\n"
        + "    BEGIN TRANSACTION;\n" + "                \n" + "        BEGIN\n"
        + "            UPDATE [FRM].[FORMATION] SET [STATUT] = 1 WHERE [MATRICULE] = ?1; \n"
        + "        END\n" + "\n" + "		BEGIN\n"
        + "            UPDATE [FRM].NIVEAU SET [STATUT] = 1 WHERE [MATRICULE] = ?1; \n"
        + "        END\n" + "                \n" + "    COMMIT TRANSACTION\n" + "                \n"
        + "END TRY\n" + "BEGIN CATCH\n" + "    PRINT 'ERRMESSAGE ' + ERROR_MESSAGE();\n"
        + "    ROLLBACK TRANSACTION\n" + "END CATCH").setParameter(1, matricule).executeUpdate();
  }

  public Date findDateEntree(Integer matricule) {
    try {
      return (Date) em.createNativeQuery(
          "SELECT DATE_ENTREE FROM [CAR].[V_PERSONNEL] where MATRICULE = ?1 and DATE_ENTREE is not null")
          .setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      return null;
    }
  }

  public Integer searchAnnuaireCount(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, String keyWord, String nom, Integer matricule,
      Integer matricul2) {
    try {
      String where = "1 = 1";
      if (matricule != null) {
        where = where + " AND c.matricule = " + matricule;
      }
      if (matricul2 != null) {
        where = where + " AND c.matricule = " + matricul2;
      }
      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }
      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (nom != null && !nom.trim().isEmpty()) {
        where = where
            + " AND s.NOM+' '+s.PRENOMS+(CASE WHEN (s.NJFILLE is not null and s.NJFILLE != '') then ' NÉE '+s.NJFILLE else '' end)+' - '+cast(s.MATRICULE as varchar) like '"
            + nom.trim() + "%' ";
      }

      if (keyWord != null && !keyWord.trim().isEmpty()) {
        String[] parts = keyWord.trim().split(" ");
        if (parts != null) {
          for (String part : parts) {
            if (!part.trim().isEmpty()) {
              where = where + " AND (s.NOM like '%" + part.trim() + "%' or s.PRENOMS like '%"
                  + part.trim() + "%' or s.NJFILLE like '%" + part.trim()
                  + "%' or c.CODE_WIL like '%" + part.trim() + "%' or w.DESC_WIL like '%"
                  + part.trim() + "%' or p.LIBELLE like '%" + part.trim()
                  + "%' or g.LIBELLE like '%" + part.trim() + "%'\n" + "	or d.DESC_DIR like '%"
                  + part.trim() + "%'  or cn.[QUATRE_CHIFFRE] like '%" + part.trim()
                  + "%' or cn.[LIGNE_IP] like '%" + part.trim() + "%' or cn.[FAX] like '%"
                  + part.trim() + "%' or cn.[LIGNE_DIRECTE] like '%" + part.trim()
                  + "%' or cn.[MAIL] like '%" + part.trim() + "%'\n" + "	)";
            }

          }
        }
      }

      // if (where.length() > 5) {
      return (Integer) em
          .createNativeQuery("with search as (SELECT COUNT(*) AS CC  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL =
              // '31-12-2100'\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
              // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100'\n"
              + " outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
              + "	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join car.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + " left join car.DIRECTION d on c.CODE_DIR = d.CODE_DIR\n"
              + "	WHERE  cn.MATRICULE is not null and " + where + " "
              + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100' "
              + " and cn.[MAIL] is not null and cn.[MAIL] != '' and  (c.DATE_SORTIE is null or (c.code_act = 100)))\n"
              + " select * from search ")
          .getSingleResult();
      // }
      // return null;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public List<Object[]> searchAnnuaire(String codDir, String grp, boolean actif, boolean inactif,
      String tech, String corps, String fonction, String categ, String coll, String contrat,
      boolean mas, boolean fem, Integer searchIndex, String keyWord, String nom, Integer matricule,
      Integer matricule2) {
    try {
      String where = "1 = 1";
      if (matricule != null) {
        where = where + " AND c.matricule = " + matricule;
      }
      if (matricule2 != null) {
        where = where + " AND c.matricule = " + matricule2;
      }
      if (codDir != null && !codDir.isEmpty()) {
        where = where + " AND c.CODE_DIR = " + codDir;
      }
      if (grp != null && !grp.isEmpty()) {
        where = where + " AND g.GRP_CHAP = " + grp;
      }

      if (fonction != null && !fonction.isEmpty()) {
        where = where + " AND c.CODE_PSTR = '" + fonction + "' ";
      }

      if (nom != null && !nom.trim().isEmpty()) {
        where = where
            + " AND s.NOM+' '+s.PRENOMS+(CASE WHEN (s.NJFILLE is not null and s.NJFILLE != '') then ' NÉE '+s.NJFILLE else '' end)+' - '+cast(s.MATRICULE as varchar) like '"
            + nom.trim() + "%' ";
      }

      if (keyWord != null && !keyWord.trim().isEmpty()) {
        String[] parts = keyWord.trim().split(" ");
        if (parts != null) {
          for (String part : parts) {
            if (!part.trim().isEmpty()) {
              where = where + " AND (s.NOM like '%" + part.trim() + "%' or s.PRENOMS like '%"
                  + part.trim() + "%' or s.NJFILLE like '%" + part.trim()
                  + "%' or c.CODE_WIL like '%" + part.trim() + "%' or w.DESC_WIL like '%"
                  + part.trim() + "%' or p.LIBELLE like '%" + part.trim()
                  + "%' or g.LIBELLE like '%" + part.trim() + "%'\n"
                  + "		or cn.[QUATRE_CHIFFRE] like '%" + part.trim()
                  + "%' or cn.[LIGNE_IP] like '%" + part.trim() + "%' or cn.[FAX] like '%"
                  + part.trim() + "%' " + " or d.DESC_DIR like '%" + part.trim()
                  + "%' or cn.[LIGNE_DIRECTE] like '%" + part.trim() + "%' or cn.[MAIL] like '%"
                  + part.trim() + "%'\n" + "	)";
            }

          }
        }
      }

      // if (where.length() > 5) {
      return em.createNativeQuery(
          "with search as (SELECT s.MATRICULE,s.NOM,s.PRENOMS,s.NJFILLE, p.LIBELLE as fonction "
              + ",g.LIBELLE as affectation," + "s.SEXE,cn.[QUATRE_CHIFFRE]\n"
              + "      ,cn.[MOBILE]\n" + "      ,cn.[LIGNE_IP]\n" + "      ,cn.[FAX]\n"
              + "      ,cn.[LIGNE_DIRECTE]\n" + "      ,cn.[MAIL]\n" + "      ,cn.[MAIL_2]\n"
              + "      ,cn.[ADRESSE_SITA]\n" + "      ,cn.[ADRESSE]\n" + "      ,cn.MOT_DE_PASSE"
              + "      ,cn.MAIL_RET" + "      ,cn.DATE_INSCRIP_RET" + "      ,cn.SHOW_PHOTO"
              + "      ,cn.SHOW_MOBILE" + "      ,cn.DATE_INSCRIP" + "      ,c.DATE_SORTIE"
              + "      ,c.GRP_CHAP\n"
              + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then cn.CODE_RANG else 9999 end) ASC,case when c.CODE_CORPS = 'E' then 1 when c.CODE_CORPS = 'M' then 2 when c.CODE_CORPS IN ('C','N') then  3 else 0 end desc,s.matricule asc) AS ROWID "
              // + ",ROW_NUMBER() OVER (ORDER BY c.code_dir,(case when cn.CODE_RANG is not null then
              // cn.CODE_RANG else 9999 end) ASC) AS ROWID\n"
              + "  FROM CAR.CARRIERE c \n"
              // + " left join POSTE_TRAVAIL p on c.CODE_PSTR = p.CODE_PSTR and c.DATE_DEB <
              // p.DATE_VAL\n"
              + "     outer apply (select top 1 * from CAR.POSTE_TRAVAIL p where c.CODE_PSTR = p.CODE_PSTR and p.DATE_VAL = '31-12-2100') p "
              // + " left join CAR.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL =
              // g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100'\n"
              + " outer apply (select top 1 * from CAR.GRP_CHAP g where c.GRP_CHAP = g.GRP_CHAP and c.COMPTE_ANAL = g.COMPTE_ANAL and g.DATE_FIN = '31-12-2100' order by g.DATE_DEB desc) g "
              + "	left join car.ACTE a on c.CODE_ACT = a.CODE_ACT \n"
              + "     left join car.WILAYA w on c.CODE_WIL = w.CODE_WIL \n"
              + "	left join car.SIGNALITIQUE s on s.MATRICULE = c.MATRICULE\n"
              + " left join car.DIRECTION d on c.CODE_DIR = d.CODE_DIR\n"
              + "	left join car.CONTACT cn on s.MATRICULE = cn.MATRICULE\n"
              + "	WHERE  cn.MATRICULE is not null and " + where + " "
              + "	and c.DATE_DEB = (select MAX(DATE_DEB) from CAR.CARRIERE where MATRICULE = c.MATRICULE and DATE_FIN = '31-12-2100')   "
              + " and c.DATE_FIN = '31-12-2100' "
              + " and cn.[MAIL] is not null and cn.[MAIL] != '' and (c.DATE_SORTIE is null or (c.code_act = 100)))\n"
              + "select * from search " + " where ROWID between (" + searchIndex + "-1)*21+1 and "
              + searchIndex + "*21 "
              // + "where ROWID > "+searchIndex+" and ROWID <= "+searchIndex+" + 9"
              + "")
          .getResultList();
      // }
      // return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Object[]> autocompleatMatriculeAnnuaire(String nom) {
    try {

      return em.createNativeQuery(
          "SELECT distinct  q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end),c.MATRICULE\n"
              + "  FROM CAR.CARRIERE c \n"
              + "  left join car.SIGNALITIQUE q on c.MATRICULE = q.MATRICULE\n"
              + "  left join car.CONTACT CN on c.MATRICULE = CN.MATRICULE\n"
              + "  where q.matricule like ?1 " + " AND c.DATE_FIN = '2100-12-31' "
              + " AND (c.DATE_SORTIE is null or c.code_act = 100) AND CN.MATRICULE is not null"
              // + " group by c.MATRICULE,c.CODE_TECH,q.NOM,q.PRENOMS,q.NJFILLE\n"
              // + " --having max(c.DATE_DEB) != (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
              // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.CODE_ACT in ('092') \n"
              // + " having max(c.DATE_DEB) = (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
              // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.CODE_DIR = '11' and
              // s.MATRICULE = c.MATRICULE) "

              + "  order by  q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null and q.NJFILLE != '') then ' NÉE '+q.NJFILLE else '' end)")
          .setParameter(1, nom + "%").getResultList();

      // return em.createNativeQuery("SELECT q.NOM+' '+q.PRENOMS+(CASE WHEN (q.NJFILLE is not null
      // and q.NJFILLE != '') then 'NEE' +q.NJFILLE else ' ' end),c.MATRICULE\n"
      // + " FROM [GRH].CAR.CARRIERE c \n"
      // + " left join SIGNALITIQUE q on c.MATRICULE = q.MATRICULE\n"
      // + " left join CONTACT t on c.MATRICULE = t.MATRICULE\n"
      // + " where (q.NOM+' '+q.PRENOMS) like ?1 and t.MATRICULE is not null\n"
      // + " group by c.MATRICULE,q.NOM,q.PRENOMS,q.NJFILLE\n"
      // + " --having max(c.DATE_DEB) != (select CASE WHEN max(s.DATE_DEB) IS NOT NULL THEN
      // max(s.DATE_DEB) ELSE '' END from CAR.CARRIERE s where s.DATE_SORTIE is not null and
      // s.MATRICULE = c.MATRICULE) \n"
      // + " order by c.MATRICULE desc")
      // .setMaxResults(50)
      // .setParameter(1, nom + "%")
      // .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String findService(int matricule) {
    // try {
    int a = em
        .createNativeQuery("SELECT g.LIBELLE FROM CAR.CARRIERE c \n"
            + "  INNER JOIN  CAR.GRP_CHAP g ON c.GRP_CHAP=g.GRP_CHAP           \n"
            + "  and g.DATE_FIN= '2100-12-31' and c.DATE_SORTIE is null\n"
            + "  where c.MATRICULE = ?1 and c.DATE_FIN ='2100-12-31' ")
        .setParameter(1, matricule).getResultList().size();
    if (a >= 1) {
      return (String) em
          .createNativeQuery("SELECT g.LIBELLE FROM CAR.CARRIERE c \n"
              + "  INNER JOIN  CAR.GRP_CHAP g ON c.GRP_CHAP=g.GRP_CHAP           \n"
              + "  and g.DATE_FIN= '2100-12-31' and c.DATE_SORTIE is null\n"
              + "  where c.MATRICULE = ?1 and c.DATE_FIN ='2100-12-31' ")
          .setParameter(1, matricule).getResultList().get(0);
    } else {
      return null;
    }
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
  }

  public int modNSS(int matricule, String num_ss) {
    System.out.println("update CAR.SIGNALITIQUE\n" + "  set NUM_SS ='" + num_ss + "'\n"
        + "  where MATRICULE= " + matricule + " ");

    return em.createNativeQuery("update CAR.SIGNALITIQUE\n" + "  set NUM_SS ='" + num_ss + "'\n"
        + "  where MATRICULE= " + matricule + " ").executeUpdate();

  }

  public List<Signalitique> findLstSignalMat(int matricule) {
    try {
      System.out.println("findLstSignalMat " + matricule);
      return em.createQuery("SELECT a from Signalitique a where a.matricule = :matricule")
          .setParameter("matricule", matricule).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Signalitique> findLstSignalNom(String nom) {
    return em
        .createNativeQuery(
            "SELECT * \n" + " FROM CAR.SIGNALITIQUE a \n"
                + " WHERE NOM +' '+PRENOMS +'-'+CONVERT(VARCHAR,MATRICULE) = ?1",
            Signalitique.class)
        .setParameter(1, nom).getResultList();
  }

  public List<Signalitique> findListeSignalNss(String num_ss) {
    // try {
    return em.createQuery("SELECT a from Signalitique a where a.numSs = :num_ss")
        .setParameter("num_ss", num_ss).getResultList();
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
  }

  public int findByNomJFPrenomMatricule(String nomJF) {
    return (Integer) em
        .createNativeQuery("SELECT MATRICULE\n" + " FROM CAR.SIGNALITIQUE \n"
            + " WHERE NJFILLE +' '+PRENOMS +'-'+CONVERT(VARCHAR,MATRICULE) = ?1")
        .setParameter(1, nomJF).getSingleResult();
  }

  public List<String> num_ss(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.NUM_SS \n" + " from CAR.SIGNALITIQUE s\n"
        + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE\n"
        + " where c.CODE_DIR not in ('18','20' ) \n"
        + " and c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null and NUM_SS like '" + query + "%'")
        .getResultList();
  }

  public List<String> num_ssGlob(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.NUM_SS \n" + " from CAR.SIGNALITIQUE s\n"
        + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE\n"
        + " where c.CODE_DIR not in ('18','20' ) \n"
        + " and c.DATE_FIN='2100-12-31' and NUM_SS like '" + query + "%'").getResultList();
  }

  public String findFoncton(int matricule) {
    // try {
    int a = em.createNativeQuery("select p.LIBELLE  from CAR.CARRIERE c\n" + "inner join \n"
        + " CAR.POSTE_TRAVAIL p on p.CODE_PSTR = c.CODE_PSTR \n" + " and c.DATE_FIN = p.DATE_VAL \n"
        + " where c.DATE_FIN = '2100-12-31' and c.MATRICULE = ?1 ").setParameter(1, matricule)
        .getResultList().size();
    if (a >= 1) {
      return (String) em
          .createNativeQuery("select p.LIBELLE  from CAR.CARRIERE c\n" + "inner join \n"
              + " CAR.POSTE_TRAVAIL p on p.CODE_PSTR = c.CODE_PSTR \n"
              + " and c.DATE_FIN = p.DATE_VAL \n"
              + " where c.DATE_FIN = '2100-12-31' and c.MATRICULE = ?1 ")
          .setParameter(1, matricule).getResultList().get(0);
    } else {
      return null;
    }
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
  }

  public List<String> nomJFGlob(String query) {
    return em
        .createNativeQuery("select distinct TOP 50 s.NJFILLE +' '+s.PRENOMS +'-'+\n"
            + " CONVERT(varchar,s.matricule)\n" + " from CAR.SIGNALITIQUE s\n"
            + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE \n"
            + " where c.CODE_DIR not in ('18','20' ) \n"
            + " and c.DATE_FIN='2100-12-31' and NJFILLE +' '+PRENOMS like '" + query + "%'")
        .getResultList();
  }

  public List<String> nomJF(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.NJFILLE +' '+s.PRENOMS +'-'+\n"
        + " CONVERT(varchar,s.matricule)\n" + " from CAR.SIGNALITIQUE s\n"
        + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE \n"
        + " where c.CODE_DIR not in ('18','20' ) \n"
        + " and c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null and NJFILLE +' '+PRENOMS like '"
        + query + "%'").getResultList();
  }

  public List<String> nomGlob(String query) {
    return em
        .createNativeQuery("select distinct TOP 50 s.NOM +' '+s.PRENOMS +'-'+\n"
            + " CONVERT(varchar,s.matricule)\n" + " from CAR.SIGNALITIQUE s\n"
            + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE\n"
            + " where c.CODE_DIR not in ('18','20') \n"
            + " and c.DATE_FIN='2100-12-31' and NOM +' '+PRENOMS like '" + query + "%'")
        .getResultList();
  }

  public List<Signalitique> findLstSignalNomJF(String nJfille) {
    // try {
    // return em.createQuery("SELECT a from Signalitique a where a.njfille = :nJfille")
    // .setParameter("nJfille", nJfille)
    // .getResultList();
    return em.createNativeQuery(
        "SELECT * \n" + " FROM CAR.SIGNALITIQUE a \n"
            + " WHERE NJFILLE +' '+PRENOMS +'-'+CONVERT(VARCHAR,MATRICULE) = ?1",
        Signalitique.class).setParameter(1, nJfille).getResultList();
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
  }

  public List<String> nom(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.NOM +' '+s.PRENOMS +'-'+\n"
        + " CONVERT(varchar,s.matricule)\n" + " from CAR.SIGNALITIQUE s\n"
        + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE\n"
        + " where c.CODE_DIR not in ('18','20') \n"
        + " and c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null and NOM +' '+PRENOMS like '"
        + query + "%'").getResultList();
  }

  public List<String> preNom(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.PRENOMS \n" + " from CAR.SIGNALITIQUE s\n"
        + " INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE  \n"
        + " where c.CODE_DIR not in ('18','20' ) \n"
        + " and c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null and PRENOMS like '" + query
        + "%'").getResultList();
  }

  public List<String> libDir(String query) {
    return em.createNativeQuery("select distinct TOP 50 DESC_DIR \n"
        + " from CAR.DIRECTION where DESC_DIR like '" + query + "%'").getResultList();
  }

  public String findNum_ss(int matricule) {
    // try {
    return (String) em
        .createNativeQuery("SELECT a.NUM_SS from CAR.SIGNALITIQUE a WHERE matricule = ?1")
        .setParameter(1, matricule).getResultList().get(0);
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
  }

  public List<String> nomRet(String query) {
    return em.createNativeQuery("select distinct TOP 50 s.NOM +' '+s.PRENOMS +'-'+\n"
        + "CONVERT(varchar,s.matricule)\n" + "from CAR.SIGNALITIQUE s\n"
        + "INNER JOIN  CAR.CARRIERE c ON c.MATRICULE=s.MATRICULE\n"
        + "where c.CODE_DIR not in ('18','20') \n"
        + "and c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is not null \n"
        + "and c.CODE_ACT='092' and NOM +' '+PRENOMS like '" + query + "%'").getResultList();
  }

  public Object[] findUserInfos(Integer matricule) {
    if (matricule != null && matricule > 0) {
      return (Object[]) em.createNativeQuery("SELECT P.[MATRICULE]\n" + "	, P.NAME\n"
          + "	, P.PRENOM\n" + "	, P.NJFILLE\n" + "	, P.GRP_LIBELLE\n" + "	, P.CODE_DIR\n"
          + "	, (CASE WHEN W.CODE_WIL = 11 THEN 'L''' ELSE '' END) + W.[DESC_WIL] DESC_WIL\n"
          + "	, F.CODE_FIL\n" + "FROM [CAR].V_PERSONNEL P\n"
          + "	OUTER APPLY (SELECT TOP 1 CODE_FIL FROM T_BP.FILIALE WHERE (DIR = P.CODE_DIR OR DIR IS NULL) AND (DIR NOT IN (SELECT DIR FROM T_BP.FILIALE WHERE DIR != P.CODE_DIR AND DIR IS NOT NULL) OR DIR IS NULL) ORDER BY DIR DESC) F\n"
          + "	LEFT JOIN CAR.WILAYA W ON W.CODE_WIL = P.CODE_WIL\n" + "WHERE P.MATRICULE = ?1")
          .setParameter(1, matricule).getSingleResult();
    } else {
      Object[] userSignalitique = {"", ""};
      return (userSignalitique);
    }
  }

  public String libFcn(int matricule, String codeTech) {
    try {
      return (String) em.createNativeQuery("SELECT PF.LIBELLE FROM [PAIE].[RUB_SPECIFIQUE_T] PR\n"
          + "  INNER JOIN [PAIE].[REF_RUB_SPECIFIQUE_PN] PF ON PF.CODE_RUB_SP = 'CODE_QUALIF_PN' AND PF.CODE_VAL = PR.CODE_QUALIF_PN \n"
          + "  AND PF.CODE_TECH = ?1 AND CODE_VAL != '1' \n"
          + "  AND PR.MATRICULE = ?2 AND PR.DATE_TRT = 210012").setParameter(1, codeTech)
          .setParameter(2, matricule).getSingleResult();
    } catch (Exception e) {
      return null;
    }
  }

  public List<Object[]> libFcnList(int matricule) {
    try {
      return em.createNativeQuery(
          "SELECT Q.MATRICULE, C.CODE_CATG, CODE_QUALIF_PN, LIBELLE_SEC, ISNULL(Q.DATE_DEB, SS.DATE_TRT) DATE_DEB, Q.DATE_FIN\n"
              + "  FROM (\n"
              + "    SELECT DISTINCT PR.MATRICULE, /*PR.DATE_TRT, */PR.CODE_QUALIF_PN, REF.LIBELLE_SEC, SS.DATE_TRT DATE_DEB, ISNULL(S.DATE_TRT, SS.DATE_TRT) DATE_FIN--, S.CODE_QUALIF_PN\n"
              + "      FROM PAIE.RUB_SPECIFIQUE_T PR\n"
              + "      INNER JOIN PAIE.REF_RUB_SPECIFIQUE_PN REF ON REF.CODE_VAL = PR.CODE_QUALIF_PN AND REF.CODE_TECH = PR.CODE_TECH AND CODE_RUB_SP = 'CODE_QUALIF_PN'\n"
              + "      OUTER APPLY (SELECT TOP 1 CONVERT(VARCHAR(6), DATEADD(M, -1, CONVERT(DATE, CONVERT(VARCHAR, DATE_TRT) + '01', 112)), 112) DATE_TRT FROM PAIE.RUB_SPECIFIQUE_T S WHERE PR.MATRICULE = S.MATRICULE AND PR.CODE_QUALIF_PN != S.CODE_QUALIF_PN AND S.DATE_TRT >= PR.DATE_TRT AND S.DATE_TRT != 210012 ORDER BY DATE_TRT ASC) S\n"
              + "      OUTER APPLY (SELECT TOP 1 CONVERT(VARCHAR(6), DATEADD(M, 1, CONVERT(DATE, CONVERT(VARCHAR, DATE_TRT) + '01', 112)), 112) DATE_TRT FROM PAIE.RUB_SPECIFIQUE_T S WHERE PR.MATRICULE = S.MATRICULE AND PR.CODE_QUALIF_PN != S.CODE_QUALIF_PN AND S.DATE_TRT <= PR.DATE_TRT ORDER BY DATE_TRT DESC) SS\n"
              + "      WHERE PR.MATRICULE = ? ) Q\n"
              + "      OUTER APPLY (SELECT TOP 1 DATE_TRT FROM PAIE.RUB_SPECIFIQUE_T S WHERE Q.MATRICULE = S.MATRICULE ORDER BY DATE_TRT ASC) SS\n"
              + "      OUTER APPLY (SELECT TOP 1 CODE_CATG FROM CAR.CARRIERE C WHERE C.MATRICULE = Q.MATRICULE AND ISNULL(Q.DATE_DEB, SS.DATE_TRT) BETWEEN  CONVERT(VARCHAR(6), C.DATE_DEB, 112) AND  CONVERT(VARCHAR(6), C.DATE_FIN, 112) ORDER BY C.DATE_DEB DESC) C\n"
              + "      ORDER BY Q.DATE_DEB DESC")
          .setParameter(1, matricule).getResultList();
    } catch (Exception e) {
      return null;
    }
  }

  public String codeTech(int matricule) {
    try {
      return (String) em
          .createNativeQuery(
              "SELECT CODE_TECH FROM CAR.CARRIERE WHERE DATE_FIN = '2100-12-31' AND MATRICULE = ?1")
          .setParameter(1, matricule).getSingleResult();
    } catch (Exception e) {
      return null;
    }
  }
}
