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
import javax.persistence.JoinColumns;
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
@Table(name = "BONSORTIE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Bonsortie.findAll", query = "SELECT b FROM Bonsortie b"),
    @NamedQuery(name = "Bonsortie.findByNumbs",
        query = "SELECT b FROM Bonsortie b WHERE b.bonsortiePK.numbs = :numbs"),
    @NamedQuery(name = "Bonsortie.findByDatesortie",
        query = "SELECT b FROM Bonsortie b WHERE b.bonsortiePK.datesortie = :datesortie"),
    // @NamedQuery(name = "Bonsortie.findByCodemag", query = "SELECT b FROM Bonsortie b WHERE
    // b.bonsortiePK.Codemag = :Codemag"),
    @NamedQuery(name = "Bonsortie.findByTypemvt",
        query = "SELECT b FROM Bonsortie b WHERE b.typemvt = :typemvt")})
public class Bonsortie implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonsortiePK bonsortiePK;
  @Column(name = "TYPEMVT")
  private Integer typemvt;
  @OneToMany(mappedBy = "bonsortie")
  private Collection<Bonreantigration> bonreantigrationCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonsortie")
  private Collection<Artbs> artbsCollection;
  @JoinColumns({@JoinColumn(name = "NUMBR", referencedColumnName = "NUMBR"),
      @JoinColumn(name = "DATERE", referencedColumnName = "DATERE")})
  @ManyToOne
  private Bonreantigration bonreantigration;

  public Bonsortie() {}

  // -------rajouter en bon sortie poour la requete bonsortie find bobs
  public Bonsortie(Integer typemvt) {
    this.typemvt = typemvt;
  }

  public Bonsortie(BonsortiePK bonsortiePK) {
    this.bonsortiePK = bonsortiePK;
  }

  public Bonsortie(int numbs, Date datesortie) {
    this.bonsortiePK = new BonsortiePK(numbs, datesortie);
  }

  public BonsortiePK getBonsortiePK() {
    return bonsortiePK;
  }

  public void setBonsortiePK(BonsortiePK bonsortiePK) {
    this.bonsortiePK = bonsortiePK;
  }

  public Integer getTypemvt() {
    return typemvt;
  }

  public void setTypemvt(Integer typemvt) {
    this.typemvt = typemvt;
  }

  @XmlTransient
  public Collection<Bonreantigration> getBonreantigrationCollection() {
    return bonreantigrationCollection;
  }

  public void setBonreantigrationCollection(
      Collection<Bonreantigration> bonreantigrationCollection) {
    this.bonreantigrationCollection = bonreantigrationCollection;
  }

  @XmlTransient
  public Collection<Artbs> getArtbsCollection() {
    return artbsCollection;
  }

  public void setArtbsCollection(Collection<Artbs> artbsCollection) {
    this.artbsCollection = artbsCollection;
  }

  public Bonreantigration getBonreantigration() {
    return bonreantigration;
  }

  public void setBonreantigration(Bonreantigration bonreantigration) {
    this.bonreantigration = bonreantigration;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonsortiePK != null ? bonsortiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Bonsortie)) {
      return false;
    }
    Bonsortie other = (Bonsortie) object;
    if ((this.bonsortiePK == null && other.bonsortiePK != null)
        || (this.bonsortiePK != null && !this.bonsortiePK.equals(other.bonsortiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Bonsortie[ bonsortiePK=" + bonsortiePK + " ]";
  }

}
