/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Embeddable
public class PosteTrvDetPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_PSTR")
  private int codePstr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "DATE_DEB")
  private String dateDeb;

  public PosteTrvDetPK() {}

  public PosteTrvDetPK(int codePstr, String dateDeb) {
    this.codePstr = codePstr;
    this.dateDeb = dateDeb;
  }

  public int getCodePstr() {
    return codePstr;
  }

  public void setCodePstr(int codePstr) {
    this.codePstr = codePstr;
  }

  public String getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(String dateDeb) {
    this.dateDeb = dateDeb;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) codePstr;
    hash += (dateDeb != null ? dateDeb.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PosteTrvDetPK)) {
      return false;
    }
    PosteTrvDetPK other = (PosteTrvDetPK) object;
    if (this.codePstr != other.codePstr) {
      return false;
    }
    if ((this.dateDeb == null && other.dateDeb != null)
        || (this.dateDeb != null && !this.dateDeb.equals(other.dateDeb))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.PosteTrvDetPK[ codePstr=" + codePstr + ", dateDeb=" + dateDeb + " ]";
  }

}
