/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class RecapeStkConMvtsSDRM {

  private String moteur;
  private BigDecimal valInitial;
  private BigDecimal valEntree;
  private BigDecimal valSortie;
  private BigDecimal valFinal;

  public RecapeStkConMvtsSDRM(String moteur, BigDecimal valInitial, BigDecimal valEntree,
      BigDecimal valSortie, BigDecimal valFinal) {
    this.moteur = moteur;
    this.valInitial = valInitial;
    this.valEntree = valEntree;
    this.valSortie = valSortie;
    this.valFinal = valFinal;
  }

  public BigDecimal getValInitial() {
    return valInitial;
  }

  public void setValInitial(BigDecimal valInitial) {
    this.valInitial = valInitial;
  }

  public BigDecimal getValEntree() {
    return valEntree;
  }

  public void setValEntree(BigDecimal valEntree) {
    this.valEntree = valEntree;
  }

  public BigDecimal getValSortie() {
    return valSortie;
  }

  public void setValSortie(BigDecimal valSortie) {
    this.valSortie = valSortie;
  }

  public BigDecimal getValFinal() {
    return valFinal;
  }

  public void setValFinal(BigDecimal valFinal) {
    this.valFinal = valFinal;
  }

  public String getMoteur() {
    return moteur;
  }

  public void setMoteur(String moteur) {
    this.moteur = moteur;
  }

}