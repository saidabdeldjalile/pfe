
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the billet database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "billet")
public class Billet implements Serializable, java.lang.Comparable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_billet")
  private long numBillet;

  @Temporal(TemporalType.DATE)

  @Column(name = "Date_elaboration")
  private Date dateElaboration;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_emis")
  private Date dateEmis;

  @Column(name = "Etat_doc")
  private String etatDoc;

  @Column(name = "Motif_ech")
  private String motifEch;

  @Column(name = "note")
  private String note;

  @Column(name = "Nb_Coup")
  private int nbCoup;

  @Column(name = "Mt_Net")
  private double mtNet;

  @Column(name = "transfere")
  private String transfere;

  @Column(name = "Timbre")
  private double timbre;

  // @Transient
  @Column(name = "num_ffp")
  private String numFfp;

  // bi-directional many-to-one association to Monnaie
  @ManyToOne(fetch = FetchType.LAZY)
  private Monnaie monnaie;

  // @Transient
  @Column(name = "hadj")
  private short hadj;

  // @Transient
  @Column(name = "comp_tarifaire")
  private String compTarifaire;

  @Transient
  private char etat;

  @Transient
  private boolean hadjB;

  @Transient
  private double fivePercent;

  @Transient
  private double threePercent;

  // bi-directional one-to-one association to Bcb
  // @OneToOne(mappedBy="billet")
  // private Bcb bcb;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  // bi-directional many-to-one association to Badc
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BADC_Num_bor")
  private Badc badc;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY)
  private Set<Billet> billets;

  // bi-directional many-to-one association to BonCommande
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Bon_commande_Num_bon_cam")
  private BonCommande bonCommande;

  // bi-directional many-to-one association to Ebr
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EBR_Num_EBR")
  private Ebr ebr;

  // bi-directional many-to-one association to Ebv
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EBV_Num_EBV")
  private Ebv ebv;

  // bi-directional many-to-one association to BilletHasModeRemb
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private Set<BilletHasModeRemb> billetHasModeRembs;

  // bi-directional many-to-one association to BilletHasTaxe
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY,
      cascade = {CascadeType.REMOVE, CascadeType.MERGE})
  private Set<BilletHasTaxe> billetHasTaxes;

  @Transient
  private List<BilletHasTaxe> billethastaxes;

  // bi-directional one-to-one association to BilletRemb
  // @OneToOne(mappedBy="billet")
  // private BilletRemb billetRemb;

  // bi-directional one-to-one association to ETicket
  // @OneToOne(mappedBy="billet")
  // private ETicket ETicket;

  // bi-directional one-to-one association to Mco
  // @OneToOne(mappedBy="billet")
  // private Mco mco;

  // bi-directional many-to-one association to ModePaiementHasBillet
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY,
      cascade = {CascadeType.REMOVE, CascadeType.MERGE})
  private Set<ModePaiementHasBillet> modePaiementHasBillets;

  // bi-directional one-to-one association to Pax
  // @OneToOne(mappedBy="billet")
  // private Pax pax;

  // bi-directional many-to-one association to TaxeHasBilletRem
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private Set<TaxeHasBilletRem> taxeHasBilletRems;

  // bi-directional many-to-one association to CouponHasBillet
  @OneToMany(mappedBy = "billet", fetch = FetchType.LAZY,
      cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  private Set<CouponHasBillet> CouponHasBillets;

  // bi-directional many-to-one association to Bodoan
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BoDoAn_Num_Bor")
  private Bodoan bodoan;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BorAvoir_Num_Bor")
  private BorAvoir borAvoir;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BordereauEnvoi_Num_Bor")
  private BordereauEnvoi bordereauEnvoi;

  // bi-directional one-to-one association to Emd
  // @OneToOne(mappedBy="billet")
  // private Emd emd;

  // bi-directional many-to-one association to Ebv
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "facture")
  private Facture facture;

  // bi-directional many-to-one association to Ebv
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "facture_avoir")
  private Facture factureAvoir;

  public Billet() {

  }

  public long getNumBillet() {
    return numBillet;
  }

  public void setNumBillet(long numBillet) {
    this.numBillet = numBillet;
  }

  public Date getDateElaboration() {
    return dateElaboration;
  }

  public void setDateElaboration(Date dateElaboration) {
    this.dateElaboration = dateElaboration;
  }

  public String getEtatDoc() {
    return etatDoc;
  }

  public void setEtatDoc(String etatDoc) {
    this.etatDoc = etatDoc;
  }

  public String getMotifEch() {
    return motifEch;
  }

  public void setMotifEch(String motifEch) {
    this.motifEch = motifEch;
  }

  public String getNote() {

    if (this.note == null)
      this.note = "";

    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public BonCommande getBonCommande() {
    return this.bonCommande;
  }

  public void setBonCommande(BonCommande bonCommande) {
    this.bonCommande = bonCommande;
  }

  public Ebr getEbr() {
    return this.ebr;
  }

  public void setEbr(Ebr ebr) {
    this.ebr = ebr;
  }

  public Ebv getEbv() {
    return this.ebv;
  }

  public void setEbv(Ebv ebv) {
    this.ebv = ebv;
  }

  public Set<BilletHasModeRemb> getBilletHasModeRembs() {
    return this.billetHasModeRembs;
  }

  public void setBilletHasModeRembs(Set<BilletHasModeRemb> billetHasModeRembs) {
    this.billetHasModeRembs = billetHasModeRembs;
  }

  public Set<BilletHasTaxe> getBilletHasTaxes() {
    return this.billetHasTaxes;
  }

  public void setBilletHasTaxes(Set<BilletHasTaxe> billetHasTaxes) {
    this.billetHasTaxes = billetHasTaxes;
  }

  public Set<ModePaiementHasBillet> getModePaiementHasBillets() {
    return this.modePaiementHasBillets;
  }

  public void setModePaiementHasBillets(Set<ModePaiementHasBillet> modePaiementHasBillets) {
    this.modePaiementHasBillets = modePaiementHasBillets;
  }

  public Set<TaxeHasBilletRem> getTaxeHasBilletRems() {
    return this.taxeHasBilletRems;
  }

  public void setTaxeHasBilletRems(Set<TaxeHasBilletRem> taxeHasBilletRems) {
    this.taxeHasBilletRems = taxeHasBilletRems;
  }

  public Set<CouponHasBillet> getCouponHasBillets() {
    return this.CouponHasBillets;
  }

  public void setCouponHasBillets(Set<CouponHasBillet> CouponHasBillets) {
    this.CouponHasBillets = CouponHasBillets;
  }

  public Badc getBadc() {
    return this.badc;
  }

  public void setBadc(Badc badc) {
    this.badc = badc;
  }

  public char getEtat() {
    return etat;
  }

  public void setEtat(char etat) {
    this.etat = etat;
  }

  public double getMtNet() {
    return mtNet;
  }

  public void setMtNet(double mtNet) {
    this.mtNet = mtNet;
  }

  public Bodoan getBodoan() {
    return bodoan;
  }

  public void setBodoan(Bodoan bodoan) {
    this.bodoan = bodoan;
  }

  public BordereauEnvoi getBordereauEnvoi() {
    return bordereauEnvoi;
  }

  public void setBordereauEnvoi(BordereauEnvoi bordereauEnvoi) {
    this.bordereauEnvoi = bordereauEnvoi;
  }

  public BorAvoir getBorAvoir() {
    return borAvoir;
  }

  public void setBorAvoir(BorAvoir borAvoir) {
    this.borAvoir = borAvoir;
  }

  public int getNbCoup() {
    return nbCoup;
  }

  public void setNbCoup(int nbCoup) {
    this.nbCoup = nbCoup;
  }

  public List<BilletHasTaxe> getBillethastaxes() {
    return billethastaxes;
  }

  public void setBillethastaxes(List<BilletHasTaxe> billethastaxes) {
    this.billethastaxes = billethastaxes;
  }

  public Monnaie getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(Monnaie monnaie) {
    this.monnaie = monnaie;
  }

  public String getTransfere() {
    return transfere;
  }

  public void setTransfere(String transfere) {
    this.transfere = transfere;
  }

  public Date getDateEmis() {
    return dateEmis;
  }

  public void setDateEmis(Date dateEmis) {
    this.dateEmis = dateEmis;
  }

  public short getHadj() {
    return hadj;
  }

  public void setHadj(short hadj) {
    this.hadj = hadj;
  }

  public boolean isHadjB() {
    return hadjB;
  }

  public void setHadjB(boolean hadjB) {
    this.hadjB = hadjB;
  }

  public String getCompTarifaire() {
    return compTarifaire;
  }

  public void setCompTarifaire(String compTarifaire) {
    this.compTarifaire = compTarifaire;
  }

  public String getNumFfp() {
    return numFfp;
  }

  public void setNumFfp(String numFfp) {
    this.numFfp = numFfp;
  }

  public double getTimbre() {
    return timbre;
  }

  public void setTimbre(double timbre) {
    this.timbre = timbre;
  }

  public double getFivePercent() {
    try {

      if ((numBillet + "").startsWith("451") || (numBillet + "").startsWith("452")
          || (numBillet + "").startsWith("454"))
        return (double) (0);

      else
        return (double) (mtNet * 0.05);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return (double) (0);
    }
  }

  public double getThreePercent() {

    try {
      if ((numBillet + "").startsWith("451") || (numBillet + "").startsWith("452")
          || (numBillet + "").startsWith("454"))
        return (double) (0);
      else
        return (double) ((mtNet/*-getFive_percent()*/) * 0.03);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return (double) (0);
    }
  }

  public Facture getFacture() {
    return facture;
  }

  public void setFacture(Facture facture) {
    this.facture = facture;
  }

  public Facture getFactureAvoir() {
    return factureAvoir;
  }

  public void setFactureAvoir(Facture factureAvoir) {
    this.factureAvoir = factureAvoir;
  }

  public int compareTo(Object other) {
    long nombre1 = ((Billet) other).getNumBillet();
    long nombre2 = this.getNumBillet();
    if (nombre1 > nombre2)
      return -1;
    else if (nombre1 == nombre2)
      return 0;
    else
      return 1;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (numBillet ^ (numBillet >>> 32));
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
    Billet other = (Billet) obj;
    if (numBillet != other.numBillet)
      return false;
    return true;
  }

}
