/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "FRM", name = "NIVEAU")
public class Niveau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE")
  private Date date;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_NIV", referencedColumnName = "CODE_NIV")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private RefNiveau refNiveau;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Niveau() {}

  public Niveau(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public RefNiveau getRefNiveau() {
    return refNiveau;
  }

  public void setRefNiveau(RefNiveau refNiveau) {
    this.refNiveau = refNiveau;
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
    if (!(object instanceof Niveau)) {
      return false;
    }
    Niveau other = (Niveau) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Niveau[ matricule=" + matricule + " ]";
  }

}
