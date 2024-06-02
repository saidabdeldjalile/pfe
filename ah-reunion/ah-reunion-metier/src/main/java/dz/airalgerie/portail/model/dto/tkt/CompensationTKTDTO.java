/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.tkt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 *
 */
public class CompensationTKTDTO implements Serializable {
  private String etkt;
  private String uniteInput;
  private String refDemande;
  private String resultatTraitement;
  private String refAccord;
  private String refReponse;
  private String cur;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  private BigDecimal montantHt;
  private BigDecimal montantTtc;
  private String taxes;
  private String docVoucher;
  private String agent;
  private String obs;
  private short statut;
  private LocalDate dateIssue;
  private String issCity;
  private String issCntry;
  private String agnIata;
  private String agnType;
  private LocalDateTime dateOperation;
  private String controlLocation;
  private String fop;
  private String coupons;
  private LocalDateTime dateFin;
  private LocalDateTime dateTransfert;

  public CompensationTKTDTO() {
  }

  public CompensationTKTDTO(String etkt, String uniteInput, String refDemande,
      String resultatTraitement, String refAccord, String refReponse, String cur,
      BigDecimal montantHt, BigDecimal montantTtc, String taxes, String docVoucher, String agent,
      String obs, short statut, LocalDate dateIssue, String issCity, String issCntry,
      String agnIata, String agnType, LocalDateTime dateOperation, String fop, String coupons,
      LocalDateTime dateFin, LocalDateTime dateTransfert) {
    this.etkt = etkt;
    this.uniteInput = uniteInput;
    this.refDemande = refDemande;
    this.resultatTraitement = resultatTraitement;
    this.refAccord = refAccord;
    this.refReponse = refReponse;
    this.cur = cur;
    this.montantHt = montantHt;
    this.montantTtc = montantTtc;
    this.taxes = taxes;
    this.docVoucher = docVoucher;
    this.agent = agent;
    this.obs = obs;
    this.statut = statut;
    this.dateIssue = dateIssue;
    this.issCity = issCity;
    this.issCntry = issCntry;
    this.agnIata = agnIata;
    this.agnType = agnType;
    this.dateOperation = dateOperation;
    this.fop = fop;
    this.coupons = coupons;
    this.dateFin = dateFin;
    this.dateTransfert = dateTransfert;
  }

  public CompensationTKTDTO(String etkt, String uniteInput, String refDemande,
      String resultatTraitement, String refAccord, String refReponse, String cur,
      BigDecimal montantHt, BigDecimal montantTtc, String taxes, String docVoucher, String agent,
      String obs, short statut, LocalDate dateIssue, String issCity, String issCntry,
      String agnIata, String agnType, LocalDateTime dateOperation, String controlLocation,
      String fop, String coupons, LocalDateTime dateFin, LocalDateTime dateTransfert) {
    this.etkt = etkt;
    this.uniteInput = uniteInput;
    this.refDemande = refDemande;
    this.resultatTraitement = resultatTraitement;
    this.refAccord = refAccord;
    this.refReponse = refReponse;
    this.cur = cur;
    this.montantHt = montantHt;
    this.montantTtc = montantTtc;
    this.taxes = taxes;
    this.docVoucher = docVoucher;
    this.agent = agent;
    this.obs = obs;
    this.statut = statut;
    this.dateIssue = dateIssue;
    this.issCity = issCity;
    this.issCntry = issCntry;
    this.agnIata = agnIata;
    this.agnType = agnType;
    this.dateOperation = dateOperation;
    this.controlLocation = controlLocation;
    this.fop = fop;
    this.coupons = coupons;
    this.dateFin = dateFin;
    this.dateTransfert = dateTransfert;
  }

  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public String getUniteInput() {
    return uniteInput;
  }

  public void setUniteInput(String uniteInput) {
    this.uniteInput = uniteInput;
  }

  public String getRefDemande() {
    return refDemande;
  }

  public void setRefDemande(String refDemande) {
    this.refDemande = refDemande;
  }

  public String getResultatTraitement() {
    return resultatTraitement;
  }

  public void setResultatTraitement(String resultatTraitement) {
    this.resultatTraitement = resultatTraitement;
  }

  public String getRefAccord() {
    return refAccord;
  }

  public void setRefAccord(String refAccord) {
    this.refAccord = refAccord;
  }

  public String getRefReponse() {
    return refReponse;
  }

  public void setRefReponse(String refReponse) {
    this.refReponse = refReponse;
  }

  public String getCur() {
    return cur;
  }

  public void setCur(String cur) {
    this.cur = cur;
  }

  public BigDecimal getMontantHt() {
    return montantHt;
  }

  public void setMontantHt(BigDecimal montantHt) {
    this.montantHt = montantHt;
  }

  public BigDecimal getMontantTtc() {
    return montantTtc;
  }

  public void setMontantTtc(BigDecimal montantTtc) {
    this.montantTtc = montantTtc;
  }

  public String getTaxes() {
    return taxes;
  }

  public void setTaxes(String taxes) {
    this.taxes = taxes;
  }

  public String getDocVoucher() {
    return docVoucher;
  }

  public void setDocVoucher(String docVoucher) {
    this.docVoucher = docVoucher;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public short getStatut() {
    return statut;
  }

  public void setStatut(short statut) {
    this.statut = statut;
  }

  public LocalDate getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(LocalDate dateIssue) {
    this.dateIssue = dateIssue;
  }

  public String getIssCity() {
    return issCity;
  }

  public void setIssCity(String issCity) {
    this.issCity = issCity;
  }

  public String getIssCntry() {
    return issCntry;
  }

  public void setIssCntry(String issCntry) {
    this.issCntry = issCntry;
  }

  public String getAgnIata() {
    return agnIata;
  }

  public void setAgnIata(String agnIata) {
    this.agnIata = agnIata;
  }

  public String getAgnType() {
    return agnType;
  }

  public void setAgnType(String agnType) {
    this.agnType = agnType;
  }

  public LocalDateTime getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(LocalDateTime dateOperation) {
    this.dateOperation = dateOperation;
  }

  public String getControlLocation() {
    return controlLocation;
  }

  public void setControlLocation(String controlLocation) {
    this.controlLocation = controlLocation;
  }

  public String getFop() {
    return fop;
  }

  public void setFop(String fop) {
    this.fop = fop;
  }

  public String getCoupons() {
    return coupons;
  }

  public void setCoupons(String coupons) {
    this.coupons = coupons;
  }

  public LocalDateTime getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDateTime dateFin) {
    this.dateFin = dateFin;
  }

  public LocalDateTime getDateTransfert() {
    return dateTransfert;
  }

  public void setDateTransfert(LocalDateTime dateTransfert) {
    this.dateTransfert = dateTransfert;
  }

}
