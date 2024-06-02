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
@Table(schema = "FRM", name = "THEME")
public class Theme implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_THM")
  private Integer codeThm;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
  private List<FormationInterne> formationIntList;

  public Theme() {}

  public Theme(Integer codeThm) {
    this.codeThm = codeThm;
  }

  public Theme(Integer codeThm, String libelle) {
    this.codeThm = codeThm;
    this.libelle = libelle;
  }

  public Integer getCodeThm() {
    return codeThm;
  }

  public void setCodeThm(Integer codeThm) {
    this.codeThm = codeThm;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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
    hash += (codeThm != null ? codeThm.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Theme)) {
      return false;
    }
    Theme other = (Theme) object;
    if ((this.codeThm == null && other.codeThm != null)
        || (this.codeThm != null && !this.codeThm.equals(other.codeThm))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Theme[ codeThm=" + codeThm + " ]";
  }

}
