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
@Table(name = "STK.bonVersement")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BonVersement.findAll", query = "SELECT b FROM BonVersement b"),
    @NamedQuery(name = "BonVersement.findByNumBonVers",
        query = "SELECT b FROM BonVersement b WHERE b.bonVersementPK.numBonVers = :numBonVers"),
    @NamedQuery(name = "BonVersement.findByDateTraitVers",
        query = "SELECT b FROM BonVersement b WHERE b.bonVersementPK.dateTraitVers = :dateTraitVers"),
    @NamedQuery(name = "BonVersement.findByDateVers",
        query = "SELECT b FROM BonVersement b WHERE b.dateVers = :dateVers"),
    @NamedQuery(name = "BonVersement.findByTypeMVT",
        query = "SELECT b FROM BonVersement b WHERE b.typeMVT = :typeMVT")})
public class BonVersement implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonVersementPK bonVersementPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateVers")
  @Temporal(TemporalType.DATE)
  private Date dateVers;
  @Basic(optional = false)
  @NotNull
  @Column(name = "typeMVT")
  private int typeMVT;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonVersement")
  private Collection<ArticleVersement> articleVersementCollection;

  public BonVersement() {}

  public BonVersement(BonVersementPK bonVersementPK) {
    this.bonVersementPK = bonVersementPK;
  }

  public BonVersement(BonVersementPK bonVersementPK, Date dateVers, int typeMVT) {
    this.bonVersementPK = bonVersementPK;
    this.dateVers = dateVers;
    this.typeMVT = typeMVT;
  }

  public BonVersement(String numBonVers, int dateTraitVers) {
    this.bonVersementPK = new BonVersementPK(numBonVers, dateTraitVers);
  }

  public BonVersementPK getBonVersementPK() {
    return bonVersementPK;
  }

  public void setBonVersementPK(BonVersementPK bonVersementPK) {
    this.bonVersementPK = bonVersementPK;
  }

  public Date getDateVers() {
    return dateVers;
  }

  public void setDateVers(Date dateVers) {
    this.dateVers = dateVers;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

  @XmlTransient
  public Collection<ArticleVersement> getArticleVersementCollection() {
    return articleVersementCollection;
  }

  public void setArticleVersementCollection(
      Collection<ArticleVersement> articleVersementCollection) {
    this.articleVersementCollection = articleVersementCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonVersementPK != null ? bonVersementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonVersement)) {
      return false;
    }
    BonVersement other = (BonVersement) object;
    if ((this.bonVersementPK == null && other.bonVersementPK != null)
        || (this.bonVersementPK != null && !this.bonVersementPK.equals(other.bonVersementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonVersement[ bonVersementPK=" + bonVersementPK + " ]";
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

}
