/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import dz.airalgerie.commun.model.entities.commun.PaysGrh;
import dz.airalgerie.commun.model.entities.commun.Wilaya;
import dz.airalgerie.grh.model.entities.gp.PersonnelLite;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "PERS_A_CHARGE")
public class PersACharge implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected PersAChargePK persAChargePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SEXE")
  private Character sexe;
  @Basic(optional = false)
  @NotNull

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
  @Column(name = "DROI_AF_AH")
  private Boolean droiAfAh;
  @Column(name = "DROI_AF_CNAS")
  private Boolean droiAfCnas;
  @Column(name = "DROI_PRIM_SCO")
  private Boolean droiPrimSco;

  @Column(name = "DEB_DROI")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date debDroi;

  @Column(name = "FIN_DROI")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date finDroi;
  @JoinColumn(name = "WIL_RESID", referencedColumnName = "CODE_WIL")
  @ManyToOne(fetch = FetchType.LAZY)
  private Wilaya wilaya;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "MATRICULE_PAC", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique signalitique1;
  @JoinColumn(name = "PAYS_NAIS", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays;
  @JoinColumn(name = "CODE_LIEN", referencedColumnName = "CODE_LIEN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private LienParente lienParente;
  @JoinColumn(name = "LIEU_NAIS", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique;
  @PrimaryKeyJoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PersonnelLite vPersAc;

  public PersACharge() {
  }

  public PersACharge(PersAChargePK persAChargePK) {
    this.persAChargePK = persAChargePK;
  }

  public PersACharge(PersAChargePK persAChargePK, String nom, Character sexe, Date dateNais) {
    this.persAChargePK = persAChargePK;
    this.nom = nom;
    this.sexe = sexe;
    this.dateNais = dateNais;
  }

  public PersACharge(int matricule, String prenoms, Character codeLien) {
    this.persAChargePK = new PersAChargePK(matricule, prenoms, codeLien);
  }

  public PersAChargePK getPersAChargePK() {
    return persAChargePK;
  }

  public void setPersAChargePK(PersAChargePK persAChargePK) {
    this.persAChargePK = persAChargePK;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  public Character getSexe() {
    return sexe;
  }

  public void setSexe(Character sexe) {
    this.sexe = sexe;
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

  public Boolean getDroiAfAh() {
    return droiAfAh;
  }

  public void setDroiAfAh(Boolean droiAfAh) {
    this.droiAfAh = droiAfAh;
  }

  public Boolean getDroiAfCnas() {
    return droiAfCnas;
  }

  public void setDroiAfCnas(Boolean droiAfCnas) {
    this.droiAfCnas = droiAfCnas;
  }

  public Boolean getDroiPrimSco() {
    return droiPrimSco;
  }

  public void setDroiPrimSco(Boolean droiPrimSco) {
    this.droiPrimSco = droiPrimSco;
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

  public Wilaya getWilaya() {
    return wilaya;
  }

  public void setWilaya(Wilaya wilaya) {
    this.wilaya = wilaya;
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

  public LienParente getLienParente() {
    return lienParente;
  }

  public void setLienParente(LienParente lienParente) {
    this.lienParente = lienParente;
  }

  public CodeGeographique getCodeGeographique() {
    return codeGeographique;
  }

  public void setCodeGeographique(CodeGeographique codeGeographique) {
    this.codeGeographique = codeGeographique;
  }

  public PersonnelLite getvPersAc() {
    return vPersAc;
  }

  public void setvPersAc(PersonnelLite vPersAc) {
    this.vPersAc = vPersAc;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (persAChargePK != null ? persAChargePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PersACharge)) {
      return false;
    }
    PersACharge other = (PersACharge) object;
    if ((this.persAChargePK == null && other.persAChargePK != null)
        || (this.persAChargePK != null && !this.persAChargePK.equals(other.persAChargePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.PersACharge[ persAChargePK=" + persAChargePK + " ]";
  }

}
