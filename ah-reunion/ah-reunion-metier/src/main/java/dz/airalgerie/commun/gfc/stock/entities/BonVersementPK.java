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
public class BonVersementPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBonVers")
  private String numBonVers;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitVers")
  private int dateTraitVers;

  public BonVersementPK() {}

  public BonVersementPK(String numBonVers, int dateTraitVers) {
    this.numBonVers = numBonVers;
    this.dateTraitVers = dateTraitVers;
  }

  public String getNumBonVers() {
    return numBonVers;
  }

  public void setNumBonVers(String numBonVers) {
    this.numBonVers = numBonVers;
  }

  public int getDateTraitVers() {
    return dateTraitVers;
  }

  public void setDateTraitVers(int dateTraitVers) {
    this.dateTraitVers = dateTraitVers;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numBonVers != null ? numBonVers.hashCode() : 0);
    hash += (int) dateTraitVers;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonVersementPK)) {
      return false;
    }
    BonVersementPK other = (BonVersementPK) object;
    if ((this.numBonVers == null && other.numBonVers != null)
        || (this.numBonVers != null && !this.numBonVers.equals(other.numBonVers))) {
      return false;
    }
    if (this.dateTraitVers != other.dateTraitVers) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonVersementPK[ numBonVers=" + numBonVers + ", dateTraitVers="
        + dateTraitVers + " ]";
  }

}
