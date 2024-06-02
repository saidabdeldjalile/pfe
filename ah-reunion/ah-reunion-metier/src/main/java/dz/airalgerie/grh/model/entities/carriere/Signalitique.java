/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.PaysGrh;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "SIGNALITIQUE")
public class Signalitique implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Size(max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Column(name = "SEXE")
  private Character sexe;
  @Column(name = "DATE_NAIS")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateNais;
  @Size(max = 100)
  @Column(name = "ADRESSE_ALG")
  private String adresse;
  @Column(name = "NUM_SS")
  private String numSS;
  @Size(max = 100)
  @Column(name = "ADRESSE_ETRG")
  private String adresseEtrg;
  @Size(max = 10)
  @Column(name = "CODE_POSTAL")
  private String codePostal;
  @OrderBy("carrierePK.dateDeb DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OrderBy("sitFamilialePK.dateDeb DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<SituationFamiliale> sitFamilialeList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private AncienneteMoudjahiddine ancMoudj;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private Niveau niveau;
  @OrderBy("antecedentPK.dateDeb DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Antecedent> antecedentList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Parent> parentList;
  @OneToMany(mappedBy = "signalitique1", fetch = FetchType.LAZY)
  private List<Parent> parentList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<FormationInterne> formationIntList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Iep> iepList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList;
  @OneToMany(mappedBy = "signalitique1", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Anciennete> ancienneteList;
  @JoinColumn(name = "PAYS_NAIS", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays;
  @JoinColumn(name = "NATIONALITE", referencedColumnName = "CODE_NAT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Nationalite nationalite;
  @JoinColumn(name = "CODE_HND", referencedColumnName = "CODE_HND")
  @ManyToOne(fetch = FetchType.LAZY)
  private Handicap handicap;
  @JoinColumn(name = "CODE_GEO", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique;
  @JoinColumn(name = "LIEU_NAIS", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique LIEU_NAIS;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList;
  @OneToMany(mappedBy = "signalitique1", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Langue> langueList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<SituationAdministrative> sitAdministrativeList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<SituationSyndicale> SitSyndicaleList;
  @OrderBy("dateFin DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Formation> formationList;
  @OrderBy("dateSnMesCons DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  private List<Enfant> enfantList;
  @OneToMany(mappedBy = "signalitique1", fetch = FetchType.LAZY)
  private List<Enfant> enfantList1;

  // @OneToOne(cascade = CascadeType.ALL, mappedBy = "signalitique", fetch = FetchType.LAZY)
  @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "MATRICULE", updatable = false, insertable = false)
  private Contact contact;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Signalitique() {}

  public Signalitique(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom.toUpperCase(Locale.FRANCE);
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    if (njfille != null) {
      njfille = njfille.toUpperCase(Locale.FRANCE);
    }
    this.njfille = njfille;
  }

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms.toUpperCase(Locale.FRANCE);
  }

  public Character getSexe() {
    return sexe;
  }

  public void setSexe(Character sexe) {
    this.sexe = sexe;
    this.njfille = null;
  }

  public Date getDateNais() {
    // if (dateNais == null) {
    // dateNais = new Date();
    // }
    return dateNais;
  }

  public void setDateNais(Date dateNais) {
    this.dateNais = dateNais;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getNumSS() {
    return numSS;
  }

  public void setNumSS(String numSS) {
    this.numSS = numSS;
  }

  public String getAdresseEtrg() {
    return adresseEtrg;
  }

  public void setAdresseEtrg(String adresseEtrg) {
    this.adresseEtrg = adresseEtrg;
  }

  public String getCodePostal() {
    if (codePostal == null) {
      codePostal = "";
    }
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    if (codePostal != null && codePostal.isEmpty()) {
      this.codePostal = null;
    } else {
      this.codePostal = codePostal;
    }

  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<SituationFamiliale> getSitFamilialeList() {
    return sitFamilialeList;
  }

  public void setSitFamilialeList(List<SituationFamiliale> sitFamilialeList) {
    this.sitFamilialeList = sitFamilialeList;
  }

  public AncienneteMoudjahiddine getAncMoudj() {
    return ancMoudj;
  }

  public void setAncMoudj(AncienneteMoudjahiddine ancMoudj) {
    this.ancMoudj = ancMoudj;
  }

  public Niveau getNiveau() {
    return niveau;
  }

  public void setNiveau(Niveau niveau) {
    this.niveau = niveau;
  }

  @XmlTransient
  public List<Antecedent> getAntecedentList() {
    return antecedentList;
  }

  public void setAntecedentList(List<Antecedent> antecedentList) {
    this.antecedentList = antecedentList;
  }

  @XmlTransient
  public List<Parent> getParentList() {
    return parentList;
  }

  public void setParentList(List<Parent> parentList) {
    this.parentList = parentList;
  }

  @XmlTransient
  public List<Parent> getParentList1() {
    return parentList1;
  }

  public void setParentList1(List<Parent> parentList1) {
    this.parentList1 = parentList1;
  }

  @XmlTransient
  public List<FormationInterne> getFormationIntList() {
    return formationIntList;
  }

  public void setFormationIntList(List<FormationInterne> formationIntList) {
    this.formationIntList = formationIntList;
  }

  @XmlTransient
  public List<Iep> getIepList() {
    return iepList;
  }

  public void setIepList(List<Iep> iepList) {
    this.iepList = iepList;
  }

  @XmlTransient
  public List<Conjoint> getConjointList() {
    return conjointList;
  }

  public void setConjointList(List<Conjoint> conjointList) {
    this.conjointList = conjointList;
  }

  @XmlTransient
  public List<Conjoint> getConjointList1() {
    return conjointList1;
  }

  public void setConjointList1(List<Conjoint> conjointList1) {
    this.conjointList1 = conjointList1;
  }

  @XmlTransient
  public List<Anciennete> getAncienneteList() {
    return ancienneteList;
  }

  public void setAncienneteList(List<Anciennete> ancienneteList) {
    this.ancienneteList = ancienneteList;
  }

  public PaysGrh getPays() {
    return pays;
  }

  public void setPays(PaysGrh pays) {
    this.pays = pays;
  }

  public Nationalite getNationalite() {
    return nationalite;
  }

  public void setNationalite(Nationalite nationalite) {
    this.nationalite = nationalite;
  }

  public Handicap getHandicap() {
    return handicap;
  }

  public void setHandicap(Handicap handicap) {
    this.handicap = handicap;
  }

  public CodeGeographique getCodeGeographique() {
    return codeGeographique;
  }

  public void setCodeGeographique(CodeGeographique codeGeographique) {
    this.codeGeographique = codeGeographique;
  }

  public CodeGeographique getLIEU_NAIS() {
    return LIEU_NAIS;
  }

  public void setLIEU_NAIS(CodeGeographique LIEU_NAIS) {
    this.LIEU_NAIS = LIEU_NAIS;
  }

  @XmlTransient
  public List<PersACharge> getPersAChargeList() {
    return persAChargeList;
  }

  public void setPersAChargeList(List<PersACharge> persAChargeList) {
    this.persAChargeList = persAChargeList;
  }

  @XmlTransient
  public List<PersACharge> getPersAChargeList1() {
    return persAChargeList1;
  }

  public void setPersAChargeList1(List<PersACharge> persAChargeList1) {
    this.persAChargeList1 = persAChargeList1;
  }

  @XmlTransient
  public List<Langue> getLangueList() {
    return langueList;
  }

  public void setLangueList(List<Langue> langueList) {
    this.langueList = langueList;
  }

  public List<SituationAdministrative> getSitAdministrativeList() {
    return sitAdministrativeList;
  }

  public void setSitAdministrativeList(List<SituationAdministrative> sitAdministrativeList) {
    this.sitAdministrativeList = sitAdministrativeList;
  }

  public List<SituationSyndicale> getSitSyndicaleList() {
    return SitSyndicaleList;
  }

  public void setSitSyndicaleList(List<SituationSyndicale> SitSyndicaleList) {
    this.SitSyndicaleList = SitSyndicaleList;
  }

  @XmlTransient
  public List<Formation> getFormationList() {
    return formationList;
  }

  public void setFormationList(List<Formation> formationList) {
    this.formationList = formationList;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList() {
    return disciplineList;
  }

  public void setDisciplineList(List<Discipline> disciplineList) {
    this.disciplineList = disciplineList;
  }

  @XmlTransient
  public List<Enfant> getEnfantList() {
    return enfantList;
  }

  public void setEnfantList(List<Enfant> enfantList) {
    this.enfantList = enfantList;
  }

  @XmlTransient
  public List<Enfant> getEnfantList1() {
    return enfantList1;
  }

  public void setEnfantList1(List<Enfant> enfantList1) {
    this.enfantList1 = enfantList1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Signalitique)) {
      return false;
    }
    Signalitique other = (Signalitique) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Signalitique[ matricule=" + matricule + " ]";
  }

}
