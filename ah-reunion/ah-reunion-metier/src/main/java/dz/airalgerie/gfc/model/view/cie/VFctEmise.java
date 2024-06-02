/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.cie;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrateur
 */
@Entity
@Table(name = "V_FCT_EMISE", catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VFctEmise.findAll", query = "SELECT v FROM VFctEmise v"),
    @NamedQuery(name = "VFctEmise.findByCptPrest",
        query = "SELECT v FROM VFctEmise v WHERE v.cptPrest = :cptPrest"),
    @NamedQuery(name = "VFctEmise.findByNumCie",
        query = "SELECT v FROM VFctEmise v WHERE v.numCie = :numCie"),
    @NamedQuery(name = "VFctEmise.findByNumFct",
        query = "SELECT v FROM VFctEmise v WHERE v.numFct = :numFct"),
    @NamedQuery(name = "VFctEmise.findByDateFct",
        query = "SELECT v FROM VFctEmise v WHERE v.dateFct = :dateFct"),
    @NamedQuery(name = "VFctEmise.findByCodeMon",
        query = "SELECT v FROM VFctEmise v WHERE v.codeMon = :codeMon"),
    @NamedQuery(name = "VFctEmise.findByDateComp",
        query = "SELECT v FROM VFctEmise v WHERE v.dateComp = :dateComp"),
    @NamedQuery(name = "VFctEmise.findByMntPrest",
        query = "SELECT v FROM VFctEmise v WHERE v.mntPrest = :mntPrest"),
    @NamedQuery(name = "VFctEmise.findByCvalAld",
        query = "SELECT v FROM VFctEmise v WHERE v.cvalAld = :cvalAld"),
    @NamedQuery(name = "VFctEmise.findByMNTald",
        query = "SELECT v FROM VFctEmise v WHERE v.mNTald = :mNTald"),
    @NamedQuery(name = "VFctEmise.findByCvalUsd",
        query = "SELECT v FROM VFctEmise v WHERE v.cvalUsd = :cvalUsd"),
    @NamedQuery(name = "VFctEmise.findByMNTusd",
        query = "SELECT v FROM VFctEmise v WHERE v.mNTusd = :mNTusd"),
    @NamedQuery(name = "VFctEmise.findBySensOp",
        query = "SELECT v FROM VFctEmise v WHERE v.sensOp = :sensOp")})
public class VFctEmise implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Size(max = 12)
  @Column(name = "CPT_PREST", length = 12)
  private String cptPrest;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_CIE", nullable = false)
  private int numCie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "NUM_FCT", nullable = false, length = 8)
  private String numFct;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FCT", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateFct;
  @Size(max = 3)
  @Column(name = "CODE_MON", length = 3)
  private String codeMon;
  @Column(name = "DATE_COMP")
  private Integer dateComp;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MNT_PREST", precision = 12, scale = 3)
  private BigDecimal mntPrest;
  @Column(name = "CVAL_ALD", precision = 12, scale = 6)
  private BigDecimal cvalAld;
  @Column(name = "MNT_ald", precision = 16, scale = 2)
  private BigDecimal mNTald;
  @Column(name = "CVAL_USD", precision = 13, scale = 6)
  private BigDecimal cvalUsd;
  @Column(name = "MNT_usd", precision = 16, scale = 2)
  private BigDecimal mNTusd;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "SENS_OP", nullable = false, length = 1)
  private String sensOp;

  public VFctEmise() {}

  public String getCptPrest() {
    return cptPrest;
  }

  public void setCptPrest(String cptPrest) {
    this.cptPrest = cptPrest;
  }

  public int getNumCie() {
    return numCie;
  }

  public void setNumCie(int numCie) {
    this.numCie = numCie;
  }

  public String getNumFct() {
    return numFct;
  }

  public void setNumFct(String numFct) {
    this.numFct = numFct;
  }

  public Date getDateFct() {
    return dateFct;
  }

  public void setDateFct(Date dateFct) {
    this.dateFct = dateFct;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public Integer getDateComp() {
    return dateComp;
  }

  public void setDateComp(Integer dateComp) {
    this.dateComp = dateComp;
  }

  public BigDecimal getMntPrest() {
    return mntPrest;
  }

  public void setMntPrest(BigDecimal mntPrest) {
    this.mntPrest = mntPrest;
  }

  public BigDecimal getCvalAld() {
    return cvalAld;
  }

  public void setCvalAld(BigDecimal cvalAld) {
    this.cvalAld = cvalAld;
  }

  public BigDecimal getMNTald() {
    return mNTald;
  }

  public void setMNTald(BigDecimal mNTald) {
    this.mNTald = mNTald;
  }

  public BigDecimal getCvalUsd() {
    return cvalUsd;
  }

  public void setCvalUsd(BigDecimal cvalUsd) {
    this.cvalUsd = cvalUsd;
  }

  public BigDecimal getMNTusd() {
    return mNTusd;
  }

  public void setMNTusd(BigDecimal mNTusd) {
    this.mNTusd = mNTusd;
  }

  public String getSensOp() {
    return sensOp;
  }

  public void setSensOp(String sensOp) {
    this.sensOp = sensOp;
  }

}
