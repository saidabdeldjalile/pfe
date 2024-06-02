/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ecofie;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author kehli
 */
public class DTOContratEcofiePays implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer anneeTrt;
  private Integer trimestre;
  private String pays;
  private Integer nbrContrat;
  private BigDecimal montantEuro;
  private BigDecimal montantUsd;
  private BigDecimal montantAutreMonnaie;
  private String autreMonnaieCode;

  public DTOContratEcofiePays(Integer anneeTrt, Integer trimestre, String pays, Integer nbrContrat,
      BigDecimal montantEuro, BigDecimal montantUsd, BigDecimal montantAutreMonnaie,
      String autreMonnaieCode) {
    this.anneeTrt = anneeTrt;
    this.trimestre = trimestre;
    this.pays = pays;
    this.nbrContrat = nbrContrat;
    this.montantEuro = montantEuro;
    this.montantUsd = montantUsd;
    this.montantAutreMonnaie = montantAutreMonnaie;
    this.autreMonnaieCode = autreMonnaieCode;
  }

  public Integer getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(Integer anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public Integer getTrimestre() {
    return trimestre;
  }

  public void setTrimestre(Integer trimestre) {
    this.trimestre = trimestre;
  }

  public String getPays() {
    return pays;
  }

  public void setPays(String pays) {
    this.pays = pays;
  }

  public Integer getNbrContrat() {
    return nbrContrat;
  }

  public void setNbrContrat(Integer nbrContrat) {
    this.nbrContrat = nbrContrat;
  }

  public BigDecimal getMontantEuro() {
    return montantEuro;
  }

  public void setMontantEuro(BigDecimal montantEuro) {
    this.montantEuro = montantEuro;
  }

  public BigDecimal getMontantUsd() {
    return montantUsd;
  }

  public void setMontantUsd(BigDecimal montantUsd) {
    this.montantUsd = montantUsd;
  }

  public BigDecimal getMontantAutreMonnaie() {
    return montantAutreMonnaie;
  }

  public void setMontantAutreMonnaie(BigDecimal montantAutreMonnaie) {
    this.montantAutreMonnaie = montantAutreMonnaie;
  }

  public String getAutreMonnaieCode() {
    return autreMonnaieCode;
  }

  public void setAutreMonnaieCode(String autreMonnaieCode) {
    this.autreMonnaieCode = autreMonnaieCode;
  }

}
