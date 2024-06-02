/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.cellulecrise;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "VCC", name = "ADHESION")
// @XmlRootElement
// @NamedQueries({
// @NamedQuery(name = "Adhesion.findAll", query = "SELECT a FROM Adhesion a"),
// @NamedQuery(name = "Adhesion.findByCodeAdhesion", query = "SELECT a FROM Adhesion a WHERE
// a.codeAdhesion = :codeAdhesion"),
// @NamedQuery(name = "Adhesion.findByLibelle", query = "SELECT a FROM Adhesion a WHERE a.libelle =
// :libelle")})
public class Adhesion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ADHESION")
  private Short codeAdhesion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeAdhesion")
  private Collection<Candidature> candidatureCollection;

  public Adhesion() {}

  public Adhesion(Short codeAdhesion) {
    this.codeAdhesion = codeAdhesion;
  }

  public Adhesion(Short codeAdhesion, String libelle) {
    this.codeAdhesion = codeAdhesion;
    this.libelle = libelle;
  }

  public Short getCodeAdhesion() {
    return codeAdhesion;
  }

  public void setCodeAdhesion(Short codeAdhesion) {
    this.codeAdhesion = codeAdhesion;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<Candidature> getCandidatureCollection() {
    return candidatureCollection;
  }

  public void setCandidatureCollection(Collection<Candidature> candidatureCollection) {
    this.candidatureCollection = candidatureCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeAdhesion != null ? codeAdhesion.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Adhesion)) {
      return false;
    }
    Adhesion other = (Adhesion) object;
    if ((this.codeAdhesion == null && other.codeAdhesion != null)
        || (this.codeAdhesion != null && !this.codeAdhesion.equals(other.codeAdhesion))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Adhesion[ codeAdhesion=" + codeAdhesion + " ]";
  }

}
