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
public class ArticleReperePK implements Serializable {
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
  @Size(min = 1, max = 15)
  @Column(name = "codeRepere")
  private String codeRepere;

  public ArticleReperePK() {}

  public ArticleReperePK(String pn, String codeAppareil, String codeRepere) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.codeRepere = codeRepere;
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

  public String getCodeRepere() {
    return codeRepere;
  }

  public void setCodeRepere(String codeRepere) {
    this.codeRepere = codeRepere;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pn != null ? pn.hashCode() : 0);
    hash += (codeAppareil != null ? codeAppareil.hashCode() : 0);
    hash += (codeRepere != null ? codeRepere.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleReperePK)) {
      return false;
    }
    ArticleReperePK other = (ArticleReperePK) object;
    if ((this.pn == null && other.pn != null) || (this.pn != null && !this.pn.equals(other.pn))) {
      return false;
    }
    if ((this.codeAppareil == null && other.codeAppareil != null)
        || (this.codeAppareil != null && !this.codeAppareil.equals(other.codeAppareil))) {
      return false;
    }
    if ((this.codeRepere == null && other.codeRepere != null)
        || (this.codeRepere != null && !this.codeRepere.equals(other.codeRepere))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleReperePK[ pn=" + pn + ", codeAppareil=" + codeAppareil
        + ", codeRepere=" + codeRepere + " ]";
  }

}
