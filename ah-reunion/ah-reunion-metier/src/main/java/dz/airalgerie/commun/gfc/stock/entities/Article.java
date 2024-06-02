/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.article")
@XmlRootElement

public class Article implements Serializable {
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<PreCloture> preClotureCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<ArticleInventaire> articleInventaireCollection;

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticlePK articlePK;
  @Size(max = 60)
  @Column(name = "designation")
  private String designation;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "codeAH")
  private String codeAH;
  @Size(max = 25)
  @Column(name = "codeATA")
  private String codeATA;
  @Size(max = 25)
  @Column(name = "specification")
  private String specification;
  @Size(max = 1)
  @Column(name = "classe")
  private String classe;
  @Size(max = 1)
  @Column(name = "moteur")
  private String moteur;
  @Size(max = 2)
  @Column(name = "typeApp")
  private String typeApp;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "stkMin")
  private BigDecimal stkMin;
  @Column(name = "stkMax")
  private BigDecimal stkMax;
  @Size(max = 60)
  @Column(name = "typePN")
  private String typePN;
  @Size(max = 20)
  @Column(name = "numeroSerie")
  private String numeroSerie;

  @Column(name = "transfert")
  private Integer transfert;

  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;

  @JoinColumn(name = "codeMesure", referencedColumnName = "codeMesure")
  @ManyToOne
  private UniteMesure codeMesure;
  @JoinColumn(name = "codeFabricant", referencedColumnName = "codeFabricant")
  @ManyToOne
  private Fabricant codeFabricant;
  @JoinColumns({@JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil",
      insertable = false, updatable = false),
      @JoinColumn(name = "typeStock", referencedColumnName = "typeStock")})
  @ManyToOne(optional = false)
  private Appareil appareil;

  public Article() {}

  public Article(ArticlePK articlePK) {
    this.articlePK = articlePK;
  }

  public Article(ArticlePK articlePK, String codeAH) {
    this.articlePK = articlePK;
    this.codeAH = codeAH;
  }

  public Article(String pn, String codeAppareil) {
    this.articlePK = new ArticlePK(pn, codeAppareil);
  }

  public ArticlePK getArticlePK() {
    return articlePK;
  }

  public void setArticlePK(ArticlePK articlePK) {
    this.articlePK = articlePK;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodeAH() {
    return codeAH;
  }

  public void setCodeAH(String codeAH) {
    this.codeAH = codeAH;
  }

  public String getCodeATA() {
    return codeATA;
  }

  public void setCodeATA(String codeATA) {
    this.codeATA = codeATA;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public String getMoteur() {
    return moteur;
  }

  public void setMoteur(String moteur) {
    this.moteur = moteur;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public BigDecimal getStkMin() {
    return stkMin;
  }

  public void setStkMin(BigDecimal stkMin) {
    this.stkMin = stkMin;
  }

  public BigDecimal getStkMax() {
    return stkMax;
  }

  public void setStkMax(BigDecimal stkMax) {
    this.stkMax = stkMax;
  }

  public String getTypePN() {
    return typePN;
  }

  public void setTypePN(String typePN) {
    this.typePN = typePN;
  }

  public UniteMesure getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(UniteMesure codeMesure) {
    this.codeMesure = codeMesure;
  }

  public Fabricant getCodeFabricant() {
    return codeFabricant;
  }

  public void setCodeFabricant(Fabricant codeFabricant) {
    this.codeFabricant = codeFabricant;
  }

  public Appareil getAppareil() {
    return appareil;
  }

  public void setAppareil(Appareil appareil) {
    this.appareil = appareil;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (articlePK != null ? articlePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Article)) {
      return false;
    }
    Article other = (Article) object;
    if ((this.articlePK == null && other.articlePK != null)
        || (this.articlePK != null && !this.articlePK.equals(other.articlePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Article[ articlePK=" + articlePK + " ]";
  }

  public String getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(String numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public Integer getTransfert() {
    return transfert;
  }

  public void setTransfert(Integer transfert) {
    this.transfert = transfert;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }

  @XmlTransient
  public Collection<ArticleInventaire> getArticleInventaireCollection() {
    return articleInventaireCollection;
  }

  public void setArticleInventaireCollection(
      Collection<ArticleInventaire> articleInventaireCollection) {
    this.articleInventaireCollection = articleInventaireCollection;
  }

  @XmlTransient
  public Collection<PreCloture> getPreClotureCollection() {
    return preClotureCollection;
  }

  public void setPreClotureCollection(Collection<PreCloture> preClotureCollection) {
    this.preClotureCollection = preClotureCollection;
  }

}
