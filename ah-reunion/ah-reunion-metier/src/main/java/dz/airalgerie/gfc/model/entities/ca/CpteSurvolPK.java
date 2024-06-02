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
public class CpteSurvolPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "RELATION")
  private String relation;
  @Size(max = 6)
  @Column(name = "RELATION_REAL")
  private String RELATION_REAL;

  public String getRELATION_REAL() {
    return RELATION_REAL;
  }

  public void setRELATION_REAL(String RELATION_REAL) {
    this.RELATION_REAL = RELATION_REAL;
  }

  public CpteSurvolPK() {}

  public CpteSurvolPK(int dateTrt, short numLigne, String typeApp, String relation) {
    this.dateTrt = dateTrt;
    this.numLigne = numLigne;
    this.typeApp = typeApp;
    this.relation = relation;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (int) numLigne;
    hash += (typeApp != null ? typeApp.hashCode() : 0);
    hash += (relation != null ? relation.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteSurvolPK)) {
      return false;
    }
    CpteSurvolPK other = (CpteSurvolPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.numLigne != other.numLigne) {
      return false;
    }
    if ((this.typeApp == null && other.typeApp != null)
        || (this.typeApp != null && !this.typeApp.equals(other.typeApp))) {
      return false;
    }
    if ((this.relation == null && other.relation != null)
        || (this.relation != null && !this.relation.equals(other.relation))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteSurvolPK[ dateTrt=" + dateTrt + ", numLigne=" + numLigne + ", typeApp="
        + typeApp + ", relation=" + relation + " ]";
  }

}
