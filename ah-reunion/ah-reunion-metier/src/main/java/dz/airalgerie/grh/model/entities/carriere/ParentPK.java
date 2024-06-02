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
public class ParentPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "LIEN_PARENTE")
  private Character lienParente;

  public ParentPK() {}

  public ParentPK(int matricule, Character lienParente) {
    this.matricule = matricule;
    this.lienParente = lienParente;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Character getLienParente() {
    return lienParente;
  }

  public void setLienParente(Character lienParente) {
    System.out.println("setLienParente");
    this.lienParente = lienParente;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (lienParente != null ? lienParente.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ParentPK)) {
      return false;
    }
    ParentPK other = (ParentPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.lienParente == null && other.lienParente != null)
        || (this.lienParente != null && !this.lienParente.equals(other.lienParente))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ParentPK[ matricule=" + matricule + ", lienParente=" + lienParente + " ]";
  }

}
