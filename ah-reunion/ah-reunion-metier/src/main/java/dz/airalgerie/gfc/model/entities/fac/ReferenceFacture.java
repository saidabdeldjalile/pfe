/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.fac;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Entity
@Table(name = "REFERENCE_FACTURE", schema = ErpConstante.DbSchemaName.CPTA_FAC)
@NamedQueries({
    @NamedQuery(name = "ReferenceFacture.findAll", query = "SELECT r FROM ReferenceFacture r")})
public class ReferenceFacture implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ReferenceFacturePK referenceFacturePK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SEQUENCE")
  private int sequence;

  public ReferenceFacture() {
  }

  public ReferenceFacture(ReferenceFacturePK referenceFacturePK) {
    this.referenceFacturePK = referenceFacturePK;
  }

  public ReferenceFacture(ReferenceFacturePK referenceFacturePK, int sequence) {
    this.referenceFacturePK = referenceFacturePK;
    this.sequence = sequence;
  }

  public ReferenceFacture(String structure, int dateTrt, String typeFacture) {
    this.referenceFacturePK = new ReferenceFacturePK(structure, dateTrt, typeFacture);
  }

  public ReferenceFacturePK getReferenceFacturePK() {
    return referenceFacturePK;
  }

  public void setReferenceFacturePK(ReferenceFacturePK referenceFacturePK) {
    this.referenceFacturePK = referenceFacturePK;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (referenceFacturePK != null ? referenceFacturePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReferenceFacture)) {
      return false;
    }
    ReferenceFacture other = (ReferenceFacture) object;
    if ((this.referenceFacturePK == null && other.referenceFacturePK != null)
        || (this.referenceFacturePK != null
            && !this.referenceFacturePK.equals(other.referenceFacturePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.ReferenceFacture[ referenceFacturePK="
        + referenceFacturePK + " ]";
  }

}
