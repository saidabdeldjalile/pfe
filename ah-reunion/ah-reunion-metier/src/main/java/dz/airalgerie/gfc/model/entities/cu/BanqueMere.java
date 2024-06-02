/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "BANQUE_MERE")
@NamedQueries({@NamedQuery(name = "BanqueMere.findAll", query = "SELECT b FROM BanqueMere b"),
    @NamedQuery(name = "BanqueMere.findById",
        query = "SELECT b FROM BanqueMere b WHERE b.id = :id"),
    @NamedQuery(name = "BanqueMere.findByLibelle",
        query = "SELECT b FROM BanqueMere b WHERE b.libelle = :libelle")})
public class BanqueMere implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "banqueMere", fetch = FetchType.LAZY)
  private List<BanqueCpta> banqueList;

  public BanqueMere() {
  }

  public BanqueMere(Integer id, String libelle) {
    this.id = id;
    this.libelle = libelle;
  }

  public BanqueMere(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<BanqueCpta> getBanqueList() {
    return banqueList;
  }

  public void setBanqueList(List<BanqueCpta> banqueList) {
    this.banqueList = banqueList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BanqueMere)) {
      return false;
    }
    BanqueMere other = (BanqueMere) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.BanqueMere[ id=" + id + " ]";
  }

}
