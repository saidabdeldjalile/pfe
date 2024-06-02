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
@Table(name = "V_ALD", catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VAld.findAll", query = "SELECT v FROM VAld v"),
    @NamedQuery(name = "VAld.findByNumFct",
        query = "SELECT v FROM VAld v WHERE v.numFct = :numFct"),
    @NamedQuery(name = "VAld.findByNumCie",
        query = "SELECT v FROM VAld v WHERE v.numCie = :numCie"),
    @NamedQuery(name = "VAld.findByDateFct",
        query = "SELECT v FROM VAld v WHERE v.dateFct = :dateFct"),
    @NamedQuery(name = "VAld.findBySensOp",
        query = "SELECT v FROM VAld v WHERE v.sensOp = :sensOp"),
    @NamedQuery(name = "VAld.findByCodeMon",
        query = "SELECT v FROM VAld v WHERE v.codeMon = :codeMon"),
    @NamedQuery(name = "VAld.findByDateComp",
        query = "SELECT v FROM VAld v WHERE v.dateComp = :dateComp"),
    @NamedQuery(name = "VAld.findByTotalPrest",
        query = "SELECT v FROM VAld v WHERE v.totalPrest = :totalPrest"),
    @NamedQuery(name = "VAld.findByCvalAld",
        query = "SELECT v FROM VAld v WHERE v.cvalAld = :cvalAld"),
    @NamedQuery(name = "VAld.findByTotalald",
        query = "SELECT v FROM VAld v WHERE v.totalald = :totalald"),
    @NamedQuery(name = "VAld.findByCvalUsd",
        query = "SELECT v FROM VAld v WHERE v.cvalUsd = :cvalUsd"),
    @NamedQuery(name = "VAld.findByTotalUsd",
        query = "SELECT v FROM VAld v WHERE v.totalUsd = :totalUsd")})
public class VAld implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "NUM_FCT", nullable = false, length = 8)
  private String numFct;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_CIE", nullable = false)
  private int numCie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FCT", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateFct;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "SENS_OP", nullable = false, length = 1)
  private String sensOp;
  @Size(max = 3)
  @Column(name = "CODE_MON", length = 3)
  private String codeMon;
  @Column(name = "DATE_COMP")
  private Integer dateComp;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(precision = 38, scale = 3)
  private BigDecimal totalPrest;
  @Column(name = "CVAL_ALD", precision = 12, scale = 6)
  private BigDecimal cvalAld;
  @Column(name = "Total_ald", precision = 16, scale = 2)
  private BigDecimal totalald;
  @Column(name = "CVAL_USD", precision = 13, scale = 6)
  private BigDecimal cvalUsd;
  @Column(name = "total_usd", precision = 16, scale = 2)
  private BigDecimal totalUsd;

  public VAld() {}

  public String getNumFct() {
    return numFct;
  }

  public void setNumFct(String numFct) {
    this.numFct = numFct;
  }

  public int getNumCie() {
    return numCie;
  }

  public void setNumCie(int numCie) {
    this.numCie = numCie;
  }

  public Date getDateFct() {
    return dateFct;
  }

  public void setDateFct(Date dateFct) {
    this.dateFct = dateFct;
  }

  public String getSensOp() {
    return sensOp;
  }

  public void setSensOp(String sensOp) {
    this.sensOp = sensOp;
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

  public BigDecimal getTotalPrest() {
    return totalPrest;
  }

  public void setTotalPrest(BigDecimal totalPrest) {
    this.totalPrest = totalPrest;
  }

  public BigDecimal getCvalAld() {
    return cvalAld;
  }

  public void setCvalAld(BigDecimal cvalAld) {
    this.cvalAld = cvalAld;
  }

  public BigDecimal getTotalald() {
    return totalald;
  }

  public void setTotalald(BigDecimal totalald) {
    this.totalald = totalald;
  }

  public BigDecimal getCvalUsd() {
    return cvalUsd;
  }

  public void setCvalUsd(BigDecimal cvalUsd) {
    this.cvalUsd = cvalUsd;
  }

  public BigDecimal getTotalUsd() {
    return totalUsd;
  }

  public void setTotalUsd(BigDecimal totalUsd) {
    this.totalUsd = totalUsd;
  }

}
