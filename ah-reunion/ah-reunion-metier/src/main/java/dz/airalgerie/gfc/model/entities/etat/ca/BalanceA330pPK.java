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
public class BalanceA330pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CPT_PART_3")
  private String cptPart3;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;

  public BalanceA330pPK() {}

  public BalanceA330pPK(int dateTrt, String cptPart3, String cptScf) {
    this.dateTrt = dateTrt;
    this.cptPart3 = cptPart3;
    this.cptScf = cptScf;
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
    hash += (cptPart3 != null ? cptPart3.hashCode() : 0);
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA330pPK)) {
      return false;
    }
    BalanceA330pPK other = (BalanceA330pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart3 == null && other.cptPart3 != null)
        || (this.cptPart3 != null && !this.cptPart3.equals(other.cptPart3))) {
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
    return "ENTITY.BalanceA330pPK[ dateTrt=" + dateTrt + ", cptPart3=" + cptPart3 + ", cptScf="
        + cptScf + " ]";
  }

}
