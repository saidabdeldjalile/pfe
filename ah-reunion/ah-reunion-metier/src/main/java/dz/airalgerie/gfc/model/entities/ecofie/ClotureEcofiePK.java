/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kehli
 */
@Embeddable
public class ClotureEcofiePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_TRT")
  private int anneeTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TRIMESTRE_TRT")
  private int trimestreTrt;

  public ClotureEcofiePK() {
  }

  public ClotureEcofiePK(int anneeTrt, int trimesterTrt) {
    this.anneeTrt = anneeTrt;
    this.trimestreTrt = trimesterTrt;
  }

  public int getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(int anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public int getTrimestreTrt() {
    return trimestreTrt;
  }

  public void setTrimestreTrt(int trimestreTrt) {
    this.trimestreTrt = trimestreTrt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) anneeTrt;
    hash += (int) trimestreTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClotureEcofiePK)) {
      return false;
    }
    ClotureEcofiePK other = (ClotureEcofiePK) object;
    if (this.anneeTrt != other.anneeTrt) {
      return false;
    }
    if (this.trimestreTrt != other.trimestreTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.ecofie.ClotureEcofiePK[ anneeTrt=" + anneeTrt
        + ", trimesterTrt=" + trimestreTrt + " ]";
  }

}
