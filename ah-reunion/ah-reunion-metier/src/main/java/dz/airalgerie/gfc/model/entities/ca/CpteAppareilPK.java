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
public class CpteAppareilPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public CpteAppareilPK() {}

  public CpteAppareilPK(int dateTrt, String typeApp) {
    this.dateTrt = dateTrt;
    this.typeApp = typeApp;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (typeApp != null ? typeApp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteAppareilPK)) {
      return false;
    }
    CpteAppareilPK other = (CpteAppareilPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.typeApp == null && other.typeApp != null)
        || (this.typeApp != null && !this.typeApp.equals(other.typeApp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteAppareilPK[ dateTrt=" + dateTrt + ", typeApp=" + typeApp + " ]";
  }

}
