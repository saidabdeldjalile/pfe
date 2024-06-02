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
@Table(name = "STK.articleAchat")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ArticleAchat.findAll", query = "SELECT a FROM ArticleAchat a"),
    @NamedQuery(name = "ArticleAchat.findByPn",
        query = "SELECT a FROM ArticleAchat a WHERE a.articleAchatPK.pn = :pn"),
    @NamedQuery(name = "ArticleAchat.findByCodeAppareil",
        query = "SELECT a FROM ArticleAchat a WHERE a.articleAchatPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleAchat.findByNumBonAchat",
        query = "SELECT a FROM ArticleAchat a WHERE a.articleAchatPK.numBonAchat = :numBonAchat"),
    @NamedQuery(name = "ArticleAchat.findByDateTraitAchat",
        query = "SELECT a FROM ArticleAchat a WHERE a.articleAchatPK.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "ArticleAchat.findByDatePeremption",
        query = "SELECT a FROM ArticleAchat a WHERE a.datePeremption = :datePeremption"),
    @NamedQuery(name = "ArticleAchat.findByQuantite",
        query = "SELECT a FROM ArticleAchat a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleAchat.findByValeur",
        query = "SELECT a FROM ArticleAchat a WHERE a.valeur = :valeur")})
public class ArticleAchat implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleAchatPK articleAchatPK;
  @Column(name = "datePeremption")
  @Temporal(TemporalType.DATE)
  private Date datePeremption;
  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @Column(name = "dateModif")
  @Temporal(TemporalType.DATE)
  private Date dateModif;
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
      @JoinColumn(name = "numBonAchat", referencedColumnName = "numBonAchat", insertable = false,
          updatable = false),
      @JoinColumn(name = "dateTraitAchat", referencedColumnName = "dateTraitAchat",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private BonAchat bonAchat;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleAchat() {}

  public ArticleAchat(ArticleAchatPK articleAchatPK) {
    this.articleAchatPK = articleAchatPK;
  }

  public ArticleAchat(ArticleAchatPK articleAchatPK, BigDecimal quantite, BigDecimal valeur) {
    this.articleAchatPK = articleAchatPK;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public ArticleAchat(String pn, String codeAppareil, String numBonAchat, int dateTraitAchat) {
    this.articleAchatPK = new ArticleAchatPK(pn, codeAppareil, numBonAchat, dateTraitAchat);
  }

  public ArticleAchatPK getArticleAchatPK() {
    return articleAchatPK;
  }

  public void setArticleAchatPK(ArticleAchatPK articleAchatPK) {
    this.articleAchatPK = articleAchatPK;
  }

  public Date getDatePeremption() {
    return datePeremption;
  }

  public void setDatePeremption(Date datePeremption) {
    this.datePeremption = datePeremption;
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

  public BonAchat getBonAchat() {
    return bonAchat;
  }

  public void setBonAchat(BonAchat bonAchat) {
    this.bonAchat = bonAchat;
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
    hash += (articleAchatPK != null ? articleAchatPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleAchat)) {
      return false;
    }
    ArticleAchat other = (ArticleAchat) object;
    if ((this.articleAchatPK == null && other.articleAchatPK != null)
        || (this.articleAchatPK != null && !this.articleAchatPK.equals(other.articleAchatPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleAchat[ articleAchatPK=" + articleAchatPK + " ]";
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
