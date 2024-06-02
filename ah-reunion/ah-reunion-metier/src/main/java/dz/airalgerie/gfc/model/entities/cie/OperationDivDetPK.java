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
public class OperationDivDetPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGN", nullable = false)
  private int numLign;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_CPTA", nullable = false)

  private int dateCpta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP", nullable = false, length = 4)
  private String grpChap;

  public OperationDivDetPK() {}

  public OperationDivDetPK(int numLign, int dateCpta, String grpChap) {
    this.numLign = numLign;
    this.dateCpta = dateCpta;
    this.grpChap = grpChap;
  }

  public int getNumLign() {
    return numLign;
  }

  public void setNumLign(int numLign) {
    this.numLign = numLign;
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
    int hash = 5;
    hash = 79 * hash + this.numLign;
    hash = 79 * hash + Objects.hashCode(this.dateCpta);
    hash = 79 * hash + Objects.hashCode(this.grpChap);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OperationDivDetPK)) {
      return false;
    }
    OperationDivDetPK other = (OperationDivDetPK) object;
    if (this.numLign != other.numLign) {
      return false;
    }
    if (this.dateCpta != other.dateCpta) {
      return false;
    }
    if ((this.grpChap == null && other.grpChap != null)
        || (this.grpChap != null && !this.grpChap.equals(other.grpChap))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.OperationDivDetPK[ numLign=" + numLign + ", dateCpta=" + dateCpta + ", grpChap="
        + grpChap + " ]";
  }

}
