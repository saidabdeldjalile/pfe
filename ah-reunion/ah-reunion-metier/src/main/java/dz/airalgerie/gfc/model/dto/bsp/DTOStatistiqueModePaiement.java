/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.bsp;

import java.math.BigDecimal;

/**
 *
 * @author KEHLI
 */
public class DTOStatistiqueModePaiement {

  private String modePaiement;
  private BigDecimal montantTotalEmis;
  private BigDecimal montantTotalRfnd;

  public DTOStatistiqueModePaiement() {
  }

  public DTOStatistiqueModePaiement(String modePaiement, BigDecimal montantTotalEmis,
      BigDecimal montantTotalRfnd) {
    this.modePaiement = modePaiement;
    this.montantTotalEmis = montantTotalEmis;
    this.montantTotalRfnd = montantTotalRfnd;
  }

  public String getModePaiement() {
    return modePaiement;
  }

  public void setModePaiement(String modePaiement) {
    this.modePaiement = modePaiement;
  }

  public BigDecimal getMontantTotalEmis() {
    return montantTotalEmis;
  }

  public void setMontantTotalEmis(BigDecimal montantTotalEmis) {
    this.montantTotalEmis = montantTotalEmis;
  }

  public BigDecimal getMontantTotalRfnd() {
    return montantTotalRfnd;
  }

  public void setMontantTotalRfnd(BigDecimal montantTotalRfnd) {
    this.montantTotalRfnd = montantTotalRfnd;
  }

}
