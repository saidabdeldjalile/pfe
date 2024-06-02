/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.math.BigDecimal;

/**
 *
 * @author KEHLI Moussab Amine
 */
public class ReportTauxChange {

  private String pays;

  private int codeMonnaie;

  private String codeAlphaNum;

  private BigDecimal valueUSD;

  private BigDecimal valueDZD;

  private BigDecimal value;

  public String getPays() {
    return pays;
  }

  public void setPays(String pays) {
    this.pays = pays;
  }

  public int getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(int codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public String getCodeAlphaNum() {
    return codeAlphaNum;
  }

  public void setCodeAlphaNum(String codeAlphaNum) {
    this.codeAlphaNum = codeAlphaNum;
  }

  public BigDecimal getValueUSD() {
    return valueUSD;
  }

  public void setValueUSD(BigDecimal valueUSD) {
    this.valueUSD = valueUSD;
  }

  public BigDecimal getValueDZD() {
    return valueDZD;
  }

  public void setValueDZD(BigDecimal valueDZD) {
    this.valueDZD = valueDZD;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getCodeMonnaieForPDF() {
    String output = "" + codeMonnaie;

    if (codeMonnaie < 10) {
      output = "00" + output;
      return output;
    }
    if (codeMonnaie < 100) {
      output = "0" + output;
      return output;
    }
    return output;
  }
}
