/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "GP", name = "GP")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Gp.findAll", query = "SELECT g FROM Gp g"),
    @NamedQuery(name = "Gp.findByNumGp", query = "SELECT g FROM Gp g WHERE g.numGp = :numGp"),
    @NamedQuery(name = "Gp.findByMatricule",
        query = "SELECT g FROM Gp g WHERE g.matricule = :matricule"),
    @NamedQuery(name = "Gp.findByDate", query = "SELECT g FROM Gp g WHERE g.date = :date"),
    @NamedQuery(name = "Gp.findByType", query = "SELECT g FROM Gp g WHERE g.type = :type"),
    @NamedQuery(name = "Gp.findByCodeFct", query = "SELECT g FROM Gp g WHERE g.codeFct = :codeFct"),
    @NamedQuery(name = "Gp.findByGrpChap", query = "SELECT g FROM Gp g WHERE g.grpChap = :grpChap"),
    @NamedQuery(name = "Gp.findByDateLimit",
        query = "SELECT g FROM Gp g WHERE g.dateLimit = :dateLimit"),
    @NamedQuery(name = "Gp.findByCode", query = "SELECT g FROM Gp g WHERE g.code = :code"),
    @NamedQuery(name = "Gp.findByStatus", query = "SELECT g FROM Gp g WHERE g.status = :status"),
    @NamedQuery(name = "Gp.findBySaisieMat",
        query = "SELECT g FROM Gp g WHERE g.saisieMat = :saisieMat"),
    @NamedQuery(name = "Gp.findByCodeDir", query = "SELECT g FROM Gp g WHERE g.ret = :ret")})
public class Gp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_GP", updatable = false, nullable = false)
  private Integer numGp;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Column(name = "DATE")
  private LocalDate date;
  @Size(max = 15)
  @Column(name = "TYPE")
  private String type;
  @Size(max = 15)
  @Column(name = "CODE_FCT")
  private String codeFct;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Column(name = "DATE_LIMIT")
  private LocalDate dateLimit;
  @Size(max = 50)
  @Column(name = "CODE")
  private String code;
  @Size(max = 50)
  @Column(name = "STATUS")
  private String status;
  @Column(name = "SAISIE_MAT")
  private Integer saisieMat;
  @Column(name = "SAISIE_DATE")
  private LocalDate saisieDate;
  @Size(max = 15)
  @Column(name = "CODE_DIR")
  private String ret;
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Size(max = 15)
  @Column(name = "TYPE_DEMANDE")
  private String typeDemande;
  @Size(max = 150)
  @Column(name = "ALLER")
  private String aller;
  @Size(max = 150)
  @Column(name = "RETOUR")
  private String retour;
  @Column(name = "VALIDE_PAR")
  private String validePar;
  @Column(name = "VALIDE_DIR")
  private Integer valideDir;
  @Column(name = "REFUS_PAR")
  private Integer refusPar;
  @Column(name = "AGENCE")
  private String agence;
  @Column(name = "REFUS_MOTIF")
  private String refusMotif;
  @Column(name = "EXERCICE")
  private int exercice;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @Column(name = "PROL_DATE")
  private LocalDate prolDate;
  @Column(name = "PROL_VAL")
  private Boolean prolVal;
  @Column(name = "EDITED")
  private Boolean edited;
  @Column(name = "DROIT_FIRST")
  private boolean droitFirst;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "numGp")
  @BatchFetch(BatchFetchType.IN)
  private List<GpDetail> listGp;

  public Gp() {
  }

  public Gp(Integer numGp) {
    this.numGp = numGp;
  }

  public Gp(Integer numGp, int matricule) {
    this.numGp = numGp;
    this.matricule = matricule;
  }

  public Integer getNumGp() {
    return numGp;
  }

  public void setNumGp(Integer numGp) {
    this.numGp = numGp;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCodeFct() {
    return codeFct;
  }

  public void setCodeFct(String codeFct) {
    this.codeFct = codeFct;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public LocalDate getDateLimit() {
    if (dateLimit == null) {
      if (date != null) {
        dateLimit = date.plusMonths(3);
      }
    }
    return dateLimit;
  }

  public void setDateLimit(LocalDate dateLimit) {
    this.dateLimit = dateLimit;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getSaisieMat() {
    return saisieMat;
  }

  public void setSaisieMat(Integer saisieMat) {
    this.saisieMat = saisieMat;
  }

  public LocalDate getSaisieDate() {
    return saisieDate;
  }

  public void setSaisieDate(LocalDate saisieDate) {
    this.saisieDate = saisieDate;
  }

  public String getRet() {
    return ret;
  }

  public void setRet(String ret) {
    this.ret = ret;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public String getTypeDemande() {
    return typeDemande;
  }

  public void setTypeDemande(String typeDemande) {
    this.typeDemande = typeDemande;
  }

  public String getAller() {
    return aller;
  }

  public void setAller(String aller) {
    this.aller = aller;
  }

  public String getRetour() {
    return retour;
  }

  public void setRetour(String retour) {
    this.retour = retour;
  }

  public List<GpDetail> getListGp() {
    return listGp;
  }

  public void setListGp(List<GpDetail> listGp) {
    this.listGp = listGp;
  }

  public String getValidePar() {
    return validePar;
  }

  public void setValidePar(String validePar) {
    this.validePar = validePar;
  }

  public Integer getValideDir() {
    return valideDir;
  }

  public void setValideDir(Integer valideDir) {
    this.valideDir = valideDir;
  }

  public Integer getRefusPar() {
    return refusPar;
  }

  public void setRefusPar(Integer refusPar) {
    this.refusPar = refusPar;
  }

  public String getAgence() {
    return agence;
  }

  public void setAgence(String agence) {
    this.agence = agence;
  }

  public String getRefusMotif() {
    return refusMotif;
  }

  public void setRefusMotif(String refusMotif) {
    this.refusMotif = refusMotif;
  }

  public int getExercice() {
    return exercice;
  }

  public void setExercice(int exercice) {
    this.exercice = exercice;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public LocalDate getProlDate() {
    return prolDate;
  }

  public void setProlDate(LocalDate prolDate) {
    this.prolDate = prolDate;
  }

  public Boolean getProlVal() {
    return prolVal;
  }

  public void setProlVal(Boolean prolVal) {
    this.prolVal = prolVal;
  }

  public Boolean getEdited() {
    return edited;
  }

  public void setEdited(Boolean edited) {
    this.edited = edited;
  }

  public boolean isDroitFirst() {
    return droitFirst;
  }

  public void setDroitFirst(boolean droitFirst) {
    this.droitFirst = droitFirst;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numGp != null ? numGp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Gp)) {
      return false;
    }
    Gp other = (Gp) object;
    if ((this.numGp == null && other.numGp != null)
        || (this.numGp != null && !this.numGp.equals(other.numGp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.Gp[ numGp=" + numGp + " ]";
  }

}
