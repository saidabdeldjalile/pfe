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
public class ListeDepart {

  private int id;
  private int matricule;
  private int datePai;
  private int dateTrait;
  private char codePaie;
  private BigDecimal preCge;
  private String codeRub;
  private char sensRub;
  private BigDecimal montant;
  private String num_ss;

  public ListeDepart(int id, int matricule, int datePai, int dateTrait, char codePaie,
      BigDecimal preCge, String codeRub, char sensRub, BigDecimal montant, String num_ss) {
    this.id = id;
    this.matricule = matricule;
    this.datePai = datePai;
    this.dateTrait = dateTrait;
    this.codePaie = codePaie;
    this.preCge = preCge;
    this.codeRub = codeRub;
    this.sensRub = sensRub;
    this.montant = montant;
    this.num_ss = num_ss;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public int getDateTrait() {
    return dateTrait;
  }

  public void setDateTrait(int dateTrait) {
    this.dateTrait = dateTrait;
  }

  public char getCodePaie() {
    return codePaie;
  }

  public void setCodePaie(char codePaie) {
    this.codePaie = codePaie;
  }

  public BigDecimal getPreCge() {
    return preCge;
  }

  public void setPreCge(BigDecimal preCge) {
    this.preCge = preCge;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public char getSensRub() {
    return sensRub;
  }

  public void setSensRub(char sensRub) {
    this.sensRub = sensRub;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public String getNum_ss() {
    return num_ss;
  }

  public void setNum_ss(String num_ss) {
    this.num_ss = num_ss;
  }

}
