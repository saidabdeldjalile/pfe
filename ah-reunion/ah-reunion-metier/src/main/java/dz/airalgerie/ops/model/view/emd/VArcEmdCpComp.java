/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
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
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_CP_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdCpComp.findAll", query = "SELECT v FROM VArcEmdCpComp v")})
public class VArcEmdCpComp implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Basic(optional = false)
  @Id
  @Column(name = "EMD_NBR")
  private String emdNbr;
  @Column(name = "SCD_DATE")
  private LocalDate scdDate;
  @Basic(optional = false)
  @Column(name = "CP")
  private String cp;
  @Basic(optional = false)
  @Column(name = "CP_STAT")
  private String cpStat;
  @Column(name = "EXC_EMDNUM")
  private String excEmdnum;
  @Column(name = "SAC_CODE")
  private String sacCode;
  @Column(name = "NVB_DATE")
  private LocalDate nvbDate;
  @Column(name = "NVA_DATE")
  private LocalDate nvaDate;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CPN_VAL")
  private BigDecimal cpnVal;
  @Column(name = "RFISC")
  private String rfisc;
  @Column(name = "RFISC_TXT")
  private String rfiscTxt;
  @Column(name = "CPN_RMRKS")
  private String cpnRmrks;
  @Column(name = "CAI_IND")
  private String caiInd;
  @Column(name = "NRF_IND")
  private String nrfInd;
  @Column(name = "NEX_IND")
  private String nexInd;
  @Column(name = "NIN_IND")
  private String ninInd;
  @Column(name = "XSB_RTU")
  private BigDecimal xsbRtu;
  @Column(name = "XSB_CURR")
  private String xsbCurr;
  @Column(name = "XSB_NBP")
  private String xsbNbp;
  @Column(name = "XSB_KGS")
  private String xsbKgs;
  @Column(name = "ICW_TKT")
  private String icwTkt;
  @Column(name = "ICW_CPN")
  private String icwCpn;
  @Column(name = "DEP_DATE")
  private LocalDate depDate;
  @Column(name = "DEP_TIME")
  private String depTime;
  @Column(name = "ORG_ARPT")
  private String orgArpt;
  @Column(name = "DST_ARPT")
  private String dstArpt;

  public VArcEmdCpComp() {
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
  }

  public LocalDate getScdDate() {
    return scdDate;
  }

  public void setScdDate(LocalDate scdDate) {
    this.scdDate = scdDate;
  }

  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public String getCpStat() {
    return cpStat;
  }

  public void setCpStat(String cpStat) {
    this.cpStat = cpStat;
  }

  public String getExcEmdnum() {
    return excEmdnum;
  }

  public void setExcEmdnum(String excEmdnum) {
    this.excEmdnum = excEmdnum;
  }

  public String getSacCode() {
    return sacCode;
  }

  public void setSacCode(String sacCode) {
    this.sacCode = sacCode;
  }

  public LocalDate getNvbDate() {
    return nvbDate;
  }

  public void setNvbDate(LocalDate nvbDate) {
    this.nvbDate = nvbDate;
  }

  public LocalDate getNvaDate() {
    return nvaDate;
  }

  public void setNvaDate(LocalDate nvaDate) {
    this.nvaDate = nvaDate;
  }

  public BigDecimal getCpnVal() {
    return cpnVal;
  }

  public void setCpnVal(BigDecimal cpnVal) {
    this.cpnVal = cpnVal;
  }

  public String getRfisc() {
    return rfisc;
  }

  public void setRfisc(String rfisc) {
    this.rfisc = rfisc;
  }

  public String getRfiscTxt() {
    return rfiscTxt;
  }

  public void setRfiscTxt(String rfiscTxt) {
    this.rfiscTxt = rfiscTxt;
  }

  public String getCpnRmrks() {
    return cpnRmrks;
  }

  public void setCpnRmrks(String cpnRmrks) {
    this.cpnRmrks = cpnRmrks;
  }

  public String getCaiInd() {
    return caiInd;
  }

  public void setCaiInd(String caiInd) {
    this.caiInd = caiInd;
  }

  public String getNrfInd() {
    return nrfInd;
  }

  public void setNrfInd(String nrfInd) {
    this.nrfInd = nrfInd;
  }

  public String getNexInd() {
    return nexInd;
  }

  public void setNexInd(String nexInd) {
    this.nexInd = nexInd;
  }

  public String getNinInd() {
    return ninInd;
  }

  public void setNinInd(String ninInd) {
    this.ninInd = ninInd;
  }

  public BigDecimal getXsbRtu() {
    return xsbRtu;
  }

  public void setXsbRtu(BigDecimal xsbRtu) {
    this.xsbRtu = xsbRtu;
  }

  public String getXsbCurr() {
    return xsbCurr;
  }

  public void setXsbCurr(String xsbCurr) {
    this.xsbCurr = xsbCurr;
  }

  public String getXsbNbp() {
    return xsbNbp;
  }

  public void setXsbNbp(String xsbNbp) {
    this.xsbNbp = xsbNbp;
  }

  public String getXsbKgs() {
    return xsbKgs;
  }

  public void setXsbKgs(String xsbKgs) {
    this.xsbKgs = xsbKgs;
  }

  public String getIcwTkt() {
    return icwTkt;
  }

  public void setIcwTkt(String icwTkt) {
    this.icwTkt = icwTkt;
  }

  public String getIcwCpn() {
    return icwCpn;
  }

  public void setIcwCpn(String icwCpn) {
    this.icwCpn = icwCpn;
  }

  public LocalDate getDepDate() {
    return depDate;
  }

  public void setDepDate(LocalDate depDate) {
    this.depDate = depDate;
  }

  public String getDepTime() {
    return depTime;
  }

  public void setDepTime(String depTime) {
    this.depTime = depTime;
  }

  public String getOrgArpt() {
    return orgArpt;
  }

  public void setOrgArpt(String orgArpt) {
    this.orgArpt = orgArpt;
  }

  public String getDstArpt() {
    return dstArpt;
  }

  public void setDstArpt(String dstArpt) {
    this.dstArpt = dstArpt;
  }

}
