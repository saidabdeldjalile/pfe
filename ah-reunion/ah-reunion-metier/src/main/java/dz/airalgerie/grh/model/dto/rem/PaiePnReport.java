/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.rem;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Administrateur
 */
public class PaiePnReport extends PaieBaseReport implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String codeTech;
  protected Integer datePaie;
  protected BigDecimal presence;
  protected BigDecimal conge;
  protected BigDecimal cumul;
  protected BigDecimal hvLigne;

  public PaiePnReport() {}

  public PaiePnReport(Integer matricule, String nom, String grpChap, String codeTech,
      Integer datePaie, BigDecimal presence, BigDecimal conge, BigDecimal cumul,
      BigDecimal hvLigne) {
    super(matricule, nom, grpChap);
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.presence = presence;
    this.conge = conge;
    this.cumul = cumul;
    this.hvLigne = hvLigne;
  }

  public String getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(String codeTech) {
    this.codeTech = codeTech;
  }

  public Integer getDatePaie() {
    return datePaie;
  }

  public void setDatePaie(Integer datePaie) {
    this.datePaie = datePaie;
  }

  public BigDecimal getPresence() {
    return presence;
  }

  public void setPresence(BigDecimal presence) {
    this.presence = presence;
  }

  public BigDecimal getConge() {
    return conge;
  }

  public void setConge(BigDecimal conge) {
    this.conge = conge;
  }

  public BigDecimal getCumul() {
    return cumul;
  }

  public void setCumul(BigDecimal cumul) {
    this.cumul = cumul;
  }

  public BigDecimal getHvLigne() {
    return hvLigne;
  }

  public void setHvLigne(BigDecimal hvLigne) {
    this.hvLigne = hvLigne;
  }

}
