/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.commun.facade;

import dz.airalgerie.commun.model.utils.DataAccessQueryBuilder;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefUser;
import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.OutputStream;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import dz.airalgerie.grh.model.dto.rem.DTOReliquats;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import dz.airalgerie.grh.model.entities.commun.Personnel_;
import dz.airalgerie.grh.model.entities.rem.Reliquats;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Administrateur
 */
@Stateless
public class PersonnelFacade extends AbstractFacade<Personnel> {

  @PersistenceContext(unitName = ErpConstante.UnitName.GRH_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public PersonnelFacade() {
    super(Personnel.class);
  }

  private XSSFWorkbook workbook;
  private XSSFSheet sheet;



  /**
   * Permet de rechercher les donnees basiques d'un employe.
   *
   * @param matricule Matricule de l'employe.
   * @return Objet PersonnelDTO.
   */
  public PersonnelDTO findByMatricule(Integer matricule) {
    return (PersonnelDTO) em.createQuery(
        "SELECT new dz.airalgerie.grh.model.dto.commun.PersonnelDTO(p.matricule, p.nom, p.name, p.njfille, p.prenom, p.codeTech, p.sexe, p.codeFiliale, CASE WHEN p.isInterim = 0 THEN p.grpChap ELSE p.grpChapInterim END, p.dirLibelle, p.mail) FROM Personnel p WHERE p.matricule = :matricule",
        PersonnelDTO.class).setParameter("matricule", matricule).getSingleResult();
  }

  public List<Object[]> getEffectif_actualise(PersonnelDTO loggedUser, RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();
      String schema = "";
      if (loggedUser.getCodeFiliale().equals("A")) {
        schema = "PAIE";
      } else if (loggedUser.getCodeFiliale().equals("C")) {
        schema = "CAT_PAIE";
      } else if (loggedUser.getCodeFiliale().equals("G")) {
        schema = "CARGO_PAIE";
      }

      return em.createNativeQuery(
          "Select p.matricule, p.NAME,p.NJFILLE ,p.PRENOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, c.CODE_UNIT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.REF_PSTR  ,case when(c.CODE_ACT='013') then pt.LIBELLE+' PAR INTERIM'else pt.LIBELLE end, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE   , ant.TAUX_MAJ,ant.MONT_MAJ,ant.DATE_DEB ,e.TAUX_IEP,e.MONT_IEP,r.TAUX_NUISANCE,p.NUM_SS,p.NUM_MGT,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH, pt.CODE_SFL, c.CODE_COLLECTIF ,case when (p.ADRESSE is null or p.ADRESSE='') then s.ADRESSE_ALG else p.ADRESSE end,wl.DESC_WIL\n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "left join CAR.ANCIENNETE ant on ant.MATRICULE=p.MATRICULE  and ant.DATE_FIN='2100-12-31'\n"
              + "left join CAR.IEP e on e.MATRICULE=p.MATRICULE   and e.DATE_FIN='2100-12-31'\n"
              + "left join  " + schema
              + ".RUB_SPECIFIQUE_T r on r.MATRICULE=p.MATRICULE and r.DATE_TRT='210012' \n"
              + "left join car.SIGNALITIQUE s on s.MATRICULE=p.MATRICULE\n"
              + "left join car.WILAYA wl on wl.CODE_WIL=c.CODE_WIL\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100'   \n" + ""
              + dataQuery.getQuery() + "and p.matricule<99999 \n"
              + "order by c.CODE_DIR asc ,c.GRP_CHAP asc ,c.SALAIRE_BASE desc,c.MATRICULE asc\n"
              + "")
          .getResultList();

    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public List<Object[]> getAbsenceTemp(RefUser user) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();

      return em.createNativeQuery(
          "Select distinct( p.matricule), p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE , c.DATE_FIN_CONTRAT ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE/*, p.CODE_FCT*/,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF\n"
              + "From CAR.V_PERSONNEL p\n"
              + "--inner join car.CARRIERE c on c.MATRICULE = p.MATRICULE and c.DATE_FIN = '31-12-2100'\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP  and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "--left join car.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and g.COMPTE_ANAL = c.COMPTE_ANAL and  g.date_fin=(select top 1 g1.DATE_FIN from CAR.GRP_CHAP g1 where g.GRP_CHAP=g1.GRP_CHAP order by g1.DATE_FIN desc) --and g.date_fin = '31-12-2100'\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on /*substring(pt.CODE_PSTR, 1, case when len(p.CODE_FCT)=11 then 8 else 7 end )*/ c.CODE_PSTR = pt.CODE_PSTR--convert(varchar, p.CODE_FCT)\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100'  --and g.date_fin=(select top 1 g1.DATE_FIN from CAR.GRP_CHAP g1 where g.GRP_CHAP=g1.GRP_CHAP order by g1.DATE_FIN desc)\n"
              + "and c.CODE_ACT in (015,080,081,082,083,084,085,086,087,088,089,090)\n"
              + "and p.matricule<99999\n" + "" + dataQuery.getQuery()
              + "--and p.MATRICULE in (8417)\n"
              + "--and p.MATRICULE not in (17077, 17304, 19329, 19867, 21279, 22646, 25133, 36645)\n"
              + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_absencetemp(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> absencetemp = getAbsenceTemp(user);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Absence Temporaire Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : absencetemp) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Absence Temporaires Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getInterimaire(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' and c.CODE_ACT='013'\n"
              + "" + dataQuery.getQuery() + "and p.matricule<99999 \n" + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_interimaires(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> interimes = getInterimaire(user);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Interimaires Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : interimes) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Interimaires Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getRenPerEssaie(RefUser user) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();

      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' and c.CODE_ACT='030'\n"
              + "" + dataQuery.getQuery() + "and p.matricule<99999 \n" + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_renouvperessaie(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> renperessai = getRenPerEssaie(user);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-RENOUVPERIODESSAI Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : renperessai) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-RENOUV PERIODE ESSAI Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getFinContrat(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' \n" + ""
              + dataQuery.getQuery()
              + "and c.CODE_ACT not in (013,015,080,081,082,083,084,085,086,087,088,089,090)  and c.TYPE_CONTRAT !='I'\n"
              + "and c.DATE_FIN_CONTRAT between GETDATE() \n"
              + "and DATEADD(month,2,DATEADD(M, DATEDIFF(M, '1990-01-01T00:00:00.000', CURRENT_TIMESTAMP), '1990-01-31T00:00:00.000'))\n"
              + "and p.matricule<99999 \n" + "order by c.DATE_FIN_CONTRAT asc,c.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_fincontrat(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> fincontrat = getFinContrat(user);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-FINCONTRAT Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : fincontrat) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Fin de Contrat Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getFinContratDepasse(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' \n" + ""
              + dataQuery.getQuery()
              + "and c.CODE_ACT not in (013,015,080,081,082,083,084,085,086,087,088,089,090) and c.TYPE_CONTRAT !='I'\n"
              + "and c.DATE_FIN_CONTRAT <GETDATE()\n" + "and p.matricule<99999 \n"
              + "order by c.DATE_FIN_CONTRAT asc,c.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_fincontrat_depasse(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> fincontratd = getFinContratDepasse(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-FINCONTRAT-DEPASSE Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : fincontratd) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Fin de Contrat Depasse Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getMutation(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='024' and  YEAR(c.DATE_DEB)=?1\n" + " and p.DATE_SORTIE is  null \n"
          + "" + dataQuery.getQuery() + "order by DATE_DEB desc  ").setParameter(1, year)
          .getResultList();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_mutation(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> mutation = getMutation(user, year);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Mutation Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : mutation) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Mutation Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getPromotion(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='020' and  YEAR(c.DATE_DEB)=?1\n" + " and p.DATE_SORTIE is  null \n"
          + "" + dataQuery.getQuery() + "order by DATE_DEB desc  ").setParameter(1, year)
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_Promotion(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getPromotion(user, year);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Promotion Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Promotion Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getNomination(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='021' and  YEAR(c.DATE_DEB)=?1\n" + " and p.DATE_SORTIE is  null \n"
          + "" + dataQuery.getQuery() + "order by DATE_DEB desc  ").setParameter(1, year)
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_Nomination(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getNomination(user, year);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Nomination Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Nomination Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getReclassement(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='029' and  YEAR(c.DATE_DEB)=?1\n" + " and p.DATE_SORTIE is  null \n"
          + "" + dataQuery.getQuery() + "order by DATE_DEB desc  ").setParameter(1, year)
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_Reclassement(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getReclassement(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Reclassement Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Reclassement Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getCodifGrpChap() {
    try {

      return em.createNativeQuery(
          "select g.GRP_CHAP , g.COMPTE_ANAL ,g.LIBELLE , g.DATE_DEB , g.DATE_FIN,g.DATE_DEC,g.REF_DEC,g.DATE_SAISIE,\n"
              + "g.CODE_UNIT ,g.CODE_WIL\n"
              + " from CAR.GRP_CHAP g where g.DATE_FIN='2100-12-31' \n"
              + "and substring(g.GRP_CHAP,1,2) not in ('18', '20')\n" + "order by g.GRP_CHAP asc"
              + "")
          .getResultList();

    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_CodifGrpChap() throws IOException, InvalidFormatException {

    String[] columns = {"GRP Chap", "Compte Analitique", "Libelle", "Date Debut", "Date Fin",
        "Date Decision", "Ref Decision", "Date Saisie", "Code Unit", "Code Wilaya"};
    List<Object[]> codifgrp = getCodifGrpChap();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Codif-GrpChapComptAnal Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : codifgrp) {
      Row row = sheet.createRow(rowNum++);

      // grp chap
      row.createCell(0).setCellValue(String.valueOf(t[0]));
      // compte anal
      row.createCell(1).setCellValue(Integer.valueOf((String) t[1]));

      // Libelle
      row.createCell(2).setCellValue((String) t[2]);

      // Date debut
      row.createCell(3).setCellValue(t[3].toString());

      // Date fin
      row.createCell(4).setCellValue(t[4].toString());

      // Date decision
      row.createCell(5).setCellValue(String.valueOf(t[5]));

      // Ref decision
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Date saisie
      row.createCell(7).setCellValue(String.valueOf(t[7]));

      // Code Unite
      row.createCell(8).setCellValue(t[8].toString());

      // Code Unite
      row.createCell(9).setCellValue(t[9].toString());
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Codification-GrpChapComptAnal Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getSanction(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(p.GRP_CHAP,1,3)", "").build();

      return em.createNativeQuery("select \n"
          + "p.MATRICULE , p.NAME , p.NJFILLE , p.PRENOM ,cr.CODE_DIR,cr.GRP_CHAP ,act.LIBELLE,dis.DATE_FAUTE ,dis.DATE_SN_MES_CONS ,dis.LIBELLE_FAUTE  \n"
          + "from CAR.DISCIPLINE dis \n"
          + "left join CAR.V_PERSONNEL p on p.MATRICULE=dis.MATRICULE \n"
          + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
          + "outer apply (select top 1 * from car.CARRIERE cr where cr.MATRICULE = p.MATRICULE and dis.DATE_FAUTE between cr.DATE_DEB and cr.DATE_FIN order by DATE_FIN desc) cr\n"
          + "outer apply (select top 1 * from car.GRP_CHAP gg where p.GRP_CHAP = gg.GRP_CHAP and p.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join CAR.ACTE act on act.CODE_ACT=dis.SN_MES_CONS\n"
          + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' and YEAR(dis.DATE_FAUTE)=?1 \n"
          + "" + dataQuery.getQuery() + "and p.matricule <99999\n" + "order by p.MATRICULE asc\n"
          + "").setParameter(1, year).getResultList();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_Sanction(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom", "NJFille", "Prenom", "Code_Direction", "GrpChap",
        "Acte Disciplinaire", "Date Faute", "Date Sanction", "Libelle Faute"};
    List<Object[]> sanctiondis = getSanction(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Etat-Sanctions-Disciplinaires Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : sanctiondis) {
      Row row = sheet.createRow(rowNum++);

      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom
      row.createCell(1).setCellValue((String) t[1]);
      // NJfILLE
      row.createCell(2).setCellValue(String.valueOf(t[2]));
      // Prenom
      row.createCell(3).setCellValue((String) t[3]);

      // Code Direction
      row.createCell(4).setCellValue(String.valueOf(t[4]));

      // GrpChap
      row.createCell(5).setCellValue(String.valueOf(t[5]));

      // Sanction
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Date faute
      row.createCell(7).setCellValue(String.valueOf(t[7]));

      // Date Sanction
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Libelle Faute
      row.createCell(9).setCellValue(String.valueOf(t[9]));

    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Etat-Sanctions-Disciplinaires Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getPersonnelsRadie(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule, p.NAME,p.NJFILLE ,p.PRENOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE ,c.DATE_SORTIE ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH, c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_FIN = '31-12-2100' and YEAR(c.DATE_SORTIE)=?1\n" + ""
              + dataQuery.getQuery() + "and p.matricule<99999 \n" + "order by p.MATRICULE asc")
          .setParameter(1, year).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_personnelsradies(RefUser user, int year)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom", "NJFille", "Prenoms", "Code Civil", "Sexe",
        "Type_Contrat", "Dernier Acte", "Date_Debut_Dernier_Acte", "Code Tech", "Code Corps",
        "GRP_CHAP", "Compte Analitique", "Direction", "Structure", "Fonction", "Categorie",
        "Indice", "Section", "Salaire de Base", "Date Sortie", "Date Entree Ah", "Date Naissance",
        "Technicite", "Code Collectif"};
    List<Object[]> personnelsrad = getPersonnelsRadie(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Personnels Radies Ah(A-1) ");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : personnelsrad) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom
      row.createCell(1).setCellValue((String) t[1]);
      // NJFille
      row.createCell(2).setCellValue(String.valueOf(t[2]));
      // Prenoms
      row.createCell(3).setCellValue((String) t[3]);

      // Code civil
      row.createCell(4).setCellValue((String) t[4]);
      // sexe
      row.createCell(5).setCellValue((String) t[5]);
      // type contract
      row.createCell(6).setCellValue((String) t[6]);

      // Dernier acte
      row.createCell(7).setCellValue((String) t[7]);
      // Date debut DerAct
      row.createCell(8).setCellValue(t[8].toString());

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date sortie
      row.createCell(20).setCellValue(String.valueOf(t[20]));

      // date entree
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // date naissance
      row.createCell(22).setCellValue(String.valueOf(t[22]));
      // technicite
      row.createCell(23).setCellValue((String) t[23]);

      // collectif
      row.createCell(24).setCellValue((String) t[24]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Personnels Radies Ah (A-1)  de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getNomenclatureposte(PersonnelDTO loggedUser) {
    try {
      String Query = "";
      if (loggedUser.getCodeFiliale().equals("A")) {
        Query = "and substring(c.GRP_CHAP,1,2) not in ('18', '20') ";
      } else if (loggedUser.getCodeFiliale().equals("C")) {
        Query = "and substring(c.GRP_CHAP,1,2)='20' ";
      } else if (loggedUser.getCodeFiliale().equals("G")) {
        Query = "and substring(c.GRP_CHAP,1,2)='18' ";
      }

      return em.createNativeQuery(
          "select pst.REF_PSTR,pst.LIBELLE ,pst.DATE_VAL,case when(pst.DATE_VAL='2100-12-31') then'Poste Valide' else 'Poste Cloture' end   ,pstd.DATE_DEB ,pstd.DATE_FIN  ,\n"
              + " pstd.CODE_CORPS  , pstd.CODE_CATG ,pstd.CODE_SEC  ,pstd.INDI_SALAIRE , pst.CODE_SFL, pst.NBR_EXPR ,COUNT (c.MATRICULE)\n"
              + " from  CAR.POSTE_TRAVAIL pst\n"
              + "left join CAR.POSTE_TRV_DET pstd on pst.CODE_PSTR= pstd.CODE_PSTR and  pstd.DATE_FIN ='2100-12-31' \n"
              + "left join car.V_PERSONNEL c on pst.CODE_PSTR = c.CODE_PSTR and c.DATE_SORTIE is null  \n"
              + "" + Query + "where  pst.CODE_FIL=?1\n" + "group by \n"
              + "pst.REF_PSTR,pst.LIBELLE ,pst.DATE_VAL ,pstd.DATE_DEB ,pstd.DATE_FIN  ,\n"
              + " pstd.CODE_CORPS  , pstd.CODE_CATG ,pstd.CODE_SEC  ,pstd.INDI_SALAIRE , pst.CODE_SFL, pst.NBR_EXPR \n"
              + " order by pst.DATE_VAL desc,pst.REF_PSTR asc  ")
          .setParameter(1, loggedUser.getCodeFiliale()).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Permet de generer l'etat de la nomenclature des poste, suivant le code filiale de l'utilisateur
   * connecte .
   *
   * @param loggedUser
   */
  public void etatNomenclaturePoste(PersonnelDTO loggedUser)
      throws IOException, InvalidFormatException {
    String[] columns =
        {"Code Poste", "Libelle", "Date Validite", "Status", "Date Debut", "Date Fin", "Code Corps",
            "Categorie", "Section", "Indice", "Code SFL", "Nbr Exp", "Personnel/Poste"};
    List<Object[]> listePostes = getNomenclatureposte(loggedUser);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Nomenclature des Poste Ah");
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : listePostes) {
      Row row = sheet.createRow(rowNum++);

      row.createCell(0).setCellValue(String.valueOf(t[0]));

      row.createCell(1).setCellValue(String.valueOf(t[1]));

      row.createCell(2).setCellValue(String.valueOf(t[2]));

      row.createCell(3).setCellValue(String.valueOf(t[3]));

      row.createCell(4).setCellValue(String.valueOf(t[4]));

      row.createCell(5).setCellValue(String.valueOf(t[5]));

      row.createCell(6).setCellValue(String.valueOf(t[6]));

      row.createCell(7).setCellValue(String.valueOf(t[7]));

      row.createCell(8).setCellValue(String.valueOf(t[8]));

      row.createCell(9).setCellValue((String.valueOf(t[9])));

      row.createCell(10).setCellValue(String.valueOf(t[10]));

      row.createCell(11).setCellValue((String.valueOf(t[11])));

      row.createCell(12).setCellValue((String.valueOf(t[12])));

    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Nomenclature des Postes Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getNomEtranger(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='017' and  YEAR(c.DATE_DEB)=?1\n"
          + "and p.DATE_SORTIE is  null and c.MATRICULE<99999  \n" + "" + dataQuery.getQuery()
          + "order by c.DATE_DEB desc ").setParameter(1, year).getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_NominationEtranger(RefUser user, int year)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getNomEtranger(user, year);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-NominationEtranger Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-NominationEtranger Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getRappelAlgerie(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='035' and  YEAR(c.DATE_DEB)=?1\n"
          + " and p.DATE_SORTIE is  null and c.MATRICULE<99999  \n" + "" + dataQuery.getQuery()
          + "order by c.DATE_DEB desc ").setParameter(1, year).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_RappelAlgerie(RefUser user, int year)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getRappelAlgerie(user, year);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-RappelEnAlgerie Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-RappelEnAlgerie Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getAbsenceTempDepasse(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select distinct( p.matricule), p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE , c.DATE_FIN_CONTRAT ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE/*, p.CODE_FCT*/,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF\n"
              + "From CAR.V_PERSONNEL p\n"
              + "--inner join car.CARRIERE c on c.MATRICULE = p.MATRICULE and c.DATE_FIN = '31-12-2100'\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP  and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "--left join car.GRP_CHAP g on c.GRP_CHAP = g.GRP_CHAP and g.COMPTE_ANAL = c.COMPTE_ANAL and  g.date_fin=(select top 1 g1.DATE_FIN from CAR.GRP_CHAP g1 where g.GRP_CHAP=g1.GRP_CHAP order by g1.DATE_FIN desc) --and g.date_fin = '31-12-2100'\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on /*substring(pt.CODE_PSTR, 1, case when len(p.CODE_FCT)=11 then 8 else 7 end )*/ c.CODE_PSTR = pt.CODE_PSTR--convert(varchar, p.CODE_FCT)\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' --and g.date_fin=(select top 1 g1.DATE_FIN from CAR.GRP_CHAP g1 where g.GRP_CHAP=g1.GRP_CHAP order by g1.DATE_FIN desc)\n"
              + "" + dataQuery.getQuery()
              + "and c.CODE_ACT in (015,080,081,082,083,084,085,086,087,088,089,090)\n"
              + "and p.matricule<99999 and  c.DATE_FIN_CONTRAT < GETDATE() \n"
              + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_absencetempdepasse(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> absencetemp = getAbsenceTempDepasse(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Reprise Depasse Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : absencetemp) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Reprise Depasse Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getpersonnelgrpchapferme(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,gg.DATE_FIN,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR\n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' \n" + ""
              + dataQuery.getQuery() + "and p.matricule<99999 and gg.DATE_FIN!='31-12-2100'\n"
              + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_personnelGrpChapFerme(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Date_Fin_Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> personnelGrp = getpersonnelgrpchapferme(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PersonnelGrpChapFermer Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : personnelGrp) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));

      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);

      // Date fin GrpChap
      row.createCell(15).setCellValue(String.valueOf(t[15]));
      // Fonction
      row.createCell(16).setCellValue((String) t[16]);

      // categorie
      row.createCell(17).setCellValue((String) t[17]);
      // indice
      row.createCell(18).setCellValue(((int) t[18]));

      // section
      row.createCell(19).setCellValue((short) t[19]);

      // salaire base
      row.createCell(20).setCellValue(Float.parseFloat((String) t[20].toString()));

      // date entree
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // date naissance
      row.createCell(22).setCellValue(String.valueOf(t[22]));
      // technicite
      row.createCell(23).setCellValue((String) t[23]);

      // collectif
      row.createCell(24).setCellValue((String) t[24]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PersonnelGrpChapFermer Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getpersonnelretraitable(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM,p.DATE_NAISS,DATEDIFF(year, p.DATE_NAISS, GETDATE()),P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR\n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' \n" + ""
              + dataQuery.getQuery()
              + "and p.matricule<99999 and  DATEDIFF(year, p.DATE_NAISS, GETDATE())>=60  and c.CODE_TECH!='L'  and pt.REF_PSTR not in ('12020282','12010254')   \n"
              + "order by p.DATE_NAISS asc,p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_personnelretraitable(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Date de Naissance", "Age", "Code Civil",
        "Sexe", "Type_Contrat", "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree",
        "Date Fin Contrat/SortTemp", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Technicite", "Code Collectif"};
    List<Object[]> personnelretraitable = getpersonnelretraitable(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PersonnelRetraitable Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : personnelretraitable) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);

      // date naissance
      row.createCell(2).setCellValue(String.valueOf(t[2]));

      // Age
      row.createCell(3).setCellValue(String.valueOf(t[3]));

      // Code civil
      row.createCell(4).setCellValue((String) t[4]);
      // sexe
      row.createCell(5).setCellValue((String) t[5]);
      // type contract
      row.createCell(6).setCellValue((String) t[6]);

      // Dernier acte
      row.createCell(7).setCellValue((String) t[7]);
      // Date debut DerAct
      row.createCell(8).setCellValue(t[8].toString());
      // Duree
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // Date fin de contrat/SortTemp
      row.createCell(10).setCellValue(String.valueOf(t[10]));

      // Code tech
      row.createCell(11).setCellValue((String) t[11]);
      // Code Corps
      row.createCell(12).setCellValue((String) t[12]);
      // grp chap
      row.createCell(13).setCellValue(String.valueOf(t[13]));

      // compte anal
      row.createCell(14).setCellValue(Integer.valueOf((String) t[14]));

      // Direction
      row.createCell(15).setCellValue((String) t[15]);

      // Structure
      row.createCell(16).setCellValue((String) t[16]);

      // Fonction
      row.createCell(17).setCellValue((String) t[17]);

      // categorie
      row.createCell(18).setCellValue((String) t[18]);
      // indice
      row.createCell(19).setCellValue(((int) t[19]));

      // section
      row.createCell(20).setCellValue((short) t[20]);

      // salaire base
      row.createCell(21).setCellValue(Float.parseFloat((String) t[21].toString()));

      // date entree
      row.createCell(22).setCellValue(String.valueOf(t[22]));

      // technicite
      row.createCell(23).setCellValue((String) t[23]);

      // collectif
      row.createCell(24).setCellValue((String) t[24]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PersonnelRetraitable Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getAnciennte(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "select a.MATRICULE ,p.NOM,d.DESC_DIR,gg.LIBELLE,  case when (c.CODE_ACT='013') then pst.LIBELLE+' PAR INTERIM' else pst.LIBELLE end,   a.DATE_DEB,a.TAUX_MAJ,a.MONT_MAJ,a.DATE_FIN,case when ( a.NBR_ANNEE is null) then 0 else a.NBR_ANNEE end,case when ( a.NBR_MOIS is null) then 0 else a.NBR_MOIS end from CAR.ANCIENNETE a\n"
              + "outer apply (select top 1 * from car.CARRIERE c1 where c1.MATRICULE = a.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join CAR.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
              + "left join car.POSTE_TRAVAIL pst on pst.CODE_PSTR=c.CODE_PSTR\n"
              + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
              + " where      c.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null  and a.MATRICULE<99999  \n"
              + " and a.DATE_DEB=(CONVERT(DateTime,CONVERT(varchar(7),GETDATE(),120) + '-01',120))\n"
              + " and a.TAUX_MAJ!=0  and a.TAUX_MAJ<=60 and a.DATE_FIN='2100-12-31'  \n" + ""
              + dataQuery.getQuery() + " order by c.CODE_DIR asc,a.MATRICULE asc,a.TAUX_MAJ desc")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_ancientee(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom ET Prenoms", "Direction", "Structure", "Fonction",
        "Date_Debut", "Taux", "Montant_Majoration", "Date_Fin", "Nombre_Annee", "Nombre_Mois"};
    List<Object[]> anciennte = getAnciennte(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-MajorationAnciennteEntreprise Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : anciennte) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);

      // nom prenom
      row.createCell(1).setCellValue(String.valueOf(t[1]));

      // direction
      row.createCell(2).setCellValue(String.valueOf(t[2]));

      // structure
      row.createCell(3).setCellValue(String.valueOf(t[3]));

      // fct
      row.createCell(4).setCellValue(String.valueOf(t[4]));

      // Date debut
      row.createCell(5).setCellValue(t[5].toString());
      // Taux
      row.createCell(6).setCellValue(String.valueOf(t[6].toString()));

      // Montant
      row.createCell(7).setCellValue(String.valueOf(t[7].toString()));

      // Date fin
      row.createCell(8).setCellValue(t[8].toString());

      // Nombre Annee
      row.createCell(9).setCellValue(String.valueOf(t[9]));

      // Nombre Mois
      row.createCell(10).setCellValue(String.valueOf(t[10]));

    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Majoration Anciennte Entreprise Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getAnciennteHorsEntreprise(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          " select a.MATRICULE ,p.NOM,d.DESC_DIR,gg.LIBELLE,  case when (c.CODE_ACT='013') then pst.LIBELLE+' PAR INTERIM' else pst.LIBELLE end, a.DATE_DEB , case when (a.TAUX_IEP is null ) then 0 else a.TAUX_IEP end ,case when (a.MONT_IEP is null ) then 0 else a.MONT_IEP end,a.DATE_FIN from CAR.IEP a\n"
              + "outer apply (select top 1 * from car.CARRIERE c1 where c1.MATRICULE = a.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join CAR.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
              + "left join car.POSTE_TRAVAIL pst on pst.CODE_PSTR=c.CODE_PSTR\n"
              + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
              + " where      c.DATE_FIN='2100-12-31' and  a.DATE_FIN='2100-12-31' and c.DATE_SORTIE is null  and a.MATRICULE<99999 \n"
              + "" + dataQuery.getQuery() + " order by a.MATRICULE asc,a.TAUX_IEP desc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_ancienteehorsentreprise(RefUser user)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom ET Prenoms", "Direction", "Structure", "Fonction",
        "Date_Debut", "Taux", "Montant_Majoration", "Date_Fin"};
    List<Object[]> ancienntehe = getAnciennteHorsEntreprise(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-IEPHorsEntreprise Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : ancienntehe) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);

      // nom prenom
      row.createCell(1).setCellValue(String.valueOf(t[1]));

      // direction
      row.createCell(2).setCellValue(String.valueOf(t[2]));

      // structure
      row.createCell(3).setCellValue(String.valueOf(t[3]));

      // fct
      row.createCell(4).setCellValue(String.valueOf(t[4]));

      // Date debut
      row.createCell(5).setCellValue(t[5].toString());
      // Taux
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Montant
      row.createCell(7).setCellValue(String.valueOf(t[7]));

      // Date fin
      row.createCell(8).setCellValue(t[8].toString());

    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-IEPHorsEntreprise Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getCodifGrpChapCatering() {
    try {

      return em.createNativeQuery(
          "select g.GRP_CHAP , g.COMPTE_ANAL ,g.LIBELLE , g.DATE_DEB , g.DATE_FIN,g.DATE_DEC,g.REF_DEC,g.DATE_SAISIE,\n"
              + "g.CODE_UNIT ,g.CODE_WIL\n"
              + " from CAR.GRP_CHAP g where g.DATE_FIN='2100-12-31' \n"
              + "and substring(g.GRP_CHAP,1,2)='20' \n" + "order by g.GRP_CHAP asc" + "")
          .getResultList();

    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_CodifGrpChapCatering() throws IOException, InvalidFormatException {

    String[] columns = {"GRP Chap", "Compte Analitique", "Libelle", "Date Debut", "Date Fin",
        "Date Decision", "Ref Decision", "Date Saisie", "Code Unit", "Code Wilaya"};
    List<Object[]> codifgrpcatering = getCodifGrpChapCatering();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Codif-GrpChapComptAnal Catering");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : codifgrpcatering) {
      Row row = sheet.createRow(rowNum++);

      // grp chap
      row.createCell(0).setCellValue(String.valueOf(t[0]));
      // compte anal
      row.createCell(1).setCellValue(Integer.valueOf((String) t[1]));

      // Libelle
      row.createCell(2).setCellValue((String) t[2]);

      // Date debut
      row.createCell(3).setCellValue(t[3].toString());

      // Date fin
      row.createCell(4).setCellValue(t[4].toString());

      // Date decision
      row.createCell(5).setCellValue(String.valueOf(t[5]));

      // Ref decision
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Date saisie
      row.createCell(7).setCellValue(String.valueOf(t[7]));

      // Code Unite
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code Unite
      row.createCell(9).setCellValue(String.valueOf(t[9]));
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Codification-GrpChapComptAnal Catering de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getCodifGrpChapCargo() {
    try {

      return em.createNativeQuery(
          "select g.GRP_CHAP , g.COMPTE_ANAL ,g.LIBELLE , g.DATE_DEB , g.DATE_FIN,g.DATE_DEC,g.REF_DEC,g.DATE_SAISIE,\n"
              + "g.CODE_UNIT ,g.CODE_WIL\n"
              + " from CAR.GRP_CHAP g where g.DATE_FIN='2100-12-31' \n"
              + "and substring(g.GRP_CHAP,1,2)='18' \n" + "order by g.GRP_CHAP asc" + "")
          .getResultList();

    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_CodifGrpChapCargo() throws IOException, InvalidFormatException {

    String[] columns = {"GRP Chap", "Compte Analitique", "Libelle", "Date Debut", "Date Fin",
        "Date Decision", "Ref Decision", "Date Saisie", "Code Unit", "Code Wilaya"};
    List<Object[]> codifgrpcargo = getCodifGrpChapCargo();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Codif-GrpChapComptAnal Cargo");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : codifgrpcargo) {
      Row row = sheet.createRow(rowNum++);

      // grp chap
      row.createCell(0).setCellValue(String.valueOf(t[0]));
      // compte anal
      row.createCell(1).setCellValue(Integer.valueOf((String) t[1]));

      // Libelle
      row.createCell(2).setCellValue((String) t[2]);

      // Date debut
      row.createCell(3).setCellValue(t[3].toString());

      // Date fin
      row.createCell(4).setCellValue(t[4].toString());

      // Date decision
      row.createCell(5).setCellValue(String.valueOf(t[5]));

      // Ref decision
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Date saisie
      row.createCell(7).setCellValue(String.valueOf(t[7]));

      // Code Unite
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code Unite
      row.createCell(9).setCellValue(String.valueOf(t[9]));
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Codification-GrpChapComptAnal Cargo de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getDechargefct(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where c.CODE_ACT='014' and  YEAR(c.DATE_DEB)=?1\n" + " and p.DATE_SORTIE is  null \n"
          + "" + dataQuery.getQuery() + "order by DATE_DEB desc  ").setParameter(1, year)
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_dechargefct(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> promonomrec = getDechargefct(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-DechargeFonction Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : promonomrec) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-DechargeFonction Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getRecrutement(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery("select \n"
          + "p.MATRICULE,p.NOM ,p.CODE_CIVIL,p.SEXE ,c.TYPE_CONTRAT ,a.LIBELLE,c.DATE_DEB,c.CODE_TECH,c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL,d.DESC_DIR,gg.LIBELLE,t.LIBELLE\n"
          + ",c.CODE_CATG, c.INDI_SALAIRE,c.SECTION,c.SALAIRE_BASE,p.DATE_ENTREE,p.DATE_NAISS,tc.DESC_TECH ,c.CODE_COLLECTIF\n"
          + "\n" + "\n" + " from CAR.CARRIERE c \n"
          + " outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
          + "left join car.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
          + "left join CAR.ACTE a on a.CODE_ACT=c.CODE_ACT\n"
          + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
          + "left join CAR.POSTE_TRAVAIL t on t.CODE_PSTR=c.CODE_PSTR \n"
          + "left join car.TECHNICITE tc on tc.CODE_TECH=c.CODE_TECH\n"
          + "where (c.CODE_ACT between '001' and '005' OR c.CODE_ACT in ('007','008','010')) and  YEAR(c.DATE_DEB)=?1\n"
          + " and p.DATE_SORTIE is  null \n" + "" + dataQuery.getQuery()
          + "order by DATE_DEB desc  ").setParameter(1, year).getResultList();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_recrutement(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Libelle", "Date_Debut", "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique",
        "Direction", "Structure", "Fonction", "Categorie", "Indice", "Section", "Salaire de Base",
        "Date Entree Ah", "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> recrutement = getRecrutement(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Recrutement Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : recrutement) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());

      // Code tech
      row.createCell(7).setCellValue((String) t[7]);
      // Code Corps
      row.createCell(8).setCellValue((String) t[8]);
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));
      // compte anal
      row.createCell(10).setCellValue(Integer.valueOf((String) t[10]));

      // Direction
      row.createCell(11).setCellValue((String) t[11]);

      // Structure
      row.createCell(12).setCellValue((String) t[12]);
      // Fonction
      row.createCell(13).setCellValue((String) t[13]);

      // categorie
      row.createCell(14).setCellValue((String) t[14]);
      // indice
      row.createCell(15).setCellValue(((int) t[15]));

      // section
      row.createCell(16).setCellValue((short) t[16]);

      // salaire base
      row.createCell(17).setCellValue(Float.parseFloat((String) t[17].toString()));

      // date entree
      row.createCell(18).setCellValue(String.valueOf(t[18]));
      // date naissance
      row.createCell(19).setCellValue(String.valueOf(t[19]));
      // technicite
      row.createCell(20).setCellValue((String) t[20]);

      // collectif
      row.createCell(21).setCellValue((String) t[21]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Recrutement Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getpslsansnumss(RefUser user) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' and p.NUM_SS is null and c.CODE_TECH!='L'\n"
              + "and p.matricule<99999 \n" + "" + dataQuery.getQuery()
              + "order by p.MATRICULE asc\n " + "")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_pssansnumss(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Code Tech",
        "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure", "Fonction",
        "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah", "Date Naissance",
        "Technicite", "Code Collectif"};
    List<Object[]> pslsansnumss = getpslsansnumss(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PslSansNumSS Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : pslsansnumss) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);

      // Code tech
      row.createCell(4).setCellValue((String) t[4]);
      // Code Corps
      row.createCell(5).setCellValue((String) t[5]);
      // grp chap
      row.createCell(6).setCellValue(String.valueOf(t[6]));
      // compte anal
      row.createCell(7).setCellValue(Integer.valueOf((String) t[7]));

      // Direction
      row.createCell(8).setCellValue((String) t[8]);

      // Structure
      row.createCell(9).setCellValue((String) t[9]);
      // Fonction
      row.createCell(10).setCellValue((String) t[10]);

      // categorie
      row.createCell(11).setCellValue((String) t[11]);
      // indice
      row.createCell(12).setCellValue(((int) t[12]));

      // section
      row.createCell(13).setCellValue((short) t[13]);

      // salaire base
      row.createCell(14).setCellValue(Float.parseFloat((String) t[14].toString()));

      // date entree
      row.createCell(15).setCellValue(String.valueOf(t[15]));
      // date naissance
      row.createCell(16).setCellValue(String.valueOf(t[16]));
      // technicite
      row.createCell(17).setCellValue((String) t[17]);

      // collectif
      row.createCell(18).setCellValue((String) t[18]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PslSansNumSS Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getpsldisponibilite(PersonnelDTO loggedUsed, RefUser user) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

      String schema = "";
      if (loggedUsed.getCodeFiliale().equals("A")) {
        schema = "PAIE";
      } else if (loggedUsed.getCodeFiliale().equals("C")) {
        schema = "CAT_PAIE";
      } else if (loggedUsed.getCodeFiliale().equals("G")) {
        schema = "CARGO_PAIE";
      }

      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,case when (c.CODE_ACT='013') then pt.LIBELLE+' PAR INTERIM' else  pt.LIBELLE end, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n" + "left join " + schema
              + ".RUB_SPECIFIQUE_T rst on rst.MATRICULE=p.MATRICULE  and  rst.DATE_TRT='210012' \n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100'  \n"
              + "and rst.CODE_DISPONIBILITE=1 \n" + "and p.matricule<99999 \n" + ""
              + dataQuery.getQuery() + "order by p.CODE_DIR asc ,p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void etat_psldisponibilite(PersonnelDTO loggedUsed, RefUser user)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> disponibilite = getpsldisponibilite(loggedUsed, user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PrimeDisponibilite Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : disponibilite) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PrimeDisponibilite Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getavancements(RefUser user, int year) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("c.CODE_DIR", "")
              .withTechNativeConstraint("c.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "select a.MATRICULE ,p.NOM,cr.GRP_CHAP,cr.COMPTE_ANAL,do.DESC_DIR,g.LIBELLE  ,psto.LIBELLE,cr.CODE_CATG,cr.INDI_SALAIRE,cr.SALAIRE_BASE,a.ANNEE,a.CHOIX_AVC,ca.LIBELLE,a.INDICE,d.DESC_DIR,gg.LIBELLE,case when (c.CODE_ACT='013') then pst.LIBELLE+' PAR INTERIM' else pst.LIBELLE end,c.CODE_CATG,c.INDI_SALAIRE,c.SALAIRE_BASE  from car.AVANCEMENT a                  \n"
              + "outer apply (select top 1 * from car.CARRIERE c1 where c1.MATRICULE = a.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "outer apply (select top 1 * from car.CARRIERE cr where cr.MATRICULE = a.MATRICULE and a.ANNEE between YEAR(cr.DATE_DEB) and YEAR(cr.DATE_FIN) order by cr.DATE_FIN desc) cr\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where cr.GRP_CHAP = gg.GRP_CHAP and cr.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc  ) g\n"
              + "left join CAR.CHOIX_AVANCEMENT ca on ca.CHOIX_AVC=a.CHOIX_AVC\n"
              + "left join CAR.V_PERSONNEL p on p.MATRICULE=c.MATRICULE\n"
              + "left join car.POSTE_TRAVAIL pst on pst.CODE_PSTR=c.CODE_PSTR\n"
              + "left join CAR.DIRECTION d on d.CODE_DIR=c.CODE_DIR\n"
              + "left join car.POSTE_TRAVAIL psto on psto.CODE_PSTR=cr.CODE_PSTR\n"
              + "left join CAR.DIRECTION do on do.CODE_DIR=cr.CODE_DIR\n"
              + " where c.DATE_FIN='2100-12-31' and (year(c.DATE_SORTIE)>'2016' or c.DATE_SORTIE is null)  and a.MATRICULE<99999 and a.ANNEE=?1 \n"
              + "" + dataQuery.getQuery()
              + " order by c.CODE_DIR asc,a.ANNEE desc,a.MATRICULE asc ")
          .setParameter(1, year).getResultList();

    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_avancements(RefUser user, int year) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "GRP_CHAP", "Compte Analitique", "Direction",
        "Structure", "Fonction", "Categorie", "Indice", "Salaire de Base", "Exercice", "Choix AVC",
        "Libelle", "Points", "Direction Actuelle", "Structure Actuelle", "Fonction Actuelle",
        "Categorie Actuelle", "Indice Actuelle", "Salaire de Base Actuelle"};
    List<Object[]> avancements = getavancements(user, year);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-Avancements Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : avancements) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue(String.valueOf(t[1]));

      row.createCell(2).setCellValue(String.valueOf(t[2]));

      row.createCell(3).setCellValue(String.valueOf(t[3]));

      row.createCell(4).setCellValue(String.valueOf(t[4]));

      // Dernier acte
      row.createCell(5).setCellValue(String.valueOf(t[5]));
      // Date debut DerAct
      row.createCell(6).setCellValue(String.valueOf(t[6]));

      // Code tech
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      row.createCell(8).setCellValue(String.valueOf(t[8]));
      // grp chap
      row.createCell(9).setCellValue(String.valueOf(t[9]));

      row.createCell(10).setCellValue(String.valueOf(t[10]));

      row.createCell(11).setCellValue(String.valueOf(t[11]));

      row.createCell(12).setCellValue(String.valueOf(t[12]));

      row.createCell(13).setCellValue(String.valueOf(t[13]));

      row.createCell(14).setCellValue(String.valueOf(t[14]));

      row.createCell(15).setCellValue(String.valueOf(t[15]));

      row.createCell(16).setCellValue(String.valueOf(t[16]));

      row.createCell(17).setCellValue(String.valueOf(t[17]));

      row.createCell(18).setCellValue(String.valueOf(t[18]));

      row.createCell(19).setCellValue(String.valueOf(t[19]));

      /*
       * row.createCell(20) .setCellValue( String.valueOf(t[20]));
       */
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-Avancements Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object[]> getpslifsp(PersonnelDTO loggeduser, RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      String schema = "";
      if (loggeduser.getCodeFiliale().equals("A")) {
        schema = "PAIE";
      } else if (loggeduser.getCodeFiliale().equals("C")) {
        schema = "CAT_PAIE";
      } else if (loggeduser.getCodeFiliale().equals("G")) {
        schema = "CARGO_PAIE";
      }

      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,case when (c.CODE_ACT='013') then pt.LIBELLE+' PAR INTERIM' else  pt.LIBELLE end, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n" + "left join " + schema
              + ".RUB_SPECIFIQUE_T rst on rst.MATRICULE=p.MATRICULE  and  rst.DATE_TRT='210012' \n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100'  \n"
              + "and rst.CODE_IFSP=1\n" + "and p.matricule<99999 \n" + "" + dataQuery.getQuery()
              + "order by p.CODE_DIR asc ,p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_pslifsp(PersonnelDTO loggeduser, RefUser user)
      throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> ifsp = getpslifsp(loggeduser, user);
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PrimeIFSP Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : ifsp) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PrimeIFSP Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public int getpslnavigant(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null and c.code_tech='T' \n"
            + "" + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public int getpslnavigantcom(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null and c.code_tech='C' \n"
            + "" + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public int getpslsol(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null and c.code_tech='S'  \n"
            + "" + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public int getpslexpat(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null and c.code_tech='E' \n"
            + "" + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public int getpsllocal(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null and c.code_tech='L'   \n"
            + "" + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public int getpsltotal(RefUser user) {
    DataAccessQueryBuilder dataQuery = new DataAccessQueryBuilder.Builder(user)
        .withFilialeNativeConstraint("c.CODE_FIL", "")
        .withDirectionNativeConstraint("c.CODE_DIR", "").withTechNativeConstraint("c.CODE_TECH", "")
        .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();

    return ((Integer) em.createNativeQuery(
        " select count(c.matricule) from  car.V_PERSONNEL c where c.date_sortie is null   \n" + ""
            + dataQuery.getQuery() + "")
        .getSingleResult()).intValue();

  }

  public List<Object[]> getpslafferronee(RefUser user) {
    try {
      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule,p.NOM, P.CODE_CIVIL, p.SEXE, c.TYPE_CONTRAT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  ,c.CODE_TECH, c.CODE_CORPS,c.GRP_CHAP,c.COMPTE_ANAL , d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, c.CODE_CATG,c.INDI_SALAIRE,c.SECTION , c.SALAIRE_BASE  ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH,c.CODE_COLLECTIF \n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where c.GRP_CHAP = gg.GRP_CHAP and c.COMPTE_ANAL=gg.COMPTE_ANAL order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = c.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  c.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=c.CODE_TECH\n"
              + "Where c.DATE_SORTIE Is null and c.DATE_FIN = '31-12-2100' and gg.LIBELLE is null    \n"
              + "" + dataQuery.getQuery() + "and p.matricule<99999 \n" + "order by p.MATRICULE asc")
          .getResultList();
    } catch (Exception e) {

      e.printStackTrace();
    }
    return null;
  }

  public void etat_pslafferronee(RefUser user) throws IOException, InvalidFormatException {

    String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type_Contrat",
        "Dernier Acte", "Date_Debut_Dernier_Acte", "Duree", "Date Fin Contrat/SortTemp",
        "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
        "Fonction", "Categorie", "Indice", "Section", "Salaire de Base", "Date Entree Ah",
        "Date Naissance", "Technicite", "Code Collectif"};
    List<Object[]> afferronee = getpslafferronee(user);

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DSI-PSLAffectationErronee Ah");
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
    }
    int rowNum = 1;
    for (Object[] t : afferronee) {
      Row row = sheet.createRow(rowNum++);
      // Matricule
      row.createCell(0).setCellValue((int) t[0]);
      // Nom et prenoms
      row.createCell(1).setCellValue((String) t[1]);
      // Code civil
      row.createCell(2).setCellValue((String) t[2]);
      // sexe
      row.createCell(3).setCellValue((String) t[3]);
      // type contract
      row.createCell(4).setCellValue((String) t[4]);

      // Dernier acte
      row.createCell(5).setCellValue((String) t[5]);
      // Date debut DerAct
      row.createCell(6).setCellValue(t[6].toString());
      // Duree
      row.createCell(7).setCellValue(String.valueOf(t[7]));
      // Date fin de contrat/SortTemp
      row.createCell(8).setCellValue(String.valueOf(t[8]));

      // Code tech
      row.createCell(9).setCellValue((String) t[9]);
      // Code Corps
      row.createCell(10).setCellValue((String) t[10]);
      // grp chap
      row.createCell(11).setCellValue(String.valueOf(t[11]));
      // compte anal
      row.createCell(12).setCellValue(Integer.valueOf((String) t[12]));

      // Direction
      row.createCell(13).setCellValue((String) t[13]);

      // Structure
      row.createCell(14).setCellValue((String) t[14]);
      // Fonction
      row.createCell(15).setCellValue((String) t[15]);

      // categorie
      row.createCell(16).setCellValue((String) t[16]);
      // indice
      row.createCell(17).setCellValue(((int) t[17]));

      // section
      row.createCell(18).setCellValue((short) t[18]);

      // salaire base
      row.createCell(19).setCellValue(Float.parseFloat((String) t[19].toString()));

      // date entree
      row.createCell(20).setCellValue(String.valueOf(t[20]));
      // date naissance
      row.createCell(21).setCellValue(String.valueOf(t[21]));
      // technicite
      row.createCell(22).setCellValue((String) t[22]);

      // collectif
      row.createCell(23).setCellValue((String) t[23]);
    }

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String dateToday = dateFormat.format(new Date());
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    workbook.write(outByteStream);
    byte[] outArray = outByteStream.toByteArray();
    String fileOut = "DSI-PSLAffectationErronee Ah de :" + dateToday + ".xlsx";
    HttpServletResponse response =
        (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setContentLength(outArray.length);
    OutputStream outStream = response.getOutputStream();
    outStream.write(outArray);
    response.getOutputStream().write(outArray, 0, outArray.length);
    outStream.flush();
    outStream.close();

  }

  public List<Object> getAllActifPers() {
    return em.createNativeQuery("SELECT MATRICULE FROM CAR.V_PERSONNEL WHERE DATE_SORTIE IS NULL")
        .getResultList();
  }

  public List<Integer> findAllYearpaie(Integer matricule, PersonnelDTO user) {
    try {

      return em.createNativeQuery(
          "select distinct cast (substring( cast (a.DATE_TRT as varchar),1,4) as int) from T_BP.BULLETIN_TOTAL a \n"
              + " where a.MATRICULE=?1 and a.CODE_FIL=?2 order by cast (substring( cast (a.DATE_TRT as varchar),1,4) as int) desc")
          .setParameter(1, matricule).setParameter(2, user.getCodeFiliale()).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Permet de rechercher reliquats de conge du personnel, avec pagination.
   *
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * @return
   */
  public QueryResult<DTOReliquats> findReliquatsByFilters(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<DTOReliquats> q = cb.createQuery(DTOReliquats.class);
    Root<Personnel> personnel = q.from(Personnel.class);
    Join<Personnel, Reliquats> reliquatsConge =
        (Join<Personnel, Reliquats>) personnel.fetch(Personnel_.reliquats, JoinType.LEFT);
    Path<?> path = personnel;
    reliquatsConge.on(cb.and(cb.equal(reliquatsConge.get("reliquatsPK").get("dateTrt"), 210012)));

    q.select(cb.construct(DTOReliquats.class, path.get("matricule"), path.get("nom"),
        path.get("grpChap"), path.get("dirLibelle"), path.get("codeTech"),
        cb.selectCase().when(cb.isNull(reliquatsConge.get("nbReliquats")), 0)
            .otherwise(reliquatsConge.get("nbReliquats")),
        cb.selectCase().when(cb.isNull(reliquatsConge.get("nbReliquatsAcquis")), 0)
            .otherwise(reliquatsConge.get("nbReliquatsAcquis")),
        cb.selectCase().when(cb.isNull(reliquatsConge.get("nbReliquatsPrevis")), 0)
            .otherwise(reliquatsConge.get("nbReliquatsPrevis"))));
    return (QueryResult<DTOReliquats>) findPaginated(personnel, q, count, first, pageSize,
        sortField, sortOrder, filters);
  }


  /**
   * Generer etat des effetifs selon format des statistiques.
   * 
   * @param user
   */
  public List<Object[]> effectifsFormatStatistique(RefUser user) {
    try {

      DataAccessQueryBuilder dataQuery =
          new DataAccessQueryBuilder.Builder(user).withFilialeNativeConstraint("p.CODE_FIL", "")
              .withDirectionNativeConstraint("p.CODE_DIR", "")
              .withTechNativeConstraint("p.CODE_TECH", "")
              .withGroupeNativeConstraint("SUBSTRING(c.GRP_CHAP,1,3)", "").build();
      return em.createNativeQuery(
          "Select p.matricule, p.NOM, P.CODE_CIVIL, p.SEXE, p.TYPE_CONTRAT, p.CODE_UNIT, a.LIBELLE, c.DATE_DEB,c.DUREE,c.DATE_FIN_CONTRAT  , p.CODE_TECH, p.CODE_CORPS, p.GRP_CHAP, p.COMPTE_ANAL, d.DESC_DIR, gg.LIBELLE,pt.LIBELLE, p.CODE_CATG,p.INDICE ,p.DATE_ENTREE, p.DATE_NAISS, tt.DESC_TECH, pt.CODE_SFL, p.CODE_COLLECTIF\n"
              + "From CAR.V_PERSONNEL p\n"
              + "outer apply (select top 1 * from car.CARRIERE c where c.MATRICULE = p.MATRICULE order by DATE_FIN desc) c\n"
              + "outer apply (select top 1 * from car.GRP_CHAP gg where p.GRP_CHAP = gg.GRP_CHAP  and p.COMPTE_ANAL=gg.COMPTE_ANAL  order by gg.DATE_FIN desc ) gg\n"
              + "left join car.Acte a on a.CODE_ACT = c.CODE_ACT\n"
              + "left join car.DIRECTION d on d.CODE_DIR = p.CODE_DIR \n"
              + "left join car.POSTE_TRAVAIL pt on  p.CODE_PSTR = pt.CODE_PSTR\n"
              + "left join CAR.TECHNICITE tt on tt.CODE_TECH=p.CODE_TECH\n"
              + "Where  c.DATE_FIN = '31-12-2100' and p.DATE_SORTIE is null \n" + " "
              + dataQuery.getQuery() + " and p.matricule<99999 \n"
              + " order by c.CODE_DIR asc,c.GRP_CHAP asc,c.SALAIRE_BASE desc,c.MATRICULE asc " + "")
          .getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Generer etat des effetifs selon format des statistiques.
   * 
   * @param user
   * @throws java.io.IOException
   * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
   */
  public void etatEffectifsFormatStatistiques(RefUser user)
      throws IOException, InvalidFormatException {
    try {
      String[] columns = {"Matricule", "Nom et Prenoms", "Code Civil", "Sexe", "Type Contrat",
          "Code Unité", "Acte Carriere", "Date Debut", "Duree", "Date Fin Contrat/SorTemp",
          "Code Tech", "Code Corps", "GRP_CHAP", "Compte Analitique", "Direction", "Structure",
          "Fonction", "Categorie", "Indice", "Date Entree Ah", "Date Naissance", "Technicite",
          "Code SFL", "Code Collectif"};
      List<Object[]> listeEffectifs = effectifsFormatStatistique(user);

      workbook = new XSSFWorkbook();
      sheet = workbook.createSheet("ERP-EffectifsFormatStatistiques");
      Row headerRow = sheet.createRow(0);

      for (int i = 0; i < columns.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns[i]);
      }
      int rowNum = 1;
      for (Object[] t : listeEffectifs) {
        Row row = sheet.createRow(rowNum++);
        // Matricule
        row.createCell(0).setCellValue((int) t[0]);
        // Nom et prenoms
        row.createCell(1).setCellValue((String) t[1]);
        // Code civil
        row.createCell(2).setCellValue((String) t[2]);
        // sexe
        row.createCell(3).setCellValue((String) t[3]);
        // type contrat
        row.createCell(4).setCellValue((String) t[4]);
        // code unite
        row.createCell(5).setCellValue((String) t[5]);
        // acte carriere
        row.createCell(6).setCellValue((String) t[6]);
        // date debut
        row.createCell(7).setCellValue(String.valueOf(t[7]));
        // duree
        row.createCell(8).setCellValue(String.valueOf(t[8]));
        // date fin contrat
        row.createCell(9).setCellValue(String.valueOf(t[9]));
        // Code tech
        row.createCell(10).setCellValue((String) t[10]);
        // Code Corps
        row.createCell(11).setCellValue(String.valueOf(t[11]));
        // grp chap
        row.createCell(12).setCellValue(String.valueOf(t[12]));
        // compte anal
        row.createCell(13).setCellValue(Integer.valueOf((String) t[13]));
        // Direction
        row.createCell(14).setCellValue((String) t[14]);
        // Structure
        row.createCell(15).setCellValue(String.valueOf(t[15]));
        // Fonction
        row.createCell(16).setCellValue((String) t[16]);
        // categorie
        row.createCell(17).setCellValue(String.valueOf(t[17]));
        // indice
        row.createCell(18).setCellValue(String.valueOf(t[18]));
        // date entree
        row.createCell(19).setCellValue(String.valueOf(t[19]));
        // date naissance
        row.createCell(20).setCellValue(String.valueOf(t[20]));
        // technicite
        row.createCell(21).setCellValue((String) t[21]);
        // code sfl
        row.createCell(22).setCellValue(String.valueOf(t[22]));
        // collectif
        row.createCell(23).setCellValue((String) t[23]);
      }
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      String dateToday = dateFormat.format(new Date());
      ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
      workbook.write(outByteStream);
      byte[] outArray = outByteStream.toByteArray();
      String fileOut = "ERP-EffectifsFormatStatistiques-de :" + dateToday + ".xlsx";
      HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
          .getExternalContext().getResponse();
      response.setHeader("Content-Disposition", "attachment; filename=\"" + fileOut + "\"");
      response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
      response.setContentLength(outArray.length);
      OutputStream outStream = response.getOutputStream();
      outStream.write(outArray);
      response.getOutputStream().write(outArray, 0, outArray.length);
      outByteStream.close();
      workbook.close();
      response.flushBuffer();
      outStream.flush();
      outStream.close();
    } catch (Exception e) {
      throw e;
    } finally {
      if (workbook != null) {
        try {
          workbook.close();
        } catch (IOException ex) {
          throw ex;
        }
      }
    }
  }



}
