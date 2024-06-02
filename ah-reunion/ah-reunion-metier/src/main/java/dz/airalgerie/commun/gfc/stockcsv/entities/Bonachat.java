/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "BONACHAT", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Bonachat.findAll", query = "SELECT b FROM Bonachat b"),
    @NamedQuery(name = "Bonachat.findByNumba",
        query = "SELECT b FROM Bonachat b WHERE b.bonachatPK.numba = :numba"),
    @NamedQuery(name = "Bonachat.findByDateachat",
        query = "SELECT b FROM Bonachat b WHERE b.bonachatPK.dateachat = :dateachat"),
    @NamedQuery(name = "Bonachat.findByTypemvt",
        query = "SELECT b FROM Bonachat b WHERE b.typemvt = :typemvt")})
public class Bonachat implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonachatPK bonachatPK;
  @Column(name = "TYPEMVT")
  private Integer typemvt;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonachat")
  private Collection<Artba> artbaCollection;
  @JoinColumn(name = "NUMFACT", referencedColumnName = "NUMFACT")
  @ManyToOne(cascade = CascadeType.ALL)
  private Facture numfact;
  @OneToMany(mappedBy = "bonachat")
  private Collection<Facture> factureCollection;

  public Bonachat() {}

  public Bonachat(BonachatPK bonachatPK) {
    this.bonachatPK = bonachatPK;
  }

  public Bonachat(int numba, Date dateachat) {
    this.bonachatPK = new BonachatPK(numba, dateachat);
  }

  public BonachatPK getBonachatPK() {
    return bonachatPK;
  }

  public void setBonachatPK(BonachatPK bonachatPK) {
    this.bonachatPK = bonachatPK;
  }

  public Integer getTypemvt() {
    return typemvt;
  }

  public void setTypemvt(Integer typemvt) {
    this.typemvt = typemvt;
  }

  @XmlTransient
  public Collection<Artba> getArtbaCollection() {
    return artbaCollection;
  }

  public void setArtbaCollection(Collection<Artba> artbaCollection) {
    this.artbaCollection = artbaCollection;
  }

  public Facture getNumfact() {
    return numfact;
  }

  public void setNumfact(Facture numfact) {
    this.numfact = numfact;
  }

  @XmlTransient
  public Collection<Facture> getFactureCollection() {
    return factureCollection;
  }

  public void setFactureCollection(Collection<Facture> factureCollection) {
    this.factureCollection = factureCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonachatPK != null ? bonachatPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Bonachat)) {
      return false;
    }
    Bonachat other = (Bonachat) object;
    if ((this.bonachatPK == null && other.bonachatPK != null)
        || (this.bonachatPK != null && !this.bonachatPK.equals(other.bonachatPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Bonachat[ bonachatPK=" + bonachatPK + " ]";
  }

}
