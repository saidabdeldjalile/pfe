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
@Table(schema = "FRM", name = "DEGRE_LANGUE")
public class DegreLangue implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_DEG")
  private String codeDeg;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "degreLangue", fetch = FetchType.LAZY)
  private List<Langue> langueList;

  public DegreLangue() {}

  public DegreLangue(String codeDeg) {
    this.codeDeg = codeDeg;
  }

  public DegreLangue(String codeDeg, String libelle) {
    this.codeDeg = codeDeg;
    this.libelle = libelle;
  }

  public String getCodeDeg() {
    return codeDeg;
  }

  public void setCodeDeg(String codeDeg) {
    this.codeDeg = codeDeg;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Langue> getLangueList() {
    return langueList;
  }

  public void setLangueList(List<Langue> langueList) {
    this.langueList = langueList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDeg != null ? codeDeg.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DegreLangue)) {
      return false;
    }
    DegreLangue other = (DegreLangue) object;
    if ((this.codeDeg == null && other.codeDeg != null)
        || (this.codeDeg != null && !this.codeDeg.equals(other.codeDeg))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.DegreLangue[ codeDeg=" + codeDeg + " ]";
  }

}
