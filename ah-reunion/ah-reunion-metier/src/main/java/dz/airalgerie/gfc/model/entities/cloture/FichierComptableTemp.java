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
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "FICHIER_COMPTABLE_T", schema = "dbo")
public class FichierComptableTemp implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "UNITEID")
  private int uniteId;
  @Column(name = "DATECOMPTE")
  private String dateCpt;
  @Column(name = "DATEACQ")
  private String dateAcq;
  @Column(name = "FAMILLEID")
  private String compteScf;
  @Id
  @Column(name = "CODENOM")
  private String codeNomenclature;
  @Column(name = "DESIGNATION")
  private String designation;
  @Column(name = "NUMSER")
  private String numeroSerie;
  @Column(name = "AMORTISSEMENT_MENSUEL")
  private BigDecimal amortissementMensuel;
  @Column(name = "VALEUR")
  private BigDecimal valeurAcq;
  @Column(name = "AMORTISSEMENT_CUMULE")
  private BigDecimal amortissementCumule;

  public FichierComptableTemp() {}

  public FichierComptableTemp(int uniteId, String dateCpt, String dateAcq, String compteScf,
      String codeNomenclature, String disignation, String numeroSerie,
      BigDecimal amortissementMensuel, BigDecimal valeurAcq, BigDecimal amortissementCumule) {
    this.uniteId = uniteId;
    this.dateCpt = dateCpt;
    this.dateAcq = dateAcq;
    this.compteScf = compteScf;
    this.codeNomenclature = codeNomenclature;
    this.designation = disignation;
    this.numeroSerie = numeroSerie;
    this.amortissementMensuel = amortissementMensuel;
    this.valeurAcq = valeurAcq;
    this.amortissementCumule = amortissementCumule;
  }

  public int getUniteId() {
    return uniteId;
  }

  public void setUniteId(int uniteId) {
    this.uniteId = uniteId;
  }

  public String getDateCpt() {
    return dateCpt;
  }

  public void setDateCpt(String dateCpt) {
    this.dateCpt = dateCpt;
  }

  public String getDateAcq() {
    return dateAcq.substring(0, 10);
  }

  public void setDateAcq(String dateAcq) {
    this.dateAcq = dateAcq;
  }

  public String getCompteScf() {
    return compteScf.replace(".0", "");
  }

  public void setCompteScf(String compteScf) {
    this.compteScf = compteScf;
  }

  public String getCodeNomenclature() {
    return codeNomenclature;
  }

  public void setCodeNomenclature(String codeNomenclature) {
    this.codeNomenclature = codeNomenclature;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String disignation) {
    this.designation = disignation;
  }

  public String getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(String numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public BigDecimal getAmortissementMensuel() {
    return amortissementMensuel;
  }

  public void setAmortissementMensuel(BigDecimal amortissementMensuel) {
    this.amortissementMensuel = amortissementMensuel;
  }

  public BigDecimal getValeurAcq() {
    return valeurAcq;
  }

  public void setValeurAcq(BigDecimal valeurAcq) {
    this.valeurAcq = valeurAcq;
  }

  public BigDecimal getAmortissementCumule() {
    return amortissementCumule;
  }

  public void setAmortissementCumule(BigDecimal amortissementCumule) {
    this.amortissementCumule = amortissementCumule;
  }

}
