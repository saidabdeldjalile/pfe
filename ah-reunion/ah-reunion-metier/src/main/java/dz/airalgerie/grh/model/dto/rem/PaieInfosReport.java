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
public class PaieInfosReport extends PaieBaseReport implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String codeTech;
  protected Integer datePaie;
  protected String codePaie;
  protected String fonction;
  protected BigDecimal netAPayer;

  public PaieInfosReport() {}

  public PaieInfosReport(Integer matricule, String nom, Integer datePaie, String codePaie,
      String grpChap, String codeTech, String fonction, BigDecimal netAPayer) {
    super(matricule, nom, grpChap);
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
    this.fonction = fonction;
    this.netAPayer = netAPayer;
  }

  public PaieInfosReport(String codeTech, Integer datePaie, String codePaie, Integer matricule,
      String nom, String grpChap) {
    super(matricule, nom, grpChap);
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
  }

  public PaieInfosReport(String codeTech, Integer datePaie, String codePaie) {
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
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

  public String getCodePaie() {
    return codePaie;
  }

  public void setCodePaie(String codePaie) {
    this.codePaie = codePaie;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public BigDecimal getNetAPayer() {
    return netAPayer;
  }

  public void setNetAPayer(BigDecimal netAPayer) {
    this.netAPayer = netAPayer;
  }

}
