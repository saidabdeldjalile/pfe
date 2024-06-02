/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import dz.airalgerie.grh.model.entities.carriere.ParentPK;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(schema = "CAR", name = "PARENT")
@XmlRootElement

public class ParentLite implements Serializable {

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
  private LocalDate dateNais;
  @Column(name = "DATE_DECES")
  private LocalDate dateDeces;
  @Column(name = "DROIT_GP")
  private Boolean droitGp;
  @Column(name = "IDENTIFICATION")
  private String identification;
  @Column(name = "MATRICULE_PAR")
  private Integer matriculePar;
  @PrimaryKeyJoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PersonnelLite vPersP;

  public ParentLite() {
  }

  public PersonnelLite getvPersP() {
    return vPersP;
  }

  public void setvPersP(PersonnelLite vPersP) {
    this.vPersP = vPersP;
  }

  public ParentLite(ParentPK parentPK) {
    this.parentPK = parentPK;
  }

  public ParentLite(int matricule, Character lienParente) {
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

  public LocalDate getDateNais() {
    return dateNais;
  }

  public void setDateNais(LocalDate dateNais) {
    this.dateNais = dateNais;
  }

  public LocalDate getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(LocalDate dateDeces) {
    this.dateDeces = dateDeces;
  }

  public Integer getMatriculePar() {
    return matriculePar;
  }

  public void setMatriculePar(Integer matriculePar) {
    this.matriculePar = matriculePar;
  }

  public Boolean getDroitGp() {
    return droitGp;
  }

  public void setDroitGp(Boolean droitGp) {
    this.droitGp = droitGp;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
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
    if (!(object instanceof ParentLite)) {
      return false;
    }
    ParentLite other = (ParentLite) object;
    if ((this.parentPK == null && other.parentPK != null)
        || (this.parentPK != null && !this.parentPK.equals(other.parentPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.Parent[ parentPK=" + parentPK + " ]";
  }

}
