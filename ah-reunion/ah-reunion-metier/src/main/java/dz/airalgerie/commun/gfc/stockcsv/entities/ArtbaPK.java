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
public class ArtbaPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "CODEPN")
  private String codepn;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUMBA")
  private int numba;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATEACHAT")
  @Temporal(TemporalType.DATE)
  private Date dateachat;

  // rajouter le 23062019 par kemikem
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODEMAG")
  private int codemag;

  public ArtbaPK() {}

  public ArtbaPK(String codepn, int numba, Date dateachat) {
    this.codepn = codepn;
    this.numba = numba;
    this.dateachat = dateachat;
  }

  public String getCodepn() {
    return codepn;
  }

  public void setCodepn(String codepn) {
    this.codepn = codepn;
  }

  public int getNumba() {
    return numba;
  }

  public void setNumba(int numba) {
    this.numba = numba;
  }

  public Date getDateachat() {
    return dateachat;
  }

  public void setDateachat(Date dateachat) {
    this.dateachat = dateachat;
  }

  // geter ajouter le 23062019
  public int getCodemag() {
    return codemag;
  }

  public void setCodemag(int codemag) {
    this.codemag = codemag;
  }

  // ------------fin

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codepn != null ? codepn.hashCode() : 0);
    hash += (int) numba;
    hash += (dateachat != null ? dateachat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ArtbaPK)) {
      return false;
    }
    ArtbaPK other = (ArtbaPK) object;
    if ((this.codepn == null && other.codepn != null)
        || (this.codepn != null && !this.codepn.equals(other.codepn))) {
      return false;
    }
    if (this.numba != other.numba) {
      return false;
    }
    if ((this.dateachat == null && other.dateachat != null)
        || (this.dateachat != null && !this.dateachat.equals(other.dateachat))) {
      return false;
    }
    if (this.codemag != other.codemag) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "Entite.ArtbaPK[ codepn=" + codepn + ", numba=" + numba + ", dateachat=" + dateachat
        + ",codemag=" + codemag + " ]";
  }

}
