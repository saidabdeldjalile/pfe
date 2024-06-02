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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STK.inventaire")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Inventaire.findAll", query = "SELECT i FROM Inventaire i"),
    @NamedQuery(name = "Inventaire.findByDateTraitInvent",
        query = "SELECT i FROM Inventaire i WHERE i.dateTraitInvent = :dateTraitInvent"),
    @NamedQuery(name = "Inventaire.findByDateValidInvent",
        query = "SELECT i FROM Inventaire i WHERE i.dateValidInvent = :dateValidInvent"),
    @NamedQuery(name = "Inventaire.findByObservation",
        query = "SELECT i FROM Inventaire i WHERE i.observation = :observation")})
public class Inventaire implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitInvent")
  private Integer dateTraitInvent;
  @Column(name = "dateValidInvent")
  @Temporal(TemporalType.DATE)
  private Date dateValidInvent;
  @Column(name = "dateDebutInvent")
  @Temporal(TemporalType.DATE)
  private Date dateDebutInvent;
  @Column(name = "derDateTraitClot")
  private Integer derDateTraitClot;
  @Size(max = 15)
  @Column(name = "typeInv")
  private String typeInv;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventaire")
  private Collection<ArticleInventaire> articleInventaireCollection;

  public Inventaire() {}

  public Inventaire(Integer dateTraitInvent) {
    this.dateTraitInvent = dateTraitInvent;
  }

  public Integer getDateTraitInvent() {
    return dateTraitInvent;
  }

  public void setDateTraitInvent(Integer dateTraitInvent) {
    this.dateTraitInvent = dateTraitInvent;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Date getDateValidInvent() {
    return dateValidInvent;
  }

  public void setDateValidInvent(Date dateValidInvent) {
    this.dateValidInvent = dateValidInvent;
  }

  public Date getDateDebutInvent() {
    return dateDebutInvent;
  }

  public void setDateDebutInvent(Date dateDebutInvent) {
    this.dateDebutInvent = dateDebutInvent;
  }

  public Integer getDerDateTraitClot() {
    return derDateTraitClot;
  }

  public void setDerDateTraitClot(Integer derDateTraitClot) {
    this.derDateTraitClot = derDateTraitClot;
  }

  @XmlTransient
  public Collection<ArticleInventaire> getArticleInventaireCollection() {
    return articleInventaireCollection;
  }

  public void setArticleInventaireCollection(
      Collection<ArticleInventaire> articleInventaireCollection) {
    this.articleInventaireCollection = articleInventaireCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dateTraitInvent != null ? dateTraitInvent.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Inventaire)) {
      return false;
    }
    Inventaire other = (Inventaire) object;
    if ((this.dateTraitInvent == null && other.dateTraitInvent != null)
        || (this.dateTraitInvent != null && !this.dateTraitInvent.equals(other.dateTraitInvent))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Inventaire[ dateTraitInvent=" + dateTraitInvent + " ]";
  }

  public String getTypeInv() {
    return typeInv;
  }

  public void setTypeInv(String typeInv) {
    this.typeInv = typeInv;
  }

}
