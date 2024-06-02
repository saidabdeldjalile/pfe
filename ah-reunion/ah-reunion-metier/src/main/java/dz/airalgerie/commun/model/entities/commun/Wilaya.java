/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import dz.airalgerie.grh.model.entities.carriere.Carriere;
import dz.airalgerie.grh.model.entities.carriere.PersACharge;
import dz.airalgerie.grh.model.entities.carriere.Region;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(schema = "CAR", name = "WILAYA")
public class Wilaya implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "DESC_WIL")
  private String descWil;
  @Size(max = 10)
  @Column(name = "COMPTE_WIL")
  private String compteWil;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(mappedBy = "wilaya", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "wilaya", fetch = FetchType.LAZY)
  private List<GrpChap> grpChapList;
  @JoinColumn(name = "CODE_REG", referencedColumnName = "CODE_REG")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Region region;
  @OneToMany(mappedBy = "wilaya", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList;

  public Wilaya() {}

  public Wilaya(String codeWil) {
    this.codeWil = codeWil;
  }

  public Wilaya(String codeWil, String descWil) {
    this.codeWil = codeWil;
    this.descWil = descWil;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public String getDescWil() {
    return descWil;
  }

  public void setDescWil(String descWil) {
    this.descWil = descWil;
  }

  public String getCompteWil() {
    return compteWil;
  }

  public void setCompteWil(String compteWil) {
    this.compteWil = compteWil;
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

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  @XmlTransient
  public List<PersACharge> getPersAChargeList() {
    return persAChargeList;
  }

  public void setPersAChargeList(List<PersACharge> persAChargeList) {
    this.persAChargeList = persAChargeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeWil != null ? codeWil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Wilaya)) {
      return false;
    }
    Wilaya other = (Wilaya) object;
    if ((this.codeWil == null && other.codeWil != null)
        || (this.codeWil != null && !this.codeWil.equals(other.codeWil))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Wilaya[ codeWil=" + codeWil + " ]";
  }

}
