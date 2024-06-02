/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.DirectionGrh;
import dz.airalgerie.commun.model.entities.commun.Wilaya;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "CARRIERE")
public class Carriere implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CarrierePK carrierePK;
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_ENTREE")
  private Date dateEntree;
  @Size(max = 3)
  @Column(name = "ECHELLE")
  private String echelle;
  @Column(name = "INDI_SALAIRE")
  private Integer indiSalaire;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SALAIRE_BASE")
  private BigDecimal salaireBase;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Size(max = 6)
  @Column(name = "COMPTE_ANAL")
  private String compteAnal;
  @Column(name = "DUREE")
  private Integer duree;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN_CONTRAT")
  private Date dateFinContrat;
  @Size(max = 150)
  @Column(name = "ORGANISME")
  private String organisme;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_SORTIE")
  private Date dateSortie;
  @JoinColumn(name = "CODE_WIL", referencedColumnName = "CODE_WIL")
  @ManyToOne(fetch = FetchType.LAZY)
  private Wilaya wilaya;
  @JoinColumn(name = "CODE_UNIT", referencedColumnName = "CODE_UNIT")
  @ManyToOne(fetch = FetchType.LAZY)
  private UniteGrh unite;
  @JoinColumn(name = "CODE_TECH", referencedColumnName = "CODE_TECH")
  @ManyToOne(fetch = FetchType.LAZY)
  private Technicite technicite;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  // @JoinColumn(name = "SECTION", referencedColumnName = "CODE_SEC")
  @JoinColumn(name = "SECTION")
  // @ManyToOne(fetch = FetchType.LAZY)
  private Short section;
  @JoinColumn(name = "CODE_PSTR", referencedColumnName = "CODE_PSTR")
  @ManyToOne(fetch = FetchType.LAZY)
  private PosteTravail posteTravail;
  @JoinColumn(name = "CODE_DIR", referencedColumnName = "CODE_DIR")
  @ManyToOne(fetch = FetchType.LAZY)
  private DirectionGrh direction;
  @JoinColumn(name = "CODE_CORPS", referencedColumnName = "CODE_CORPS")
  @ManyToOne(fetch = FetchType.LAZY)
  private Corps corps;
  @JoinColumn(name = "TYPE_CONTRAT", referencedColumnName = "TYPE_CONTRAT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Contrat contrat;
  @JoinColumn(name = "CODE_COLLECTIF", referencedColumnName = "CODE_COLLECTIF")
  @ManyToOne(fetch = FetchType.LAZY)
  private Collectif collectif;
  // @JoinColumn(name = "CODE_CATG", referencedColumnName = "CODE_CATG")
  @Column(name = "CODE_CATG")
  // @ManyToOne(fetch = FetchType.LAZY)
  private String categorie;
  @JoinColumn(name = "CODE_ACT", referencedColumnName = "CODE_ACT", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Acte acte;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Carriere() {}

  public Carriere(CarrierePK carrierePK) {
    this.carrierePK = carrierePK;
  }

  public Carriere(CarrierePK carrierePK, Date dateFin) {
    this.carrierePK = carrierePK;
    this.dateFin = dateFin;
  }

  public Carriere(int matricule, String codeAct, Date dateDeb) {
    this.carrierePK = new CarrierePK(matricule, codeAct, dateDeb);
  }

  public CarrierePK getCarrierePK() {
    return carrierePK;
  }

  public void setCarrierePK(CarrierePK carrierePK) {
    this.carrierePK = carrierePK;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Date getDateEntree() {
    return dateEntree;
  }

  public void setDateEntree(Date dateEntree) {
    this.dateEntree = dateEntree;
  }

  public String getEchelle() {
    return echelle;
  }

  public void setEchelle(String echelle) {
    this.echelle = echelle;
  }

  public Integer getIndiSalaire() {
    return indiSalaire;
  }

  public void setIndiSalaire(Integer indiSalaire) {
    this.indiSalaire = indiSalaire;
  }

  public BigDecimal getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(BigDecimal salaireBase) {
    this.salaireBase = salaireBase;
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

  public Integer getDuree() {
    return duree;
  }

  public void setDuree(Integer duree) {
    this.duree = duree;
  }

  public Date getDateFinContrat() {
    return dateFinContrat;
  }

  public void setDateFinContrat(Date dateFinContrat) {
    this.dateFinContrat = dateFinContrat;
  }

  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }

  public Wilaya getWilaya() {
    return wilaya;
  }

  public void setWilaya(Wilaya wilaya) {
    this.wilaya = wilaya;
  }

  public UniteGrh getUnite() {
    return unite;
  }

  public void setUnite(UniteGrh unite) {
    this.unite = unite;
  }

  public Technicite getTechnicite() {
    return technicite;
  }

  public void setTechnicite(Technicite technicite) {
    this.technicite = technicite;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Short getSection() {
    return section;
  }

  public void setSection(Short section) {
    this.section = section;
  }

  public PosteTravail getPosteTravail() {
    return posteTravail;
  }

  public void setPosteTravail(PosteTravail posteTravail) {
    this.posteTravail = posteTravail;
  }

  public DirectionGrh getDirection() {
    return direction;
  }

  public void setDirection(DirectionGrh direction) {
    this.direction = direction;
  }

  public Corps getCorps() {
    return corps;
  }

  public void setCorps(Corps corps) {
    this.corps = corps;
  }

  public Contrat getContrat() {
    return contrat;
  }

  public void setContrat(Contrat contrat) {
    this.contrat = contrat;
  }

  public Collectif getCollectif() {
    return collectif;
  }

  public void setCollectif(Collectif collectif) {
    this.collectif = collectif;
  }

  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public Acte getActe() {
    return acte;
  }

  public void setActe(Acte acte) {
    this.acte = acte;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (carrierePK != null ? carrierePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Carriere)) {
      return false;
    }
    Carriere other = (Carriere) object;
    if ((this.carrierePK == null && other.carrierePK != null)
        || (this.carrierePK != null && !this.carrierePK.equals(other.carrierePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Carriere{" + carrierePK + ", dateFin=" + dateFin + ", dateEntree=" + dateEntree
        + ", echelle=" + echelle + ", indiSalaire=" + indiSalaire + ", salaireBase=" + salaireBase
        + ", grpChap=" + grpChap + ", compteAnal=" + compteAnal + ", duree=" + duree
        + ", dateFinContrat=" + dateFinContrat + ", organisme=" + organisme + ", dateSortie="
        + dateSortie + ", wilaya=" + wilaya + ", unite=" + unite + ", technicite=" + technicite
        + ", signalitique=" + signalitique + ", section=" + section + ", posteTravail="
        + posteTravail + ", direction=" + direction + ", corps=" + corps + ", contrat=" + contrat
        + ", collectif=" + collectif + ", categorie=" + categorie + ", acte=" + acte + ", statut="
        + statut + '}';
  }

}
