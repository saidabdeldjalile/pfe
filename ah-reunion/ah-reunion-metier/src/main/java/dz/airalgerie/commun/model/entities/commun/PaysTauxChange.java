/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "PAYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaysTauxChange.findAll", query = "SELECT p FROM PaysTauxChange p"),
    @NamedQuery(name = "PaysTauxChange.findById",
        query = "SELECT p FROM PaysTauxChange p WHERE p.id = :id"),
    @NamedQuery(name = "PaysTauxChange.findByName",
        query = "SELECT p FROM PaysTauxChange p WHERE p.name = :name"),
    @NamedQuery(name = "PaysTauxChange.findByNom",
        query = "SELECT p FROM PaysTauxChange p WHERE p.nom = :nom")})
public class PaysTauxChange implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Size(max = 100)
  @Column(name = "NAME")
  private String name;
  @Size(max = 100)
  @Column(name = "NOM")
  private String nom;
  // @JoinColumn(name = "CODE_MONNAIE", referencedColumnName = "CODE_MONNAIE")
  // @ManyToOne
  // private MonnaieEtg codeMonnaieETG;
  @Column(name = "CODE_MONNAIE")
  private int codeMonnaie;

  public PaysTauxChange() {}

  public PaysTauxChange(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  // public MonnaieEtg getCodeMonnaieETG() {
  // return codeMonnaieETG;
  // }
  //
  // public void setCodeMonnaieETG(MonnaieEtg codeMonnaie) {
  // this.codeMonnaieETG = codeMonnaie;
  // }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  public int getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(int codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PaysTauxChange)) {
      return false;
    }
    PaysTauxChange other = (PaysTauxChange) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.PaysTauxChange[ id=" + id + " ]";
  }

}
