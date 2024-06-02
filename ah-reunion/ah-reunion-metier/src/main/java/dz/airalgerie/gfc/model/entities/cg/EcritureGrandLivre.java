/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * =
 */
public class EcritureGrandLivre implements Serializable {

  private static final long serialVersionUID = 1L;

  private String compteScf;
  private String compteParticulier;
  private String intitule;
  private BigDecimal debitAnterieur;
  private BigDecimal creditAnterieur;
  private BigDecimal soldeAnterieur;
  private String sensAnterieur;
  private BigDecimal debitMois;
  private BigDecimal creditMois;
  private BigDecimal debitCumule;
  private BigDecimal creditCumule;
  private BigDecimal soldeCumule;
  private String sensCumule;

  public EcritureGrandLivre() {}

  public EcritureGrandLivre(String compteScf, String compteParticulier, String intitule,
      BigDecimal debitAnterieur, BigDecimal creditAnterieur, BigDecimal soldeAnterieur,
      String sensAnterieur, BigDecimal debitMois, BigDecimal creditMois, BigDecimal debitCumule,
      BigDecimal creditCumule, BigDecimal soldeCumule, String sensCumule) {
    this.compteScf = compteScf;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.debitAnterieur = debitAnterieur;
    this.creditAnterieur = creditAnterieur;
    this.soldeAnterieur = soldeAnterieur;
    this.sensAnterieur = sensAnterieur;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureGrandLivre(String compteScf, String intitule, BigDecimal debitAnterieur,
      BigDecimal creditAnterieur, BigDecimal soldeAnterieur, String sensAnterieur,
      BigDecimal debitMois, BigDecimal creditMois, BigDecimal debitCumule, BigDecimal creditCumule,
      BigDecimal soldeCumule, String sensCumule) {
    this.compteScf = compteScf;
    this.compteParticulier = null;
    this.intitule = intitule;
    this.debitAnterieur = debitAnterieur;
    this.creditAnterieur = creditAnterieur;
    this.soldeAnterieur = soldeAnterieur;
    this.sensAnterieur = sensAnterieur;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureGrandLivre(BigDecimal debitMois, BigDecimal creditMois, BigDecimal debitCumule,
      BigDecimal creditCumule, BigDecimal soldeCumule, String sensCumule) {
    this.compteScf = null;
    this.compteParticulier = null;
    this.intitule = null;
    this.debitAnterieur = null;
    this.creditAnterieur = null;
    this.soldeAnterieur = null;
    this.sensAnterieur = null;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public String getCompteScf() {
    return compteScf;
  }

  public void setCompteScf(String compteScf) {
    this.compteScf = compteScf;
  }

  public String getCompteParticulier() {
    return compteParticulier;
  }

  public void setCompteParticulier(String compteParticulier) {
    this.compteParticulier = compteParticulier;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public BigDecimal getDebitAnterieur() {
    return debitAnterieur;
  }

  public void setDebitAnterieur(BigDecimal debitAnterieur) {
    this.debitAnterieur = debitAnterieur;
  }

  public BigDecimal getCreditAnterieur() {
    return creditAnterieur;
  }

  public void setCreditAnterieur(BigDecimal creditAnterieur) {
    this.creditAnterieur = creditAnterieur;
  }

  public BigDecimal getSoldeAnterieur() {
    return soldeAnterieur;
  }

  public void setSoldeAnterieur(BigDecimal soldeAnterieur) {
    this.soldeAnterieur = soldeAnterieur;
  }

  public String getSensAnterieur() {
    return sensAnterieur;
  }

  public void setSensAnterieur(String sensAnterieur) {
    this.sensAnterieur = sensAnterieur;
  }

  public BigDecimal getDebitMois() {
    return debitMois;
  }

  public void setDebitMois(BigDecimal debitMois) {
    this.debitMois = debitMois;
  }

  public BigDecimal getCreditMois() {
    return creditMois;
  }

  public void setCreditMois(BigDecimal creditMois) {
    this.creditMois = creditMois;
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
}
