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
public class EcritureAnalytiqueDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  private int dateTrt;
  private String compteParticulier;
  private String compteScf;
  private String libelle;
  private BigDecimal soldeAnterieur;
  private BigDecimal soldeMois;
  private BigDecimal soldeCumule;

  public EcritureAnalytiqueDetail() {}

  public EcritureAnalytiqueDetail(String compteParticulier, String compteScf, String libelle,
      BigDecimal soldeAnterieur, BigDecimal soldeMois, BigDecimal soldeCumule) {
    this.compteParticulier = compteParticulier;
    this.compteScf = compteScf;
    this.libelle = libelle;
    this.soldeAnterieur = soldeAnterieur;
    this.soldeMois = soldeMois;
    this.soldeCumule = soldeCumule;
  }

  public EcritureAnalytiqueDetail(int dateTrt, String compteParticulier, String compteScf,
      String libelle, BigDecimal soldeAnterieur, BigDecimal soldeMois, BigDecimal soldeCumule) {
    this.dateTrt = dateTrt;
    this.compteParticulier = compteParticulier;
    this.compteScf = compteScf;
    this.libelle = libelle;
    this.soldeAnterieur = soldeAnterieur;
    this.soldeMois = soldeMois;
    this.soldeCumule = soldeCumule;
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

  public String getCompteScf() {
    return compteScf;
  }

  public void setCompteScf(String compteScf) {
    this.compteScf = compteScf;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getSoldeAnterieur() {
    return soldeAnterieur;
  }

  public void setSoldeAnterieur(BigDecimal soldeAnterieur) {
    this.soldeAnterieur = soldeAnterieur;
  }

  public BigDecimal getSoldeMois() {
    return soldeMois;
  }

  public void setSoldeMois(BigDecimal soldeMois) {
    this.soldeMois = soldeMois;
  }

  public BigDecimal getSoldeCumule() {
    return soldeCumule;
  }

  public void setSoldeCumule(BigDecimal soldeCumule) {
    this.soldeCumule = soldeCumule;
  }
}
