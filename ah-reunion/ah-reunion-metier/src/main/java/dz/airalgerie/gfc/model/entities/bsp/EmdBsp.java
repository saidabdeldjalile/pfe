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
@Table(name = "EMD", schema = ErpConstante.DbSchemaName.CPTA_CV)
public class EmdBsp implements Serializable {

  private static final long serialVersionUID = 1L;
  // @EmbeddedId
  // protected EmdPK emdPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Column(name = "ID_DOCUMENT")
  private BigInteger idDocument;
  @Column(name = "NUM_DOCUMENT")
  private Long numDocument;
  @Column(name = "COUPON_ID")
  private int couponId;
  @Column(name = "MONTANT")
  private BigDecimal montant;
  @Column(name = "MONNAIE")
  private String monnaie;
  @Column(name = "REF_DOCUMENT")
  private Long refDocument;
  @Column(name = "REF_COUPON")
  private Integer refCoupon;
  @Column(name = "ISSUE_REASON_SUB_CODE")
  private String issueReasonSubCode;
  @Column(name = "EXCEDENT_FRANCHISE_BAGGAGE")
  private String excedentFranchiseBaggage;
  @Column(name = "TAUX_EXCEDENT_BAGGAGE")
  private String tauxExcedentBaggage;
  @Column(name = "EXCEDENT_BAGGAGE")
  private String excedentBaggage;
  @Column(name = "ISSUE_CONSOMMATION")
  private String issueConsommation;
  @JoinColumn(name = "ID_DOCUMENT", referencedColumnName = "ID", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private DocumentElectronique document;

  public EmdBsp() {
  }

  public EmdBsp(BigInteger id, BigInteger idDocument, Long numDocument, int couponId,
      BigDecimal montant, String monnaie, Long refDocument, Integer refCoupon,
      String issueReasonSubCode, String excedentFranchiseBaggage, String tauxExcedentBaggage,
      String excedentBaggage, String issueConsommation, DocumentElectronique document) {
    this.id = id;
    this.idDocument = idDocument;
    this.numDocument = numDocument;
    this.couponId = couponId;
    this.montant = montant;
    this.monnaie = monnaie;
    this.refDocument = refDocument;
    this.refCoupon = refCoupon;
    this.issueReasonSubCode = issueReasonSubCode;
    this.excedentFranchiseBaggage = excedentFranchiseBaggage;
    this.tauxExcedentBaggage = tauxExcedentBaggage;
    this.excedentBaggage = excedentBaggage;
    this.issueConsommation = issueConsommation;
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

  public int getCouponId() {
    return couponId;
  }

  public void setCouponId(int couponId) {
    this.couponId = couponId;
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

  public Long getRefDocument() {
    return refDocument;
  }

  public void setRefDocument(Long refDocument) {
    this.refDocument = refDocument;
  }

  public Integer getRefCoupon() {
    return refCoupon;
  }

  public void setRefCoupon(Integer refCoupon) {
    this.refCoupon = refCoupon;
  }

  public String getIssueReasonSubCode() {
    return issueReasonSubCode;
  }

  public void setIssueReasonSubCode(String issueReasonSubCode) {
    this.issueReasonSubCode = issueReasonSubCode;
  }

  public String getExcedentFranchiseBaggage() {
    return excedentFranchiseBaggage;
  }

  public void setExcedentFranchiseBaggage(String excedentFranchiseBaggage) {
    this.excedentFranchiseBaggage = excedentFranchiseBaggage;
  }

  public String getTauxExcedentBaggage() {
    return tauxExcedentBaggage;
  }

  public void setTauxExcedentBaggage(String tauxExcedentBaggage) {
    this.tauxExcedentBaggage = tauxExcedentBaggage;
  }

  public String getExcedentBaggage() {
    return excedentBaggage;
  }

  public void setExcedentBaggage(String excedentBaggage) {
    this.excedentBaggage = excedentBaggage;
  }

  public String getIssueConsommation() {
    return issueConsommation;
  }

  public void setIssueConsommation(String issueConsommation) {
    this.issueConsommation = issueConsommation;
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
    sb.append("EmdBsp{");
    sb.append("id=").append(id);
    sb.append(", idDocument=").append(idDocument);
    sb.append(", numDocument=").append(numDocument);
    sb.append(", couponId=").append(couponId);
    sb.append(", montant=").append(montant);
    sb.append(", monnaie=").append(monnaie);
    sb.append(", refDocument=").append(refDocument);
    sb.append(", refCoupon=").append(refCoupon);
    sb.append(", issueReasonSubCode=").append(issueReasonSubCode);
    sb.append(", excedentFranchiseBaggage=").append(excedentFranchiseBaggage);
    sb.append(", tauxExcedentBaggage=").append(tauxExcedentBaggage);
    sb.append(", excedentBaggage=").append(excedentBaggage);
    sb.append(", issueConsommation=").append(issueConsommation);
    sb.append(", document=").append(document);
    sb.append('}');
    return sb.toString();
  }
}
