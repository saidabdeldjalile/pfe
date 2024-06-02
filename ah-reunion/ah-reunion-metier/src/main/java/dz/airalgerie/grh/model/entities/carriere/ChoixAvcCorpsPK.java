/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Embeddable
public class ChoixAvcCorpsPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "CHOIX_AVC")
  private Character choixAvc;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CORPS")
  private Character codeCorps;

  public ChoixAvcCorpsPK() {}

  public ChoixAvcCorpsPK(Character choixAvc, Character codeCorps) {
    this.choixAvc = choixAvc;
    this.codeCorps = codeCorps;
  }

  public Character getChoixAvc() {
    return choixAvc;
  }

  public void setChoixAvc(Character choixAvc) {
    this.choixAvc = choixAvc;
  }

  public Character getCodeCorps() {
    return codeCorps;
  }

  public void setCodeCorps(Character codeCorps) {
    this.codeCorps = codeCorps;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (choixAvc != null ? choixAvc.hashCode() : 0);
    hash += (codeCorps != null ? codeCorps.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ChoixAvcCorpsPK)) {
      return false;
    }
    ChoixAvcCorpsPK other = (ChoixAvcCorpsPK) object;
    if ((this.choixAvc == null && other.choixAvc != null)
        || (this.choixAvc != null && !this.choixAvc.equals(other.choixAvc))) {
      return false;
    }
    if ((this.codeCorps == null && other.codeCorps != null)
        || (this.codeCorps != null && !this.codeCorps.equals(other.codeCorps))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ChoixAvcCorpsPK[ choixAvc=" + choixAvc + ", codeCorps=" + codeCorps + " ]";
  }

}
