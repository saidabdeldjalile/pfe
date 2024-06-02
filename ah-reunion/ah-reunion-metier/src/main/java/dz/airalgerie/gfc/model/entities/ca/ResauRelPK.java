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
public class ResauRelPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "DEB_TRC")
  private String debTrc;

  public ResauRelPK() {}

  public ResauRelPK(String reseau, String debTrc) {
    this.reseau = reseau;
    this.debTrc = debTrc;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getDebTrc() {
    return debTrc;
  }

  public void setDebTrc(String debTrc) {
    this.debTrc = debTrc;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (reseau != null ? reseau.hashCode() : 0);
    hash += (debTrc != null ? debTrc.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ResauRelPK)) {
      return false;
    }
    ResauRelPK other = (ResauRelPK) object;
    if ((this.reseau == null && other.reseau != null)
        || (this.reseau != null && !this.reseau.equals(other.reseau))) {
      return false;
    }
    if ((this.debTrc == null && other.debTrc != null)
        || (this.debTrc != null && !this.debTrc.equals(other.debTrc))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.ResauRelPK[ reseau=" + reseau + ", debTrc=" + debTrc + " ]";
  }

}
