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
public class CloturePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitCloture")
  private int dateTraitCloture;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "typeEngin")
  private String typeEngin;

  public CloturePK() {}

  public CloturePK(int dateTraitCloture, String typeEngin) {
    this.dateTraitCloture = dateTraitCloture;
    this.typeEngin = typeEngin;
  }

  public int getDateTraitCloture() {
    return dateTraitCloture;
  }

  public void setDateTraitCloture(int dateTraitCloture) {
    this.dateTraitCloture = dateTraitCloture;
  }

  public String getTypeEngin() {
    return typeEngin;
  }

  public void setTypeEngin(String typeEngin) {
    this.typeEngin = typeEngin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTraitCloture;
    hash += (typeEngin != null ? typeEngin.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CloturePK)) {
      return false;
    }
    CloturePK other = (CloturePK) object;
    if (this.dateTraitCloture != other.dateTraitCloture) {
      return false;
    }
    if ((this.typeEngin == null && other.typeEngin != null)
        || (this.typeEngin != null && !this.typeEngin.equals(other.typeEngin))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.CloturePK[ dateTraitCloture=" + dateTraitCloture
        + ", typeEngin=" + typeEngin + " ]";
  }

}
