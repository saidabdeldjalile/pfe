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
public class ArticleVersementPK implements Serializable {
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
  @Column(name = "numBonVers")
  private String numBonVers;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitVers")
  private int dateTraitVers;

  public ArticleVersementPK() {}

  public ArticleVersementPK(String pn, String codeAppareil, String numBonVers, int dateTraitVers) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.numBonVers = numBonVers;
    this.dateTraitVers = dateTraitVers;
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

  public String getNumBonVers() {
    return numBonVers;
  }

  public void setNumBonVers(String numBonVers) {
    this.numBonVers = numBonVers;
  }

  public int getDateTraitVers() {
    return dateTraitVers;
  }

  public void setDateTraitVers(int dateTraitVers) {
    this.dateTraitVers = dateTraitVers;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pn != null ? pn.hashCode() : 0);
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (numBonVers != null ? numBonVers.hashCode() : 0);
    hash += (int) dateTraitVers;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleVersementPK)) {
      return false;
    }
    ArticleVersementPK other = (ArticleVersementPK) object;
    if ((this.pn == null && other.pn != null) || (this.pn != null && !this.pn.equals(other.pn))) {
      return false;
    }
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.numBonVers == null && other.numBonVers != null)
        || (this.numBonVers != null && !this.numBonVers.equals(other.numBonVers))) {
      return false;
    }
    if (this.dateTraitVers != other.dateTraitVers) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleVersementPK[ pn=" + pn + ", codeAppareil="
        + codeAppareil + ", numBonVers=" + numBonVers + ", dateTraitVers=" + dateTraitVers + " ]";
  }

}