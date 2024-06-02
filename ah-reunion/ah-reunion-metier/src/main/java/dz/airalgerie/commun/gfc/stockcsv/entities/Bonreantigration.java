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
@Table(name = "BONREANTIGRATION", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonreantigration.findAll", query = "SELECT b FROM Bonreantigration b"),
    @NamedQuery(name = "Bonreantigration.findByNumbr",
        query = "SELECT b FROM Bonreantigration b WHERE b.bonreantigrationPK.numbr = :numbr"),
    @NamedQuery(name = "Bonreantigration.findByDatere",
        query = "SELECT b FROM Bonreantigration b WHERE b.bonreantigrationPK.datere = :datere"),
    // @NamedQuery(name = "Bonreantigration.findByCodemag", query = "SELECT b FROM Bonreantigration
    // b WHERE b.bonreantigrationPK.codemag = :codemag"),
    @NamedQuery(name = "Bonreantigration.findByTypemvt",
        query = "SELECT b FROM Bonreantigration b WHERE b.typemvt = :typemvt")})
public class Bonreantigration implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonreantigrationPK bonreantigrationPK;
  @Column(name = "TYPEMVT")
  private Integer typemvt;
  @JoinColumns({@JoinColumn(name = "NUMBS", referencedColumnName = "NUMBS"),
      @JoinColumn(name = "DATESORTIE", referencedColumnName = "DATESORTIE")})
  @ManyToOne
  private Bonsortie bonsortie;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonreantigration")
  private Collection<Artbr> artbrCollection;
  @OneToMany(mappedBy = "bonreantigration")
  private Collection<Bonsortie> bonsortieCollection;

  public Bonreantigration() {}

  public Bonreantigration(BonreantigrationPK bonreantigrationPK) {
    this.bonreantigrationPK = bonreantigrationPK;
  }

  public Bonreantigration(int numbr, Date datere) {
    this.bonreantigrationPK = new BonreantigrationPK(numbr, datere);
  }

  public BonreantigrationPK getBonreantigrationPK() {
    return bonreantigrationPK;
  }

  public void setBonreantigrationPK(BonreantigrationPK bonreantigrationPK) {
    this.bonreantigrationPK = bonreantigrationPK;
  }

  public Integer getTypemvt() {
    return typemvt;
  }

  public void setTypemvt(Integer typemvt) {
    this.typemvt = typemvt;
  }

  public Bonsortie getBonsortie() {
    return bonsortie;
  }

  public void setBonsortie(Bonsortie bonsortie) {
    this.bonsortie = bonsortie;
  }

  @XmlTransient
  public Collection<Artbr> getArtbrCollection() {
    return artbrCollection;
  }

  public void setArtbrCollection(Collection<Artbr> artbrCollection) {
    this.artbrCollection = artbrCollection;
  }

  @XmlTransient
  public Collection<Bonsortie> getBonsortieCollection() {
    return bonsortieCollection;
  }

  public void setBonsortieCollection(Collection<Bonsortie> bonsortieCollection) {
    this.bonsortieCollection = bonsortieCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonreantigrationPK != null ? bonreantigrationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Bonreantigration)) {
      return false;
    }
    Bonreantigration other = (Bonreantigration) object;
    if ((this.bonreantigrationPK == null && other.bonreantigrationPK != null)
        || (this.bonreantigrationPK != null
            && !this.bonreantigrationPK.equals(other.bonreantigrationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Bonreantigration[ bonreantigrationPK=" + bonreantigrationPK + " ]";
  }

}
