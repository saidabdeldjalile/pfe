/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

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
public class Balance330340TtPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CLASSE")
  private String classe;

  public Balance330340TtPK() {}

  public Balance330340TtPK(int dateTrt, String classe) {
    this.dateTrt = dateTrt;
    this.classe = classe;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (classe != null ? classe.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance330340TtPK)) {
      return false;
    }
    Balance330340TtPK other = (Balance330340TtPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.classe == null && other.classe != null)
        || (this.classe != null && !this.classe.equals(other.classe))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance330340TtPK[ dateTrt=" + dateTrt + ", classe=" + classe + " ]";
  }

}
