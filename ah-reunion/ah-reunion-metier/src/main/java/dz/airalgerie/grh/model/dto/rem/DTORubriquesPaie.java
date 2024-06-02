/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.rem;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author AGHA Riadh
 */
public class DTORubriquesPaie implements Serializable {

  private static final long serialVersionUID = 1L;
  private int matricule;
  private int dateTrt;
  private int datePai;
  private String codeRubrique;
  private String libelleRubrique;
  private String sensRubrique;
  private BigDecimal nbJrHr;
  private BigDecimal tauxAssiette;
  private BigDecimal gainsImposables;
  private BigDecimal gainsNonImposables;
  private BigDecimal retenuesImposables;
  private BigDecimal retenuesNonImposables;

  public DTORubriquesPaie() {
  }

  public DTORubriquesPaie(int matricule,int dateTrt, int datePai, String codeRubrique, String libelleRubrique,
      String sensRubrique, BigDecimal nbJrHr, BigDecimal tauxAssiette, BigDecimal gainsImposables,
      BigDecimal gainsNonImposables, BigDecimal retenuesImposables,
      BigDecimal retenuesNonImposables) {
    this.matricule=matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
    this.codeRubrique = codeRubrique;
    this.libelleRubrique = libelleRubrique;
    this.sensRubrique = sensRubrique;
    this.nbJrHr = nbJrHr;
    this.tauxAssiette = tauxAssiette;
    this.gainsImposables = gainsImposables;
    this.gainsNonImposables = gainsNonImposables;
    this.retenuesImposables = retenuesImposables;
    this.retenuesNonImposables = retenuesNonImposables;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public String getCodeRubrique() {
    return codeRubrique;
  }

  public void setCodeRubrique(String codeRubrique) {
    this.codeRubrique = codeRubrique;
  }

  public String getLibelleRubrique() {
    return libelleRubrique;
  }

  public void setLibelleRubrique(String libelleRubrique) {
    this.libelleRubrique = libelleRubrique;
  }

  public String getSensRubrique() {
    return sensRubrique;
  }

  public void setSensRubrique(String sensRubrique) {
    this.sensRubrique = sensRubrique;
  }

  public BigDecimal getNbJrHr() {
    return nbJrHr;
  }

  public void setNbJrHr(BigDecimal nbJrHr) {
    this.nbJrHr = nbJrHr;
  }

  public BigDecimal getTauxAssiette() {
    return tauxAssiette;
  }

  public void setTauxAssiette(BigDecimal tauxAssiette) {
    this.tauxAssiette = tauxAssiette;
  }

  public BigDecimal getGainsImposables() {
    return gainsImposables;
  }

  public void setGainsImposables(BigDecimal gainsImposables) {
    this.gainsImposables = gainsImposables;
  }

  public BigDecimal getGainsNonImposables() {
    return gainsNonImposables;
  }

  public void setGainsNonImposables(BigDecimal gainsNonImposables) {
    this.gainsNonImposables = gainsNonImposables;
  }

  public BigDecimal getRetenuesImposables() {
    return retenuesImposables;
  }

  public void setRetenuesImposables(BigDecimal retenuesImposables) {
    this.retenuesImposables = retenuesImposables;
  }

  public BigDecimal getRetenuesNonImposables() {
    return retenuesNonImposables;
  }

  public void setRetenuesNonImposables(BigDecimal retenuesNonImposables) {
    this.retenuesNonImposables = retenuesNonImposables;
  }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }



}
