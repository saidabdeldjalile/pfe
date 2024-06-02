/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "RESAU_REL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ResauRel.findAll", query = "SELECT r FROM ResauRel r"),
    @NamedQuery(name = "ResauRel.findByReseau",
        query = "SELECT r FROM ResauRel r WHERE r.resauRelPK.reseau = :reseau"),
    @NamedQuery(name = "ResauRel.findByDebTrc",
        query = "SELECT r FROM ResauRel r WHERE r.resauRelPK.debTrc = :debTrc"),
    @NamedQuery(name = "ResauRel.findByFinTrc",
        query = "SELECT r FROM ResauRel r WHERE r.finTrc = :finTrc")})
public class ResauRel implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ResauRelPK resauRelPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "FIN_TRC")
  private String finTrc;

  public ResauRel() {}

  public ResauRel(ResauRelPK resauRelPK) {
    this.resauRelPK = resauRelPK;
  }

  public ResauRel(ResauRelPK resauRelPK, String finTrc) {
    this.resauRelPK = resauRelPK;
    this.finTrc = finTrc;
  }

  public ResauRel(String reseau, String debTrc) {
    this.resauRelPK = new ResauRelPK(reseau, debTrc);
  }

  public ResauRelPK getResauRelPK() {
    return resauRelPK;
  }

  public void setResauRelPK(ResauRelPK resauRelPK) {
    this.resauRelPK = resauRelPK;
  }

  public String getFinTrc() {
    return finTrc;
  }

  public void setFinTrc(String finTrc) {
    this.finTrc = finTrc;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (resauRelPK != null ? resauRelPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ResauRel)) {
      return false;
    }
    ResauRel other = (ResauRel) object;
    if ((this.resauRelPK == null && other.resauRelPK != null)
        || (this.resauRelPK != null && !this.resauRelPK.equals(other.resauRelPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.ResauRel[ resauRelPK=" + resauRelPK + " ]";
  }

}
