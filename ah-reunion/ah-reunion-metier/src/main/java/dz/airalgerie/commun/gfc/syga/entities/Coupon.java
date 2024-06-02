
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the Coupon database table.
 * 
 */
@Entity
@Table(name = "Coupon")
public class Coupon implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Parcours")
  private String parcours;

  // bi-directional many-to-one association to CouponHasBillet
  @OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY)
  private Set<CouponHasBillet> couponHasBillets;

  // bi-directional many-to-one association to Monnaie
  @ManyToOne(fetch = FetchType.LAZY)
  // @Transient
  private Monnaie monnaie;

  public Coupon() {}

  public String getParcours() {
    return this.parcours;
  }

  public void setParcours(String parcours) {
    this.parcours = parcours;
  }

  public Set<CouponHasBillet> getCouponHasBillets() {
    return this.couponHasBillets;
  }

  public void setCouponHasBillets(Set<CouponHasBillet> CouponHasBillets) {
    this.couponHasBillets = CouponHasBillets;
  }

  public Monnaie getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(Monnaie monnaie) {
    this.monnaie = monnaie;
  }

}
