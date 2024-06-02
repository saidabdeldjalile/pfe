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
@Table(name = "TAXE", schema = ErpConstante.DbSchemaName.CPTA_CV)
public class TaxeBsp implements Serializable {

  private static final long serialVersionUID = 1L;

  // BKS-30
  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Column(name = "ID_DOCUMENT")
  private BigInteger idDocument;
  @Column(name = "NUM_DOCUMENT")
  private Long numDocument;
  @Column(name = "CODE_TAXE")
  private String codeTaxe;
  @Column(name = "MONTANT")
  private BigDecimal montant;
  @Column(name = "MONNAIE")
  private String monnaie;
  @Column(name = "IS_OBFEES")
  private boolean isObFees;
  @JoinColumn(name = "ID_DOCUMENT", referencedColumnName = "ID", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private DocumentElectronique documentTaxe;

  public TaxeBsp() {
  }

  public TaxeBsp(BigInteger id, BigInteger idDocument, Long numDocument, String codeTaxe,
      BigDecimal montant, String monnaie, boolean isObFees, DocumentElectronique documentTaxe) {
    this.id = id;
    this.idDocument = idDocument;
    this.numDocument = numDocument;
    this.codeTaxe = codeTaxe;
    this.montant = montant;
    this.monnaie = monnaie;
    this.isObFees = isObFees;
    this.documentTaxe = documentTaxe;
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

  public String getCodeTaxe() {
    return codeTaxe;
  }

  public void setCodeTaxe(String codeTaxe) {
    this.codeTaxe = codeTaxe;
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

  public DocumentElectronique getDocumentTaxe() {
    return documentTaxe;
  }

  public void setDocumentTaxe(DocumentElectronique documentTaxe) {
    this.documentTaxe = documentTaxe;
  }

  public boolean isIsObFees() {
    return isObFees;
  }

  public void setIsObFees(boolean isObFees) {
    this.isObFees = isObFees;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Taxe{");
    sb.append("numBillet=").append(numDocument);
    sb.append(", codeTaxe=").append(codeTaxe);
    sb.append(", montant=").append(montant);
    sb.append(", monnaie=").append(monnaie);
    sb.append('}');
    return sb.toString();
  }
}
