/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.util.Objects;
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
public class OperationDivPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_CPTA", nullable = false)

  private int dateCpta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP", nullable = false, length = 4)
  private String grpChap;

  public OperationDivPK() {}

  public OperationDivPK(int dateCpta, String grpChap) {
    this.dateCpta = dateCpta;
    this.grpChap = grpChap;
  }

  public int getDateCpta() {
    return dateCpta;
  }

  public void setDateCpta(int dateCpta) {
    this.dateCpta = dateCpta;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.dateCpta);
    hash = 67 * hash + Objects.hashCode(this.grpChap);
    return hash;
  }

  // @Override
  // public int hashCode() {
  // int hash = 0;
  // hash += Integer.valueOf(dateCpta.toString());
  // hash += (grpChap != null ? grpChap.hashCode() : 0);
  // return hash;
  // }
  // @Override
  // public boolean equals(Object object) {
  // // TODO: Warning - this method won't work in the case the id fields are not set
  // if (!(object instanceof OperationDivPK)) {
  // return false;
  // }
  // OperationDivPK other = (OperationDivPK) object;
  // if (this.dateCpta != other.dateCpta) {
  // return false;
  // }
  // if ((this.grpChap == null && other.grpChap != null) || (this.grpChap != null &&
  // !this.grpChap.equals(other.grpChap))) {
  // return false;
  // }
  // return true;
  // }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final OperationDivPK other = (OperationDivPK) obj;
    if (!Objects.equals(this.grpChap, other.grpChap)) {
      return false;
    }
    if (!Objects.equals(this.dateCpta, other.dateCpta)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.OperationDivPK[ dateCpta=" + dateCpta + ", grpChap=" + grpChap + " ]";
  }

}
