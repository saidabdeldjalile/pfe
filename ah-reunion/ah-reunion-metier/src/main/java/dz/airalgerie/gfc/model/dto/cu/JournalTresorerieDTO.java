/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.dto.cu;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
public class JournalTresorerieDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer codeJournal;
  private String typeJournal;
  private String libelle;
  private Integer idStructure;
  private String libelleStructure;
  private BigDecimal debit;
  private BigDecimal credit;
  private BigDecimal solde;
  private BigDecimal oldSolde;
  private BigDecimal newSolde;

  public JournalTresorerieDTO() {
  }

  public JournalTresorerieDTO(Integer codeJournal, String typeJournal, String libelle,
      Integer idStructure, String libelleStructure, BigDecimal debit, BigDecimal credit,
      BigDecimal solde, BigDecimal oldSolde, BigDecimal newSolde) {
    this.codeJournal = codeJournal;
    this.typeJournal = typeJournal;
    this.libelle = libelle;
    this.idStructure = idStructure;
    this.libelleStructure = libelleStructure;
    this.debit = debit;
    this.credit = credit;
    this.solde = solde;
    this.oldSolde = oldSolde;
    this.newSolde = newSolde;
  }

  public Integer getCodeJournal() {
    return codeJournal;
  }

  public void setCodeJournal(Integer codeJournal) {
    this.codeJournal = codeJournal;
  }

  public String getTypeJournal() {
    return typeJournal;
  }

  public void setTypeJournal(String typeJournal) {
    this.typeJournal = typeJournal;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Integer getIdStructure() {
    return idStructure;
  }

  public void setIdStructure(Integer idStructure) {
    this.idStructure = idStructure;
  }

  public String getLibelleStructure() {
    return libelleStructure;
  }

  public void setLibelleStructure(String libelleStructure) {
    this.libelleStructure = libelleStructure;
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

  public BigDecimal getSolde() {
    return solde;
  }

  public void setSolde(BigDecimal solde) {
    this.solde = solde;
  }

  public BigDecimal getOldSolde() {
    return oldSolde;
  }

  public void setOldSolde(BigDecimal oldSolde) {
    this.oldSolde = oldSolde;
  }

  public BigDecimal getNewSolde() {
    return newSolde;
  }

  public void setNewSolde(BigDecimal newSolde) {
    this.newSolde = newSolde;
  }

}
