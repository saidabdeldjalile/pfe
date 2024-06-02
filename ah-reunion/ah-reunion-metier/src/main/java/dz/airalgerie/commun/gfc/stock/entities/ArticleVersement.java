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
@Table(name = "STK.articleVersement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleVersement.findAll", query = "SELECT a FROM ArticleVersement a"),
    @NamedQuery(name = "ArticleVersement.findByPn",
        query = "SELECT a FROM ArticleVersement a WHERE a.articleVersementPK.pn = :pn"),
    @NamedQuery(name = "ArticleVersement.findByCodeAppareil",
        query = "SELECT a FROM ArticleVersement a WHERE a.articleVersementPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleVersement.findByNumBonVers",
        query = "SELECT a FROM ArticleVersement a WHERE a.articleVersementPK.numBonVers = :numBonVers"),
    @NamedQuery(name = "ArticleVersement.findByDateTraitVers",
        query = "SELECT a FROM ArticleVersement a WHERE a.articleVersementPK.dateTraitVers = :dateTraitVers"),
    @NamedQuery(name = "ArticleVersement.findByQuantite",
        query = "SELECT a FROM ArticleVersement a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleVersement.findByValeur",
        query = "SELECT a FROM ArticleVersement a WHERE a.valeur = :valeur")})
public class ArticleVersement implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleVersementPK articleVersementPK;
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
      @JoinColumn(name = "numBonVers", referencedColumnName = "numBonVers", insertable = false,
          updatable = false),
      @JoinColumn(name = "dateTraitVers", referencedColumnName = "dateTraitVers",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private BonVersement bonVersement;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleVersement() {}

  public ArticleVersement(ArticleVersementPK articleVersementPK) {
    this.articleVersementPK = articleVersementPK;
  }

  public ArticleVersement(ArticleVersementPK articleVersementPK, BigDecimal quantite,
      BigDecimal valeur) {
    this.articleVersementPK = articleVersementPK;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public ArticleVersement(String pn, String codeAppareil, String numBonVers, int dateTraitVers) {
    this.articleVersementPK = new ArticleVersementPK(pn, codeAppareil, numBonVers, dateTraitVers);
  }

  public ArticleVersementPK getArticleVersementPK() {
    return articleVersementPK;
  }

  public void setArticleVersementPK(ArticleVersementPK articleVersementPK) {
    this.articleVersementPK = articleVersementPK;
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

  public BonVersement getBonVersement() {
    return bonVersement;
  }

  public void setBonVersement(BonVersement bonVersement) {
    this.bonVersement = bonVersement;
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
    hash += (articleVersementPK != null ? articleVersementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleVersement)) {
      return false;
    }
    ArticleVersement other = (ArticleVersement) object;
    if ((this.articleVersementPK == null && other.articleVersementPK != null)
        || (this.articleVersementPK != null
            && !this.articleVersementPK.equals(other.articleVersementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleVersement[ articleVersementPK=" + articleVersementPK
        + " ]";
  }

}
