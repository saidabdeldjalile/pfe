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

/**
 *
 * @author Nabila
 */
@Embeddable
public class ConstantePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_VAL")
  private int codeVal;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB")
  private int dateDeb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  private int dateFin;

  public ConstantePK() {}

  public ConstantePK(String codeRub, int codeVal, int dateDeb, int dateFin) {
    this.codeRub = codeRub;
    this.codeVal = codeVal;
    this.dateDeb = dateDeb;
    this.dateFin = dateFin;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public int getCodeVal() {
    return codeVal;
  }

  public void setCodeVal(int codeVal) {
    this.codeVal = codeVal;
  }

  public int getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(int dateDeb) {
    this.dateDeb = dateDeb;
  }

  public int getDateFin() {
    return dateFin;
  }

  public void setDateFin(int dateFin) {
    this.dateFin = dateFin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRub != null ? codeRub.hashCode() : 0);
    hash += (int) codeVal;
    hash += (int) dateDeb;
    hash += (int) dateFin;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ConstantePK)) {
      return false;
    }
    ConstantePK other = (ConstantePK) object;
    if ((this.codeRub == null && other.codeRub != null)
        || (this.codeRub != null && !this.codeRub.equals(other.codeRub))) {
      return false;
    }
    if (this.codeVal != other.codeVal) {
      return false;
    }
    if (this.dateDeb != other.dateDeb) {
      return false;
    }
    if (this.dateFin != other.dateFin) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.ConstantePK[ codeRub=" + codeRub + ", codeVal=" + codeVal + ", dateDeb="
        + dateDeb + ", dateFin=" + dateFin + " ]";
  }

}
