/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class ListeBordereaux {

  private int datePai;
  private String numCHQ;
  private BigDecimal montantCHQ;
  private String numBDX;
  private BigDecimal montantBDX;

  public ListeBordereaux(String numMGT, String codeRub, int datePai, BigDecimal montantCHQ,
      String numBDX, BigDecimal montantBDX, String numCHQ) {
    this.datePai = datePai;
    this.montantCHQ = montantCHQ;
    this.numBDX = numBDX;
    this.montantBDX = montantBDX;
    this.numCHQ = numCHQ;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public BigDecimal getMontantCHQ() {
    return montantCHQ;
  }

  public void setMontantCHQ(BigDecimal montantCHQ) {
    this.montantCHQ = montantCHQ;
  }

  public String getNumBDX() {
    return numBDX;
  }

  public void setNumBDX(String numBDX) {
    this.numBDX = numBDX;
  }

  public BigDecimal getMontantBDX() {
    return montantBDX;
  }

  public void setMontantBDX(BigDecimal montantBDX) {
    this.montantBDX = montantBDX;
  }

  public String getNumCHQ() {
    return numCHQ;
  }

  public void setNumCHQ(String numCHQ) {
    this.numCHQ = numCHQ;
  }

}
