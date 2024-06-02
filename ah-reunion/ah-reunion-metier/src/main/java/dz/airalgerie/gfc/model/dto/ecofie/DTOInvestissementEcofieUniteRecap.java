/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ecofie;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author kehli
 */
public class DTOInvestissementEcofieUniteRecap implements Serializable {

  private static final long serialVersionUID = 1L;

  private String designationAnt;
  private Integer quantiteAnt;
  private BigDecimal montantAnt;
  private String designation;
  private Integer quantite;
  private BigDecimal montant;
  private String codeMonnaie;

  public DTOInvestissementEcofieUniteRecap(String designationAnt, Integer quantiteAnt,
      BigDecimal montantAnt, String designation, Integer quantite, BigDecimal montant,
      String codeMonnaie) {
    this.designationAnt = designationAnt;
    this.quantiteAnt = quantiteAnt;
    this.montantAnt = montantAnt;
    this.designation = designation;
    this.quantite = quantite;
    this.montant = montant;
    this.codeMonnaie = codeMonnaie;
  }

  public String getDesignationAnt() {
    return designationAnt;
  }

  public void setDesignationAnt(String designationAnt) {
    this.designationAnt = designationAnt;
  }

  public Integer getQuantiteAnt() {
    return quantiteAnt;
  }

  public void setQuantiteAnt(Integer quantiteAnt) {
    this.quantiteAnt = quantiteAnt;
  }

  public BigDecimal getMontantAnt() {
    return montantAnt;
  }

  public void setMontantAnt(BigDecimal montantAnt) {
    this.montantAnt = montantAnt;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Integer getQuantite() {
    return quantite;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

}
