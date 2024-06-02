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
public class VueMvtsPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn")
  private String pn;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "numBon")
  private String numBon;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTrait")
  private int dateTrait;

  public VueMvtsPK() {}

  public VueMvtsPK(String pn, String codeAppareil, String numBon, int dateTrait) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.numBon = numBon;
    this.dateTrait = dateTrait;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public String getNumBonAchat() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public int getDateTrait() {
    return dateTrait;
  }

  public void setDateTraitAchat(int dateTrait) {
    this.dateTrait = dateTrait;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pn != null ? pn.hashCode() : 0);
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (numBon != null ? numBon.hashCode() : 0);
    hash += (int) dateTrait;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VueMvtsPK)) {
      return false;
    }
    VueMvtsPK other = (VueMvtsPK) object;
    if ((this.pn == null && other.pn != null) || (this.pn != null && !this.pn.equals(other.pn))) {
      return false;
    }
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.numBon == null && other.numBon != null)
        || (this.numBon != null && !this.numBon.equals(other.numBon))) {
      return false;
    }
    if (this.dateTrait != other.dateTrait) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.VueMvtsPK[ pn=" + pn + ", codeAppareil=" + codeAppareil
        + ", numBon=" + numBon + ", dateTrait=" + dateTrait + " ]";
  }

}
