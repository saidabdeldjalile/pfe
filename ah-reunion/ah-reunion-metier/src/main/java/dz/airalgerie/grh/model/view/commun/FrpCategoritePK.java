/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.view.commun;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DEV
 */
@Embeddable
public class FrpCategoritePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private String dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_TECH")
  private String codeTech;
  @NotNull
  @Column(name = "SALAIRE_BRUT")
  private BigDecimal salaireBrut;

  public FrpCategoritePK() {}

  public FrpCategoritePK(String dateTrt, String codeTech, BigDecimal salaireBrut) {
    this.dateTrt = dateTrt;
    this.codeTech = codeTech;
    this.salaireBrut = salaireBrut;
  }

  // public String getCodeFil() {
  // switch (codeFil) {
  // case "A":
  // codeFil = "AH";
  // break;
  // case "C":
  // codeFil = "CATERING";
  // break;
  // case "G":
  // codeFil = "CARGO";
  // break;
  // }
  // return codeFil;
  // }
  //
  // public void setCodeFil(String codeFil) {
  // this.codeFil = codeFil;
  // }
  public String getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(String dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCodeTech() {
    switch (codeTech) {
      case "C":
        codeTech = "PNC";
        break;
      case "T":
        codeTech = "PNT";
        break;
      case "S":
        codeTech = "SOL";
        break;
    }
    return codeTech;
  }

  public void setCodeTech(String codeTech) {
    this.codeTech = codeTech;
  }

  // public String getCategorite() {
  // return categorite;
  // }
  //
  // public void setCategorite(String categorite) {
  // this.categorite = categorite;
  // }
  public BigDecimal getSalaireBrut() {
    return salaireBrut;
  }

  public void setSalaireBrut(BigDecimal salaireBrut) {
    this.salaireBrut = salaireBrut;
  }

}
