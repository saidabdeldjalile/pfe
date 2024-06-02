/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Embeddable
public class CarrierePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_ACT")
  private String codeAct;
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_DEB")
  private Date dateDeb;

  public CarrierePK() {}

  public CarrierePK(int matricule, String codeAct, Date dateDeb) {
    this.matricule = matricule;
    this.codeAct = codeAct;
    this.dateDeb = dateDeb;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getCodeAct() {
    return codeAct;
  }

  public void setCodeAct(String codeAct) {
    this.codeAct = codeAct;
  }

  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (codeAct != null ? codeAct.hashCode() : 0);
    hash += (dateDeb != null ? dateDeb.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CarrierePK)) {
      return false;
    }
    CarrierePK other = (CarrierePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.codeAct == null && other.codeAct != null)
        || (this.codeAct != null && !this.codeAct.equals(other.codeAct))) {
      return false;
    }
    if ((this.dateDeb == null && other.dateDeb != null)
        || (this.dateDeb != null && !this.dateDeb.equals(other.dateDeb))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.CarrierePK[ matricule=" + matricule + ", codeAct=" + codeAct + ", dateDeb="
        + dateDeb + " ]";
  }

}
