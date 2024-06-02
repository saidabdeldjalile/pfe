/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "NATURE_PRESTATION", schema = "CE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NaturePrestation.findAll", query = "SELECT n FROM NaturePrestation n")})
public class NaturePrestation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "NAT_PREST")
  private String natPrest;
  @Size(max = 30)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "natPrest")
  private Collection<FactureRecue> factureRecueCollection;

  public NaturePrestation() {}

  public NaturePrestation(String natPrest) {
    this.natPrest = natPrest;
  }

  public String getNatPrest() {
    return natPrest;
  }

  public void setNatPrest(String natPrest) {
    this.natPrest = natPrest;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<FactureRecue> getFactureRecueCollection() {
    return factureRecueCollection;
  }

  public void setFactureRecueCollection(Collection<FactureRecue> factureRecueCollection) {
    this.factureRecueCollection = factureRecueCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (natPrest != null ? natPrest.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof NaturePrestation)) {
      return false;
    }
    NaturePrestation other = (NaturePrestation) object;
    if ((this.natPrest == null && other.natPrest != null)
        || (this.natPrest != null && !this.natPrest.equals(other.natPrest))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.NaturePrestation[ natPrest=" + natPrest + " ]";
  }

}
