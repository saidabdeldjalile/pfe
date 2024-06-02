/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public class EcritureBalance implements Serializable {

  private static final long serialVersionUID = 1L;

  private int dateTrt;
  private String compteScf;
  private String compteParticulier;
  private String intitule;
  private BigDecimal soldeOuverture;
  private String sensOuverture;
  private BigDecimal soldeInitial;
  private String sensInitial;
  private BigDecimal debitMois;
  private BigDecimal creditMois;
  private BigDecimal debitCumule;
  private BigDecimal creditCumule;
  private BigDecimal soldeCumule;
  private String sensCumule;

  public EcritureBalance() {
  }

  public EcritureBalance(int dateTrt, String compteScf, String intitule, BigDecimal soldeOuverture,
      String sensOuverture, BigDecimal debitMois, BigDecimal creditMois, BigDecimal debitCumule,
      BigDecimal creditCumule, BigDecimal soldeCumule, String sensCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = null;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.sensOuverture = sensOuverture;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureBalance(int dateTrt, String compteScf, String intitule, BigDecimal soldeOuverture,
      String sensOuverture, BigDecimal soldeInitial, String sensInitial, BigDecimal debitMois,
      BigDecimal creditMois, BigDecimal debitCumule, BigDecimal creditCumule,
      BigDecimal soldeCumule, String sensCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = null;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.sensOuverture = sensOuverture;
    this.soldeInitial = soldeInitial;
    this.sensInitial = sensInitial;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureBalance(int dateTrt, String compteScf, String compteParticulier, String intitule,
      BigDecimal soldeOuverture, String sensOuverture, BigDecimal debitMois, BigDecimal creditMois,
      BigDecimal debitCumule, BigDecimal creditCumule, BigDecimal soldeCumule, String sensCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.sensOuverture = sensOuverture;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureBalance(int dateTrt, String compteScf, String compteParticulier, String intitule,
      BigDecimal soldeOuverture, String sensOuverture, BigDecimal soldeInitial, String sensInitial,
      BigDecimal debitMois, BigDecimal creditMois, BigDecimal debitCumule, BigDecimal creditCumule,
      BigDecimal soldeCumule, String sensCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.sensOuverture = sensOuverture;
    this.soldeInitial = soldeInitial;
    this.sensInitial = sensInitial;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
    this.sensCumule = sensCumule;
  }

  public EcritureBalance(int dateTrt, String compteScf, String compteParticulier, String intitule,
      BigDecimal soldeOuverture, BigDecimal debitMois, BigDecimal creditMois,
      BigDecimal debitCumule, BigDecimal creditCumule, BigDecimal soldeCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
  }

  public EcritureBalance(int dateTrt, String compteScf, String compteParticulier, String intitule,
      BigDecimal soldeOuverture, BigDecimal soldeInitial, BigDecimal debitMois,
      BigDecimal creditMois, BigDecimal debitCumule, BigDecimal creditCumule,
      BigDecimal soldeCumule) {
    this.dateTrt = dateTrt;
    this.compteScf = compteScf;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.soldeOuverture = soldeOuverture;
    this.soldeInitial = soldeInitial;
    this.debitMois = debitMois;
    this.creditMois = creditMois;
    this.debitCumule = debitCumule;
    this.creditCumule = creditCumule;
    this.soldeCumule = soldeCumule;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
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

  public BigDecimal getSoldeOuverture() {
    return soldeOuverture;
  }

  public void setSoldeOuverture(BigDecimal soldeOuverture) {
    this.soldeOuverture = soldeOuverture;
  }

  public String getSensOuverture() {
    return sensOuverture;
  }

  public void setSensOuverture(String sensOuverture) {
    this.sensOuverture = sensOuverture;
  }

  public BigDecimal getSoldeInitial() {
    return soldeInitial;
  }

  public void setSoldeInitial(BigDecimal soldeInitial) {
    this.soldeInitial = soldeInitial;
  }

  public String getSensInitial() {
    return sensInitial;
  }

  public void setSensInitial(String sensInitial) {
    this.sensInitial = sensInitial;
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("EcritureBalance{dateTrt=").append(dateTrt);
    sb.append(", compteScf=").append(compteScf);
    sb.append(", compteParticulier=").append(compteParticulier);
    sb.append(", intitule=").append(intitule);
    sb.append(", soldeOuverture=").append(soldeOuverture);
    sb.append(", sensOuverture=").append(sensOuverture);
    sb.append(", soldeInitial=").append(soldeInitial);
    sb.append(", sensInitial=").append(sensInitial);
    sb.append(", debitMois=").append(debitMois);
    sb.append(", creditMois=").append(creditMois);
    sb.append(", debitCumule=").append(debitCumule);
    sb.append(", creditCumule=").append(creditCumule);
    sb.append(", soldeCumule=").append(soldeCumule);
    sb.append(", sensCumule=").append(sensCumule);
    sb.append('}');
    return sb.toString();
  }

}
