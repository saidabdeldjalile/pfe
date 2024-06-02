/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.cg.EcritureBalance;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = "CU", name = "BALANCE_COMPTABLE")
@NamedQueries({
    @NamedQuery(name = "BalanceComptable.findAll", query = "SELECT b FROM BalanceComptable b")})
@SqlResultSetMapping(name = "EcritureBalanceUniteMapping",
    classes = @ConstructorResult(targetClass = EcritureBalance.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = int.class),
            @ColumnResult(name = "CLASSE", type = String.class),
            @ColumnResult(name = "CPT_PART", type = String.class),
            @ColumnResult(name = "INTITULE", type = String.class),
            @ColumnResult(name = "SOLDE_OUV", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_INIT", type = BigDecimal.class),
            @ColumnResult(name = "DEBIT_MM", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT_MM", type = BigDecimal.class),
            @ColumnResult(name = "DEBIT_CUMULE", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT_CUMULE", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_CUMULE", type = BigDecimal.class)}))
public class BalanceComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Size(max = 4)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Size(max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Size(max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;
  @Size(max = 100)
  @Column(name = "LIBELLE_CPT")
  private String libelleCpt;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SOLDE_OUV")
  private BigDecimal soldeOuv;
  @Size(max = 1)
  @Column(name = "SENS_OUV")
  private String sensOuv;
  @Column(name = "SOLDE_INIT")
  private BigDecimal soldeInit;
  @Size(max = 1)
  @Column(name = "SENS_INIT")
  private String sensInit;
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;
  @Column(name = "SOLDE_MM")
  private BigDecimal soldeMm;
  @Size(max = 1)
  @Column(name = "SENS_MM")
  private String sensMm;
  @Column(name = "DEBIT_CUMULE")
  private BigDecimal debitCumule;
  @Column(name = "CREDIT_CUMULE")
  private BigDecimal creditCumule;
  @Column(name = "SOLDE_CUMULE")
  private BigDecimal soldeCumule;
  @Size(max = 1)
  @Column(name = "SENS_CUMULE")
  private String sensCumule;
  @Column(name = "MODE")
  private Integer mode;

  public BalanceComptable() {
  }

  public BalanceComptable(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public String getLibelleCpt() {
    return libelleCpt;
  }

  public void setLibelleCpt(String libelleCpt) {
    this.libelleCpt = libelleCpt;
  }

  public BigDecimal getSoldeOuv() {
    return soldeOuv;
  }

  public void setSoldeOuv(BigDecimal soldeOuv) {
    this.soldeOuv = soldeOuv;
  }

  public String getSensOuv() {
    return sensOuv;
  }

  public void setSensOuv(String sensOuv) {
    this.sensOuv = sensOuv;
  }

  public BigDecimal getSoldeInit() {
    return soldeInit;
  }

  public void setSoldeInit(BigDecimal soldeInit) {
    this.soldeInit = soldeInit;
  }

  public String getSensInit() {
    return sensInit;
  }

  public void setSensInit(String sensInit) {
    this.sensInit = sensInit;
  }

  public BigDecimal getDebitMm() {
    return debitMm;
  }

  public void setDebitMm(BigDecimal debitMm) {
    this.debitMm = debitMm;
  }

  public BigDecimal getCreditMm() {
    return creditMm;
  }

  public void setCreditMm(BigDecimal creditMm) {
    this.creditMm = creditMm;
  }

  public BigDecimal getSoldeMm() {
    return soldeMm;
  }

  public void setSoldeMm(BigDecimal soldeMm) {
    this.soldeMm = soldeMm;
  }

  public String getSensMm() {
    return sensMm;
  }

  public void setSensMm(String sensMm) {
    this.sensMm = sensMm;
  }

  public BigDecimal getDebitCumule() {
    return debitCumule;
  }

  public void setDebitCumule(BigDecimal debitCumule) {
    this.debitCumule = debitCumule;
  }

  public BigDecimal getCreditCumule() {
    return creditCumule;
  }

  public void setCreditCumule(BigDecimal creditCumule) {
    this.creditCumule = creditCumule;
  }

  public BigDecimal getSoldeCumule() {
    return soldeCumule;
  }

  public void setSoldeCumule(BigDecimal soldeCumule) {
    this.soldeCumule = soldeCumule;
  }

  public String getSensCumule() {
    return sensCumule;
  }

  public void setSensCumule(String sensCumule) {
    this.sensCumule = sensCumule;
  }

  public Integer getMode() {
    return mode;
  }

  public void setMode(Integer mode) {
    this.mode = mode;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceComptable)) {
      return false;
    }
    BalanceComptable other = (BalanceComptable) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.BalanceComptable[ id=" + id + " ]";
  }

}
