/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

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
public class BalanceA360pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;

  public BalanceA360pPK() {}

  public BalanceA360pPK(int dateTrt, String cptPart, String cptScf) {
    this.dateTrt = dateTrt;
    this.cptPart = cptPart;
    this.cptScf = cptScf;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (cptPart != null ? cptPart.hashCode() : 0);
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA360pPK)) {
      return false;
    }
    BalanceA360pPK other = (BalanceA360pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart == null && other.cptPart != null)
        || (this.cptPart != null && !this.cptPart.equals(other.cptPart))) {
      return false;
    }
    if ((this.cptScf == null && other.cptScf != null)
        || (this.cptScf != null && !this.cptScf.equals(other.cptScf))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA360pPK[ dateTrt=" + dateTrt + ", cptPart=" + cptPart + ", cptScf="
        + cptScf + " ]";
  }

}