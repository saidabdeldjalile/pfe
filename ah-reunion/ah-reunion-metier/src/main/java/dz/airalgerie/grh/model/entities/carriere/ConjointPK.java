/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Embeddable
public class ConjointPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CNJ")
  private short codeCnj;
  @Column(name = "DATE_MAR")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateMar;

  public ConjointPK() {}

  public ConjointPK(int matricule, short codeCnj, Date dateMar) {
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

  public Date getDateMar() {
    return dateMar;
  }

  public void setDateMar(Date dateMar) {
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
    if (!(object instanceof ConjointPK)) {
      return false;
    }
    ConjointPK other = (ConjointPK) object;
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
