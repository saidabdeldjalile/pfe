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
public class ArticleReintegrationPK implements Serializable {
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
  @Column(name = "numBonReint")
  private String numBonReint;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitReint")
  private int dateTraitReint;

  public ArticleReintegrationPK() {}

  public ArticleReintegrationPK(String pn, String codeAppareil, String numBonReint,
      int dateTraitReint) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.numBonReint = numBonReint;
    this.dateTraitReint = dateTraitReint;
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

  public String getNumBonReint() {
    return numBonReint;
  }

  public void setNumBonReint(String numBonReint) {
    this.numBonReint = numBonReint;
  }

  public int getDateTraitReint() {
    return dateTraitReint;
  }

  public void setDateTraitReint(int dateTraitReint) {
    this.dateTraitReint = dateTraitReint;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pn != null ? pn.hashCode() : 0);
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (numBonReint != null ? numBonReint.hashCode() : 0);
    hash += (int) dateTraitReint;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleReintegrationPK)) {
      return false;
    }
    ArticleReintegrationPK other = (ArticleReintegrationPK) object;
    if ((this.pn == null && other.pn != null) || (this.pn != null && !this.pn.equals(other.pn))) {
      return false;
    }
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.numBonReint == null && other.numBonReint != null)
        || (this.numBonReint != null && !this.numBonReint.equals(other.numBonReint))) {
      return false;
    }
    if (this.dateTraitReint != other.dateTraitReint) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleReintegrationPK[ pn=" + pn + ", codeAppareil="
        + codeAppareil + ", numBonReint=" + numBonReint + ", dateTraitReint=" + dateTraitReint
        + " ]";
  }

}
