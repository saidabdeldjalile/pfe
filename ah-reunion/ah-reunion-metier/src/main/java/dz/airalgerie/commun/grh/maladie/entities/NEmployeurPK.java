/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

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
public class NEmployeurPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_WIL")
  private int codeWil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_FIL")
  private String codeFil;

  public NEmployeurPK() {}

  public NEmployeurPK(int codeWil, String codeFil) {
    this.codeWil = codeWil;
    this.codeFil = codeFil;
  }

  public int getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(int codeWil) {
    this.codeWil = codeWil;
  }

  public String getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) codeWil;
    hash += (codeFil != null ? codeFil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof NEmployeurPK)) {
      return false;
    }
    NEmployeurPK other = (NEmployeurPK) object;
    if (this.codeWil != other.codeWil) {
      return false;
    }
    if ((this.codeFil == null && other.codeFil != null)
        || (this.codeFil != null && !this.codeFil.equals(other.codeFil))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.NEmployeurPK[ codeWil=" + codeWil + ", codeFil=" + codeFil + " ]";
  }

}
