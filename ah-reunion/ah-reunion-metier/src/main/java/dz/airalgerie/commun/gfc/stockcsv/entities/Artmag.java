/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "ARTMAG", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Artmag.findAll", query = "SELECT a FROM Artmag a"),
    @NamedQuery(name = "Artmag.findByCodepn",
        query = "SELECT a FROM Artmag a WHERE a.artmagPK.codepn = :codepn"),
    @NamedQuery(name = "Artmag.findByCodemag",
        query = "SELECT a FROM Artmag a WHERE a.artmagPK.codemag = :codemag"),
    @NamedQuery(name = "Artmag.findByEtat", query = "SELECT a FROM Artmag a WHERE a.etat = :etat")})
public class Artmag implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArtmagPK artmagPK;
  @Size(max = 50)
  @Column(name = "ETAT")
  private String etat;
  @JoinColumn(name = "CODEMAG", referencedColumnName = "CODEMAG", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Magazine magazine;
  @JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Article article;

  public Artmag() {}

  public Artmag(ArtmagPK artmagPK) {
    this.artmagPK = artmagPK;
  }

  public Artmag(String codepn, int codemag) {
    this.artmagPK = new ArtmagPK(codepn, codemag);
  }

  public ArtmagPK getArtmagPK() {
    return artmagPK;
  }

  public void setArtmagPK(ArtmagPK artmagPK) {
    this.artmagPK = artmagPK;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public Magazine getMagazine() {
    return magazine;
  }

  public void setMagazine(Magazine magazine) {
    this.magazine = magazine;
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
    hash += (artmagPK != null ? artmagPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Artmag)) {
      return false;
    }
    Artmag other = (Artmag) object;
    if ((this.artmagPK == null && other.artmagPK != null)
        || (this.artmagPK != null && !this.artmagPK.equals(other.artmagPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Artmag[ artmagPK=" + artmagPK + " ]";
  }

}
