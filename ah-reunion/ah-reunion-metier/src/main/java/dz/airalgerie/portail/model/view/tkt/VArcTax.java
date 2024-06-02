/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.view.tkt;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(schema = "dbo", name = "V_ARC_TAX")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VArcTax.findAll", query = "SELECT v FROM VArcTax v"),
    @NamedQuery(name = "VArcTax.findByEtkt",
        query = "SELECT v FROM VArcTax v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VArcTax.findByTaxCur",
        query = "SELECT v FROM VArcTax v WHERE v.taxCur = :taxCur"),
    @NamedQuery(name = "VArcTax.findByTaxCnd",
        query = "SELECT v FROM VArcTax v WHERE v.taxCnd = :taxCnd"),
    @NamedQuery(name = "VArcTax.findByTaxCode",
        query = "SELECT v FROM VArcTax v WHERE v.taxCode = :taxCode"),
    @NamedQuery(name = "VArcTax.findByTaxAmt",
        query = "SELECT v FROM VArcTax v WHERE v.taxAmt = :taxAmt"),
    @NamedQuery(name = "VArcTax.findByTaxActi",
        query = "SELECT v FROM VArcTax v WHERE v.taxActi = :taxActi")})
public class VArcTax implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Size(max = 3)
  @Column(name = "TAX_CUR")
  private String taxCur;
  @Size(max = 2)
  @Column(name = "TAX_CND")
  private String taxCnd;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "TAX_CODE")
  private String taxCode;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAX_AMT")
  private BigDecimal taxAmt;
  @Size(max = 1)
  @Column(name = "TAX_ACTI")
  private String taxActi;

  public VArcTax() {
  }

  public VArcTax(String etkt, String taxCur, String taxCnd, String taxCode, BigDecimal taxAmt,
      String taxActi) {
    this.etkt = etkt;
    this.taxCur = taxCur;
    this.taxCnd = taxCnd;
    this.taxCode = taxCode;
    this.taxAmt = taxAmt;
    this.taxActi = taxActi;
  }


  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public String getTaxCur() {
    return taxCur;
  }

  public void setTaxCur(String taxCur) {
    this.taxCur = taxCur;
  }

  public String getTaxCnd() {
    return taxCnd;
  }

  public void setTaxCnd(String taxCnd) {
    this.taxCnd = taxCnd;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public BigDecimal getTaxAmt() {
    return taxAmt;
  }

  public void setTaxAmt(BigDecimal taxAmt) {
    this.taxAmt = taxAmt;
  }

  public String getTaxActi() {
    return taxActi;
  }

  public void setTaxActi(String taxActi) {
    this.taxActi = taxActi;
  }

}
