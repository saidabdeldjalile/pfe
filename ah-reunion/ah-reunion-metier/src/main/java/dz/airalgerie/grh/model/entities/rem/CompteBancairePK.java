/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kemikem
 */
@Embeddable
public class CompteBancairePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB")
  @Temporal(TemporalType.DATE)
  private Date dateDeb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "IS_DEVISE")
  private boolean isDevise;

  public CompteBancairePK() {}

  public CompteBancairePK(int matricule, Date dateDeb, boolean isDevise) {
    this.matricule = matricule;
    this.dateDeb = dateDeb;
    this.isDevise = isDevise;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  public boolean getIsDevise() {
    return isDevise;
  }

  public void setIsDevise(boolean isDevise) {
    this.isDevise = isDevise;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (dateDeb != null ? dateDeb.hashCode() : 0);
    hash += (isDevise ? 1 : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CompteBancairePK)) {
      return false;
    }
    CompteBancairePK other = (CompteBancairePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.dateDeb == null && other.dateDeb != null)
        || (this.dateDeb != null && !this.dateDeb.equals(other.dateDeb))) {
      return false;
    }
    if (this.isDevise != other.isDevise) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.CompteBancairePK[ matricule=" + matricule + ", dateDeb=" + dateDeb
        + ", isDevise=" + isDevise + " ]";
  }

}
