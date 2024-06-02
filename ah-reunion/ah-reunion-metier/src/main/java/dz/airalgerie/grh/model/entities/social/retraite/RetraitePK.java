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
public class RetraitePK implements Serializable {

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

  public RetraitePK() {}

  public RetraitePK(int matricule, int anneePaie, String codeWil) {
    this.matricule = matricule;
    this.anneePaie = anneePaie;
    this.codeWil = codeWil;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) anneePaie;
    hash += (codeWil != null ? codeWil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RetraitePK)) {
      return false;
    }
    RetraitePK other = (RetraitePK) object;
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
    return true;
  }

  @Override
  public String toString() {
    return "Entities.RetraitePK[ matricule=" + matricule + ", anneePaie=" + anneePaie + ", codeWil="
        + codeWil + " ]";
  }

}
