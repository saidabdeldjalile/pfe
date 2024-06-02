/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "ARTICLE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByCodepn",
        query = "SELECT a FROM Article a WHERE a.codepn = :codepn"),
    @NamedQuery(name = "Article.findByDesignation",
        query = "SELECT a FROM Article a WHERE a.designation = :designation"),
    @NamedQuery(name = "Article.findBySection",
        query = "SELECT a FROM Article a WHERE a.section = :section"),
    @NamedQuery(name = "Article.findByStockmin",
        query = "SELECT a FROM Article a WHERE a.stockmin = :stockmin"),
    @NamedQuery(name = "Article.findByStockmax",
        query = "SELECT a FROM Article a WHERE a.stockmax = :stockmax"),
    // @NamedQuery(name = "Article.findByTypestock", query = "SELECT a FROM Article a WHERE
    // a.typestock = :typestock"),
    @NamedQuery(name = "Article.findByCodefab",
        query = "SELECT a FROM Article a WHERE a.codefab = :codefab")})
public class Article implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "CODEPN")
  private String codepn;
  @Size(max = 30)
  @Column(name = "DESIGNATION")
  private String designation;
  @Column(name = "SECTION")
  private Integer section;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "STOCKMIN")
  private BigDecimal stockmin;
  @Column(name = "STOCKMAX")
  private BigDecimal stockmax;
  // @Size(max = 25)
  // @Column(name = "TYPESTOCK")
  // private String typestock;
  @Size(max = 15)
  @Column(name = "CODEFAB")
  private String codefab;
  @JoinTable(name = "ENTERCHANGEABILITE",
      joinColumns = {@JoinColumn(name = "CODEPN_ARTICLE", referencedColumnName = "CODEPN")},
      inverseJoinColumns = {@JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN")})
  @ManyToMany
  private Collection<Article> articleCollection;
  @ManyToMany(mappedBy = "articleCollection")
  private Collection<Article> articleCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<Artba> artbaCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<Artmag> artmagCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<Artbr> artbrCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<Artbs> artbsCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
  private Collection<Etatstock> etatstockCollection;

  public Article() {}

  public Article(String codepn) {
    this.codepn = codepn;
  }

  public String getCodepn() {
    return codepn;
  }

  public void setCodepn(String codepn) {
    this.codepn = codepn;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Integer getSection() {
    return section;
  }

  public void setSection(Integer section) {
    this.section = section;
  }

  public BigDecimal getStockmin() {
    return stockmin;
  }

  public void setStockmin(BigDecimal stockmin) {
    this.stockmin = stockmin;
  }

  public BigDecimal getStockmax() {
    return stockmax;
  }

  public void setStockmax(BigDecimal stockmax) {
    this.stockmax = stockmax;
  }

  // public String getTypestock() {
  // return typestock;
  // }
  //
  // public void setTypestock(String typestock) {
  // this.typestock = typestock;
  // }

  public String getCodefab() {
    return codefab;
  }

  public void setCodefab(String codefab) {
    this.codefab = codefab;
  }

  @XmlTransient
  public Collection<Article> getArticleCollection() {
    return articleCollection;
  }

  public void setArticleCollection(Collection<Article> articleCollection) {
    this.articleCollection = articleCollection;
  }

  @XmlTransient
  public Collection<Article> getArticleCollection1() {
    return articleCollection1;
  }

  public void setArticleCollection1(Collection<Article> articleCollection1) {
    this.articleCollection1 = articleCollection1;
  }

  @XmlTransient
  public Collection<Artba> getArtbaCollection() {
    return artbaCollection;
  }

  public void setArtbaCollection(Collection<Artba> artbaCollection) {
    this.artbaCollection = artbaCollection;
  }

  @XmlTransient
  public Collection<Artmag> getArtmagCollection() {
    return artmagCollection;
  }

  public void setArtmagCollection(Collection<Artmag> artmagCollection) {
    this.artmagCollection = artmagCollection;
  }

  @XmlTransient
  public Collection<Artbr> getArtbrCollection() {
    return artbrCollection;
  }

  public void setArtbrCollection(Collection<Artbr> artbrCollection) {
    this.artbrCollection = artbrCollection;
  }

  @XmlTransient
  public Collection<Artbs> getArtbsCollection() {
    return artbsCollection;
  }

  public void setArtbsCollection(Collection<Artbs> artbsCollection) {
    this.artbsCollection = artbsCollection;
  }

  @XmlTransient
  public Collection<Etatstock> getEtatstockCollection() {
    return etatstockCollection;
  }

  public void setEtatstockCollection(Collection<Etatstock> etatstockCollection) {
    this.etatstockCollection = etatstockCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codepn != null ? codepn.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Article)) {
      return false;
    }
    Article other = (Article) object;
    if ((this.codepn == null && other.codepn != null)
        || (this.codepn != null && !this.codepn.equals(other.codepn))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Article[ codepn=" + codepn + " ]";
  }

}
