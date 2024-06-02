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
public class VueMaladiePK implements Serializable {
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

  public VueMaladiePK() {}

  public VueMaladiePK(int matricule, Date dateDebMld) {
    this.matricule = matricule;
    this.dateDebMld = dateDebMld;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 23 * hash + this.matricule;
    hash = 23 * hash + Objects.hashCode(this.dateDebMld);
    hash = 23 * hash + Objects.hashCode(this.etat);
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
    final VueMaladiePK other = (VueMaladiePK) obj;
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

}
