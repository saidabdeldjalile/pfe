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
@Table(schema = "FRM", name = "ETUDE")
public class Etude implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ETU")
  private Integer codeEtu;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 200)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "etude", fetch = FetchType.LAZY)
  private List<Formation> formationList;

  public Etude() {}

  public Etude(Integer codeEtu) {
    this.codeEtu = codeEtu;
  }

  public Etude(Integer codeEtu, String libelle) {
    this.codeEtu = codeEtu;
    this.libelle = libelle;
  }

  public Integer getCodeEtu() {
    return codeEtu;
  }

  public void setCodeEtu(Integer codeEtu) {
    this.codeEtu = codeEtu;
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
    hash += (codeEtu != null ? codeEtu.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Etude)) {
      return false;
    }
    Etude other = (Etude) object;
    if ((this.codeEtu == null && other.codeEtu != null)
        || (this.codeEtu != null && !this.codeEtu.equals(other.codeEtu))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Etude[ codeEtu=" + codeEtu + " ]";
  }

}
