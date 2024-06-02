/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.articleRecuperation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleRecuperation.findAll",
        query = "SELECT a FROM ArticleRecuperation a"),
    @NamedQuery(name = "ArticleRecuperation.findByPn",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.articleRecuperationPK.pn = :pn"),
    @NamedQuery(name = "ArticleRecuperation.findByCodeAppareil",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.articleRecuperationPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleRecuperation.findByNumBonRecup",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.articleRecuperationPK.numBonRecup = :numBonRecup"),
    @NamedQuery(name = "ArticleRecuperation.findByDateTraitRecup",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.articleRecuperationPK.dateTraitRecup = :dateTraitRecup"),
    @NamedQuery(name = "ArticleRecuperation.findByQuantite",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleRecuperation.findByValeur",
        query = "SELECT a FROM ArticleRecuperation a WHERE a.valeur = :valeur")})
public class ArticleRecuperation implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleRecuperationPK articleRecuperationPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantite")
  private BigDecimal quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeur")
  private BigDecimal valeur;
  @JoinColumns({
      @JoinColumn(name = "numBonRecup", referencedColumnName = "numBonRecup", insertable = false,
          updatable = false),
      @JoinColumn(name = "dateTraitRecup", referencedColumnName = "dateTraitRecup",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private BonRecuperation bonRecuperation;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleRecuperation() {}

  public ArticleRecuperation(ArticleRecuperationPK articleRecuperationPK) {
    this.articleRecuperationPK = articleRecuperationPK;
  }

  public ArticleRecuperation(ArticleRecuperationPK articleRecuperationPK, BigDecimal quantite,
      BigDecimal valeur) {
    this.articleRecuperationPK = articleRecuperationPK;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public ArticleRecuperation(String pn, String codeAppareil, String numBonRecup,
      int dateTraitRecup) {
    this.articleRecuperationPK =
        new ArticleRecuperationPK(pn, codeAppareil, numBonRecup, dateTraitRecup);
  }

  public ArticleRecuperationPK getArticleRecuperationPK() {
    return articleRecuperationPK;
  }

  public void setArticleRecuperationPK(ArticleRecuperationPK articleRecuperationPK) {
    this.articleRecuperationPK = articleRecuperationPK;
  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public BonRecuperation getBonRecuperation() {
    return bonRecuperation;
  }

  public void setBonRecuperation(BonRecuperation bonRecuperation) {
    this.bonRecuperation = bonRecuperation;
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
    hash += (articleRecuperationPK != null ? articleRecuperationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleRecuperation)) {
      return false;
    }
    ArticleRecuperation other = (ArticleRecuperation) object;
    if ((this.articleRecuperationPK == null && other.articleRecuperationPK != null)
        || (this.articleRecuperationPK != null
            && !this.articleRecuperationPK.equals(other.articleRecuperationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleRecuperation[ articleRecuperationPK="
        + articleRecuperationPK + " ]";
  }

}
