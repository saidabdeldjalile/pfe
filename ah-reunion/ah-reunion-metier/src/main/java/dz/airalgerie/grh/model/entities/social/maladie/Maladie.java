/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MALADIE", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Maladie.findAll", query = "SELECT m FROM Maladie m"),
    @NamedQuery(name = "Maladie.findByMatricule",
        query = "SELECT m FROM Maladie m WHERE m.maladiePK.matricule = :matricule"),
    @NamedQuery(name = "Maladie.findByDateDebMld",
        query = "SELECT m FROM Maladie m WHERE m.maladiePK.dateDebMld = :dateDebMld"),
    @NamedQuery(name = "Maladie.findByDateFinMld",
        query = "SELECT m FROM Maladie m WHERE m.dateFinMld = :dateFinMld"),
    @NamedQuery(name = "Maladie.findByDateSaisie",
        query = "SELECT m FROM Maladie m WHERE m.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "Maladie.findByDateRecCm",
        query = "SELECT m FROM Maladie m WHERE m.dateRecCm = :dateRecCm"),
    @NamedQuery(name = "Maladie.findByDateCerMed",
        query = "SELECT m FROM Maladie m WHERE m.dateCerMed = :dateCerMed"),
    @NamedQuery(name = "Maladie.findByNbrJourMld",
        query = "SELECT m FROM Maladie m WHERE m.nbrJourMld = :nbrJourMld"),
    @NamedQuery(name = "Maladie.findByMontantIj",
        query = "SELECT m FROM Maladie m WHERE m.montantIj = :montantIj"),
    @NamedQuery(name = "Maladie.findByAts", query = "SELECT m FROM Maladie m WHERE m.ats = :ats"),
    @NamedQuery(name = "Maladie.findByObsMld",
        query = "SELECT m FROM Maladie m WHERE m.obsMld = :obsMld"),
    @NamedQuery(name = "Maladie.findByObsAts",
        query = "SELECT m FROM Maladie m WHERE m.obsAts = :obsAts")})
public class Maladie implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected MaladiePK maladiePK;
  @Column(name = "DATE_FIN_MLD")
  @Temporal(TemporalType.DATE)
  private Date dateFinMld;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Column(name = "DATE_REC_CM")
  @Temporal(TemporalType.DATE)
  private Date dateRecCm;
  @Column(name = "DATE_CER_MED")
  @Temporal(TemporalType.DATE)
  private Date dateCerMed;
  @Column(name = "NBR_JOUR_MLD")
  private Integer nbrJourMld;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONTANT_IJ")
  private BigDecimal montantIj;
  @Column(name = "ATS")
  private Character ats;
  @Size(max = 200)
  @Column(name = "OBS_MLD")
  private String obsMld;
  @Size(max = 200)
  @Column(name = "OBS_ATS")
  private String obsAts;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;
  @JoinColumn(name = "ETAT", referencedColumnName = "ETAT", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private EtatMaladie etat;

  public Maladie() {}

  public Maladie(MaladiePK maladiePK) {
    this.maladiePK = maladiePK;
  }

  public Maladie(int matricule, Date dateDebMld, String etat) {
    this.maladiePK = new MaladiePK(matricule, dateDebMld, etat);
  }

  public MaladiePK getMaladiePK() {
    return maladiePK;
  }

  public void setMaladiePK(MaladiePK maladiePK) {
    this.maladiePK = maladiePK;
  }

  public Date getDateFinMld() {
    return dateFinMld;
  }

  public void setDateFinMld(Date dateFinMld) {
    this.dateFinMld = dateFinMld;
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

  public Date getDateCerMed() {
    return dateCerMed;
  }

  public void setDateCerMed(Date dateCerMed) {
    this.dateCerMed = dateCerMed;
  }

  public Integer getNbrJourMld() {
    return nbrJourMld;
  }

  public void setNbrJourMld(Integer nbrJourMld) {
    this.nbrJourMld = nbrJourMld;
  }

  public BigDecimal getMontantIj() {
    return montantIj;
  }

  public void setMontantIj(BigDecimal montantIj) {
    this.montantIj = montantIj;
  }

  public Character getAts() {
    return ats;
  }

  public void setAts(Character ats) {
    this.ats = ats;
  }

  public String getObsMld() {
    return obsMld;
  }

  public void setObsMld(String obsMld) {
    this.obsMld = obsMld;
  }

  public String getObsAts() {
    return obsAts;
  }

  public void setObsAts(String obsAts) {
    this.obsAts = obsAts;
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
    hash += (maladiePK != null ? maladiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Maladie)) {
      return false;
    }
    Maladie other = (Maladie) object;
    if ((this.maladiePK == null && other.maladiePK != null)
        || (this.maladiePK != null && !this.maladiePK.equals(other.maladiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Maladie[ maladiePK=" + maladiePK + " ]";
  }

}
