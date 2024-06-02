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
@Table(schema = "VCC", name = "REGIME_TRAVAIL")
// @XmlRootElement
// @NamedQueries({
// @NamedQuery(name = "RegimeTravail.findAll", query = "SELECT r FROM RegimeTravail r"),
// @NamedQuery(name = "RegimeTravail.findByCodeRegimeTravail", query = "SELECT r FROM RegimeTravail
// r WHERE r.codeRegimeTravail = :codeRegimeTravail"),
// @NamedQuery(name = "RegimeTravail.findByLibelle", query = "SELECT r FROM RegimeTravail r WHERE
// r.libelle = :libelle")})
public class RegimeTravail implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_REGIME_TRAVAIL")
  private Short codeRegimeTravail;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeRegimeTravail")
  private Collection<Candidature> candidatureCollection;

  public RegimeTravail() {}

  public RegimeTravail(Short codeRegimeTravail) {
    this.codeRegimeTravail = codeRegimeTravail;
  }

  public RegimeTravail(Short codeRegimeTravail, String libelle) {
    this.codeRegimeTravail = codeRegimeTravail;
    this.libelle = libelle;
  }

  public Short getCodeRegimeTravail() {
    return codeRegimeTravail;
  }

  public void setCodeRegimeTravail(Short codeRegimeTravail) {
    this.codeRegimeTravail = codeRegimeTravail;
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
    hash += (codeRegimeTravail != null ? codeRegimeTravail.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RegimeTravail)) {
      return false;
    }
    RegimeTravail other = (RegimeTravail) object;
    if ((this.codeRegimeTravail == null && other.codeRegimeTravail != null)
        || (this.codeRegimeTravail != null
            && !this.codeRegimeTravail.equals(other.codeRegimeTravail))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.RegimeTravail[ codeRegimeTravail=" + codeRegimeTravail + " ]";
  }

}
