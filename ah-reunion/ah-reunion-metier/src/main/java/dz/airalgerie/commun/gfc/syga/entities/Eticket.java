
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the e_ticket database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "e_ticket")
public class Eticket implements Serializable, java.lang.Comparable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billetNumBillet;

  @Column(name = "Bas_tari")
  private String basTari;

  @Column(name = "code_agent")
  private String codeAgent;

  @Column(name = "Gratuit_serv")
  private String gratuitServ;

  @Column(name = "Nom")
  private String nom;

  @Column(name = "Prenom")
  private String prenom;

  @Column(name = "Rate")
  private double rate;

  @Column(name = "Mont_conv")
  private double montConv;

  @Column(name = "Remar")
  private String remar;

  @Column(name = "Reseau")
  private String reseau;

  @Column(name = "Code_Pro")
  private String codePro;

  @Column(name = "PNR")
  private String pnr;

  @Transient
  private String remarqr;

  @Transient
  private String noter;

  @Transient
  private Eticket eticket;

  @Transient
  private String service;

  @Transient
  public String compositionT;

  @Transient
  public long poids;

  @Transient
  private String parcoursSygef;

  // bi-directional many-to-one association to Bcb
  @OneToMany(mappedBy = "eticket", fetch = FetchType.LAZY)
  private Set<Bcb> bcbs;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  // bi-directional many-to-one association to Mco
  @OneToMany(mappedBy = "eticket", fetch = FetchType.LAZY)
  private Set<Mco> mcos;

  // bi-directional many-to-one association to Atb
  @OneToMany(mappedBy = "eticket", fetch = FetchType.LAZY)
  private Set<Atb> atbs;

  @Transient
  private String parc;

  @Transient
  private String clas;

  @Transient
  private String tran;

  @Transient
  private double mtNet;

  @Transient
  private double brut;

  @Transient
  private double taxeE;

  @Transient
  private double tbr;

  @Transient
  private double taeroXe;

  @Transient
  private double tvaYb;

  @Transient
  private double txDiv;

  @Transient
  private double differenec;

  @Transient
  private int index;

  @Transient
  private String nomPrenom;

  @Transient
  private String monnaie;

  @Transient
  private String numCc;

  @Transient
  private ModePaiementHasBillet mod1;

  @Transient
  private ModePaiementHasBillet modFr;

  @Transient
  private ModePaiementHasBillet mod2;

  @Transient
  private ModePaiementHasBillet mod3;

  @Transient
  private BilletHasModeRemb modR1;

  @Transient
  private BilletHasModeRemb modR2;

  @Transient
  private BilletHasModeRemb modR3;

  @Transient
  private Date dateRemb;

  @Transient
  private double fraisRemb;

  @Transient
  private String benifi;

  @Transient
  private BilletRemb billerRemb;

  @Transient
  private String date;

  @Transient
  private String reason;

  @Transient
  private double totalEur;

  @Transient

  private CouponHasBillet couponHasBillet;

  @Transient
  private double dz;

  @Transient
  private double d9;

  @Transient
  private double nh;

  @Transient
  private double hq;

  @Transient
  private double yr;

  @Transient
  private double totalNet;

  @Transient
  private double fivePercentR;

  @Transient
  private double threePercentR;

  @Transient
  public String refundCoupons;

  public double getFivePercentR() {
    return fivePercentR;
  }

  public void setFivePercentR(double fivePercentR) {
    this.fivePercentR = fivePercentR;
  }

  public double getThreePercentR() {
    return threePercentR;
  }

  public void setThreePercentR(double threePercentR) {
    this.threePercentR = threePercentR;
  }

  public double getYr() {
    return yr;
  }

  public void setYr(double yr) {
    this.yr = yr;
  }

  public double getTotalNet() {
    return totalNet;
  }

  public void setTotalNet(double totalNet) {
    this.totalNet = totalNet;
  }

  public double getDZ() {
    return dz;
  }

  public double getDz() {
    return dz;
  }

  public void setDZ(double dZ) {
    dz = dZ;
  }

  public CouponHasBillet getCouponHasBillet() {
    return couponHasBillet;
  }

  public void setCouponHasBillet(CouponHasBillet CouponHasBillet) {
    this.couponHasBillet = CouponHasBillet;
  }

  public String getCodePro() {
    return codePro;
  }

  public void setCodePro(String codePro) {
    this.codePro = codePro;
  }

  public BilletHasModeRemb getModR1() {
    return modR1;
  }

  public void setModR1(BilletHasModeRemb modR1) {
    this.modR1 = modR1;
  }

  public BilletHasModeRemb getModR2() {
    return modR2;
  }

  public void setModR2(BilletHasModeRemb modR2) {
    this.modR2 = modR2;
  }

  public BilletHasModeRemb getModR3() {
    return modR3;
  }

  public void setModR3(BilletHasModeRemb modR3) {
    this.modR3 = modR3;
  }

  public BilletRemb getBillerRemb() {
    return billerRemb;
  }

  public void setBillerRemb(BilletRemb billerRemb) {
    this.billerRemb = billerRemb;
  }

  public Eticket() {}

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public String getBasTari() {
    return this.basTari;
  }

  public void setBasTari(String basTari) {
    this.basTari = basTari;
  }

  public String getCodeAgent() {
    return this.codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
  }

  public String getGratuitServ() {
    return this.gratuitServ;
  }

  public void setGratuitServ(String gratuitServ) {
    this.gratuitServ = gratuitServ;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public double getRate() {
    return this.rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String getRemar() {

    if (this.remar == null)
      return "";
    else
      return this.remar;
  }

  public void setRemar(String remar) {
    this.remar = remar;
  }

  public Set<Bcb> getBcbs() {
    return this.bcbs;
  }

  public void setBcbs(Set<Bcb> bcbs) {
    this.bcbs = bcbs;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Set<Mco> getMcos() {
    return this.mcos;
  }

  public void setMcos(Set<Mco> mcos) {
    this.mcos = mcos;
  }

  public Set<Atb> getAtbs() {
    return this.atbs;
  }

  public void setAtbs(Set<Atb> atbs) {
    this.atbs = atbs;
  }

  public String getParc() {
    return parc;
  }

  public void setParc(String parc) {
    this.parc = parc;
  }

  public String getClas() {
    return clas;
  }

  public void setClas(String clas) {
    this.clas = clas;
  }

  public double getMtNet() {
    return mtNet;
  }

  public void setMtNet(double mt_net) {
    mtNet = mt_net;
  }

  public double getBrut() {
    return brut;
  }

  public double getBrut_avoir() {
    return getBrut() - getFraisR();
  }

  public void setBrut(double brut) {
    this.brut = (double) (Math.round(brut * 100.0) / 100.0);
  }

  public double getTaxe() {
    return taxeE;
  }

  public void setTaxe(double taxe_E) {
    taxeE = taxe_E;
  }

  public double getTbr() {
    return tbr;
  }

  public void setTbr(double tbr) {
    this.tbr = tbr;
  }

  public double getTAero() {
    return taeroXe;
  }

  public double getTaero() {
    return taeroXe;
  }

  public void setTAero(double tAero_XE) {
    taeroXe = tAero_XE;
  }

  public double getTVA() {
    return tvaYb;
  }

  public double getTva() {
    return tvaYb;
  }

  public void setTVA(double tVA_YB) {
    tvaYb = tVA_YB;
  }

  public double getTxDiv() {
    return txDiv;
  }

  public void setTxDiv(double tx_Div) {
    // Tx_Div = (double) (Math.round(tx_Div*100.0)/100.0);
    txDiv = tx_Div;
  }

  public double getDifferenec() {
    return differenec;
  }

  public void setDifferenec(double differenec) {
    this.differenec = differenec;// (double) (Math.round(differenec*100.0)/100.0);
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getNomPrenom() {
    return nomPrenom;
  }

  public void setNomPrenom(String nomPrenom) {
    this.nomPrenom = nomPrenom;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getNumCc() {
    return numCc;
  }

  public void setNumCc(String num_CC) {
    numCc = num_CC;
  }

  public ModePaiementHasBillet getMod1() {
    return mod1;
  }

  public void setMod1(ModePaiementHasBillet mod1) {
    this.mod1 = mod1;
  }

  public ModePaiementHasBillet getMod2() {
    return mod2;
  }

  public void setMod2(ModePaiementHasBillet mod2) {
    this.mod2 = mod2;
  }

  public ModePaiementHasBillet getMod3() {
    return mod3;
  }

  public void setMod3(ModePaiementHasBillet mod3) {
    this.mod3 = mod3;
  }

  public Date getDateRemb() {
    return dateRemb;
  }

  public void setDateRemb(Date dateRemb) {
    this.dateRemb = dateRemb;
  }

  public double getFraisR() {
    return fraisRemb;
  }

  public void setFraisR(double fRaisRemb) {
    this.fraisRemb = fRaisRemb;
  }

  public String getBenifi() {
    return benifi;
  }

  public void setBenifi(String benifi) {
    this.benifi = benifi;
  }

  /**
   * Impression EBV
   */

  public long getNumBillet() {
    return this.billet.getNumBillet();
  }

  public String getMod_1() {
    try {
      return (this.mod1.getMontant() + " ").substring(0,
          (this.mod1.getMontant() + " ").indexOf(".") + 3) + " "
          + this.mod1.getModePaiement().getModePaiement();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      try {
        return (this.mod1.getMontant() + " ").substring(0,
            (this.mod1.getMontant() + " ").indexOf(".") + 2) + " "
            + this.mod1.getModePaiement().getModePaiement();
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        return "";
      }

    }

  }

  public String getMod_2() {
    try {
      return (this.mod2.getMontant() + " ").substring(0,
          (this.mod2.getMontant() + " ").indexOf(".") + 3) + " "
          + this.mod2.getModePaiement().getModePaiement();
    } catch (Exception e) {
      // TODO Auto-generated catch block

      try {
        return (this.mod2.getMontant() + " ").substring(0,
            (this.mod2.getMontant() + " ").indexOf(".") + 2) + " "
            + this.mod2.getModePaiement().getModePaiement();
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        return "";
      }

    }

  }

  public String getMod_3() {
    try {
      return (this.mod3.getMontant() + " ").substring(0,
          (this.mod3.getMontant() + " ").indexOf(".") + 3) + " "
          + this.mod3.getModePaiement().getModePaiement();
    } catch (Exception e) {
      // TODO Auto-generated catch block

      try {
        return (this.mod3.getMontant() + " ").substring(0,
            (this.mod2.getMontant() + " ").indexOf(".") + 2) + " "
            + this.mod2.getModePaiement().getModePaiement();
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        return "";
      }

    }

  }

  public double getMnH() {
    return this.billet.getMtNet();

  }

  public double getFivePercent() {
    return this.billet.getFivePercent();

  }

  public double getThreePercent() {
    return this.billet.getThreePercent();

  }

  public String getObs() {
    try {
      if (this.billet.getNote() != null)

        return this.billet.getNote();
      else
        return "";
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }

  }

  /**
   * Impression EBR
   */

  public String getModR_1() {
    try {
      return this.modR1.getMontant() + " " + this.modR1.getModeRemb().getModeRemb();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }

  }

  public double getModR_1_m() {
    try {
      return this.modR1.getMontant();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return 0;
    }

  }

  public String getModR_2() {
    try {
      return this.modR2.getMontant() + " " + this.modR2.getModeRemb().getModeRemb();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }

  }

  public String getModR_3() {
    try {
      return this.modR3.getMontant() + " " + this.modR3.getModeRemb().getModeRemb();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }

  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTran() {
    return tran;
  }

  public void setTran(String tran) {
    this.tran = tran;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getRemarqr() {

    if (remarqr == null)
      remarqr = "";
    return remarqr;
  }

  public void setRemarqr(String remarqr) {
    this.remarqr = remarqr;
  }

  public String getNoter() {
    return noter;
  }

  public void setNoter(String noter) {
    this.noter = noter;
  }

  public double getTotalEur() {
    return totalEur;
  }

  public void setTotalEur(double totalEur) {
    this.totalEur = (double) (Math.round(totalEur * 100.0) / 100.0);
  }

  public double getMontConv() {
    return montConv;
  }

  public void setMontConv(double montConv) {
    this.montConv = montConv;
  }

  public ModePaiementHasBillet getModFr() {
    return modFr;
  }

  public void setModFr(ModePaiementHasBillet modfr) {
    modFr = modfr;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public Eticket getEticket() {
    return eticket;
  }

  public void setEticket(Eticket eticket) {
    this.eticket = eticket;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getCompositionT() {
    return compositionT;
  }

  public void setCompositionT(String compositionT) {
    this.compositionT = compositionT;
  }

  public String getTaxeTVA() {
    return "YB";
  }

  public String getTaxeTE() {
    return "TE";
  }

  public String getTaxeTAero() {
    return "XE";
  }

  public String getZero() {
    return "0";
  }

  public String getBlan() {
    return "";
  }

  public String getOrigine() {
    try {
      return couponHasBillet.getCoupon().getParcours().substring(0, 3);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }
  }

  public String getDesti() {
    try {
      return couponHasBillet.getCoupon().getParcours().substring(4);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "";
    }
  }

  public double getD9() {
    return d9;
  }

  public void setD9(double d9) {
    this.d9 = d9;
  }

  public double getNh() {
    return nh;
  }

  public void setNh(double nh) {
    this.nh = nh;
  }

  public double getHq() {
    return hq;
  }

  public void setHq(double hq) {
    this.hq = hq;
  }

  public long getPoids() {
    return poids;
  }

  public void setPoids(long poids) {
    this.poids = poids;
  }

  public String getRefundCoupons() {
    return refundCoupons;
  }

  public void setRefundCoupons(String refundCoupons) {
    this.refundCoupons = refundCoupons;
  }

  public double getMont_n_s() {
    if (reseau.compareTo("RIA") == 0)
      return 0;
    else
      return getBrut_avoir();
  }

  public double getMont_s() {
    if (reseau.compareTo("RIA") != 0)
      return 0;
    else
      return (getBrut_avoir() / (1.19f));
  }

  public double getTvaf() {

    if (reseau.compareTo("RIA") != 0)
      return 0;
    else
      return ((getBrut_avoir()) / (1.19f)) * (0.19f);
  }

  public String getSoumi() {
    if (reseau.compareTo("INT") == 0)
      return "NS";
    else
      return "SO";
  }

  public long getBc() {
    return this.billet.getBonCommande().getNumBonCam();
  }

  public String getDate_e() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    return formatter.format(this.billet.getDateElaboration());
  }

  public String getAgence() {
    return this.billet.getAgence().getNomAgence();
  }

  public String getParcoursSygef() {
    return parcoursSygef;
  }

  public void setParcoursSygef(String parcoursSygef) {
    this.parcoursSygef = parcoursSygef;
  }

  public int compareTo(Object other) {
    long nombre1 = ((Eticket) other).getBillet().getNumBillet();
    long nombre2 = this.getBillet().getNumBillet();
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
    result = prime * result + ((billet == null) ? 0 : billet.hashCode());
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
    Eticket other = (Eticket) obj;
    if (billet == null) {
      if (other.billet != null)
        return false;
    } else if (!billet.equals(other.billet))
      return false;
    return true;
  }

}
