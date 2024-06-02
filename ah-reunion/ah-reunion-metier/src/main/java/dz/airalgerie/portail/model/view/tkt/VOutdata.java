/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.view.tkt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;

/**
 *
 * @author hp
 */
@Entity
@Table(schema = "dbo", name = "V_OUTDATA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VOutdata.findAll", query = "SELECT v FROM VOutdata v"),
    @NamedQuery(name = "VOutdata.findByDateIssue",
        query = "SELECT v FROM VOutdata v WHERE v.dateIssue = :dateIssue"),
    @NamedQuery(name = "VOutdata.findByPlaceIssue",
        query = "SELECT v FROM VOutdata v WHERE v.placeIssue = :placeIssue"),
    @NamedQuery(name = "VOutdata.findByReturnAgent",
        query = "SELECT v FROM VOutdata v WHERE v.returnAgent = :returnAgent"),
    @NamedQuery(name = "VOutdata.findByEtkt",
        query = "SELECT v FROM VOutdata v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VOutdata.findByCp", query = "SELECT v FROM VOutdata v WHERE v.cp = :cp"),
    @NamedQuery(name = "VOutdata.findByDocClass",
        query = "SELECT v FROM VOutdata v WHERE v.docClass = :docClass"),
    @NamedQuery(name = "VOutdata.findByUtilType",
        query = "SELECT v FROM VOutdata v WHERE v.utilType = :utilType"),
    @NamedQuery(name = "VOutdata.findByCarrierUplifeted",
        query = "SELECT v FROM VOutdata v WHERE v.carrierUplifeted = :carrierUplifeted"),
    @NamedQuery(name = "VOutdata.findByBookFlightNo",
        query = "SELECT v FROM VOutdata v WHERE v.bookFlightNo = :bookFlightNo"),
    @NamedQuery(name = "VOutdata.findByBookFloghtDate",
        query = "SELECT v FROM VOutdata v WHERE v.bookFloghtDate = :bookFloghtDate"),
    @NamedQuery(name = "VOutdata.findByPnr", query = "SELECT v FROM VOutdata v WHERE v.pnr = :pnr"),
    @NamedQuery(name = "VOutdata.findBySalesSource",
        query = "SELECT v FROM VOutdata v WHERE v.salesSource = :salesSource"),
    @NamedQuery(name = "VOutdata.findByGrossFare",
        query = "SELECT v FROM VOutdata v WHERE v.grossFare = :grossFare"),
    @NamedQuery(name = "VOutdata.findByDiscount",
        query = "SELECT v FROM VOutdata v WHERE v.discount = :discount"),
    @NamedQuery(name = "VOutdata.findByComission",
        query = "SELECT v FROM VOutdata v WHERE v.comission = :comission"),
    @NamedQuery(name = "VOutdata.findByTotalTaxes",
        query = "SELECT v FROM VOutdata v WHERE v.totalTaxes = :totalTaxes"),
    @NamedQuery(name = "VOutdata.findBySalesTaxString",
        query = "SELECT v FROM VOutdata v WHERE v.salesTaxString = :salesTaxString"),
    @NamedQuery(name = "VOutdata.findByUpliftTaxString",
        query = "SELECT v FROM VOutdata v WHERE v.upliftTaxString = :upliftTaxString"),
    @NamedQuery(name = "VOutdata.findByAirlineTaxString",
        query = "SELECT v FROM VOutdata v WHERE v.airlineTaxString = :airlineTaxString"),
    @NamedQuery(name = "VOutdata.findByClass1",
        query = "SELECT v FROM VOutdata v WHERE v.class1 = :class1"),
    @NamedQuery(name = "VOutdata.findByOriginalTicketedFareBasis",
        query = "SELECT v FROM VOutdata v WHERE v.originalTicketedFareBasis = :originalTicketedFareBasis"),
    @NamedQuery(name = "VOutdata.findByFareBasisTd",
        query = "SELECT v FROM VOutdata v WHERE v.fareBasisTd = :fareBasisTd"),
    @NamedQuery(name = "VOutdata.findByCityPair",
        query = "SELECT v FROM VOutdata v WHERE v.cityPair = :cityPair"),
    @NamedQuery(name = "VOutdata.findByInternationalDomesticFlag",
        query = "SELECT v FROM VOutdata v WHERE v.internationalDomesticFlag = :internationalDomesticFlag"),
    @NamedQuery(name = "VOutdata.findByMcoUtilFlag",
        query = "SELECT v FROM VOutdata v WHERE v.mcoUtilFlag = :mcoUtilFlag"),
    @NamedQuery(name = "VOutdata.findByServiceType",
        query = "SELECT v FROM VOutdata v WHERE v.serviceType = :serviceType"),
    @NamedQuery(name = "VOutdata.findByOriginalEtkt",
        query = "SELECT v FROM VOutdata v WHERE v.originalEtkt = :originalEtkt"),
    @NamedQuery(name = "VOutdata.findByMonthClosedDate",
        query = "SELECT v FROM VOutdata v WHERE v.monthClosedDate = :monthClosedDate")})
