/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cloture;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class EcritureCartoucheComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "CPT_UNITE")
  private String uniteId;
  @Id
  @Column(name = "DATE_TRT")
  private String dateTrt;
  @Id
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Id
  @Column(name = "CPT_PART")
  private String cptPart;
  @Id
  @Column(name = "LIBELLE")
  private String libelle;
  @Id
  @Column(name = "DEBIT")
  private BigDecimal debit;
  @Id
  @Column(name = "CREDIT")
  private BigDecimal credit;
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Column(name = "NUM_PIECE")
  private String numPiece;
  @Column(name = "NUM_PAGE")
  private String numPage;
  @Column(name = "NUM_JOURNAL")
  private String numJournal;
  @Column(name = "CODE_APPLICATION")
  private String codeApplication;
  @Column(name = "DEBIT_ORG")
  private String debitOrg;
  @Column(name = "CREDIT_ORG")
  private String creditOrg;
  @Column(name = "UTILISATEUR")
  private String utilisateur;
  @Column(name = "DATE_SAISIE")
  private String dateSaisie;

  public EcritureCartoucheComptable() {}

  public EcritureCartoucheComptable(String uniteId, String dateTrt, String cptScf, String cptPart,
      String libelle, BigDecimal debit, BigDecimal credit, String codeMonnaie, String numPiece,
      String numPage, String numJournal, String codeApplication, String debitOrg, String creditOrg,
      String utilisateur, String dateSaisie) {
    this.uniteId = uniteId;
    this.dateTrt = dateTrt;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
    this.libelle = libelle;
    this.debit = debit;
    this.credit = credit;
    this.codeMonnaie = codeMonnaie;
    this.numPiece = numPiece;
    this.numPage = numPage;
    this.numJournal = numJournal;
    this.codeApplication = codeApplication;
    this.debitOrg = debitOrg;
    this.creditOrg = creditOrg;
    this.utilisateur = utilisateur;
    this.dateSaisie = dateSaisie;
  }

  public String getUniteId() {
    return uniteId;
  }

  public void setUniteId(String uniteId) {
    this.uniteId = uniteId;
  }

  public String getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(String dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getDebit() {
    return debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public String getNumPiece() {
    return numPiece;
  }

  public void setNumPiece(String numPiece) {
    this.numPiece = numPiece;
  }

  public String getNumPage() {
    return numPage;
  }

  public void setNumPage(String numPage) {
    this.numPage = numPage;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getCodeApplication() {
    return codeApplication;
  }

  public void setCodeApplication(String codeApplication) {
    this.codeApplication = codeApplication;
  }

  public String getDebitOrg() {
    return debitOrg;
  }

  public void setDebitOrg(String debitOrg) {
    this.debitOrg = debitOrg;
  }

  public String getCreditOrg() {
    return creditOrg;
  }

  public void setCreditOrg(String creditOrg) {
    this.creditOrg = creditOrg;
  }

  public String getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(String utilisateur) {
    this.utilisateur = utilisateur;
  }

  public String getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(String dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

}
