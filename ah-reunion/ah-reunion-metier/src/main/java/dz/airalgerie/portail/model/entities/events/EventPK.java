/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Embeddable
public class EventPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private int id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SECTOR_ID")
  private int sectorId;

  public EventPK() {
  }

  public EventPK(int id, int sectorId) {
    this.id = id;
    this.sectorId = sectorId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSectorId() {
    return sectorId;
  }

  public void setSectorId(int sectorId) {
    this.sectorId = sectorId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) id;
    hash += (int) sectorId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EventPK)) {
      return false;
    }
    EventPK other = (EventPK) object;
    if (this.id != other.id) {
      return false;
    }
    if (this.sectorId != other.sectorId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.EventPK[ id=" + id + ", sectorId="
        + sectorId + " ]";
  }

}
