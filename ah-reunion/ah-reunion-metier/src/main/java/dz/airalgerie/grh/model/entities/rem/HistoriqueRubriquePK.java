/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nabila
 */
@Embeddable
public class HistoriqueRubriquePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  private int dateFin;

  public HistoriqueRubriquePK() {}

  public HistoriqueRubriquePK(String codeRub, int dateFin) {
    this.codeRub = codeRub;
    this.dateFin = dateFin;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public int getDateFin() {
    return dateFin;
  }

  public void setDateFin(int dateFin) {
    this.dateFin = dateFin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRub != null ? codeRub.hashCode() : 0);
    hash += (int) dateFin;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof HistoriqueRubriquePK)) {
      return false;
    }
    HistoriqueRubriquePK other = (HistoriqueRubriquePK) object;
    if ((this.codeRub == null && other.codeRub != null)
        || (this.codeRub != null && !this.codeRub.equals(other.codeRub))) {
      return false;
    }
    if (this.dateFin != other.dateFin) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.HistoriqueRubriquePK[ codeRub=" + codeRub + ", dateFin=" + dateFin + " ]";
  }

}
