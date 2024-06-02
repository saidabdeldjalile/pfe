/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author user
 */
public class ListeReints {
  private String typeStock;
  private String designation;
  private String codeATA;
  private String specification;
  private String codeMesure;
  private String codeRepere;
  private String codeMagasin;
  private String pn;
  private String codeAppareil;
  private BigDecimal quantite;
  private BigDecimal valeur;
  private String numBon;
  private int dateTraitReint;
  private Date dateReint;

  public ListeReints(String typeStock, String designation, String codeATA, String specification,
      String codeMesure, String codeRepere, String codeMagasin, String pn, String codeAppareil,
      BigDecimal quantite, BigDecimal valeur, String numBon, int dateTraitReint, Date dateReint) {
    this.typeStock = typeStock;
    this.designation = designation;
    this.codeATA = codeATA;
    this.specification = specification;
    this.codeMesure = codeMesure;
    this.codeRepere = codeRepere;
    this.codeMagasin = codeMagasin;
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.quantite = quantite;
    this.valeur = valeur;
    this.numBon = numBon;
    this.dateTraitReint = dateTraitReint;
    this.dateReint = dateReint;
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

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
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

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public int getDateTraitReint() {
    return dateTraitReint;
  }

  public void setDateTraitReint(int dateTraitReint) {
    this.dateTraitReint = dateTraitReint;
  }

  public Date getDateReint() {
    return dateReint;
  }

  public void setDateReint(Date dateReint) {
    this.dateReint = dateReint;
  }

}
