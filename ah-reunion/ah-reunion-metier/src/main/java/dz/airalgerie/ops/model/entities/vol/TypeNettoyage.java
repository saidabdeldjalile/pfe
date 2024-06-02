/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities.vol;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "TYPE_NETTOYAGE", schema = ErpConstante.DbSchemaName.OPS)
@NamedQueries({
    @NamedQuery(name = "TypeNettoyage.findAll", query = "SELECT t FROM TypeNettoyage t")})
public class TypeNettoyage implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "TYPE")
  private String type;
  @Size(max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "FREQUENCE")
  private Integer frequence;
  @Column(name = "ALERTE")
  private Integer alerte;
  @OneToMany(mappedBy = "typeNettoyage", fetch = FetchType.LAZY)
  private List<PlanningNettoyage> planningNettoyageList;

  public TypeNettoyage() {
  }

  public TypeNettoyage(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Integer getFrequence() {
    return frequence;
  }

  public void setFrequence(Integer frequence) {
    this.frequence = frequence;
  }

  public Integer getAlerte() {
    return alerte;
  }

  public void setAlerte(Integer alerte) {
    this.alerte = alerte;
  }

  public List<PlanningNettoyage> getPlanningNettoyageList() {
    return planningNettoyageList;
  }

  public void setPlanningNettoyageList(List<PlanningNettoyage> planningNettoyageList) {
    this.planningNettoyageList = planningNettoyageList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (type != null ? type.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TypeNettoyage)) {
      return false;
    }
    TypeNettoyage other = (TypeNettoyage) object;
    if ((this.type == null && other.type != null)
        || (this.type != null && !this.type.equals(other.type))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.vol.TypeNettoyage[ type=" + type + " ]";
  }

}
