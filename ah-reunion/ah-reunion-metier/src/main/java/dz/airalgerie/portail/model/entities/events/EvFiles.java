/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
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
@Table(schema = DbSchemaName.AGS_EV, name = "EV_FILES")
@NamedQueries({@NamedQuery(name = "EvFiles.findAll", query = "SELECT e FROM EvFiles e")})
public class EvFiles implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "FILE_NAME")
  private String fileName;
  @Column(name = "FILE_MONTH")
  private Integer fileMonth;
  @Column(name = "SECTOR_ID")
  private Integer sectorId;
  @Column(name = "IS_INTEGRATED")
  private Boolean isIntegrated;
  @Column(name = "DATE_INT")
  private LocalDateTime dateInt;
  @OneToMany(mappedBy = "evFiles", fetch = FetchType.LAZY)
  private List<Flight> flightList;

  public EvFiles() {
  }

  public EvFiles(Integer id) {
    this.id = id;
  }

  public EvFiles(Integer id, String fileName) {
    this.id = id;
    this.fileName = fileName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Integer getFileMonth() {
    return fileMonth;
  }

  public void setFileMonth(Integer fileMonth) {
    this.fileMonth = fileMonth;
  }

  public Integer getSectorId() {
    return sectorId;
  }

  public void setSectorId(Integer sectorId) {
    this.sectorId = sectorId;
  }

  public Boolean getIsIntegrated() {
    return isIntegrated;
  }

  public void setIsIntegrated(Boolean isIntegrated) {
    this.isIntegrated = isIntegrated;
  }

  public LocalDateTime getDateInt() {
    return dateInt;
  }

  public void setDateInt(LocalDateTime dateInt) {
    this.dateInt = dateInt;
  }

  public List<Flight> getFlightList() {
    return flightList;
  }

  public void setFlightList(List<Flight> flightList) {
    this.flightList = flightList;
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
    if (!(object instanceof EvFiles)) {
      return false;
    }
    EvFiles other = (EvFiles) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.EvFiles[ id=" + id + " ]";
  }

}
