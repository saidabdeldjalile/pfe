/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class Balance312pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;

  public Balance312pPK() {}

  public Balance312pPK(int dateTrt, String cptScf, String cptPart) {
    this.dateTrt = dateTrt;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    hash += (cptPart != null ? cptPart.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance312pPK)) {
      return false;
    }
    Balance312pPK other = (Balance312pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptScf == null && other.cptScf != null)
        || (this.cptScf != null && !this.cptScf.equals(other.cptScf))) {
      return false;
    }
    if ((this.cptPart == null && other.cptPart != null)
        || (this.cptPart != null && !this.cptPart.equals(other.cptPart))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance312pPK[ dateTrt=" + dateTrt + ", cptScf=" + cptScf + ", cptPart="
        + cptPart + " ]";
  }

}
