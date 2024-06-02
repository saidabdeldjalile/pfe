/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

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
public class MaladiePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB_MLD")
  @Temporal(TemporalType.DATE)
  private Date dateDebMld;
  @NotNull
  @Column(name = "ETAT")
  private String etat;

  public MaladiePK() {}

  public MaladiePK(int matricule, Date dateDebMld, String etat) {
    this.matricule = matricule;
    this.dateDebMld = dateDebMld;
    this.etat = etat;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateDebMld() {
    return dateDebMld;
  }

  public void setDateDebMld(Date dateDebMld) {
    this.dateDebMld = dateDebMld;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 73 * hash + this.matricule;
    hash = 73 * hash + Objects.hashCode(this.dateDebMld);
    hash = 73 * hash + Objects.hashCode(this.etat);
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
    final MaladiePK other = (MaladiePK) obj;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (!Objects.equals(this.dateDebMld, other.dateDebMld)) {
      return false;
    }
    if (!Objects.equals(this.etat, other.etat)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.MaladiePK[ matricule=" + matricule + ", dateDebMld=" + dateDebMld
        + " ]";
  }

}
