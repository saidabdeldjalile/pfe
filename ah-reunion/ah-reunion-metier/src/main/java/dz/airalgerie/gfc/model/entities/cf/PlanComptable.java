/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.cf;

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

/**
 *
 */
@Entity
@Table(schema = "CF", name = "PLAN_COMPTABLE")
@NamedQueries({
    @NamedQuery(name = "PlanComptable.findAll", query = "SELECT p FROM PlanComptable p")})
public class PlanComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "COMPTE")
  private String compte;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "NB_COMPTE")
  private Integer nbCompte;
  @Size(max = 5)
  @Column(name = "TYPE")
  private String type;

  public PlanComptable() {
  }

  public PlanComptable(String compte) {
    this.compte = compte;
  }

  public String getCompte() {
    return compte;
  }

  public void setCompte(String compte) {
    this.compte = compte;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Integer getNbCompte() {
    return nbCompte;
  }

  public void setNbCompte(Integer nbCompte) {
    this.nbCompte = nbCompte;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (compte != null ? compte.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PlanComptable)) {
      return false;
    }
    PlanComptable other = (PlanComptable) object;
    if ((this.compte == null && other.compte != null)
        || (this.compte != null && !this.compte.equals(other.compte))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cf.PlanComptable[ compte=" + compte + " ]";
  }

}
