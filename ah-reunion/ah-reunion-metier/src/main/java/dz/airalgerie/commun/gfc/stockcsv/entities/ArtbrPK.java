/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kemikem
 */
@Embeddable
public class ArtbrPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "CODEPN")
  private String codepn;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUMBR")
  private int numbr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATERE")
  @Temporal(TemporalType.DATE)
  private Date datere;

  // rajouter le 23062019 par kemikem
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODEMAG")
  private int codemag;

  public ArtbrPK() {}

  public ArtbrPK(String codepn, int numbr, Date datere) {
    this.codepn = codepn;
    this.numbr = numbr;
    this.datere = datere;
  }

  public String getCodepn() {
    return codepn;
  }

  public void setCodepn(String codepn) {
    this.codepn = codepn;
  }

  public int getNumbr() {
    return numbr;
  }

  public void setNumbr(int numbr) {
    this.numbr = numbr;
  }

  public Date getDatere() {
    return datere;
  }

  public void setDatere(Date datere) {
    this.datere = datere;
  }

  public int getCodemag() {
    return codemag;
  }

  public void setCodemag(int codemag) {
    this.codemag = codemag;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codepn != null ? codepn.hashCode() : 0);
    hash += (int) numbr;
    hash += (datere != null ? datere.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArtbrPK)) {
      return false;
    }
    ArtbrPK other = (ArtbrPK) object;
    if ((this.codepn == null && other.codepn != null)
        || (this.codepn != null && !this.codepn.equals(other.codepn))) {
      return false;
    }
    if (this.numbr != other.numbr) {
      return false;
    }
    if ((this.datere == null && other.datere != null)
        || (this.datere != null && !this.datere.equals(other.datere))) {
      return false;
    }

    if (this.codemag != other.codemag) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.ArtbrPK[ codepn=" + codepn + ", numbr=" + numbr + ", datere=" + datere
        + ",codemag=" + codemag + "  ]";
  }

}
