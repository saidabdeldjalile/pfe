/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cg;

import dz.airalgerie.gfc.model.entities.cg.Journal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrateur
 */
public class EcritureJournal implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer orderId;
  private String cptUnite;
  private int dateTrt;
  private Date dateOperation;
  private String cptComptable;
  private String libelle;
  private int typeOperation = 1; // 1 = Débit ; 2 = Crédit
  private BigDecimal montant;
  private BigDecimal debit;
  private BigDecimal credit;
  private String codeMonnaie;
  private String numPiece;
  private String numPage;
  private String numJournal;
  private String codeApplication;
  private Boolean isSaisie;
  private Integer utilisateur;
  private Date dateSaisie;

  public EcritureJournal() {}

  public EcritureJournal(Integer id, Integer orderId, String cptUnite, int dateTrt,
      Date dateOperation, String cptComptable, String libelle, BigDecimal debit, BigDecimal credit,
      String codeMonnaie, String numPiece, String numPage, String numJournal,
      String codeApplication, Boolean isSaisie, Integer utilisateur, Date dateSaisie) {
    this.id = id;
    this.orderId = orderId;
    this.cptUnite = cptUnite;
    this.dateTrt = dateTrt;
    this.dateOperation = dateOperation;
    this.cptComptable = cptComptable;
    this.libelle = libelle;
    this.debit = debit;
    this.credit = credit;
    this.codeMonnaie = codeMonnaie;
    this.numPiece = numPiece;
    this.numPage = numPage;
    this.numJournal = numJournal;
    this.codeApplication = codeApplication;
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
    this.dateSaisie = dateSaisie;
  }

  public Journal toJournal() {
    this.changerSigne();

    String cptGrl = cptComptable.split(" - ")[0].substring(0, 6);
    String cptPrtl = cptComptable.split(" - ")[0].substring(6);

    if (numPage.equals("noPage")) {
      numPage = null;
    }
    String refactoredCodeMonnaie =
        ("00" + this.codeMonnaie).substring(("00" + this.codeMonnaie).length() - 3);
    return new Journal(id, orderId, cptUnite, dateTrt, dateOperation, cptGrl, cptPrtl, libelle,
        debit, credit, refactoredCodeMonnaie, numPiece, numPage, numJournal, codeApplication,
        isSaisie, utilisateur, dateSaisie);
  }

  public void changerSigne() {
    if (typeOperation == 1) {
      this.debit = montant;
      this.credit = BigDecimal.ZERO;
    } else if (typeOperation == 2) {
      this.debit = BigDecimal.ZERO;
      this.credit = montant;
    }
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Date getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(Date dateOperation) {
    this.dateOperation = dateOperation;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public int getTypeOperation() {
    return typeOperation;
  }

  public void setTypeOperation(int typeOperation) {
    this.typeOperation = typeOperation;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
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

  public Boolean getIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(Boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  public Integer getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(Integer utilisateur) {
    this.utilisateur = utilisateur;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getCptComptable() {
    return cptComptable;
  }

  public void setCptComptable(String cptComptable) {
    this.cptComptable = cptComptable;
  }

}
