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
public class MonnaieCvalCptaPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MON")
  private String codeMon;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;

  public MonnaieCvalCptaPK() {}

  public MonnaieCvalCptaPK(String codeMon, int dateTrt) {
    this.codeMon = codeMon;
    this.dateTrt = dateTrt;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
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
    hash += (codeMon != null ? codeMon.hashCode() : 0);
    hash += (int) dateTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MonnaieCvalCptaPK)) {
      return false;
    }
    MonnaieCvalCptaPK other = (MonnaieCvalCptaPK) object;
    if ((this.codeMon == null && other.codeMon != null)
        || (this.codeMon != null && !this.codeMon.equals(other.codeMon))) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.MonnaieCvalCptaPK[ codeMon=" + codeMon + ", dateTrt=" + dateTrt + " ]";
  }

}
