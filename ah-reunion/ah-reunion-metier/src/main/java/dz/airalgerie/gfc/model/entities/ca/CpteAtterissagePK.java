/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class CpteAtterissagePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // [Column (Name="ID ",IsDbGenerated=true,DbType="int Not Null IDENTITY")]
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public CpteAtterissagePK() {}

  public CpteAtterissagePK(int id) {
    this.id = id;

  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += id;

    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteAtterissagePK)) {
      return false;
    }
    CpteAtterissagePK other = (CpteAtterissagePK) object;
    if (this.id != other.id) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteAtterissagePK[ id=" + id + " ]";
  }

}
