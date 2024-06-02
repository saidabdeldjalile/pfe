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
@Table(name = "ARTBA", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Artba.findAll", query = "SELECT a FROM Artba a"),
    @NamedQuery(name = "Artba.findByCodepn",
        query = "SELECT a FROM Artba a WHERE a.artbaPK.codepn = :codepn"),
    @NamedQuery(name = "Artba.findByNumba",
        query = "SELECT a FROM Artba a WHERE a.artbaPK.numba = :numba"),
    @NamedQuery(name = "Artba.findByDateachat",
        query = "SELECT a FROM Artba a WHERE a.artbaPK.dateachat = :dateachat"),
    @NamedQuery(name = "Artba.findByCodemag",
        query = "SELECT a FROM Artba a WHERE a.artbaPK.codemag = :codemag"),
    @NamedQuery(name = "Artba.findByQuantite",
        query = "SELECT a FROM Artba a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "Artba.findByValeur",
        query = "SELECT a FROM Artba a WHERE a.valeur = :valeur"),
    @NamedQuery(name = "Artba.findByObservationmag",
        query = "SELECT a FROM Artba a WHERE a.observationmag = :observationmag")})

public class Artba implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArtbaPK artbaPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "QUANTITE")
  private Float quantite;
  // private Double quantite;
  @Column(name = "VALEUR")
  // private BigDecimal valeur;
  private Float valeur;
  @Column(name = "OBSERVATIONMAG")
  // private BigDecimal valeur;
  private String observationmag;

  @JoinColumns({
      @JoinColumn(name = "NUMBA", referencedColumnName = "NUMBA", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATEACHAT", referencedColumnName = "DATEACHAT", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Bonachat bonachat;
  @JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Article article;

  public Artba() {}

  public Artba(ArtbaPK artbaPK) {
    this.artbaPK = artbaPK;
  }

  public Artba(String codepn, int numba, Date dateachat) {
    this.artbaPK = new ArtbaPK(codepn, numba, dateachat);
  }

  public ArtbaPK getArtbaPK() {
    return artbaPK;
  }

  public void setArtbaPK(ArtbaPK artbaPK) {
    this.artbaPK = artbaPK;
  }

  public Float getQuantite() {
    return quantite;
  }

  public void setQuantite(Float quantite) {
    this.quantite = quantite;
  }

  public Float getValeur() {
    return valeur;
  }

  public void setValeur(Float valeur) {
    this.valeur = valeur;
  }

  public Bonachat getBonachat() {
    return bonachat;
  }

  public void setBonachat(Bonachat bonachat) {
    this.bonachat = bonachat;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public String getObservationmag() {
    return observationmag;
  }

  public void setObservationmag(String observationmag) {
    this.observationmag = observationmag;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (artbaPK != null ? artbaPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Artba)) {
      return false;
    }
    Artba other = (Artba) object;
    if ((this.artbaPK == null && other.artbaPK != null)
        || (this.artbaPK != null && !this.artbaPK.equals(other.artbaPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Artba[ artbaPK=" + artbaPK + " ]";
  }

}
