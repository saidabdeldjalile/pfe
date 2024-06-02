/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "STK.logSTK")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "LogSTK.findAll", query = "SELECT l FROM LogSTK l"),
    @NamedQuery(name = "LogSTK.findByIdlogSTK",
        query = "SELECT l FROM LogSTK l WHERE l.idlogSTK = :idlogSTK"),
    @NamedQuery(name = "LogSTK.findByEmail",
        query = "SELECT l FROM LogSTK l WHERE l.email = :email"),
    @NamedQuery(name = "LogSTK.findByDateLog",
        query = "SELECT l FROM LogSTK l WHERE l.dateLog = :dateLog"),
    @NamedQuery(name = "LogSTK.findByOpsLog",
        query = "SELECT l FROM LogSTK l WHERE l.opsLog = :opsLog"),
    @NamedQuery(name = "LogSTK.findByPn", query = "SELECT l FROM LogSTK l WHERE l.pn = :pn"),
    @NamedQuery(name = "LogSTK.findByCodeApp",
        query = "SELECT l FROM LogSTK l WHERE l.codeApp = :codeApp"),
    @NamedQuery(name = "LogSTK.findByNumBon",
        query = "SELECT l FROM LogSTK l WHERE l.numBon = :numBon"),
    @NamedQuery(name = "LogSTK.findByTypeMVT",
        query = "SELECT l FROM LogSTK l WHERE l.typeMVT = :typeMVT"),
    @NamedQuery(name = "LogSTK.findByOldPMP",
        query = "SELECT l FROM LogSTK l WHERE l.oldPMP = :oldPMP"),
    @NamedQuery(name = "LogSTK.findByNewPMP",
        query = "SELECT l FROM LogSTK l WHERE l.newPMP = :newPMP"),
    @NamedQuery(name = "LogSTK.findByOldQte",
        query = "SELECT l FROM LogSTK l WHERE l.oldQte = :oldQte"),
    @NamedQuery(name = "LogSTK.findByNewQte",
        query = "SELECT l FROM LogSTK l WHERE l.newQte = :newQte"),
    @NamedQuery(name = "LogSTK.findByOldVal",
        query = "SELECT l FROM LogSTK l WHERE l.oldVal = :oldVal"),
    @NamedQuery(name = "LogSTK.findByNewVal",
        query = "SELECT l FROM LogSTK l WHERE l.newVal = :newVal"),
    @NamedQuery(name = "LogSTK.findByObservation",
        query = "SELECT l FROM LogSTK l WHERE l.observation = :observation")})
public class LogSTK implements Serializable {
  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_logSTK")
  private Integer idlogSTK;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "email")
  private String email;
  @Column(name = "dateLog")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLog;
  @Size(max = 30)
  @Column(name = "opsLog")
  private String opsLog;
  @Size(max = 25)
  @Column(name = "pn")
  private String pn;
  @Size(max = 5)
  @Column(name = "codeApp")
  private String codeApp;
  @Size(max = 6)
  @Column(name = "numBon")
  private String numBon;
  @Column(name = "dateBon")
  @Temporal(TemporalType.DATE)
  private Date dateBon;
  @Column(name = "typeMVT")
  private Integer typeMVT;
  @Size(max = 100)
  @Column(name = "oldPMP")
  private BigDecimal oldPMP;
  @Size(max = 100)
  @Column(name = "newPMP")
  private BigDecimal newPMP;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "oldQte")
  private BigDecimal oldQte;
  @Column(name = "newQte")
  private BigDecimal newQte;
  @Column(name = "oldVal")
  private BigDecimal oldVal;
  @Column(name = "newVal")
  private BigDecimal newVal;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  public LogSTK() {}

  public LogSTK(Integer idlogSTK) {
    this.idlogSTK = idlogSTK;
  }

  public LogSTK(Integer idlogSTK, String email) {
    this.idlogSTK = idlogSTK;
    this.email = email;
  }

  public Integer getIdlogSTK() {
    return idlogSTK;
  }

  public void setIdlogSTK(Integer idlogSTK) {
    this.idlogSTK = idlogSTK;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateLog() {
    return dateLog;
  }

  public void setDateLog(Date dateLog) {
    this.dateLog = dateLog;
  }

  public String getOpsLog() {
    return opsLog;
  }

  public void setOpsLog(String opsLog) {
    this.opsLog = opsLog;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeApp() {
    return codeApp;
  }

  public void setCodeApp(String codeApp) {
    this.codeApp = codeApp;
  }

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public Integer getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(Integer typeMVT) {
    this.typeMVT = typeMVT;
  }

  public BigDecimal getOldPMP() {
    return oldPMP;
  }

  public void setOldPMP(BigDecimal oldPMP) {
    this.oldPMP = oldPMP;
  }

  public BigDecimal getNewPMP() {
    return newPMP;
  }

  public void setNewPMP(BigDecimal newPMP) {
    this.newPMP = newPMP;
  }

  public BigDecimal getOldQte() {
    return oldQte;
  }

  public void setOldQte(BigDecimal oldQte) {
    this.oldQte = oldQte;
  }

  public BigDecimal getNewQte() {
    return newQte;
  }

  public void setNewQte(BigDecimal newQte) {
    this.newQte = newQte;
  }

  public BigDecimal getOldVal() {
    return oldVal;
  }

  public void setOldVal(BigDecimal oldVal) {
    this.oldVal = oldVal;
  }

  public BigDecimal getNewVal() {
    return newVal;
  }

  public void setNewVal(BigDecimal newVal) {
    this.newVal = newVal;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idlogSTK != null ? idlogSTK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LogSTK)) {
      return false;
    }
    LogSTK other = (LogSTK) object;
    if ((this.idlogSTK == null && other.idlogSTK != null)
        || (this.idlogSTK != null && !this.idlogSTK.equals(other.idlogSTK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.LogSTK[ idlogSTK=" + idlogSTK + " ]";
  }

  public Date getDateBon() {
    return dateBon;
  }

  public void setDateBon(Date dateBon) {
    this.dateBon = dateBon;
  }

}
