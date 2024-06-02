/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.bsp;

import java.io.Serializable;

/**
 *
 * @author KEHLI
 */
public class DTORecapCpature implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer totalTktt;
  private Integer totalEmds;
  private Integer totalEmda;
  private Integer totalCanx;
  private Integer totalCann;
  private Integer totalRfnd;

  public DTORecapCpature() {
  }

  public int getTotalTktt() {
    return totalTktt;
  }

  public DTORecapCpature(Integer totalTktt, Integer totalEmds, Integer totalEmda, Integer totalCanx,
      Integer totalCann, Integer totalRfnd) {
    this.totalTktt = totalTktt;
    this.totalEmds = totalEmds;
    this.totalEmda = totalEmda;
    this.totalCanx = totalCanx;
    this.totalCann = totalCann;
    this.totalRfnd = totalRfnd;
  }

  public void setTotalTktt(Integer totalTktt) {
    this.totalTktt = totalTktt;
  }

  public int getTotalEmds() {
    return totalEmds;
  }

  public void setTotalEmds(Integer totalEmds) {
    this.totalEmds = totalEmds;
  }

  public int getTotalEmda() {
    return totalEmda;
  }

  public void setTotalEmda(Integer totalEmda) {
    this.totalEmda = totalEmda;
  }

  public int getTotalCanx() {
    return totalCanx;
  }

  public void setTotalCanx(Integer totalCanx) {
    this.totalCanx = totalCanx;
  }

  public int getTotalCann() {
    return totalCann;
  }

  public void setTotalCann(Integer totalCann) {
    this.totalCann = totalCann;
  }

  public int getTotalRfnd() {
    return totalRfnd;
  }

  public void setTotalRfnd(Integer totalRfnd) {
    this.totalRfnd = totalRfnd;
  }

}
