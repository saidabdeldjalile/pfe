/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.portail.model.dto.safety.event.FlightEventNotifsDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "FLIGHT")
@NamedQueries({@NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")})
@SqlResultSetMapping(name = "FlightEvent.findRecapView",
    classes = @ConstructorResult(targetClass = FlightEventNotifsDto.class,
        columns = {@ColumnResult(name = "ID", type = int.class),
            @ColumnResult(name = "SECTOR_ID", type = int.class),
            @ColumnResult(name = "SECTOR_NAME", type = String.class),
            @ColumnResult(name = "FLT_DATE", type = LocalDateTime.class),
            @ColumnResult(name = "FLT", type = String.class),
            @ColumnResult(name = "DEP", type = String.class),
            @ColumnResult(name = "ARR", type = String.class),
            @ColumnResult(name = "AIRCRAFT", type = String.class),
            @ColumnResult(name = "PILOTE", type = Integer.class),
            @ColumnResult(name = "POSITION", type = String.class),
            @ColumnResult(name = "SEVERITE", type = Integer.class),
            @ColumnResult(name = "NB_EVENTS", type = Integer.class),
            @ColumnResult(name = "IS_READ", type = boolean.class)}))
public class Flight implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "FLT_DATE")
  private LocalDateTime fltDate;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "FLT")
  private String flt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "DEP")
  private String dep;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "ARR")
  private String arr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "RWY_TO")
  private String rwyTo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "RWY_LDG")
  private String rwyLdg;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "AIRCRAFT")
  private String aircraft;
  @Column(name = "FILE_NO")
  private Integer fileNo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "DURATION")
  private String duration;
  @Column(name = "PILOTE")
  private Integer pilote;
  @JoinColumn(name = "EV_FILES_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private EvFiles evFiles;
  @JoinColumn(name = "SECTOR_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Sector sector;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight", fetch = FetchType.LAZY)
  private List<Crew> crewList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight", fetch = FetchType.LAZY)
  @OrderBy(value = "classe")
  private List<FlightEvent> flightEventList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight", fetch = FetchType.LAZY)
  @OrderBy(value = "createdAt DESC")
  private List<FlightComments> flightCommentsList;

  public Flight() {
  }

  public Flight(Integer id) {
    this.id = id;
  }

  public Flight(Integer id, LocalDateTime fltDate, String flt, String dep, String arr, String rwyTo,
      String rwyLdg, String aircraft, String duration) {
    this.id = id;
    this.fltDate = fltDate;
    this.flt = flt;
    this.dep = dep;
    this.arr = arr;
    this.rwyTo = rwyTo;
    this.rwyLdg = rwyLdg;
    this.aircraft = aircraft;
    this.duration = duration;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getFltDate() {
    return fltDate;
  }

  public void setFltDate(LocalDateTime fltDate) {
    this.fltDate = fltDate;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
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

  public String getAircraft() {
    return aircraft;
  }

  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  public Integer getFileNo() {
    return fileNo;
  }

  public void setFileNo(Integer fileNo) {
    this.fileNo = fileNo;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Integer getPilote() {
    return pilote;
  }

  public void setPilote(Integer pilote) {
    this.pilote = pilote;
  }

  public EvFiles getEvFiles() {
    return evFiles;
  }

  public void setEvFiles(EvFiles evFiles) {
    this.evFiles = evFiles;
  }

  public Sector getSector() {
    return sector;
  }

  public void setSector(Sector sector) {
    this.sector = sector;
  }

  public List<Crew> getCrewList() {
    return crewList;
  }

  public void setCrewList(List<Crew> crewList) {
    this.crewList = crewList;
  }

  public List<FlightEvent> getFlightEventList() {
    return flightEventList;
  }

  public void setFlightEventList(List<FlightEvent> flightEventList) {
    this.flightEventList = flightEventList;
  }

  public List<FlightComments> getFlightCommentsList() {
    return flightCommentsList;
  }

  public void setFlightCommentsList(List<FlightComments> flightCommentsList) {
    this.flightCommentsList = flightCommentsList;
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
    if (!(object instanceof Flight)) {
      return false;
    }
    Flight other = (Flight) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.Flight[ id=" + id + " ]";
  }

}
