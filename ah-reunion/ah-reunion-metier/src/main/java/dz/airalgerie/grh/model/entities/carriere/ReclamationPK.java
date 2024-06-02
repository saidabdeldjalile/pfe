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

/**
 *
 * @author Diaf
 */
@Embeddable
public class ReclamationPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DATE")
  private Date date;

  public ReclamationPK() {}

  public ReclamationPK(int matricule, Date date) {
    this.matricule = matricule;
    this.date = date;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDate() {
    return date;
  }

  public void setDateDeb(Date date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (date != null ? date.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReclamationPK)) {
      return false;
    }
    ReclamationPK other = (ReclamationPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.date == null && other.date != null)
        || (this.date != null && !this.date.equals(other.date))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CAR.ReclamationPK[ matricule=" + matricule + ", date=" + date + " ]";
  }

}
