/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_TAX_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdTaxComp.findAll", query = "SELECT v FROM VArcEmdTaxComp v")})
public class VArcEmdTaxComp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "EMD_NBR")
  @Id
  private String emdNbr;
  @Column(name = "TAX_CURR")
  private String taxCurr;
  @Column(name = "TAX_ISOC")
  private String taxIsoc;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAX_AMNT")
  private BigDecimal taxAmnt;
  @Column(name = "TAX_ACTI")
  private String taxActi;

  public VArcEmdTaxComp() {
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
  }

  public String getTaxCurr() {
    return taxCurr;
  }

  public void setTaxCurr(String taxCurr) {
    this.taxCurr = taxCurr;
  }

  public String getTaxIsoc() {
    return taxIsoc;
  }

  public void setTaxIsoc(String taxIsoc) {
    this.taxIsoc = taxIsoc;
  }

  public BigDecimal getTaxAmnt() {
    return taxAmnt;
  }

  public void setTaxAmnt(BigDecimal taxAmnt) {
    this.taxAmnt = taxAmnt;
  }

  public String getTaxActi() {
    return taxActi;
  }

  public void setTaxActi(String taxActi) {
    this.taxActi = taxActi;
  }

}
