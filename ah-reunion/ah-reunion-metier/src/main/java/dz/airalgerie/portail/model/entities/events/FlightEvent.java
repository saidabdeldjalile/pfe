/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.portail.model.dto.safety.event.FlightEventsStatsDto;
import dz.airalgerie.portail.model.dto.safety.event.FlightEventsStatsRecapDto;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "FLIGHT_EVENT")
@NamedQueries({@NamedQuery(name = "FlightEvent.findAll", query = "SELECT f FROM FlightEvent f")})
@SqlResultSetMapping(name = "FlightEvent.findUserStatsRecap",
    classes = @ConstructorResult(targetClass = FlightEventsStatsDto.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = String.class),
            @ColumnResult(name = "NB_VOLS", type = Integer.class),
            @ColumnResult(name = "NB_EVENTS_TOTAL", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_1", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_2", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_3", type = Integer.class)}))
@SqlResultSetMapping(name = "FlightEvent.findUserStatsRecapTrend",
    classes = @ConstructorResult(targetClass = FlightEventsStatsRecapDto.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = String.class),
            @ColumnResult(name = "NB_EVENTS_TOTAL", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_1", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_2", type = Integer.class),
            @ColumnResult(name = "NB_EVENT_CLASS_3", type = Integer.class),
            @ColumnResult(name = "NB_VOLS_AH", type = Integer.class),
            @ColumnResult(name = "NB_VOLS_PN", type = Integer.class),
            @ColumnResult(name = "TAUX_AH", type = BigDecimal.class),
            @ColumnResult(name = "TAUX_PNT", type = BigDecimal.class)}))
public class FlightEvent implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "CLASS")
  private Integer classe;
  @Size(max = 50)
  @Column(name = "MAX_VALUE")
  private String maxValue;
  @JoinColumns({@JoinColumn(name = "EVENT_ID", referencedColumnName = "ID"),
      @JoinColumn(name = "SECTOR_ID", referencedColumnName = "SECTOR_ID")})
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Event event;
  @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Flight flight;

  public FlightEvent() {
  }

  public FlightEvent(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getClasse() {
    return classe;
  }

  public void setClasse(Integer classe) {
    this.classe = classe;
  }

  public String getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(String maxValue) {
    this.maxValue = maxValue;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FlightEvent)) {
      return false;
    }
    FlightEvent other = (FlightEvent) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.FlightEvent[ id=" + id + " ]";
  }

}
