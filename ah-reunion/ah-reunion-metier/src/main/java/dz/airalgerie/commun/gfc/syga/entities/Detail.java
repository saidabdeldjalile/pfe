
package dz.airalgerie.commun.gfc.syga.entities;

public class Detail {

  private double sumMtNet;

  private double sumTxe;

  private double sumTdz;

  private double sumTe;

  private double sumTva;

  private double sumTbr;

  private double sumTaxDiv;

  private double sumCash;

  private double sumChe;

  private double sumInv;

  private double sumCc;

  private double sumAut;

  private double sumFra;

  private double sumUatp;

  private double sumInt;

  private double st1;

  private double st2;

  private double sumD9;

  private double sumNh;

  private double sumHq;

  private double sumYr;

  private double sumFivePercent;

  private double sumThreePercent;

  private double sumTotalNet;

  public double getSumTotalNet() {
    return sumTotalNet;
  }

  public void setSumTotalNet(double sumTotalNet) {
    this.sumTotalNet = sumTotalNet;
  }

  public double getSumFivePercent() {
    return sumFivePercent;
  }

  public void setSumFivePercent(double sumFivePercent) {
    this.sumFivePercent = sumFivePercent;
  }

  public double getSumThreePercent() {
    return sumThreePercent;
  }

  public void setSumThreePercent(double sumThreePercent) {
    this.sumThreePercent = sumThreePercent;
  }

  public double getSumYr() {
    return sumYr;
  }

  public void setSumYr(double sumYr) {
    this.sumYr = sumYr;
  }

  public double getSumD9() {
    return sumD9;
  }

  public void setSumD9(double sumD9) {
    this.sumD9 = sumD9;
  }

  public double getSumNh() {
    return sumNh;
  }

  public void setSumNh(double sumNh) {
    this.sumNh = sumNh;
  }

  public double getSumHq() {
    return sumHq;
  }

  public void setSumHq(double sumHq) {
    this.sumHq = sumHq;
  }

  public double getSumMtNet() {
    return sumMtNet;
  }

  public void setSumMtNet(double sumMtNet) {
    this.sumMtNet = sumMtNet;// =(double) (Math.round( sumMtNet

    // *100.0)/100.0);
  }

  public double getSumTxe() {
    return sumTxe;
  }

  public void setSumTxe(double sumTxe) {
    this.sumTxe = sumTxe;// (double) (Math.round( sumTxe

    // *100.0)/100.0);
  }

  public double getSumTdz() {
    return sumTdz;
  }

  public void setSumTdz(double sumTdz) {
    this.sumTdz = sumTdz; // (double) (Math.round( sumTdz

    // *100.0)/100.0);
  }

  public double getSumTe() {
    return sumTe;
  }

  public void setSumTe(double sumTe) {
    this.sumTe = sumTe;// (double) (Math.round( sumTe

    // *100.0)/100.0);
  }

  public double getSumTva() {
    return sumTva;
  }

  public void setSumTva(double sumTva) {
    this.sumTva = sumTva;// (double) (Math.round( sumTva

    // *100.0)/100.0);
  }

  public double getSumTbr() {
    return sumTbr;
  }

  public void setSumTbr(double sumTbr) {
    this.sumTbr = sumTbr;// (double) (Math.round( sumTbr

    // *100.0)/100.0);
  }

  public double getSumTaxDiv() {
    return sumTaxDiv;
  }

  public void setSumTaxDiv(double sumTaxDiv) {
    this.sumTaxDiv = sumTaxDiv;// (double) (Math.round( sumTaxDiv

    // *100.0)/100.0);
  }

  public double getSumCash() {
    return sumCash;
  }

  public void setSumCash(double sumCash) {
    this.sumCash = sumCash;// (double) (Math.round( sumCash

    // *100.0)/100.0);
  }

  public double getSumChe() {
    return sumChe;
  }

  public void setSumChe(double sumChe) {
    this.sumChe = sumChe;// (double) (Math.round( sumChe

    // *100.0)/100.0);
  }

  public double getSumInv() {
    return sumInv;
  }

  public void setSumInv(double sumInv) {
    this.sumInv = sumInv;// (double) (Math.round( sumInv

    // *100.0)/100.0);
  }

  public double getSumCc() {
    return sumCc;
  }

  public void setSumCc(double sumCc) {
    this.sumCc = sumCc;// (double) (Math.round(sumCc

    // *100.0)/100.0);
  }

  public double getSumAut() {
    return sumAut;
  }

  public void setSumAut(double sumAut) {
    this.sumAut = sumAut;// (double) (Math.round( sumAut

    // *100.0)/100.0);
  }

  public double getSumFra() {
    return sumFra;
  }

  public void setSumFra(double sumFra) {
    this.sumFra = sumFra;// (double) (Math.round( sumFra

    // *100.0)/100.0);
  }

  public double getSumUatp() {
    return sumUatp;
  }

  public void setSumUatp(double sumUatp) {
    this.sumUatp = sumUatp;// (double) (Math.round( sumUatp

    // *100.0)/100.0);
  }

  public double getSumInt() {
    return sumInt;
  }

  public void setSumInt(double sumInt) {
    this.sumInt = sumInt; // (double) (Math.round( sumInt

    // *100.0)/100.0);
  }

  public double getSt1() {
    setSt1(st1);
    return st1;
  }

  public void setSt1(double st1) {
    this.st1 = sumTaxDiv + sumTxe + sumTe + sumTva + sumTbr + sumMtNet + sumTdz;

    // (double) (Math.round( (sumTaxDiv +
    // sUmTxe + sumTe + sumTva + sumTbr + sumMtNet + sumTdz)

    // *100.0)/100.0);

  }

  public double getSt2() {
    setSt2(st2);
    return st2;
  }

  public void setSt2(double st2) {
    this.st2 = sumAut + sumCash + sumCc + sumChe + sumInv + sumInt;
    // (double) (Math.round( (sumAut +
    // sumCash + sumCc +
    // sumChe + sumInv +
    // sumInt)

    // *100.0)/100.0);
  }

}
