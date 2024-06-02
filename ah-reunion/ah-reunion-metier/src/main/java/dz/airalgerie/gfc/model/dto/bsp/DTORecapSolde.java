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
public class DTORecapSolde {

  private BigDecimal soldeTktt;
  private BigDecimal soldeRfnd;
  private BigDecimal soldeCanx;
  private BigDecimal soldeCann;
  private BigDecimal soldeEmds;
  private BigDecimal soldeEmda;

  public DTORecapSolde() {
  }

  public DTORecapSolde(BigDecimal soldeTktt, BigDecimal soldeRfnd, BigDecimal soldeCanx,
      BigDecimal soldeCann, BigDecimal soldeEmds, BigDecimal soldeEmda) {
    this.soldeTktt = soldeTktt;
    this.soldeRfnd = soldeRfnd;
    this.soldeCanx = soldeCanx;
    this.soldeCann = soldeCann;
    this.soldeEmds = soldeEmds;
    this.soldeEmda = soldeEmda;
  }

  public BigDecimal getSoldeTktt() {
    return soldeTktt;
  }

  public void setSoldeTktt(BigDecimal soldeTktt) {
    this.soldeTktt = soldeTktt;
  }

  public BigDecimal getSoldeRfnd() {
    return soldeRfnd;
  }

  public void setSoldeRfnd(BigDecimal soldeRfnd) {
    this.soldeRfnd = soldeRfnd;
  }

  public BigDecimal getSoldeCanx() {
    return soldeCanx;
  }

  public void setSoldeCanx(BigDecimal soldeCanx) {
    this.soldeCanx = soldeCanx;
  }

  public BigDecimal getSoldeCann() {
    return soldeCann;
  }

  public void setSoldeCann(BigDecimal soldeCann) {
    this.soldeCann = soldeCann;
  }

  public BigDecimal getSoldeEmds() {
    return soldeEmds;
  }

  public void setSoldeEmds(BigDecimal soldeEmds) {
    this.soldeEmds = soldeEmds;
  }

  public BigDecimal getSoldeEmda() {
    return soldeEmda;
  }

  public void setSoldeEmda(BigDecimal soldeEmda) {
    this.soldeEmda = soldeEmda;
  }
}
