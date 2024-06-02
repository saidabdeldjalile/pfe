/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.grh.model.dto.mld;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public class DTORemboursementsMaladieRecap implements Serializable {

  private static final long serialVersionUID = 1L;

  protected Integer dateTrt;
  protected String numCheque;
  protected BigDecimal montantCheque;
  protected String numBordereau;
  protected BigDecimal montantBordereau;
  protected BigDecimal montantRemboursements;
  protected BigDecimal montantRemboursementsByMatricule;

  public DTORemboursementsMaladieRecap() {
  }

  public DTORemboursementsMaladieRecap(Integer dateTrt, String numCheque, BigDecimal montantCheque,
      String numBordereau, BigDecimal montantBordereau, BigDecimal montantRemboursements,
      BigDecimal montantRemboursementsByMatricule) {
    this.dateTrt = dateTrt;
    this.numCheque = numCheque;
    this.montantCheque = montantCheque;
    this.numBordereau = numBordereau;
    this.montantBordereau = montantBordereau;
    this.montantRemboursements = montantRemboursements;
    this.montantRemboursementsByMatricule = montantRemboursementsByMatricule;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getNumCheque() {
    return numCheque;
  }

  public void setNumCheque(String numCheque) {
    this.numCheque = numCheque;
  }

  public BigDecimal getMontantCheque() {
    return montantCheque;
  }

  public void setMontantCheque(BigDecimal montantCheque) {
    this.montantCheque = montantCheque;
  }

  public String getNumBordereau() {
    return numBordereau;
  }

  public void setNumBordereau(String numBordereau) {
    this.numBordereau = numBordereau;
  }

  public BigDecimal getMontantBordereau() {
    return montantBordereau;
  }

  public void setMontantBordereau(BigDecimal montantBordereau) {
    this.montantBordereau = montantBordereau;
  }

  public BigDecimal getMontantRemboursements() {
    return montantRemboursements;
  }

  public void setMontantRemboursements(BigDecimal montantRemboursements) {
    this.montantRemboursements = montantRemboursements;
  }

  public BigDecimal getMontantRemboursementsByMatricule() {
    return montantRemboursementsByMatricule;
  }

  public void setMontantRemboursementsByMatricule(BigDecimal montantRemboursementsByMatricule) {
    this.montantRemboursementsByMatricule = montantRemboursementsByMatricule;
  }

}
