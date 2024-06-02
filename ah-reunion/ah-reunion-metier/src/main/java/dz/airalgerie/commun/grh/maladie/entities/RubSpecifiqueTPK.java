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

/**
 *
 * @author user
 */
@Embeddable
public class RubSpecifiqueTPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;

  public RubSpecifiqueTPK() {}

  public RubSpecifiqueTPK(int matricule, int dateTrt) {
    this.matricule = matricule;
    this.dateTrt = dateTrt;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) dateTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RubSpecifiqueTPK)) {
      return false;
    }
    RubSpecifiqueTPK other = (RubSpecifiqueTPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.controlleur.RubSpecifiqueTPK[ matricule=" + matricule + ", dateTrt=" + dateTrt
        + " ]";
  }

}
