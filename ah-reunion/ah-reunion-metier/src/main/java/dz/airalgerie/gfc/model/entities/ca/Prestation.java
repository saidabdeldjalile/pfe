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
@Table(name = "PRESTATION", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p"),
    @NamedQuery(name = "Prestation.findByCodePre",
        query = "SELECT p FROM Prestation p WHERE p.codePre = :codePre"),
    @NamedQuery(name = "Prestation.findByLibelle",
        query = "SELECT p FROM Prestation p WHERE p.libelle = :libelle")})
public class Prestation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_PRE")
  private Integer codePre;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "codePre")
  private Collection<CpteLigne> cpteLigneCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestation")
  private Collection<CptePrestation> cptePrestationCollection;

  public Prestation() {}

  public Prestation(Integer codePre) {
    this.codePre = codePre;
  }

  public Prestation(Integer codePre, String libelle) {
    this.codePre = codePre;
    this.libelle = libelle;
  }

  public Integer getCodePre() {
    return codePre;
  }

  public void setCodePre(Integer codePre) {
    this.codePre = codePre;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<CpteLigne> getCpteLigneCollection() {
    return cpteLigneCollection;
  }

  public void setCpteLigneCollection(Collection<CpteLigne> cpteLigneCollection) {
    this.cpteLigneCollection = cpteLigneCollection;
  }

  @XmlTransient
  public Collection<CptePrestation> getCptePrestationCollection() {
    return cptePrestationCollection;
  }

  public void setCptePrestationCollection(Collection<CptePrestation> cptePrestationCollection) {
    this.cptePrestationCollection = cptePrestationCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codePre != null ? codePre.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Prestation)) {
      return false;
    }
    Prestation other = (Prestation) object;
    if ((this.codePre == null && other.codePre != null)
        || (this.codePre != null && !this.codePre.equals(other.codePre))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.Prestation[ codePre=" + codePre + " ]";
  }

}
