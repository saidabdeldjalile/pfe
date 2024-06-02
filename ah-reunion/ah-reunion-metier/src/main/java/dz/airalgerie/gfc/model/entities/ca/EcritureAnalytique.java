/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public class EcritureAnalytique implements Serializable {

  private static final long serialVersionUID = 1L;

  private int dateTrt;
  private String compteParticulier;
  private String intitule;
  private String libelle;
  private BigDecimal soldeAnterieurCharge;
  private BigDecimal soldeMoisCharge;
  private BigDecimal soldeCumuleCharge;
  private BigDecimal soldeAnterieurProduit;
  private BigDecimal soldeMoisProduit;
  private BigDecimal soldeCumuleProduit;
  private BigDecimal ecartAnterieur;
  private BigDecimal ecartMois;
  private BigDecimal ecartCumule;

  public EcritureAnalytique() {}

  public EcritureAnalytique(int dateTrt, String compteParticulier, String intitule, String libelle,
      BigDecimal soldeAnterieurCharge, BigDecimal soldeMoisCharge, BigDecimal soldeCumuleCharge,
      BigDecimal soldeAnterieurProduit, BigDecimal soldeMoisProduit, BigDecimal soldeCumuleProduit,
      BigDecimal ecartAnterieur, BigDecimal ecartMois, BigDecimal ecartCumule) {
    this.dateTrt = dateTrt;
    this.compteParticulier = compteParticulier;
    this.intitule = intitule;
    this.libelle = libelle;
    this.soldeAnterieurCharge = soldeAnterieurCharge;
    this.soldeMoisCharge = soldeMoisCharge;
    this.soldeCumuleCharge = soldeCumuleCharge;
    this.soldeAnterieurProduit = soldeAnterieurProduit;
    this.soldeMoisProduit = soldeMoisProduit;
    this.soldeCumuleProduit = soldeCumuleProduit;
    this.ecartAnterieur = ecartAnterieur;
    this.ecartMois = ecartMois;
    this.ecartCumule = ecartCumule;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
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

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getSoldeAnterieurCharge() {
    return soldeAnterieurCharge;
  }

  public void setSoldeAnterieurCharge(BigDecimal soldeAnterieurCharge) {
    this.soldeAnterieurCharge = soldeAnterieurCharge;
  }

  public BigDecimal getSoldeMoisCharge() {
    return soldeMoisCharge;
  }

  public void setSoldeMoisCharge(BigDecimal soldeMoisCharge) {
    this.soldeMoisCharge = soldeMoisCharge;
  }

  public BigDecimal getSoldeCumuleCharge() {
    return soldeCumuleCharge;
  }

  public void setSoldeCumuleCharge(BigDecimal soldeCumuleCharge) {
    this.soldeCumuleCharge = soldeCumuleCharge;
  }

  public BigDecimal getSoldeAnterieurProduit() {
    return soldeAnterieurProduit;
  }

  public void setSoldeAnterieurProduit(BigDecimal soldeAnterieurProduit) {
    this.soldeAnterieurProduit = soldeAnterieurProduit;
  }

  public BigDecimal getSoldeMoisProduit() {
    return soldeMoisProduit;
  }

  public void setSoldeMoisProduit(BigDecimal soldeMoisProduit) {
    this.soldeMoisProduit = soldeMoisProduit;
  }

  public BigDecimal getSoldeCumuleProduit() {
    return soldeCumuleProduit;
  }

  public void setSoldeCumuleProduit(BigDecimal soldeCumuleProduit) {
    this.soldeCumuleProduit = soldeCumuleProduit;
  }

  public BigDecimal getEcartAnterieur() {
    return ecartAnterieur;
  }

  public void setEcartAnterieur(BigDecimal ecartAnterieur) {
    this.ecartAnterieur = ecartAnterieur;
  }

  public BigDecimal getEcartMois() {
    return ecartMois;
  }

  public void setEcartMois(BigDecimal ecartMois) {
    this.ecartMois = ecartMois;
  }

  public BigDecimal getEcartCumule() {
    return ecartCumule;
  }

  public void setEcartCumule(BigDecimal ecartCumule) {
    this.ecartCumule = ecartCumule;
  }

}
