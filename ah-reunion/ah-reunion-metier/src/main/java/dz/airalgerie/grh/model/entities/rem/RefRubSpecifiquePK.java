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
public class RefRubSpecifiquePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "CODE_RUB_SP")
  private String codeRubSp;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_VAL")
  private Character codeVal;

  public RefRubSpecifiquePK() {}

  public RefRubSpecifiquePK(String codeRubSp, Character codeVal) {
    this.codeRubSp = codeRubSp;
    this.codeVal = codeVal;
  }

  public String getCodeRubSp() {
    return codeRubSp;
  }

  public void setCodeRubSp(String codeRubSp) {
    this.codeRubSp = codeRubSp;
  }

  public Character getCodeVal() {
    return codeVal;
  }

  public void setCodeVal(Character codeVal) {
    this.codeVal = codeVal;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRubSp != null ? codeRubSp.hashCode() : 0);
    hash += (codeVal != null ? codeVal.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefRubSpecifiquePK)) {
      return false;
    }
    RefRubSpecifiquePK other = (RefRubSpecifiquePK) object;
    if ((this.codeRubSp == null && other.codeRubSp != null)
        || (this.codeRubSp != null && !this.codeRubSp.equals(other.codeRubSp))) {
      return false;
    }
    if ((this.codeVal == null && other.codeVal != null)
        || (this.codeVal != null && !this.codeVal.equals(other.codeVal))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.RefRubSpecifiquePK[ codeRubSp=" + codeRubSp + ", codeVal=" + codeVal + " ]";
  }

}
