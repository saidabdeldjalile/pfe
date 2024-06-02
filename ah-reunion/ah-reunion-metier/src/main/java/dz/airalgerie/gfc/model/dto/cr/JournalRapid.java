/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cr;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kehli
 */
@Entity
public class JournalRapid implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "FILE_CODE")
  private String fileCode;

  @Column(name = "DATE_TRT")
  private String dateTrt;

  @Column(name = "CPT_UNITE")
  private String cptUnite;

  @Column(name = "CPT_COMPTE")
  private String cptCompte;

  @Column(name = "CPT_LIBELLE")
  private String cptLibelle;

  @Column(name = "CPT_DEBIT")
  private BigDecimal cptDebit;

  @Column(name = "CPT_CREDIT")
  private BigDecimal cptCredit;

  @Column(name = "CPT_CODE_MONNAIE")
  private String cptCodeMonnaie;

  @Column(name = "CPT_PIECE_A")
  private String cptPieceA;

  @Column(name = "CPT_PAGE_A")
  private String cptPageA;

  @Id
  @Column(name = "CPT_NUM_JOURNAL")
  private String cptNumJournal;

  @Column(name = "CODE_APPLICATION")
  private String codeApplication;

  @Column(name = "JV")
  private String jv;

  public JournalRapid() {
  }

  public JournalRapid(int id, String fileCode, String dateTrt, String cptUnite, String cptCompte,
      String cptLibelle, BigDecimal cptDebit, BigDecimal cptCredit, String cptCodeMonnaie,
      String cptPieceA, String cptPageA, String cptNumJournal, String codeApplication, String jv) {
    this.id = id;
    this.fileCode = fileCode;
    this.dateTrt = dateTrt;
    this.cptUnite = cptUnite;
    this.cptCompte = cptCompte;
    this.cptLibelle = cptLibelle;
    this.cptDebit = cptDebit;
    this.cptCredit = cptCredit;
    this.cptCodeMonnaie = cptCodeMonnaie;
    this.cptPieceA = cptPieceA;
    this.cptPageA = cptPageA;
    this.cptNumJournal = cptNumJournal;
    this.codeApplication = codeApplication;
    this.jv = jv;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFileCode() {
    return fileCode;
  }

  public void setFileCode(String fileCode) {
    this.fileCode = fileCode;
  }

  public String getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(String dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public String getCptCompte() {
    return cptCompte;
  }

  public void setCptCompte(String cptCompte) {
    this.cptCompte = cptCompte;
  }

  public String getCptLibelle() {
    return cptLibelle;
  }

  public void setCptLibelle(String cptLibelle) {
    this.cptLibelle = cptLibelle;
  }

  public BigDecimal getCptDebit() {
    return cptDebit;
  }

  public void setCptDebit(BigDecimal cptDebit) {
    this.cptDebit = cptDebit;
  }

  public BigDecimal getCptCredit() {
    return cptCredit;
  }

  public void setCptCredit(BigDecimal cptCredit) {
    this.cptCredit = cptCredit;
  }

  public String getCptCodeMonnaie() {
    return cptCodeMonnaie;
  }

  public void setCptCodeMonnaie(String cptCodeMonnaie) {
    this.cptCodeMonnaie = cptCodeMonnaie;
  }

  public String getCptPieceA() {
    return cptPieceA;
  }

  public void setCptPieceA(String cptPieceA) {
    this.cptPieceA = cptPieceA;
  }

  public String getCptPageA() {
    return cptPageA;
  }

  public void setCptPageA(String cptPageA) {
    this.cptPageA = cptPageA;
  }

  public String getCptNumJournal() {
    return cptNumJournal;
  }

  public void setCptNumJournal(String cptNumJournal) {
    this.cptNumJournal = cptNumJournal;
  }

  public String getCodeApplication() {
    return codeApplication;
  }

  public void setCodeApplication(String codeApplication) {
    this.codeApplication = codeApplication;
  }

  public String getJv() {
    return jv;
  }

  public void setJv(String jv) {
    this.jv = jv;
  }


}
