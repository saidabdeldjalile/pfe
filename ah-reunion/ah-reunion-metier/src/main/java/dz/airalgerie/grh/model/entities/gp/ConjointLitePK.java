/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Root
 */
@Embeddable
public class ConjointLitePK implements Serializable {
    
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CNJ")
  private short codeCnj;
  @Column(name = "DATE_MAR")
  private LocalDate dateMar;

  public ConjointLitePK() {}

  public ConjointLitePK(int matricule, short codeCnj, LocalDate dateMar) {
    this.matricule = matricule;
    this.codeCnj = codeCnj;
    this.dateMar = dateMar;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public short getCodeCnj() {
    return codeCnj;
  }

  public void setCodeCnj(short codeCnj) {
    this.codeCnj = codeCnj;
  }

  public LocalDate getDateMar() {
    return dateMar;
  }

  public void setDateMar(LocalDate dateMar) {
    this.dateMar = dateMar;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) codeCnj;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ConjointLitePK)) {
      return false;
    }
    ConjointLitePK other = (ConjointLitePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.codeCnj != other.codeCnj) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ConjointPK[ matricule=" + matricule + ", codeCnj=" + codeCnj + " ]";
  }

}
