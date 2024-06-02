/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.retraite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DEV
 */
@Embeddable
public class ActivitePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_PAIE")
  private int anneePaie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TRIMESTRE")
  private int trimestre;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_TRT")
  private int anneeTrt;

  public ActivitePK() {}

  public ActivitePK(int matricule, int anneePaie, String codeWil, int trimestre, int anneeTrt) {
    this.matricule = matricule;
    this.anneePaie = anneePaie;
    this.codeWil = codeWil;
    this.trimestre = trimestre;
    this.anneeTrt = anneeTrt;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getAnneePaie() {
    return anneePaie;
  }

  public void setAnneePaie(int anneePaie) {
    this.anneePaie = anneePaie;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public int getTrimestre() {
    return trimestre;
  }

  public void setTrimestre(int trimestre) {
    this.trimestre = trimestre;
  }

  public int getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(int anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) anneePaie;
    hash += (codeWil != null ? codeWil.hashCode() : 0);
    hash += (int) trimestre;
    hash += (int) anneeTrt;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ActivitePK)) {
      return false;
    }
    ActivitePK other = (ActivitePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.anneePaie != other.anneePaie) {
      return false;
    }
    if ((this.codeWil == null && other.codeWil != null)
        || (this.codeWil != null && !this.codeWil.equals(other.codeWil))) {
      return false;
    }
    if (this.trimestre != other.trimestre) {
      return false;
    }
    if (this.anneeTrt != other.anneeTrt) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entities.ActivitePK[ matricule=" + matricule + ", anneePaie=" + anneePaie + ", codeWil="
        + codeWil + ", trimestre=" + trimestre + ", anneeTrt=" + anneeTrt + " ]";
  }

}
