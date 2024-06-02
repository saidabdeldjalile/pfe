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
public class ListeCheques {

  private int DATE_PAI;
  private BigDecimal MONT_CHEQ;
  private String NUM_BDX;
  private BigDecimal MONT_BDX;
  private String NUM_CHEQUE;

  public ListeCheques(int DATE_PAI, BigDecimal MONT_CHEQ, String NUM_BDX, BigDecimal MONT_BDX,
      String NUM_CHEQUE) {
    this.DATE_PAI = DATE_PAI;
    this.MONT_CHEQ = MONT_CHEQ;
    this.NUM_BDX = NUM_BDX;
    this.MONT_BDX = MONT_BDX;
    this.NUM_CHEQUE = NUM_CHEQUE;
  }

  public int getDATE_PAI() {
    return DATE_PAI;
  }

  public void setDATE_PAI(int DATE_PAI) {
    this.DATE_PAI = DATE_PAI;
  }

  public BigDecimal getMONT_CHEQ() {
    return MONT_CHEQ;
  }

  public void setMONT_CHEQ(BigDecimal MONT_CHEQ) {
    this.MONT_CHEQ = MONT_CHEQ;
  }

  public String getNUM_BDX() {
    return NUM_BDX;
  }

  public void setNUM_BDX(String NUM_BDX) {
    this.NUM_BDX = NUM_BDX;
  }

  public BigDecimal getMONT_BDX() {
    return MONT_BDX;
  }

  public void setMONT_BDX(BigDecimal MONT_BDX) {
    this.MONT_BDX = MONT_BDX;
  }

  public String getNUM_CHEQUE() {
    return NUM_CHEQUE;
  }

  public void setNUM_CHEQUE(String NUM_CHEQUE) {
    this.NUM_CHEQUE = NUM_CHEQUE;
  }

}
