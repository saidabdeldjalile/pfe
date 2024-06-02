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
public class CpteLignePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE", nullable = false)
  private short numLigne;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "RELATION", nullable = false, length = 6)
  private String relation;

  public CpteLignePK() {}

  public CpteLignePK(short numLigne, String relation) {
    this.numLigne = numLigne;
    this.relation = relation;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
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
    hash += (int) numLigne;
    hash += (relation != null ? relation.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteLignePK)) {
      return false;
    }
    CpteLignePK other = (CpteLignePK) object;
    if (this.numLigne != other.numLigne) {
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
    return "jpa.CpteLignePK[ numLigne=" + numLigne + ", relation=" + relation + " ]";
  }

}
