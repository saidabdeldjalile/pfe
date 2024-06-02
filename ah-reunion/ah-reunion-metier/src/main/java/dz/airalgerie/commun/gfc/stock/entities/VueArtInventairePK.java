/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class VueArtInventairePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn")
  private String pn;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitInvent")
  private int dateTraitInvent;

  public VueArtInventairePK() {}

  public VueArtInventairePK(String pn, String codeAppareil, int dateTraitInvent) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.dateTraitInvent = dateTraitInvent;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public int getDateTraitInvent() {
    return dateTraitInvent;
  }

  public void setDateTraitInvent(int dateTraitInvent) {
    this.dateTraitInvent = dateTraitInvent;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.pn);
    hash = 67 * hash + Objects.hashCode(this.codeAppareil);
    hash = 67 * hash + this.dateTraitInvent;
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
    final VueArtInventairePK other = (VueArtInventairePK) obj;
    if (!Objects.equals(this.pn, other.pn)) {
      return false;
    }
    if (!Objects.equals(this.codeAppareil, other.codeAppareil)) {
      return false;
    }
    if (this.dateTraitInvent != other.dateTraitInvent) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VueArtInventairePK{" + "pn=" + pn + ", codeAppareil=" + codeAppareil
        + ", dateTraitInvent=" + dateTraitInvent + '}';
  }

}
