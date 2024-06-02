/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kemikem
 */
@Embeddable
public class BonachatPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUMBA")
  private int numba;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATEACHAT")
  @Temporal(TemporalType.DATE)
  private Date dateachat;

  public BonachatPK() {}

  public BonachatPK(int numba, Date dateachat) {
    this.numba = numba;
    this.dateachat = dateachat;
  }

  public int getNumba() {
    return numba;
  }

  public void setNumba(int numba) {
    this.numba = numba;
  }

  public Date getDateachat() {
    return dateachat;
  }

  public void setDateachat(Date dateachat) {
    this.dateachat = dateachat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) numba;
    hash += (dateachat != null ? dateachat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonachatPK)) {
      return false;
    }
    BonachatPK other = (BonachatPK) object;
    if (this.numba != other.numba) {
      return false;
    }
    if ((this.dateachat == null && other.dateachat != null)
        || (this.dateachat != null && !this.dateachat.equals(other.dateachat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.BonachatPK[ numba=" + numba + ", dateachat=" + dateachat + " ]";
  }

}
