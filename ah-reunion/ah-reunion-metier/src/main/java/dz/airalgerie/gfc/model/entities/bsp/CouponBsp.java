/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.bsp;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author KEHLI
 */

@Entity
@Table(name = "COUPON", schema = ErpConstante.DbSchemaName.CPTA_CV)
public class CouponBsp implements Serializable {

  private static final long serialVersionUID = 1L;

  // BKI-63
  // @EmbeddedId
  // protected CouponPK couponPk;
  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Column(name = "ID_DOCUMENT")
  private BigInteger idDocument;
  @Column(name = "NUM_DOCUMENT")
  private Long numDocument;
  @Column(name = "COUPON_ID")
  private int couponId;
  @Column(name = "STOP_OVER_CODE")
  private String stopOverCode;
  @Column(name = "NOT_VALID_BEFORE_DATE")
  private LocalDate notValidBeforeDate;
  @Column(name = "NOT_VALID_AFTER_DATE")
  private LocalDate notValidAfterDate;
  @Column(name = "CARRIER")
  private String carrier;
  @Column(name = "DEPART")
  private String depart;
  @Column(name = "ARRIVEE")
  private String arrivee;
  @Column(name = "NUM_VOL")
  private String numVol;
  @Column(name = "CLASSE")
  private String classe;
  @Column(name = "DATE_VOL")
  private LocalDateTime dateVol;
  @Column(name = "STATUT_RESERVATION")
  private String statutReservation;
  @Column(name = "FRANCHISE_BAGAGES")
  private String franchiseBagages;
  @Column(name = "BASE_TARIFAIRE")
  private String baseTarifaire;
  @JoinColumn(name = "ID_DOCUMENT", referencedColumnName = "ID", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private DocumentElectronique documentCoupon;

  public CouponBsp() {
  }

  public CouponBsp(BigInteger id, BigInteger idDocument, Long numDocument, int couponId,
      String stopOverCode, LocalDate notValidBeforeDate, LocalDate notValidAfterDate, String depart,
      String arrivee, String numVol, String classe, LocalDateTime dateVol, String statutReservation,
      String franchiseBagages, String baseTarifaire, DocumentElectronique documentCoupon) {
    this.id = id;
    this.idDocument = idDocument;
    this.numDocument = numDocument;
    this.couponId = couponId;
    this.stopOverCode = stopOverCode;
    this.notValidBeforeDate = notValidBeforeDate;
    this.notValidAfterDate = notValidAfterDate;
    this.depart = depart;
    this.arrivee = arrivee;
    this.numVol = numVol;
    this.classe = classe;
    this.dateVol = dateVol;
    this.statutReservation = statutReservation;
    this.franchiseBagages = franchiseBagages;
    this.baseTarifaire = baseTarifaire;
    this.documentCoupon = documentCoupon;
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

  public String getStopOverCode() {
    return stopOverCode;
  }

  public void setStopOverCode(String stopOverCode) {
    this.stopOverCode = stopOverCode;
  }

  public LocalDate getNotValidBeforeDate() {
    return notValidBeforeDate;
  }

  public void setNotValidBeforeDate(LocalDate notValidBeforeDate) {
    this.notValidBeforeDate = notValidBeforeDate;
  }

  public LocalDate getNotValidAfterDate() {
    return notValidAfterDate;
  }

  public void setNotValidAfterDate(LocalDate notValidAfterDate) {
    this.notValidAfterDate = notValidAfterDate;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
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

  public String getNumVol() {
    return numVol;
  }

  public void setNumVol(String numVol) {
    this.numVol = numVol;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public LocalDateTime getDateVol() {
    return dateVol;
  }

  public void setDateVol(LocalDateTime dateVol) {
    this.dateVol = dateVol;
  }

  public String getStatutReservation() {
    return statutReservation;
  }

  public void setStatutReservation(String statutReservation) {
    this.statutReservation = statutReservation;
  }

  public String getFranchiseBagages() {
    return franchiseBagages;
  }

  public void setFranchiseBagages(String franchiseBagages) {
    this.franchiseBagages = franchiseBagages;
  }

  public String getBaseTarifaire() {
    return baseTarifaire;
  }

  public void setBaseTarifaire(String baseTarifaire) {
    this.baseTarifaire = baseTarifaire;
  }

  public DocumentElectronique getDocumentCoupon() {
    return documentCoupon;
  }

  public void setDocumentCoupon(DocumentElectronique documentCoupon) {
    this.documentCoupon = documentCoupon;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CouponBsp{");
    sb.append("id=").append(id);
    sb.append(", idDocument=").append(idDocument);
    sb.append(", numDocument=").append(numDocument);
    sb.append(", couponId=").append(couponId);
    sb.append(", stopOverCode=").append(stopOverCode);
    sb.append(", notValidBeforeDate=").append(notValidBeforeDate);
    sb.append(", notValidAfterDate=").append(notValidAfterDate);
    sb.append(", carrier=").append(carrier);
    sb.append(", depart=").append(depart);
    sb.append(", arrivee=").append(arrivee);
    sb.append(", numVol=").append(numVol);
    sb.append(", classe=").append(classe);
    sb.append(", dateVol=").append(dateVol);
    sb.append(", statutReservation=").append(statutReservation);
    sb.append(", franchiseBagages=").append(franchiseBagages);
    sb.append(", baseTarifaire=").append(baseTarifaire);
    sb.append('}');
    return sb.toString();
  }

}
