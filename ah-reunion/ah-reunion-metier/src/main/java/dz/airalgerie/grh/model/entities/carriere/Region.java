/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.Wilaya;
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
@Table(schema = "CAR", name = "REGION")
public class Region implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "CODE_REG")
  private String codeReg;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "DESC_REG")
  private String descReg;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.LAZY)
  private List<Wilaya> wilayaList;

  public Region() {}

  public Region(String codeReg) {
    this.codeReg = codeReg;
  }

  public Region(String codeReg, String descReg) {
    this.codeReg = codeReg;
    this.descReg = descReg;
  }

  public String getCodeReg() {
    return codeReg;
  }

  public void setCodeReg(String codeReg) {
    this.codeReg = codeReg;
  }

  public String getDescReg() {
    return descReg;
  }

  public void setDescReg(String descReg) {
    this.descReg = descReg;
  }

  @XmlTransient
  public List<Wilaya> getWilayaList() {
    return wilayaList;
  }

  public void setWilayaList(List<Wilaya> wilayaList) {
    this.wilayaList = wilayaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeReg != null ? codeReg.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Region)) {
      return false;
    }
    Region other = (Region) object;
    if ((this.codeReg == null && other.codeReg != null)
        || (this.codeReg != null && !this.codeReg.equals(other.codeReg))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Region[ codeReg=" + codeReg + " ]";
  }

}
