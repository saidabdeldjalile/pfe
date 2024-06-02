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
@Table(name = "STK.articleSortie")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ArticleSortie.findAll", query = "SELECT a FROM ArticleSortie a"),
    @NamedQuery(name = "ArticleSortie.findByPn",
        query = "SELECT a FROM ArticleSortie a WHERE a.articleSortiePK.pn = :pn"),
    @NamedQuery(name = "ArticleSortie.findByCodeAppareil",
        query = "SELECT a FROM ArticleSortie a WHERE a.articleSortiePK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleSortie.findByNumBonSortie",
        query = "SELECT a FROM ArticleSortie a WHERE a.articleSortiePK.numBonSortie = :numBonSortie"),
    @NamedQuery(name = "ArticleSortie.findByDateTraitSortie",
        query = "SELECT a FROM ArticleSortie a WHERE a.articleSortiePK.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "ArticleSortie.findByQuantite",
        query = "SELECT a FROM ArticleSortie a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleSortie.findByValeur",
        query = "SELECT a FROM ArticleSortie a WHERE a.valeur = :valeur")})
public class ArticleSortie implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleSortiePK articleSortiePK;
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
  @JoinColumns({
      @JoinColumn(name = "numBonSortie", referencedColumnName = "numBonSortie", insertable = false,
          updatable = false),
      @JoinColumn(name = "dateTraitSortie", referencedColumnName = "dateTraitSortie",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private BonSortie bonSortie;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleSortie() {}

  public ArticleSortie(ArticleSortiePK articleSortiePK) {
    this.articleSortiePK = articleSortiePK;
  }

  public ArticleSortie(ArticleSortiePK articleSortiePK, BigDecimal quantite, BigDecimal valeur) {
    this.articleSortiePK = articleSortiePK;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public ArticleSortie(String pn, String codeAppareil, String numBonSortie, int dateTraitSortie) {
    this.articleSortiePK = new ArticleSortiePK(pn, codeAppareil, numBonSortie, dateTraitSortie);
  }

  public ArticleSortiePK getArticleSortiePK() {
    return articleSortiePK;
  }

  public void setArticleSortiePK(ArticleSortiePK articleSortiePK) {
    this.articleSortiePK = articleSortiePK;
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

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (articleSortiePK != null ? articleSortiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleSortie)) {
      return false;
    }
    ArticleSortie other = (ArticleSortie) object;
    if ((this.articleSortiePK == null && other.articleSortiePK != null)
        || (this.articleSortiePK != null && !this.articleSortiePK.equals(other.articleSortiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleSortie[ articleSortiePK=" + articleSortiePK + " ]";
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
