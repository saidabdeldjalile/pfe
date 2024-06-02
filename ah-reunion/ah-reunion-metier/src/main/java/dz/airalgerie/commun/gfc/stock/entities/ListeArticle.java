/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class ListeArticle {
  private String typeStock;
  private String designation;
  private String codeAH;
  private String codeATA;
  private String specification;
  private BigDecimal stkMin;
  private BigDecimal stkMax;
  private String codeMesure;
  private String codeFabricant;
  private String codeRepere;
  private String codeMagasin;
  private String pn;
  private String codeAppareil;
  private BigDecimal quantite;
  private BigDecimal valeur;

  public ListeArticle(String typeStock, String designation, String codeAH, String codeATA,
      String specification, BigDecimal stkMin, BigDecimal stkMax, String codeMesure,
      String codeFabricant, String codeRepere, String codeMagasin, String pn, String codeAppareil,
      BigDecimal quantite, BigDecimal valeur) {
    this.typeStock = typeStock;
    this.designation = designation;
    this.codeAH = codeAH;
    this.codeATA = codeATA;
    this.specification = specification;
    this.stkMin = stkMin;
    this.stkMax = stkMax;
    this.codeMesure = codeMesure;
    this.codeFabricant = codeFabricant;
    this.codeRepere = codeRepere;
    this.codeMagasin = codeMagasin;
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.quantite = quantite;
    this.valeur = valeur;
  }

  public String getTypeStock() {
    return typeStock;
  }

  public void setTypeStock(String typeStock) {
    this.typeStock = typeStock;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodeAH() {
    return codeAH;
  }

  public void setCodeAH(String codeAH) {
    this.codeAH = codeAH;
  }

  public String getCodeATA() {
    return codeATA;
  }

  public void setCodeATA(String codeATA) {
    this.codeATA = codeATA;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public BigDecimal getStkMin() {
    return stkMin;
  }

  public void setStkMin(BigDecimal stkMin) {
    this.stkMin = stkMin;
  }

  public BigDecimal getStkMax() {
    return stkMax;
  }

  public void setStkMax(BigDecimal stkMax) {
    this.stkMax = stkMax;
  }

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
  }

  public String getCodeFabricant() {
    return codeFabricant;
  }

  public void setCodeFabricant(String codeFabricant) {
    this.codeFabricant = codeFabricant;
  }

  public String getCodeRepere() {
    return codeRepere;
  }

  public void setCodeRepere(String codeRepere) {
    this.codeRepere = codeRepere;
  }

  public String getCodeMagasin() {
    return codeMagasin;
  }

  public void setCodeMagasin(String codeMagasin) {
    this.codeMagasin = codeMagasin;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }
}
