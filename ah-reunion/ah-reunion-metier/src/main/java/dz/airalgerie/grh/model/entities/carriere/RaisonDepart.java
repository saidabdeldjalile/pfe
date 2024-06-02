/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "RAISON_DEPART")
public class RaisonDepart implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "RAIS_DEP")
  private String raisDep;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "raisonDepart", fetch = FetchType.LAZY)
  private List<Antecedent> antecedentList;

  public RaisonDepart() {}

  public RaisonDepart(String raisDep) {
    this.raisDep = raisDep;
  }

  public String getRaisDep() {
    return raisDep;
  }

  public void setRaisDep(String raisDep) {
    this.raisDep = raisDep;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Antecedent> getAntecedentList() {
    return antecedentList;
  }

  public void setAntecedentList(List<Antecedent> antecedentList) {
    this.antecedentList = antecedentList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (raisDep != null ? raisDep.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RaisonDepart)) {
      return false;
    }
    RaisonDepart other = (RaisonDepart) object;
    if ((this.raisDep == null && other.raisDep != null)
        || (this.raisDep != null && !this.raisDep.equals(other.raisDep))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.RaisonDepart[ raisDep=" + raisDep + " ]";
  }

}
