/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "V_PERSONNEL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VuePersonnel.findAll", query = "SELECT v FROM VuePersonnel v"),
    @NamedQuery(name = "VuePersonnel.findByMatricule",
        query = "SELECT v FROM VuePersonnel v WHERE v.matricule = :matricule"),
    @NamedQuery(name = "VuePersonnel.findByMatriculePn",
        query = "SELECT v FROM VuePersonnel v WHERE v.matriculePn = :matriculePn"),
    @NamedQuery(name = "VuePersonnel.findByNom",
        query = "SELECT v FROM VuePersonnel v WHERE v.nom = :nom"),
    @NamedQuery(name = "VuePersonnel.findByName",
        query = "SELECT v FROM VuePersonnel v WHERE v.name = :name"),
    @NamedQuery(name = "VuePersonnel.findByPrenom",
        query = "SELECT v FROM VuePersonnel v WHERE v.prenom = :prenom"),
    @NamedQuery(name = "VuePersonnel.findByNjfille",
        query = "SELECT v FROM VuePersonnel v WHERE v.njfille = :njfille"),
    @NamedQuery(name = "VuePersonnel.findByDateEntree",
        query = "SELECT v FROM VuePersonnel v WHERE v.dateEntree = :dateEntree"),
    @NamedQuery(name = "VuePersonnel.findByDateNaiss",
        query = "SELECT v FROM VuePersonnel v WHERE v.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "VuePersonnel.findByNumSs",
        query = "SELECT v FROM VuePersonnel v WHERE v.numSs = :numSs"),
    @NamedQuery(name = "VuePersonnel.findByTypeContrat",
        query = "SELECT v FROM VuePersonnel v WHERE v.typeContrat = :typeContrat"),
    @NamedQuery(name = "VuePersonnel.findByDateSortie",
        query = "SELECT v FROM VuePersonnel v WHERE v.dateSortie = :dateSortie"),
    @NamedQuery(name = "VuePersonnel.findBySexe",
        query = "SELECT v FROM VuePersonnel v WHERE v.sexe = :sexe"),
    @NamedQuery(name = "VuePersonnel.findByCodeNat",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeNat = :codeNat"),
    @NamedQuery(name = "VuePersonnel.findByCodeWil",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeWil = :codeWil"),
    @NamedQuery(name = "VuePersonnel.findByCodeUnit",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeUnit = :codeUnit"),
    @NamedQuery(name = "VuePersonnel.findByCodeMotif",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeMotif = :codeMotif"),
    @NamedQuery(name = "VuePersonnel.findByCodeDir",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeDir = :codeDir"),
    @NamedQuery(name = "VuePersonnel.findByGrpChap",
        query = "SELECT v FROM VuePersonnel v WHERE v.grpChap = :grpChap"),
    @NamedQuery(name = "VuePersonnel.findByCompteAnal",
        query = "SELECT v FROM VuePersonnel v WHERE v.compteAnal = :compteAnal"),
    @NamedQuery(name = "VuePersonnel.findByCodeCatg",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeCatg = :codeCatg"),
    @NamedQuery(name = "VuePersonnel.findByIndice",
        query = "SELECT v FROM VuePersonnel v WHERE v.indice = :indice"),
    @NamedQuery(name = "VuePersonnel.findBySalaireBase",
        query = "SELECT v FROM VuePersonnel v WHERE v.salaireBase = :salaireBase"),
    @NamedQuery(name = "VuePersonnel.findByCodeCivil",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeCivil = :codeCivil"),
    @NamedQuery(name = "VuePersonnel.findByEnfantm10",
        query = "SELECT v FROM VuePersonnel v WHERE v.enfantm10 = :enfantm10"),
    @NamedQuery(name = "VuePersonnel.findByEnfantp10",
        query = "SELECT v FROM VuePersonnel v WHERE v.enfantp10 = :enfantp10"),
    @NamedQuery(name = "VuePersonnel.findByCodeTech",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeTech = :codeTech"),
    @NamedQuery(name = "VuePersonnel.findByPersCharge",
        query = "SELECT v FROM VuePersonnel v WHERE v.persCharge = :persCharge"),
    @NamedQuery(name = "VuePersonnel.findByCodeCollectif",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeCollectif = :codeCollectif"),
    @NamedQuery(name = "VuePersonnel.findByCodeFoye",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeFoye = :codeFoye"),
    @NamedQuery(name = "VuePersonnel.findByCodeZone",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeZone = :codeZone"),
    @NamedQuery(name = "VuePersonnel.findByCodeMgt",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeMgt = :codeMgt"),
    @NamedQuery(name = "VuePersonnel.findByNumMgt",
        query = "SELECT v FROM VuePersonnel v WHERE v.numMgt = :numMgt"),
    @NamedQuery(name = "VuePersonnel.findByCodeAstreinte",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeAstreinte = :codeAstreinte"),
    @NamedQuery(name = "VuePersonnel.findByCodeCaat",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeCaat = :codeCaat"),
    @NamedQuery(name = "VuePersonnel.findByNumCaat",
        query = "SELECT v FROM VuePersonnel v WHERE v.numCaat = :numCaat"),
    @NamedQuery(name = "VuePersonnel.findByCodeBanqueDa",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeBanqueDa = :codeBanqueDa"),
    @NamedQuery(name = "VuePersonnel.findByCompteDa",
        query = "SELECT v FROM VuePersonnel v WHERE v.compteDa = :compteDa"),
    @NamedQuery(name = "VuePersonnel.findByCodeBanqueDev",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeBanqueDev = :codeBanqueDev"),
    @NamedQuery(name = "VuePersonnel.findByCompteDev",
        query = "SELECT v FROM VuePersonnel v WHERE v.compteDev = :compteDev"),
    @NamedQuery(name = "VuePersonnel.findByCodeFct",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeFct = :codeFct"),
    @NamedQuery(name = "VuePersonnel.findByCodeFctPn",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeFctPn = :codeFctPn"),
    @NamedQuery(name = "VuePersonnel.findByCodeQualifPn",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeQualifPn = :codeQualifPn"),
    @NamedQuery(name = "VuePersonnel.findByAdresse",
        query = "SELECT v FROM VuePersonnel v WHERE v.adresse = :adresse"),
    @NamedQuery(name = "VuePersonnel.findByCodePostal",
        query = "SELECT v FROM VuePersonnel v WHERE v.codePostal = :codePostal"),
    @NamedQuery(name = "VuePersonnel.findByTel",
        query = "SELECT v FROM VuePersonnel v WHERE v.tel = :tel"),
    @NamedQuery(name = "VuePersonnel.findByMail",
        query = "SELECT v FROM VuePersonnel v WHERE v.mail = :mail"),
    @NamedQuery(name = "VuePersonnel.findByCodeRetraite",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeRetraite = :codeRetraite"),
    @NamedQuery(name = "VuePersonnel.findByCodeSec",
        query = "SELECT v FROM VuePersonnel v WHERE v.codeSec = :codeSec"),
    @NamedQuery(name = "VuePersonnel.findByGrpLibelle",
        query = "SELECT v FROM VuePersonnel v WHERE v.grpLibelle = :grpLibelle"),
    @NamedQuery(name = "VuePersonnel.findByDirLibelle",
        query = "SELECT v FROM VuePersonnel v WHERE v.dirLibelle = :dirLibelle")})
public class VuePersonnel implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Column(name = "MATRICULE_PN")
  private Integer matriculePn;
  @Size(max = 101)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "NAME")
  private String name;
  @Size(max = 50)
  @Column(name = "PRENOM")
  private String prenom;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Column(name = "DATE_ENTREE")
  @Temporal(TemporalType.DATE)
  private Date dateEntree;
  @Column(name = "DATE_NAISS")
  @Temporal(TemporalType.DATE)
  private Date dateNaiss;
  @Size(max = 30)
  @Column(name = "NUM_SS")
  private String numSs;
  @Column(name = "TYPE_CONTRAT")
  private Character typeContrat;
  @Column(name = "DATE_SORTIE")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
  @Column(name = "SEXE")
  private Character sexe;
  @Column(name = "CODE_NAT")
  private Short codeNat;
  @Size(max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Size(max = 2)
  @Column(name = "CODE_UNIT")
  private String codeUnit;
  @Column(name = "CODE_MOTIF")
  private Character codeMotif;
  @Size(max = 3)
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Size(max = 6)
  @Column(name = "COMPTE_ANAL")
  private String compteAnal;
  @Size(max = 3)
  @Column(name = "CODE_CATG")
  private String codeCatg;
  @Column(name = "INDICE")
  private Short indice;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SALAIRE_BASE")
  private BigDecimal salaireBase;
  @Column(name = "CODE_CIVIL")
  private Character codeCivil;
  @Column(name = "ENFANTM10")
  private Short enfantm10;
  @Column(name = "ENFANTP10")
  private Short enfantp10;
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Column(name = "PERS_CHARGE")
  private Short persCharge;
  @Column(name = "CODE_COLLECTIF")
  private Character codeCollectif;
  @Column(name = "CODE_FOYE")
  private Short codeFoye;
  @Column(name = "CODE_ZONE")
  private Short codeZone;
  @Column(name = "CODE_MGT")
  private Short codeMgt;
  @Size(max = 30)
  @Column(name = "NUM_MGT")
  private String numMgt;
  @Column(name = "CODE_ASTREINTE")
  private Short codeAstreinte;
  @Column(name = "CODE_CAAT")
  private Short codeCaat;
  @Size(max = 30)
  @Column(name = "NUM_CAAT")
  private String numCaat;
  @Column(name = "CODE_BANQUE_DA")
  private Short codeBanqueDa;
  @Size(max = 200)
  @Column(name = "COMPTE_DA")
  private String compteDa;
  @Column(name = "CODE_BANQUE_DEV")
  private Short codeBanqueDev;
  @Size(max = 200)
  @Column(name = "COMPTE_DEV")
  private String compteDev;
  @Size(max = 15)
  @Column(name = "CODE_FCT")
  private String codeFct;
  @Size(max = 12)
  @Column(name = "CODE_FCT_PN")
  private String codeFctPn;
  @Column(name = "CODE_QUALIF_PN")
  private Character codeQualifPn;
  @Size(max = 100)
  @Column(name = "ADRESSE")
  private String adresse;
  @Size(max = 10)
  @Column(name = "CODE_POSTAL")
  private String codePostal;
  @Size(max = 30)
  @Column(name = "TEL")
  private String tel;
  @Size(max = 60)
  @Column(name = "MAIL")
  private String mail;
  @Column(name = "CODE_RETRAITE")
  private Short codeRetraite;
  @Column(name = "CODE_SEC")
  private Short codeSec;
  @Size(max = 150)
  @Column(name = "GRP_LIBELLE")
  private String grpLibelle;
  @Size(max = 50)
  @Column(name = "DIR_LIBELLE")
  private String dirLibelle;

  public VuePersonnel() {}

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Integer getMatriculePn() {
    return matriculePn;
  }

  public void setMatriculePn(Integer matriculePn) {
    this.matriculePn = matriculePn;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  public Date getDateEntree() {
    return dateEntree;
  }

  public void setDateEntree(Date dateEntree) {
    this.dateEntree = dateEntree;
  }

  public Date getDateNaiss() {
    return dateNaiss;
  }

  public void setDateNaiss(Date dateNaiss) {
    this.dateNaiss = dateNaiss;
  }

  public String getNumSs() {
    return numSs;
  }

  public void setNumSs(String numSs) {
    this.numSs = numSs;
  }

  public Character getTypeContrat() {
    return typeContrat;
  }

  public void setTypeContrat(Character typeContrat) {
    this.typeContrat = typeContrat;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }

  public Character getSexe() {
    return sexe;
  }

  public void setSexe(Character sexe) {
    this.sexe = sexe;
  }

  public Short getCodeNat() {
    return codeNat;
  }

  public void setCodeNat(Short codeNat) {
    this.codeNat = codeNat;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public String getCodeUnit() {
    return codeUnit;
  }

  public void setCodeUnit(String codeUnit) {
    this.codeUnit = codeUnit;
  }

  public Character getCodeMotif() {
    return codeMotif;
  }

  public void setCodeMotif(Character codeMotif) {
    this.codeMotif = codeMotif;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getCompteAnal() {
    return compteAnal;
  }

  public void setCompteAnal(String compteAnal) {
    this.compteAnal = compteAnal;
  }

  public String getCodeCatg() {
    return codeCatg;
  }

  public void setCodeCatg(String codeCatg) {
    this.codeCatg = codeCatg;
  }

  public Short getIndice() {
    return indice;
  }

  public void setIndice(Short indice) {
    this.indice = indice;
  }

  public BigDecimal getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(BigDecimal salaireBase) {
    this.salaireBase = salaireBase;
  }

  public Character getCodeCivil() {
    return codeCivil;
  }

  public void setCodeCivil(Character codeCivil) {
    this.codeCivil = codeCivil;
  }

  public Short getEnfantm10() {
    return enfantm10;
  }

  public void setEnfantm10(Short enfantm10) {
    this.enfantm10 = enfantm10;
  }

  public Short getEnfantp10() {
    return enfantp10;
  }

  public void setEnfantp10(Short enfantp10) {
    this.enfantp10 = enfantp10;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public Short getPersCharge() {
    return persCharge;
  }

  public void setPersCharge(Short persCharge) {
    this.persCharge = persCharge;
  }

  public Character getCodeCollectif() {
    return codeCollectif;
  }

  public void setCodeCollectif(Character codeCollectif) {
    this.codeCollectif = codeCollectif;
  }

  public Short getCodeFoye() {
    return codeFoye;
  }

  public void setCodeFoye(Short codeFoye) {
    this.codeFoye = codeFoye;
  }

  public Short getCodeZone() {
    return codeZone;
  }

  public void setCodeZone(Short codeZone) {
    this.codeZone = codeZone;
  }

  public Short getCodeMgt() {
    return codeMgt;
  }

  public void setCodeMgt(Short codeMgt) {
    this.codeMgt = codeMgt;
  }

  public String getNumMgt() {
    return numMgt;
  }

  public void setNumMgt(String numMgt) {
    this.numMgt = numMgt;
  }

  public Short getCodeAstreinte() {
    return codeAstreinte;
  }

  public void setCodeAstreinte(Short codeAstreinte) {
    this.codeAstreinte = codeAstreinte;
  }

  public Short getCodeCaat() {
    return codeCaat;
  }

  public void setCodeCaat(Short codeCaat) {
    this.codeCaat = codeCaat;
  }

  public String getNumCaat() {
    return numCaat;
  }

  public void setNumCaat(String numCaat) {
    this.numCaat = numCaat;
  }

  public Short getCodeBanqueDa() {
    return codeBanqueDa;
  }

  public void setCodeBanqueDa(Short codeBanqueDa) {
    this.codeBanqueDa = codeBanqueDa;
  }

  public String getCompteDa() {
    return compteDa;
  }

  public void setCompteDa(String compteDa) {
    this.compteDa = compteDa;
  }

  public Short getCodeBanqueDev() {
    return codeBanqueDev;
  }

  public void setCodeBanqueDev(Short codeBanqueDev) {
    this.codeBanqueDev = codeBanqueDev;
  }

  public String getCompteDev() {
    return compteDev;
  }

  public void setCompteDev(String compteDev) {
    this.compteDev = compteDev;
  }

  public String getCodeFct() {
    return codeFct;
  }

  public void setCodeFct(String codeFct) {
    this.codeFct = codeFct;
  }

  public String getCodeFctPn() {
    return codeFctPn;
  }

  public void setCodeFctPn(String codeFctPn) {
    this.codeFctPn = codeFctPn;
  }

  public Character getCodeQualifPn() {
    return codeQualifPn;
  }

  public void setCodeQualifPn(Character codeQualifPn) {
    this.codeQualifPn = codeQualifPn;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Short getCodeRetraite() {
    return codeRetraite;
  }

  public void setCodeRetraite(Short codeRetraite) {
    this.codeRetraite = codeRetraite;
  }

  public Short getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(Short codeSec) {
    this.codeSec = codeSec;
  }

  public String getGrpLibelle() {
    return grpLibelle;
  }

  public void setGrpLibelle(String grpLibelle) {
    this.grpLibelle = grpLibelle;
  }

  public String getDirLibelle() {
    return dirLibelle;
  }

  public void setDirLibelle(String dirLibelle) {
    this.dirLibelle = dirLibelle;
  }

}
