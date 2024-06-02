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
@Table(schema = "CAR", name = "CONTRAT")
public class Contrat implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "TYPE_CONTRAT")
  private String typeContrat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "DESC_CONTRAT")
  private String descContrat;
  @Column(name = "STATUT")
  private Integer statut;
  @Column(name = "CODE_FIL")
  private String codeFil;
  @OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;

  public Contrat() {}

  public Contrat(String typeContrat) {
    this.typeContrat = typeContrat;
  }

  public Contrat(String typeContrat, String descContrat) {
    this.typeContrat = typeContrat;
    this.descContrat = descContrat;
  }

  public String getTypeContrat() {
    return typeContrat;
  }

  public void setTypeContrat(String typeContrat) {
    this.typeContrat = typeContrat;
  }

  public String getDescContrat() {
    return descContrat;
  }

  public void setDescContrat(String descContrat) {
    this.descContrat = descContrat;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public String getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
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
    hash += (typeContrat != null ? typeContrat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Contrat)) {
      return false;
    }
    Contrat other = (Contrat) object;
    if ((this.typeContrat == null && other.typeContrat != null)
        || (this.typeContrat != null && !this.typeContrat.equals(other.typeContrat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Contrat[ typeContrat=" + typeContrat + " ]";
  }

}
