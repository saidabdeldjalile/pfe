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
@Table(schema = "CAR", name = "CONJOINT")
public class Conjoint implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ConjointPK conjointPK;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Column(name = "DATE_NAISS")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateNaiss;

  @Column(name = "DATE_DECES")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDeces;
  @Column(name = "DATE_DIV")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateDiv;
  @Size(max = 100)
  @Column(name = "PROF_CNJ")
  private String profCnj;
  @Size(max = 100)
  @Column(name = "ORGANISME")
  private String organisme;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "MATRICULE_CNJ", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique signalitique1;
  @JoinColumn(name = "PAYS_NAISS", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays;
  @JoinColumn(name = "PAYS_MAR", referencedColumnName = "CODE_PAY")
  @ManyToOne(fetch = FetchType.LAZY)
  private PaysGrh pays1;
  @JoinColumn(name = "NATIONALITE", referencedColumnName = "CODE_NAT")
  @ManyToOne(fetch = FetchType.LAZY)
  private Nationalite nationalite;
  @JoinColumn(name = "LIEU_MAR", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique;
  @JoinColumn(name = "LIEU_NAISS", referencedColumnName = "CODE_GEO")
  @ManyToOne(fetch = FetchType.LAZY)
  private CodeGeographique codeGeographique1;
  @JoinColumn(name = "CODE_CNJ", referencedColumnName = "CODE_CNJ", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CodeConjoint codeConjoint;
  @Column(name = "STATUT")
  private Integer statut;

  public Conjoint() {}

  public Conjoint(ConjointPK conjointPK) {
    this.conjointPK = conjointPK;
  }

  public Conjoint(int matricule, short codeCnj, Date dateMar) {
    this.conjointPK = new ConjointPK(matricule, codeCnj, dateMar);
  }

  public ConjointPK getConjointPK() {
    return conjointPK;
  }

  public void setConjointPK(ConjointPK conjointPK) {
    this.conjointPK = conjointPK;
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

  public Date getDateNaiss() {
    return dateNaiss;
  }

  public void setDateNaiss(Date dateNaiss) {
    this.dateNaiss = dateNaiss;
  }

  public Date getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(Date dateDeces) {
    this.dateDeces = dateDeces;
  }

  public Date getDateDiv() {
    return dateDiv;
  }

  public void setDateDiv(Date dateDiv) {
    this.dateDiv = dateDiv;
  }

  public String getProfCnj() {
    return profCnj;
  }

  public void setProfCnj(String profCnj) {
    this.profCnj = profCnj;
  }

  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
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

  public PaysGrh getPays1() {
    return pays1;
  }

  public void setPays1(PaysGrh pays1) {
    this.pays1 = pays1;
  }

  public Nationalite getNationalite() {
    return nationalite;
  }

  public void setNationalite(Nationalite nationalite) {
    this.nationalite = nationalite;
  }

  public CodeGeographique getCodeGeographique() {
    return codeGeographique;
  }

  public void setCodeGeographique(CodeGeographique codeGeographique) {
    this.codeGeographique = codeGeographique;
  }

  public CodeGeographique getCodeGeographique1() {
    return codeGeographique1;
  }

  public void setCodeGeographique1(CodeGeographique codeGeographique1) {
    this.codeGeographique1 = codeGeographique1;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (conjointPK != null ? conjointPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Conjoint)) {
      return false;
    }
    Conjoint other = (Conjoint) object;
    if ((this.conjointPK == null && other.conjointPK != null)
        || (this.conjointPK != null && !this.conjointPK.equals(other.conjointPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Conjoint[ conjointPK=" + conjointPK + " ]";
  }

}
