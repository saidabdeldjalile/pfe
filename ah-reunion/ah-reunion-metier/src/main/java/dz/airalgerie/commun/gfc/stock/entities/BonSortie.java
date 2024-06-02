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
@Table(name = "STK.bonSortie")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BonSortie.findAll", query = "SELECT b FROM BonSortie b"),
    @NamedQuery(name = "BonSortie.findByNumBonSortie",
        query = "SELECT b FROM BonSortie b WHERE b.bonSortiePK.numBonSortie = :numBonSortie"),
    @NamedQuery(name = "BonSortie.findByDateTraitSortie",
        query = "SELECT b FROM BonSortie b WHERE b.bonSortiePK.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "BonSortie.findByDateSortie",
        query = "SELECT b FROM BonSortie b WHERE b.dateSortie = :dateSortie"),
    @NamedQuery(name = "BonSortie.findByTypeMVT",
        query = "SELECT b FROM BonSortie b WHERE b.typeMVT = :typeMVT"),
    @NamedQuery(name = "BonSortie.findByCodeCI",
        query = "SELECT b FROM BonSortie b WHERE b.codeCI = :codeCI"),
    @NamedQuery(name = "BonSortie.findByVisite",
        query = "SELECT b FROM BonSortie b WHERE b.visite = :visite"),
    @NamedQuery(name = "BonSortie.findByImmatriculation",
        query = "SELECT b FROM BonSortie b WHERE b.immatriculation = :immatriculation"),
    @NamedQuery(name = "BonSortie.findByNumLot",
        query = "SELECT b FROM BonSortie b WHERE b.numLot = :numLot"),
    @NamedQuery(name = "BonSortie.findByInvent",
        query = "SELECT b FROM BonSortie b WHERE b.invent = :invent"),
    @NamedQuery(name = "BonSortie.findByCodeAtelier",
        query = "SELECT b FROM BonSortie b WHERE b.codeAtelier = :codeAtelier"),
    @NamedQuery(name = "BonSortie.findByIdBonSortie",
        query = "SELECT b FROM BonSortie b WHERE b.idBonSortie = :idBonSortie"),
    @NamedQuery(name = "BonSortie.findById", query = "SELECT b FROM BonSortie b WHERE b.id = :id")})

public class BonSortie implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BonSortiePK bonSortiePK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateSortie")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "typeMVT")
  private int typeMVT;
  @Size(max = 12)
  @Column(name = "codeCI")
  private String codeCI;
  @Size(max = 10)
  @Column(name = "visite")
  private String visite;
  @Size(max = 6)
  @Column(name = "immatriculation")
  private String immatriculation;
  @Size(max = 15)
  @Column(name = "numLot")
  private String numLot;
  @Column(name = "invent")
  private int invent;
  @Size(max = 14)
  @Column(name = "idBonSortie")
  private String idBonSortie;

  @Column(name = "id")
  private int id;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  @JoinColumn(name = "codeClient", referencedColumnName = "codeClient")
  @ManyToOne
  private Client codeClient;

  @JoinColumn(name = "codeAtelier", referencedColumnName = "codeAtelier")
  @ManyToOne
  private Atelier codeAtelier;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonSortie")
  private Collection<ArticleSortie> articleSortieCollection;
  @OneToMany(mappedBy = "bonSortie")
  private Collection<ArticleReintegration> articleReintegrationCollection;

  public BonSortie() {}

  public BonSortie(BonSortiePK bonSortiePK) {
    this.bonSortiePK = bonSortiePK;
  }

  public BonSortie(BonSortiePK bonSortiePK, Date dateSortie, int typeMVT) {
    this.bonSortiePK = bonSortiePK;
    this.dateSortie = dateSortie;
    this.typeMVT = typeMVT;
  }

  public BonSortie(String numBonSortie, int dateTraitSortie) {
    this.bonSortiePK = new BonSortiePK(numBonSortie, dateTraitSortie);
  }

  public BonSortiePK getBonSortiePK() {
    return bonSortiePK;
  }

  public void setBonSortiePK(BonSortiePK bonSortiePK) {
    this.bonSortiePK = bonSortiePK;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

  public String getCodeCI() {
    return codeCI;
  }

  public void setCodeCI(String codeCI) {
    this.codeCI = codeCI;
  }

  public String getVisite() {
    return visite;
  }

  public void setVisite(String visite) {
    this.visite = visite;
  }

  public String getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(String immatriculation) {
    this.immatriculation = immatriculation;
  }

  public String getNumLot() {
    return numLot;
  }

  public void setNumLot(String numLot) {
    this.numLot = numLot;
  }

  public Client getCodeClient() {
    return codeClient;
  }

  public void setCodeClient(Client codeClient) {
    this.codeClient = codeClient;
  }

  @XmlTransient
  public Collection<ArticleSortie> getArticleSortieCollection() {
    return articleSortieCollection;
  }

  public void setArticleSortieCollection(Collection<ArticleSortie> articleSortieCollection) {
    this.articleSortieCollection = articleSortieCollection;
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
    hash += (bonSortiePK != null ? bonSortiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BonSortie)) {
      return false;
    }
    BonSortie other = (BonSortie) object;
    if ((this.bonSortiePK == null && other.bonSortiePK != null)
        || (this.bonSortiePK != null && !this.bonSortiePK.equals(other.bonSortiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.BonSortie[ bonSortiePK=" + bonSortiePK + " ]";
  }

  public String getIdBonSortie() {
    return idBonSortie;
  }

  public void setIdBonSortie(String idBonSortie) {
    this.idBonSortie = idBonSortie;
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

  public Atelier getCodeAtelier() {
    return codeAtelier;
  }

  public void setCodeAtelier(Atelier codeAtelier) {
    this.codeAtelier = codeAtelier;
  }

  public int getInvent() {
    return invent;
  }

  public void setInvent(int invent) {
    this.invent = invent;
  }
}
