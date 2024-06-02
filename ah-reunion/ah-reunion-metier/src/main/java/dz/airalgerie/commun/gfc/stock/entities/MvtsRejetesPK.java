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
public class MvtsRejetesPK implements Serializable {
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
  @Column(name = "numBonSortie")
  private String numBonSortie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitSortie")
  private int dateTraitSortie;

  public MvtsRejetesPK() {}

  public MvtsRejetesPK(String pn, String codeAppareil, String numBonSortie, int dateTraitSortie) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.numBonSortie = numBonSortie;
    this.dateTraitSortie = dateTraitSortie;
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

  public String getNumBonSortie() {
    return numBonSortie;
  }

  public void setNumBonSortie(String numBonSortie) {
    this.numBonSortie = numBonSortie;
  }

  public int getDateTraitSortie() {
    return dateTraitSortie;
  }

  public void setDateTraitSortie(int dateTraitSortie) {
    this.dateTraitSortie = dateTraitSortie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pn != null ? pn.hashCode() : 0);
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (numBonSortie != null ? numBonSortie.hashCode() : 0);
    hash += (int) dateTraitSortie;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MvtsRejetesPK)) {
      return false;
    }
    MvtsRejetesPK other = (MvtsRejetesPK) object;
    if ((this.pn == null && other.pn != null) || (this.pn != null && !this.pn.equals(other.pn))) {
      return false;
    }
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.numBonSortie == null && other.numBonSortie != null)
        || (this.numBonSortie != null && !this.numBonSortie.equals(other.numBonSortie))) {
      return false;
    }
    if (this.dateTraitSortie != other.dateTraitSortie) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.MvtsRejetesPK[ pn=" + pn + ", codeAppareil=" + codeAppareil
        + ", numBonSortie=" + numBonSortie + ", dateTraitSortie=" + dateTraitSortie + " ]";
  }

}
