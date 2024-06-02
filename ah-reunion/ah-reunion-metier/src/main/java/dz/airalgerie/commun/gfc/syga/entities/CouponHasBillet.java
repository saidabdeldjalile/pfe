
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Coupon_has_billet database table.
 * 
 */
@Entity
@Table(name = "Coupon_has_billet")
public class CouponHasBillet implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private CouponHasBilletPK id;

  @Column(name = "Class")
  private String classe;

  @Column(name = "Transpo")
  private String transpo;

  @Column(name = "Ven_Rem")
  private String venRem;

  @Column(name = "NUM_PAR")
  private byte numPar;

  @Column(name = "not_valide_after")
  private String notValideAfter;

  @Column(name = "not_valide_befor")
  private String notValideBefor;

  @Column(name = "flight_number")
  private String flightNumber;

  @Column(name = "Date")
  private String date;

  @Column(name = "Time")
  private String time;

  @Column(name = "status")
  private String status;

  @Column(name = "Montant")
  private double montant;

  @Transient

  private String basT;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  // bi-directional many-to-one association to coupon
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Tronçon_Parcours")
  private Coupon coupon;

  public CouponHasBillet() {}

  public CouponHasBilletPK getId() {
    return this.id;
  }

  public void setId(CouponHasBilletPK id) {
    this.id = id;
  }

  public String getClasse() {
    return this.classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public String getTranspo() {
    return this.transpo;
  }

  public void setTranspo(String transpo) {
    this.transpo = transpo;
  }

  public String getVenRem() {
    return this.venRem;
  }

  public void setVenRem(String venRem) {
    this.venRem = venRem;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Coupon getCoupon() {
    return this.coupon;
  }

  public void setCoupon(Coupon Coupon) {
    this.coupon = Coupon;
  }

  public byte getNumPar() {
    return numPar;
  }

  public void setNumPar(byte numPar) {
    this.numPar = numPar;
  }

  public String getNotValideAfter() {
    return notValideAfter;
  }

  public void setNotValideAfter(String notValideAfter) {
    this.notValideAfter = notValideAfter;
  }

  public String getNotValideBefor() {
    return notValideBefor;
  }

  public void setNotValideBefor(String notValideBefor) {
    this.notValideBefor = notValideBefor;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void PK() {
    id = new CouponHasBilletPK();
    id.setBilletNumBillet(this.billet.getNumBillet());
    id.setCouponParcours(this.coupon.getParcours());
    id.setNumPar(numPar);
  }

  public double getMontant() {
    return montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public String getBasT() {
    return basT;
  }

  public void setBasT(String bas_T) {
    basT = bas_T;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    CouponHasBillet other = (CouponHasBillet) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
