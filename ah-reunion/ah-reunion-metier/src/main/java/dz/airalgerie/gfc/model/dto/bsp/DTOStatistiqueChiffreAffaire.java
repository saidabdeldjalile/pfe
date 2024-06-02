/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.bsp;

import java.math.BigDecimal;

/**
 *
 * @author KEHLI
 */
public class DTOStatistiqueChiffreAffaire {

  private String codeAgence;
  private String libelleStructure;
  private BigDecimal htVente;
  private BigDecimal htRfnd;
  private BigDecimal balanceHt;
  private BigDecimal yrVente;
  private BigDecimal yrRfnd;
  private BigDecimal balanceYr;
  private BigDecimal fraisService;
  private BigDecimal fraisRfnd;
  private BigDecimal penaliteRfnd;
  private BigDecimal chiffreAffaire;
  private Integer nbrDocEmis;
  private Integer nbrDocRfnd;

  public DTOStatistiqueChiffreAffaire() {
  }

  public DTOStatistiqueChiffreAffaire(String codeAgence, String libelleStructure, BigDecimal htVente,
      BigDecimal htRfnd, BigDecimal balanceHt, BigDecimal yrVente, BigDecimal yrRfnd,
      BigDecimal balanceYr, BigDecimal fraisService, BigDecimal fraisRfnd, BigDecimal penaliteRfnd,
      BigDecimal chiffreAffaire, Integer nbrDocEmis, Integer nbrDocRfnd) {
    this.codeAgence = codeAgence;
    this.libelleStructure = libelleStructure;
    this.htVente = htVente;
    this.htRfnd = htRfnd;
    this.balanceHt = balanceHt;
    this.yrVente = yrVente;
    this.yrRfnd = yrRfnd;
    this.balanceYr = balanceYr;
    this.fraisService = fraisService;
    this.fraisRfnd = fraisRfnd;
    this.penaliteRfnd = penaliteRfnd;
    this.chiffreAffaire = chiffreAffaire;
    this.nbrDocEmis = nbrDocEmis;
    this.nbrDocRfnd = nbrDocRfnd;
  }

  public String getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(String codeAgence) {
    this.codeAgence = codeAgence;
  }

  public String getLibelleStructure() {
    return libelleStructure;
  }

  public void setLibelleStructure(String libelleStructure) {
    this.libelleStructure = libelleStructure;
  }

  public BigDecimal getHtVente() {
    return htVente;
  }

  public void setHtVente(BigDecimal htVente) {
    this.htVente = htVente;
  }

  public BigDecimal getHtRfnd() {
    return htRfnd;
  }

  public void setHtRfnd(BigDecimal htRfnd) {
    this.htRfnd = htRfnd;
  }

  public BigDecimal getBalanceHt() {
    return balanceHt;
  }

  public void setBalanceHt(BigDecimal balanceHt) {
    this.balanceHt = balanceHt;
  }

  public BigDecimal getYrVente() {
    return yrVente;
  }

  public void setYrVente(BigDecimal yrVente) {
    this.yrVente = yrVente;
  }

  public BigDecimal getYrRfnd() {
    return yrRfnd;
  }

  public void setYrRfnd(BigDecimal yrRfnd) {
    this.yrRfnd = yrRfnd;
  }

  public BigDecimal getBalanceYr() {
    return balanceYr;
  }

  public void setBalanceYr(BigDecimal balanceYr) {
    this.balanceYr = balanceYr;
  }

  public BigDecimal getFraisService() {
    return fraisService;
  }

  public void setFraisService(BigDecimal fraisService) {
    this.fraisService = fraisService;
  }

  public BigDecimal getFraisRfnd() {
    return fraisRfnd;
  }

  public void setFraisRfnd(BigDecimal fraisRfnd) {
    this.fraisRfnd = fraisRfnd;
  }

  public BigDecimal getPenaliteRfnd() {
    return penaliteRfnd;
  }

  public void setPenaliteRfnd(BigDecimal penaliteRfnd) {
    this.penaliteRfnd = penaliteRfnd;
  }

  public BigDecimal getChiffreAffaire() {
    return chiffreAffaire;
  }

  public void setChiffreAffaire(BigDecimal chiffreAffaire) {
    this.chiffreAffaire = chiffreAffaire;
  }

  public Integer getNbrDocEmis() {
    return nbrDocEmis;
  }

  public void setNbrDocEmis(Integer nbrDocEmis) {
    this.nbrDocEmis = nbrDocEmis;
  }

  public Integer getNbrDocRfnd() {
    return nbrDocRfnd;
  }

  public void setNbrDocRfnd(Integer nbrDocRfnd) {
    this.nbrDocRfnd = nbrDocRfnd;
  }

}
