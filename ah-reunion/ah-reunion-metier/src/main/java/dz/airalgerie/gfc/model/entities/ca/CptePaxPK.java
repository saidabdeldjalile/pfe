/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

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
public class CptePaxPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CAE_ESC")
  private String caeEsc;

  public CptePaxPK() {}

  public CptePaxPK(int dateTrt, String caeEsc) {
    this.dateTrt = dateTrt;
    this.caeEsc = caeEsc;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCaeEsc() {
    return caeEsc;
  }

  public void setCaeEsc(String caeEsc) {
    this.caeEsc = caeEsc;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (caeEsc != null ? caeEsc.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CptePaxPK)) {
      return false;
    }
    CptePaxPK other = (CptePaxPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.caeEsc == null && other.caeEsc != null)
        || (this.caeEsc != null && !this.caeEsc.equals(other.caeEsc))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CptePaxPK[ dateTrt=" + dateTrt + ", caeEsc=" + caeEsc + " ]";
  }

}
