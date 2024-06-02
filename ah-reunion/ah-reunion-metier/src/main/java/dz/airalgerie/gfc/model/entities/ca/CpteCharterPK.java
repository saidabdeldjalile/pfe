/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class CpteCharterPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE")
  private short numLigne;

  public CpteCharterPK() {}

  public CpteCharterPK(int dateTrt, short numLigne) {
    this.dateTrt = dateTrt;
    this.numLigne = numLigne;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (int) numLigne;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteCharterPK)) {
      return false;
    }
    CpteCharterPK other = (CpteCharterPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.numLigne != other.numLigne) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteCharterPK[ dateTrt=" + dateTrt + ", numLigne=" + numLigne + " ]";
  }

}
