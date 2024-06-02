/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.DirectionGrh;
import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "DISCIPLINE")
public class Discipline implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected DisciplinePK disciplinePK;
  @Size(max = 255)
  @Column(name = "LIBELLE_FAUTE")
  private String libelleFaute;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_SN_MES_CONS")
  private Date dateSnMesCons;
  @Size(max = 10)
  @Column(name = "DATE_SN_PROP_UNITE")
  private String dateSnPropUnite;
  @Size(max = 10)
  @Column(name = "DATE_SN_RET_UNITE")
  private String dateSnRetUnite;
  @Size(max = 10)
  @Column(name = "DATE_SN_PROP_ENTREPRISE")
  private String dateSnPropEntreprise;
  @Size(max = 10)
  @Column(name = "DATE_SN_RET_ENTREPRISE")
  private String dateSnRetEntreprise;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_DIR", referencedColumnName = "CODE_DIR")
  @ManyToOne(fetch = FetchType.LAZY)
  private DirectionGrh direction;
  @JoinColumn(name = "SN_UNITE", referencedColumnName = "CODE_ACT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acte acte;
  @JoinColumn(name = "SN_RET_UNITE", referencedColumnName = "CODE_ACT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acte acte1;
  @JoinColumn(name = "SN_RET_ENTREPRISE", referencedColumnName = "CODE_ACT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acte acte2;
  @JoinColumn(name = "SN_PROP_UNITE", referencedColumnName = "CODE_ACT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acte acte3;
  @JoinColumn(name = "SN_PROP_ENTREPRISE", referencedColumnName = "CODE_ACT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Acte acte4;
  @JoinColumn(name = "SN_MES_CONS", referencedColumnName = "CODE_ACT", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Acte acte5;
  @Column(name = "STATUT")
  private Integer statut;

  public Discipline() {}

  public Discipline(DisciplinePK disciplinePK) {
    this.disciplinePK = disciplinePK;
  }

  public Discipline(int matricule, Date dateFaute, String snMesCons) {
    this.disciplinePK = new DisciplinePK(matricule, dateFaute, snMesCons);
  }

  public DisciplinePK getDisciplinePK() {
    return disciplinePK;
  }

  public void setDisciplinePK(DisciplinePK disciplinePK) {
    this.disciplinePK = disciplinePK;
  }

  public String getLibelleFaute() {
    return libelleFaute;
  }

  public void setLibelleFaute(String libelleFaute) {
    this.libelleFaute = libelleFaute;
  }

  public Date getDateSnMesCons() {
    return dateSnMesCons;
  }

  public void setDateSnMesCons(Date dateSnMesCons) {
    this.dateSnMesCons = dateSnMesCons;
  }

  public String getDateSnPropUnite() {
    return dateSnPropUnite;
  }

  public void setDateSnPropUnite(String dateSnPropUnite) {
    this.dateSnPropUnite = dateSnPropUnite;
  }

  public String getDateSnRetUnite() {
    return dateSnRetUnite;
  }

  public void setDateSnRetUnite(String dateSnRetUnite) {
    this.dateSnRetUnite = dateSnRetUnite;
  }

  public String getDateSnPropEntreprise() {
    return dateSnPropEntreprise;
  }

  public void setDateSnPropEntreprise(String dateSnPropEntreprise) {
    this.dateSnPropEntreprise = dateSnPropEntreprise;
  }

  public String getDateSnRetEntreprise() {
    return dateSnRetEntreprise;
  }

  public void setDateSnRetEntreprise(String dateSnRetEntreprise) {
    this.dateSnRetEntreprise = dateSnRetEntreprise;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public DirectionGrh getDirection() {
    return direction;
  }

  public void setDirection(DirectionGrh direction) {
    this.direction = direction;
  }

  public Acte getActe() {
    return acte;
  }

  public void setActe(Acte acte) {
    this.acte = acte;
  }

  public Acte getActe1() {
    return acte1;
  }

  public void setActe1(Acte acte1) {
    this.acte1 = acte1;
  }

  public Acte getActe2() {
    return acte2;
  }

  public void setActe2(Acte acte2) {
    this.acte2 = acte2;
  }

  public Acte getActe3() {
    return acte3;
  }

  public void setActe3(Acte acte3) {
    this.acte3 = acte3;
  }

  public Acte getActe4() {
    return acte4;
  }

  public void setActe4(Acte acte4) {
    this.acte4 = acte4;
  }

  public Acte getActe5() {
    return acte5;
  }

  public void setActe5(Acte acte5) {
    this.acte5 = acte5;
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
    hash += (disciplinePK != null ? disciplinePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Discipline)) {
      return false;
    }
    Discipline other = (Discipline) object;
    if ((this.disciplinePK == null && other.disciplinePK != null)
        || (this.disciplinePK != null && !this.disciplinePK.equals(other.disciplinePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Discipline[ disciplinePK=" + disciplinePK + " ]";
  }

}
