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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "STK.bonAchat")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BonAchat.findAll", query = "SELECT b FROM BonAchat b"),
    @NamedQuery(name = "BonAchat.findByNumBonAchat",
        query = "SELECT b FROM BonAchat b WHERE b.bonAchatPK.numBonAchat = :numBonAchat"),
    @NamedQuery(name = "BonAchat.findByDateTraitAchat",
        query = "SELECT b FROM BonAchat b WHERE b.bonAchatPK.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "BonAchat.findByDateAchat",
        query = "SELECT b FROM BonAchat b WHERE b.dateAchat = :dateAchat"),
    @NamedQuery(name = "BonAchat.findByTypeMVT",
        query = "SELECT b FROM BonAchat b WHERE b.typeMVT = :typeMVT"),
    @NamedQuery(name = "BonAchat.findByNumCMD",
        query = "SELECT b FROM BonAchat b WHERE b.numCMD = :numCMD"),
    @NamedQuery(name = "BonAchat.findByTypeCMD",
        query = "SELECT b FROM BonAchat b WHERE b.typeCMD = :typeCMD"),
    @NamedQuery(name = "BonAchat.findByInvent",
        query = "SELECT b FROM BonAchat b WHERE b.invent = :invent"),
    @NamedQuery(name = "BonAchat.findByIdBonAchat",
        query = "SELECT b FROM BonAchat b WHERE b.idBonAchat = :idBonAchat"),
    @NamedQuery(name = "BonAchat.findById", query = "SELECT b FROM BonAchat b WHERE b.id = :id")})
public class BonAchat implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonAchatPK bonAchatPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateAchat")
  @Temporal(TemporalType.DATE)
  private Date dateAchat;
  @Basic(optional = false)
  @NotNull
  @Column(name = "typeMVT")
  private int typeMVT;
  @Size(max = 10)
  @Column(name = "numCMD")
  private String numCMD;
  @Size(max = 10)
  @Column(name = "typeCMD")
  private String typeCMD;
  @Column(name = "invent")
  private int invent;
  @Size(max = 14)
  @Column(name = "idBonAchat")
  private String idBonAchat;

  @Column(name = "id")
  private int id;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonAchat")
  private Collection<ArticleAchat> articleAchatCollection;
  @JoinColumns({@JoinColumn(name = "numFacture", referencedColumnName = "numFacture"),
      @JoinColumn(name = "dateFacture", referencedColumnName = "dateFacture")})
  @ManyToOne
  private Facture facture;

  public BonAchat() {}

  public BonAchat(BonAchatPK bonAchatPK) {
    this.bonAchatPK = bonAchatPK;
  }

  public BonAchat(BonAchatPK bonAchatPK, Date dateAchat, int typeMVT) {
    this.bonAchatPK = bonAchatPK;
    this.dateAchat = dateAchat;
    this.typeMVT = typeMVT;
  }

  public BonAchat(String numBonAchat, int dateTraitAchat) {
    this.bonAchatPK = new BonAchatPK(numBonAchat, dateTraitAchat);
  }

  public BonAchatPK getBonAchatPK() {
    return bonAchatPK;
  }

  public void setBonAchatPK(BonAchatPK bonAchatPK) {
    this.bonAchatPK = bonAchatPK;
  }

  public Date getDateAchat() {
    return dateAchat;
  }

  public void setDateAchat(Date dateAchat) {
    this.dateAchat = dateAchat;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

  public String getNumCMD() {
    return numCMD;
  }

  public void setNumCMD(String numCMD) {
    this.numCMD = numCMD;
  }

  public String getTypeCMD() {
    return typeCMD;
  }

  public void setTypeCMD(String typeCMD) {
    this.typeCMD = typeCMD;
  }

  @XmlTransient
  public Collection<ArticleAchat> getArticleAchatCollection() {
    return articleAchatCollection;
  }

  public void setArticleAchatCollection(Collection<ArticleAchat> articleAchatCollection) {
    this.articleAchatCollection = articleAchatCollection;
  }

  public Facture getFacture() {
    return facture;
  }

  public void setFacture(Facture facture) {
    this.facture = facture;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bonAchatPK != null ? bonAchatPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonAchat)) {
      return false;
    }
    BonAchat other = (BonAchat) object;
    if ((this.bonAchatPK == null && other.bonAchatPK != null)
        || (this.bonAchatPK != null && !this.bonAchatPK.equals(other.bonAchatPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonAchat[ bonAchatPK=" + bonAchatPK + " ]";
  }

  public String getIdBonAchat() {
    return idBonAchat;
  }

  public void setIdBonAchat(String idBonAchat) {
    this.idBonAchat = idBonAchat;
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
