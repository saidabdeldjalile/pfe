/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.grh.model.entities.commun.Personnel;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity
@Table(name = "ACCIDENT_TRAVAIL", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
public class AccidentTravail implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AccidentTravailPK accidentTravailPK;
  @Column(name = "DATE_FIN_MLD")
  @Temporal(TemporalType.DATE)
  private Date dateFinMld;
  @Column(name = "NBR_JOUR_MLD")
  private Integer nbrJourMld;
  @Column(name = "DATE_REC_CM")
  @Temporal(TemporalType.DATE)
  private Date dateRecCm;
  @Column(name = "DATE_CER_MED")
  @Temporal(TemporalType.DATE)
  private Date dateCerMed;
  @Column(name = "NUM_ACCTR")
  private Integer numAcctr;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Column(name = "ATS")
  private Character ats;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;
  @JoinColumn(name = "ETAT", referencedColumnName = "ETAT", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private EtatMaladie etat;

  public AccidentTravail() {
  }

  public AccidentTravail(AccidentTravailPK accidentTravailPK) {
    this.accidentTravailPK = accidentTravailPK;
  }

  public AccidentTravail(int matricule, Date dateAcctr, Date dateDebMld, String etat) {
    this.accidentTravailPK = new AccidentTravailPK(matricule, dateAcctr, dateDebMld, etat);
  }

  public AccidentTravailPK getAccidentTravailPK() {
    return accidentTravailPK;
  }

  public void setAccidentTravailPK(AccidentTravailPK accidentTravailPK) {
    this.accidentTravailPK = accidentTravailPK;
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

  public Date getDateRecCm() {
    return dateRecCm;
  }

  public void setDateRecCm(Date dateRecCm) {
    this.dateRecCm = dateRecCm;
  }

  public Date getDateCerMed() {
    return dateCerMed;
  }

  public void setDateCerMed(Date dateCerMed) {
    this.dateCerMed = dateCerMed;
  }

  public Integer getNumAcctr() {
    return numAcctr;
  }

  public void setNumAcctr(Integer numAcctr) {
    this.numAcctr = numAcctr;
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

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  public EtatMaladie getEtat() {
    return etat;
  }

  public void setEtat(EtatMaladie etat) {
    this.etat = etat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (accidentTravailPK != null ? accidentTravailPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AccidentTravail)) {
      return false;
    }
    AccidentTravail other = (AccidentTravail) object;
    if ((this.accidentTravailPK == null && other.accidentTravailPK != null)
        || (this.accidentTravailPK != null
            && !this.accidentTravailPK.equals(other.accidentTravailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.AccidentTravail[ accidentTravailPK=" + accidentTravailPK + " ]";
  }

  public Character getAts() {
    return ats;
  }

  public void setAts(Character ats) {
    this.ats = ats;
  }

}
