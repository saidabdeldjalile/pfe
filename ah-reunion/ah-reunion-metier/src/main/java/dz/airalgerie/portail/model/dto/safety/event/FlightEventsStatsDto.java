/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.safety.event;

import java.io.Serializable;

/**
 *
 */
public class FlightEventsStatsDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String dateTrt;
  private Integer nbVols;
  private Integer nbTotalEvents;
  private Integer nbEventsClasse1;
  private Integer nbEventsClasse2;
  private Integer nbEventsClasse3;

  public FlightEventsStatsDto() {
    this.nbVols = 0;
    this.nbTotalEvents = 0;
    this.nbEventsClasse1 = 0;
    this.nbEventsClasse2 = 0;
    this.nbEventsClasse3 = 0;
  }

  public FlightEventsStatsDto(String dateTrt, Integer nbVols, Integer nbTotalEvents,
      Integer nbEventsClasse1, Integer nbEventsClasse2, Integer nbEventsClasse3) {
    this.dateTrt = dateTrt;
    this.nbVols = nbVols;
    this.nbTotalEvents = nbTotalEvents;
    this.nbEventsClasse1 = nbEventsClasse1;
    this.nbEventsClasse2 = nbEventsClasse2;
    this.nbEventsClasse3 = nbEventsClasse3;
  }

  public String getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(String dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Integer getNbVols() {
    return nbVols;
  }

  public void setNbVols(Integer nbVols) {
    this.nbVols = nbVols;
  }

  public Integer getNbTotalEvents() {
    return nbTotalEvents;
  }

  public void setNbTotalEvents(Integer nbTotalEvents) {
    this.nbTotalEvents = nbTotalEvents;
  }

  public Integer getNbEventsClasse1() {
    return nbEventsClasse1;
  }

  public void setNbEventsClasse1(Integer nbEventsClasse1) {
    this.nbEventsClasse1 = nbEventsClasse1;
  }

  public Integer getNbEventsClasse2() {
    return nbEventsClasse2;
  }

  public void setNbEventsClasse2(Integer nbEventsClasse2) {
    this.nbEventsClasse2 = nbEventsClasse2;
  }

  public Integer getNbEventsClasse3() {
    return nbEventsClasse3;
  }

  public void setNbEventsClasse3(Integer nbEventsClasse3) {
    this.nbEventsClasse3 = nbEventsClasse3;
  }

}
