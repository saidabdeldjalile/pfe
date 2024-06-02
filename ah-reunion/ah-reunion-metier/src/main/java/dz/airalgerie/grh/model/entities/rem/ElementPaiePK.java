/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nabila
 */
@Embeddable
public class ElementPaiePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;

  public ElementPaiePK() {}

  public ElementPaiePK(Integer matricule, int dateTrt, int datePai) {
    this.matricule = matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) dateTrt;
    hash += (int) datePai;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ElementPaiePK)) {
      return false;
    }
    ElementPaiePK other = (ElementPaiePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.datePai != other.datePai) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.ElementPaiePK[ matricule=" + matricule + ", dateTrt=" + dateTrt + ", datePai="
        + datePai + " ]";
  }

}
