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
@Table(schema = "FRM", name = "SOUS_FILIERE")
public class SousFiliere implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_SFL")
  private String codeSfl;
  @Size(max = 100)
  @Column(name = "LIBELLE1")
  private String libelle1;
  @Size(max = 100)
  @Column(name = "LIBELLE2")
  private String libelle2;
  @Size(max = 100)
  @Column(name = "LIBELLE3")
  private String libelle3;
  @OneToMany(mappedBy = "sousFiliere", fetch = FetchType.LAZY)
  private List<FormationInterne> formationIntList;

  public SousFiliere() {}

  public SousFiliere(String codeSfl) {
    this.codeSfl = codeSfl;
  }

  public String getCodeSfl() {
    return codeSfl;
  }

  public void setCodeSfl(String codeSfl) {
    this.codeSfl = codeSfl;
  }

  public String getLibelle1() {
    return libelle1;
  }

  public void setLibelle1(String libelle1) {
    this.libelle1 = libelle1;
  }

  public String getLibelle2() {
    return libelle2;
  }

  public void setLibelle2(String libelle2) {
    this.libelle2 = libelle2;
  }

  public String getLibelle3() {
    return libelle3;
  }

  public void setLibelle3(String libelle3) {
    this.libelle3 = libelle3;
  }

  @XmlTransient
  public List<FormationInterne> getFormationIntList() {
    return formationIntList;
  }

  public void setFormationIntList(List<FormationInterne> formationIntList) {
    this.formationIntList = formationIntList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeSfl != null ? codeSfl.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SousFiliere)) {
      return false;
    }
    SousFiliere other = (SousFiliere) object;
    if ((this.codeSfl == null && other.codeSfl != null)
        || (this.codeSfl != null && !this.codeSfl.equals(other.codeSfl))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.SousFiliere[ codeSfl=" + codeSfl + " ]";
  }

}
