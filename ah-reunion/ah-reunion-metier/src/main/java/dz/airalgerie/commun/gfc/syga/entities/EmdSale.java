
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the EMD_SALE database table.
 * 
 */
@Entity
@Table(name = "EMD_SALE")
public class EmdSale implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "AGENCY_CODE")
  private String locationIataCode;

  @Column(name = "CUR")
  private String cur;

  @Column(name = "EMD_IND")
  private String emdInd;

  @Id
  @Column(name = "EMD_NBR")
  private long emdNbr;

  @Column(name = "ISSUING_AGENT")
  private String issuingAgent;

  @Column(name = "ISSUING_CITY")
  private String issuingCity;

  @Temporal(TemporalType.DATE)
  @Column(name = "ISSUNIG_SYS_DATE")
  private Date systemDateIssue;

  @Column(name = "RFIC")
  private String rfic;

  @Column(name = "RFIC_DESC")
  private String rficDesc;

  @Column(name = "TOTAL_AMT")
  private BigDecimal totAmt;

  public EmdSale() {}

  public String getAgencyCode() {
    return this.locationIataCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.locationIataCode = agencyCode;
  }

  public String getCur() {
    return this.cur;
  }

  public void setCur(String cur) {
    this.cur = cur;
  }

  public String getEmdInd() {
    return this.emdInd;
  }

  public void setEmdInd(String emdInd) {
    this.emdInd = emdInd;
  }

  public long getEmdNbr() {
    return this.emdNbr;
  }

  public void setEmdNbr(long emdNbr) {
    this.emdNbr = emdNbr;
  }

  public String getIssuingAgent() {
    return this.issuingAgent;
  }

  public void setIssuingAgent(String issuingAgent) {
    this.issuingAgent = issuingAgent;
  }

  public String getIssuingCity() {
    return this.issuingCity;
  }

  public void setIssuingCity(String issuingCity) {
    this.issuingCity = issuingCity;
  }

  public Date getIssunigSysDate() {
    return this.systemDateIssue;
  }

  public void setIssunigSysDate(Date issunigSysDate) {
    this.systemDateIssue = issunigSysDate;
  }

  public String getRfic() {
    return this.rfic;
  }

  public void setRfic(String rfic) {
    this.rfic = rfic;
  }

  public String getRficDesc() {
    return this.rficDesc;
  }

  public void setRficDesc(String rficDesc) {
    this.rficDesc = rficDesc;
  }

  public BigDecimal getTotalAmt() {
    return this.totAmt;
  }

  public void setTotalAmt(BigDecimal totalAmt) {
    this.totAmt = totalAmt;
  }

}
