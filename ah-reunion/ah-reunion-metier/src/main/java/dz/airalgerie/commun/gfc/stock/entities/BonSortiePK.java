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
public class BonSortiePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBonSortie")
  private String numBonSortie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitSortie")
  private int dateTraitSortie;

  public BonSortiePK() {}

  public BonSortiePK(String numBonSortie, int dateTraitSortie) {
    this.numBonSortie = numBonSortie;
    this.dateTraitSortie = dateTraitSortie;
  }

  public String getNumBonSortie() {
    return numBonSortie;
  }

  public void setNumBonSortie(String numBonSortie) {
    this.numBonSortie = numBonSortie;
  }

  public int getDateTraitSortie() {
    return dateTraitSortie;
  }

  public void setDateTraitSortie(int dateTraitSortie) {
    this.dateTraitSortie = dateTraitSortie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numBonSortie != null ? numBonSortie.hashCode() : 0);
    hash += (int) dateTraitSortie;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonSortiePK)) {
      return false;
    }
    BonSortiePK other = (BonSortiePK) object;
    if ((this.numBonSortie == null && other.numBonSortie != null)
        || (this.numBonSortie != null && !this.numBonSortie.equals(other.numBonSortie))) {
      return false;
    }
    if (this.dateTraitSortie != other.dateTraitSortie) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonSortiePK[ numBonSortie=" + numBonSortie
        + ", dateTraitSortie=" + dateTraitSortie + " ]";
  }

}
