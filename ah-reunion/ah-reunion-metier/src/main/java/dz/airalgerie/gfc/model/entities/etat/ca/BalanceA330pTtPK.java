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
public class BalanceA330pTtPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CPT_PART_3")
  private String cptPart3;

  public BalanceA330pTtPK() {}

  public BalanceA330pTtPK(int dateTrt, String cptPart3) {
    this.dateTrt = dateTrt;
    this.cptPart3 = cptPart3;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptPart3() {
    return cptPart3;
  }

  public void setCptPart3(String cptPart3) {
    this.cptPart3 = cptPart3;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (cptPart3 != null ? cptPart3.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA330pTtPK)) {
      return false;
    }
    BalanceA330pTtPK other = (BalanceA330pTtPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart3 == null && other.cptPart3 != null)
        || (this.cptPart3 != null && !this.cptPart3.equals(other.cptPart3))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA330pTtPK[ dateTrt=" + dateTrt + ", cptPart3=" + cptPart3 + " ]";
  }

}
