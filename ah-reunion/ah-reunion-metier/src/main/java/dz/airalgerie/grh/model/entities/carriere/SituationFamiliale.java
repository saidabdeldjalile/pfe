/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
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

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "SIT_FAMILIALE")
public class SituationFamiliale implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected SituationFamilialePK sitFamilialePK;
  @Column(name = "CODE_ITS")
  private Short codeIts;
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_CIV", referencedColumnName = "CODE_CIV")
  @ManyToOne(fetch = FetchType.LAZY)
  private Civile civile;

  public SituationFamiliale() {}

  public SituationFamiliale(SituationFamilialePK sitFamilialePK) {
    this.sitFamilialePK = sitFamilialePK;
  }

  public SituationFamiliale(SituationFamilialePK sitFamilialePK, Date dateFin) {
    this.sitFamilialePK = sitFamilialePK;
    this.dateFin = dateFin;
  }

  public SituationFamiliale(int matricule, Date dateDeb) {
    this.sitFamilialePK = new SituationFamilialePK(matricule, dateDeb);
  }

  public SituationFamilialePK getSitFamilialePK() {
    return sitFamilialePK;
  }

  public void setSitFamilialePK(SituationFamilialePK sitFamilialePK) {
    this.sitFamilialePK = sitFamilialePK;
  }

  public Short getCodeIts() {
    return codeIts;
  }

  public void setCodeIts(Short codeIts) {
    this.codeIts = codeIts;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Civile getCivile() {
    return civile;
  }

  public void setCivile(Civile civile) {
    this.civile = civile;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (sitFamilialePK != null ? sitFamilialePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SituationFamiliale)) {
      return false;
    }
    SituationFamiliale other = (SituationFamiliale) object;
    if ((this.sitFamilialePK == null && other.sitFamilialePK != null)
        || (this.sitFamilialePK != null && !this.sitFamilialePK.equals(other.sitFamilialePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.SituationFamiliale[ sitFamilialePK=" + sitFamilialePK + " ]";
  }

}
