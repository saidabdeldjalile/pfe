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
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class Trp214pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "NUM_LIGNE")
  private String numLigne;

  public Trp214pPK() {}

  public Trp214pPK(int dateTrt, String numLigne) {
    this.dateTrt = dateTrt;
    this.numLigne = numLigne;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(String numLigne) {
    this.numLigne = numLigne;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (numLigne != null ? numLigne.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Trp214pPK)) {
      return false;
    }
    Trp214pPK other = (Trp214pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.numLigne == null && other.numLigne != null)
        || (this.numLigne != null && !this.numLigne.equals(other.numLigne))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.Trp214pPK[ dateTrt=" + dateTrt + ", numLigne=" + numLigne + " ]";
  }

}
