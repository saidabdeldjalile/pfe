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
@Table(schema = "CAR", name = "SERVICE_NAT")
public class ServiceNational implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_SCE_NAT")
  private String codeSceNat;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "serviceNat", fetch = FetchType.LAZY)
  private List<SituationAdministrative> sitAdministrativeList;

  public ServiceNational() {}

  public ServiceNational(String codeSceNat) {
    this.codeSceNat = codeSceNat;
  }

  public String getCodeSceNat() {
    return codeSceNat;
  }

  public void setCodeSceNat(String codeSceNat) {
    this.codeSceNat = codeSceNat;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<SituationAdministrative> getSitAdministrativeList() {
    return sitAdministrativeList;
  }

  public void setSitAdministrativeList(List<SituationAdministrative> sitAdministrativeList) {
    this.sitAdministrativeList = sitAdministrativeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeSceNat != null ? codeSceNat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ServiceNational)) {
      return false;
    }
    ServiceNational other = (ServiceNational) object;
    if ((this.codeSceNat == null && other.codeSceNat != null)
        || (this.codeSceNat != null && !this.codeSceNat.equals(other.codeSceNat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ServiceNational[ codeSceNat=" + codeSceNat + " ]";
  }

}
