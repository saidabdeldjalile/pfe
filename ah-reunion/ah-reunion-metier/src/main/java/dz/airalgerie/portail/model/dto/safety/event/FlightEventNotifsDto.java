/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.safety.event;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 */
public class FlightEventNotifsDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer sectorId;
  private String sectorName;
  private LocalDateTime flightDate;
  private String flightNbr;
  private String dep;
  private String arr;
  private String aircraft;
  private Integer pilote;
  private String position;
  private Integer severite;
  private Integer nbEvents;
  private boolean isRead;

  public FlightEventNotifsDto() {
  }

  public FlightEventNotifsDto(Integer id, Integer sectorId, String sectorName, LocalDateTime flightDate,
      String flightNbr, String dep, String arr, String aircraft, Integer pilote, String position,
      Integer severite, Integer nbEvents, boolean isRead) {
    this.id = id;
    this.sectorId = sectorId;
    this.sectorName = sectorName;
    this.flightDate = flightDate;
    this.flightNbr = flightNbr;
    this.dep = dep;
    this.arr = arr;
    this.aircraft = aircraft;
    this.pilote = pilote;
    this.position = position;
    this.severite = severite;
    this.nbEvents = nbEvents;
    this.isRead = isRead;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSectorId() {
    return sectorId;
  }

  public void setSectorId(Integer sectorId) {
    this.sectorId = sectorId;
  }

  public String getSectorName() {
    return sectorName;
  }

  public void setSectorName(String sectorName) {
    this.sectorName = sectorName;
  }

  public LocalDateTime getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(LocalDateTime flightDate) {
    this.flightDate = flightDate;
  }

  public String getFlightNbr() {
    return flightNbr;
  }

  public void setFlightNbr(String flightNbr) {
    this.flightNbr = flightNbr;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getArr() {
    return arr;
  }

  public void setArr(String arr) {
    this.arr = arr;
  }

  public String getAircraft() {
    return aircraft;
  }

  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  public Integer getPilote() {
    return pilote;
  }

  public void setPilote(Integer pilote) {
    this.pilote = pilote;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getSeverite() {
    return severite;
  }

  public void setSeverite(Integer severite) {
    this.severite = severite;
  }

  public Integer getNbEvents() {
    return nbEvents;
  }

  public void setNbEvents(Integer nbEvents) {
    this.nbEvents = nbEvents;
  }

  public boolean isIsRead() {
    return isRead;
  }

  public void setIsRead(boolean isRead) {
    this.isRead = isRead;
  }

}
