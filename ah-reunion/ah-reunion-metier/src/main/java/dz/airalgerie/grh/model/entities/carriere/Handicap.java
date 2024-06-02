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
@Table(schema = "CAR", name = "HANDICAP")
public class Handicap implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_HND")
  private String codeHnd;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "handicap", fetch = FetchType.LAZY)
  private List<Signalitique> signalitiqueList;

  public Handicap() {}

  public Handicap(String codeHnd) {
    this.codeHnd = codeHnd;
  }

  public String getCodeHnd() {
    return codeHnd;
  }

  public void setCodeHnd(String codeHnd) {
    this.codeHnd = codeHnd;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Signalitique> getSignalitiqueList() {
    return signalitiqueList;
  }

  public void setSignalitiqueList(List<Signalitique> signalitiqueList) {
    this.signalitiqueList = signalitiqueList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeHnd != null ? codeHnd.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Handicap)) {
      return false;
    }
    Handicap other = (Handicap) object;
    if ((this.codeHnd == null && other.codeHnd != null)
        || (this.codeHnd != null && !this.codeHnd.equals(other.codeHnd))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Handicap[ codeHnd=" + codeHnd + " ]";
  }

}
