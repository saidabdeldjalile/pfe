/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.fac;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Embeddable
public class ClotureFacturePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;

  public ClotureFacturePK() {
  }

  public ClotureFacturePK(String codeUnite, int dateTrt) {
    this.codeUnite = codeUnite;
    this.dateTrt = dateTrt;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
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
    hash += Integer.valueOf(codeUnite);
    hash += (int) dateTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClotureFacturePK)) {
      return false;
    }
    ClotureFacturePK other = (ClotureFacturePK) object;
    if (this.codeUnite != other.codeUnite) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.ClotureFacturePK[ codeUnite=" + codeUnite
        + ", dateTrt=" + dateTrt + " ]";
  }

}
