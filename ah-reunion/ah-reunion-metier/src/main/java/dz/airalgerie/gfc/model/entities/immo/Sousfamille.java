/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
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
@Table(name = "SOUSFAMILLE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Sousfamille.findAll", query = "SELECT s FROM Sousfamille s")})
public class Sousfamille implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOUSFAMILLEID")
  private Long sousfamilleid;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "sousfamille", fetch = FetchType.LAZY)
  private List<Item> itemList;
  @JoinColumn(name = "FAMILLEID", referencedColumnName = "FAMILLEID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Famille famille;

  public Sousfamille() {}

  public Sousfamille(Long sousfamilleid) {
    this.sousfamilleid = sousfamilleid;
  }

  public Long getSousfamilleid() {
    return sousfamilleid;
  }

  public void setSousfamilleid(Long sousfamilleid) {
    this.sousfamilleid = sousfamilleid;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public Famille getFamille() {
    return famille;
  }

  public void setFamille(Famille famille) {
    this.famille = famille;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (sousfamilleid != null ? sousfamilleid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Sousfamille)) {
      return false;
    }
    Sousfamille other = (Sousfamille) object;
    if ((this.sousfamilleid == null && other.sousfamilleid != null)
        || (this.sousfamilleid != null && !this.sousfamilleid.equals(other.sousfamilleid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Sousfamille[ sousfamilleid=" + sousfamilleid + " ]";
  }

}
