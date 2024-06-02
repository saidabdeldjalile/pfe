/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "CLOTURE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Cloture.findAll", query = "SELECT c FROM Cloture c"),
    @NamedQuery(name = "Cloture.findByDatecloture",
        query = "SELECT c FROM Cloture c WHERE c.datecloture = :datecloture"),
    @NamedQuery(name = "Cloture.findByDatereelle",
        query = "SELECT c FROM Cloture c WHERE c.datereelle = :datereelle")})
public class Cloture implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATECLOTURE")
  private Integer datecloture;
  @Column(name = "DATEREELLE")
  @Temporal(TemporalType.DATE)
  private Date datereelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cloture")
  private Collection<Etatstock> etatstockCollection;
  @Column(name = "ISCLOTURE")
  private boolean iscloture;

  public Cloture() {}

  public Cloture(Integer datecloture) {
    this.datecloture = datecloture;
  }

  public Integer getDatecloture() {
    return datecloture;
  }

  public void setDatecloture(Integer datecloture) {
    this.datecloture = datecloture;
  }

  public Date getDatereelle() {
    return datereelle;
  }

  public void setDatereelle(Date datereelle) {
    this.datereelle = datereelle;
  }

  public boolean isIscloture() {
    return iscloture;
  }

  public void setIscloture(boolean iscloture) {
    this.iscloture = iscloture;
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
    hash += (datecloture != null ? datecloture.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cloture)) {
      return false;
    }
    Cloture other = (Cloture) object;
    if ((this.datecloture == null && other.datecloture != null)
        || (this.datecloture != null && !this.datecloture.equals(other.datecloture))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Cloture[ datecloture=" + datecloture + " ]";
  }

}
