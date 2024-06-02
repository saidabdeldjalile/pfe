/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author KEHLI Moussab Amine
 */
@Entity
public class Glv1245 implements Serializable {

  @Column(name = "ID")
  @Id
  private Long id;

  @Column(name = "CPT_SCF")
  private String cptScf;

  @Column(name = "CPT_PART")
  private String cptPart;

  @Column(name = "INTITULE")
  private String intitule;

  @Column(name = "DEBIT_ANT")
  private BigDecimal debitAnt;

  @Column(name = "CREDIT_ANT")
  private BigDecimal creditAnt;

  @Column(name = "SOLDE_ANT")
  private BigDecimal soldeAnt;

  @Column(name = "SENS_ANT")
  private String sensAnt;

  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;

  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;

  @Column(name = "DEBIT_ANT_MM")
  private BigDecimal debitAntMm;

  @Column(name = "CREDIT_ANT_MM")
  private BigDecimal creditAntMm;

  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal soldeAntMm;

  @Column(name = "SENS_ANT_MM")
  private String sensAntMm;

  @Column(name = "MOIS")
  private int mois;

  @Column(name = "ANNEE")
  private int annee;

  @Column(name = "NUM_JOURNAL")
  private String numJournal;

  @Column(name = "NUM_PAGE")
  private String numPage;

  @Column(name = "NUM_PIECE")
  private String numPiece;

  @Column(name = "LIBELLE")
  private String libelle;

  @Column(name = "DEBIT")
  private BigDecimal debit;

  @Column(name = "CREDIT")
  private BigDecimal credit;

  public Glv1245() {
  }

  public Glv1245(Long id, String cptScf, String cptPart, String intitule, BigDecimal debitAnt,
      BigDecimal creditAnt, BigDecimal soldeAnt, String sensAnt, BigDecimal debitMm,
      BigDecimal creditMm, BigDecimal debitAntMm, BigDecimal creditAntMm, BigDecimal soldeAntMm,
      String sensAntMm, int mois, int annee, String numJournal, String numPage, String numPiece,
      String libelle, BigDecimal debit, BigDecimal credit) {
    this.id = id;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
    this.intitule = intitule;
    this.debitAnt = debitAnt;
    this.creditAnt = creditAnt;
    this.soldeAnt = soldeAnt;
    this.sensAnt = sensAnt;
    this.debitMm = debitMm;
    this.creditMm = creditMm;
    this.debitAntMm = debitAntMm;
    this.creditAntMm = creditAntMm;
    this.soldeAntMm = soldeAntMm;
    this.sensAntMm = sensAntMm;
    this.mois = mois;
    this.annee = annee;
    this.numJournal = numJournal;
    this.numPage = numPage;
    this.numPiece = numPiece;
    this.libelle = libelle;
    this.debit = debit;
    this.credit = credit;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public BigDecimal getDebitAnt() {
    return debitAnt;
  }

  public void setDebitAnt(BigDecimal debitAnt) {
    this.debitAnt = debitAnt;
  }

  public BigDecimal getCreditAnt() {
    return creditAnt;
  }

  public void setCreditAnt(BigDecimal creditAnt) {
    this.creditAnt = creditAnt;
  }

  public BigDecimal getSoldeAnt() {
    return soldeAnt;
  }

  public void setSoldeAnt(BigDecimal soldeAnt) {
    this.soldeAnt = soldeAnt;
  }

  public String getSensAnt() {
    return sensAnt;
  }

  public void setSensAnt(String sensAnt) {
    this.sensAnt = sensAnt;
  }

  public BigDecimal getDebitMm() {
    return debitMm;
  }

  public void setDebitMm(BigDecimal debitMm) {
    this.debitMm = debitMm;
  }

  public BigDecimal getCreditMm() {
    return creditMm;
  }

  public void setCreditMm(BigDecimal creditMm) {
    this.creditMm = creditMm;
  }

  public BigDecimal getDebitAntMm() {
    return debitAntMm;
  }

  public void setDebitAntMm(BigDecimal debitAntMm) {
    this.debitAntMm = debitAntMm;
  }

  public BigDecimal getCreditAntMm() {
    return creditAntMm;
  }

  public void setCreditAntMm(BigDecimal creditAntMm) {
    this.creditAntMm = creditAntMm;
  }

  public BigDecimal getSoldeAntMm() {
    return soldeAntMm;
  }

  public void setSoldeAntMm(BigDecimal soldeAntMm) {
    this.soldeAntMm = soldeAntMm;
  }

  public String getSensAntMm() {
    return sensAntMm;
  }

  public void setSensAntMm(String sensAntMm) {
    this.sensAntMm = sensAntMm;
  }

  public int getMois() {
    return mois;
  }

  public void setMois(int mois) {
    this.mois = mois;
  }

  public int getAnnee() {
    return annee;
  }

  public void setAnnee(int annee) {
    this.annee = annee;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getNumPage() {
    return numPage;
  }

  public void setNumPage(String numPage) {
    this.numPage = numPage;
  }

  public String getNumPiece() {
    return numPiece;
  }

  public void setNumPiece(String numPiece) {
    this.numPiece = numPiece;
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
}
