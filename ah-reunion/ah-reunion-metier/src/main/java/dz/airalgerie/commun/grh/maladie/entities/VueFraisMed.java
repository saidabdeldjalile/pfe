/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "V_FRAIS_MED")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VFraisMed.findAll", query = "SELECT v FROM VueFraisMed v"),
    @NamedQuery(name = "VFraisMed.findByMatricule",
        query = "SELECT v FROM VueFraisMed v WHERE v.matricule = :matricule"),
    @NamedQuery(name = "VFraisMed.findByName",
        query = "SELECT v FROM VueFraisMed v WHERE v.name = :name"),
    @NamedQuery(name = "VFraisMed.findByNom",
        query = "SELECT v FROM VueFraisMed v WHERE v.nom = :nom"),
    @NamedQuery(name = "VFraisMed.findByNjfille",
        query = "SELECT v FROM VueFraisMed v WHERE v.njfille = :njfille"),
    @NamedQuery(name = "VFraisMed.findByPrenoms",
        query = "SELECT v FROM VueFraisMed v WHERE v.prenoms = :prenoms"),
    @NamedQuery(name = "VFraisMed.findByNumSs",
        query = "SELECT v FROM VueFraisMed v WHERE v.numSs = :numSs"),
    @NamedQuery(name = "VFraisMed.findById",
        query = "SELECT v FROM VueFraisMed v WHERE v.id = :id"),
    @NamedQuery(name = "VFraisMed.findByDateFm",
        query = "SELECT v FROM VueFraisMed v WHERE v.dateFm = :dateFm"),
    @NamedQuery(name = "VFraisMed.findByCodeBenef",
        query = "SELECT v FROM VueFraisMed v WHERE v.codeBenef = :codeBenef"),
    @NamedQuery(name = "VFraisMed.findByMontFm",
        query = "SELECT v FROM VueFraisMed v WHERE v.montFm = :montFm"),
    @NamedQuery(name = "VFraisMed.findByCodeActe",
        query = "SELECT v FROM VueFraisMed v WHERE v.codeActe = :codeActe"),
    @NamedQuery(name = "VFraisMed.findByDateSaisie",
        query = "SELECT v FROM VueFraisMed v WHERE v.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "VFraisMed.findByDateRecCm",
        query = "SELECT v FROM VueFraisMed v WHERE v.dateRecCm = :dateRecCm"),
    @NamedQuery(name = "VFraisMed.findByObservation",
        query = "SELECT v FROM VueFraisMed v WHERE v.observation = :observation")})
public class VueFraisMed implements Serializable {
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Size(max = 152)
  @Column(name = "NAME")
  private String name;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Size(max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Size(max = 30)
  @Column(name = "NUM_SS")
  private String numSs;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private int id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FM")
  @Temporal(TemporalType.DATE)
  private Date dateFm;
  @Size(max = 1)
  @Column(name = "CODE_BENEF")
  private String codeBenef;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_FM")
  private BigDecimal montFm;
  @Size(max = 2)
  @Column(name = "CODE_ACTE")
  private String codeActe;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Column(name = "DATE_REC_CM")
  @Temporal(TemporalType.DATE)
  private Date dateRecCm;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;

  public VueFraisMed() {}

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms;
  }

  public String getNumSs() {
    return numSs;
  }

  public void setNumSs(String numSs) {
    this.numSs = numSs;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDateFm() {
    return dateFm;
  }

  public void setDateFm(Date dateFm) {
    this.dateFm = dateFm;
  }

  public String getCodeBenef() {
    return codeBenef;
  }

  public void setCodeBenef(String codeBenef) {
    this.codeBenef = codeBenef;
  }

  public BigDecimal getMontFm() {
    return montFm;
  }

  public void setMontFm(BigDecimal montFm) {
    this.montFm = montFm;
  }

  public String getCodeActe() {
    return codeActe;
  }

  public void setCodeActe(String codeActe) {
    this.codeActe = codeActe;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Date getDateRecCm() {
    return dateRecCm;
  }

  public void setDateRecCm(Date dateRecCm) {
    this.dateRecCm = dateRecCm;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

}
