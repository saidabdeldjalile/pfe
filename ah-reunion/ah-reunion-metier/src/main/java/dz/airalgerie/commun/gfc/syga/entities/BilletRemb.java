
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the billet_remb database table.
 * 
 */
@Entity
@Table(name = "billet_remb")
public class BilletRemb implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billetNumBillet;

  @Column(name = "Benifi")
  private String benifi;

  @Column(name = "Code_agen")
  private String codeAgent;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_Remb")
  private Date dateRemb;

  @Column(name = "Frais_Rem")
  private double fraisRem;

  @Column(name = "Mt_Net")
  private double mtNet;

  private String note;

  @Column(name = "Remar")
  private String remar;

  @Column(name = "Timbre")
  private double timbre;

  // bi-directional many-to-one association to Monnaie
  @ManyToOne(fetch = FetchType.LAZY)
  private Monnaie monnaie;

  @Transient
  private double fivePercent;

  @Transient
  private double threePercent;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  // bi-directional many-to-one association to ModePaiement
  @ManyToOne(/* cascade=CascadeType.MERGE, */fetch = FetchType.LAZY)
  @JoinColumn(name = "Mode_paiement_Mode_paiement")
  private ModePaiement modePaiement;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public BilletRemb() {}

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public String getBenifi() {
    return this.benifi;
  }

  public void setBenifi(String benifi) {
    this.benifi = benifi;
  }

  public String getCodeAgent() {
    return codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
  }

  public Date getDateRemb() {
    return this.dateRemb;
  }

  public void setDateRemb(Date dateRemb) {
    this.dateRemb = dateRemb;
  }

  public double getFraisRem() {

    return this.fraisRem;
  }

  public void setFraisRem(double fraisRem) {
    this.fraisRem = fraisRem;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public double getMtNet() {
    return mtNet;
  }

  public void setMtNet(double mt_Net) {
    mtNet = mt_Net;
  }

  public ModePaiement getModePaiement() {
    return modePaiement;
  }

  public void setModePaiement(ModePaiement modePaiement) {
    this.modePaiement = modePaiement;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getRemar() {
    return remar;
  }

  public void setRemar(String remar) {
    this.remar = remar;
  }

  public Agence getAgence() {
    return agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Monnaie getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(Monnaie monnaie) {
    this.monnaie = monnaie;
  }

  public double getTimbre() {
    return timbre;
  }

  public void setTimbre(double timbre) {
    this.timbre = timbre;
  }

  public double getFivePercent() {
    return (double) (mtNet * 0.05);
  }

  public double getThreePercent() {
    return (double) (mtNet * 0.03);
  }

}
