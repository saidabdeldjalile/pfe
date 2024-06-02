/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.view.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "V_ARC_EMD_FOP_COMP")
@NamedQueries({
    @NamedQuery(name = "VArcEmdFopComp.findAll", query = "SELECT v FROM VArcEmdFopComp v")})
public class VArcEmdFopComp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Id
  @Column(name = "EMD_NBR")
  private String emdNbr;
  @Column(name = "FOP_TYPE")
  private String fopType;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "FOP_AMNT")
  private BigDecimal fopAmnt;
  @Column(name = "CC_VENDR")
  private String ccVendr;
  @Column(name = "CC_NUM")
  private String ccNum;
  @Column(name = "CC_EXPDAT")
  private String ccExpdat;
  @Column(name = "FOP_FREE")
  private String fopFree;
  @Column(name = "FOP_IND")
  private String fopInd;

  public VArcEmdFopComp() {
  }

  public String getEmdNbr() {
    return emdNbr;
  }

  public void setEmdNbr(String emdNbr) {
    this.emdNbr = emdNbr;
  }

  public String getFopType() {
    return fopType;
  }

  public void setFopType(String fopType) {
    this.fopType = fopType;
  }

  public BigDecimal getFopAmnt() {
    return fopAmnt;
  }

  public void setFopAmnt(BigDecimal fopAmnt) {
    this.fopAmnt = fopAmnt;
  }

  public String getCcVendr() {
    return ccVendr;
  }

  public void setCcVendr(String ccVendr) {
    this.ccVendr = ccVendr;
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
