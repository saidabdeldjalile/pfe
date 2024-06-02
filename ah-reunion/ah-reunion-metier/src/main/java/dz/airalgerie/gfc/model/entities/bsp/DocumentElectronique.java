/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.bsp;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.gfc.model.dto.bsp.DTOHistoriqueDocument;
import dz.airalgerie.gfc.model.dto.bsp.DTORecapBalance;
import dz.airalgerie.gfc.model.dto.bsp.DTORecapCpature;
import dz.airalgerie.gfc.model.dto.bsp.DTORecapSolde;
import dz.airalgerie.gfc.model.dto.bsp.DTOStatistiqueChiffreAffaire;
import dz.airalgerie.gfc.model.dto.bsp.DTOStatistiqueModePaiement;
import dz.airalgerie.gfc.model.dto.bsp.DTOStatistiqueTaxe;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author KEHLI
 */
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "DTORecapCaptureMapping",
        classes = @ConstructorResult(targetClass = DTORecapCpature.class,
            columns = {@ColumnResult(name = "TOTAL_TKTT", type = Integer.class),
                @ColumnResult(name = "TOTAL_EMDS", type = Integer.class),
                @ColumnResult(name = "TOTAL_EMDA", type = Integer.class),
                @ColumnResult(name = "TOTAL_CANX", type = Integer.class),
                @ColumnResult(name = "TOTAL_CANN", type = Integer.class),
                @ColumnResult(name = "TOTAL_RFND", type = Integer.class)})),
    @SqlResultSetMapping(name = "DTOHistoriqueDocumentMapping",
        classes = @ConstructorResult(targetClass = DTOHistoriqueDocument.class,
            columns = {@ColumnResult(name = "ID_ORDER", type = Integer.class),
                @ColumnResult(name = "ID", type = BigInteger.class),
                @ColumnResult(name = "TRANSACTION_CODE", type = String.class),
                @ColumnResult(name = "PNR", type = String.class),
                @ColumnResult(name = "NUM_DOCUMENT", type = Long.class),
                @ColumnResult(name = "DATE_ISSUE", type = LocalDate.class),
                @ColumnResult(name = "CODE_AGENCE", type = String.class),
                @ColumnResult(name = "BOOKING_OFFICE", type = String.class),
                @ColumnResult(name = "VALIDATING_OFFICE", type = String.class),
                @ColumnResult(name = "VALIDATING_AGENT_ID", type = String.class)})),
    @SqlResultSetMapping(name = "DTORecapSoldeMapping",
        classes = @ConstructorResult(targetClass = DTORecapSolde.class,
            columns = {@ColumnResult(name = "SOLDE_TKTT", type = BigDecimal.class),
                @ColumnResult(name = "SOLDE_RFND", type = BigDecimal.class),
                @ColumnResult(name = "SOLDE_CANX", type = BigDecimal.class),
                @ColumnResult(name = "SOLDE_CANN", type = BigDecimal.class),
                @ColumnResult(name = "SOLDE_EMDS", type = BigDecimal.class),
                @ColumnResult(name = "SOLDE_EMDA", type = BigDecimal.class)})),
    @SqlResultSetMapping(name = "DTORecapBalanceMapping",
        classes = @ConstructorResult(targetClass = DTORecapBalance.class,
            columns = {@ColumnResult(name = "MODE_PAIEMENT", type = String.class),
                @ColumnResult(name = "CREDIT", type = BigDecimal.class),
                @ColumnResult(name = "DEBIT", type = BigDecimal.class),
                @ColumnResult(name = "BALANCE", type = BigDecimal.class),
                @ColumnResult(name = "MONNAIE", type = String.class)})),
    @SqlResultSetMapping(name = "DTOStatistiqueChiffreAffaireMapping",
        classes = @ConstructorResult(targetClass = DTOStatistiqueChiffreAffaire.class,
            columns = {@ColumnResult(name = "CODE_AGENCE", type = String.class),
                @ColumnResult(name = "LIBELLE_STRUCTURE", type = String.class),
                @ColumnResult(name = "HT_VENTE", type = BigDecimal.class),
                @ColumnResult(name = "HT_RFND", type = BigDecimal.class),
                @ColumnResult(name = "BALANCE_HT", type = BigDecimal.class),
                @ColumnResult(name = "YR_VENTE", type = BigDecimal.class),
                @ColumnResult(name = "YR_RFND", type = BigDecimal.class),
                @ColumnResult(name = "BALANCE_YR", type = BigDecimal.class),
                @ColumnResult(name = "FRAIS_SERVICE", type = BigDecimal.class),
                @ColumnResult(name = "FRAIS_RFND", type = BigDecimal.class),
                @ColumnResult(name = "PENALITE_RFND", type = BigDecimal.class),
                @ColumnResult(name = "CHIFFRE_AFFAIRE", type = BigDecimal.class),
                @ColumnResult(name = "DOC_EMIS", type = Integer.class),
                @ColumnResult(name = "DOC_RFND", type = Integer.class)})),
    @SqlResultSetMapping(name = "DTOStatistiqueTaxeMapping",
        classes = @ConstructorResult(targetClass = DTOStatistiqueTaxe.class,
            columns = {@ColumnResult(name = "CODE_TAXE", type = String.class),
                @ColumnResult(name = "MONTANT_TOTAL_EMIS", type = BigDecimal.class),
                @ColumnResult(name = "MONTANT_TOTAL_RFND", type = BigDecimal.class)})),
    @SqlResultSetMapping(name = "DTOStatistiqueModePaiementMapping",
        classes = @ConstructorResult(targetClass = DTOStatistiqueModePaiement.class,
            columns = {@ColumnResult(name = "MODE_PAIEMENT_ALTERNATE", type = String.class),
                @ColumnResult(name = "TOTAL_MONTANT_EMIS", type = BigDecimal.class),
                @ColumnResult(name = "TOTAL_MONTANT_RFND", type = BigDecimal.class)}))})
