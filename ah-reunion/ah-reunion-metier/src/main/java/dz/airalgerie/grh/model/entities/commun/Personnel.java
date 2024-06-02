/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.grh.model.entities.commun;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "V_PERSONNEL", schema = "CAR")
public class Personnel implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Column(name = "MATRICULE_PN")
  private Integer matriculePn;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 60)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 30)
  @Column(name = "NAME")
  private String name;
  @Size(max = 30)
  @Column(name = "PRENOM")
  private String prenom;
  @Size(max = 30)
  @Column(name = "NJFILLE")
  private String njfille;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_ENTREE")
  @Temporal(TemporalType.DATE)
  private Date dateEntree;
  @Column(name = "DATE_NAISS")
  @Temporal(TemporalType.DATE)
  private Date dateNaiss;
  @Size(max = 30)
  @Column(name = "NUM_SS")
  private String numSs;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TYPE_CONTRAT")
  private Character typeContrat;
  @Column(name = "DATE_SORTIE")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SEXE")
  private Character sexe;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_NAT")
  private short codeNat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Size(max = 2)
  @Column(name = "CODE_UNIT")
  private String codeUnit;
  @Column(name = "CODE_MOTIF")
  private Character codeMotif;
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
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Column(name = "PERS_CHARGE")
  private Short persCharge;
  @Column(name = "CODE_COLLECTIF")
  private Character codeCollectif;
  @Column(name = "CODE_FOYE")
  private Short codeFoye;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ZONE")
  private short codeZone;
  @Column(name = "CODE_MGT")
  private Short codeMgt;
  @Size(max = 30)
  @Column(name = "NUM_MGT")
  private String numMgt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ASTREINTE")
  private short codeAstreinte;
  @Column(name = "CODE_CAAT")
  private Short codeCaat;
  @Size(max = 30)
  @Column(name = "NUM_CAAT")
  private String numCaat;
  @Column(name = "CODE_BANQUE_DA")
  private Short codeBanqueDa;
  @Size(max = 50)
  @Column(name = "COMPTE_DA")
  private String compteDa;
  @Column(name = "CODE_BANQUE_DEV")
  private Short codeBanqueDev;
  @Size(max = 50)
  @Column(name = "COMPTE_DEV")
  private String compteDev;
  @Column(name = "CODE_FCT_PN")
  private Character codeFctPn;
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
  @Column(name = "CODE_FCT")
  private String codeFonction;
  // @Column(name = "CODE_DIR")
  // private String codeDirection;
  @Column(name = "CODE_RETRAITE")
  private Short codeRetraite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_SEC")
  private short codeSec;
  @Size(max = 100)
  @Column(name = "GRP_LIBELLE")
  private String grpLibelle;
  @Size(max = 100)
  @Column(name = "DIR_LIBELLE")
  private String dirLibelle;
  @Column(name = "CODE_FIL")
  private String codeFiliale;
  @Column(name = "IS_INTERIM")
  private boolean isInterim;
  @Column(name = "GRP_CHAP_INTERIM")
  private String grpChapInterim;
  @Column(name = "PSTR_INTERIM")
  private String pstrInterim;


  public Personnel() {
  }

  public Personnel(Integer matricule) {
    this.matricule = matricule;
  }

  public Personnel(Integer matricule, String nom, Date dateEntree, Character typeContrat,
      Character sexe, short codeNat, String codeWil, Character codeTech, short codeZone,
      short codeAstreinte, short codeSec) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateEntree = dateEntree;
    this.typeContrat = typeContrat;
    this.sexe = sexe;
    this.codeNat = codeNat;
    this.codeWil = codeWil;
    this.codeTech = codeTech;
    this.codeZone = codeZone;
    this.codeAstreinte = codeAstreinte;
    this.codeSec = codeSec;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
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

  public short getCodeNat() {
    return codeNat;
  }

  public void setCodeNat(short codeNat) {
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

  public short getCodeZone() {
    return codeZone;
  }

  public void setCodeZone(short codeZone) {
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

  public short getCodeAstreinte() {
    return codeAstreinte;
  }

  public void setCodeAstreinte(short codeAstreinte) {
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

  public Character getCodeFctPn() {
    return codeFctPn;
  }

  public void setCodeFctPn(Character codeFctPn) {
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

  public String getCodeFonction() {
    return codeFonction;
  }

  public void setCodeFonction(String codeFonction) {
    this.codeFonction = codeFonction;
  }

  public Short getCodeRetraite() {
    return codeRetraite;
  }

  public void setCodeRetraite(Short codeRetraite) {
    this.codeRetraite = codeRetraite;
  }

  public short getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(short codeSec) {
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

  public String getCodeFiliale() {
    return codeFiliale;
  }

  public void setCodeFiliale(String codeFiliale) {
    this.codeFiliale = codeFiliale;
  }

  public boolean isIsInterim() {
    return isInterim;
  }

  public void setIsInterim(boolean isInterim) {
    this.isInterim = isInterim;
  }

  public String getGrpChapInterim() {
    return grpChapInterim;
  }

  public void setGrpChapInterim(String grpChapInterim) {
    this.grpChapInterim = grpChapInterim;
  }

  public String getPstrInterim() {
    return pstrInterim;
  }

  public void setPstrInterim(String pstrInterim) {
    this.pstrInterim = pstrInterim;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }
  //
  // public RubSpecifique getRubSpecifique() {
  // return rubSpecifique;
  // }
  //
  // public void setRubSpecifique(RubSpecifique rubSpecifique) {
  // this.rubSpecifique = rubSpecifique;
  // }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Personnel)) {
      return false;
    }
    Personnel other = (Personnel) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.PersonnelGrh[ matricule=" + matricule + " ]";
  }

}
