/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.articleReintegration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleReintegration.findAll",
        query = "SELECT a FROM ArticleReintegration a"),
    @NamedQuery(name = "ArticleReintegration.findByPn",
        query = "SELECT a FROM ArticleReintegration a WHERE a.articleReintegrationPK.pn = :pn"),
    @NamedQuery(name = "ArticleReintegration.findByCodeAppareil",
        query = "SELECT a FROM ArticleReintegration a WHERE a.articleReintegrationPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleReintegration.findByNumBonReint",
        query = "SELECT a FROM ArticleReintegration a WHERE a.articleReintegrationPK.numBonReint = :numBonReint"),
    @NamedQuery(name = "ArticleReintegration.findByDateTraitReint",
        query = "SELECT a FROM ArticleReintegration a WHERE a.articleReintegrationPK.dateTraitReint = :dateTraitReint"),
    @NamedQuery(name = "ArticleReintegration.findByQuantite",
        query = "SELECT a FROM ArticleReintegration a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleReintegration.findByValeur",
        query = "SELECT a FROM ArticleReintegration a WHERE a.valeur = :valeur")})
public class ArticleReintegration implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleReintegrationPK articleReintegrationPK;
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
  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @Column(name = "dateModif")
  @Temporal(TemporalType.DATE)
  private Date dateModif;
  @JoinColumns({@JoinColumn(name = "numBonSortie", referencedColumnName = "numBonSortie"),
      @JoinColumn(name = "dateTraitSortie", referencedColumnName = "dateTraitSortie")})
  @ManyToOne
  private BonSortie bonSortie;
  @JoinColumns({
      @JoinColumn(name = "numBonReint", referencedColumnName = "numBonReint", insertable = false,
          updatable = false),
      @JoinColumn(name = "dateTraitReint", referencedColumnName = "dateTraitReint",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private BonReintegration bonReintegration;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleReintegration() {}

  public ArticleReintegration(ArticleReintegrationPK articleReintegrationPK) {
    this.articleReintegrationPK = articleReintegrationPK;
  }

  public ArticleReintegration(ArticleReintegrationPK articleReintegrationPK, BigDecimal quantite,
      BigDecimal valeur) {
    this.articleReintegrationPK = articleReintegrationPK;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public ArticleReintegration(String pn, String codeAppareil, String numBonReint,
      int dateTraitReint) {
    this.articleReintegrationPK =
        new ArticleReintegrationPK(pn, codeAppareil, numBonReint, dateTraitReint);
  }

  public ArticleReintegrationPK getArticleReintegrationPK() {
    return articleReintegrationPK;
  }

  public void setArticleReintegrationPK(ArticleReintegrationPK articleReintegrationPK) {
    this.articleReintegrationPK = articleReintegrationPK;
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

  public BonSortie getBonSortie() {
    return bonSortie;
  }

  public void setBonSortie(BonSortie bonSortie) {
    this.bonSortie = bonSortie;
  }

  public BonReintegration getBonReintegration() {
    return bonReintegration;
  }

  public void setBonReintegration(BonReintegration bonReintegration) {
    this.bonReintegration = bonReintegration;
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
    hash += (articleReintegrationPK != null ? articleReintegrationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleReintegration)) {
      return false;
    }
    ArticleReintegration other = (ArticleReintegration) object;
    if ((this.articleReintegrationPK == null && other.articleReintegrationPK != null)
        || (this.articleReintegrationPK != null
            && !this.articleReintegrationPK.equals(other.articleReintegrationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleReintegration[ articleReintegrationPK="
        + articleReintegrationPK + " ]";
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Date getDateModif() {
    return dateModif;
  }

  public void setDateModif(Date dateModif) {
    this.dateModif = dateModif;
  }

}
