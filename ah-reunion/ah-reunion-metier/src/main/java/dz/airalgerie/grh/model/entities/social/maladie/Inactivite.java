/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AGHA Riadh
 */
@Entity
@Table(name = "INACTIVITE" ,schema = ErpConstante.DbSchemaName.GRH_MLD)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Inactivite.findAll", query = "SELECT i FROM Inactivite i"),
    @NamedQuery(name = "Inactivite.findById",
        query = "SELECT i FROM Inactivite i WHERE i.id = :id"),
    @NamedQuery(name = "Inactivite.findByMatricule",
        query = "SELECT i FROM Inactivite i WHERE i.matricule = :matricule"),
    @NamedQuery(name = "Inactivite.findByDateDebut",
        query = "SELECT i FROM Inactivite i WHERE i.dateDebut = :dateDebut"),
    @NamedQuery(name = "Inactivite.findByDateFin",
        query = "SELECT i FROM Inactivite i WHERE i.dateFin = :dateFin"),
    @NamedQuery(name = "Inactivite.findByDateAccidentTravail",
        query = "SELECT i FROM Inactivite i WHERE i.dateAccidentTravail = :dateAccidentTravail"),
    @NamedQuery(name = "Inactivite.findByDateDoc",
        query = "SELECT i FROM Inactivite i WHERE i.dateDoc = :dateDoc"),
    @NamedQuery(name = "Inactivite.findByDateReceptionDoc",
        query = "SELECT i FROM Inactivite i WHERE i.dateReceptionDoc = :dateReceptionDoc"),
    @NamedQuery(name = "Inactivite.findByNbrJour",
        query = "SELECT i FROM Inactivite i WHERE i.nbrJour = :nbrJour"),
    @NamedQuery(name = "Inactivite.findByNumAccidentTravail",
        query = "SELECT i FROM Inactivite i WHERE i.numAccidentTravail = :numAccidentTravail"),
    @NamedQuery(name = "Inactivite.findByDateSaisie",
        query = "SELECT i FROM Inactivite i WHERE i.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "Inactivite.findByObservation",
        query = "SELECT i FROM Inactivite i WHERE i.observation = :observation")})
public class Inactivite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEBUT")
  @Temporal(TemporalType.DATE)
  private Date dateDebut;
  @Column(name = "DATE_FIN")
  @Temporal(TemporalType.DATE)
  private Date dateFin;
  @Column(name = "DATE_ACCIDENT_TRAVAIL")
  @Temporal(TemporalType.DATE)
  private Date dateAccidentTravail;
  @Column(name = "DATE_DOC")
  @Temporal(TemporalType.DATE)
  private Date dateDoc;
  @Column(name = "DATE_RECEPTION_DOC")
  @Temporal(TemporalType.DATE)
  private Date dateReceptionDoc;
  @Column(name = "NBR_JOUR")
  private Integer nbrJour;
  @Column(name = "NUM_ACCIDENT_TRAVAIL")
  private Integer numAccidentTravail;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @JoinColumn(name = "TYPE", referencedColumnName = "ETAT")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private EtatMaladie type;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true,mappedBy = "idParent", fetch = FetchType.LAZY)
  private List<Inactivite> inactiviteList;
  @JoinColumn(name = "ID_PARENT", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Inactivite idParent;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE",insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;
  @Column(name = "NATURE_DOC")
  private Integer natureDoc;

  public Inactivite() {
  }

  public Inactivite(Integer id) {
    this.id = id;
  }

  public Inactivite(Integer id, int matricule, Date dateDebut, Date dateSaisie) {
    this.id = id;
    this.matricule = matricule;
    this.dateDebut = dateDebut;
    this.dateSaisie = dateSaisie;
  }

  public Inactivite(int matricule, Date dateDebut, Date dateFin, Date dateAccidentTravail,
      Date dateDoc, Date dateReceptionDoc, Integer nbrJour, Integer numAccidentTravail,
      Date dateSaisie, String observation, EtatMaladie type, Inactivite idParent , Integer natureDoc) {
    this.matricule = matricule;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.dateAccidentTravail = dateAccidentTravail;
    this.dateDoc = dateDoc;
    this.dateReceptionDoc = dateReceptionDoc;
    this.nbrJour = nbrJour;
    this.numAccidentTravail = numAccidentTravail;
    this.dateSaisie = dateSaisie;
    this.observation = observation;
    this.type = type;
    this.idParent = idParent;
    this.natureDoc=natureDoc;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Date getDateAccidentTravail() {
    return dateAccidentTravail;
  }

  public void setDateAccidentTravail(Date dateAccidentTravail) {
    this.dateAccidentTravail = dateAccidentTravail;
  }

  public Date getDateDoc() {
    return dateDoc;
  }

  public void setDateDoc(Date dateDoc) {
    this.dateDoc = dateDoc;
  }

  public Date getDateReceptionDoc() {
    return dateReceptionDoc;
  }

  public void setDateReceptionDoc(Date dateReceptionDoc) {
    this.dateReceptionDoc = dateReceptionDoc;
  }

  public Integer getNbrJour() {
    return nbrJour;
  }

  public void setNbrJour(Integer nbrJour) {
    this.nbrJour = nbrJour;
  }

  public Integer getNumAccidentTravail() {
    return numAccidentTravail;
  }

  public void setNumAccidentTravail(Integer numAccidentTravail) {
    this.numAccidentTravail = numAccidentTravail;
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

  public EtatMaladie getType() {
    return type;
  }

  public void setType(EtatMaladie type) {
    this.type = type;
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  @XmlTransient
  public List<Inactivite> getInactiviteList() {
    return inactiviteList;
  }

  public void setInactiviteList(List<Inactivite> inactiviteList) {
    this.inactiviteList = inactiviteList;
  }

  public Inactivite getIdParent() {
    return idParent;
  }

  public void setIdParent(Inactivite idParent) {
    this.idParent = idParent;
  }

    public Integer getNatureDoc() {
        return natureDoc;
    }

    public void setNatureDoc(Integer natureDoc) {
        this.natureDoc = natureDoc;
    }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Inactivite)) {
      return false;
    }
    Inactivite other = (Inactivite) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.grh.model.entities.social.maladie.Inactivite[ id=" + id + " ]";
  }

}
