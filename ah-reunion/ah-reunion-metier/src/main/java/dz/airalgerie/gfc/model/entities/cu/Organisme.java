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
@Table(schema = "CU", name = "ORGANISME")
@NamedQueries({@NamedQuery(name = "Organisme.findAll", query = "SELECT o FROM Organisme o"),
    @NamedQuery(name = "Organisme.findById", query = "SELECT o FROM Organisme o WHERE o.id = :id"),
    @NamedQuery(name = "Organisme.findByLibelle",
        query = "SELECT o FROM Organisme o WHERE o.libelle = :libelle")})
public class Organisme implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "organisme", fetch = FetchType.LAZY)
  private List<FournisseurCpta> fournisseurList;
  @OneToMany(mappedBy = "organisme", fetch = FetchType.LAZY)
  private List<ClientCpta> clientList;

  public Organisme() {
  }

  public Organisme(Integer id, String libelle) {
    this.id = id;
    this.libelle = libelle;
  }

  public Organisme(Integer id) {
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

  public List<FournisseurCpta> getFournisseurList() {
    return fournisseurList;
  }

  public void setFournisseurList(List<FournisseurCpta> fournisseurList) {
    this.fournisseurList = fournisseurList;
  }

  public List<ClientCpta> getClientList() {
    return clientList;
  }

  public void setClientList(List<ClientCpta> clientList) {
    this.clientList = clientList;
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
    if (!(object instanceof Organisme)) {
      return false;
    }
    Organisme other = (Organisme) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ID:" + this.getId() + " - LIBELLE:" + this.getLibelle();
  }
  
  public String autoCompleteLibelle() {
    return libelle + " - " + id;
  }

}
