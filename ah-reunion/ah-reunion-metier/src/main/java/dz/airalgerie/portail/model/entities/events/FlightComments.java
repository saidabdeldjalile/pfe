/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.portail.model.entities.fpn.PersonnelAgs;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "FLIGHT_COMMENTS")
@NamedQueries({
    @NamedQuery(name = "FlightComments.findAll", query = "SELECT f FROM FlightComments f")})
public class FlightComments implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @NotNull
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs personnel;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 2147483647)
  @Column(name = "MESSAGE")
  private String message;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Flight flight;
  @OneToMany(mappedBy = "flightComments", fetch = FetchType.LAZY)
  private List<FlightComments> flightCommentsList;
  @JoinColumn(name = "FLIGHT_COMMENT_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private FlightComments flightComments;

  public FlightComments() {
  }

  public FlightComments(Integer id) {
    this.id = id;
  }

  public FlightComments(Integer id, PersonnelAgs personnel, String message,
      LocalDateTime createdAt) {
    this.id = id;
    this.personnel = personnel;
    this.message = message;
    this.createdAt = createdAt;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonnelAgs getPersonnel() {
    return personnel;
  }

  public void setPersonnel(PersonnelAgs personnel) {
    this.personnel = personnel;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public List<FlightComments> getFlightCommentsList() {
    return flightCommentsList;
  }

  public void setFlightCommentsList(List<FlightComments> flightCommentsList) {
    this.flightCommentsList = flightCommentsList;
  }

  public FlightComments getFlightComments() {
    return flightComments;
  }

  public void setFlightComments(FlightComments flightComments) {
    this.flightComments = flightComments;
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
    if (!(object instanceof FlightComments)) {
      return false;
    }
    FlightComments other = (FlightComments) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.FlightComments[ id=" + id + " ]";
  }

}
