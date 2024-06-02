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
@Table(schema = "CAR", name = "CIVILE")
public class Civile implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_CIV")
  private String codeCiv;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "civile", fetch = FetchType.LAZY)
  private List<SituationFamiliale> sitFamilialeList;

  public Civile() {}

  public Civile(String codeCiv) {
    this.codeCiv = codeCiv;
  }

  public Civile(String codeCiv, String libelle) {
    this.codeCiv = codeCiv;
    this.libelle = libelle;
  }

  public String getCodeCiv() {
    return codeCiv;
  }

  public void setCodeCiv(String codeCiv) {
    this.codeCiv = codeCiv;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<SituationFamiliale> getSitFamilialeList() {
    return sitFamilialeList;
  }

  public void setSitFamilialeList(List<SituationFamiliale> sitFamilialeList) {
    this.sitFamilialeList = sitFamilialeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeCiv != null ? codeCiv.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Civile)) {
      return false;
    }
    Civile other = (Civile) object;
    if ((this.codeCiv == null && other.codeCiv != null)
        || (this.codeCiv != null && !this.codeCiv.equals(other.codeCiv))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Civile[ codeCiv=" + codeCiv + " ]";
  }

}
