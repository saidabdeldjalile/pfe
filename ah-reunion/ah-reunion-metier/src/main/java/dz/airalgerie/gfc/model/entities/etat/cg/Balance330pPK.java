/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class Balance330pPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CLASSE")
  private String classe;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CPT_SCF_3")
  private String cptScf3;

  public Balance330pPK() {}

  public Balance330pPK(int dateTrt, String classe, String cptScf3) {
    this.dateTrt = dateTrt;
    this.classe = classe;
    this.cptScf3 = cptScf3;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public String getCptScf3() {
    return cptScf3;
  }

  public void setCptScf3(String cptScf3) {
    this.cptScf3 = cptScf3;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) dateTrt;
    hash += (classe != null ? classe.hashCode() : 0);
    hash += (cptScf3 != null ? cptScf3.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance330pPK)) {
      return false;
    }
    Balance330pPK other = (Balance330pPK) object;
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if ((this.classe == null && other.classe != null)
        || (this.classe != null && !this.classe.equals(other.classe))) {
      return false;
    }
    if ((this.cptScf3 == null && other.cptScf3 != null)
        || (this.cptScf3 != null && !this.cptScf3.equals(other.cptScf3))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance330pPK[ dateTrt=" + dateTrt + ", classe=" + classe + ", cptScf3="
        + cptScf3 + " ]";
  }

}
