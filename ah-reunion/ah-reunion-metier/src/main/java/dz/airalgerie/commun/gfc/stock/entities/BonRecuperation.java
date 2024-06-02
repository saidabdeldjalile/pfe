/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "STK.bonRecuperation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonRecuperation.findAll", query = "SELECT b FROM BonRecuperation b"),
    @NamedQuery(name = "BonRecuperation.findByNumBonRecup",
        query = "SELECT b FROM BonRecuperation b WHERE b.bonRecuperationPK.numBonRecup = :numBonRecup"),
    @NamedQuery(name = "BonRecuperation.findByDateTraitRecup",
        query = "SELECT b FROM BonRecuperation b WHERE b.bonRecuperationPK.dateTraitRecup = :dateTraitRecup"),
    @NamedQuery(name = "BonRecuperation.findByDateRecup",
        query = "SELECT b FROM BonRecuperation b WHERE b.dateRecup = :dateRecup"),
    @NamedQuery(name = "BonRecuperation.findByTypeMVT",
        query = "SELECT b FROM BonRecuperation b WHERE b.typeMVT = :typeMVT")})
public class BonRecuperation implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonRecuperationPK bonRecuperationPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateRecup")
  @Temporal(TemporalType.DATE)
  private Date dateRecup;
  @Basic(optional = false)
  @NotNull
  @Column(name = "typeMVT")
  private int typeMVT;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonRecuperation")
  private Collection<ArticleRecuperation> articleRecuperationCollection;

  public BonRecuperation() {}

  public BonRecuperation(BonRecuperationPK bonRecuperationPK) {
    this.bonRecuperationPK = bonRecuperationPK;
  }

  public BonRecuperation(BonRecuperationPK bonRecuperationPK, Date dateRecup, int typeMVT) {
    this.bonRecuperationPK = bonRecuperationPK;
    this.dateRecup = dateRecup;
    this.typeMVT = typeMVT;
  }

  public BonRecuperation(String numBonRecup, int dateTraitRecup) {
    this.bonRecuperationPK = new BonRecuperationPK(numBonRecup, dateTraitRecup);
  }

  public BonRecuperationPK getBonRecuperationPK() {
    return bonRecuperationPK;
  }

  public void setBonRecuperationPK(BonRecuperationPK bonRecuperationPK) {
    this.bonRecuperationPK = bonRecuperationPK;
  }

  public Date getDateRecup() {
    return dateRecup;
  }

  public void setDateRecup(Date dateRecup) {
    this.dateRecup = dateRecup;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

  @XmlTransient
  public Collection<ArticleRecuperation> getArticleRecuperationCollection() {
    return articleRecuperationCollection;
  }

  public void setArticleRecuperationCollection(
      Collection<ArticleRecuperation> articleRecuperationCollection) {
    this.articleRecuperationCollection = articleRecuperationCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonRecuperationPK != null ? bonRecuperationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonRecuperation)) {
      return false;
    }
    BonRecuperation other = (BonRecuperation) object;
    if ((this.bonRecuperationPK == null && other.bonRecuperationPK != null)
        || (this.bonRecuperationPK != null
            && !this.bonRecuperationPK.equals(other.bonRecuperationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonRecuperation[ bonRecuperationPK=" + bonRecuperationPK
        + " ]";
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

}
