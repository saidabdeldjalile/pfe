/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.GrpChap;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(schema = "CAR", name = "UNITE")
public class UniteGrh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_UNIT")
  private String codeUnit;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "DESC_UNIT")
  private String descUnit;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(mappedBy = "unite", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "unite", fetch = FetchType.LAZY)
  private List<GrpChap> grpChapList;

  public UniteGrh() {}

  public UniteGrh(String codeUnit) {
    this.codeUnit = codeUnit;
  }

  public UniteGrh(String codeUnit, String descUnit) {
    this.codeUnit = codeUnit;
    this.descUnit = descUnit;
  }

  public String getCodeUnit() {
    return codeUnit;
  }

  public void setCodeUnit(String codeUnit) {
    this.codeUnit = codeUnit;
  }

  public String getDescUnit() {
    return descUnit;
  }

  public void setDescUnit(String descUnit) {
    this.descUnit = descUnit;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<GrpChap> getGrpChapList() {
    return grpChapList;
  }

  public void setGrpChapList(List<GrpChap> grpChapList) {
    this.grpChapList = grpChapList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeUnit != null ? codeUnit.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UniteGrh)) {
      return false;
    }
    UniteGrh other = (UniteGrh) object;
    if ((this.codeUnit == null && other.codeUnit != null)
        || (this.codeUnit != null && !this.codeUnit.equals(other.codeUnit))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.UniteGrh[ codeUnit=" + codeUnit + " ]";
  }

}
