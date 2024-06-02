/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import dz.airalgerie.grh.model.entities.carriere.CodeConjoint;
import dz.airalgerie.grh.model.entities.carriere.Signalitique;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "CAR", name = "CONJOINT")
@XmlRootElement

public class ConjointLite implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ConjointLitePK conjointPK;
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
  private LocalDate dateNaiss;
  @Column(name = "DATE_DECES")
  private LocalDate dateDeces;
  @Size(max = 250)
  @Column(name = "IDENTIFICATION")
  private String identification;
  @JoinColumn(name = "CODE_CNJ", referencedColumnName = "CODE_CNJ", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CodeConjoint codeConjoint;
  @JoinColumn(name = "MATRICULE_CNJ", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private Signalitique matriculeCnj;
  @PrimaryKeyJoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PersonnelLite vPersC;
	@Column(name = "DATE_DIV")
  private LocalDate dateDiv;

  public ConjointLite() {}

  public PersonnelLite getvPersC() {
    return vPersC;
  }

  public void setvPersC(PersonnelLite vPersC) {
    this.vPersC = vPersC;
  }

  public ConjointLite(ConjointLitePK conjointPK) {
    this.conjointPK = conjointPK;
  }

  public ConjointLite(int matricule, short codeCnj, LocalDate dateMar) {
    this.conjointPK = new ConjointLitePK(matricule, codeCnj, dateMar);
  }

  public ConjointLitePK getConjointPK() {
    return conjointPK;
  }

  public void setConjointPK(ConjointLitePK conjointPK) {
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

  public LocalDate getDateNaiss() {
    return dateNaiss;
  }

  public void setDateNaiss(LocalDate dateNaiss) {
    this.dateNaiss = dateNaiss;
  }

  public LocalDate getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(LocalDate dateDeces) {
    this.dateDeces = dateDeces;
  }

  public CodeConjoint getCodeConjoint() {
    return codeConjoint;
  }

  public void setCodeConjoint(CodeConjoint codeConjoint) {
    this.codeConjoint = codeConjoint;
  }

  public Signalitique getMatriculeCnj() {
    return matriculeCnj;
  }

  public void setMatriculeCnj(Signalitique matriculeCnj) {
    this.matriculeCnj = matriculeCnj;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

	public LocalDate getDateDiv() {
		return dateDiv;
	}

	public void setDateDiv(LocalDate dateDiv) {
		this.dateDiv = dateDiv;
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
    if (!(object instanceof ConjointLite)) {
      return false;
    }
    ConjointLite other = (ConjointLite) object;
    if ((this.conjointPK == null && other.conjointPK != null)
        || (this.conjointPK != null && !this.conjointPK.equals(other.conjointPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.Conjoint[ conjointPK=" + conjointPK + " ]";
  }

}
