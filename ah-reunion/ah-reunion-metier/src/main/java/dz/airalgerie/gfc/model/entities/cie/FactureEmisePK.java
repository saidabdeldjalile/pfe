/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class FactureEmisePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_CIE", nullable = false)
  private String numCie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "NUM_FCT", nullable = false, length = 8)
  private String numFct;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FCT", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateFct;

  public FactureEmisePK() {}

  public FactureEmisePK(String numCie, String numFct, Date dateFct) {
    this.numCie = numCie;
    this.numFct = numFct;
    this.dateFct = dateFct;
  }

  public String getNumCie() {
    return numCie;
  }

  public void setNumCie(String numCie) {
    this.numCie = numCie;
  }

  public String getNumFct() {
    return numFct;
  }

  public void setNumFct(String numFct) {
    this.numFct = numFct;
  }

  public Date getDateFct() {
    return dateFct;
  }

  public void setDateFct(Date dateFct) {
    this.dateFct = dateFct;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.numCie);
    hash = 83 * hash + Objects.hashCode(this.numFct);
    hash = 83 * hash + Objects.hashCode(this.dateFct);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FactureEmisePK)) {
      return false;
    }
    FactureEmisePK other = (FactureEmisePK) object;
    if (this.numCie != other.numCie) {
      return false;
    }
    if ((this.numFct == null && other.numFct != null)
        || (this.numFct != null && !this.numFct.equals(other.numFct))) {
      return false;
    }
    if ((this.dateFct == null && other.dateFct != null)
        || (this.dateFct != null && !this.dateFct.equals(other.dateFct))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.FactureEmisePK[ numCie=" + numCie + ", numFct=" + numFct + ", dateFct=" + dateFct
        + " ]";
  }

}
