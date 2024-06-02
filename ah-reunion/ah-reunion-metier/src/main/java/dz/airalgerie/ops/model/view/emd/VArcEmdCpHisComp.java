/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_CP_HIS_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdCpHisComp.findAll", query = "SELECT v FROM VArcEmdCpHisComp v")})
public class VArcEmdCpHisComp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "EMD_NBR")
  @Id
  private String emdNbr;
  @Column(name = "EMD_ORDR")
  private String emdOrdr;
  @Column(name = "CP")
  private String cp;
  @Column(name = "CP_STAT")
  private String cpStat;
  @Column(name = "UPD_DATE")
  private LocalDate updDate;
  @Column(name = "UPD_TIME")
  private String updTime;
  @Column(name = "CPN_UPD_TRNC")
  private String cpnUpdTrnc;
  @Column(name = "AGNT_CITY")
  private String agntCity;
  @Column(name = "AGNT_THL")
  private String agntThl;
  @Column(name = "AGNT_AMID")
  private String agntAmid;
  @Column(name = "AGNT_IATA")
  private String agntIata;
  @Column(name = "AGNT_TPT")
  private String agntTpt;
  @Column(name = "CTRL_BY")
  private String ctrlBy;
  @Column(name = "EXC_EMDNUM")
  private String excEmdnum;
  @Column(name = "SAC_CODE")
  private String sacCode;
  @Column(name = "ICW_TKT")
  private String icwTkt;
  @Column(name = "ICW_CPN")
  private String icwCpn;
  @Column(name = "UPD_RMKS")
  private String updRmks;

  public VArcEmdCpHisComp() {
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
  }

  public String getEmdOrdr() {
    return emdOrdr;
  }

  public void setEmdOrdr(String emdOrdr) {
    this.emdOrdr = emdOrdr;
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

  public LocalDate getUpdDate() {
    return updDate;
  }

  public void setUpdDate(LocalDate updDate) {
    this.updDate = updDate;
  }

  public String getUpdTime() {
    return updTime;
  }

  public void setUpdTime(String updTime) {
    this.updTime = updTime;
  }

  public String getCpnUpdTrnc() {
    return cpnUpdTrnc;
  }

  public void setCpnUpdTrnc(String cpnUpdTrnc) {
    this.cpnUpdTrnc = cpnUpdTrnc;
  }

  public String getAgntCity() {
    return agntCity;
  }

  public void setAgntCity(String agntCity) {
    this.agntCity = agntCity;
  }

  public String getAgntThl() {
    return agntThl;
  }

  public void setAgntThl(String agntThl) {
    this.agntThl = agntThl;
  }

  public String getAgntAmid() {
    return agntAmid;
  }

  public void setAgntAmid(String agntAmid) {
    this.agntAmid = agntAmid;
  }

  public String getAgntIata() {
    return agntIata;
  }

  public void setAgntIata(String agntIata) {
    this.agntIata = agntIata;
  }

  public String getAgntTpt() {
    return agntTpt;
  }

  public void setAgntTpt(String agntTpt) {
    this.agntTpt = agntTpt;
  }

  public String getCtrlBy() {
    return ctrlBy;
  }

  public void setCtrlBy(String ctrlBy) {
    this.ctrlBy = ctrlBy;
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

  public String getUpdRmks() {
    return updRmks;
  }

  public void setUpdRmks(String updRmks) {
    this.updRmks = updRmks;
  }

}
