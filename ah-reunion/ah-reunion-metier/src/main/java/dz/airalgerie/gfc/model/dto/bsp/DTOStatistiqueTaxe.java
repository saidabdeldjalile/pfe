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
public class DTOStatistiqueTaxe {

  private String codeTaxe;
  private BigDecimal montantTotalEmis;
  private BigDecimal montantTotalRfnd;

  public DTOStatistiqueTaxe() {
  }

  public DTOStatistiqueTaxe(String codeTaxe, BigDecimal montantTotalEmis,
      BigDecimal montantTotalRfnd) {
    this.codeTaxe = codeTaxe;
    this.montantTotalEmis = montantTotalEmis;
    this.montantTotalRfnd = montantTotalRfnd;
  }

  public String getCodeTaxe() {
    return codeTaxe;
  }

  public void setCodeTaxe(String codeTaxe) {
    this.codeTaxe = codeTaxe;
  }

  public BigDecimal getMontantTotalEmis() {
    return montantTotalEmis;
  }

  public void setMontantTotalEmis(BigDecimal montantTotalEmis) {
    this.montantTotalEmis = montantTotalEmis;
  }

  public BigDecimal getMontantTotalRfnd() {
    return montantTotalRfnd;
  }

  public void setMontantTotalRfnd(BigDecimal montantTotalRfnd) {
    this.montantTotalRfnd = montantTotalRfnd;
  }

}
