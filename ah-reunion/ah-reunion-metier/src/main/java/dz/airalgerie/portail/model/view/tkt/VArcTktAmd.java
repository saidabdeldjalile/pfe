/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.view.tkt;

import dz.airalgerie.portail.model.entities.tkt.CompensationTKT;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hp
 */
@Entity
@Table(schema = "dbo", name = "V_ARC_TKT_AMD_V2")
public class VArcTktAmd implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_ISSUE")
  private LocalDate dateIssue;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_CREATION_ETS")
  private LocalDate dateCreationEts;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "PNR")
  private String pnr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "RES_SYST")
  private String resSyst;
  @Size(max = 6)
  @Column(name = "PNR_OTH")
  private String pnrOth;
  @Size(max = 4)
  @Column(name = "RES_OTH")
  private String resOth;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "FST_TKT")
  private String fstTkt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "LAST_TKT")
  private String lastTkt;
  @Column(name = "BOOKLET_COUNT")
  private Short bookletCount;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CP_COUNT")
  private short cpCount;
  @Size(max = 3)
  @Column(name = "TKMI")
  private String tkmi;
  @Size(max = 4)
  @Column(name = "INTSI")
  private String intsi;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "ISS_CITY")
  private String issCity;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "ISS_CNTRY")
  private String issCntry;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "AGN_IATA")
  private String agnIata;
  @Size(max = 7)
  @Column(name = "AGN_TYPE")
  private String agnType;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 40)
  @Column(name = "PAX_SURNAME")
  private String paxSurname;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 40)
  @Column(name = "PAX_GIVENNAME")
  private String paxGivenname;
  @Size(max = 3)
  @Column(name = "PAX_TYPE")
  private String paxType;
  @Size(max = 20)
  @Column(name = "TOUR_CODE")
  private String tourCode;
  @Size(max = 20)
  @Column(name = "FFP_NBR")
  private String ffpNbr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "ENDORS")
  private String endors;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 720)
  @Column(name = "FARE_CALC")
  private String fareCalc;
  @Size(max = 3)
  @Column(name = "FCMI")
  private String fcmi;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CUR_CODE")
  private String curCode;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TTL_FARE")
  private BigDecimal ttlFare;
  @Column(name = "ADC_IND")
  private Character adcInd;
  @Size(max = 3)
  @Column(name = "ADC_CUR")
  private String adcCur;
  @Column(name = "ADC_AMT")
  private BigDecimal adcAmt;
  @Size(max = 3)
  @Column(name = "ADT_CUR")
  private String adtCur;
  @Column(name = "ADT_AMT")
  private BigDecimal adtAmt;
  @Size(max = 3)
  @Column(name = "EFR_CUR")
  private String efrCur;
  @Column(name = "EFR_AMT")
  private BigDecimal efrAmt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "BFR_CUR")
  private String bfrCur;
  @Basic(optional = false)
  @NotNull
  @Column(name = "BFR_AMT")
  private BigDecimal bfrAmt;
  @Column(name = "CL")
  private String controlLocation;
  @Column(name = "FOP")
  private String fop;
  @Column(name = "COUPONS")
  private String coupons;
  @OneToOne(mappedBy = "vArcTktAmd", fetch = FetchType.LAZY)
  private CompensationTKT compensationTKT;

  public VArcTktAmd() {
  }

  public VArcTktAmd(String etkt, LocalDate dateIssue, LocalDate dateCreationEts, String pnr, String resSyst,
      String pnrOth, String resOth, String fstTkt, String lastTkt, Short bookletCount,
      short cpCount, String tkmi, String intsi, String issCity, String issCntry, String agnIata,
      String agnType, String paxSurname, String paxGivenname, String paxType, String tourCode,
      String ffpNbr, String endors, String fareCalc, String fcmi, String curCode,
      BigDecimal ttlFare, Character adcInd, String adcCur, BigDecimal adcAmt, String adtCur,
      BigDecimal adtAmt, String efrCur, BigDecimal efrAmt, String bfrCur, BigDecimal bfrAmt,
      String controlLocation) {
    this.etkt = etkt;
    this.dateIssue = dateIssue;
    this.dateCreationEts = dateCreationEts;
    this.pnr = pnr;
    this.resSyst = resSyst;
    this.pnrOth = pnrOth;
    this.resOth = resOth;
    this.fstTkt = fstTkt;
    this.lastTkt = lastTkt;
    this.bookletCount = bookletCount;
    this.cpCount = cpCount;
    this.tkmi = tkmi;
    this.intsi = intsi;
    this.issCity = issCity;
    this.issCntry = issCntry;
    this.agnIata = agnIata;
    this.agnType = agnType;
    this.paxSurname = paxSurname;
    this.paxGivenname = paxGivenname;
    this.paxType = paxType;
    this.tourCode = tourCode;
    this.ffpNbr = ffpNbr;
    this.endors = endors;
    this.fareCalc = fareCalc;
    this.fcmi = fcmi;
    this.curCode = curCode;
    this.ttlFare = ttlFare;
    this.adcInd = adcInd;
    this.adcCur = adcCur;
    this.adcAmt = adcAmt;
    this.adtCur = adtCur;
    this.adtAmt = adtAmt;
    this.efrCur = efrCur;
    this.efrAmt = efrAmt;
    this.bfrCur = bfrCur;
    this.bfrAmt = bfrAmt;
    this.controlLocation = controlLocation;
  }



  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public LocalDate getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(LocalDate dateIssue) {
    this.dateIssue = dateIssue;
  }

  public LocalDate getDateCreationEts() {
    return dateCreationEts;
  }

  public void setDateCreationEts(LocalDate dateCreationEts) {
    this.dateCreationEts = dateCreationEts;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public String getResSyst() {
    return resSyst;
  }

  public void setResSyst(String resSyst) {
    this.resSyst = resSyst;
  }

  public String getPnrOth() {
    return pnrOth;
  }

  public void setPnrOth(String pnrOth) {
    this.pnrOth = pnrOth;
  }

  public String getResOth() {
    return resOth;
  }

  public void setResOth(String resOth) {
    this.resOth = resOth;
  }

  public String getFstTkt() {
    return fstTkt;
  }

  public void setFstTkt(String fstTkt) {
    this.fstTkt = fstTkt;
  }

  public String getLastTkt() {
    return lastTkt;
  }

  public void setLastTkt(String lastTkt) {
    this.lastTkt = lastTkt;
  }

  public Short getBookletCount() {
    return bookletCount;
  }

  public void setBookletCount(Short bookletCount) {
    this.bookletCount = bookletCount;
  }

  public short getCpCount() {
    return cpCount;
  }

  public void setCpCount(short cpCount) {
    this.cpCount = cpCount;
  }

  public String getTkmi() {
    return tkmi;
  }

  public void setTkmi(String tkmi) {
    this.tkmi = tkmi;
  }

  public String getIntsi() {
    return intsi;
  }

  public void setIntsi(String intsi) {
    this.intsi = intsi;
  }

  public String getIssCity() {
    return issCity;
  }

  public void setIssCity(String issCity) {
    this.issCity = issCity;
  }

  public String getIssCntry() {
    return issCntry;
  }

  public void setIssCntry(String issCntry) {
    this.issCntry = issCntry;
  }

  public String getAgnIata() {
    return agnIata;
  }

  public void setAgnIata(String agnIata) {
    this.agnIata = agnIata;
  }

  public String getAgnType() {
    return agnType;
  }

  public void setAgnType(String agnType) {
    this.agnType = agnType;
  }

  public String getPaxSurname() {
    return paxSurname;
  }

  public void setPaxSurname(String paxSurname) {
    this.paxSurname = paxSurname;
  }

  public String getPaxGivenname() {
    return paxGivenname;
  }

  public void setPaxGivenname(String paxGivenname) {
    this.paxGivenname = paxGivenname;
  }

  public String getPaxType() {
    return paxType;
  }

  public void setPaxType(String paxType) {
    this.paxType = paxType;
  }

  public String getTourCode() {
    return tourCode;
  }

  public void setTourCode(String tourCode) {
    this.tourCode = tourCode;
  }

  public String getFfpNbr() {
    return ffpNbr;
  }

  public void setFfpNbr(String ffpNbr) {
    this.ffpNbr = ffpNbr;
  }

  public String getEndors() {
    return endors;
  }

  public void setEndors(String endors) {
    this.endors = endors;
  }

  public String getFareCalc() {
    return fareCalc;
  }

  public void setFareCalc(String fareCalc) {
    this.fareCalc = fareCalc;
  }

  public String getFcmi() {
    return fcmi;
  }

  public void setFcmi(String fcmi) {
    this.fcmi = fcmi;
  }

  public String getCurCode() {
    return curCode;
  }

  public void setCurCode(String curCode) {
    this.curCode = curCode;
  }

  public BigDecimal getTtlFare() {
    return ttlFare;
  }

  public void setTtlFare(BigDecimal ttlFare) {
    this.ttlFare = ttlFare;
  }

  public Character getAdcInd() {
    return adcInd;
  }

  public void setAdcInd(Character adcInd) {
    this.adcInd = adcInd;
  }

  public String getAdcCur() {
    return adcCur;
  }

  public void setAdcCur(String adcCur) {
    this.adcCur = adcCur;
  }

  public BigDecimal getAdcAmt() {
    return adcAmt;
  }

  public void setAdcAmt(BigDecimal adcAmt) {
    this.adcAmt = adcAmt;
  }

  public String getAdtCur() {
    return adtCur;
  }

  public void setAdtCur(String adtCur) {
    this.adtCur = adtCur;
  }

  public BigDecimal getAdtAmt() {
    return adtAmt;
  }

  public void setAdtAmt(BigDecimal adtAmt) {
    this.adtAmt = adtAmt;
  }

  public String getEfrCur() {
    return efrCur;
  }

  public void setEfrCur(String efrCur) {
    this.efrCur = efrCur;
  }

  public BigDecimal getEfrAmt() {
    return efrAmt;
  }

  public void setEfrAmt(BigDecimal efrAmt) {
    this.efrAmt = efrAmt;
  }

  public String getBfrCur() {
    return bfrCur;
  }

  public void setBfrCur(String bfrCur) {
    this.bfrCur = bfrCur;
  }

  public BigDecimal getBfrAmt() {
    return bfrAmt;
  }

  public void setBfrAmt(BigDecimal bfrAmt) {
    this.bfrAmt = bfrAmt;
  }

  public CompensationTKT getCompensationTKT() {
    return compensationTKT;
  }

  public void setCompensationTKT(CompensationTKT compensationTKT) {
    this.compensationTKT = compensationTKT;
  }

  public String getControlLocation() {
    return controlLocation;
  }

  public void setControlLocation(String controlLocation) {
    this.controlLocation = controlLocation;
  }

  public String getFop() {
    return fop;
  }

  public void setFop(String fop) {
    this.fop = fop;
  }

  public String getCoupons() {
    return coupons;
  }

  public void setCoupons(String coupons) {
    this.coupons = coupons;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.etkt);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VArcTktAmd other = (VArcTktAmd) obj;
    return Objects.equals(this.etkt, other.etkt);
  }

  @Override
  public String toString() {
    return "VArcTktAmd{" + "etkt=" + etkt + ", dateIssue=" + dateIssue + ", dateCreationEts="
        + dateCreationEts + ", pnr=" + pnr + ", resSyst=" + resSyst + ", pnrOth=" + pnrOth
        + ", resOth=" + resOth + ", fstTkt=" + fstTkt + ", lastTkt=" + lastTkt + ", bookletCount="
        + bookletCount + ", cpCount=" + cpCount + ", tkmi=" + tkmi + ", intsi=" + intsi
        + ", issCity=" + issCity + ", issCntry=" + issCntry + ", agnIata=" + agnIata + ", agnType="
        + agnType + ", paxSurname=" + paxSurname + ", paxGivenname=" + paxGivenname + ", paxType="
        + paxType + ", tourCode=" + tourCode + ", ffpNbr=" + ffpNbr + ", endors=" + endors
        + ", fareCalc=" + fareCalc + ", fcmi=" + fcmi + ", curCode=" + curCode + ", ttlFare="
        + ttlFare + ", adcInd=" + adcInd + ", adcCur=" + adcCur + ", adcAmt=" + adcAmt + ", adtCur="
        + adtCur + ", adtAmt=" + adtAmt + ", efrCur=" + efrCur + ", efrAmt=" + efrAmt + ", bfrCur="
        + bfrCur + ", bfrAmt=" + bfrAmt + ", controlLocation=" + controlLocation + ", fop=" + fop
        + ", coupons=" + coupons + ", compensationTKT=" + compensationTKT + '}';
  }

}
