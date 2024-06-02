/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "ANTECEDENT")
public class Antecedent implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AntecedentPK antecedentPK;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @Size(max = 150)
  @Column(name = "ORGANISME")
  private String organisme;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_SEC", referencedColumnName = "CODE_SEC")
  @ManyToOne(fetch = FetchType.LAZY)
  private Secteur secteur;
  @JoinColumn(name = "RAIS_DEP", referencedColumnName = "RAIS_DEP")
  @ManyToOne(fetch = FetchType.LAZY)
  private RaisonDepart raisonDepart;
  @JoinColumn(name = "CODE_PSTR", referencedColumnName = "CODE_PSTR")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PosteTravail posteTravail;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Antecedent() {}

  public Antecedent(AntecedentPK antecedentPK) {
    this.antecedentPK = antecedentPK;
  }

  public Antecedent(int matricule, Date dateDeb) {
    this.antecedentPK = new AntecedentPK(matricule, dateDeb);
  }

  public AntecedentPK getAntecedentPK() {
    return antecedentPK;
  }

  public void setAntecedentPK(AntecedentPK antecedentPK) {
    this.antecedentPK = antecedentPK;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Secteur getSecteur() {
    return secteur;
  }

  public void setSecteur(Secteur secteur) {
    this.secteur = secteur;
  }

  public RaisonDepart getRaisonDepart() {
    return raisonDepart;
  }

  public void setRaisonDepart(RaisonDepart raisonDepart) {
    this.raisonDepart = raisonDepart;
  }

  public PosteTravail getPosteTravail() {
    return posteTravail;
  }

  public void setPosteTravail(PosteTravail posteTravail) {
    this.posteTravail = posteTravail;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (antecedentPK != null ? antecedentPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Antecedent)) {
      return false;
    }
    Antecedent other = (Antecedent) object;
    if ((this.antecedentPK == null && other.antecedentPK != null)
        || (this.antecedentPK != null && !this.antecedentPK.equals(other.antecedentPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Antecedent[ antecedentPK=" + antecedentPK + " ]";
  }

}
