/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

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
 * @author Diaf
 */
@Embeddable
public class DisciplinePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FAUTE")
  private Date dateFaute;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "SN_MES_CONS")
  private String snMesCons;

  public DisciplinePK() {}

  public DisciplinePK(int matricule, Date dateFaute, String snMesCons) {
    this.matricule = matricule;
    this.dateFaute = dateFaute;
    this.snMesCons = snMesCons;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateFaute() {
    return dateFaute;
  }

  public void setDateFaute(Date dateFaute) {
    this.dateFaute = dateFaute;
  }

  public String getSnMesCons() {
    return snMesCons;
  }

  public void setSnMesCons(String snMesCons) {
    this.snMesCons = snMesCons;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (dateFaute != null ? dateFaute.hashCode() : 0);
    hash += (snMesCons != null ? snMesCons.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DisciplinePK)) {
      return false;
    }
    DisciplinePK other = (DisciplinePK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if ((this.dateFaute == null && other.dateFaute != null)
        || (this.dateFaute != null && !this.dateFaute.equals(other.dateFaute))) {
      return false;
    }
    if ((this.snMesCons == null && other.snMesCons != null)
        || (this.snMesCons != null && !this.snMesCons.equals(other.snMesCons))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.DisciplinePK[ matricule=" + matricule + ", dateFaute=" + dateFaute + ", snMesCons="
        + snMesCons + " ]";
  }

}
