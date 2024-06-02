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
@Table(name = "ARTBR", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Artbr.findAll", query = "SELECT a FROM Artbr a"),
    @NamedQuery(name = "Artbr.findByCodepn",
        query = "SELECT a FROM Artbr a WHERE a.artbrPK.codepn = :codepn"),
    @NamedQuery(name = "Artbr.findByNumbr",
        query = "SELECT a FROM Artbr a WHERE a.artbrPK.numbr = :numbr"),
    @NamedQuery(name = "Artbr.findByDatere",
        query = "SELECT a FROM Artbr a WHERE a.artbrPK.datere = :datere"),
    @NamedQuery(name = "Artbr.findByQuantite",
        query = "SELECT a FROM Artbr a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "Artbr.findByValeur",
        query = "SELECT a FROM Artbr a WHERE a.valeur = :valeur")})
public class Artbr implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArtbrPK artbrPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "QUANTITE")
  // private Double quantite;
  private Float quantite;
  @Column(name = "VALEUR")
  // private BigDecimal valeur;
  private Float valeur;
  @JoinColumns({
      @JoinColumn(name = "NUMBR", referencedColumnName = "NUMBR", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATERE", referencedColumnName = "DATERE", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Bonreantigration bonreantigration;
  @JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Article article;

  public Artbr() {}

  public Artbr(ArtbrPK artbrPK) {
    this.artbrPK = artbrPK;
  }

  public Artbr(String codepn, int numbr, Date datere) {
    this.artbrPK = new ArtbrPK(codepn, numbr, datere);
  }

  public ArtbrPK getArtbrPK() {
    return artbrPK;
  }

  public void setArtbrPK(ArtbrPK artbrPK) {
    this.artbrPK = artbrPK;
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

  public Bonreantigration getBonreantigration() {
    return bonreantigration;
  }

  public void setBonreantigration(Bonreantigration bonreantigration) {
    this.bonreantigration = bonreantigration;
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
    hash += (artbrPK != null ? artbrPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Artbr)) {
      return false;
    }
    Artbr other = (Artbr) object;
    if ((this.artbrPK == null && other.artbrPK != null)
        || (this.artbrPK != null && !this.artbrPK.equals(other.artbrPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Artbr[ artbrPK=" + artbrPK + " ]";
  }

}
