/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "ERR_TRT", schema = DbSchemaName.AGS_EV)
public class ErreurIntegrationAgsEvent implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;

  @Column(name = "FILE_NAME")
  private String fileName;

  @Size(max = 250)
  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "DATE_TRT")
  private LocalDateTime dateTrt;

  public ErreurIntegrationAgsEvent() {
  }

  public ErreurIntegrationAgsEvent(Integer id, String fileName, String message,
      LocalDateTime dateTrt) {
    this.id = id;
    this.fileName = fileName;
    this.message = message;
    this.dateTrt = dateTrt;
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

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(LocalDateTime dateTrt) {
    this.dateTrt = dateTrt;
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
    if (!(object instanceof ErreurIntegrationAgsEvent)) {
      return false;
    }
    ErreurIntegrationAgsEvent other = (ErreurIntegrationAgsEvent) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ErreurIntegrationAgsEvent{" + "id=" + id + ", fileName=" + fileName + ", message="
        + message + ", dateTrt=" + dateTrt + '}';
  }

}
