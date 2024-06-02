/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Embeddable
public class GrpChapPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "COMPTE_ANAL")
  private String compteAnal;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDeb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateFin;

  public GrpChapPK() {}

  public GrpChapPK(String compteAnal, String grpChap, Date dateDeb, Date dateFin) {
    this.compteAnal = compteAnal;
    this.grpChap = grpChap;
    this.dateDeb = dateDeb;
    this.dateFin = dateFin;
  }

  public String getCompteAnal() {
    return compteAnal;
  }

  public void setCompteAnal(String compteAnal) {
    this.compteAnal = compteAnal;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (compteAnal != null ? compteAnal.hashCode() : 0);
    hash += (grpChap != null ? grpChap.hashCode() : 0);
    hash += (dateDeb != null ? dateDeb.hashCode() : 0);
    hash += (dateFin != null ? dateFin.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GrpChapPK)) {
      return false;
    }
    GrpChapPK other = (GrpChapPK) object;
    if ((this.compteAnal == null && other.compteAnal != null)
        || (this.compteAnal != null && !this.compteAnal.equals(other.compteAnal))) {
      return false;
    }
    if ((this.grpChap == null && other.grpChap != null)
        || (this.grpChap != null && !this.grpChap.equals(other.grpChap))) {
      return false;
    }
    if ((this.dateDeb == null && other.dateDeb != null)
        || (this.dateDeb != null && !this.dateDeb.equals(other.dateDeb))) {
      return false;
    }
    if ((this.dateFin == null && other.dateFin != null)
        || (this.dateFin != null && !this.dateFin.equals(other.dateFin))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.GrpChapPK[ compteAnal=" + compteAnal + ", grpChap=" + grpChap + ", dateDeb="
        + dateDeb + ", dateFin=" + dateFin + " ]";
  }

}
