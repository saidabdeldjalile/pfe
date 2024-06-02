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
@Table(schema = "dbo", name = "V_ARC_FOP")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VArcFop.findAll", query = "SELECT v FROM VArcFop v"),
    @NamedQuery(name = "VArcFop.findByEtkt",
        query = "SELECT v FROM VArcFop v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VArcFop.findByFopType",
        query = "SELECT v FROM VArcFop v WHERE v.fopType = :fopType"),
    @NamedQuery(name = "VArcFop.findByFopAmt",
        query = "SELECT v FROM VArcFop v WHERE v.fopAmt = :fopAmt"),
    @NamedQuery(name = "VArcFop.findByCcVendor",
        query = "SELECT v FROM VArcFop v WHERE v.ccVendor = :ccVendor"),
    @NamedQuery(name = "VArcFop.findByCcNum",
        query = "SELECT v FROM VArcFop v WHERE v.ccNum = :ccNum"),
    @NamedQuery(name = "VArcFop.findByCcExpdat",
        query = "SELECT v FROM VArcFop v WHERE v.ccExpdat = :ccExpdat"),
    @NamedQuery(name = "VArcFop.findByCcAuth",
        query = "SELECT v FROM VArcFop v WHERE v.ccAuth = :ccAuth"),
    @NamedQuery(name = "VArcFop.findByCcAprsc",
        query = "SELECT v FROM VArcFop v WHERE v.ccAprsc = :ccAprsc"),
    @NamedQuery(name = "VArcFop.findByAuthAmt",
        query = "SELECT v FROM VArcFop v WHERE v.authAmt = :authAmt"),
    @NamedQuery(name = "VArcFop.findByAdrVerif",
        query = "SELECT v FROM VArcFop v WHERE v.adrVerif = :adrVerif"),
    @NamedQuery(name = "VArcFop.findByCcExtpay",
        query = "SELECT v FROM VArcFop v WHERE v.ccExtpay = :ccExtpay"),
    @NamedQuery(name = "VArcFop.findByCcCorp",
        query = "SELECT v FROM VArcFop v WHERE v.ccCorp = :ccCorp"),
    @NamedQuery(name = "VArcFop.findByFopFree",
        query = "SELECT v FROM VArcFop v WHERE v.fopFree = :fopFree"),
    @NamedQuery(name = "VArcFop.findByFopInd",
        query = "SELECT v FROM VArcFop v WHERE v.fopInd = :fopInd")})
public class VArcFop implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "FOP_TYPE")
  private String fopType;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "FOP_AMT")
  private BigDecimal fopAmt;
  @Size(max = 3)
  @Column(name = "CC_VENDOR")
  private String ccVendor;
  @Size(max = 35)
  @Column(name = "CC_NUM")
  private String ccNum;
  @Size(max = 7)
  @Column(name = "CC_EXPDAT")
  private String ccExpdat;
  @Size(max = 17)
  @Column(name = "CC_AUTH")
  private String ccAuth;
  @Size(max = 3)
  @Column(name = "CC_APRSC")
  private String ccAprsc;
  @Size(max = 16)
  @Column(name = "AUTH_AMT")
  private String authAmt;
  @Size(max = 3)
  @Column(name = "ADR_VERIF")
  private String adrVerif;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CC_EXTPAY")
  private String ccExtpay;
  @Size(max = 3)
  @Column(name = "CC_CORP")
  private String ccCorp;
  @Size(max = 60)
  @Column(name = "FOP_FREE")
  private String fopFree;
  @Size(max = 8)
  @Column(name = "FOP_IND")
  private String fopInd;

  public VArcFop() {
  }

  public VArcFop(String etkt, String fopType, BigDecimal fopAmt, String ccVendor, String ccNum,
      String ccExpdat, String ccAuth, String ccAprsc, String authAmt, String adrVerif,
      String ccExtpay, String ccCorp, String fopFree, String fopInd) {
    this.etkt = etkt;
    this.fopType = fopType;
    this.fopAmt = fopAmt;
    this.ccVendor = ccVendor;
    this.ccNum = ccNum;
    this.ccExpdat = ccExpdat;
    this.ccAuth = ccAuth;
    this.ccAprsc = ccAprsc;
    this.authAmt = authAmt;
    this.adrVerif = adrVerif;
    this.ccExtpay = ccExtpay;
    this.ccCorp = ccCorp;
    this.fopFree = fopFree;
    this.fopInd = fopInd;
  }



  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public String getFopType() {
    return fopType;
  }

  public void setFopType(String fopType) {
    this.fopType = fopType;
  }

  public BigDecimal getFopAmt() {
    return fopAmt;
  }

  public void setFopAmt(BigDecimal fopAmt) {
    this.fopAmt = fopAmt;
  }

  public String getCcVendor() {
    return ccVendor;
  }

  public void setCcVendor(String ccVendor) {
    this.ccVendor = ccVendor;
  }

  public String getCcNum() {
    return ccNum;
  }

  public void setCcNum(String ccNum) {
    this.ccNum = ccNum;
  }

  public String getCcExpdat() {
    return ccExpdat;
  }

  public void setCcExpdat(String ccExpdat) {
    this.ccExpdat = ccExpdat;
  }

  public String getCcAuth() {
    return ccAuth;
  }

  public void setCcAuth(String ccAuth) {
    this.ccAuth = ccAuth;
  }

  public String getCcAprsc() {
    return ccAprsc;
  }

  public void setCcAprsc(String ccAprsc) {
    this.ccAprsc = ccAprsc;
  }

  public String getAuthAmt() {
    return authAmt;
  }

  public void setAuthAmt(String authAmt) {
    this.authAmt = authAmt;
  }

  public String getAdrVerif() {
    return adrVerif;
  }

  public void setAdrVerif(String adrVerif) {
    this.adrVerif = adrVerif;
  }

  public String getCcExtpay() {
    return ccExtpay;
  }

  public void setCcExtpay(String ccExtpay) {
    this.ccExtpay = ccExtpay;
  }

  public String getCcCorp() {
    return ccCorp;
  }

  public void setCcCorp(String ccCorp) {
    this.ccCorp = ccCorp;
  }

  public String getFopFree() {
    return fopFree;
  }

  public void setFopFree(String fopFree) {
    this.fopFree = fopFree;
  }

  public String getFopInd() {
    return fopInd;
  }

  public void setFopInd(String fopInd) {
    this.fopInd = fopInd;
  }

}
