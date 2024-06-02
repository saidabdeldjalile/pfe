/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import dz.airalgerie.grh.model.entities.rem.BulletinPointage;
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
 * @author user
 */
@Entity
@Table(name = "POINTAGE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Pointage.findAll", query = "SELECT p FROM Pointage p"),
    @NamedQuery(name = "Pointage.findByCodPoin",
        query = "SELECT p FROM Pointage p WHERE p.codPoin = :codPoin"),
    @NamedQuery(name = "Pointage.findByLibPoin",
        query = "SELECT p FROM Pointage p WHERE p.libPoin = :libPoin")})
public class Pointage implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "COD_POIN")
  private Integer codPoin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIB_POIN")
  private String libPoin;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pointage")
  private Collection<BulletinPointage> bulletinPointageCollection;

  public Pointage() {}

  public Pointage(Integer codPoin) {
    this.codPoin = codPoin;
  }

  public Pointage(Integer codPoin, String libPoin) {
    this.codPoin = codPoin;
    this.libPoin = libPoin;
  }

  public Integer getCodPoin() {
    return codPoin;
  }

  public void setCodPoin(Integer codPoin) {
    this.codPoin = codPoin;
  }

  public String getLibPoin() {
    return libPoin;
  }

  public void setLibPoin(String libPoin) {
    this.libPoin = libPoin;
  }

  @XmlTransient
  public Collection<BulletinPointage> getBulletinPointageCollection() {
    return bulletinPointageCollection;
  }

  public void setBulletinPointageCollection(
      Collection<BulletinPointage> bulletinPointageCollection) {
    this.bulletinPointageCollection = bulletinPointageCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codPoin != null ? codPoin.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pointage)) {
      return false;
    }
    Pointage other = (Pointage) object;
    if ((this.codPoin == null && other.codPoin != null)
        || (this.codPoin != null && !this.codPoin.equals(other.codPoin))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Pointage[ codPoin=" + codPoin + " ]";
  }

}
