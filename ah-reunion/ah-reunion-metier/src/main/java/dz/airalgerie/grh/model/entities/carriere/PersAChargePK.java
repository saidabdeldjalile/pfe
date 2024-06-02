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
public class PersAChargePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_LIEN")
  private Character codeLien;

  public PersAChargePK() {}

  public PersAChargePK(int matricule, String prenoms, Character codeLien) {
    this.matricule = matricule;
    this.prenoms = prenoms;
    this.codeLien = codeLien;
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

  public Character getCodeLien() {
    return codeLien;
  }

  public void setCodeLien(Character codeLien) {
    this.codeLien = codeLien;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (prenoms != null ? prenoms.hashCode() : 0);
    hash += (codeLien != null ? codeLien.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PersAChargePK)) {
      return false;
    }
    PersAChargePK other = (PersAChargePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.prenoms == null && other.prenoms != null)
        || (this.prenoms != null && !this.prenoms.equals(other.prenoms))) {
      return false;
    }
    if ((this.codeLien == null && other.codeLien != null)
        || (this.codeLien != null && !this.codeLien.equals(other.codeLien))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.PersAChargePK[ matricule=" + matricule + ", prenoms=" + prenoms + ", codeLien="
        + codeLien + " ]";
  }

}