@Entity
@Table(name = "DOCUMENT_ELECTRONIQUE", schema = ErpConstante.DbSchemaName.CPTA_CV)
public class DocumentElectronique implements Serializable {

  private static final long serialVersionUID = 1L;

  // BKS-24
  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Column(name = "NUM_DOCUMENT")
  private Long numDocument;
  @Column(name = "PNR")
  private String pnr;
  @Column(name = "TRANSACTION_CODE")
  private String transactionCode;
  @Column(name = "DATE_ISSUE")
  private LocalDate dateIssue;
  @Column(name = "DEPART")
  private String depart;
  @Column(name = "ARRIVEE")
  private String arrivee;
  @Column(name = "CODE_AGENCE")
  private String codeAgence;
  @Column(name = "CNJ_TICKET")
  private String conjuctionTicket;
  @Column(name = "COUPON_INDICATEUR")
  private String couponUseIndic;

  // BKS-30
  @Column(name = "MONNAIE")
  private String monnaie;
  @Column(name = "MONTANT_HT")
  private BigDecimal montantHt;
  @Column(name = "TARIF_NET")
  private BigDecimal tarifNet;
  @Column(name = "MONTANT_DOCUMENT")
  private BigDecimal montantDocument;
  @Column(name = "MONTANT_DOCUMENT_IATA")
  private BigDecimal montantDocumentIata;

  // AMA-85
  @Column(name = "MONTANT_DOCUMENT_AMA")
  private BigDecimal montantDocumentAma;

  // BKS-39
  @Column(name = "RESEAU")
  private String reseau;

  // BKS-46
  @Column(name = "ENDOSSEMENT_RESTRICTION")
  private String endossementRestriction;

  // BAR-64
  @Column(name = "FARE_CALCULATION_MODE")
  private String fareCalculationMode;

