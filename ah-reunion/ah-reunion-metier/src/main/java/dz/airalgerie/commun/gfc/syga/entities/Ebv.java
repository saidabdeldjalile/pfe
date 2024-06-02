
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the ebv database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "ebv")
public class Ebv implements Serializable, java.lang.Comparable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_EBV")
  private long numEbv;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_debut")
  private Date dateDebut;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_fin")
  private Date dateFin;

  @Column(name = "reseau")
  private char reseau;

  @Transient
  private double sumCash;

  @Transient
  private double sumChe;

  @Transient
  private double sumInv;

  @Transient
  private double sumInt;

  @Transient
  private double sumCc;

  @Transient
  private double sumAutre;

  @Transient
  private double sumUatp;

  @Transient
  private double sumNet;

  @Transient
  private double sumTex;

  @Transient
  private double sumTdz;

  @Transient
  private double sumTe;

  @Transient
  private double sumTva;

  @Transient
  private double sumTbr;

  @Transient
  private double sumTdiv;

  @Transient
  private BilletHasTaxe billetHasTaxe;

  @Transient

  private List<Eticket> etic = new ArrayList<Eticket>();

  @Transient
  private String res;

  @Transient
  private Detail detail;

  @Transient
  private String date;

  @Transient
  private String monnaie;

  @Transient
  private String hadj;

  @Transient
  private String dh;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "ebv", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  private Set<Billet> billets;

  public Ebv() {
    this.detail = new Detail();
  }

  public long getNumEbv() {
    return this.numEbv;
  }

  public void setNumEbv(long numEbv) {
    this.numEbv = numEbv;
  }

  public Date getDateDebut() {
    return this.dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return this.dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public char getReseau() {
    return reseau;
  }

  public void setReseau(char reseau) {
    this.reseau = reseau;
  }

  public double getSumCash() {

    return sumCash;
  }

  public void setSumCash(double sumCash) {
    this.sumCash = sumCash;
  }

  public double getSumChe() {

    return sumChe;
  }

  public void setSumChe(double sumChe) {
    this.sumChe = sumChe;
  }

  public double getSumInv() {
    return sumInv;
  }

  public void setSumInv(double sumInv) {
    this.sumInv = sumInv;
  }

  public double getSumCc() {

    return sumCc;
  }

  public void setSumCc(double sUmCc) {
    this.sumCc = sUmCc;
  }

  public double getSumAutre() {

    return sumAutre;
  }

  public void setSumAutre(double sUmAutre) {
    this.sumAutre = sUmAutre;
  }

  public double getSumUatp() {

    return sumUatp;
  }

  public void setSumUatp(double sUmUatp) {
    this.sumUatp = sUmUatp;
  }

  public double getSumNet() {

    return sumNet;
  }

  public void setSumNet(double sumNet) {
    this.sumNet = sumNet;
  }

  public double getSumTex() {

    return sumTex;
  }

  public void setSumTex(double sumTex) {
    this.sumTex = sumTex;
  }

  public double getSumTdz() {

    return sumTdz;
  }

  public void setSumTdz(double sumTdz) {
    this.sumTdz = sumTdz;
  }

  public double getSumTdiv() {

    return sumTdiv;
  }

  public void setSumTdiv(double sumTdiv) {
    this.sumTdiv = sumTdiv;
  }

  public BilletHasTaxe getBilletHasTaxe() {
    return billetHasTaxe;
  }

  public void setBilletHasTaxe(BilletHasTaxe bIlletHasTaxe) {
    this.billetHasTaxe = bIlletHasTaxe;
  }

  public List<Eticket> getEtic() {
    return etic;
  }

  public void setEtic(List<Eticket> etic) {
    this.etic = etic;
  }

  public String getRes() {
    return res;
  }

  public void setRes(String res) {
    this.res = res;
  }

  public Detail getDetail() {
    return detail;
  }

  public void setDetail(Detail detail) {
    this.detail = detail;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void addEtic(Eticket eTicket) {
    etic.add(eTicket);
  }

  public double getSumcash() {
    return this.detail.getSumCash();

  }

  public double getSumche() {
    return this.detail.getSumChe();

  }

  public double getSuminv() {
    return this.detail.getSumInv();

  }

  public double getSumcc() {
    return this.detail.getSumCc();

  }

  public double getSumautre() {
    return this.detail.getSumAut();

  }

  public double getSumuatp() {
    return this.detail.getSumUatp();

  }

  public double getSumint() {
    return this.detail.getSumInt();

  }

  public double getSumMntNet() {
    return this.detail.getSumMtNet();

  }

  public double getSumtbr() {
    return this.detail.getSumTbr();

  }

  public double getSumTxAero() {
    return this.detail.getSumTxe();

  }

  public double getSumTxDZ() {
    return this.detail.getSumTdz();

  }

  public double getSumtva() {
    return this.detail.getSumTva();

  }

  public double getSumte() {
    return this.detail.getSumTe();

  }

  public double getSumTxDiv() {
    return this.detail.getSumTaxDiv();

  }

  public double getSumFive_Percent() {
    return this.detail.getSumFivePercent();

  }

  public double getSumThree_Percent() {
    return this.detail.getSumThreePercent();

  }

  public double getSumHq() {
    return this.detail.getSumHq();

  }

  public double getSumYr() {
    return this.detail.getSumYr();

  }

  public double getSumD9() {
    return this.detail.getSumD9();

  }

  public double getSumNh() {
    return this.detail.getSumNh();

  }

  public double getSumTotalNet() {
    return this.detail.getSumTotalNet();

  }

  public double getSumCashChec() {
    return getSumChe() + getSumCash();

  }

  public double getSumInvCc() {
    return getSumCc() + getSumInv();

  }

  public double getSumAuUatp() {
    return getSumUatp() + getSumAutre() + getSumInt();

  }

  public double getTotalNV() {
    return getSumAuUatp() + getSumInvCc() + getSumCashChec();

  }

  public double getTotalV() {
    return getSumTxDiv() + getSumTe() + getSumTva() + getSumTxAero() + getSumTbr() + getSumMntNet()
        + getSumTxDZ();

  }

  public double getSumInt() {
    return sumInt;
  }

  public void setSumInt(double sUmInt) {
    this.sumInt = sUmInt;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  @Override
  public int compareTo(Object other) {
    long nombre1 = ((Ebv) other).getNumEbv();
    long nombre2 = this.getNumEbv();
    if (nombre1 > nombre2)
      return -1;
    else if (nombre1 == nombre2)
      return 0;
    else
      return 1;
  }

  public double getSUmCc() {

    return sumCc;
  }

  public String getHadj() {
    return hadj;
  }

  public void setHadj(String hadj) {
    this.hadj = hadj;
  }

  public String getDh() {
    return dh;
  }

  public void setDh(String dH) {
    dh = dH;
  }

  public double getSumTe() {
    return sumTe;
  }

  public void setSumTe(double sumte) {
    this.sumTe = sumte;
  }

  public double getSumTva() {
    return sumTva;
  }

  public void setSumTva(double sumtva) {
    this.sumTva = sumtva;
  }

  public double getSumTbr() {
    return sumTbr;
  }

  public void setSumTbr(double sumtbr) {
    this.sumTbr = sumtbr;
  }

}
