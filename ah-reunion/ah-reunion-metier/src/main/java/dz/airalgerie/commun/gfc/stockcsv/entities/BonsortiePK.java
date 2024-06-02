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
public class BonsortiePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUMBS")
  private int numbs;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATESORTIE")
  @Temporal(TemporalType.DATE)
  private Date datesortie;
  // rajouter le 23062019 par kemikem
  // @Basic(optional = false)
  // @NotNull
  // @Column(name = "CODEMAG")
  // private int codemag;

  public BonsortiePK() {}

  public BonsortiePK(int numbs, Date datesortie) {
    this.numbs = numbs;
    this.datesortie = datesortie;
  }

  public int getNumbs() {
    return numbs;
  }

  public void setNumbs(int numbs) {
    this.numbs = numbs;
  }

  public Date getDatesortie() {
    return datesortie;
  }

  public void setDatesortie(Date datesortie) {
    this.datesortie = datesortie;
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
    hash += (int) numbs;
    hash += (datesortie != null ? datesortie.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonsortiePK)) {
      return false;
    }
    BonsortiePK other = (BonsortiePK) object;
    if (this.numbs != other.numbs) {
      return false;
    }
    if ((this.datesortie == null && other.datesortie != null)
        || (this.datesortie != null && !this.datesortie.equals(other.datesortie))) {
      return false;
    }
    // if (this.codemag != other.codemag) {
    // return false;
    // }

    return true;
  }

  @Override
  public String toString() {
    return "Entite.BonsortiePK[ numbs=" + numbs + ", datesortie=" + datesortie + " ]";
  }

}
