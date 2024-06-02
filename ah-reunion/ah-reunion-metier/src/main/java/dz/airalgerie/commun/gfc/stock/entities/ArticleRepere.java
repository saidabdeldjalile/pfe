/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.articleRepere")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ArticleRepere.findAll", query = "SELECT a FROM ArticleRepere a"),
    @NamedQuery(name = "ArticleRepere.findByPn",
        query = "SELECT a FROM ArticleRepere a WHERE a.articleReperePK.pn = :pn"),
    @NamedQuery(name = "ArticleRepere.findByCodeAppareil",
        query = "SELECT a FROM ArticleRepere a WHERE a.articleReperePK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "ArticleRepere.findByCodeRepere",
        query = "SELECT a FROM ArticleRepere a WHERE a.articleReperePK.codeRepere = :codeRepere"),
    @NamedQuery(name = "ArticleRepere.findByTypeRepere",
        query = "SELECT a FROM ArticleRepere a WHERE a.typeRepere = :typeRepere"),
    @NamedQuery(name = "ArticleRepere.findByObservation",
        query = "SELECT a FROM ArticleRepere a WHERE a.observation = :observation")})
public class ArticleRepere implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ArticleReperePK articleReperePK;
  @Size(max = 15)
  @Column(name = "typeRepere")
  private String typeRepere;
  @Size(max = 2)
  @Column(name = "numRep")
  private String numRep;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  public ArticleRepere() {}

  public ArticleRepere(ArticleReperePK articleReperePK) {
    this.articleReperePK = articleReperePK;
  }

  public ArticleRepere(String pn, String codeAppareil, String codeRepere) {
    this.articleReperePK = new ArticleReperePK(pn, codeAppareil, codeRepere);
  }

  public ArticleReperePK getArticleReperePK() {
    return articleReperePK;
  }

  public void setArticleReperePK(ArticleReperePK articleReperePK) {
    this.articleReperePK = articleReperePK;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public String getTypeRepere() {
    return typeRepere;
  }

  public void setTypeRepere(String typeRepere) {
    this.typeRepere = typeRepere;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (articleReperePK != null ? articleReperePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArticleRepere)) {
      return false;
    }
    ArticleRepere other = (ArticleRepere) object;
    if ((this.articleReperePK == null && other.articleReperePK != null)
        || (this.articleReperePK != null && !this.articleReperePK.equals(other.articleReperePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.ArticleRepere[ articleReperePK=" + articleReperePK + " ]";
  }

  public String getNumRep() {
    return numRep;
  }

  public void setNumRep(String numRep) {
    this.numRep = numRep;
  }

}
