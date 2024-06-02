/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.view.tkt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(schema = "dbo", name = "V_ARC_CP_AMD_COMP")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VArcCpAmdComp.findAll", query = "SELECT v FROM VArcCpAmdComp v"),
    @NamedQuery(name = "VArcCpAmdComp.findByEtkt",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VArcCpAmdComp.findByTktOrder",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.tktOrder = :tktOrder"),
    @NamedQuery(name = "VArcCpAmdComp.findByCpOrder",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.cpOrder = :cpOrder"),
    @NamedQuery(name = "VArcCpAmdComp.findByCp",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.cp = :cp"),
    @NamedQuery(name = "VArcCpAmdComp.findByCpStat",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.cpStat = :cpStat"),
    @NamedQuery(name = "VArcCpAmdComp.findByStatChangDate",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.statChangDate = :statChangDate"),
    @NamedQuery(name = "VArcCpAmdComp.findByExcTkt",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.excTkt = :excTkt"),
    @NamedQuery(name = "VArcCpAmdComp.findByMktCarr",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.mktCarr = :mktCarr"),
    @NamedQuery(name = "VArcCpAmdComp.findByOptCarr",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.optCarr = :optCarr"),
    @NamedQuery(name = "VArcCpAmdComp.findByFltNum",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.fltNum = :fltNum"),
    @NamedQuery(name = "VArcCpAmdComp.findByOrgArpt",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.orgArpt = :orgArpt"),
    @NamedQuery(name = "VArcCpAmdComp.findByDstArpt",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.dstArpt = :dstArpt"),
    @NamedQuery(name = "VArcCpAmdComp.findByDepDate",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.depDate = :depDate"),
    @NamedQuery(name = "VArcCpAmdComp.findByDepTime",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.depTime = :depTime"),
    @NamedQuery(name = "VArcCpAmdComp.findByMktClas",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.mktClas = :mktClas"),
    @NamedQuery(name = "VArcCpAmdComp.findByFbc",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.fbc = :fbc"),
    @NamedQuery(name = "VArcCpAmdComp.findByCpStpo",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.cpStpo = :cpStpo"),
    @NamedQuery(name = "VArcCpAmdComp.findBySegStat",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.segStat = :segStat"),
    @NamedQuery(name = "VArcCpAmdComp.findBySacCode",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.sacCode = :sacCode"),
    @NamedQuery(name = "VArcCpAmdComp.findByNvb",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.nvb = :nvb"),
    @NamedQuery(name = "VArcCpAmdComp.findByNva",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.nva = :nva"),
    @NamedQuery(name = "VArcCpAmdComp.findByFqtvCarr",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.fqtvCarr = :fqtvCarr"),
    @NamedQuery(name = "VArcCpAmdComp.findByFqtvNum",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.fqtvNum = :fqtvNum"),
    @NamedQuery(name = "VArcCpAmdComp.findByDateInsertLift",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.dateInsertLift = :dateInsertLift"),
    @NamedQuery(name = "VArcCpAmdComp.findByInvind",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.invind = :invind"),
    @NamedQuery(name = "VArcCpAmdComp.findByBagRest",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.bagRest = :bagRest"),
    @NamedQuery(name = "VArcCpAmdComp.findByBagUnit",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.bagUnit = :bagUnit"),
    @NamedQuery(name = "VArcCpAmdComp.findByStaffInd",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.staffInd = :staffInd"),
    @NamedQuery(name = "VArcCpAmdComp.findByObsCnl",
        query = "SELECT v FROM VArcCpAmdComp v WHERE v.obsCnl = :obsCnl")})
public class VArcCpAmdComp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TKT_ORDER")
  private short tktOrder;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CP_ORDER")
  private short cpOrder;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CP")
  private short cp;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CP_STAT")
  private String cpStat;
  @Column(name = "STAT_CHANG_DATE")
  @Temporal(TemporalType.DATE)
  private Date statChangDate;
  @Size(max = 13)
  @Column(name = "EXC_TKT")
  private String excTkt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "MKT_CARR")
  private String mktCarr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "OPT_CARR")
  private String optCarr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "FLT_NUM")
  private String fltNum;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "ORG_ARPT")
  private String orgArpt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "DST_ARPT")
  private String dstArpt;
  @Column(name = "DEP_DATE")
  @Temporal(TemporalType.DATE)
  private Date depDate;
  @Size(max = 8)
  @Column(name = "DEP_TIME")
  private String depTime;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MKT_CLAS")
  private Character mktClas;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "FBC")
  private String fbc;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CP_STPO")
  private String cpStpo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "SEG_STAT")
  private String segStat;
  @Size(max = 14)
  @Column(name = "SAC_CODE")
  private String sacCode;
  @Column(name = "NVB")
  @Temporal(TemporalType.DATE)
  private Date nvb;
  @Column(name = "NVA")
  @Temporal(TemporalType.DATE)
  private Date nva;
  @Size(max = 4)
  @Column(name = "FQTV_CARR")
  private String fqtvCarr;
  @Size(max = 25)
  @Column(name = "FQTV_NUM")
  private String fqtvNum;
  @Column(name = "DATE_INSERT_LIFT")
  @Temporal(TemporalType.DATE)
  private Date dateInsertLift;
  @Size(max = 3)
  @Column(name = "INVIND")
  private String invind;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "BAG_REST")
  private String bagRest;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "BAG_UNIT")
  private String bagUnit;
  @Size(max = 3)
  @Column(name = "STAFF_IND")
  private String staffInd;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "OBS_CNL")
  private String obsCnl;

  public VArcCpAmdComp() {
  }

  public VArcCpAmdComp(String etkt, short tktOrder, short cpOrder, short cp, String cpStat,
      Date statChangDate, String excTkt, String mktCarr, String optCarr, String fltNum,
      String orgArpt, String dstArpt, Date depDate, String depTime, Character mktClas, String fbc,
      String cpStpo, String segStat, String sacCode, Date nvb, Date nva, String fqtvCarr,
      String fqtvNum, Date dateInsertLift, String invind, String bagRest, String bagUnit,
      String staffInd, String obsCnl) {
    this.etkt = etkt;
    this.tktOrder = tktOrder;
    this.cpOrder = cpOrder;
    this.cp = cp;
    this.cpStat = cpStat;
    this.statChangDate = statChangDate;
    this.excTkt = excTkt;
    this.mktCarr = mktCarr;
    this.optCarr = optCarr;
    this.fltNum = fltNum;
    this.orgArpt = orgArpt;
    this.dstArpt = dstArpt;
    this.depDate = depDate;
    this.depTime = depTime;
    this.mktClas = mktClas;
    this.fbc = fbc;
    this.cpStpo = cpStpo;
    this.segStat = segStat;
    this.sacCode = sacCode;
    this.nvb = nvb;
    this.nva = nva;
    this.fqtvCarr = fqtvCarr;
    this.fqtvNum = fqtvNum;
    this.dateInsertLift = dateInsertLift;
    this.invind = invind;
    this.bagRest = bagRest;
    this.bagUnit = bagUnit;
    this.staffInd = staffInd;
    this.obsCnl = obsCnl;
  }



  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public short getTktOrder() {
    return tktOrder;
  }

  public void setTktOrder(short tktOrder) {
    this.tktOrder = tktOrder;
  }

  public short getCpOrder() {
    return cpOrder;
  }

  public void setCpOrder(short cpOrder) {
    this.cpOrder = cpOrder;
  }

  public short getCp() {
    return cp;
  }

  public void setCp(short cp) {
    this.cp = cp;
  }

  public String getCpStat() {
    return cpStat;
  }

  public void setCpStat(String cpStat) {
    this.cpStat = cpStat;
  }

  public Date getStatChangDate() {
    return statChangDate;
  }

  public void setStatChangDate(Date statChangDate) {
    this.statChangDate = statChangDate;
  }

  public String getExcTkt() {
    return excTkt;
  }

  public void setExcTkt(String excTkt) {
    this.excTkt = excTkt;
  }

  public String getMktCarr() {
    return mktCarr;
  }

  public void setMktCarr(String mktCarr) {
    this.mktCarr = mktCarr;
  }

  public String getOptCarr() {
    return optCarr;
  }

  public void setOptCarr(String optCarr) {
    this.optCarr = optCarr;
  }

  public String getFltNum() {
    return fltNum;
  }

  public void setFltNum(String fltNum) {
    this.fltNum = fltNum;
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

  public Date getDepDate() {
    return depDate;
  }

  public void setDepDate(Date depDate) {
    this.depDate = depDate;
  }

  public String getDepTime() {
    return depTime;
  }

  public void setDepTime(String depTime) {
    this.depTime = depTime;
  }

  public Character getMktClas() {
    return mktClas;
  }

  public void setMktClas(Character mktClas) {
    this.mktClas = mktClas;
  }

  public String getFbc() {
    return fbc;
  }

  public void setFbc(String fbc) {
    this.fbc = fbc;
  }

  public String getCpStpo() {
    return cpStpo;
  }

  public void setCpStpo(String cpStpo) {
    this.cpStpo = cpStpo;
  }

  public String getSegStat() {
    return segStat;
  }

  public void setSegStat(String segStat) {
    this.segStat = segStat;
  }

  public String getSacCode() {
    return sacCode;
  }

  public void setSacCode(String sacCode) {
    this.sacCode = sacCode;
  }

  public Date getNvb() {
    return nvb;
  }

  public void setNvb(Date nvb) {
    this.nvb = nvb;
  }

  public Date getNva() {
    return nva;
  }

  public void setNva(Date nva) {
    this.nva = nva;
  }

  public String getFqtvCarr() {
    return fqtvCarr;
  }

  public void setFqtvCarr(String fqtvCarr) {
    this.fqtvCarr = fqtvCarr;
  }

  public String getFqtvNum() {
    return fqtvNum;
  }

  public void setFqtvNum(String fqtvNum) {
    this.fqtvNum = fqtvNum;
  }

  public Date getDateInsertLift() {
    return dateInsertLift;
  }

  public void setDateInsertLift(Date dateInsertLift) {
    this.dateInsertLift = dateInsertLift;
  }

  public String getInvind() {
    return invind;
  }

  public void setInvind(String invind) {
    this.invind = invind;
  }

  public String getBagRest() {
    return bagRest;
  }

  public void setBagRest(String bagRest) {
    this.bagRest = bagRest;
  }

  public String getBagUnit() {
    return bagUnit;
  }

  public void setBagUnit(String bagUnit) {
    this.bagUnit = bagUnit;
  }

  public String getStaffInd() {
    return staffInd;
  }

  public void setStaffInd(String staffInd) {
    this.staffInd = staffInd;
  }

  public String getObsCnl() {
    return obsCnl;
  }

  public void setObsCnl(String obsCnl) {
    this.obsCnl = obsCnl;
  }

}
