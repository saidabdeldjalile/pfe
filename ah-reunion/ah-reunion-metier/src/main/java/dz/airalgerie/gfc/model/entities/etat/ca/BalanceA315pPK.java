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
public class BalanceA315pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CPT_PART_1")
  private String cptPart1;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;

  public BalanceA315pPK() {}

  public BalanceA315pPK(int dateTrt, String cptPart1, String cptScf) {
    this.dateTrt = dateTrt;
    this.cptPart1 = cptPart1;
    this.cptScf = cptScf;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptPart1() {
    return cptPart1;
  }

  public void setCptPart1(String cptPart1) {
    this.cptPart1 = cptPart1;
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
    hash += (cptPart1 != null ? cptPart1.hashCode() : 0);
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA315pPK)) {
      return false;
    }
    BalanceA315pPK other = (BalanceA315pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart1 == null && other.cptPart1 != null)
        || (this.cptPart1 != null && !this.cptPart1.equals(other.cptPart1))) {
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
    return "ENTITY.BalanceA315pPK[ dateTrt=" + dateTrt + ", cptPart1=" + cptPart1 + ", cptScf="
        + cptScf + " ]";
  }

}