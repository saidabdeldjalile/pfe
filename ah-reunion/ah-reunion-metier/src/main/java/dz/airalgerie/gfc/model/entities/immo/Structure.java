/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "STRUCTURE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Structure.findAll", query = "SELECT s FROM Structure s")})
public class Structure implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "STRUCTUREID")
  private Long structureid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "COMPTE_ANALYTIQUE")
  private long compteAnalytique;
  @Column(name = "UNITEID")
  private Long uniteid;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure", fetch = FetchType.LAZY)
  private List<Pv> pvList;

  public Structure() {}

  public Structure(Long structureid) {
    this.structureid = structureid;
  }

  public Structure(Long structureid, long compteAnalytique) {
    this.structureid = structureid;
    this.compteAnalytique = compteAnalytique;
  }

  public Long getStructureid() {
    return structureid;
  }

  public void setStructureid(Long structureid) {
    this.structureid = structureid;
  }

  public long getCompteAnalytique() {
    return compteAnalytique;
  }

  public void setCompteAnalytique(long compteAnalytique) {
    this.compteAnalytique = compteAnalytique;
  }

  public Long getUniteid() {
    return uniteid;
  }

  public void setUniteid(Long uniteid) {
    this.uniteid = uniteid;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Pv> getPvList() {
    return pvList;
  }

  public void setPvList(List<Pv> pvList) {
    this.pvList = pvList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (structureid != null ? structureid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Structure)) {
      return false;
    }
    Structure other = (Structure) object;
    if ((this.structureid == null && other.structureid != null)
        || (this.structureid != null && !this.structureid.equals(other.structureid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Structure[ structureid=" + structureid + " ]";
  }

}
