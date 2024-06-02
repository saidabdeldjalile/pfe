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
public class BonAchatPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBonAchat")
  private String numBonAchat;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitAchat")
  private int dateTraitAchat;

  public BonAchatPK() {}

  public BonAchatPK(String numBonAchat, int dateTraitAchat) {
    this.numBonAchat = numBonAchat;
    this.dateTraitAchat = dateTraitAchat;
  }

  public String getNumBonAchat() {
    return numBonAchat;
  }

  public void setNumBonAchat(String numBonAchat) {
    this.numBonAchat = numBonAchat;
  }

  public int getDateTraitAchat() {
    return dateTraitAchat;
  }

  public void setDateTraitAchat(int dateTraitAchat) {
    this.dateTraitAchat = dateTraitAchat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numBonAchat != null ? numBonAchat.hashCode() : 0);
    hash += (int) dateTraitAchat;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonAchatPK)) {
      return false;
    }
    BonAchatPK other = (BonAchatPK) object;
    if ((this.numBonAchat == null && other.numBonAchat != null)
        || (this.numBonAchat != null && !this.numBonAchat.equals(other.numBonAchat))) {
      return false;
    }
    if (this.dateTraitAchat != other.dateTraitAchat) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonAchatPK[ numBonAchat=" + numBonAchat + ", dateTraitAchat="
        + dateTraitAchat + " ]";
  }

}
