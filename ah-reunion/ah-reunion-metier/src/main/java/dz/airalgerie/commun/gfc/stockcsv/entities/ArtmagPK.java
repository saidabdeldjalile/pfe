/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kemikem
 */
@Embeddable
public class ArtmagPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "CODEPN")
  private String codepn;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODEMAG")
  private int codemag;

  public ArtmagPK() {}

  public ArtmagPK(String codepn, int codemag) {
    this.codepn = codepn;
    this.codemag = codemag;
  }

  public String getCodepn() {
    return codepn;
  }

  public void setCodepn(String codepn) {
    this.codepn = codepn;
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
    hash += (codepn != null ? codepn.hashCode() : 0);
    hash += (int) codemag;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArtmagPK)) {
      return false;
    }
    ArtmagPK other = (ArtmagPK) object;
    if ((this.codepn == null && other.codepn != null)
        || (this.codepn != null && !this.codepn.equals(other.codepn))) {
      return false;
    }
    if (this.codemag != other.codemag) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.ArtmagPK[ codepn=" + codepn + ", codemag=" + codemag + " ]";
  }

}
