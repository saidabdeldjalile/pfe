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
public class BalanceA320pTtPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CPT_PART_2")
  private String cptPart2;

  public BalanceA320pTtPK() {}

  public BalanceA320pTtPK(int dateTrt, String cptPart2) {
    this.dateTrt = dateTrt;
    this.cptPart2 = cptPart2;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (cptPart2 != null ? cptPart2.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA320pTtPK)) {
      return false;
    }
    BalanceA320pTtPK other = (BalanceA320pTtPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart2 == null && other.cptPart2 != null)
        || (this.cptPart2 != null && !this.cptPart2.equals(other.cptPart2))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA320pTtPK[ dateTrt=" + dateTrt + ", cptPart2=" + cptPart2 + " ]";
  }

}
