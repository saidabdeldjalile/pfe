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
@Table(schema = "CAR", name = "COLLECTIF")
public class Collectif implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_COLLECTIF")
  private String codeCollectif;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "collectif", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;

  public Collectif() {}

  public Collectif(String codeCollectif) {
    this.codeCollectif = codeCollectif;
  }

  public Collectif(String codeCollectif, String libelle) {
    this.codeCollectif = codeCollectif;
    this.libelle = libelle;
  }

  public String getCodeCollectif() {
    return codeCollectif;
  }

  public void setCodeCollectif(String codeCollectif) {
    this.codeCollectif = codeCollectif;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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
    hash += (codeCollectif != null ? codeCollectif.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Collectif)) {
      return false;
    }
    Collectif other = (Collectif) object;
    if ((this.codeCollectif == null && other.codeCollectif != null)
        || (this.codeCollectif != null && !this.codeCollectif.equals(other.codeCollectif))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Collectif[ codeCollectif=" + codeCollectif + " ]";
  }

}
