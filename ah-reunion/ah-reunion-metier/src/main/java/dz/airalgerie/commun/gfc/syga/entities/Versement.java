
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the versement database table.
 * 
 */
@Entity
@Table(name = "versement")
public class Versement implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Numero_reçu")
  private long numero_recu;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_J")
  private Date date_J;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_vers")
  private Date date_vers;

  @Column(name = "Frais_vers")
  private BigDecimal frais_vers;

  @Column(name = "Montant")
  private BigDecimal montant;

  @Transient
  private long numero_recu_p;

  @Transient
  private String date_JI;

  @Transient
  private String date_versI;

  @Column(name = "Hadj")
  private short hadj;

  @Transient
  private boolean hadj_b;

  @Column(name = "Obs")
  private String obs;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public Versement() {

    montant = new BigDecimal(0);
    frais_vers = new BigDecimal(0);
  }

  public long getNumero_recu() {
    return this.numero_recu;
  }

  public void setNumero_recu(long numero_recu) {
    this.numero_recu = numero_recu;
  }

  public Date getDate_J() {
    return this.date_J;
  }

  public void setDate_J(Date date_J) {
    this.date_J = date_J;
  }

  public Date getDate_vers() {
    return this.date_vers;
  }

  public void setDate_vers(Date date_vers) {
    this.date_vers = date_vers;
  }

  public BigDecimal getFrais_vers() {
    return this.frais_vers;
  }

  public void setFrais_vers(BigDecimal frais_vers) {
    this.frais_vers = frais_vers;
  }

  public BigDecimal getMontant() {
    return this.montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public long getNumero_recu_p() {
    return numero_recu_p;
  }

  public void setNumero_recu_p(long numero_recu_p) {
    this.numero_recu_p = numero_recu_p;
  }

  public String getDate_JI() {
    return date_JI;
  }

  public void setDate_JI(String date_JI) {
    this.date_JI = date_JI;
  }

  public String getDate_versI() {
    return date_versI;
  }

  public void setDate_versI(String date_versI) {
    this.date_versI = date_versI;
  }

  public short getHadj() {
    return hadj;
  }

  public void setHadj(short hadj) {
    this.hadj = hadj;
  }

  public boolean isHadj_b() {
    return hadj_b;
  }

  public void setHadj_b(boolean hadj_b) {
    this.hadj_b = hadj_b;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

}
