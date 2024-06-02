/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Embeddable
public class LanguePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_LNG")
  private String codeLng;

  public LanguePK() {}

  public LanguePK(int matricule, String codeLng) {
    this.matricule = matricule;
    this.codeLng = codeLng;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getCodeLng() {
    return codeLng;
  }

  public void setCodeLng(String codeLng) {
    this.codeLng = codeLng;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (codeLng != null ? codeLng.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LanguePK)) {
      return false;
    }
    LanguePK other = (LanguePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.codeLng == null && other.codeLng != null)
        || (this.codeLng != null && !this.codeLng.equals(other.codeLng))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.LanguePK[ matricule=" + matricule + ", codeLng=" + codeLng + " ]";
  }

}
