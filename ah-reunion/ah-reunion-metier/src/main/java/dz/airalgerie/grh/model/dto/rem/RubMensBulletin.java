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
public class RubMensBulletin implements Serializable {

  private BigDecimal Totaux_gains_imposables = BigDecimal.ZERO;
  private BigDecimal Totaux_Gains_non_imposable = BigDecimal.ZERO;
  private BigDecimal Totaux_Retenues_imposables = BigDecimal.ZERO;
  private BigDecimal Totaux_Retenues_non_imposables = BigDecimal.ZERO;
  private BigDecimal Net_fiscal = BigDecimal.ZERO;
  private BigDecimal Total_des_retenues = BigDecimal.ZERO;
  private BigDecimal Trop_perçu = BigDecimal.ZERO;
  private BigDecimal Net_à_payer = BigDecimal.ZERO;
  private BigDecimal salaireBrut = BigDecimal.ZERO;

  public RubMensBulletin() {}

  public BigDecimal getTotaux_gains_imposables() {
    return Totaux_gains_imposables;
  }

  public void setTotaux_gains_imposables(BigDecimal Totaux_gains_imposables) {
    this.Totaux_gains_imposables = Totaux_gains_imposables;
  }

  public BigDecimal getTotaux_Gains_non_imposable() {
    return Totaux_Gains_non_imposable;
  }

  public void setTotaux_Gains_non_imposable(BigDecimal Totaux_Gains_non_imposable) {
    this.Totaux_Gains_non_imposable = Totaux_Gains_non_imposable;
  }

  public BigDecimal getTotaux_Retenues_imposables() {
    return Totaux_Retenues_imposables;
  }

  public void setTotaux_Retenues_imposables(BigDecimal Totaux_Retenues_imposables) {
    this.Totaux_Retenues_imposables = Totaux_Retenues_imposables;
  }

  public BigDecimal getTotaux_Retenues_non_imposables() {
    return Totaux_Retenues_non_imposables;
  }

  public void setTotaux_Retenues_non_imposables(BigDecimal Totaux_Retenues_non_imposables) {
    this.Totaux_Retenues_non_imposables = Totaux_Retenues_non_imposables;
  }

  public BigDecimal getNet_fiscal() {
    return Net_fiscal;
  }

  public void setNet_fiscal(BigDecimal Net_fiscal) {
    this.Net_fiscal = Net_fiscal;
  }

  public BigDecimal getTotal_des_retenues() {
    return Total_des_retenues;
  }

  public void setTotal_des_retenues(BigDecimal Total_des_retenues) {
    this.Total_des_retenues = Total_des_retenues;
  }

  public BigDecimal getTrop_perçu() {
    return Trop_perçu;
  }

  public void setTrop_perçu(BigDecimal Trop_perçu) {
    this.Trop_perçu = Trop_perçu;
  }

  public BigDecimal getNet_à_payer() {
    return Net_à_payer;
  }

  public void setNet_à_payer(BigDecimal Net_à_payer) {
    this.Net_à_payer = Net_à_payer;
  }

  public BigDecimal getSalaireBrut() {
    return salaireBrut;
  }

  public void setSalaireBrut(BigDecimal salaireBrut) {
    this.salaireBrut = salaireBrut;
  }

}
