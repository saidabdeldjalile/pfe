/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author KEHLI Moussab Amine
 */
@Entity
public class Glv1245Total implements Serializable {

  @NotNull
  @Column(name = "DATE_TRT")
  @Id
  private Integer dateTrt;

  @Column(name = "DEBIT_MM")
  private BigDecimal totalDebitMm;

  @Column(name = "CREDIT_MM")
  private BigDecimal totalCreditMm;

  @Column(name = "DEBIT_ANT_MM")
  private BigDecimal totalDebitAntMm;

  @Column(name = "CREDIT_ANT_MM")
  private BigDecimal totalCreditAntMm;

  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal totalSoldeAntMm;

  @Column(name = "SENS_ANT_MM")
  private String totalSensAntMm;

  public Glv1245Total() {}

  public Glv1245Total(Integer dateTrt, BigDecimal totalDebitMm, BigDecimal totalCreditMm,
      BigDecimal totalDebitAntMm, BigDecimal totalCreditAntMm, BigDecimal totalSoldeAntMm,
      String totalSensAntMm) {
    this.dateTrt = dateTrt;
    this.totalDebitMm = totalDebitMm;
    this.totalCreditMm = totalCreditMm;
    this.totalDebitAntMm = totalDebitAntMm;
    this.totalCreditAntMm = totalCreditAntMm;
    this.totalSoldeAntMm = totalSoldeAntMm;
    this.totalSensAntMm = totalSensAntMm;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public BigDecimal getTotalDebitMm() {
    return totalDebitMm;
  }

  public void setTotalDebitMm(BigDecimal totalDebitMm) {
    this.totalDebitMm = totalDebitMm;
  }

  public BigDecimal getTotalCreditMm() {
    return totalCreditMm;
  }

  public void setTotalCreditMm(BigDecimal totalCreditMm) {
    this.totalCreditMm = totalCreditMm;
  }

  public BigDecimal getTotalDebitAntMm() {
    return totalDebitAntMm;
  }

  public void setTotalDebitAntMm(BigDecimal totalDebitAntMm) {
    this.totalDebitAntMm = totalDebitAntMm;
  }

  public BigDecimal getTotalCreditAntMm() {
    return totalCreditAntMm;
  }

  public void setTotalCreditAntMm(BigDecimal totalCreditAntMm) {
    this.totalCreditAntMm = totalCreditAntMm;
  }

  public BigDecimal getTotalSoldeAntMm() {
    return totalSoldeAntMm;
  }

  public void setTotalSoldeAntMm(BigDecimal totalSoldeAntMm) {
    this.totalSoldeAntMm = totalSoldeAntMm;
  }

  public String getTotalSensAntMm() {
    return totalSensAntMm;
  }

  public void setTotalSensAntMm(String totalSensAntMm) {
    this.totalSensAntMm = totalSensAntMm;
  }
}
