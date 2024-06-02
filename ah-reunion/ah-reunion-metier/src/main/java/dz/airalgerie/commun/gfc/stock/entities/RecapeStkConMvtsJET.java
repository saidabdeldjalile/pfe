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
public class RecapeStkConMvtsJET {

  private String classe;
  private BigDecimal valInitial;
  private BigDecimal valEntree;
  private BigDecimal valSortie;
  private BigDecimal valFinal;

  public RecapeStkConMvtsJET(String classe, BigDecimal valInitial, BigDecimal valEntree,
      BigDecimal valSortie, BigDecimal valFinal) {
    this.classe = classe;
    this.valInitial = valInitial;
    this.valEntree = valEntree;
    this.valSortie = valSortie;
    this.valFinal = valFinal;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
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

}
