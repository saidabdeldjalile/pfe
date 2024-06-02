/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class CompteCaePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB")
  @Temporal(TemporalType.DATE)
  private Date dateDeb;

  public CompteCaePK() {}

  public CompteCaePK(String cptPart, Date dateDeb) {
    this.cptPart = cptPart;
    this.dateDeb = dateDeb;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cptPart != null ? cptPart.hashCode() : 0);
    hash += (dateDeb != null ? dateDeb.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CompteCaePK)) {
      return false;
    }
    CompteCaePK other = (CompteCaePK) object;
    if ((this.cptPart == null && other.cptPart != null)
        || (this.cptPart != null && !this.cptPart.equals(other.cptPart))) {
      return false;
    }
    if ((this.dateDeb == null && other.dateDeb != null)
        || (this.dateDeb != null && !this.dateDeb.equals(other.dateDeb))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.bean.journal.CompteCaePK[ cptPart=" + cptPart + ", dateDeb=" + dateDeb
        + " ]";
  }

}
