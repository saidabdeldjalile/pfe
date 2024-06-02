
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the cheque database table.
 * 
 */
@Entity
@Table(name = "cheque")
public class Cheque implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_che")
  private long num_che;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_che")
  private Date date_che;

  @Column(name = "Montant")
  private BigDecimal montant;

  @Column(name = "Obser")
  private String obser;

  @Column(name = "Organ")
  private String organ_m;

  @Column(name = "Organ_m")
  private String organ;

  @Column(name = "Titul")
  private String titul;

  @Column(name = "HadjC")
  private short hadj;

  @Transient
  private long num_che_p;

  @Transient
  private boolean hadj_b;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public Cheque() {

    montant = new BigDecimal(0);
  }

  public long getNum_che() {
    return this.num_che;
  }

  public void setNum_che(long num_che) {
    this.num_che = num_che;
  }

  public Date getDate_che() {
    return this.date_che;
  }

  public void setDate_che(Date date_che) {
    this.date_che = date_che;
  }

  public BigDecimal getMontant() {
    return this.montant;
  }

  public void setMontant(BigDecimal montant) {

    this.montant = montant;

  }

  public String getObser() {
    return this.obser;
  }

  public void setObser(String obser) {
    this.obser = obser;
  }

  public String getOrgan() {
    return this.organ;
  }

  public void setOrgan(String organ) {
    this.organ = organ;
  }

  public String getTitul() {
    return this.titul;
  }

  public void setTitul(String titul) {
    this.titul = titul;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public long getNum_che_p() {
    return num_che_p;
  }

  public void setNum_che_p(long num_che_p) {
    this.num_che_p = num_che_p;
  }

  public String getOrgan_m() {
    return organ_m;
  }

  public void setOrgan_m(String organ_m) {
    this.organ_m = organ_m;
  }

  public short getHadj() {
    return hadj;
  }

  public void setHadj(short hadj) {

    this.hadj = hadj;
  }

  public boolean isHadj_b() {

    return this.hadj_b;
  }

  public void setHadj_b(boolean hadj_b) {

    this.hadj_b = hadj_b;
  }

}
