/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "GRP_CHAP")
public class GrpChap implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GrpChapPK grpChapPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "DATE_DEC")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDec;
  @Size(max = 30)
  @Column(name = "REF_DEC")
  private String refDec;
  @Column(name = "DATE_SAISIE")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateSaisie;
  @Column(name = "STATUT")
  private Integer statut;

  public GrpChap() {
    this.grpChapPK = new GrpChapPK();
  }

  public GrpChap(GrpChapPK grpChapPK) {
    this.grpChapPK = grpChapPK;
  }

  public GrpChap(GrpChapPK grpChapPK, String libelle) {
    this.grpChapPK = grpChapPK;
    this.libelle = libelle;
  }

  public GrpChap(String compteAnal, String grpChap, Date dateDeb, Date dateFin) {
    this.grpChapPK = new GrpChapPK(compteAnal, grpChap, dateDeb, dateFin);
  }

  public GrpChapPK getGrpChapPK() {
    return grpChapPK;
  }

  public void setGrpChapPK(GrpChapPK grpChapPK) {
    this.grpChapPK = grpChapPK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Date getDateDec() {
    return dateDec;
  }

  public void setDateDec(Date dateDec) {
    this.dateDec = dateDec;
  }

  public String getRefDec() {
    return refDec;
  }

  public void setRefDec(String refDec) {
    this.refDec = refDec;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (grpChapPK != null ? grpChapPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GrpChap)) {
      return false;
    }
    GrpChap other = (GrpChap) object;
    if ((this.grpChapPK == null && other.grpChapPK != null)
        || (this.grpChapPK != null && !this.grpChapPK.equals(other.grpChapPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.GrpChap[ grpChapPK=" + grpChapPK + " ]";
  }

}
