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
public class ListeAchats {
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
  private int dateTraitAchat;
  private String numCMD;
  private Date dateAchat;
  private Date dateFact;
  private String numFact;

  public ListeAchats(String typeStock, String designation, String specification, String codeMesure,
      String codeRepere, String codeMagasin, String pn, String codeAppareil, BigDecimal quantite,
      BigDecimal valeur, String numBon, int DateTraitAchat, String numCMD, String numFact,
      Date dateAchat, Date dateFact) {
    this.typeStock = typeStock;
    this.designation = designation;
    this.specification = specification;
    this.codeMesure = codeMesure;
    this.codeRepere = codeRepere;
    this.codeMagasin = codeMagasin;
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.quantite = quantite;
    this.valeur = valeur;
    this.numBon = numBon;
    this.dateTraitAchat = DateTraitAchat;
    this.numCMD = numCMD;
    this.numFact = numFact;
    this.dateAchat = dateAchat;
    this.dateFact = dateFact;
  }

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public String getNumCMD() {
    return numCMD;
  }

  public void setNumCMD(String numCMD) {
    this.numCMD = numCMD;
  }

  public String getNumFact() {
    return numFact;
  }

  public void setNumFact(String numFact) {
    this.numFact = numFact;
  }

  public Date getDateAchat() {
    return dateAchat;
  }

  public void setDateAchat(Date dateAchat) {
    this.dateAchat = dateAchat;
  }

  public Date getDateFact() {
    return dateFact;
  }

  public void setDateFact(Date dateFact) {
    this.dateFact = dateFact;
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

  public int getDateTraitAchat() {
    return dateTraitAchat;
  }

  public void setDateTraitAchat(int dateTraitAchat) {
    this.dateTraitAchat = dateTraitAchat;
  }
}
