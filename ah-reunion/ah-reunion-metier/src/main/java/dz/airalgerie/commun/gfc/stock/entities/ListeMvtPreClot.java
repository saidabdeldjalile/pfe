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
public class ListeMvtPreClot {

  private String pn;
  private String codeAppareil;
  private BigDecimal quantite;
  private BigDecimal valeur;
  private String numBon;
  private int dateTraitMvt;
  private int typeMVT;

  public ListeMvtPreClot(String pn, String codeAppareil, BigDecimal quantite, BigDecimal valeur,
      String numBon, int dateTraitMvt, int typeMVT) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.quantite = quantite;
    this.valeur = valeur;
    this.numBon = numBon;
    this.dateTraitMvt = dateTraitMvt;
    this.typeMVT = typeMVT;
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

  public int getDateTraitMvt() {
    return dateTraitMvt;
  }

  public void setDateTraitMvt(int dateTraitMvt) {
    this.dateTraitMvt = dateTraitMvt;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

}
