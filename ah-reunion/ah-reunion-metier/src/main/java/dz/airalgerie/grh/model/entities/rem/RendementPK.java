/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nabila
 */
@Embeddable
public class RendementPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;

  public RendementPK() {}

  public RendementPK(String codeDir, int dateTrt) {
    this.codeDir = codeDir;
    this.dateTrt = dateTrt;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDir != null ? codeDir.hashCode() : 0);
    hash += (int) dateTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RendementPK)) {
      return false;
    }
    RendementPK other = (RendementPK) object;
    if ((this.codeDir == null && other.codeDir != null)
        || (this.codeDir != null && !this.codeDir.equals(other.codeDir))) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.RendementPK[ codeDir=" + codeDir + ", dateTrt=" + dateTrt + " ]";
  }

}
