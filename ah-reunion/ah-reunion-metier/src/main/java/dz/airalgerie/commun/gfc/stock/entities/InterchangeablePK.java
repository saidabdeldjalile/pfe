/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
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
public class InterchangeablePK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn_art")
  private String pnArt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil_art")
  private String codeAppareilart;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn_inter")
  private String pnInter;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil_inter")
  private String codeAppareilinter;

  public InterchangeablePK() {}

  public InterchangeablePK(String pnArt, String codeAppareilart, String pnInter,
      String codeAppareilinter) {
    this.pnArt = pnArt;
    this.codeAppareilart = codeAppareilart;
    this.pnInter = pnInter;
    this.codeAppareilinter = codeAppareilinter;
  }

  public String getPnArt() {
    return pnArt;
  }

  public void setPnArt(String pnArt) {
    this.pnArt = pnArt;
  }

  public String getCodeAppareilart() {
    return codeAppareilart;
  }

  public void setCodeAppareilart(String codeAppareilart) {
    this.codeAppareilart = codeAppareilart;
  }

  public String getPnInter() {
    return pnInter;
  }

  public void setPnInter(String pnInter) {
    this.pnInter = pnInter;
  }

  public String getCodeAppareilinter() {
    return codeAppareilinter;
  }

  public void setCodeAppareilinter(String codeAppareilinter) {
    this.codeAppareilinter = codeAppareilinter;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pnArt != null ? pnArt.hashCode() : 0);
    hash += (codeAppareilart != null ? codeAppareilart.hashCode() : 0);
    hash += (pnInter != null ? pnInter.hashCode() : 0);
    hash += (codeAppareilinter != null ? codeAppareilinter.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof InterchangeablePK)) {
      return false;
    }
    InterchangeablePK other = (InterchangeablePK) object;
    if ((this.pnArt == null && other.pnArt != null)
        || (this.pnArt != null && !this.pnArt.equals(other.pnArt))) {
      return false;
    }
    if ((this.codeAppareilart == null && other.codeAppareilart != null)
        || (this.codeAppareilart != null && !this.codeAppareilart.equals(other.codeAppareilart))) {
      return false;
    }
    if ((this.pnInter == null && other.pnInter != null)
        || (this.pnInter != null && !this.pnInter.equals(other.pnInter))) {
      return false;
    }
    if ((this.codeAppareilinter == null && other.codeAppareilinter != null)
        || (this.codeAppareilinter != null
            && !this.codeAppareilinter.equals(other.codeAppareilinter))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.InterchangeablePK[ pnArt=" + pnArt + ", codeAppareilart="
        + codeAppareilart + ", pnInter=" + pnInter + ", codeAppareilinter=" + codeAppareilinter
        + " ]";
  }

}
