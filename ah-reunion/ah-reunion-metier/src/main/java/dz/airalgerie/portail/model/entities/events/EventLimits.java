/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "EVENT_LIMITS")
@NamedQueries({@NamedQuery(name = "EventLimits.findAll", query = "SELECT e FROM EventLimits e")})
public class EventLimits implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "LIMIT1")
  private String limit1;
  @Size(max = 50)
  @Column(name = "LIMIT2")
  private String limit2;
  @Size(max = 50)
  @Column(name = "LIMIT3")
  private String limit3;
  @Basic(optional = false)
  @NotNull
  @Column(name = "START_DATE")
  private LocalDate startDate;
  @Column(name = "END_DATE")
  private LocalDate endDate;
  @JoinColumns({@JoinColumn(name = "EVENT_ID", referencedColumnName = "ID"),
      @JoinColumn(name = "SECTOR_ID", referencedColumnName = "SECTOR_ID")})
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Event event;

  public EventLimits() {
  }

  public EventLimits(Integer id) {
    this.id = id;
  }

  public EventLimits(Integer id, LocalDate startDate) {
    this.id = id;
    this.startDate = startDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLimit1() {
    return limit1;
  }

  public void setLimit1(String limit1) {
    this.limit1 = limit1;
  }

  public String getLimit2() {
    return limit2;
  }

  public void setLimit2(String limit2) {
    this.limit2 = limit2;
  }

  public String getLimit3() {
    return limit3;
  }

  public void setLimit3(String limit3) {
    this.limit3 = limit3;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
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
    if (!(object instanceof EventLimits)) {
      return false;
    }
    EventLimits other = (EventLimits) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.EventLimits[ id=" + id + " ]";
  }

}
