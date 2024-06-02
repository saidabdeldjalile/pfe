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

/**
 *
 * @author kemikem
 */
@Embeddable
public class BulletinPointagePK implements Serializable {

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
  @Column(name = "COD_POIN")
  private int codPoin;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_FIL")
  private Character codeFil;

  public BulletinPointagePK() {}

  public BulletinPointagePK(int matricule, int datePai, int dateTrt, boolean bulPrim, int codPoin,
      Character codeFil) {
    this.matricule = matricule;
    this.datePai = datePai;
    this.dateTrt = dateTrt;
    this.bulPrim = bulPrim;
    this.codPoin = codPoin;
    this.codeFil = codeFil;
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

  public int getCodPoin() {
    return codPoin;
  }

  public void setCodPoin(int codPoin) {
    this.codPoin = codPoin;
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
    hash += (int) matricule;
    hash += (int) datePai;
    hash += (int) dateTrt;
    hash += (bulPrim ? 1 : 0);
    hash += (int) codPoin;
    hash += (codeFil != null ? codeFil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinPointagePK)) {
      return false;
    }
    BulletinPointagePK other = (BulletinPointagePK) object;
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
    if (this.codPoin != other.codPoin) {
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
    return "ENTITY.SAISIE.BulletinPointagePK[ matricule=" + matricule + ", datePai=" + datePai
        + ", dateTrt=" + dateTrt + ", bulPrim=" + bulPrim + ", codPoin=" + codPoin + ", codeFil="
        + codeFil + " ]";
  }

}
