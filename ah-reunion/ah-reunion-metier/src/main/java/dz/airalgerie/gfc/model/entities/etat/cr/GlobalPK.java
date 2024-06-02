/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cr;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class GlobalPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private int id;
  @Basic(optional = false)
  @NotNull
  // @Size(min = 1, max = 3)
  @Column(name = "FILE_CODE")
  private String codeDoc;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;

  public GlobalPK() {}

  public GlobalPK(int id, String codeDoc, int dateTrt) {
    this.id = id;
    this.codeDoc = codeDoc;
    this.dateTrt = dateTrt;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCodeDoc() {
    return codeDoc;
  }

  public void setCodeDoc(String codeDoc) {
    this.codeDoc = codeDoc;
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
    hash += (int) id;
    hash += (codeDoc != null ? codeDoc.hashCode() : 0);
    hash += (int) dateTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GlobalPK)) {
      return false;
    }
    GlobalPK other = (GlobalPK) object;
    if (this.id != other.id) {
      return false;
    }
    if ((this.codeDoc == null && other.codeDoc != null)
        || (this.codeDoc != null && !this.codeDoc.equals(other.codeDoc))) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.GlobalPK[ id=" + id + ", codeDoc=" + codeDoc + ", dateTrt=" + dateTrt + " ]";
  }

}
