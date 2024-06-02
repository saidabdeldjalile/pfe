/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.fac;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Embeddable
public class ReferenceFacturePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "STRUCTURE")
  private String structure;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "TYPE_FACTURE")
  private String typeFacture;

  public ReferenceFacturePK() {
  }

  public ReferenceFacturePK(String structure, int dateTrt, String typeFacture) {
    this.structure = structure;
    this.dateTrt = dateTrt;
    this.typeFacture = typeFacture;
  }

  public String getStructure() {
    return structure;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getTypeFacture() {
    return typeFacture;
  }

  public void setTypeFacture(String typeFacture) {
    this.typeFacture = typeFacture;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (structure != null ? structure.hashCode() : 0);
    hash += (int) dateTrt;
    hash += (typeFacture != null ? typeFacture.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReferenceFacturePK)) {
      return false;
    }
    ReferenceFacturePK other = (ReferenceFacturePK) object;
    if ((this.structure == null && other.structure != null)
        || (this.structure != null && !this.structure.equals(other.structure))) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.typeFacture == null && other.typeFacture != null)
        || (this.typeFacture != null && !this.typeFacture.equals(other.typeFacture))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.ReferenceFacturePK[ structure=" + structure
        + ", dateTrt=" + dateTrt + ", typeFacture=" + typeFacture + " ]";
  }

}
