/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
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
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_EX_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdExComp.findAll", query = "SELECT v FROM VArcEmdExComp v")})
public class VArcEmdExComp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Id
  @Column(name = "EMD_NBR")
  private String emdNbr;
  @Basic(optional = false)
  @Column(name = "EXC_TKT_1")
  private String excTkt1;
  @Column(name = "EXC_CPN_1")
  private String excCpn1;
  @Column(name = "EXC_TKT_2")
  private String excTkt2;
  @Column(name = "EXC_CPN_2")
  private String excCpn2;
  @Column(name = "ORG_FOP")
  private String orgFop;
  @Column(name = "EXC_INFO")
  private String excInfo;

  public VArcEmdExComp() {
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
  }

  public String getExcTkt1() {
    return excTkt1;
  }

  public void setExcTkt1(String excTkt1) {
    this.excTkt1 = excTkt1;
  }

  public String getExcCpn1() {
    return excCpn1;
  }

  public void setExcCpn1(String excCpn1) {
    this.excCpn1 = excCpn1;
  }

  public String getExcTkt2() {
    return excTkt2;
  }

  public void setExcTkt2(String excTkt2) {
    this.excTkt2 = excTkt2;
  }

  public String getExcCpn2() {
    return excCpn2;
  }

  public void setExcCpn2(String excCpn2) {
    this.excCpn2 = excCpn2;
  }

  public String getOrgFop() {
    return orgFop;
  }

  public void setOrgFop(String orgFop) {
    this.orgFop = orgFop;
  }

  public String getExcInfo() {
    return excInfo;
  }

  public void setExcInfo(String excInfo) {
    this.excInfo = excInfo;
  }

}
