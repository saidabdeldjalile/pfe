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
public class PaieRubsReport implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer matricule;
  private String nom;
  private Integer dateTrt;
  private Integer datePaie;
  private String codePaie;
  private String grpChap;
  private String codeTech;
  private String fonction;
  private String codeRub;
  private String sens;
  private BigDecimal valUnite;
  private BigDecimal valBase;
  private BigDecimal valMontant;

  public PaieRubsReport() {}

  public PaieRubsReport(Integer id, Integer matricule, String nom, Integer dateTrt,
      Integer datePaie, String codePaie, String grpChap, String codeTech, String fonction,
      String codeRub, String sens, BigDecimal valUnite, BigDecimal valBase, BigDecimal valMontant) {
    this.id = id;
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
    this.grpChap = grpChap;
    this.codeTech = codeTech;
    this.fonction = fonction;
    this.codeRub = codeRub;
    this.sens = sens;
    this.valUnite = valUnite;
    this.valBase = valBase;
    this.valMontant = valMontant;
  }

  public PaieRubsReport(Integer id, Integer matricule, String nom, Integer datePaie,
      String codePaie, String grpChap, String codeTech, String fonction, String codeRub,
      String sens, BigDecimal valUnite, BigDecimal valBase, BigDecimal valMontant) {
    this.id = id;
    this.matricule = matricule;
    this.nom = nom;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
    this.grpChap = grpChap;
    this.codeTech = codeTech;
    this.fonction = fonction;
    this.codeRub = codeRub;
    this.sens = sens;
    this.valUnite = valUnite;
    this.valBase = valBase;
    this.valMontant = valMontant;
  }

  public PaieRubsReport(Integer matricule, String nom, Integer dateTrt, Integer datePaie,
      String codePaie, String grpChap, String codeTech, String fonction, String codeRub,
      String sens, BigDecimal valUnite, BigDecimal valBase, BigDecimal valMontant) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.grpChap = grpChap;
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
    this.fonction = fonction;
    this.codeRub = codeRub;
    this.sens = sens;
    this.valUnite = valUnite;
    this.valBase = valBase;
    this.valMontant = valMontant;
  }

  public PaieRubsReport(String codeTech, Integer dateTrt, Integer datePaie, String codePaie,
      Integer matricule, String nom, String grpChap) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.grpChap = grpChap;
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
  }

  public PaieRubsReport(String codeTech, Integer datePaie, String codePaie) {
    this.codeTech = codeTech;
    this.datePaie = datePaie;
    this.codePaie = codePaie;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
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

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public String getSens() {
    return sens;
  }

  public void setSens(String sens) {
    this.sens = sens;
  }

  public BigDecimal getValUnite() {
    return valUnite;
  }

  public void setValUnite(BigDecimal valUnite) {
    this.valUnite = valUnite;
  }

  public BigDecimal getValBase() {
    return valBase;
  }

  public void setValBase(BigDecimal valBase) {
    this.valBase = valBase;
  }

  public BigDecimal getValMontant() {
    return valMontant;
  }

  public void setValMontant(BigDecimal valMontant) {
    this.valMontant = valMontant;
  }

}
