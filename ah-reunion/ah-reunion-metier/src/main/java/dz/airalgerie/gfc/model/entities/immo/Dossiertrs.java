/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author Administrateur
 */
@Entity
@Table(name = "DOSSIERTRS")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Dossiertrs.findAll", query = "SELECT d FROM Dossiertrs d")})
public class Dossiertrs implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DOSSIERTRANSFERTID")
  private Long dossiertransfertid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "UNITEPRENATE")
  private long uniteprenate;
  @Basic(optional = false)
  @NotNull
  @Column(name = "UNITECEDANTE")
  private long unitecedante;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATETRANSFERT")
  @Temporal(TemporalType.DATE)
  private Date datetransfert;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATEDEMANDE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datedemande;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "STATUT")
  private String statut;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossiertrs", fetch = FetchType.LAZY)
  private List<RaisonTransfert> raisonTransfertList;

  public Dossiertrs() {}

  public Dossiertrs(Long dossiertransfertid) {
    this.dossiertransfertid = dossiertransfertid;
  }

  public Dossiertrs(Long dossiertransfertid, long uniteprenate, long unitecedante,
      Date datetransfert, Date datedemande, Date created, String statut) {
    this.dossiertransfertid = dossiertransfertid;
    this.uniteprenate = uniteprenate;
    this.unitecedante = unitecedante;
    this.datetransfert = datetransfert;
    this.datedemande = datedemande;
    this.created = created;
    this.statut = statut;
  }

  public Long getDossiertransfertid() {
    return dossiertransfertid;
  }

  public void setDossiertransfertid(Long dossiertransfertid) {
    this.dossiertransfertid = dossiertransfertid;
  }

  public long getUniteprenate() {
    return uniteprenate;
  }

  public void setUniteprenate(long uniteprenate) {
    this.uniteprenate = uniteprenate;
  }

  public long getUnitecedante() {
    return unitecedante;
  }

  public void setUnitecedante(long unitecedante) {
    this.unitecedante = unitecedante;
  }

  public Date getDatetransfert() {
    return datetransfert;
  }

  public void setDatetransfert(Date datetransfert) {
    this.datetransfert = datetransfert;
  }

  public Date getDatedemande() {
    return datedemande;
  }

  public void setDatedemande(Date datedemande) {
    this.datedemande = datedemande;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  @XmlTransient
  public List<RaisonTransfert> getRaisonTransfertList() {
    return raisonTransfertList;
  }

  public void setRaisonTransfertList(List<RaisonTransfert> raisonTransfertList) {
    this.raisonTransfertList = raisonTransfertList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dossiertransfertid != null ? dossiertransfertid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Dossiertrs)) {
      return false;
    }
    Dossiertrs other = (Dossiertrs) object;
    if ((this.dossiertransfertid == null && other.dossiertransfertid != null)
        || (this.dossiertransfertid != null
            && !this.dossiertransfertid.equals(other.dossiertransfertid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Dossiertrs[ dossiertransfertid="
        + dossiertransfertid + " ]";
  }

}
