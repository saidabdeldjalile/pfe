/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.portail.model.entities.fpn.PersonnelAgs;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "CREW")
@NamedQueries({@NamedQuery(name = "Crew.findAll", query = "SELECT c FROM Crew c")})
public class Crew implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 3)
  @Column(name = "POSITION")
  private String position;
  @Column(name = "POSITION_ID")
  private Integer positionId;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs personnel;
  @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Flight flight;

  public Crew() {
  }

  public Crew(Integer id) {
    this.id = id;
  }

  public Crew(Integer id, PersonnelAgs personnel) {
    this.id = id;
    this.personnel = personnel;
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

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getPositionId() {
    return positionId;
  }

  public void setPositionId(Integer positionId) {
    this.positionId = positionId;
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
    if (!(object instanceof Crew)) {
      return false;
    }
    Crew other = (Crew) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.Crew[ id=" + id + " ]";
  }

}
