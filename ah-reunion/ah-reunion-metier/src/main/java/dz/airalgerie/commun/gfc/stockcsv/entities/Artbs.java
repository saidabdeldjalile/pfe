/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "ARTBS", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Artbs.findAll", query = "SELECT a FROM Artbs a"),
    @NamedQuery(name = "Artbs.findByCodepn",
        query = "SELECT a FROM Artbs a WHERE a.artbsPK.codepn = :codepn"),
    @NamedQuery(name = "Artbs.findByNumbs",
        query = "SELECT a FROM Artbs a WHERE a.artbsPK.numbs = :numbs"),
    @NamedQuery(name = "Artbs.findByDatesortie",
        query = "SELECT a FROM Artbs a WHERE a.artbsPK.datesortie = :datesortie"),
    @NamedQuery(name = "Artbs.findByQuentite",
        query = "SELECT a FROM Artbs a WHERE a.quentite = :quentite"),
    @NamedQuery(name = "Artbs.findByValeur",
        query = "SELECT a FROM Artbs a WHERE a.valeur = :valeur")})
public class Artbs implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArtbsPK artbsPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "QUENTITE")
  private Float quentite;
  @Column(name = "VALEUR")
  private Float valeur;
  @JoinColumns({
      @JoinColumn(name = "NUMBS", referencedColumnName = "NUMBS", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATESORTIE", referencedColumnName = "DATESORTIE", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Bonsortie bonsortie;
  @JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Article article;

  public Artbs() {}

  public Artbs(ArtbsPK artbsPK) {
    this.artbsPK = artbsPK;
  }

  public Artbs(String codepn, int numbs, Date datesortie) {
    this.artbsPK = new ArtbsPK(codepn, numbs, datesortie);
  }

  public ArtbsPK getArtbsPK() {
    return artbsPK;
  }

  public void setArtbsPK(ArtbsPK artbsPK) {
    this.artbsPK = artbsPK;
  }

  public Float getQuentite() {
    return quentite;
  }

  public void setQuentite(Float quentite) {
    this.quentite = quentite;
  }

  public Float getValeur() {
    return valeur;
  }

  public void setValeur(Float valeur) {
    this.valeur = valeur;
  }

  public Bonsortie getBonsortie() {
    return bonsortie;
  }

  public void setBonsortie(Bonsortie bonsortie) {
    this.bonsortie = bonsortie;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (artbsPK != null ? artbsPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Artbs)) {
      return false;
    }
    Artbs other = (Artbs) object;
    if ((this.artbsPK == null && other.artbsPK != null)
        || (this.artbsPK != null && !this.artbsPK.equals(other.artbsPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Artbs[ artbsPK=" + artbsPK + " ]";
  }

}
