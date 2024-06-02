/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.retraite;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DEV
 */
@Entity
@Table(name = "ACTIVITE", schema = "RET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActiviteRetraite.findAll", query = "SELECT a FROM ActiviteRetraite a"),
    @NamedQuery(name = "ActiviteRetraite.findByMatricule",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.activitePK.matricule = :matricule"),
    @NamedQuery(name = "ActiviteRetraite.findByAnneePaie",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.activitePK.anneePaie = :anneePaie"),
    @NamedQuery(name = "ActiviteRetraite.findByCodeWil",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.activitePK.codeWil = :codeWil"),
    @NamedQuery(name = "ActiviteRetraite.findByTrimestre",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.activitePK.trimestre = :trimestre"),
    @NamedQuery(name = "ActiviteRetraite.findByAnneeTrt",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.activitePK.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "ActiviteRetraite.findByActTrim",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.actTrim = :actTrim"),
    @NamedQuery(name = "ActiviteRetraite.findByMontTrim",
        query = "SELECT a FROM ActiviteRetraite a WHERE a.montTrim = :montTrim")})
public class ActiviteRetraite implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ActivitePK activitePK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ACT_TRIM")
  private int actTrim;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONT_TRIM")
  private BigDecimal montTrim;

  public ActiviteRetraite() {}

  public ActiviteRetraite(ActivitePK activitePK) {
    this.activitePK = activitePK;
  }

  public ActiviteRetraite(ActivitePK activitePK, int actTrim, BigDecimal montTrim) {
    this.activitePK = activitePK;
    this.actTrim = actTrim;
    this.montTrim = montTrim;
  }

  public ActiviteRetraite(int matricule, int anneePaie, String codeWil, int trimestre,
      int anneeTrt) {
    this.activitePK = new ActivitePK(matricule, anneePaie, codeWil, trimestre, anneeTrt);
  }

  public ActivitePK getActivitePK() {
    return activitePK;
  }

  public void setActivitePK(ActivitePK activitePK) {
    this.activitePK = activitePK;
  }

  public int getActTrim() {
    return actTrim;
  }

  public void setActTrim(int actTrim) {
    this.actTrim = actTrim;
  }

  public BigDecimal getMontTrim() {
    return montTrim;
  }

  public void setMontTrim(BigDecimal montTrim) {
    this.montTrim = montTrim;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (activitePK != null ? activitePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ActiviteRetraite)) {
      return false;
    }
    ActiviteRetraite other = (ActiviteRetraite) object;
    if ((this.activitePK == null && other.activitePK != null)
        || (this.activitePK != null && !this.activitePK.equals(other.activitePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entities.Activite[ activitePK=" + activitePK + " ]";
  }

}
