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
public class AppareilPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "typeStock")
  private String typeStock;

  public AppareilPK() {}

  public AppareilPK(String codeAppareil, String typeStock) {
    this.codeAppareil = codeAppareil;
    this.typeStock = typeStock;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public String getTypeStock() {
    return typeStock;
  }

  public void setTypeStock(String typeStock) {
    this.typeStock = typeStock;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (typeStock != null ? typeStock.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AppareilPK)) {
      return false;
    }
    AppareilPK other = (AppareilPK) object;
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.typeStock == null && other.typeStock != null)
        || (this.typeStock != null && !this.typeStock.equals(other.typeStock))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.AppareilPK[ codeAppareil=" + codeAppareil + ", typeStock="
        + typeStock + " ]";
  }

}
