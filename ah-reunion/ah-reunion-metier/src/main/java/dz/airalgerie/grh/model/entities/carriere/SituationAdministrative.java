/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "SIT_ADMINISTRATIVE")
public class SituationAdministrative implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected SituationAdministrativePK sitAdministrativePK;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_SCE_NAT", referencedColumnName = "CODE_SCE_NAT")
  @ManyToOne(fetch = FetchType.LAZY)
  private ServiceNational serviceNat;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public SituationAdministrative() {}

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public SituationAdministrativePK getSitAdministrativePK() {
    return sitAdministrativePK;
  }

  public void setSitAdministrativePK(SituationAdministrativePK sitAdministrativePK) {
    this.sitAdministrativePK = sitAdministrativePK;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public ServiceNational getServiceNat() {
    return serviceNat;
  }

  public void setServiceNat(ServiceNational serviceNat) {
    this.serviceNat = serviceNat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (sitAdministrativePK != null ? sitAdministrativePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SituationAdministrative)) {
      return false;
    }
    SituationAdministrative other = (SituationAdministrative) object;
    if ((this.sitAdministrativePK == null && other.sitAdministrativePK != null)
        || (this.sitAdministrativePK != null
            && !this.sitAdministrativePK.equals(other.sitAdministrativePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.SituationAdministrative[ matricule=" + sitAdministrativePK + " ]";
  }

}
