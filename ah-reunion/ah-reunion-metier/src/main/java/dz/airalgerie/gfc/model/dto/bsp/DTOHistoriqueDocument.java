/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.bsp;

import java.math.BigInteger;
import java.time.LocalDate;


/**
 *
 * @author KEHLI
 */
public class DTOHistoriqueDocument {

  private int idOrder;
  private BigInteger id;
  private String transactionCode;
  private String pnr;
  private Long numDocument;
  private LocalDate dateIssue;
  private String codeAgence;
  private String bookingOffice;
  private String validatingOffice;
  private String validationAgentId;

  public DTOHistoriqueDocument() {
  }

  public DTOHistoriqueDocument(int idOrder, BigInteger id, String transactionCode, String pnr,
      Long numDocument, LocalDate dateIssue, String codeAgence, String bookingOffice,
      String validatingOffice, String validationAgentId) {
    this.idOrder = idOrder;
    this.id = id;
    this.transactionCode = transactionCode;
    this.pnr = pnr;
    this.numDocument = numDocument;
    this.dateIssue = dateIssue;
    this.codeAgence = codeAgence;
    this.bookingOffice = bookingOffice;
    this.validatingOffice = validatingOffice;
    this.validationAgentId = validationAgentId;
  }

  public int getIdOrder() {
    return idOrder;
  }

  public void setIdOrder(int idOrder) {
    this.idOrder = idOrder;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public Long getNumDocument() {
    return numDocument;
  }

  public void setNumDocument(Long numDocument) {
    this.numDocument = numDocument;
  }

  public LocalDate getDateIssue() {
    return dateIssue;
  }

  public void setDateIssue(LocalDate dateIssue) {
    this.dateIssue = dateIssue;
  }

  public String getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(String codeAgence) {
    this.codeAgence = codeAgence;
  }

  public String getBookingOffice() {
    return bookingOffice;
  }

  public void setBookingOffice(String bookingOffice) {
    this.bookingOffice = bookingOffice;
  }


  public String getValidatingOffice() {
    return validatingOffice;
  }

  public void setValidatingOffice(String validatingOffice) {
    this.validatingOffice = validatingOffice;
  }

  public String getValidationAgentId() {
    return validationAgentId;
  }

  public void setValidationAgentId(String validationAgentId) {
    this.validationAgentId = validationAgentId;
  }

}