  // BAR-65
  @Column(name = "PAX_LASTNAME")
  private String paxLastname;
  @Column(name = "PAX_FIRSTNAME")
  private String paxFirstname;

  // AMA-25
  @Column(name = "BOOKING_OFFICE")
  private String bookingOffice;
  @Column(name = "VALIDATING_AGENT_ID")
  private String validatingAgentId;
  @Column(name = "VALIDATING_OFFICE")
  private String validatingOffice;

  // BKP-84
  @Column(name = "NUM_DOCUMENT_EX")
  private String numDocumentEx;
  @Column(name = "COUPONS_EX")
  private String couponsEx;

  @Column(name = "PARCOURS")
  private String parcours;

  @Column(name = "CARRIER")
  private String carrier;
  @Column(name = "IS_VIP")
  private boolean isVip;

  @Column(name = "SOURCE_FILE")
  private String sourceFile;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentCoupon", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<CouponBsp> couponsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentTaxe", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<TaxeBsp> taxesList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "document", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<ModePaiementBsp> modePaiementList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "document", fetch = FetchType.LAZY)
  private List<EmdBsp> emdList;

  public DocumentElectronique() {
  }

  public DocumentElectronique(BigInteger id, Long numDocument, String pnr, String transactionCode,
      LocalDate dateIssue, String depart, String arrivee, String codeAgence,
      String conjuctionTicket, String couponUseIndic, String monnaie, BigDecimal montantHt,
      BigDecimal tarifNet, BigDecimal montantDocument, BigDecimal montantDocumentIata,
      BigDecimal montantDocumentAma, String reseau, String paxLastname, String paxFirstname,
      String bookingOffice, String validatingAgentId, String validatingOffice, String numDocumentEx,
      String couponsEx, String sourceFile, List<CouponBsp> couponsList, List<TaxeBsp> taxesList,
      List<ModePaiementBsp> modePaiementList, List<EmdBsp> emdList) {
    this.id = id;
    this.numDocument = numDocument;
    this.pnr = pnr;
    this.transactionCode = transactionCode;
    this.dateIssue = dateIssue;
    this.depart = depart;
    this.arrivee = arrivee;
    this.codeAgence = codeAgence;
    this.conjuctionTicket = conjuctionTicket;
    this.couponUseIndic = couponUseIndic;
    this.monnaie = monnaie;
    this.montantHt = montantHt;
    this.tarifNet = tarifNet;
    this.montantDocument = montantDocument;
    this.montantDocumentIata = montantDocumentIata;
    this.montantDocumentAma = montantDocumentAma;
    this.reseau = reseau;
    this.paxLastname = paxLastname;
    this.paxFirstname = paxFirstname;
    this.bookingOffice = bookingOffice;
    this.validatingAgentId = validatingAgentId;
    this.validatingOffice = validatingOffice;
    this.numDocumentEx = numDocumentEx;
    this.couponsEx = couponsEx;
    this.sourceFile = sourceFile;
    this.couponsList = couponsList;
    this.taxesList = taxesList;
    this.modePaiementList = modePaiementList;
    this.emdList = emdList;
  }

  public DocumentElectronique(BigInteger id, Long numDocument, String pnr, String transactionCode,
      LocalDate dateIssue, String depart, String arrivee, String codeAgence,
      String conjuctionTicket, String couponUseIndic, String monnaie,
      BigDecimal montantCommissionable, BigDecimal tarifNet, BigDecimal montantBillet,
      BigDecimal montantBilletIata, BigDecimal montantBilletAma, String reseau, String paxLastname,
      String paxFirstname, String bookingOffice, String validatingAgentId, String validatingOffice,
      String numDocumentEx) {
    this.id = id;
    this.numDocument = numDocument;
    this.pnr = pnr;
    this.transactionCode = transactionCode;
    this.dateIssue = dateIssue;
    this.depart = depart;
    this.arrivee = arrivee;
    this.codeAgence = codeAgence;
    this.conjuctionTicket = conjuctionTicket;
    this.couponUseIndic = couponUseIndic;
    this.monnaie = monnaie;
    this.montantHt = montantCommissionable;
    this.tarifNet = tarifNet;
    this.montantDocument = montantBillet;
    this.montantDocumentIata = montantBilletIata;
    this.montantDocumentAma = montantBilletAma;
    this.reseau = reseau;
    this.paxLastname = paxLastname;
    this.paxFirstname = paxFirstname;
    this.bookingOffice = bookingOffice;
    this.validatingAgentId = validatingAgentId;
    this.validatingOffice = validatingOffice;
    this.numDocumentEx = numDocumentEx;
  }

  public DocumentElectronique(BigInteger id, Long numDocument, String pnr, String transactionCode,
      LocalDate dateIssue, String depart, String arrivee, String codeAgence,
      String conjuctionTicket, String couponUseIndic, String monnaie,
      BigDecimal montantCommissionable, BigDecimal tarifNet, BigDecimal montantBillet,
      BigDecimal montantBilletIata, BigDecimal montantBilletAma, String reseau, String paxLastname,
      String paxFirstname, String bookingOffice, String validatingAgentId, String validatingOffice,
      String numDocumentEx, List<ModePaiementBsp> modePaiementList) {
    this.id = id;
    this.numDocument = numDocument;
    this.pnr = pnr;
    this.transactionCode = transactionCode;
    this.dateIssue = dateIssue;
    this.depart = depart;
    this.arrivee = arrivee;
    this.codeAgence = codeAgence;
    this.conjuctionTicket = conjuctionTicket;
    this.couponUseIndic = couponUseIndic;
    this.monnaie = monnaie;
    this.montantHt = montantCommissionable;
    this.tarifNet = tarifNet;
    this.montantDocument = montantBillet;
    this.montantDocumentIata = montantBilletIata;
    this.montantDocumentAma = montantBilletAma;
    this.reseau = reseau;
    this.paxLastname = paxLastname;
    this.paxFirstname = paxFirstname;
    this.bookingOffice = bookingOffice;
    this.validatingAgentId = validatingAgentId;
    this.validatingOffice = validatingOffice;
    this.numDocumentEx = numDocumentEx;
    this.modePaiementList = modePaiementList;
  }

  public DocumentElectronique(BigInteger id, Long numDocument, String pnr, String transactionCode,
      LocalDate dateIssue, String depart, String arrivee, String codeAgence,
      String conjuctionTicket, String couponUseIndic, String monnaie, BigDecimal montantHt,
      BigDecimal tarifNet, BigDecimal montantDocument, BigDecimal montantDocumentIata,
      BigDecimal montantDocumentAma, String reseau, String endossementRestriction,
      String fareCalculationMode, String paxLastname, String paxFirstname, String bookingOffice,
      String validatingAgentId, String validatingOffice, String numDocumentEx, String couponsEx,
      String sourceFile, List<CouponBsp> couponsList, List<TaxeBsp> taxesList,
      List<ModePaiementBsp> modePaiementList, List<EmdBsp> emdList) {
    this.id = id;
    this.numDocument = numDocument;
    this.pnr = pnr;
    this.transactionCode = transactionCode;
    this.dateIssue = dateIssue;
    this.depart = depart;
    this.arrivee = arrivee;
    this.codeAgence = codeAgence;
    this.conjuctionTicket = conjuctionTicket;
    this.couponUseIndic = couponUseIndic;
    this.monnaie = monnaie;
    this.montantHt = montantHt;
    this.tarifNet = tarifNet;
    this.montantDocument = montantDocument;
    this.montantDocumentIata = montantDocumentIata;
    this.montantDocumentAma = montantDocumentAma;
    this.reseau = reseau;
    this.endossementRestriction = endossementRestriction;
    this.fareCalculationMode = fareCalculationMode;
    this.paxLastname = paxLastname;
    this.paxFirstname = paxFirstname;
    this.bookingOffice = bookingOffice;
    this.validatingAgentId = validatingAgentId;
    this.validatingOffice = validatingOffice;
    this.numDocumentEx = numDocumentEx;
    this.couponsEx = couponsEx;
    this.sourceFile = sourceFile;
    this.couponsList = couponsList;
    this.taxesList = taxesList;
    this.modePaiementList = modePaiementList;
    this.emdList = emdList;
  }



  public void initEticket(String fileNme) {
    montantHt = BigDecimal.ZERO;
    tarifNet = BigDecimal.ZERO;
    montantDocument = BigDecimal.ZERO;
    montantDocumentIata = BigDecimal.ZERO;
    montantDocumentAma = BigDecimal.ZERO;
    taxesList = new ArrayList<>();
    couponsList = new ArrayList<>();
    modePaiementList = new ArrayList<>();
    emdList = new ArrayList<>();
    sourceFile = fileNme;
    parcours = "";
    carrier = "";
    isVip = false;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public Long getNumDocument() {
    return numDocument;
  }

  public void setNumDocument(Long numDocument) {
    this.numDocument = numDocument;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }

  public LocalDate getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(LocalDate dateIssue) {
    this.dateIssue = dateIssue;
  }

  public String getDepart() {
    return depart;
  }

  public void setDepart(String depart) {
    this.depart = depart;
  }

  public String getArrivee() {
    return arrivee;
  }

  public void setArrivee(String arrivee) {
    this.arrivee = arrivee;
  }

  public String getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(String codeAgence) {
    this.codeAgence = codeAgence;
  }

  public String getConjuctionTicket() {
    return conjuctionTicket;
  }

  public void setConjuctionTicket(String conjuctionTicket) {
    this.conjuctionTicket = conjuctionTicket;
  }

  public String getCouponUseIndic() {
    return couponUseIndic;
  }

  public void setCouponUseIndic(String couponUseIndic) {
    this.couponUseIndic = couponUseIndic;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public BigDecimal getMontantHt() {
    return montantHt;
  }

  public void setMontantHt(BigDecimal montantHt) {
    this.montantHt = montantHt;
  }

  public BigDecimal getTarifNet() {
    return tarifNet;
  }

  public void setTarifNet(BigDecimal tarifNet) {
    this.tarifNet = tarifNet;
  }

  public BigDecimal getMontantDocument() {
    return montantDocument;
  }

  public void setMontantDocument(BigDecimal montantDocument) {
    this.montantDocument = montantDocument;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getPaxLastname() {
    return paxLastname;
  }

  public void setPaxLastname(String paxLastname) {
    this.paxLastname = paxLastname;
  }

  public String getPaxFirstname() {
    return paxFirstname;
  }

  public void setPaxFirstname(String paxFirstname) {
    this.paxFirstname = paxFirstname;
  }

  public String getBookingOffice() {
    return bookingOffice;
  }

  public void setBookingOffice(String bookingOffice) {
    this.bookingOffice = bookingOffice;
  }

  public String getValidatingAgentId() {
    return validatingAgentId;
  }

  public void setValidatingAgentId(String validatingAgentId) {
    this.validatingAgentId = validatingAgentId;
  }

  public String getValidatingOffice() {
    return validatingOffice;
  }

  public void setValidatingOffice(String validatingOffice) {
    this.validatingOffice = validatingOffice;
  }

  public String getNumDocumentEx() {
    return numDocumentEx;
  }

  public void setNumDocumentEx(String numDocumentEx) {
    this.numDocumentEx = numDocumentEx;
  }

  public String getCouponsEx() {
    return couponsEx;
  }

  public void setCouponsEx(String couponsEx) {
    this.couponsEx = couponsEx;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public boolean isIsVip() {
    return isVip;
  }

  public void setIsVip(boolean isVip) {
    this.isVip = isVip;
  }

  public String getSourceFile() {
    return sourceFile;
  }

  public void setSourceFile(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  public List<CouponBsp> getCouponsList() {
    return couponsList;
  }

  public void setCouponsList(List<CouponBsp> couponsList) {
    this.couponsList = couponsList;
  }

  public List<TaxeBsp> getTaxesList() {
    return taxesList;
  }

  public void setTaxesList(List<TaxeBsp> taxesList) {
    this.taxesList = taxesList;
  }

  public List<ModePaiementBsp> getModePaiementList() {
    return modePaiementList;
  }

  public void setModePaiementList(List<ModePaiementBsp> modePaiementList) {
    this.modePaiementList = modePaiementList;
  }

  public List<EmdBsp> getEmdList() {
    return emdList;
  }

  public void setEmdList(List<EmdBsp> emdList) {
    this.emdList = emdList;
  }

  public String getFareCalculationMode() {
    return fareCalculationMode;
  }

  public void setFareCalculationMode(String fareCalculationMode) {
    this.fareCalculationMode = fareCalculationMode;
  }

  public String getEndossementRestriction() {
    return endossementRestriction;
  }

  public void setEndossementRestriction(String endossementRestriction) {
    this.endossementRestriction = endossementRestriction;
  }

  public String getParcours() {
    return parcours;
  }

  public void setParcours(String parcours) {
    this.parcours = parcours;
  }

  public BigDecimal getMontantDocumentIata() {
    return montantDocumentIata;
  }

  public void setMontantDocumentIata(BigDecimal montantDocumentIata) {
    this.montantDocumentIata = montantDocumentIata;
  }

  public BigDecimal getMontantDocumentAma() {
    return montantDocumentAma;
  }

  public void setMontantDocumentAma(BigDecimal montantDocumentAma) {
    this.montantDocumentAma = montantDocumentAma;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DocumentElectronique{");
    sb.append("id=").append(id);
    sb.append(", numDocument=").append(numDocument);
    sb.append(", pnr=").append(pnr);
    sb.append(", transactionCode=").append(transactionCode);
    sb.append(", dateIssue=").append(dateIssue);
    sb.append(", depart=").append(depart);
    sb.append(", arrivee=").append(arrivee);
    sb.append(", codeAgence=").append(codeAgence);
    sb.append(", conjuctionTicket=").append(conjuctionTicket);
    sb.append(", couponUseIndic=").append(couponUseIndic);
    sb.append(", monnaie=").append(monnaie);
    sb.append(", montantHt=").append(montantHt);
    sb.append(", tarifNet=").append(tarifNet);
    sb.append(", montantDocument=").append(montantDocument);
    sb.append(", montantDocumentIata=").append(montantDocumentIata);
    sb.append(", montantDocumentAma=").append(montantDocumentAma);
    sb.append(", reseau=").append(reseau);
    sb.append(", endossementRestriction=").append(endossementRestriction);
    sb.append(", fareCalculationMode=").append(fareCalculationMode);
    sb.append(", paxLastname=").append(paxLastname);
    sb.append(", paxFirstname=").append(paxFirstname);
    sb.append(", bookingOffice=").append(bookingOffice);
    sb.append(", validatingAgentId=").append(validatingAgentId);
    sb.append(", validatingOffice=").append(validatingOffice);
    sb.append(", numDocumentEx=").append(numDocumentEx);
    sb.append(", couponsEx=").append(couponsEx);
    sb.append(", sourceFile=").append(sourceFile);
    sb.append(", couponsList=").append(couponsList);
    sb.append(", taxesList=").append(taxesList);
    sb.append(", modePaiementList=").append(modePaiementList);
    sb.append(", emdList=").append(emdList);
    sb.append('}');
    return sb.toString();
  }

}
