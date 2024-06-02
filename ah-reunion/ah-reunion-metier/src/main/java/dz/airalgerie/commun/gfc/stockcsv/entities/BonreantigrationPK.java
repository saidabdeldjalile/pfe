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
public class BonreantigrationPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUMBR")
  private int numbr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATERE")
  @Temporal(TemporalType.DATE)
  private Date datere;

  // // rajouter le 23062019 par kemikem
  // @Basic(optional = false)
  // @NotNull
  // @Column(name = "CODEMAG")
  // private int codemag;

  public BonreantigrationPK() {}

  public BonreantigrationPK(int numbr, Date datere) {
    this.numbr = numbr;
    this.datere = datere;
  }

  public int getNumbr() {
    return numbr;
  }

  public void setNumbr(int numbr) {
    this.numbr = numbr;
  }

  public Date getDatere() {
    return datere;
  }

  public void setDatere(Date datere) {
    this.datere = datere;
  }

  // public int getCodemag() {
  // return codemag;
  // }
  //
  // public void setCodemag(int codemag) {
  // this.codemag = codemag;
  // }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) numbr;
    hash += (datere != null ? datere.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonreantigrationPK)) {
      return false;
    }
    BonreantigrationPK other = (BonreantigrationPK) object;
    if (this.numbr != other.numbr) {
      return false;
    }
    if ((this.datere == null && other.datere != null)
        || (this.datere != null && !this.datere.equals(other.datere))) {
      return false;
    }

    // if (this.codemag != other.codemag) {
    // return false;
    // }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.BonreantigrationPK[ numbr=" + numbr + ", datere=" + datere + " ]";
  }

}
