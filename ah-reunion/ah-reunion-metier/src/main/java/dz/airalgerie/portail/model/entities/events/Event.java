/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "EVENT")
@NamedQueries({@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")})
public class Event implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EventPK eventPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "SHORT_NAME")
  private String shortName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "DESCRIPTION")
  private String description;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DELETED")
  private boolean deleted;
  @OrderBy(value = "endDate DESC, id DESC")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
  private List<EventLimits> eventLimitsList;
  @JoinColumn(name = "SECTOR_ID", referencedColumnName = "ID", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Sector sector;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
  private List<FlightEvent> flightEventList;

  public Event() {
  }

  public Event(EventPK eventPK) {
    this.eventPK = eventPK;
  }

  public Event(EventPK eventPK, String shortName, String description, boolean deleted) {
    this.eventPK = eventPK;
    this.shortName = shortName;
    this.description = description;
    this.deleted = deleted;
  }

  public Event(int id, int sectorId) {
    this.eventPK = new EventPK(id, sectorId);
  }

  /**
   * Permet d'ajouter une limite à un évènement.
   * 
   * @param limit Limite à ajouter
   */
  public void addLimit(EventLimits limit) {
    if (this.getEventLimitsList() != null && !this.getEventLimitsList().isEmpty()) {
      EventLimits lastLimit = this.getEventLimitsList().get(0);

      // Replacer la limite dans la chronologie.
      // Si dateFin < date Début alors dateFin = dateDébut
      if (lastLimit.getStartDate().isAfter(LocalDate.now().minusDays(1))) {
        lastLimit.setEndDate(lastLimit.getStartDate());
      } else {
        lastLimit.setEndDate(LocalDate.now().minusDays(1));
      }
    } else {
      this.setEventLimitsList(new ArrayList<>());
    }
    this.getEventLimitsList().add(0, limit);
  }

  /**
   * Permet de supprimer une limite d'un évènement.
   * 
   * @param limit Limite à supprimer.
   */
  public void deleteLimit(EventLimits limit) {
    this.getEventLimitsList().remove(limit);
    // Replacer le dernier élément à la tête de la chronologie
    if (this.getEventLimitsList() != null && !this.getEventLimitsList().isEmpty()) {
      this.getEventLimitsList().get(0).setEndDate(LocalDate.of(2100, 12, 31));
    }
  }

  public EventPK getEventPK() {
    return eventPK;
  }

  public void setEventPK(EventPK eventPK) {
    this.eventPK = eventPK;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public List<EventLimits> getEventLimitsList() {
    return eventLimitsList;
  }

  public void setEventLimitsList(List<EventLimits> eventLimitsList) {
    this.eventLimitsList = eventLimitsList;
  }

  public Sector getSector() {
    return sector;
  }

  public void setSector(Sector sector) {
    this.sector = sector;
  }

  public List<FlightEvent> getFlightEventList() {
    return flightEventList;
  }

  public void setFlightEventList(List<FlightEvent> flightEventList) {
    this.flightEventList = flightEventList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (eventPK != null ? eventPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Event)) {
      return false;
    }
    Event other = (Event) object;
    if ((this.eventPK == null && other.eventPK != null)
        || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.Event[ eventPK=" + eventPK + " ]";
  }

}
