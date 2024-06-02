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
@Table(schema = "dbo", name = "V_ARC_CP_HIS")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VArcCpHis.findAll", query = "SELECT v FROM VArcCpHis v"),
    @NamedQuery(name = "VArcCpHis.findByEtkt",
        query = "SELECT v FROM VArcCpHis v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VArcCpHis.findByTktOrder",
        query = "SELECT v FROM VArcCpHis v WHERE v.tktOrder = :tktOrder"),
    @NamedQuery(name = "VArcCpHis.findByCpOrder",
        query = "SELECT v FROM VArcCpHis v WHERE v.cpOrder = :cpOrder"),
    @NamedQuery(name = "VArcCpHis.findByCpStat",
        query = "SELECT v FROM VArcCpHis v WHERE v.cpStat = :cpStat"),
    @NamedQuery(name = "VArcCpHis.findByUpdDate",
        query = "SELECT v FROM VArcCpHis v WHERE v.updDate = :updDate"),
    @NamedQuery(name = "VArcCpHis.findByUpdTime",
        query = "SELECT v FROM VArcCpHis v WHERE v.updTime = :updTime"),
    @NamedQuery(name = "VArcCpHis.findByCpUpdTrnc",
        query = "SELECT v FROM VArcCpHis v WHERE v.cpUpdTrnc = :cpUpdTrnc"),
    @NamedQuery(name = "VArcCpHis.findByAgentCity",
        query = "SELECT v FROM VArcCpHis v WHERE v.agentCity = :agentCity"),
    @NamedQuery(name = "VArcCpHis.findByAgentThl",
        query = "SELECT v FROM VArcCpHis v WHERE v.agentThl = :agentThl"),
    @NamedQuery(name = "VArcCpHis.findByAgentAmid",
        query = "SELECT v FROM VArcCpHis v WHERE v.agentAmid = :agentAmid"),
    @NamedQuery(name = "VArcCpHis.findByAgentIata",
        query = "SELECT v FROM VArcCpHis v WHERE v.agentIata = :agentIata"),
    @NamedQuery(name = "VArcCpHis.findByAgebtTpt",
        query = "SELECT v FROM VArcCpHis v WHERE v.agebtTpt = :agebtTpt"),
    @NamedQuery(name = "VArcCpHis.findByCpCtrl",
        query = "SELECT v FROM VArcCpHis v WHERE v.cpCtrl = :cpCtrl"),
    @NamedQuery(name = "VArcCpHis.findByExcTkt",
        query = "SELECT v FROM VArcCpHis v WHERE v.excTkt = :excTkt"),
    @NamedQuery(name = "VArcCpHis.findByUsgOrg",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgOrg = :usgOrg"),
    @NamedQuery(name = "VArcCpHis.findByUsgCarr",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgCarr = :usgCarr"),
    @NamedQuery(name = "VArcCpHis.findByUsgDep",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgDep = :usgDep"),
    @NamedQuery(name = "VArcCpHis.findByUsgDst",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgDst = :usgDst"),
    @NamedQuery(name = "VArcCpHis.findByUsgFlt",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgFlt = :usgFlt"),
    @NamedQuery(name = "VArcCpHis.findByUsgClas",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgClas = :usgClas"),
    @NamedQuery(name = "VArcCpHis.findByUsgInvind",
        query = "SELECT v FROM VArcCpHis v WHERE v.usgInvind = :usgInvind"),
    @NamedQuery(name = "VArcCpHis.findBySacCode",
        query = "SELECT v FROM VArcCpHis v WHERE v.sacCode = :sacCode"),
    @NamedQuery(name = "VArcCpHis.findByOldMkCarr",
        query = "SELECT v FROM VArcCpHis v WHERE v.oldMkCarr = :oldMkCarr"),
    @NamedQuery(name = "VArcCpHis.findByOldMkDepTime",
        query = "SELECT v FROM VArcCpHis v WHERE v.oldMkDepTime = :oldMkDepTime"),
    @NamedQuery(name = "VArcCpHis.findByOldMkDep",
        query = "SELECT v FROM VArcCpHis v WHERE v.oldMkDep = :oldMkDep"),
    @NamedQuery(name = "VArcCpHis.findByOldMkFlt",
        query = "SELECT v FROM VArcCpHis v WHERE v.oldMkFlt = :oldMkFlt"),
    @NamedQuery(name = "VArcCpHis.findByOldMkClas",
        query = "SELECT v FROM VArcCpHis v WHERE v.oldMkClas = :oldMkClas"),
    @NamedQuery(name = "VArcCpHis.findByNewMkCarr",
        query = "SELECT v FROM VArcCpHis v WHERE v.newMkCarr = :newMkCarr"),
    @NamedQuery(name = "VArcCpHis.findByNewMkDepTime",
        query = "SELECT v FROM VArcCpHis v WHERE v.newMkDepTime = :newMkDepTime"),
    @NamedQuery(name = "VArcCpHis.findByNewMkDep",
        query = "SELECT v FROM VArcCpHis v WHERE v.newMkDep = :newMkDep"),
    @NamedQuery(name = "VArcCpHis.findByNewMkFlt",
        query = "SELECT v FROM VArcCpHis v WHERE v.newMkFlt = :newMkFlt"),
    @NamedQuery(name = "VArcCpHis.findByNewMkClas",
        query = "SELECT v FROM VArcCpHis v WHERE v.newMkClas = :newMkClas"),
    @NamedQuery(name = "VArcCpHis.findByUpdRmks",
        query = "SELECT v FROM VArcCpHis v WHERE v.updRmks = :updRmks")})
public class VArcCpHis implements Serializable {

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
  @Size(min = 1, max = 3)
  @Column(name = "CP_STAT")
  private String cpStat;
  @Basic(optional = false)
  @NotNull
  @Column(name = "UPD_DATE")
  @Temporal(TemporalType.DATE)
  private Date updDate;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "UPD_TIME")
  private String updTime;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "CP_UPD_TRNC")
  private String cpUpdTrnc;
  @Size(max = 3)
  @Column(name = "AGENT_CITY")
  private String agentCity;
  @Size(max = 9)
  @Column(name = "AGENT_THL")
  private String agentThl;
  @Size(max = 11)
  @Column(name = "AGENT_AMID")
  private String agentAmid;
  @Size(max = 8)
  @Column(name = "AGENT_IATA")
  private String agentIata;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "AGEBT_TPT")
  private String agebtTpt;
  @Size(max = 20)
  @Column(name = "CP_CTRL")
  private String cpCtrl;
  @Size(max = 15)
  @Column(name = "EXC_TKT")
  private String excTkt;
  @Size(max = 3)
  @Column(name = "USG_ORG")
  private String usgOrg;
  @Size(max = 4)
  @Column(name = "USG_CARR")
  private String usgCarr;
  @Column(name = "USG_DEP")
  @Temporal(TemporalType.DATE)
  private Date usgDep;
  @Size(max = 3)
  @Column(name = "USG_DST")
  private String usgDst;
  @Size(max = 5)
  @Column(name = "USG_FLT")
  private String usgFlt;
  @Size(max = 1)
  @Column(name = "USG_CLAS")
  private String usgClas;
  @Size(max = 3)
  @Column(name = "USG_INVIND")
  private String usgInvind;
  @Size(max = 14)
  @Column(name = "SAC_CODE")
  private String sacCode;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "OLD_MK_CARR")
  private String oldMkCarr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "OLD_MK_DEP_TIME")
  private String oldMkDepTime;
  @Column(name = "OLD_MK_DEP")
  @Temporal(TemporalType.DATE)
  private Date oldMkDep;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "OLD_MK_FLT")
  private String oldMkFlt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "OLD_MK_CLAS")
  private Character oldMkClas;
  @Size(max = 3)
  @Column(name = "NEW_MK_CARR")
  private String newMkCarr;
  @Size(max = 8)
  @Column(name = "NEW_MK_DEP_TIME")
  private String newMkDepTime;
  @Column(name = "NEW_MK_DEP")
  @Temporal(TemporalType.DATE)
  private Date newMkDep;
  @Size(max = 5)
  @Column(name = "NEW_MK_FLT")
  private String newMkFlt;
  @Column(name = "NEW_MK_CLAS")
  private Character newMkClas;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 63)
  @Column(name = "UPD_RMKS")
  private String updRmks;

  public VArcCpHis() {
  }

  public VArcCpHis(String etkt, short tktOrder, short cpOrder, String cpStat, Date updDate,
      String updTime, String cpUpdTrnc, String agentCity, String agentThl, String agentAmid,
      String agentIata, String agebtTpt, String cpCtrl, String excTkt, String usgOrg,
      String usgCarr, Date usgDep, String usgDst, String usgFlt, String usgClas, String usgInvind,
      String sacCode, String oldMkCarr, String oldMkDepTime, Date oldMkDep, String oldMkFlt,
      Character oldMkClas, String newMkCarr, String newMkDepTime, Date newMkDep, String newMkFlt,
      Character newMkClas, String updRmks) {
    this.etkt = etkt;
    this.tktOrder = tktOrder;
    this.cpOrder = cpOrder;
    this.cpStat = cpStat;
    this.updDate = updDate;
    this.updTime = updTime;
    this.cpUpdTrnc = cpUpdTrnc;
    this.agentCity = agentCity;
    this.agentThl = agentThl;
    this.agentAmid = agentAmid;
    this.agentIata = agentIata;
    this.agebtTpt = agebtTpt;
    this.cpCtrl = cpCtrl;
    this.excTkt = excTkt;
    this.usgOrg = usgOrg;
    this.usgCarr = usgCarr;
    this.usgDep = usgDep;
    this.usgDst = usgDst;
    this.usgFlt = usgFlt;
    this.usgClas = usgClas;
    this.usgInvind = usgInvind;
    this.sacCode = sacCode;
    this.oldMkCarr = oldMkCarr;
    this.oldMkDepTime = oldMkDepTime;
    this.oldMkDep = oldMkDep;
    this.oldMkFlt = oldMkFlt;
    this.oldMkClas = oldMkClas;
    this.newMkCarr = newMkCarr;
    this.newMkDepTime = newMkDepTime;
    this.newMkDep = newMkDep;
    this.newMkFlt = newMkFlt;
    this.newMkClas = newMkClas;
    this.updRmks = updRmks;
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

  public String getCpStat() {
    return cpStat;
  }

  public void setCpStat(String cpStat) {
    this.cpStat = cpStat;
  }

  public Date getUpdDate() {
    return updDate;
  }

  public void setUpdDate(Date updDate) {
    this.updDate = updDate;
  }

  public String getUpdTime() {
    return updTime;
  }

  public void setUpdTime(String updTime) {
    this.updTime = updTime;
  }

  public String getCpUpdTrnc() {
    return cpUpdTrnc;
  }

  public void setCpUpdTrnc(String cpUpdTrnc) {
    this.cpUpdTrnc = cpUpdTrnc;
  }

  public String getAgentCity() {
    return agentCity;
  }

  public void setAgentCity(String agentCity) {
    this.agentCity = agentCity;
  }

  public String getAgentThl() {
    return agentThl;
  }

  public void setAgentThl(String agentThl) {
    this.agentThl = agentThl;
  }

  public String getAgentAmid() {
    return agentAmid;
  }

  public void setAgentAmid(String agentAmid) {
    this.agentAmid = agentAmid;
  }

  public String getAgentIata() {
    return agentIata;
  }

  public void setAgentIata(String agentIata) {
    this.agentIata = agentIata;
  }

  public String getAgebtTpt() {
    return agebtTpt;
  }

  public void setAgebtTpt(String agebtTpt) {
    this.agebtTpt = agebtTpt;
  }

  public String getCpCtrl() {
    return cpCtrl;
  }

  public void setCpCtrl(String cpCtrl) {
    this.cpCtrl = cpCtrl;
  }

  public String getExcTkt() {
    return excTkt;
  }

  public void setExcTkt(String excTkt) {
    this.excTkt = excTkt;
  }

  public String getUsgOrg() {
    return usgOrg;
  }

  public void setUsgOrg(String usgOrg) {
    this.usgOrg = usgOrg;
  }

  public String getUsgCarr() {
    return usgCarr;
  }

  public void setUsgCarr(String usgCarr) {
    this.usgCarr = usgCarr;
  }

  public Date getUsgDep() {
    return usgDep;
  }

  public void setUsgDep(Date usgDep) {
    this.usgDep = usgDep;
  }

  public String getUsgDst() {
    return usgDst;
  }

  public void setUsgDst(String usgDst) {
    this.usgDst = usgDst;
  }

  public String getUsgFlt() {
    return usgFlt;
  }

  public void setUsgFlt(String usgFlt) {
    this.usgFlt = usgFlt;
  }

  public String getUsgClas() {
    return usgClas;
  }

  public void setUsgClas(String usgClas) {
    this.usgClas = usgClas;
  }

  public String getUsgInvind() {
    return usgInvind;
  }

  public void setUsgInvind(String usgInvind) {
    this.usgInvind = usgInvind;
  }

  public String getSacCode() {
    return sacCode;
  }

  public void setSacCode(String sacCode) {
    this.sacCode = sacCode;
  }

  public String getOldMkCarr() {
    return oldMkCarr;
  }

  public void setOldMkCarr(String oldMkCarr) {
    this.oldMkCarr = oldMkCarr;
  }

  public String getOldMkDepTime() {
    return oldMkDepTime;
  }

  public void setOldMkDepTime(String oldMkDepTime) {
    this.oldMkDepTime = oldMkDepTime;
  }

  public Date getOldMkDep() {
    return oldMkDep;
  }

  public void setOldMkDep(Date oldMkDep) {
    this.oldMkDep = oldMkDep;
  }

  public String getOldMkFlt() {
    return oldMkFlt;
  }

  public void setOldMkFlt(String oldMkFlt) {
    this.oldMkFlt = oldMkFlt;
  }

  public Character getOldMkClas() {
    return oldMkClas;
  }

  public void setOldMkClas(Character oldMkClas) {
    this.oldMkClas = oldMkClas;
  }

  public String getNewMkCarr() {
    return newMkCarr;
  }

  public void setNewMkCarr(String newMkCarr) {
    this.newMkCarr = newMkCarr;
  }

  public String getNewMkDepTime() {
    return newMkDepTime;
  }

  public void setNewMkDepTime(String newMkDepTime) {
    this.newMkDepTime = newMkDepTime;
  }

  public Date getNewMkDep() {
    return newMkDep;
  }

  public void setNewMkDep(Date newMkDep) {
    this.newMkDep = newMkDep;
  }

  public String getNewMkFlt() {
    return newMkFlt;
  }

  public void setNewMkFlt(String newMkFlt) {
    this.newMkFlt = newMkFlt;
  }

  public Character getNewMkClas() {
    return newMkClas;
  }

  public void setNewMkClas(Character newMkClas) {
    this.newMkClas = newMkClas;
  }

  public String getUpdRmks() {
    return updRmks;
  }

  public void setUpdRmks(String updRmks) {
    this.updRmks = updRmks;
  }

}