public class VOutdata implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_ISSUE")
  @Temporal(TemporalType.DATE)
  private Date dateIssue;
  @Size(max = 3)
  @Column(name = "PLACE_ISSUE")
  private String placeIssue;
  @Size(max = 10)
  @Column(name = "RETURN_AGENT")
  private String returnAgent;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CP")
  private short cp;
  @Size(max = 3)
  @Column(name = "DOC_CLASS")
  private String docClass;
  @Size(max = 20)
  @Column(name = "UTIL_TYPE")
  private String utilType;
  @Size(max = 2)
  @Column(name = "CARRIER_UPLIFETED")
  private String carrierUplifeted;
  @Size(max = 5)
  @Column(name = "BOOK_FLIGHT_NO")
  private String bookFlightNo;
  @Column(name = "BOOK_FLOGHT_DATE")
  @Temporal(TemporalType.DATE)
  private Date bookFloghtDate;
  @Size(max = 20)
  @Column(name = "PNR")
  private String pnr;
  @Size(max = 50)
  @Column(name = "SALES_SOURCE")
  private String salesSource;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "GROSS_FARE")
  private BigDecimal grossFare;
  @Column(name = "DISCOUNT")
  private BigDecimal discount;
  @Column(name = "COMISSION")
  private BigDecimal comission;
  @Column(name = "TOTAL_TAXES")
  private BigDecimal totalTaxes;
  @Size(max = 150)
  @Column(name = "SALES_TAX_STRING")
  private String salesTaxString;
  @Size(max = 150)
  @Column(name = "UPLIFT_TAX_STRING")
  private String upliftTaxString;
  @Size(max = 150)
  @Column(name = "AIRLINE_TAX_STRING")
  private String airlineTaxString;
  @Column(name = "CLASS")
  private Character class1;
  @Size(max = 50)
  @Column(name = "ORIGINAL_TICKETED_FARE_BASIS")
  private String originalTicketedFareBasis;
  @Size(max = 50)
  @Column(name = "FARE_BASIS_TD")
  private String fareBasisTd;
  @Size(max = 50)
  @Column(name = "CITY_PAIR")
  private String cityPair;
  @Column(name = "INTERNATIONAL_DOMESTIC_FLAG")
  private Character internationalDomesticFlag;
  @Size(max = 10)
  @Column(name = "MCO_UTIL_FLAG")
  private String mcoUtilFlag;
  @Size(max = 50)
  @Column(name = "SERVICE_TYPE")
  private String serviceType;
  @Size(max = 13)
  @Column(name = "ORIGINAL_ETKT")
  private String originalEtkt;
  @Column(name = "MONTH_CLOSED_DATE")
  @Temporal(TemporalType.DATE)
  private Date monthClosedDate;

  public VOutdata() {
  }

  public VOutdata(Date dateIssue, String placeIssue, String returnAgent, String etkt, short cp,
      String docClass, String utilType, String carrierUplifeted, String bookFlightNo,
      Date bookFloghtDate, String pnr, String salesSource, BigDecimal grossFare,
      BigDecimal discount, BigDecimal comission, BigDecimal totalTaxes, String salesTaxString,
      String upliftTaxString, String airlineTaxString, Character class1,
      String originalTicketedFareBasis, String fareBasisTd, String cityPair,
      Character internationalDomesticFlag, String mcoUtilFlag, String serviceType,
      String originalEtkt, Date monthClosedDate) {
    this.dateIssue = dateIssue;
    this.placeIssue = placeIssue;
    this.returnAgent = returnAgent;
    this.etkt = etkt;
    this.cp = cp;
    this.docClass = docClass;
    this.utilType = utilType;
    this.carrierUplifeted = carrierUplifeted;
    this.bookFlightNo = bookFlightNo;
    this.bookFloghtDate = bookFloghtDate;
    this.pnr = pnr;
    this.salesSource = salesSource;
    this.grossFare = grossFare;
    this.discount = discount;
    this.comission = comission;
    this.totalTaxes = totalTaxes;
    this.salesTaxString = salesTaxString;
    this.upliftTaxString = upliftTaxString;
    this.airlineTaxString = airlineTaxString;
    this.class1 = class1;
    this.originalTicketedFareBasis = originalTicketedFareBasis;
    this.fareBasisTd = fareBasisTd;
    this.cityPair = cityPair;
    this.internationalDomesticFlag = internationalDomesticFlag;
    this.mcoUtilFlag = mcoUtilFlag;
    this.serviceType = serviceType;
    this.originalEtkt = originalEtkt;
    this.monthClosedDate = monthClosedDate;
  }


  public Date getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(Date dateIssue) {
    this.dateIssue = dateIssue;
  }

  public String getPlaceIssue() {
    return placeIssue;
  }

  public void setPlaceIssue(String placeIssue) {
    this.placeIssue = placeIssue;
  }

  public String getReturnAgent() {
    return returnAgent;
  }

  public void setReturnAgent(String returnAgent) {
    this.returnAgent = returnAgent;
  }

  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public short getCp() {
    return cp;
  }

  public void setCp(short cp) {
    this.cp = cp;
  }

  public String getDocClass() {
    return docClass;
  }

  public void setDocClass(String docClass) {
    this.docClass = docClass;
  }

  public String getUtilType() {
    return utilType;
  }

  public void setUtilType(String utilType) {
    this.utilType = utilType;
  }

  public String getCarrierUplifeted() {
    return carrierUplifeted;
  }

  public void setCarrierUplifeted(String carrierUplifeted) {
    this.carrierUplifeted = carrierUplifeted;
  }

  public String getBookFlightNo() {
    return bookFlightNo;
  }

  public void setBookFlightNo(String bookFlightNo) {
    this.bookFlightNo = bookFlightNo;
  }

  public Date getBookFloghtDate() {
    return bookFloghtDate;
  }

  public void setBookFloghtDate(Date bookFloghtDate) {
    this.bookFloghtDate = bookFloghtDate;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public String getSalesSource() {
    return salesSource;
  }

  public void setSalesSource(String salesSource) {
    this.salesSource = salesSource;
  }

  public BigDecimal getGrossFare() {
    return grossFare;
  }

  public void setGrossFare(BigDecimal grossFare) {
    this.grossFare = grossFare;
  }

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getComission() {
    return comission;
  }

  public void setComission(BigDecimal comission) {
    this.comission = comission;
  }

  public BigDecimal getTotalTaxes() {
    return totalTaxes;
  }

  public void setTotalTaxes(BigDecimal totalTaxes) {
    this.totalTaxes = totalTaxes;
  }

  public String getSalesTaxString() {
    return salesTaxString;
  }

  public void setSalesTaxString(String salesTaxString) {
    this.salesTaxString = salesTaxString;
  }

  public String getUpliftTaxString() {
    return upliftTaxString;
  }

  public void setUpliftTaxString(String upliftTaxString) {
    this.upliftTaxString = upliftTaxString;
  }

  public String getAirlineTaxString() {
    return airlineTaxString;
  }

  public void setAirlineTaxString(String airlineTaxString) {
    this.airlineTaxString = airlineTaxString;
  }

  public Character getClass1() {
    return class1;
  }

  public void setClass1(Character class1) {
    this.class1 = class1;
  }

  public String getOriginalTicketedFareBasis() {
    return originalTicketedFareBasis;
  }

  public void setOriginalTicketedFareBasis(String originalTicketedFareBasis) {
    this.originalTicketedFareBasis = originalTicketedFareBasis;
  }

  public String getFareBasisTd() {
    return fareBasisTd;
  }

  public void setFareBasisTd(String fareBasisTd) {
    this.fareBasisTd = fareBasisTd;
  }

  public String getCityPair() {
    return cityPair;
  }

  public void setCityPair(String cityPair) {
    this.cityPair = cityPair;
  }

  public Character getInternationalDomesticFlag() {
    return internationalDomesticFlag;
  }

  public void setInternationalDomesticFlag(Character internationalDomesticFlag) {
    this.internationalDomesticFlag = internationalDomesticFlag;
  }

  public String getMcoUtilFlag() {
    return mcoUtilFlag;
  }

  public void setMcoUtilFlag(String mcoUtilFlag) {
    this.mcoUtilFlag = mcoUtilFlag;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getOriginalEtkt() {
    return originalEtkt;
  }

  public void setOriginalEtkt(String originalEtkt) {
    this.originalEtkt = originalEtkt;
  }

  public Date getMonthClosedDate() {
    return monthClosedDate;
  }

  public void setMonthClosedDate(Date monthClosedDate) {
    this.monthClosedDate = monthClosedDate;
  }

}
