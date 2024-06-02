/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.bsp;

import java.math.BigDecimal;

/**
 *
 * @author KEHLI
 */
public class DTORecapBalance {

  private String modePaiement;
  private BigDecimal credit;
  private BigDecimal debit;
  private BigDecimal balance;
  private String monnaie;

  public DTORecapBalance() {
  }

  public DTORecapBalance(String modePaiement, BigDecimal credit, BigDecimal debit,
      BigDecimal balance, String monnaie) {
    this.modePaiement = modePaiement;
    this.credit = credit;
    this.debit = debit;
    this.balance = balance;
    this.monnaie = monnaie;
  }

  public String getModePaiement() {
    return modePaiement;
  }

  public void setModePaiement(String modePaiement) {
    this.modePaiement = modePaiement;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public BigDecimal getDebit() {
    return debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }
}
