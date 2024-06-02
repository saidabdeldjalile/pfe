/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

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
 * @author user
 */
@Entity
@Table(name = "STK.pays")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.findByCodePays",
        query = "SELECT p FROM Pays p WHERE p.codePays = :codePays"),
    @NamedQuery(name = "Pays.findByLibelle",
        query = "SELECT p FROM Pays p WHERE p.libelle = :libelle")})
public class Pays implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "codePays")
  private Integer codePays;
  @Size(max = 90)
  @Column(name = "libelle")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codePays")
  private Collection<Fournisseur> fournisseurCollection;

  public Pays() {}

  public Pays(Integer codePays) {
    this.codePays = codePays;
  }

  public Integer getCodePays() {
    return codePays;
  }

  public void setCodePays(Integer codePays) {
    this.codePays = codePays;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<Fournisseur> getFournisseurCollection() {
    return fournisseurCollection;
  }

  public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
    this.fournisseurCollection = fournisseurCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codePays != null ? codePays.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pays)) {
      return false;
    }
    Pays other = (Pays) object;
    if ((this.codePays == null && other.codePays != null)
        || (this.codePays != null && !this.codePays.equals(other.codePays))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Pays[ codePays=" + codePays + " ]";
  }

}
