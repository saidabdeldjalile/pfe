/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

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
@Table(schema = "CAR", name = "CODE_CONJOINT")
public class CodeConjoint implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CNJ")
  private Short codeCnj;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeConjoint", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList;
  @OneToMany(mappedBy = "codeConjoint", fetch = FetchType.LAZY)
  private List<Enfant> enfantList;

  public CodeConjoint() {}

  public CodeConjoint(Short codeCnj) {
    this.codeCnj = codeCnj;
  }

  public Short getCodeCnj() {
    return codeCnj;
  }

  public void setCodeCnj(Short codeCnj) {
    this.codeCnj = codeCnj;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Conjoint> getConjointList() {
    return conjointList;
  }

  public void setConjointList(List<Conjoint> conjointList) {
    this.conjointList = conjointList;
  }

  @XmlTransient
  public List<Enfant> getEnfantList() {
    return enfantList;
  }

  public void setEnfantList(List<Enfant> enfantList) {
    this.enfantList = enfantList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeCnj != null ? codeCnj.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CodeConjoint)) {
      return false;
    }
    CodeConjoint other = (CodeConjoint) object;
    if ((this.codeCnj == null && other.codeCnj != null)
        || (this.codeCnj != null && !this.codeCnj.equals(other.codeCnj))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.CodeConjoint[ codeCnj=" + codeCnj + " ]";
  }

}
