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
public class BalanceA320pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CPT_PART_2")
  private String cptPart2;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;

  public BalanceA320pPK() {}

  public BalanceA320pPK(int dateTrt, String cptPart2, String cptScf) {
    this.dateTrt = dateTrt;
    this.cptPart2 = cptPart2;
    this.cptScf = cptScf;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptPart2() {
    return cptPart2;
  }

  public void setCptPart2(String cptPart2) {
    this.cptPart2 = cptPart2;
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
    hash += (cptPart2 != null ? cptPart2.hashCode() : 0);
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA320pPK)) {
      return false;
    }
    BalanceA320pPK other = (BalanceA320pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart2 == null && other.cptPart2 != null)
        || (this.cptPart2 != null && !this.cptPart2.equals(other.cptPart2))) {
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
    return "ENTITY.BalanceA320pPK[ dateTrt=" + dateTrt + ", cptPart2=" + cptPart2 + ", cptScf="
        + cptScf + " ]";
  }

}
