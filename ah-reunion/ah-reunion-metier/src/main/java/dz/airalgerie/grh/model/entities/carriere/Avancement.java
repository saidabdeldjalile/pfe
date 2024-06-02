/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "AVANCEMENT")
public class Avancement implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AvancementPK avancementPK;
  @Column(name = "CODE_SEC")
  private Short codeSec;
  @Column(name = "INDICE")
  private Integer indice;
  @Column(name = "ACCEPT_AVC")
  private Boolean acceptAvc;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MOYE_PR")
  private BigDecimal moyePr;
  @Column(name = "DATE_SAISI")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisi;
  @JoinColumn(name = "CHOIX_AVC", referencedColumnName = "CHOIX_AVC")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private ChoixAvancement choixAvancement;

  public Avancement() {}

  public Avancement(AvancementPK avancementPK) {
    this.avancementPK = avancementPK;
  }

  public Avancement(int matricule, int annee) {
    this.avancementPK = new AvancementPK(matricule, annee);
  }

  public AvancementPK getAvancementPK() {
    return avancementPK;
  }

  public void setAvancementPK(AvancementPK avancementPK) {
    this.avancementPK = avancementPK;
  }

  public Short getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(Short codeSec) {
    this.codeSec = codeSec;
  }

  public Integer getIndice() {
    return indice;
  }

  public void setIndice(Integer indice) {
    this.indice = indice;
  }

  public Boolean getAcceptAvc() {
    return acceptAvc;
  }

  public void setAcceptAvc(Boolean acceptAvc) {
    this.acceptAvc = acceptAvc;
  }

  public BigDecimal getMoyePr() {
    return moyePr;
  }

  public void setMoyePr(BigDecimal moyePr) {
    this.moyePr = moyePr;
  }

  public Date getDateSaisi() {
    return dateSaisi;
  }

  public void setDateSaisi(Date dateSaisi) {
    this.dateSaisi = dateSaisi;
  }

  public ChoixAvancement getChoixAvancement() {
    return choixAvancement;
  }

  public void setChoixAvancement(ChoixAvancement choixAvancement) {
    this.choixAvancement = choixAvancement;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (avancementPK != null ? avancementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Avancement)) {
      return false;
    }
    Avancement other = (Avancement) object;
    if ((this.avancementPK == null && other.avancementPK != null)
        || (this.avancementPK != null && !this.avancementPK.equals(other.avancementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Avancement[ avancementPK=" + avancementPK + " ]";
  }

}
