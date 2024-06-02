/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.stock;

import java.math.BigDecimal;

/**
 *
 */
public class EcartInventaireDto {

  private String pn;
  private String codeAppareil;
  private String designation;
  private String codemesure;
  private String ddm;
  private String magasin_1;
  private String repere_1;
  private String reserve_1;
  private String magasin_2;
  private String repere_2;
  private String reserve_2;
  private String dateInventaire;
  private BigDecimal quantiteComptable;
  private BigDecimal valeurComptable;
  private BigDecimal quantitePhysique;
  private BigDecimal valeurPhysique;
  private BigDecimal ecartQuantite;
  private BigDecimal ecartValeur;
  private String commentaires;
  private boolean isInvent;

  public EcartInventaireDto() {
  }

  public EcartInventaireDto(String pn, String codeAppareil, String designation, String codemesure,
      String ddm, String magasin_1, String repere_1, String reserve_1, String magasin_2,
      String repere_2, String reserve_2, String dateInventaire, BigDecimal quantiteComptable,
      BigDecimal valeurComptable, BigDecimal quantitePhysique, BigDecimal valeurPhysique,
      BigDecimal ecartQuantite, BigDecimal ecartValeur, String commentaires, boolean isInvent) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.designation = designation;
    this.codemesure = codemesure;
    this.ddm = ddm;
    this.magasin_1 = magasin_1;
    this.repere_1 = repere_1;
    this.reserve_1 = reserve_1;
    this.magasin_2 = magasin_2;
    this.repere_2 = repere_2;
    this.reserve_2 = reserve_2;
    this.dateInventaire = dateInventaire;
    this.quantiteComptable = quantiteComptable;
    this.valeurComptable = valeurComptable;
    this.quantitePhysique = quantitePhysique;
    this.valeurPhysique = valeurPhysique;
    this.ecartQuantite = ecartQuantite;
    this.ecartValeur = ecartValeur;
    this.commentaires = commentaires;
    this.isInvent = isInvent;
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

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodemesure() {
    return codemesure;
  }

  public void setCodemesure(String codemesure) {
    this.codemesure = codemesure;
  }

  public String getDdm() {
    return ddm;
  }

  public void setDdm(String ddm) {
    this.ddm = ddm;
  }

  public String getMagasin_1() {
    return magasin_1;
  }

  public void setMagasin_1(String magasin_1) {
    this.magasin_1 = magasin_1;
  }

  public String getRepere_1() {
    return repere_1;
  }

  public void setRepere_1(String repere_1) {
    this.repere_1 = repere_1;
  }

  public String getReserve_1() {
    return reserve_1;
  }

  public void setReserve_1(String reserve_1) {
    this.reserve_1 = reserve_1;
  }

  public String getMagasin_2() {
    return magasin_2;
  }

  public void setMagasin_2(String magasin_2) {
    this.magasin_2 = magasin_2;
  }

  public String getRepere_2() {
    return repere_2;
  }

  public void setRepere_2(String repere_2) {
    this.repere_2 = repere_2;
  }

  public String getReserve_2() {
    return reserve_2;
  }

  public void setReserve_2(String reserve_2) {
    this.reserve_2 = reserve_2;
  }

  public String getDateInventaire() {
    return dateInventaire;
  }

  public void setDateInventaire(String dateInventaire) {
    this.dateInventaire = dateInventaire;
  }

  public BigDecimal getQuantiteComptable() {
    return quantiteComptable;
  }

  public void setQuantiteComptable(BigDecimal quantiteComptable) {
    this.quantiteComptable = quantiteComptable;
  }

  public BigDecimal getValeurComptable() {
    return valeurComptable;
  }

  public void setValeurComptable(BigDecimal valeurComptable) {
    this.valeurComptable = valeurComptable;
  }

  public BigDecimal getQuantitePhysique() {
    return quantitePhysique;
  }

  public void setQuantitePhysique(BigDecimal quantitePhysique) {
    this.quantitePhysique = quantitePhysique;
  }

  public BigDecimal getValeurPhysique() {
    return valeurPhysique;
  }

  public void setValeurPhysique(BigDecimal valeurPhysique) {
    this.valeurPhysique = valeurPhysique;
  }

  public BigDecimal getEcartQuantite() {
    return ecartQuantite;
  }

  public void setEcartQuantite(BigDecimal ecartQuantite) {
    this.ecartQuantite = ecartQuantite;
  }

  public BigDecimal getEcartValeur() {
    return ecartValeur;
  }

  public void setEcartValeur(BigDecimal ecartValeur) {
    this.ecartValeur = ecartValeur;
  }

  public String getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(String commentaires) {
    this.commentaires = commentaires;
  }

  public boolean isIsInvent() {
    return isInvent;
  }

  public void setIsInvent(boolean isInvent) {
    this.isInvent = isInvent;
  }

}
