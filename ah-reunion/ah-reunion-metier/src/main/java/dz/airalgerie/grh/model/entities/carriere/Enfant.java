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
@Table(schema = "CAR", name = "ENFANT")
public class Enfant implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EnfantPK enfantPK;
  @Size(max = 50)
  @Column(name = "SEXE")
  private String sexe;

  @Column(name = "DATE_NAIS")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateNais;
  @Column(name = "DATE_DECES")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDeces;
  @Column(name = "INFIRME")
  private Boolean infirme;
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

  @Column(name = "DEB_DROIT")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date debDroit;
  @Column(name = "STATUT")
  private Integer statut;
  @Size(min = 1, max = 50)
  @Column(name = "NOM")
  private String nom;
  @Column(name = "FIN_DROIT")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date finDroit;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "MATRICULE_ENF", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique signalitique1;
  @JoinColumn(name = "MATRICULE_CNJ", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique signalitique2;
  @JoinColumn(name = "PAYS_NAIS", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays;
  @JoinColumn(name = "LIEU_NAIS", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique;
  @JoinColumn(name = "CODE_CNJ", referencedColumnName = "CODE_CNJ")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeConjoint codeConjoint;
  @Column(name = "IDENTIFICATION")
  private String Identification;

  public Enfant() {
  }

  public String getIdentification() {
    return Identification;
  }

  public void setIdentification(String Identification) {
    this.Identification = Identification;
  }

  public Enfant(EnfantPK enfantPK) {
    this.enfantPK = enfantPK;
  }

  public Enfant(int matricule, String prenoms) {
    this.enfantPK = new EnfantPK(matricule, prenoms);
  }

  public EnfantPK getEnfantPK() {
    return enfantPK;
  }

  public void setEnfantPK(EnfantPK enfantPK) {
    this.enfantPK = enfantPK;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
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

  public Date getDebDroit() {
    return debDroit;
  }

  public void setDebDroit(Date debDroit) {
    this.debDroit = debDroit;
  }

  public Date getFinDroit() {
    return finDroit;
  }

  public void setFinDroit(Date finDroit) {
    this.finDroit = finDroit;
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

  public Signalitique getSignalitique2() {
    return signalitique2;
  }

  public void setSignalitique2(Signalitique signalitique2) {
    this.signalitique2 = signalitique2;
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

  public CodeConjoint getCodeConjoint() {
    return codeConjoint;
  }

  public void setCodeConjoint(CodeConjoint codeConjoint) {
    this.codeConjoint = codeConjoint;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Boolean getInfirme() {
    return infirme;
  }

  public void setInfirme(Boolean infirme) {
    this.infirme = infirme;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (enfantPK != null ? enfantPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Enfant)) {
      return false;
    }
    Enfant other = (Enfant) object;
    if ((this.enfantPK == null && other.enfantPK != null)
        || (this.enfantPK != null && !this.enfantPK.equals(other.enfantPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Enfant[ enfantPK=" + enfantPK + " ]";
  }

}
