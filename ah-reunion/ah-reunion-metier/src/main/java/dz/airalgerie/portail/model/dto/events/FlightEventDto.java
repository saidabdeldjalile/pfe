/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.events;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 */
public class FlightEventDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer matricule;
  private String pntTitle;
  private LocalDateTime eventDate;
  private String flightNbr;
  private String escFrom;
  private String escTo;
  private String rwyTo;
  private String rwyLdg;
  private String aircraftRegistration;
  private LocalTime duration;
  private int classe;
  private Integer eventId;
  private String eventShortName;
  private String eventDescription;
  private Integer sectorId;
  private String sectorShortName;

  public FlightEventDto() {
  }

  public FlightEventDto(Integer id, Integer matricule, String pntTitle, LocalDateTime eventDate,
      String flightNbr, String escFrom, String escTo, String rwyTo, String rwyLdg,
      String aircraftRegistration, LocalTime duration, int classe, Integer eventId,
      String eventShortName, String eventDescription) {
    this.id = id;
    this.matricule = matricule;
    this.pntTitle = pntTitle;
    this.eventDate = eventDate;
    this.flightNbr = flightNbr;
    this.escFrom = escFrom;
    this.escTo = escTo;
    this.rwyTo = rwyTo;
    this.rwyLdg = rwyLdg;
    this.aircraftRegistration = aircraftRegistration;
    this.duration = duration;
    this.classe = classe;
    this.eventId = eventId;
    this.eventShortName = eventShortName;
    this.eventDescription = eventDescription;
  }

  public FlightEventDto(Integer id, Integer matricule, String pntTitle, LocalDateTime eventDate,
      String flightNbr, String escFrom, String escTo, String rwyTo, String rwyLdg,
      String aircraftRegistration, LocalTime duration, int classe, Integer eventId,
      String eventShortName, String eventDescription, Integer sectorId, String sectorShortName) {
    this.id = id;
    this.matricule = matricule;
    this.pntTitle = pntTitle;
    this.eventDate = eventDate;
    this.flightNbr = flightNbr;
    this.escFrom = escFrom;
    this.escTo = escTo;
    this.rwyTo = rwyTo;
    this.rwyLdg = rwyLdg;
    this.aircraftRegistration = aircraftRegistration;
    this.duration = duration;
    this.classe = classe;
    this.eventId = eventId;
    this.eventShortName = eventShortName;
    this.eventDescription = eventDescription;
    this.sectorId = sectorId;
    this.sectorShortName = sectorShortName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getPntTitle() {
    return pntTitle;
  }

  public void setPntTitle(String pntTitle) {
    this.pntTitle = pntTitle;
  }

  public LocalDateTime getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
  }

  public String getFlightNbr() {
    return flightNbr;
  }

  public void setFlightNbr(String flightNbr) {
    this.flightNbr = flightNbr;
  }

  public String getEscFrom() {
    return escFrom;
  }

  public void setEscFrom(String escFrom) {
    this.escFrom = escFrom;
  }

  public String getEscTo() {
    return escTo;
  }

  public void setEscTo(String escTo) {
    this.escTo = escTo;
  }

  public String getRwyTo() {
    return rwyTo;
  }

  public void setRwyTo(String rwyTo) {
    this.rwyTo = rwyTo;
  }

  public String getRwyLdg() {
    return rwyLdg;
  }

  public void setRwyLdg(String rwyLdg) {
    this.rwyLdg = rwyLdg;
  }

  public String getAircraftRegistration() {
    return aircraftRegistration;
  }

  public void setAircraftRegistration(String aircraftRegistration) {
    this.aircraftRegistration = aircraftRegistration;
  }

  public LocalTime getDuration() {
    return duration;
  }

  public void setDuration(LocalTime duration) {
    this.duration = duration;
  }

  public int getClasse() {
    return classe;
  }

  public void setClasse(int classe) {
    this.classe = classe;
  }

  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  public String getEventShortName() {
    return eventShortName;
  }

  public void setEventShortName(String eventShortName) {
    this.eventShortName = eventShortName;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public Integer getSectorId() {
    return sectorId;
  }

  public void setSectorId(Integer sectorId) {
    this.sectorId = sectorId;
  }

  public String getSectorShortName() {
    return sectorShortName;
  }

  public void setSectorShortName(String sectorShortName) {
    this.sectorShortName = sectorShortName;
  }


}
