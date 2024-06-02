/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_RELATION", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteRelation.findAll", query = "SELECT c FROM CpteRelation c"),
    @NamedQuery(name = "CpteRelation.findByCodeRel",
        query = "SELECT c FROM CpteRelation c WHERE c.codeRel = :codeRel"),
    @NamedQuery(name = "CpteRelation.findByRotation",
        query = "SELECT c FROM CpteRelation c WHERE c.rotation = :rotation"),
    @NamedQuery(name = "CpteRelation.findByCodeZone",
        query = "SELECT c FROM CpteRelation c WHERE c.codeZone = :codeZone")})
public class CpteRelation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "CODE_REL")
  private String codeRel;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "CODE_ZONE")
  private Short codeZone;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeRel")
  private Collection<CpteLigne> cpteLigneCollection;

  public CpteRelation() {

  }

  public CpteRelation(String codeRel) {
    this.codeRel = codeRel;
  }

  public CpteRelation(String codeRel, String rotation) {
    this.codeRel = codeRel;
    this.rotation = rotation;
  }

  public String getCodeRel() {
    return codeRel;
  }

  public void setCodeRel(String codeRel) {
    this.codeRel = codeRel;
  }

  public String getRotation() {

    return rotation;
  }

  public void setRotation(String rotation) {

    this.rotation = rotation;
  }

  public Short getCodeZone() {
    return codeZone;
  }

  public void setCodeZone(Short codeZone) {
    this.codeZone = codeZone;
  }

  @XmlTransient
  public Collection<CpteLigne> getCpteLigneCollection() {
    return cpteLigneCollection;
  }

  public void setCpteLigneCollection(Collection<CpteLigne> cpteLigneCollection) {
    this.cpteLigneCollection = cpteLigneCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRel != null ? codeRel.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteRelation)) {
      return false;
    }
    CpteRelation other = (CpteRelation) object;
    if ((this.codeRel == null && other.codeRel != null)
        || (this.codeRel != null && !this.codeRel.equals(other.codeRel))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteRelation[ codeRel=" + codeRel + " ]";
  }

}
