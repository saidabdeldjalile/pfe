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
@Table(schema = "CAR", name = "LIEN_PARENTE")
public class LienParente implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_LIEN")
  private String codeLien;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "lienParente", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList;

  public LienParente() {}

  public LienParente(String codeLien) {
    this.codeLien = codeLien;
  }

  public String getCodeLien() {
    return codeLien;
  }

  public void setCodeLien(String codeLien) {
    this.codeLien = codeLien;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<PersACharge> getPersAChargeList() {
    return persAChargeList;
  }

  public void setPersAChargeList(List<PersACharge> persAChargeList) {
    this.persAChargeList = persAChargeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeLien != null ? codeLien.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LienParente)) {
      return false;
    }
    LienParente other = (LienParente) object;
    if ((this.codeLien == null && other.codeLien != null)
        || (this.codeLien != null && !this.codeLien.equals(other.codeLien))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.LienParente[ codeLien=" + codeLien + " ]";
  }

}
