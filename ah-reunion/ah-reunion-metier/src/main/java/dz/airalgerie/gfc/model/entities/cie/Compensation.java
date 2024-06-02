/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

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
@Table(catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Compensation.findAll", query = "SELECT c FROM Compensation c"),
    @NamedQuery(name = "Compensation.findByCodeComp",
        query = "SELECT c FROM Compensation c WHERE c.codeComp = :codeComp"),
    @NamedQuery(name = "Compensation.findByLibelle",
        query = "SELECT c FROM Compensation c WHERE c.libelle = :libelle")})
public class Compensation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_COMP", nullable = false, length = 2)
  private String codeComp;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(nullable = false, length = 50)
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeComp")
  private Collection<FactureEmise> factureEmiseCollection;

  public Compensation() {}

  public Compensation(String codeComp) {
    this.codeComp = codeComp;
  }

  public Compensation(String codeComp, String libelle) {
    this.codeComp = codeComp;
    this.libelle = libelle;
  }

  public String getCodeComp() {
    return codeComp;
  }

  public void setCodeComp(String codeComp) {
    this.codeComp = codeComp;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<FactureEmise> getFactureEmiseCollection() {
    return factureEmiseCollection;
  }

  public void setFactureEmiseCollection(Collection<FactureEmise> factureEmiseCollection) {
    this.factureEmiseCollection = factureEmiseCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeComp != null ? codeComp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Compensation)) {
      return false;
    }
    Compensation other = (Compensation) object;
    if ((this.codeComp == null && other.codeComp != null)
        || (this.codeComp != null && !this.codeComp.equals(other.codeComp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.Compensation[ codeComp=" + codeComp + " ]";
  }

}
