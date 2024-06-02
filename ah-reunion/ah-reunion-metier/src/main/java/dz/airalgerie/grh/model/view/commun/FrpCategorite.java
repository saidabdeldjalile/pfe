/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.view.commun;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author DEV
 */
@Entity
@Table(name = "CATEGORIE", schema = "T_BP")
public class FrpCategorite implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  protected FrpCategoritePK frpCategoritePK;

  @Column(name = "CODE_FIL")
  private String codeFil;

  @Column(name = "CATEGORIE")
  private String categorite;

  @Column(name = "NOMBRE_PAIE")
  private String nombrePaie;

  @Column(name = "NOMBRE_PERSONNE")
  private String nombrePersonne;

  @Column(name = "SALAIRE_BASE")
  private String salaireBase;

  @Column(name = "ACTIVITE")
  private String activite;

  @Column(name = "NB_JR_HR")
  private BigDecimal nbJrHr;

  @Column(name = "SALAIRE_POSTE")
  private BigDecimal salairePoste;

  @Column(name = "TOTAL_CHRGE")
  private BigDecimal totalChrge;

  @Column(name = "CAT")
  private String cat;

  public FrpCategoritePK getFrpCategoritePK() {
    return frpCategoritePK;
  }

  public void setFrpCategoritePK(FrpCategoritePK frpCategoritePK) {
    this.frpCategoritePK = frpCategoritePK;
  }

  public FrpCategorite(FrpCategoritePK frpCategoritePK) {
    this.frpCategoritePK = frpCategoritePK;
  }

  public FrpCategorite() {

  }

  public FrpCategorite(String dateTrt, String codeTech, BigDecimal salaireBrut) {
    this.frpCategoritePK = new FrpCategoritePK(dateTrt, codeTech, salaireBrut);
  }

  public String getCodeFil() {
    switch (codeFil) {
      case "A":
        codeFil = "AH";
        break;
      case "C":
        codeFil = "CATERING";
        break;
      case "G":
        codeFil = "CARGO";
        break;
    }
    return codeFil;
  }

  //
  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
  }

  public String getCategorite() {
    return categorite;
  }

  //
  public void setCategorite(String categorie) {
    this.categorite = categorie;
  }

  public String getNombrePaie() {
    return nombrePaie;
  }

  public void setNombrePaie(String nombrePaie) {
    this.nombrePaie = nombrePaie;
  }

  public String getNombrePersonne() {
    return nombrePersonne;
  }

  public void setNombrePersonne(String nombrePersonne) {
    this.nombrePersonne = nombrePersonne;
  }

  public String getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(String salaireBase) {
    this.salaireBase = salaireBase;
  }

  public String getActivite() {
    return activite;
  }

  public void setActivite(String activite) {
    this.activite = activite;
  }

  public BigDecimal getNbJrHr() {
    return nbJrHr;
  }

  public void setNbJrHr(BigDecimal nbJrHr) {
    this.nbJrHr = nbJrHr;
  }

  public BigDecimal getSalairePoste() {
    return salairePoste;
  }

  public void setSalairePoste(BigDecimal salairePoste) {
    this.salairePoste = salairePoste;
  }

  public BigDecimal getTotalChrge() {
    return totalChrge;
  }

  public void setTotalChrge(BigDecimal totalChrge) {
    this.totalChrge = totalChrge;
  }

  public String getCat() {
    return cat;
  }

  public void setCat(String cat) {
    this.cat = cat;
  }

}
