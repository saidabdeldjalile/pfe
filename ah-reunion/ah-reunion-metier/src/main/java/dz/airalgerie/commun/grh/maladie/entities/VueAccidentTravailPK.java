/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
class VueAccidentTravailPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_ACCTR")
  @Temporal(TemporalType.DATE)
  private Date dateAcctr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB_MLD")
  @Temporal(TemporalType.DATE)
  private Date dateDebMld;

  public VueAccidentTravailPK() {}

  public VueAccidentTravailPK(int matricule, Date dateAcctr, Date dateDebMld) {
    this.matricule = matricule;
    this.dateAcctr = dateAcctr;
    this.dateDebMld = dateDebMld;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateAcctr() {
    return dateAcctr;
  }

  public void setDateAcctr(Date dateAcctr) {
    this.dateAcctr = dateAcctr;
  }

  public Date getDateDebMld() {
    return dateDebMld;
  }

  public void setDateDebMld(Date dateDebMld) {
    this.dateDebMld = dateDebMld;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + this.matricule;
    hash = 53 * hash + Objects.hashCode(this.dateAcctr);
    hash = 53 * hash + Objects.hashCode(this.dateDebMld);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VueAccidentTravailPK other = (VueAccidentTravailPK) obj;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (!Objects.equals(this.dateAcctr, other.dateAcctr)) {
      return false;
    }
    if (!Objects.equals(this.dateDebMld, other.dateDebMld)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.VueAccidentTravailPK[ matricule=" + matricule + ", dateAcctr="
        + dateAcctr + ", dateDebMld=" + dateDebMld + " ]";

  }

}
