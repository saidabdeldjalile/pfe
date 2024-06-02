/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class BonReintegrationPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBonReint")
  private String numBonReint;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitReint")
  private int dateTraitReint;

  public BonReintegrationPK() {}

  public BonReintegrationPK(String numBonReint, int dateTraitReint) {
    this.numBonReint = numBonReint;
    this.dateTraitReint = dateTraitReint;
  }

  public String getNumBonReint() {
    return numBonReint;
  }

  public void setNumBonReint(String numBonReint) {
    this.numBonReint = numBonReint;
  }

  public int getDateTraitReint() {
    return dateTraitReint;
  }

  public void setDateTraitReint(int dateTraitReint) {
    this.dateTraitReint = dateTraitReint;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numBonReint != null ? numBonReint.hashCode() : 0);
    hash += (int) dateTraitReint;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonReintegrationPK)) {
      return false;
    }
    BonReintegrationPK other = (BonReintegrationPK) object;
    if ((this.numBonReint == null && other.numBonReint != null)
        || (this.numBonReint != null && !this.numBonReint.equals(other.numBonReint))) {
      return false;
    }
    if (this.dateTraitReint != other.dateTraitReint) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonReintegrationPK[ numBonReint=" + numBonReint
        + ", dateTraitReint=" + dateTraitReint + " ]";
  }

}
