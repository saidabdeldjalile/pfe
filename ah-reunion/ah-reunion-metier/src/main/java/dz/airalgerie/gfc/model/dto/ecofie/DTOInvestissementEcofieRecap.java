/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ecofie;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author kehli
 */
public class DTOInvestissementEcofieRecap implements Serializable {

  private static final long serialVersionUID = 1L;

  private String entreprise;
  private BigDecimal autofinancementAnt;
  private BigDecimal creditAnt;
  private BigDecimal totalAnt;
  private BigDecimal autofinancement;
  private BigDecimal credit;
  private BigDecimal total;

  public DTOInvestissementEcofieRecap(String entreprise, BigDecimal autofinancementAnt,
      BigDecimal creditAnt, BigDecimal totalAnt, BigDecimal autofinancement, BigDecimal credit,
      BigDecimal total) {
    this.entreprise = entreprise;
    this.autofinancementAnt = autofinancementAnt;
    this.creditAnt = creditAnt;
    this.totalAnt = totalAnt;
    this.autofinancement = autofinancement;
    this.credit = credit;
    this.total = total;
  }

  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public BigDecimal getAutofinancementAnt() {
    return autofinancementAnt;
  }

  public void setAutofinancementAnt(BigDecimal autofinancementAnt) {
    this.autofinancementAnt = autofinancementAnt;
  }

  public BigDecimal getCreditAnt() {
    return creditAnt;
  }

  public void setCreditAnt(BigDecimal creditAnt) {
    this.creditAnt = creditAnt;
  }

  public BigDecimal getTotalAnt() {
    return totalAnt;
  }

  public void setTotalAnt(BigDecimal totalAnt) {
    this.totalAnt = totalAnt;
  }

  public BigDecimal getAutofinancement() {
    return autofinancement;
  }

  public void setAutofinancement(BigDecimal autofinancement) {
    this.autofinancement = autofinancement;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

}
