/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class FacturePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "numFacture")
  private String numFacture;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateFacture")
  @Temporal(TemporalType.DATE)
  private Date dateFacture;

  public FacturePK() {}

  public FacturePK(String numFacture, Date dateFacture) {
    this.numFacture = numFacture;
    this.dateFacture = dateFacture;
  }

  public String getNumFacture() {
    return numFacture;
  }

  public void setNumFacture(String numFacture) {
    this.numFacture = numFacture;
  }

  public Date getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(Date dateFacture) {
    this.dateFacture = dateFacture;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numFacture != null ? numFacture.hashCode() : 0);
    hash += (dateFacture != null ? dateFacture.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FacturePK)) {
      return false;
    }
    FacturePK other = (FacturePK) object;
    if ((this.numFacture == null && other.numFacture != null)
        || (this.numFacture != null && !this.numFacture.equals(other.numFacture))) {
      return false;
    }
    if ((this.dateFacture == null && other.dateFacture != null)
        || (this.dateFacture != null && !this.dateFacture.equals(other.dateFacture))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.FacturePK[ numFacture=" + numFacture + ", dateFacture="
        + dateFacture + " ]";
  }

}
