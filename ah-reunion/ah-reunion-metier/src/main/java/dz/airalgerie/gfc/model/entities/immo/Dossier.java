/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import dz.airalgerie.gfc.model.entities.commun.UniteImmo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "DOSSIER")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Dossier.findAll", query = "SELECT d FROM Dossier d")})
public class Dossier implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DOSSIERID")
  private Long dossierid;
  @Column(name = "DOSSIERIDOLD")
  private Long dossieridold;
  @Column(name = "DATECOMPT")
  @Temporal(TemporalType.DATE)
  private Date datecompt;
  @Column(name = "DATEACQ")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAcquisition;
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Column(name = "DATEFAC")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datefac;
  @Column(name = "DATEBONCOMM")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateboncomm;
  @Size(max = 255)
  @Column(name = "FOURNISSEUR")
  private String fournisseur;
  @Size(max = 255)
  @Column(name = "NUMFAC")
  private String numfac;
  @Size(max = 255)
  @Column(name = "NUMBONCOMM")
  private String numboncomm;
  @Column(name = "NBRPV")
  private Long nbrpv;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "STATUT")
  private String statut;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier", fetch = FetchType.LAZY)
  private List<RaisonRejet> raisonRejetList;
  // @JoinColumn(name = "USERID", referencedColumnName = "USERID")
  // @ManyToOne(optional = false, fetch = FetchType.LAZY)
  // private Appuser appuser;
  @JoinColumn(name = "UNITEID", referencedColumnName = "UNITEID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private UniteImmo unite;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier", fetch = FetchType.LAZY)
  private List<Pv> pvList;

  public Dossier() {}

  public Dossier(Long dossierid) {
    this.dossierid = dossierid;
  }

  public Dossier(Long dossierid, String statut) {
    this.dossierid = dossierid;
    this.statut = statut;
  }

  public Long getDossierId() {
    return dossierid;
  }

  public void setDossierId(Long dossierid) {
    this.dossierid = dossierid;
  }

  public Long getDossieridold() {
    return dossieridold;
  }

  public void setDossieridold(Long dossieridold) {
    this.dossieridold = dossieridold;
  }

  public Date getDatecompt() {
    return datecompt;
  }

  public void setDatecompt(Date datecompt) {
    this.datecompt = datecompt;
  }

  public Date getDateAcquisition() {
    return dateAcquisition;
  }

  public void setDateAcquisition(Date dateAcquisition) {
    this.dateAcquisition = dateAcquisition;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getDatefac() {
    return datefac;
  }

  public void setDatefac(Date datefac) {
    this.datefac = datefac;
  }

  public Date getDateboncomm() {
    return dateboncomm;
  }

  public void setDateboncomm(Date dateboncomm) {
    this.dateboncomm = dateboncomm;
  }

  public String getFournisseur() {
    return fournisseur;
  }

  public void setFournisseur(String fournisseur) {
    this.fournisseur = fournisseur;
  }

  public String getNumfac() {
    return numfac;
  }

  public void setNumfac(String numfac) {
    this.numfac = numfac;
  }

  public String getNumboncomm() {
    return numboncomm;
  }

  public void setNumboncomm(String numboncomm) {
    this.numboncomm = numboncomm;
  }

  public Long getNbrpv() {
    return nbrpv;
  }

  public void setNbrpv(Long nbrpv) {
    this.nbrpv = nbrpv;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  @XmlTransient
  public List<RaisonRejet> getRaisonRejetList() {
    return raisonRejetList;
  }

  public void setRaisonRejetList(List<RaisonRejet> raisonRejetList) {
    this.raisonRejetList = raisonRejetList;
  }

  // public Appuser getAppuser() {
  // return appuser;
  // }
  //
  // public void setAppuser(Appuser appuser) {
  // this.appuser = appuser;
  // }

  public UniteImmo getUnite() {
    return unite;
  }

  public void setUnite(UniteImmo unite) {
    this.unite = unite;
  }

  @XmlTransient
  public List<Pv> getPvList() {
    return pvList;
  }

  public void setPvList(List<Pv> pvList) {
    this.pvList = pvList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dossierid != null ? dossierid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Dossier)) {
      return false;
    }
    Dossier other = (Dossier) object;
    if ((this.dossierid == null && other.dossierid != null)
        || (this.dossierid != null && !this.dossierid.equals(other.dossierid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Dossier[ dossierid=" + dossierid + " ]";
  }

}
