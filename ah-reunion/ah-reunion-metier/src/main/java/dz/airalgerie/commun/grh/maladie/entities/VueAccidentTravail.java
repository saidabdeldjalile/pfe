/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "V_ACCIDENT_TRAVAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAccidentTravail.findAll", query = "SELECT v FROM VueAccidentTravail v"),
    @NamedQuery(name = "VAccidentTravail.findByMatricule",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.vueAccidentTravailPK.matricule = :matricule"),
    @NamedQuery(name = "VAccidentTravail.findByName",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.name = :name"),
    @NamedQuery(name = "VAccidentTravail.findByNom",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.nom = :nom"),
    @NamedQuery(name = "VAccidentTravail.findByNjfille",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.njfille = :njfille"),
    @NamedQuery(name = "VAccidentTravail.findByPrenoms",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.prenoms = :prenoms"),
    @NamedQuery(name = "VAccidentTravail.findByNumSs",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.numSs = :numSs"),
    @NamedQuery(name = "VAccidentTravail.findByDateDebMld",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.vueAccidentTravailPK.dateDebMld = :dateDebMld"),
    @NamedQuery(name = "VAccidentTravail.findByDateFinMld",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.dateFinMld = :dateFinMld"),
    @NamedQuery(name = "VAccidentTravail.findByNbrJourMld",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.nbrJourMld = :nbrJourMld"),
    @NamedQuery(name = "VAccidentTravail.findByDateCerMed",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.dateCerMed = :dateCerMed"),
    @NamedQuery(name = "VAccidentTravail.findByDateRecCm",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.dateRecCm = :dateRecCm"),
    @NamedQuery(name = "VAccidentTravail.findByDateSaisie",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "VAccidentTravail.findByObservation",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.observation = :observation"),
    @NamedQuery(name = "VAccidentTravail.findByNumAcctr",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.numAcctr = :numAcctr"),
    @NamedQuery(name = "VAccidentTravail.findByDateAcctr",
        query = "SELECT v FROM VueAccidentTravail v WHERE v.vueAccidentTravailPK.dateAcctr = :dateAcctr")})
public class VueAccidentTravail implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private VueAccidentTravailPK vueAccidentTravailPK;

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
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @Column(name = "NUM_ACCTR")
  private Integer numAcctr;

  public VueAccidentTravail() {}

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

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Integer getNumAcctr() {
    return numAcctr;
  }

  public void setNumAcctr(Integer numAcctr) {
    this.numAcctr = numAcctr;
  }

  public VueAccidentTravailPK getVueAccidentTravailPK() {
    return vueAccidentTravailPK;
  }

  public void setVueAccidentTravailPK(VueAccidentTravailPK vueAccidentTravailPK) {
    this.vueAccidentTravailPK = vueAccidentTravailPK;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.vueAccidentTravailPK);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VueAccidentTravail other = (VueAccidentTravail) obj;
    if (!Objects.equals(this.vueAccidentTravailPK, other.vueAccidentTravailPK)) {
      return false;
    }
    return true;
  }

}
