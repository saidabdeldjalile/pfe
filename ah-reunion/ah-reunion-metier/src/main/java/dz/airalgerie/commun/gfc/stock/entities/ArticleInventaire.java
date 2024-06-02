/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import dz.airalgerie.gfc.model.dto.stock.EcartInventaireDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "STK.articleInventaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleInventaire.findAll", query = "SELECT a FROM ArticleInventaire a"),
    @NamedQuery(name = "ArticleInventaire.findByPn",
        query = "SELECT a FROM ArticleInventaire a WHERE a.articleInventairePK.pn = :pn"),
    @NamedQuery(name = "ArticleInventaire.findByCodeAppareil",
        query = "SELECT a FROM ArticleInventaire a WHERE a.articleInventairePK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleInventaire.findByDateTraitInvent",
        query = "SELECT a FROM ArticleInventaire a WHERE a.articleInventairePK.dateTraitInvent = :dateTraitInvent"),
    @NamedQuery(name = "ArticleInventaire.findByQuantitePhy",
        query = "SELECT a FROM ArticleInventaire a WHERE a.quantitePhy = :quantitePhy"),
    @NamedQuery(name = "ArticleInventaire.findByValeurPhy",
        query = "SELECT a FROM ArticleInventaire a WHERE a.valeurPhy = :valeurPhy"),
    @NamedQuery(name = "ArticleInventaire.findByQuantiteCpt",
        query = "SELECT a FROM ArticleInventaire a WHERE a.quantiteCpt = :quantiteCpt"),
    @NamedQuery(name = "ArticleInventaire.findByValeurCpt",
        query = "SELECT a FROM ArticleInventaire a WHERE a.valeurCpt = :valeurCpt"),
    @NamedQuery(name = "ArticleInventaire.findByEcartQte",
        query = "SELECT a FROM ArticleInventaire a WHERE a.ecartQte = :ecartQte"),
    @NamedQuery(name = "ArticleInventaire.findByEcartVal",
        query = "SELECT a FROM ArticleInventaire a WHERE a.ecartVal = :ecartVal")})

@SqlResultSetMapping(name = "EcartsInventaireStocksMapping",
    classes = @ConstructorResult(targetClass = EcartInventaireDto.class,
        columns = {@ColumnResult(name = "PN", type = String.class),
            @ColumnResult(name = "CODE_APPAREIL", type = String.class),
            @ColumnResult(name = "DESIGNATION", type = String.class),
            @ColumnResult(name = "CODEMESURE", type = String.class),
            @ColumnResult(name = "DDM", type = String.class),
            @ColumnResult(name = "MAGASIN_1", type = String.class),
            @ColumnResult(name = "REPERE_1", type = String.class),
            @ColumnResult(name = "RESERVE_1", type = String.class),
            @ColumnResult(name = "MAGASIN_2", type = String.class),
            @ColumnResult(name = "REPERE_2", type = String.class),
            @ColumnResult(name = "RESERVE_2", type = String.class),
            @ColumnResult(name = "DATE_INVENTAIRE", type = String.class),
            @ColumnResult(name = "QUANTITE_COMPTABLE", type = BigDecimal.class),
            @ColumnResult(name = "VALEUR_COMPTABLE", type = BigDecimal.class),
            @ColumnResult(name = "QUANTITE_PHYSIQUE", type = BigDecimal.class),
            @ColumnResult(name = "VALEUR_PHYSIQUE", type = BigDecimal.class),
            @ColumnResult(name = "ECART_QUANTITE", type = BigDecimal.class),
            @ColumnResult(name = "ECART_VALEUR", type = BigDecimal.class),
            @ColumnResult(name = "COMMENTAIRES", type = String.class),
            @ColumnResult(name = "IS_INVENT", type = boolean.class)}))

public class ArticleInventaire implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleInventairePK articleInventairePK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "quantiteCpt")
  private BigDecimal quantiteCpt;
  @Column(name = "valeurCpt")
  private BigDecimal valeurCpt;
  @Column(name = "quantitePhy")
  private BigDecimal quantitePhy;
  @Column(name = "valeurPhy")
  private BigDecimal valeurPhy;
  @Column(name = "ecartQte")
  private BigDecimal ecartQte;
  @Column(name = "ecartVal")
  private BigDecimal ecartVal;
  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @Column(name = "dateModif")
  @Temporal(TemporalType.DATE)
  private Date dateModif;
  @NotNull
  @Column(name = "etat")
  private int etat;
  @Basic(optional = false)
  @Column(name = "dateInventaire")
  @Temporal(TemporalType.DATE)
  private Date dateInventaire;
  @Column(name = "quantiteRamene")
  private BigDecimal quantiteRamene;
  @JoinColumn(name = "dateTraitInvent", referencedColumnName = "dateTraitInvent",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Inventaire inventaire;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public ArticleInventaire() {
  }

  public ArticleInventaire(ArticleInventairePK articleInventairePK) {
    this.articleInventairePK = articleInventairePK;
  }

  public ArticleInventaire(String pn, String codeAppareil, int dateTraitInvent) {
    this.articleInventairePK = new ArticleInventairePK(pn, codeAppareil, dateTraitInvent);
  }

  public ArticleInventairePK getArticleInventairePK() {
    return articleInventairePK;
  }

  public void setArticleInventairePK(ArticleInventairePK articleInventairePK) {
    this.articleInventairePK = articleInventairePK;
  }

  public BigDecimal getQuantitePhy() {
    return quantitePhy;
  }

  public void setQuantitePhy(BigDecimal quantitePhy) {
    this.quantitePhy = quantitePhy;
  }

  public BigDecimal getValeurPhy() {
    return valeurPhy;
  }

  public void setValeurPhy(BigDecimal valeurPhy) {
    this.valeurPhy = valeurPhy;
  }

  public BigDecimal getEcartQte() {
    return ecartQte;
  }

  public void setEcartQte(BigDecimal ecartQte) {
    this.ecartQte = ecartQte;
  }

  public BigDecimal getEcartVal() {
    return ecartVal;
  }

  public void setEcartVal(BigDecimal ecartVal) {
    this.ecartVal = ecartVal;
  }

  public Inventaire getInventaire() {
    return inventaire;
  }

  public void setInventaire(Inventaire inventaire) {
    this.inventaire = inventaire;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (articleInventairePK != null ? articleInventairePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleInventaire)) {
      return false;
    }
    ArticleInventaire other = (ArticleInventaire) object;
    if ((this.articleInventairePK == null && other.articleInventairePK != null)
        || (this.articleInventairePK != null
            && !this.articleInventairePK.equals(other.articleInventairePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleInventaire[ articleInventairePK=" + articleInventairePK
        + " ]";
  }

  public int getEtat() {
    return etat;
  }

  public void setEtat(int etat) {
    this.etat = etat;
  }

  public Date getDateInventaire() {
    return dateInventaire;
  }

  public void setDateInventaire(Date dateInventaire) {
    this.dateInventaire = dateInventaire;
  }

  public BigDecimal getQuantiteRamene() {
    return quantiteRamene;
  }

  public void setQuantiteRamene(BigDecimal quantiteRamene) {
    this.quantiteRamene = quantiteRamene;
  }

  public BigDecimal getQuantiteCpt() {
    return quantiteCpt;
  }

  public void setQuantiteCpt(BigDecimal quantiteCpt) {
    this.quantiteCpt = quantiteCpt;
  }

  public BigDecimal getValeurCpt() {
    return valeurCpt;
  }

  public void setValeurCpt(BigDecimal valeurCpt) {
    this.valeurCpt = valeurCpt;
  }

}
