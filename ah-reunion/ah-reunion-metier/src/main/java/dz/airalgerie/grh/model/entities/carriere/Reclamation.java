/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diaf
 */
@Entity
public class Reclamation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ReclamationPK reclamationPk;
  @Column(name = "VALIDE")
  private boolean isValid;
  @Column(name = "TRAITE")
  private boolean isTraite;
  @Column(name = "OBSERVATION")
  private String observation;
  @Column(name = "DATE_TRT")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateTraitement;
  @Column(name = "MATRICULE_TRT")
  private int validateur;

  public Reclamation() {}

  public Reclamation(ReclamationPK reclamationPk) {
    this.reclamationPk = reclamationPk;
  }

  public Reclamation(ReclamationPK reclamationPk, boolean isValid, boolean isTraite,
      String observation) {
    this.reclamationPk = reclamationPk;
    this.isValid = isValid;
    this.isTraite = isTraite;
    this.observation = observation;
  }

  public ReclamationPK getReclamationPk() {
    return reclamationPk;
  }

  public void setReclamationPk(ReclamationPK reclamationPk) {
    this.reclamationPk = reclamationPk;
  }

  public boolean isIsValid() {
    return isValid;
  }

  public void setIsValid(boolean isValid) {
    this.isValid = isValid;
  }

  public boolean isIsTraite() {
    return isTraite;
  }

  public void setIsTraite(boolean isTraite) {
    this.isTraite = isTraite;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Date getDateTraitement() {
    return dateTraitement;
  }

  public void setDateTraitement(Date dateTraitement) {
    this.dateTraitement = dateTraitement;
  }

  public int getValidateur() {
    return validateur;
  }

  public void setValidateur(int validateur) {
    this.validateur = validateur;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 47 * hash + Objects.hashCode(this.reclamationPk);
    return hash;
  }

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
    final Reclamation other = (Reclamation) obj;
    if (!Objects.equals(this.reclamationPk, other.reclamationPk)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Reclamation{" + "reclamationPk=" + reclamationPk + ", isValid=" + isValid
        + ", isTraite=" + isTraite + ", observation=" + observation + ", dateTraitement="
        + dateTraitement + ", validateur=" + validateur + '}';
  }

}
