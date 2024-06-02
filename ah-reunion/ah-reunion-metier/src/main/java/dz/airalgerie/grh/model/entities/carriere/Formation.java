/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "FRM", name = "FORMATION")
public class Formation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Column(name = "DUREE")
  private Integer duree;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @Column(name = "STATUT")
  private Integer statut;
  @JoinColumn(name = "TYPE_FRM", referencedColumnName = "TYPE_FRM")
  @ManyToOne(fetch = FetchType.LAZY)
  private TypeFormation typeFormation;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_ETU", referencedColumnName = "CODE_ETU")
  @ManyToOne(fetch = FetchType.LAZY)
  private Etude etude;
  @JoinColumn(name = "CODE_DIP", referencedColumnName = "CODE_DIP")
  @ManyToOne(fetch = FetchType.LAZY)
  private Diplome diplome;

  public Formation() {}

  public Formation(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDuree() {
    return duree;
  }

  public void setDuree(Integer duree) {
    this.duree = duree;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public TypeFormation getTypeFormation() {
    return typeFormation;
  }

  public void setTypeFormation(TypeFormation typeFormation) {
    this.typeFormation = typeFormation;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Etude getEtude() {
    return etude;
  }

  public void setEtude(Etude etude) {
    this.etude = etude;
  }

  public Diplome getDiplome() {
    return diplome;
  }

  public void setDiplome(Diplome diplome) {
    this.diplome = diplome;
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
    if (!(object instanceof Formation)) {
      return false;
    }
    Formation other = (Formation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Formation[ id=" + id + " ]";
  }

}
