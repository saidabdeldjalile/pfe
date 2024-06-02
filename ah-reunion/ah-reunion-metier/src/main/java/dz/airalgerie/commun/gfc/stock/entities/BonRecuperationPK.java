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
public class BonRecuperationPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBonRecup")
  private String numBonRecup;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitRecup")
  private int dateTraitRecup;

  public BonRecuperationPK() {}

  public BonRecuperationPK(String numBonRecup, int dateTraitRecup) {
    this.numBonRecup = numBonRecup;
    this.dateTraitRecup = dateTraitRecup;
  }

  public String getNumBonRecup() {
    return numBonRecup;
  }

  public void setNumBonRecup(String numBonRecup) {
    this.numBonRecup = numBonRecup;
  }

  public int getDateTraitRecup() {
    return dateTraitRecup;
  }

  public void setDateTraitRecup(int dateTraitRecup) {
    this.dateTraitRecup = dateTraitRecup;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numBonRecup != null ? numBonRecup.hashCode() : 0);
    hash += (int) dateTraitRecup;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonRecuperationPK)) {
      return false;
    }
    BonRecuperationPK other = (BonRecuperationPK) object;
    if ((this.numBonRecup == null && other.numBonRecup != null)
        || (this.numBonRecup != null && !this.numBonRecup.equals(other.numBonRecup))) {
      return false;
    }
    if (this.dateTraitRecup != other.dateTraitRecup) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonRecuperationPK[ numBonRecup=" + numBonRecup
        + ", dateTraitRecup=" + dateTraitRecup + " ]";
  }

}
