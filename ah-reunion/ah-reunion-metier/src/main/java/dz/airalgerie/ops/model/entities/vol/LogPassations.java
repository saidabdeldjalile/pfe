/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities.vol;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "LOG_PASSATIONS", schema = DbSchemaName.OPS)
@NamedQueries({
    @NamedQuery(name = "LogPassations.findAll", query = "SELECT l FROM LogPassations l")})
public class LogPassations implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "DATE_DEBUT")
  private LocalDateTime dateDebut;
  @Column(name = "DATE_FIN")
  private LocalDateTime dateFin;
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 200)
  @Column(name = "TITRE")
  private String titre;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "OBSERVATIONS")
  private String observations;
  @Column(name = "AGENT")
  private String agent;
  @Column(name = "STATUT")
  private boolean statut;

  public LogPassations() {
  }

  public LogPassations(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDateTime dateDebut) {
    this.dateDebut = dateDebut;
  }

  public LocalDateTime getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDateTime dateFin) {
    this.dateFin = dateFin;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getObservations() {
    return observations;
  }

  public void setObservations(String observations) {
    this.observations = observations;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public boolean isStatut() {
    return statut;
  }

  public void setStatut(boolean statut) {
    this.statut = statut;
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
    if (!(object instanceof LogPassations)) {
      return false;
    }
    LogPassations other = (LogPassations) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.vol.LogPassations[ id=" + id + ", " + " statut="
        + statut + " ]";
  }

}
