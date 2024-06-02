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
public class BalanceA340pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "CPT_PART_4")
  private String cptPart4;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;

  public BalanceA340pPK() {}

  public BalanceA340pPK(int dateTrt, String cptPart4, String cptScf) {
    this.dateTrt = dateTrt;
    this.cptPart4 = cptPart4;
    this.cptScf = cptScf;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptPart4() {
    return cptPart4;
  }

  public void setCptPart4(String cptPart4) {
    this.cptPart4 = cptPart4;
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
    hash += (cptPart4 != null ? cptPart4.hashCode() : 0);
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA340pPK)) {
      return false;
    }
    BalanceA340pPK other = (BalanceA340pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.cptPart4 == null && other.cptPart4 != null)
        || (this.cptPart4 != null && !this.cptPart4.equals(other.cptPart4))) {
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
    return "ENTITY.BalanceA340pPK[ dateTrt=" + dateTrt + ", cptPart4=" + cptPart4 + ", cptScf="
        + cptScf + " ]";
  }

}
