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
public class ElementPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Basic(optional = false)
  @NotNull
  // @Size(min = 196001, max = 210012)
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ACT")
  private int codeAct;

  public ElementPK() {}

  public ElementPK(Integer matricule, int dateTrt, int datePai, int codeAct) {
    this.matricule = matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
    this.codeAct = codeAct;
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

  public int getCodeAct() {
    return codeAct;
  }

  public void setCodeAct(int codeAct) {
    this.codeAct = codeAct;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) dateTrt;
    hash += (int) datePai;
    hash += (int) codeAct;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ElementPK)) {
      return false;
    }
    ElementPK other = (ElementPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.datePai != other.datePai) {
      return false;
    }
    if (this.codeAct != other.codeAct) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.ElementPK[ matricule=" + matricule + ", dateTrt=" + dateTrt + ", datePai="
        + datePai + ", codeAct=" + codeAct + " ]";
  }

}
