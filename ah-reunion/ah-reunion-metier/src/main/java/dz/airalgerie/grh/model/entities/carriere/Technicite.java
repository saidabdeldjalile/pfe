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
@Table(schema = "CAR", name = "TECHNICITE")
public class Technicite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_TECH")
  private String codeTech;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "DESC_TECH")
  private String descTech;
  @OneToMany(mappedBy = "technicite", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;

  public Technicite() {}

  public Technicite(String codeTech) {
    this.codeTech = codeTech;
  }

  public Technicite(String codeTech, String descTech) {
    this.codeTech = codeTech;
    this.descTech = descTech;
  }

  public String getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(String codeTech) {
    this.codeTech = codeTech;
  }

  public String getDescTech() {
    return descTech;
  }

  public void setDescTech(String descTech) {
    this.descTech = descTech;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeTech != null ? codeTech.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Technicite)) {
      return false;
    }
    Technicite other = (Technicite) object;
    if ((this.codeTech == null && other.codeTech != null)
        || (this.codeTech != null && !this.codeTech.equals(other.codeTech))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Technicite[ codeTech=" + codeTech + " ]";
  }

}
