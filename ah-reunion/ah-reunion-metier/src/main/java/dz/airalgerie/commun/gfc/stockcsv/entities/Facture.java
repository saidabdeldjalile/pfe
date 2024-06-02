/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author kemikem
 */
@Entity
@Table(name = "FACTURE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findByNumfact",
        query = "SELECT f FROM Facture f WHERE f.numfact = :numfact"),
    @NamedQuery(name = "Facture.findByCodefournis",
        query = "SELECT f FROM Facture f WHERE f.codefournis = :codefournis")})
public class Facture implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "NUMFACT")
  private String numfact;
  @Size(max = 15)
  @Column(name = "CODEFOURNIS")
  private String codefournis;
  @OneToMany(mappedBy = "numfact")
  private Collection<Bonachat> bonachatCollection;
  @JoinColumn(name = "CODEFOUR", referencedColumnName = "CODEFOUR")
  @ManyToOne
  private Fournisseur codefour;
  // @JoinColumns({
  // @JoinColumn(name = "NUMBA", referencedColumnName = "NUMBA"),
  // @JoinColumn(name = "DATEACHAT", referencedColumnName = "DATEACHAT")})
  // @ManyToOne
  private Bonachat bonachat;

  public Facture() {}

  public Facture(String numfact) {
    this.numfact = numfact;
  }

  public String getNumfact() {
    return numfact;
  }

  public void setNumfact(String numfact) {
    this.numfact = numfact;
  }

  public String getCodefournis() {
    return codefournis;
  }

  public void setCodefournis(String codefournis) {
    this.codefournis = codefournis;
  }

  @XmlTransient
  public Collection<Bonachat> getBonachatCollection() {
    return bonachatCollection;
  }

  public void setBonachatCollection(Collection<Bonachat> bonachatCollection) {
    this.bonachatCollection = bonachatCollection;
  }

  public Fournisseur getCodefour() {
    return codefour;
  }

  public void setCodefour(Fournisseur codefour) {
    this.codefour = codefour;
  }

  public Bonachat getBonachat() {
    return bonachat;
  }

  public void setBonachat(Bonachat bonachat) {
    this.bonachat = bonachat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numfact != null ? numfact.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Facture)) {
      return false;
    }
    Facture other = (Facture) object;
    if ((this.numfact == null && other.numfact != null)
        || (this.numfact != null && !this.numfact.equals(other.numfact))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Facture[ numfact=" + numfact + " ]";
  }

}
