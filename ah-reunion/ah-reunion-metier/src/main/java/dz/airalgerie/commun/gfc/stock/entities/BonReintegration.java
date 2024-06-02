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
@Table(name = "STK.bonReintegration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonReintegration.findAll", query = "SELECT b FROM BonReintegration b"),
    @NamedQuery(name = "BonReintegration.findByNumBonReint",
        query = "SELECT b FROM BonReintegration b WHERE b.bonReintegrationPK.numBonReint = :numBonReint"),
    @NamedQuery(name = "BonReintegration.findByDateTraitReint",
        query = "SELECT b FROM BonReintegration b WHERE b.bonReintegrationPK.dateTraitReint = :dateTraitReint"),
    @NamedQuery(name = "BonReintegration.findByDateReint",
        query = "SELECT b FROM BonReintegration b WHERE b.dateReint = :dateReint"),
    @NamedQuery(name = "BonReintegration.findByTypeMvt",
        query = "SELECT b FROM BonReintegration b WHERE b.typeMvt = :typeMvt"),
    @NamedQuery(name = "BonReintegration.findByInvent",
        query = "SELECT b FROM BonReintegration b WHERE b.invent = :invent"),
    @NamedQuery(name = "BonReintegration.findByIdBonReint",
        query = "SELECT b FROM BonReintegration b WHERE b.idBonReint = :idBonReint"),
    @NamedQuery(name = "BonReintegration.findById",
        query = "SELECT b FROM BonReintegration b WHERE b.id = :id")})
public class BonReintegration implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonReintegrationPK bonReintegrationPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateReint")
  @Temporal(TemporalType.DATE)
  private Date dateReint;
  @Basic(optional = false)
  @NotNull
  @Column(name = "typeMvt")
  private int typeMvt;
  @Column(name = "invent")
  private int invent;
  @Size(max = 14)
  @Column(name = "idBonReint")
  private String idBonReint;

  @Column(name = "id")
  private int id;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonReintegration")
  private Collection<ArticleReintegration> articleReintegrationCollection;

  public BonReintegration() {}

  public BonReintegration(BonReintegrationPK bonReintegrationPK) {
    this.bonReintegrationPK = bonReintegrationPK;
  }

  public BonReintegration(BonReintegrationPK bonReintegrationPK, Date dateReint, int typeMvt) {
    this.bonReintegrationPK = bonReintegrationPK;
    this.dateReint = dateReint;
    this.typeMvt = typeMvt;
  }

  public BonReintegration(String numBonReint, int dateTraitReint) {
    this.bonReintegrationPK = new BonReintegrationPK(numBonReint, dateTraitReint);
  }

  public BonReintegrationPK getBonReintegrationPK() {
    return bonReintegrationPK;
  }

  public void setBonReintegrationPK(BonReintegrationPK bonReintegrationPK) {
    this.bonReintegrationPK = bonReintegrationPK;
  }

  public Date getDateReint() {
    return dateReint;
  }

  public void setDateReint(Date dateReint) {
    this.dateReint = dateReint;
  }

  public int getTypeMvt() {
    return typeMvt;
  }

  public void setTypeMvt(int typeMvt) {
    this.typeMvt = typeMvt;
  }

  @XmlTransient
  public Collection<ArticleReintegration> getArticleReintegrationCollection() {
    return articleReintegrationCollection;
  }

  public void setArticleReintegrationCollection(
      Collection<ArticleReintegration> articleReintegrationCollection) {
    this.articleReintegrationCollection = articleReintegrationCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonReintegrationPK != null ? bonReintegrationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonReintegration)) {
      return false;
    }
    BonReintegration other = (BonReintegration) object;
    if ((this.bonReintegrationPK == null && other.bonReintegrationPK != null)
        || (this.bonReintegrationPK != null
            && !this.bonReintegrationPK.equals(other.bonReintegrationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonReintegration[ bonReintegrationPK=" + bonReintegrationPK
        + " ]";
  }

  public String getIdBonReint() {
    return idBonReint;
  }

  public void setIdBonReint(String idBonReint) {
    this.idBonReint = idBonReint;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public int getInvent() {
    return invent;
  }

  public void setInvent(int invent) {
    this.invent = invent;
  }

}
