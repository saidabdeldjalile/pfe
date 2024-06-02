/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "V_MALADIE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VMaladie.findAll", query = "SELECT v FROM VueMaladie v"),
    @NamedQuery(name = "VMaladie.findByMatricule",
        query = "SELECT v FROM VueMaladie v WHERE v.vueMaladiePK.matricule = :matricule"),
    @NamedQuery(name = "VMaladie.findByName",
        query = "SELECT v FROM VueMaladie v WHERE v.name = :name"),
    @NamedQuery(name = "VMaladie.findByNom",
        query = "SELECT v FROM VueMaladie v WHERE v.nom = :nom"),
    @NamedQuery(name = "VMaladie.findByNjfille",
        query = "SELECT v FROM VueMaladie v WHERE v.njfille = :njfille"),
    @NamedQuery(name = "VMaladie.findByPrenoms",
        query = "SELECT v FROM VueMaladie v WHERE v.prenoms = :prenoms"),
    @NamedQuery(name = "VMaladie.findByNumSs",
        query = "SELECT v FROM VueMaladie v WHERE v.numSs = :numSs"),
    @NamedQuery(name = "VMaladie.findByDateDebMld",
        query = "SELECT v FROM VueMaladie v WHERE v.vueMaladiePK.dateDebMld = :dateDebMld"),
    @NamedQuery(name = "VMaladie.findByDateFinMld",
        query = "SELECT v FROM VueMaladie v WHERE v.dateFinMld = :dateFinMld"),
    @NamedQuery(name = "VMaladie.findByNbrJourMld",
        query = "SELECT v FROM VueMaladie v WHERE v.nbrJourMld = :nbrJourMld"),
    @NamedQuery(name = "VMaladie.findByDateCerMed",
        query = "SELECT v FROM VueMaladie v WHERE v.dateCerMed = :dateCerMed"),
    @NamedQuery(name = "VMaladie.findByDateRecCm",
        query = "SELECT v FROM VueMaladie v WHERE v.dateRecCm = :dateRecCm"),
    @NamedQuery(name = "VMaladie.findByAts",
        query = "SELECT v FROM VueMaladie v WHERE v.ats = :ats"),
    @NamedQuery(name = "VMaladie.findByDateSaisie",
        query = "SELECT v FROM VueMaladie v WHERE v.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "VMaladie.findByObsAts",
        query = "SELECT v FROM VueMaladie v WHERE v.obsAts = :obsAts"),
    @NamedQuery(name = "VMaladie.findByMontantIj",
        query = "SELECT v FROM VueMaladie v WHERE v.montantIj = :montantIj"),
    @NamedQuery(name = "VMaladie.findByObsMld",
        query = "SELECT v FROM VueMaladie v WHERE v.obsMld = :obsMld")})
public class VueMaladie implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private VueMaladiePK vueMaladiePK;
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
  @Column(name = "DATE_FIN_MLD")
  @Temporal(TemporalType.DATE)
  private Date dateFinMld;
  @Column(name = "NBR_JOUR_MLD")
  private Integer nbrJourMld;
  @Column(name = "DATE_CER_MED")
  @Temporal(TemporalType.DATE)
  private Date dateCerMed;
  @Column(name = "DATE_REC_CM")
  @Temporal(TemporalType.DATE)
  private Date dateRecCm;
  @Column(name = "ATS")
  private Character ats;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Size(max = 200)
  @Column(name = "OBS_ATS")
  private String obsAts;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONTANT_IJ")
  private BigDecimal montantIj;
  @Size(max = 200)
  @Column(name = "OBS_MLD")
  private String obsMld;

  public VueMaladie() {}

  public VueMaladie(VueMaladiePK vueMaladiePK, String name, String nom, String njfille,
      String prenoms, String numSs, Date dateFinMld, Integer nbrJourMld, Date dateCerMed,
      Date dateRecCm, Character ats, Date dateSaisie, String etat, String obsAts,
      BigDecimal montantIj, String obsMld) {
    this.vueMaladiePK = vueMaladiePK;
    this.name = name;
    this.nom = nom;
    this.njfille = njfille;
    this.prenoms = prenoms;
    this.numSs = numSs;
    this.dateFinMld = dateFinMld;
    this.nbrJourMld = nbrJourMld;
    this.dateCerMed = dateCerMed;
    this.dateRecCm = dateRecCm;
    this.ats = ats;
    this.dateSaisie = dateSaisie;
    this.obsAts = obsAts;
    this.montantIj = montantIj;
    this.obsMld = obsMld;
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

  public Date getDateFinMld() {
    return dateFinMld;
  }

  public void setDateFinMld(Date dateFinMld) {
    this.dateFinMld = dateFinMld;
  }

  public Integer getNbrJourMld() {
    return nbrJourMld;
  }

  public void setNbrJourMld(Integer nbrJourMld) {
    this.nbrJourMld = nbrJourMld;
  }

  public Date getDateCerMed() {
    return dateCerMed;
  }

  public void setDateCerMed(Date dateCerMed) {
    this.dateCerMed = dateCerMed;
  }

  public Date getDateRecCm() {
    return dateRecCm;
  }

  public void setDateRecCm(Date dateRecCm) {
    this.dateRecCm = dateRecCm;
  }

  public Character getAts() {
    return ats;
  }

  public void setAts(Character ats) {
    this.ats = ats;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getObsAts() {
    return obsAts;
  }

  public void setObsAts(String obsAts) {
    this.obsAts = obsAts;
  }

  public BigDecimal getMontantIj() {
    return montantIj;
  }

  public void setMontantIj(BigDecimal montantIj) {
    this.montantIj = montantIj;
  }

  public String getObsMld() {
    return obsMld;
  }

  public void setObsMld(String obsMld) {
    this.obsMld = obsMld;
  }

  public VueMaladiePK getVueMaladiePK() {
    return vueMaladiePK;
  }

  public void setVueMaladiePK(VueMaladiePK vueMaladiePK) {
    this.vueMaladiePK = vueMaladiePK;
  }

}
