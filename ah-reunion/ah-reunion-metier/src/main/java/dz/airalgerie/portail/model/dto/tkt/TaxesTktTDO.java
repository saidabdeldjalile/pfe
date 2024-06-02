/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.tkt;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author kehli
 */
public class TaxesTktTDO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private BigDecimal taxAmt;
  private String taxCode;

  public TaxesTktTDO() {
  }

  public TaxesTktTDO(BigDecimal taxAmt, String taxCode) {
    this.taxAmt = taxAmt;
    this.taxCode = taxCode;
  }

  public BigDecimal getTaxAmt() {
    return taxAmt;
  }

  public void setTaxAmt(BigDecimal taxAmt) {
    this.taxAmt = taxAmt;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }
}
