/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.safety.event;

import java.io.Serializable;

/**
 *
 */
public class FlightEventsTopStatsDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer eventId;
  private String eventName;
  private Integer nbTotalEvents;

  public FlightEventsTopStatsDto() {
  }

  public FlightEventsTopStatsDto(Integer eventId, String eventName, Integer nbTotalEvents) {
    this.eventId = eventId;
    this.eventName = eventName;
    this.nbTotalEvents = nbTotalEvents;
  }

  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Integer getNbTotalEvents() {
    return nbTotalEvents;
  }

  public void setNbTotalEvents(Integer nbTotalEvents) {
    this.nbTotalEvents = nbTotalEvents;
  }

}
