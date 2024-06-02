/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Embeddable
public class GrillePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CATG")
  private String codeCat;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_SEC")
  private Integer codeSec;
  @Basic(optional = false)
  @NotNull
  @Column(name = "GRILLE_DEB")
  private String dateDeb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "GRILLE_FIN")
  private String dateFin;

  public GrillePK() {}

  public String getCodeCat() {
    return codeCat;
  }

  public void setCodeCat(String codeCat) {
    this.codeCat = codeCat;
  }

  public Integer getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(Integer codeSec) {
    this.codeSec = codeSec;
  }

  public String getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(String dateDeb) {
    this.dateDeb = dateDeb;
  }

  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 29 * hash + Objects.hashCode(this.codeCat);
    hash = 29 * hash + Objects.hashCode(this.codeSec);
    hash = 29 * hash + Objects.hashCode(this.dateDeb);
    hash = 29 * hash + Objects.hashCode(this.dateFin);
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
    final GrillePK other = (GrillePK) obj;
    if (!Objects.equals(this.codeCat, other.codeCat)) {
      return false;
    }
    if (!Objects.equals(this.codeSec, other.codeSec)) {
      return false;
    }
    if (!Objects.equals(this.dateDeb, other.dateDeb)) {
      return false;
    }
    if (!Objects.equals(this.dateFin, other.dateFin)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "codeCat = " + codeCat + ", codeSec = " + codeSec + ", dateDeb = " + dateDeb
        + ", dateFin = " + dateFin;
  }

}
