/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.ops.model.entities.emd.CompensationEmd;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_TKT_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdTktComp.findAll", query = "SELECT v FROM VArcEmdTktComp v")})
public class VArcEmdTktComp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Id
  @Column(name = "EMD_NBR")
  private String emdNbr;
  @Column(name = "PAX_SURNAME")
  private String paxSurname;
  @Column(name = "PAX_GIVENNAME")
  private String paxGivenname;
  @Column(name = "PAX_TYPE")
  private String paxType;
  @Column(name = "CPN_COUNT")
  private String cpnCount;
  @Column(name = "DOCUMENT_TYPE")
  private String documentType;
  @Column(name = "TKT_TKMI")
  private String tktTkmi;
  @Column(name = "STAT_CODE")
  private String statCode;
  @Column(name = "DATE_ISSUE")
  private LocalDate dateIssue;
  @Column(name = "ORG_CITY")
  private String orgCity;
  @Column(name = "DST_CITY")
  private String dstCity;
  @Column(name = "RES_SYST")
  private String resSyst;
  @Column(name = "PNR_RECL")
  private String pnrRecl;
  @Column(name = "RES_OTHE")
  private String resOthe;
  @Column(name = "PNR_OTHE")
  private String pnrOthe;
  @Column(name = "DELIV_SYSTEM")
  private String delivSystem;
  @Column(name = "AGN_IATA")
  private String agnIata;
  @Column(name = "DLV_CITY")
  private String dlvCity;
  @Column(name = "AGN_TYPE")
  private String agnType;
  @Column(name = "TKT_CTRY")
  private String tktCtry;
  @Column(name = "TOUR_CODE")
  private String tourCode;
  @Column(name = "FFN_NMBR")
  private String ffnNmbr;
  @Column(name = "NDR_ENRS")
  private String ndrEnrs;
  @Column(name = "EMD_RFIC")
  private String emdRfic;
  @Column(name = "RFIC_TXT")
  private String rficTxt;
  @Column(name = "RFIC_RMK")
  private String rficRmk;
  @Column(name = "PIN_FCMI")
  private String pinFcmi;
  @Column(name = "CUR_CODE")
  private String curCode;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TTL_FARE")
  private BigDecimal ttlFare;
  @Column(name = "ADC_IND")
  private String adcInd;
  @Column(name = "ADC_CURR")
  private String adcCurr;
  @Column(name = "ADC_AMNT")
  private BigDecimal adcAmnt;
  @Column(name = "BFR_CURR")
  private String bfrCurr;
  @Column(name = "BFR_AMNT")
  private BigDecimal bfrAmnt;
  @Column(name = "EFR_CURR")
  private String efrCurr;
  @Column(name = "EFR_AMNT")
  private BigDecimal efrAmnt;
  @Column(name = "CURR_BANK")
  private String currBank;
  @Column(name = "CL")
  private String cl;
  @Column(name = "FOP")
  private String fop;
  @Column(name = "COUPONS")
  private String coupons;
  @OneToOne(mappedBy = "vArcEmdAmd", fetch = FetchType.LAZY)
  private CompensationEmd compensationEmd;

  public VArcEmdTktComp() {
  }

  public VArcEmdTktComp(String emdNbr, String paxSurname, String paxGivenname, String paxType,
      String cpnCount, String documentType, String tktTkmi, String statCode, LocalDate dateIssue,
      String orgCity, String dstCity, String resSyst, String pnrRecl, String resOthe,
      String pnrOthe, String delivSystem, String agnIata, String dlvCity, String agnType,
      String tktCtry, String tourCode, String ffnNmbr, String ndrEnrs, String emdRfic,
      String rficTxt, String rficRmk, String pinFcmi, String curCode, BigDecimal ttlFare,
      String adcInd, String adcCurr, BigDecimal adcAmnt, String bfrCurr, BigDecimal bfrAmnt,
      String efrCurr, BigDecimal efrAmnt, String currBank, String cl) {
    this.emdNbr = emdNbr;
    this.paxSurname = paxSurname;
    this.paxGivenname = paxGivenname;
    this.paxType = paxType;
    this.cpnCount = cpnCount;
    this.documentType = documentType;
    this.tktTkmi = tktTkmi;
    this.statCode = statCode;
    this.dateIssue = dateIssue;
    this.orgCity = orgCity;
    this.dstCity = dstCity;
    this.resSyst = resSyst;
    this.pnrRecl = pnrRecl;
    this.resOthe = resOthe;
    this.pnrOthe = pnrOthe;
    this.delivSystem = delivSystem;
    this.agnIata = agnIata;
    this.dlvCity = dlvCity;
    this.agnType = agnType;
    this.tktCtry = tktCtry;
    this.tourCode = tourCode;
    this.ffnNmbr = ffnNmbr;
    this.ndrEnrs = ndrEnrs;
    this.emdRfic = emdRfic;
    this.rficTxt = rficTxt;
    this.rficRmk = rficRmk;
    this.pinFcmi = pinFcmi;
    this.curCode = curCode;
    this.ttlFare = ttlFare;
    this.adcInd = adcInd;
    this.adcCurr = adcCurr;
    this.adcAmnt = adcAmnt;
    this.bfrCurr = bfrCurr;
    this.bfrAmnt = bfrAmnt;
    this.efrCurr = efrCurr;
    this.efrAmnt = efrAmnt;
    this.currBank = currBank;
    this.cl = cl;
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
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

  public String getCpnCount() {
    return cpnCount;
  }

  public void setCpnCount(String cpnCount) {
    this.cpnCount = cpnCount;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getTktTkmi() {
    return tktTkmi;
  }

  public void setTktTkmi(String tktTkmi) {
    this.tktTkmi = tktTkmi;
  }

  public String getStatCode() {
    return statCode;
  }

  public void setStatCode(String statCode) {
    this.statCode = statCode;
  }

  public LocalDate getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(LocalDate dateIssue) {
    this.dateIssue = dateIssue;
  }

  public String getOrgCity() {
    return orgCity;
  }

  public void setOrgCity(String orgCity) {
    this.orgCity = orgCity;
  }

  public String getDstCity() {
    return dstCity;
  }

  public void setDstCity(String dstCity) {
    this.dstCity = dstCity;
  }

  public String getResSyst() {
    return resSyst;
  }

  public void setResSyst(String resSyst) {
    this.resSyst = resSyst;
  }

  public String getPnrRecl() {
    return pnrRecl;
  }

  public void setPnrRecl(String pnrRecl) {
    this.pnrRecl = pnrRecl;
  }

  public String getResOthe() {
    return resOthe;
  }

  public void setResOthe(String resOthe) {
    this.resOthe = resOthe;
  }

  public String getPnrOthe() {
    return pnrOthe;
  }

  public void setPnrOthe(String pnrOthe) {
    this.pnrOthe = pnrOthe;
  }

  public String getDelivSystem() {
    return delivSystem;
  }

  public void setDelivSystem(String delivSystem) {
    this.delivSystem = delivSystem;
  }

  public String getAgnIata() {
    return agnIata;
  }

  public void setAgnIata(String agnIata) {
    this.agnIata = agnIata;
  }

  public String getDlvCity() {
    return dlvCity;
  }

  public void setDlvCity(String dlvCity) {
    this.dlvCity = dlvCity;
  }

  public String getAgnType() {
    return agnType;
  }

  public void setAgnType(String agnType) {
    this.agnType = agnType;
  }

  public String getTktCtry() {
    return tktCtry;
  }

  public void setTktCtry(String tktCtry) {
    this.tktCtry = tktCtry;
  }

  public String getTourCode() {
    return tourCode;
  }

  public void setTourCode(String tourCode) {
    this.tourCode = tourCode;
  }

  public String getFfnNmbr() {
    return ffnNmbr;
  }

  public void setFfnNmbr(String ffnNmbr) {
    this.ffnNmbr = ffnNmbr;
  }

  public String getNdrEnrs() {
    return ndrEnrs;
  }

  public void setNdrEnrs(String ndrEnrs) {
    this.ndrEnrs = ndrEnrs;
  }

  public String getEmdRfic() {
    return emdRfic;
  }

  public void setEmdRfic(String emdRfic) {
    this.emdRfic = emdRfic;
  }

  public String getRficTxt() {
    return rficTxt;
  }

  public void setRficTxt(String rficTxt) {
    this.rficTxt = rficTxt;
  }

  public String getRficRmk() {
    return rficRmk;
  }

  public void setRficRmk(String rficRmk) {
    this.rficRmk = rficRmk;
  }

  public String getPinFcmi() {
    return pinFcmi;
  }

  public void setPinFcmi(String pinFcmi) {
    this.pinFcmi = pinFcmi;
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

  public String getAdcInd() {
    return adcInd;
  }

  public void setAdcInd(String adcInd) {
    this.adcInd = adcInd;
  }

  public String getAdcCurr() {
    return adcCurr;
  }

  public void setAdcCurr(String adcCurr) {
    this.adcCurr = adcCurr;
  }

  public BigDecimal getAdcAmnt() {
    return adcAmnt;
  }

  public void setAdcAmnt(BigDecimal adcAmnt) {
    this.adcAmnt = adcAmnt;
  }

  public String getBfrCurr() {
    return bfrCurr;
  }

  public void setBfrCurr(String bfrCurr) {
    this.bfrCurr = bfrCurr;
  }

  public BigDecimal getBfrAmnt() {
    return bfrAmnt;
  }

  public void setBfrAmnt(BigDecimal bfrAmnt) {
    this.bfrAmnt = bfrAmnt;
  }

  public String getEfrCurr() {
    return efrCurr;
  }

  public void setEfrCurr(String efrCurr) {
    this.efrCurr = efrCurr;
  }

  public BigDecimal getEfrAmnt() {
    return efrAmnt;
  }

  public void setEfrAmnt(BigDecimal efrAmnt) {
    this.efrAmnt = efrAmnt;
  }

  public String getCurrBank() {
    return currBank;
  }

  public void setCurrBank(String currBank) {
    this.currBank = currBank;
  }

  public String getCl() {
    return cl;
  }

  public void setCl(String cl) {
    this.cl = cl;
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

  public CompensationEmd getCompensationEmd() {
    return compensationEmd;
  }

  public void setCompensationEmd(CompensationEmd compensationEmd) {
    this.compensationEmd = compensationEmd;
  }

}
