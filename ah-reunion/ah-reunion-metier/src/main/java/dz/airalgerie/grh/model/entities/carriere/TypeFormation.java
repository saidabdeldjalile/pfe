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
@Table(schema = "FRM", name = "TYPE_FORMATION")
public class TypeFormation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "TYPE_FRM")
  private String typeFrm;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "typeFormation", fetch = FetchType.LAZY)
  private List<Formation> formationList;

  public TypeFormation() {}

  public TypeFormation(String typeFrm) {
    this.typeFrm = typeFrm;
  }

  public String getTypeFrm() {
    return typeFrm;
  }

  public void setTypeFrm(String typeFrm) {
    this.typeFrm = typeFrm;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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
    hash += (typeFrm != null ? typeFrm.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TypeFormation)) {
      return false;
    }
    TypeFormation other = (TypeFormation) object;
    if ((this.typeFrm == null && other.typeFrm != null)
        || (this.typeFrm != null && !this.typeFrm.equals(other.typeFrm))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.TypeFormation[ typeFrm=" + typeFrm + " ]";
  }

}
