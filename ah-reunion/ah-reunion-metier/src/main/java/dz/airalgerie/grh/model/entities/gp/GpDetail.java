/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(schema = "GP", name = "GP_DETAIL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "GpDetail.findAll", query = "SELECT g FROM GpDetail g"),
    @NamedQuery(name = "GpDetail.findByNum", query = "SELECT g FROM GpDetail g WHERE g.num = :num"),
    @NamedQuery(name = "GpDetail.findByLastname",
        query = "SELECT g FROM GpDetail g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GpDetail.findByName",
        query = "SELECT g FROM GpDetail g WHERE g.name = :name"),
    @NamedQuery(name = "GpDetail.findByStatus",
        query = "SELECT g FROM GpDetail g WHERE g.status = :status"),
    @NamedQuery(name = "GpDetail.findByNBillet",
        query = "SELECT g FROM GpDetail g WHERE g.nBillet = :nBillet"),
    @NamedQuery(name = "GpDetail.findByObservation",
        query = "SELECT g FROM GpDetail g WHERE g.observation = :observation")})
public class GpDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM", updatable = false, nullable = false)
  private Integer num;
  @Size(max = 50)
  @Column(name = "LASTNAME")
  private String lastname;
  @Size(max = 50)
  @Column(name = "NAME")
  private String name;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Size(max = 50)
  @Column(name = "STATUS")
  private String status;
  @Size(max = 50)
  @Column(name = "N_BILLET")
  private String nBillet;
  @Size(max = 100)
  @Column(name = "OBSERVATION")
  private String observation;
  @Size(max = 50)
  @Column(name = "LIEN")
  private String lien;
  @Column(name = "DATE_NAISSANCE")
  private LocalDate dateNaissance;
  @JoinColumn(name = "NUM_GP", referencedColumnName = "NUM_GP")
  @ManyToOne(optional = false)
  @BatchFetch(BatchFetchType.IN)
  private Gp numGp;

  public GpDetail() {
  }

  public GpDetail(Integer num) {
    this.num = num;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getNBillet() {
    return nBillet;
  }

  public void setNBillet(String nBillet) {
    this.nBillet = nBillet;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }

  public Gp getNumGp() {
    return numGp;
  }

  public void setNumGp(Gp numGp) {
    this.numGp = numGp;
  }

  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (num != null ? num.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GpDetail)) {
      return false;
    }
    GpDetail other = (GpDetail) object;
    if ((this.num == null && other.num != null)
        || (this.num != null && !this.num.equals(other.num))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.GpDetail[ num=" + num + " ]";
  }

}
