/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class CentreComptablePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_CENTRE_CPT")
  private String codeCentreCpt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_DIR")
  private String codeDir;

  public CentreComptablePK() {}

  public CentreComptablePK(String codeCentreCpt, String codeDir) {
    this.codeCentreCpt = codeCentreCpt;
    this.codeDir = codeDir;
  }

  public String getCodeCentreCpt() {
    return codeCentreCpt;
  }

  public void setCodeCentreCpt(String codeCentreCpt) {
    this.codeCentreCpt = codeCentreCpt;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeCentreCpt != null ? codeCentreCpt.hashCode() : 0);
    hash += (codeDir != null ? codeDir.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CentreComptablePK)) {
      return false;
    }
    CentreComptablePK other = (CentreComptablePK) object;
    if ((this.codeCentreCpt == null && other.codeCentreCpt != null)
        || (this.codeCentreCpt != null && !this.codeCentreCpt.equals(other.codeCentreCpt))) {
      return false;
    }
    if ((this.codeDir == null && other.codeDir != null)
        || (this.codeDir != null && !this.codeDir.equals(other.codeDir))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.CentreComptablePK[ codeCentreCpt=" + codeCentreCpt
        + ", codeDir=" + codeDir + " ]";
  }

}
