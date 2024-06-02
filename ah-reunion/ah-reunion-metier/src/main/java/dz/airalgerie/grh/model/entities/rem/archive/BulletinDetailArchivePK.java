/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem.archive;

import dz.airalgerie.grh.model.entities.rem.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kemikem
 */
@Embeddable
public class BulletinDetailArchivePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_DTB")
  private int codeDtb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "BUL_PRIM")
  private boolean bulPrim;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_FIL")
  private Character codeFil;

  public BulletinDetailArchivePK() {}

  public BulletinDetailArchivePK(int codeDtb, int matricule, int datePai, int dateTrt,
      boolean bulPrim, Character codeFil) {
    this.codeDtb = codeDtb;
    this.matricule = matricule;
    this.datePai = datePai;
    this.dateTrt = dateTrt;
    this.bulPrim = bulPrim;
    this.codeFil = codeFil;
  }

  public int getCodeDtb() {
    return codeDtb;
  }

  public void setCodeDtb(int codeDtb) {
    this.codeDtb = codeDtb;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public boolean getBulPrim() {
    return bulPrim;
  }

  public void setBulPrim(boolean bulPrim) {
    this.bulPrim = bulPrim;
  }

  public Character getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(Character codeFil) {
    this.codeFil = codeFil;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) codeDtb;
    hash += (int) matricule;
    hash += (int) datePai;
    hash += (int) dateTrt;
    hash += (bulPrim ? 1 : 0);
    hash += (codeFil != null ? codeFil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinDetailArchivePK)) {
      return false;
    }
    BulletinDetailArchivePK other = (BulletinDetailArchivePK) object;
    if (this.codeDtb != other.codeDtb) {
      return false;
    }
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.datePai != other.datePai) {
      return false;
    }
    if (this.dateTrt != other.dateTrt) {
      return false;
    }
    if (this.bulPrim != other.bulPrim) {
      return false;
    }
    if ((this.codeFil == null && other.codeFil != null)
        || (this.codeFil != null && !this.codeFil.equals(other.codeFil))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.BulletinDetailPK[ codeDtb=" + codeDtb + ", matricule=" + matricule
        + ", datePai=" + datePai + ", dateTrt=" + dateTrt + ", bulPrim=" + bulPrim + ", codeFil="
        + codeFil + " ]";
  }

}
