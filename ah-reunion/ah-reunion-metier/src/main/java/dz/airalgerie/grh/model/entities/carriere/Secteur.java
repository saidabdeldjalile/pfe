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
@Table(schema = "CAR", name = "SECTEUR")
public class Secteur implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_SEC")
  private String codeSec;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
  private List<Antecedent> antecedentList;

  public Secteur() {}

  public Secteur(String codeSec) {
    this.codeSec = codeSec;
  }

  public String getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(String codeSec) {
    this.codeSec = codeSec;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Antecedent> getAntecedentList() {
    return antecedentList;
  }

  public void setAntecedentList(List<Antecedent> antecedentList) {
    this.antecedentList = antecedentList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeSec != null ? codeSec.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Secteur)) {
      return false;
    }
    Secteur other = (Secteur) object;
    if ((this.codeSec == null && other.codeSec != null)
        || (this.codeSec != null && !this.codeSec.equals(other.codeSec))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Secteur[ codeSec=" + codeSec + " ]";
  }

}
