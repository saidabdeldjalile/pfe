/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.time.LocalDate;
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
public class GpGrillePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(max = 20)
  @Column(name = "PSTR_LIB")
  private String pstrLib;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANCIENNETE")
  private int anciennete;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_D")
  private LocalDate dateD;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_F")
  private LocalDate dateF;

  public GpGrillePK() {}

  public GpGrillePK(String pstrLib, int anciennete, LocalDate dateD, LocalDate dateF) {
    this.pstrLib = pstrLib;
    this.anciennete = anciennete;
    this.dateD = dateD;
    this.dateF = dateF;
  }

  public String getPstrLib() {
    return pstrLib;
  }

  public void setPstrLib(String pstrLib) {
    this.pstrLib = pstrLib;
  }

  public int getAnciennete() {
    return anciennete;
  }

  public void setAnciennete(int anciennete) {
    this.anciennete = anciennete;
  }

  public LocalDate getDateD() {
    return dateD;
  }

  public void setDateD(LocalDate dateD) {
    this.dateD = dateD;
  }

  public LocalDate getDateF() {
    return dateF;
  }

  public void setDateF(LocalDate dateF) {
    this.dateF = dateF;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pstrLib != null ? pstrLib.hashCode() : 0);
    hash += (int) anciennete;
    hash += (dateD != null ? dateD.hashCode() : 0);
    hash += (dateF != null ? dateF.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GpGrillePK)) {
      return false;
    }
    GpGrillePK other = (GpGrillePK) object;
    if ((this.pstrLib == null && other.pstrLib != null)
        || (this.pstrLib != null && !this.pstrLib.equals(other.pstrLib))) {
      return false;
    }
    if (this.anciennete != other.anciennete) {
      return false;
    }
    if ((this.dateD == null && other.dateD != null)
        || (this.dateD != null && !this.dateD.equals(other.dateD))) {
      return false;
    }
    if ((this.dateF == null && other.dateF != null)
        || (this.dateF != null && !this.dateF.equals(other.dateF))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.GpGrillePK[ pstrLib=" + pstrLib + ", anciennete="
        + anciennete + ", dateD=" + dateD + ", dateF=" + dateF + " ]";
  }

}
