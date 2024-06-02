/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Administrateur
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ITEMID")
  private long itemid;
  @Size(max = 255)
  @Column(name = "NAME")
  private String name;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAUX_AMORT")
  private Double tauxAmort;
  @Column(name = "DUREE")
  private Double duree;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Column(name = "compte_comptable")
  private BigInteger compteComptable;
  @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
  private List<Pv> pvList;
  @JoinColumn(name = "SOUSFAMILLEID", referencedColumnName = "SOUSFAMILLEID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Sousfamille sousfamille;

  public Item() {}

  public Item(Long id) {
    this.id = id;
  }

  public Item(Long id, long itemid) {
    this.id = id;
    this.itemid = itemid;
  }

  public long getItemid() {
    return itemid;
  }

  public void setItemid(long itemid) {
    this.itemid = itemid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getTauxAmort() {
    return tauxAmort;
  }

  public void setTauxAmort(Double tauxAmort) {
    this.tauxAmort = tauxAmort;
  }

  public Double getDuree() {
    return duree;
  }

  public void setDuree(Double duree) {
    this.duree = duree;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigInteger getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(BigInteger compteComptable) {
    this.compteComptable = compteComptable;
  }

  @XmlTransient
  public List<Pv> getPvList() {
    return pvList;
  }

  public void setPvList(List<Pv> pvList) {
    this.pvList = pvList;
  }

  public Sousfamille getSousfamille() {
    return sousfamille;
  }

  public void setSousfamille(Sousfamille sousfamille) {
    this.sousfamille = sousfamille;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Item)) {
      return false;
    }
    Item other = (Item) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Item[ id=" + id + " ]";
  }

}
