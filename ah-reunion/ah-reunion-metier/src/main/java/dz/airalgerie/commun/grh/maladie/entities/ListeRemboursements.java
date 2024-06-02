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
public class ListeRemboursements {

  private int matricule;
  private String num_ss;
  private BigDecimal valMontant;
  private int idMontant;
  private String codeRub;
  private int datePai;
  private BigDecimal montantCHQ;
  private String numBDX;
  private BigDecimal montantBDX;
  private String numCHQ;

  public ListeRemboursements(int matricule, String num_ss, BigDecimal valMontant, int idMontant,
      String codeRub, int datePai, BigDecimal montantCHQ, String numBDX, BigDecimal montantBDX,
      String numCHQ) {
    this.matricule = matricule;
    this.num_ss = num_ss;
    this.valMontant = valMontant;
    this.idMontant = idMontant;
    this.codeRub = codeRub;
    this.datePai = datePai;
    this.montantCHQ = montantCHQ;
    this.numBDX = numBDX;
    this.montantBDX = montantBDX;
    this.numCHQ = numCHQ;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getNum_ss() {
    return num_ss;
  }

  public void setNum_ss(String num_ss) {
    this.num_ss = num_ss;
  }

  public BigDecimal getValMontant() {
    return valMontant;
  }

  public void setValMontant(BigDecimal valMontant) {
    this.valMontant = valMontant;
  }

  public int getIdMontant() {
    return idMontant;
  }

  public void setIdMontant(int idMontant) {
    this.idMontant = idMontant;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
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
