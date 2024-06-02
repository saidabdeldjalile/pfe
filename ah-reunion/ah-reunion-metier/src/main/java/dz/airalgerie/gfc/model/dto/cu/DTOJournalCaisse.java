/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author kehli
 */
public class DTOJournalCaisse implements Serializable {

  private Integer codeCaisse;
  private Date dateTrt;
  private String libelle;
  private BigDecimal recette;
  private BigDecimal depense;

  public DTOJournalCaisse() {
  }

  public DTOJournalCaisse(Integer codeCaisse, Date dateTrt, String libelle, BigDecimal recette,
      BigDecimal depense) {
    this.codeCaisse = codeCaisse;
    this.dateTrt = dateTrt;
    this.libelle = libelle;
    this.recette = recette;
    this.depense = depense;
  }

  public Integer getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Integer codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public Date getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Date dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getRecette() {
    return recette;
  }

  public void setRecette(BigDecimal recette) {
    this.recette = recette;
  }

  public BigDecimal getDepense() {
    return depense;
  }

  public void setDepense(BigDecimal depense) {
    this.depense = depense;
  }
}
