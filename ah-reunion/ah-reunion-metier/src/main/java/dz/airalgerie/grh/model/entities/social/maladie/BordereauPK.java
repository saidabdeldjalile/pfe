/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
public class BordereauPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  // @Size(min = 1, max = 6)
  @Column(name = "NUM_CHEQUE")
  private String numCheque;
  @Basic(optional = false)
  @NotNull
  // @Size(min = 1, max = 4)
  @Column(name = "NUM_BDX")
  private String numBdx;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;

  public BordereauPK() {}

  public BordereauPK(String numCheque, String numBdx, int datePai) {
    this.numCheque = numCheque;
    this.numBdx = numBdx;
    this.datePai = datePai;
  }

  public String getNumCheque() {
    return numCheque;
  }

  public void setNumCheque(String numCheque) {
    this.numCheque = numCheque;
  }

  public String getNumBdx() {
    return numBdx;
  }

  public void setNumBdx(String numBdx) {
    this.numBdx = numBdx;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numCheque != null ? numCheque.hashCode() : 0);
    hash += (numBdx != null ? numBdx.hashCode() : 0);
    hash += (int) datePai;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BordereauPK)) {
      return false;
    }
    BordereauPK other = (BordereauPK) object;
    if ((this.numCheque == null && other.numCheque != null)
        || (this.numCheque != null && !this.numCheque.equals(other.numCheque))) {
      return false;
    }
    if ((this.numBdx == null && other.numBdx != null)
        || (this.numBdx != null && !this.numBdx.equals(other.numBdx))) {
      return false;
    }
    if (this.datePai != other.datePai) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.BordereauPK[ numCheque=" + numCheque + ", numBdx=" + numBdx
        + ", datePai=" + datePai + " ]";
  }

}
