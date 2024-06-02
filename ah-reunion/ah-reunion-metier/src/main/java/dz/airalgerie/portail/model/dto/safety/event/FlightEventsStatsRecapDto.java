/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.safety.event;

import java.math.BigDecimal;

/**
 *
 */
public class FlightEventsStatsRecapDto extends FlightEventsStatsDto {

  private static final long serialVersionUID = 1L;

  private Integer nbVolsAh;
  private BigDecimal tauxAh;
  private BigDecimal tauxPn;

  public FlightEventsStatsRecapDto() {
    super();
    this.nbVolsAh = 0;
    this.tauxAh = BigDecimal.ZERO;
    this.tauxPn = BigDecimal.ZERO;
  }

  public FlightEventsStatsRecapDto(String dateTrt, Integer nbTotalEvents, Integer nbEventsClasse1,
      Integer nbEventsClasse2, Integer nbEventsClasse3, Integer nbVolsAh, Integer nbVols,
      BigDecimal tauxAh, BigDecimal tauxPn) {
    super(dateTrt, nbVols, nbTotalEvents, nbEventsClasse1, nbEventsClasse2, nbEventsClasse3);
    this.nbVolsAh = nbVolsAh;
    this.tauxAh = tauxAh;
    this.tauxPn = tauxPn;
  }

  public Integer getNbVolsAh() {
    return nbVolsAh;
  }

  public void setNbVolsAh(Integer nbVolsAh) {
    this.nbVolsAh = nbVolsAh;
  }

  public BigDecimal getTauxAh() {
    return tauxAh;
  }

  public void setTauxAh(BigDecimal tauxAh) {
    this.tauxAh = tauxAh;
  }

  public BigDecimal getTauxPn() {
    return tauxPn;
  }

  public void setTauxPn(BigDecimal tauxPn) {
    this.tauxPn = tauxPn;
  }
}
