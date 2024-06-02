/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.PaysGrh;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "PARENT")
public class Parent implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ParentPK parentPK;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;

  @Column(name = "DATE_NAIS")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateNais;

  @Column(name = "DATE_DECES")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDeces;
  @Column(name = "A_CHARGE")
  private Boolean aCharge;
  @Column(name = "DROIT_GP")
  private Boolean droitGp;

  @Column(name = "DEB_DROI")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date debDroi;

  @Column(name = "FIN_DROI")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date finDroi;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "MATRICULE_PAR", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique signalitique1;
  @JoinColumn(name = "PAYS_NAIS", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays;
  @JoinColumn(name = "LIEU_NAIS", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique;
  @Column(name = "STATUT")
  private Integer statut;

  public Parent() {}

  public Parent(ParentPK parentPK) {
    this.parentPK = parentPK;
  }

  public Parent(int matricule, Character lienParente) {
    this.parentPK = new ParentPK(matricule, lienParente);
  }

  public ParentPK getParentPK() {
    return parentPK;
  }

  public void setParentPK(ParentPK parentPK) {
    this.parentPK = parentPK;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  public Date getDateNais() {
    return dateNais;
  }

  public void setDateNais(Date dateNais) {
    this.dateNais = dateNais;
  }

  public Date getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(Date dateDeces) {
    this.dateDeces = dateDeces;
  }

  public Boolean getACharge() {
    return aCharge;
  }

  public void setACharge(Boolean aCharge) {
    this.aCharge = aCharge;
  }

  public Boolean getDroitGp() {
    return droitGp;
  }

  public void setDroitGp(Boolean droitGp) {
    this.droitGp = droitGp;
  }

  public Date getDebDroi() {
    return debDroi;
  }

  public void setDebDroi(Date debDroi) {
    this.debDroi = debDroi;
  }

  public Date getFinDroi() {
    return finDroi;
  }

  public void setFinDroi(Date finDroi) {
    this.finDroi = finDroi;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Signalitique getSignalitique1() {
    return signalitique1;
  }

  public void setSignalitique1(Signalitique signalitique1) {
    this.signalitique1 = signalitique1;
  }

  public PaysGrh getPays() {
    return pays;
  }

  public void setPays(PaysGrh pays) {
    this.pays = pays;
  }

  public CodeGeographique getCodeGeographique() {
    return codeGeographique;
  }

  public void setCodeGeographique(CodeGeographique codeGeographique) {
    this.codeGeographique = codeGeographique;
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
    hash += (parentPK != null ? parentPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Parent)) {
      return false;
    }
    Parent other = (Parent) object;
    if ((this.parentPK == null && other.parentPK != null)
        || (this.parentPK != null && !this.parentPK.equals(other.parentPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Parent[ parentPK=" + parentPK + " ]";
  }

}
