
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the SALE database table.
 * 
 */
@Entity
@Table(name = "SALE")
public class Sale implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "ISSUING_AGENT")
  private String issuingAgent;

  @Column(name = "ISSUING_CITY")
  private String issuingCity;

  @Column(name = "LOCATION_IATA_CODE")
  private String locationIataCode;

  @Temporal(TemporalType.DATE)
  @Column(name = "SYSTEM_DATE_ISSUE")
  private Date systemDateIssue;

  @Id
  @Column(name = "TKT_NBR")
  private long tktNbr;

  @Column(name = "TOT_AMT")
  private BigDecimal totAmt;

  @Column(name = "TOT_AMT_CUR")
  private String totAmtCur;

  @Column(name = "TOT_AMT_DATA")
  private String totAmtData;

  public Sale() {}

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

  public String getLocationIataCode() {
    return this.locationIataCode;
  }

  public void setLocationIataCode(String locationIataCode) {
    this.locationIataCode = locationIataCode;
  }

  public Date getSystemDateIssue() {
    return this.systemDateIssue;
  }

  public void setSystemDateIssue(Date systemDateIssue) {
    this.systemDateIssue = systemDateIssue;
  }

  public long getTktNbr() {
    return this.tktNbr;
  }

  public void setTktNbr(long tktNbr) {
    this.tktNbr = tktNbr;
  }

  public BigDecimal getTotAmt() {
    return this.totAmt;
  }

  public void setTotAmt(BigDecimal totAmt) {
    this.totAmt = totAmt;
  }

  public String getTotAmtCur() {
    return this.totAmtCur;
  }

  public void setTotAmtCur(String totAmtCur) {
    this.totAmtCur = totAmtCur;
  }

  public String getTotAmtData() {
    return this.totAmtData;
  }

  public void setTotAmtData(String totAmtData) {
    this.totAmtData = totAmtData;
  }

}
