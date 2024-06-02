/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class JournalTotalPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "NUM_JOURNAL")
  private String numJournal;

  public JournalTotalPK() {}

  public JournalTotalPK(int dateTrt, String numJournal) {
    this.dateTrt = dateTrt;
    this.numJournal = numJournal;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (numJournal != null ? numJournal.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof JournalTotalPK)) {
      return false;
    }
    JournalTotalPK other = (JournalTotalPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.numJournal == null && other.numJournal != null)
        || (this.numJournal != null && !this.numJournal.equals(other.numJournal))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.JournalTotalPK[ dateTrt=" + dateTrt + ", numJournal=" + numJournal + " ]";
  }

}
