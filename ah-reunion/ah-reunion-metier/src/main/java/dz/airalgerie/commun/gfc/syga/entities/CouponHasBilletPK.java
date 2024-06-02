
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Coupon_has_billet database table.
 * 
 */
@Embeddable
public class CouponHasBilletPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "Tronçon_Parcours", insertable = false, updatable = false)
  private String couponParcours;

  @Column(name = "Billet_Num_billet", insertable = false, updatable = false)
  private long billetNumBillet;

  @Column(name = "NUM_PARC")
  private byte numPar;

  public CouponHasBilletPK() {}

  public String getCouponParcours() {
    return this.couponParcours;
  }

  public void setCouponParcours(String couponParcours) {
    this.couponParcours = couponParcours;
  }

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public byte getNumPar() {
    return numPar;
  }

  public void setNumPar(byte numPar) {
    this.numPar = numPar;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (billetNumBillet ^ (billetNumBillet >>> 32));
    result = prime * result + numPar;
    result = prime * result + ((couponParcours == null) ? 0 : couponParcours.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CouponHasBilletPK other = (CouponHasBilletPK) obj;
    if (billetNumBillet != other.billetNumBillet)
      return false;
    if (numPar != other.numPar)
      return false;
    if (couponParcours == null) {
      if (other.couponParcours != null)
        return false;
    } else if (!couponParcours.equals(other.couponParcours))
      return false;
    return true;
  }

}
