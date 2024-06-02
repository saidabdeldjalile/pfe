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
public class CptePrestationPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_PRE")
  private int codePre;

  public CptePrestationPK() {}

  public CptePrestationPK(int dateTrt, int codePre) {
    this.dateTrt = dateTrt;
    this.codePre = codePre;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getCodePre() {
    return codePre;
  }

  public void setCodePre(int codePre) {
    this.codePre = codePre;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (int) codePre;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CptePrestationPK)) {
      return false;
    }
    CptePrestationPK other = (CptePrestationPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.codePre != other.codePre) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CptePrestationPK[ dateTrt=" + dateTrt + ", codePre=" + codePre + " ]";
  }

}
