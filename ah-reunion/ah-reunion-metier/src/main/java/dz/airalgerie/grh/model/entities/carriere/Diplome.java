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
@Table(schema = "FRM", name = "DIPLOME")
public class Diplome implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_DIP")
  private Integer codeDip;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 200)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "diplome", fetch = FetchType.LAZY)
  private List<FormationInterne> formationIntList;
  @OneToMany(mappedBy = "diplome", fetch = FetchType.LAZY)
  private List<Formation> formationList;

  public Diplome() {}

  public Diplome(Integer codeDip) {
    this.codeDip = codeDip;
  }

  public Diplome(Integer codeDip, String libelle) {
    this.codeDip = codeDip;
    this.libelle = libelle;
  }

  public Integer getCodeDip() {
    return codeDip;
  }

  public void setCodeDip(Integer codeDip) {
    this.codeDip = codeDip;
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

  @XmlTransient
  public List<Formation> getFormationList() {
    return formationList;
  }

  public void setFormationList(List<Formation> formationList) {
    this.formationList = formationList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDip != null ? codeDip.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Diplome)) {
      return false;
    }
    Diplome other = (Diplome) object;
    if ((this.codeDip == null && other.codeDip != null)
        || (this.codeDip != null && !this.codeDip.equals(other.codeDip))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Diplome[ codeDip=" + codeDip + " ]";
  }

}
