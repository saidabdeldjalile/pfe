/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.bsp;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author KEHLI
 */
@Entity
@Table(name = "MODE_PAIEMENT", schema = ErpConstante.DbSchemaName.CPTA_CV)
public class ModePaiementBsp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Column(name = "ID_DOCUMENT")
  private BigInteger idDocument;
  @Column(name = "NUM_DOCUMENT")
  private Long numDocument;
  @Column(name = "MODE_PAIEMENT")
  private String modePaiement;
  @Column(name = "MODE_PAIEMENT_ALTERNATE")
  private String modePaiementAlternate;
  @Column(name = "MONTANT")
  private BigDecimal montant;
  @Column(name = "MONNAIE")
  private String monnaie;
  @Column(name = "NUM_COMPTE")
  private String numCompte;
  @Column(name = "EXIRACY_DATE")
  private String exiracyDate;
  @Column(name = "NUM_FACTURE")
  private String numFacture;
  @Column(name = "DATE_FACTURE")
  private int dateFacture;
  @Column(name = "BANQUE")
  private String banque;
  @Column(name = "NUM_CLIENT")
  private String numClient;
  @Column(name = "NUM_BON")
  private String numBon;
  @Column(name = "NUM_CLIENT_INIT")
  private String numClientInit;
  @Column(name = "NUM_BON_INIT")
  private String numBonInit;
  @Column(name = "MONNAIE_ORIGIN")
  private String monnaieOrigin;
  @Column(name = "DETAILS")
  private String details;
  @Column(name = "REMARQUES")
  private String remarques;
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_DOCUMENT", referencedColumnName = "ID", insertable = false,
      updatable = false)
  private DocumentElectronique document;

  public ModePaiementBsp() {
  }

  public ModePaiementBsp(BigInteger id, BigInteger idDocument, Long numDocument,
      String modePaiement, String modePaiementAlternate, BigDecimal montant, String monnaie,
      String numCompte, String exiracyDate, String numFacture, int dateFacture, String banque,
      String numClient, String numBon, String monnaieOrigin, String details, String remarques,
      DocumentElectronique document) {
    this.id = id;
    this.idDocument = idDocument;
    this.numDocument = numDocument;
    this.modePaiement = modePaiement;
    this.modePaiementAlternate = modePaiementAlternate;
    this.montant = montant;
    this.monnaie = monnaie;
    this.numCompte = numCompte;
    this.exiracyDate = exiracyDate;
    this.numFacture = numFacture;
    this.dateFacture = dateFacture;
    this.banque = banque;
    this.numClient = numClient;
    this.numBon = numBon;
    this.monnaieOrigin = monnaieOrigin;
    this.details = details;
    this.remarques = remarques;
    this.document = document;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public BigInteger getIdDocument() {
    return idDocument;
  }

  public void setIdDocument(BigInteger idDocument) {
    this.idDocument = idDocument;
  }

  public Long getNumDocument() {
    return numDocument;
  }

  public void setNumDocument(Long numDocument) {
    this.numDocument = numDocument;
  }

  public String getModePaiement() {
    return modePaiement;
  }

  public void setModePaiement(String modePaiement) {
    this.modePaiement = modePaiement;
  }

  public String getModePaiementAlternate() {
    return modePaiementAlternate;
  }

  public void setModePaiementAlternate(String modePaiementAlternate) {
    this.modePaiementAlternate = modePaiementAlternate;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public String getNumCompte() {
    return numCompte;
  }

  public void setNumCompte(String numCompte) {
    this.numCompte = numCompte;
  }

  public String getExiracyDate() {
    return exiracyDate;
  }

  public void setExiracyDate(String exiracyDate) {
    this.exiracyDate = exiracyDate;
  }

  public String getNumFacture() {
    return numFacture;
  }

  public void setNumFacture(String numFacture) {
    this.numFacture = numFacture;
  }

  public int getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(int dateFacture) {
    this.dateFacture = dateFacture;
  }

  public String getBanque() {
    return banque;
  }

  public void setBanque(String banque) {
    this.banque = banque;
  }

  public String getNumClient() {
    return numClient;
  }

  public void setNumClient(String numClient) {
    this.numClient = numClient;
  }

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public String getNumClientInit() {
    return numClientInit;
  }

  public void setNumClientInit(String numClientInit) {
    this.numClientInit = numClientInit;
  }

  public String getNumBonInit() {
    return numBonInit;
  }

  public void setNumBonInit(String numBonInit) {
    this.numBonInit = numBonInit;
  }

  public String getMonnaieOrigin() {
    return monnaieOrigin;
  }

  public void setMonnaieOrigin(String monnaieOrigin) {
    this.monnaieOrigin = monnaieOrigin;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getRemarques() {
    return remarques;
  }

  public void setRemarques(String remarques) {
    this.remarques = remarques;
  }

  public DocumentElectronique getDocument() {
    return document;
  }

  public void setDocument(DocumentElectronique document) {
    this.document = document;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ModePaiementBsp{");
    sb.append("id=").append(id);
    sb.append(", idDocument=").append(idDocument);
    sb.append(", numDocument=").append(numDocument);
    sb.append(", modePaiement=").append(modePaiement);
    sb.append(", modePaiementAlternate=").append(modePaiementAlternate);
    sb.append(", montant=").append(montant);
    sb.append(", monnaie=").append(monnaie);
    sb.append(", numCompte=").append(numCompte);
    sb.append(", exiracyDate=").append(exiracyDate);
    sb.append(", numFacture=").append(numFacture);
    sb.append(", dateFacture=").append(dateFacture);
    sb.append(", banque=").append(banque);
    sb.append(", numClient=").append(numClient);
    sb.append(", numBon=").append(numBon);
    sb.append(", numClientInit=").append(numClientInit);
    sb.append(", numBonInit=").append(numBonInit);
    sb.append(", monnaieOrigin=").append(monnaieOrigin);
    sb.append(", details=").append(details);
    sb.append(", remarques=").append(remarques);
    sb.append(", document=").append(document);
    sb.append('}');
    return sb.toString();
  }
}
