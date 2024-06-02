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
public class EnfantPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;

  public EnfantPK() {}

  public EnfantPK(int matricule, String prenoms) {
    this.matricule = matricule;
    this.prenoms = prenoms;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (prenoms != null ? prenoms.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EnfantPK)) {
      return false;
    }
    EnfantPK other = (EnfantPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.prenoms == null && other.prenoms != null)
        || (this.prenoms != null && !this.prenoms.equals(other.prenoms))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.EnfantPK[ matricule=" + matricule + ", prenoms=" + prenoms + " ]";
  }

}
