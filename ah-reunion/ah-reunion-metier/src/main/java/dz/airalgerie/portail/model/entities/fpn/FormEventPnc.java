/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.portail.model.entities.fpn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 */
@Entity
@Table(name = "FORM_EVENT_PNC", schema = "FPN")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "FormEventPnc.findAll", query = "SELECT f FROM FormEventPnc f")})
public class FormEventPnc implements Serializable {

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
  @Size(max = 5)
  @Column(name = "FONCTION")
  private String fonction;
  @Size(max = 150)
  @Column(name = "CDB")
  private String cdb;
  @Column(name = "DATE_EVENT")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateEvent;
  @Size(max = 10)
  @Column(name = "FLT")
  private String flt;
  @Size(max = 50)
  @Column(name = "DEP")
  private String dep;
  @Size(max = 50)
  @Column(name = "ARR")
  private String arr;
  @Size(max = 10)
  @Column(name = "AC_TYPE")
  private String acType;
  @Size(max = 10)
  @Column(name = "REG")
  private String reg;
  @Size(max = 50)
  @Column(name = "LIEU_OCCUR")
  private String lieuOccur;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "DESCRIPTION")
  private String description;
  @Size(max = 50)
  @Column(name = "AUTRE_EVENT")
  private String autreEvent;
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @JoinTable(name = "FORM_EVENT_PNC_EVENT", schema = "FPN",
      joinColumns = {@JoinColumn(name = "ID_FORM", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "ID_EVENT", referencedColumnName = "ID")})
  @ManyToMany(fetch = FetchType.LAZY)
  private List<FormEvent> formEventList;
  @JoinTable(name = "FORM_EVENT_PNC_PHASE", schema = "FPN",
      joinColumns = {@JoinColumn(name = "ID_FORM", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "ID_PHASE", referencedColumnName = "ID")})
  @ManyToMany(fetch = FetchType.LAZY)
  private List<PhaseVol> phaseVolList;

  public FormEventPnc() {
  }

  public FormEventPnc(Integer id) {
    this.id = id;
  }

  public FormEventPnc(Integer id, int matricule) {
    this.id = id;
    this.matricule = matricule;
  }

    public FormEventPnc(Integer id, int matricule, String fonction, String cdb, Date dateEvent, String flt, String dep, String arr, String acType, String reg, String lieuOccur, String description, String autreEvent, Date created) {
        this.id = id;
        this.matricule = matricule;
        this.fonction = fonction;
        this.cdb = cdb;
        this.dateEvent = dateEvent;
        this.flt = flt;
        this.dep = dep;
        this.arr = arr;
        this.acType = acType;
        this.reg = reg;
        this.lieuOccur = lieuOccur;
        this.description = description;
        this.autreEvent = autreEvent;
        this.created = created;
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

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public String getCdb() {
    return cdb;
  }

  public void setCdb(String cdb) {
    this.cdb = cdb;
  }

  public Date getDateEvent() {
    return dateEvent;
  }

  public void setDateEvent(Date dateEvent) {
    this.dateEvent = dateEvent;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getArr() {
    return arr;
  }

  public void setArr(String arr) {
    this.arr = arr;
  }

  public String getAcType() {
    return acType;
  }

  public void setAcType(String acType) {
    this.acType = acType;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public String getLieuOccur() {
    return lieuOccur;
  }

  public void setLieuOccur(String lieuOccur) {
    this.lieuOccur = lieuOccur;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAutreEvent() {
    return autreEvent;
  }

  public void setAutreEvent(String autreEvent) {
    this.autreEvent = autreEvent;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @XmlTransient
  public List<FormEvent> getFormEventList() {
    return formEventList;
  }

  public void setFormEventList(List<FormEvent> formEventList) {
    this.formEventList = formEventList;
  }

  @XmlTransient
  public List<PhaseVol> getPhaseVolList() {
    return phaseVolList;
  }

  public void setPhaseVolList(List<PhaseVol> phaseVolList) {
    this.phaseVolList = phaseVolList;
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
    if (!(object instanceof FormEventPnc)) {
      return false;
    }
    FormEventPnc other = (FormEventPnc) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.FormEventPnc[ id=" + id + " ]";
  }

}
