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

/**
 *
 * @author Diaf
 */
@Embeddable
public class EncouragementPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE")
  private int annee;

  public EncouragementPK() {}

  public EncouragementPK(int matricule, int annee) {
    this.matricule = matricule;
    this.annee = annee;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getAnnee() {
    return annee;
  }

  public void setAnnee(int annee) {
    this.annee = annee;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) annee;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EncouragementPK)) {
      return false;
    }
    EncouragementPK other = (EncouragementPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.annee != other.annee) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.EncouragementPK[ matricule=" + matricule + ", annee=" + annee + " ]";
  }

}
