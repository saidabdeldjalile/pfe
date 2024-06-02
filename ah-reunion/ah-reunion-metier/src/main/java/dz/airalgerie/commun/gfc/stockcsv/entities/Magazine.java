/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MAGAZINE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Magazine.findAll", query = "SELECT m FROM Magazine m"),
    @NamedQuery(name = "Magazine.findByCodemag",
        query = "SELECT m FROM Magazine m WHERE m.codemag = :codemag"),
    @NamedQuery(name = "Magazine.findByLibeller",
        query = "SELECT m FROM Magazine m WHERE m.libeller = :libeller")})
public class Magazine implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODEMAG")
  private Integer codemag;
  @Size(max = 60)
  @Column(name = "LIBELLER")
  private String libeller;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazine")
  private Collection<Artmag> artmagCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazine")
  private Collection<Repaire> repaireCollection;

  public Magazine() {}

  public Magazine(Integer codemag) {
    this.codemag = codemag;
  }

  public Integer getCodemag() {
    return codemag;
  }

  public void setCodemag(Integer codemag) {
    this.codemag = codemag;
  }

  public String getLibeller() {
    return libeller;
  }

  public void setLibeller(String libeller) {
    this.libeller = libeller;
  }

  @XmlTransient
  public Collection<Artmag> getArtmagCollection() {
    return artmagCollection;
  }

  public void setArtmagCollection(Collection<Artmag> artmagCollection) {
    this.artmagCollection = artmagCollection;
  }

  @XmlTransient
  public Collection<Repaire> getRepaireCollection() {
    return repaireCollection;
  }

  public void setRepaireCollection(Collection<Repaire> repaireCollection) {
    this.repaireCollection = repaireCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codemag != null ? codemag.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Magazine)) {
      return false;
    }
    Magazine other = (Magazine) object;
    if ((this.codemag == null && other.codemag != null)
        || (this.codemag != null && !this.codemag.equals(other.codemag))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Magazine[ codemag=" + codemag + " ]";
  }

}
