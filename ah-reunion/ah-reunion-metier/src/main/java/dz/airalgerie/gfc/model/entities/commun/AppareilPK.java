/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

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
public class AppareilPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "MATR_APP")
  private String matrApp;

  public AppareilPK() {}

  public AppareilPK(String typeApp, String matrApp) {
    this.typeApp = typeApp;
    this.matrApp = matrApp;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public String getMatrApp() {
    return matrApp;
  }

  public void setMatrApp(String matrApp) {
    this.matrApp = matrApp;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (typeApp != null ? typeApp.hashCode() : 0);
    hash += (matrApp != null ? matrApp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AppareilPK)) {
      return false;
    }
    AppareilPK other = (AppareilPK) object;
    if ((this.typeApp == null && other.typeApp != null)
        || (this.typeApp != null && !this.typeApp.equals(other.typeApp))) {
      return false;
    }
    if ((this.matrApp == null && other.matrApp != null)
        || (this.matrApp != null && !this.matrApp.equals(other.matrApp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.AppareilPK[ typeApp=" + typeApp + ", matrApp=" + matrApp + " ]";
  }

}
