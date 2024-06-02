/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import dz.airalgerie.grh.model.entities.carriere.Categorie;
import dz.airalgerie.grh.model.entities.carriere.PersACharge;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Customizer;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "CAR", name = "V_PERSONNEL")
@Customizer(RelationCustomizer.class)
@XmlRootElement
public class PersonnelLite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  @Id
  private int matricule;
  @Column(name = "MATRICULE_PN")
  private Integer matriculePn;
  @Size(max = 156)
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
  private LocalDate dateEntree;
  @Column(name = "DATE_SORTIE")
  private LocalDate dateSortie;
  @Column(name = "DATE_NAISS")
  private LocalDate dateNaiss;
  @Column(name = "SEXE")
  private char sexe;
  @Size(max = 3)
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Column(name = "CODE_PSTR")
  private Integer codePstr;
  @Size(max = 150)
  @Column(name = "GRP_LIBELLE")
  private String grpLibelle;
  @Size(max = 50)
  @Column(name = "DIR_LIBELLE")
  private String dirLibelle;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Column(name = "CODE_CATG")
  private String codeCatg;
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Column(name = "PERS_CHARGE")
  private Short persCharge;
  @Size(max = 15)
  @Column(name = "CODE_FCT")
  private String codeFct;
  @Size(max = 30)
  @Column(name = "TEL")
  private String tel;
  @Size(max = 60)
  @Column(name = "MAIL")
  private String mail;
  @Column(name = "IS_INTERIM")
  private boolean isInterim;
  @Column(name = "GRP_CHAP_INTERIM")
  private String grpChapInterim;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "vPers", fetch = FetchType.LAZY)
  private List<EnfantLite> listEnf;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "vPersP", fetch = FetchType.LAZY)
  private List<ParentLite> listPrT;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "vPersC", fetch = FetchType.LAZY)
  private List<ConjointLite> listCnj;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "vPersAc", fetch = FetchType.LAZY)
  private List<PersACharge> listPerac;
  @JoinColumn(name = "CODE_PSTR", referencedColumnName = "CODE_PSTR", insertable = false,
      updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private PosteTravailLite posteT;
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CODE_CATG", referencedColumnName = "CODE_CATG", insertable = false,
      updatable = false)
  private Categorie categorie;

  public PersonnelLite() {
  }

  public PosteTravailLite getPosteT() {
    return posteT;
  }

  public void setPosteT(PosteTravailLite posteT) {
    this.posteT = posteT;
  }

  public List<ParentLite> getListPrT() {
    return listPrT;
  }

  public void setListPrT(List<ParentLite> listPrT) {
    this.listPrT = listPrT;
  }

  public List<ConjointLite> getListCnj() {
    return listCnj;
  }

  public void setListCnj(List<ConjointLite> listCnj) {
    this.listCnj = listCnj;
  }

  public List<EnfantLite> getListEnf() {
    return listEnf;
  }

  public void setListEnf(List<EnfantLite> listEnf) {
    this.listEnf = listEnf;
  }

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

  public LocalDate getDateEntree() {
    return dateEntree;
  }

  public void setDateEntree(LocalDate dateEntree) {
    this.dateEntree = dateEntree;
  }

  public LocalDate getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(LocalDate dateSortie) {
    this.dateSortie = dateSortie;
  }

  public LocalDate getDateNaiss() {
    return dateNaiss;
  }

  public void setDateNaiss(LocalDate dateNaiss) {
    this.dateNaiss = dateNaiss;
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

  public String getCodeCatg() {
    return codeCatg;
  }

  public void setCodeCatg(String codeCatg) {
    this.codeCatg = codeCatg;
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

  public String getCodeFct() {
    return codeFct;
  }

  public void setCodeFct(String codeFct) {
    this.codeFct = codeFct;
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

  public Integer getCodePstr() {
    return codePstr;
  }

  public void setCodePstr(Integer codePstr) {
    this.codePstr = codePstr;
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

  public char getSexe() {
    return sexe;
  }

  public void setSexe(char sexe) {
    this.sexe = sexe;
  }

  public Categorie getCategorie() {
    return categorie;
  }

  public void setCategorie(Categorie categorie) {
    this.categorie = categorie;
  }

  public List<PersACharge> getListPerac() {
    return listPerac;
  }

  public void setListPerac(List<PersACharge> listPerac) {
    this.listPerac = listPerac;
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
}
