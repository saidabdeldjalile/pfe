/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kemikem
 */
@Embeddable
public class RepairePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "CODEREP")
  private String coderep;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODEMAG")
  private int codemag;

  @Transient
  private String old;

  public String getOld() {
    return old;
  }

  public void setOld(String old) {
    this.old = old;
  }

  public RepairePK() {}

  public RepairePK(String coderep, int codemag) {
    this.coderep = coderep;
    this.codemag = codemag;
  }

  // ----------rajout pour repere
  public String getCoderep() {
    if (old == null)
      old = coderep;
    // System.out.println("old "+old);
    return coderep;
  }

  public void setCoderep(String coderep) {
    this.coderep = coderep;
  }

  public int getCodemag() {
    return codemag;
  }

  public void setCodemag(int codemag) {
    this.codemag = codemag;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (coderep != null ? coderep.hashCode() : 0);
    hash += (int) codemag;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RepairePK)) {
      return false;
    }
    RepairePK other = (RepairePK) object;
    if ((this.coderep == null && other.coderep != null)
        || (this.coderep != null && !this.coderep.equals(other.coderep))) {
      return false;
    }
    if (this.codemag != other.codemag) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.RepairePK[ coderep=" + coderep + ", codemag=" + codemag + " ]";
  }

}
