/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities.vol;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.ops.model.dto.vol.ImmobilisationAvionReportDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "IMMOBILISATION", schema = DbSchemaName.OPS)
@NamedQueries({@NamedQuery(name = "ImmobilisationAvion.findAll",
    query = "SELECT i FROM ImmobilisationAvion i")})
@SqlResultSetMapping(name = "OpsNet.PlanningImmobilisationAvionReportMapping",
    classes = @ConstructorResult(targetClass = ImmobilisationAvionReportDTO.class,
        columns = {@ColumnResult(name = "REG", type = String.class),
            @ColumnResult(name = "ID_PREVIOUS", type = Integer.class),
            @ColumnResult(name = "LIBELLE_PREVIOUS", type = String.class),
            @ColumnResult(name = "TYPE_PREVIOUS", type = String.class),
            @ColumnResult(name = "LIBELLE_TYPE_PREVIOUS", type = String.class),
            @ColumnResult(name = "DATE_DEBUT_PREVIOUS", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN_PREVIOUS", type = LocalDateTime.class),
            @ColumnResult(name = "STATUT_PREVIOUS", type = Integer.class),
            @ColumnResult(name = "DATE_NEXT_PREVU", type = LocalDateTime.class),
            @ColumnResult(name = "NB_JOURS_RESTANT_PREVU", type = Integer.class),
            @ColumnResult(name = "ID_IMMO", type = Integer.class),
            @ColumnResult(name = "DATE_IMMO", type = LocalDate.class),
            @ColumnResult(name = "DISPONIBILITE_IMMO", type = Integer.class),
            @ColumnResult(name = "DEBUT_IMMO", type = LocalDateTime.class),
            @ColumnResult(name = "FIN_IMMO", type = LocalDateTime.class),
            @ColumnResult(name = "ID_NEXT", type = Integer.class),
            @ColumnResult(name = "LIBELLE_NEXT", type = String.class),
            @ColumnResult(name = "TYPE_NEXT", type = String.class),
            @ColumnResult(name = "LIBELLE_TYPE_NEXT", type = String.class),
            @ColumnResult(name = "DATE_DEBUT_NEXT", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN_NEXT", type = LocalDateTime.class),
            @ColumnResult(name = "STATUT_NEXT", type = String.class)}))
@SqlResultSetMapping(name = "OpsNet.PlanningAlertesAvionReportMapping",
    classes = @ConstructorResult(targetClass = ImmobilisationAvionReportDTO.class,
        columns = {@ColumnResult(name = "REG", type = String.class),
            @ColumnResult(name = "ID_PREVIOUS", type = Integer.class),
            @ColumnResult(name = "LIBELLE_PREVIOUS", type = String.class),
            @ColumnResult(name = "TYPE_PREVIOUS", type = String.class),
            @ColumnResult(name = "LIBELLE_TYPE_PREVIOUS", type = String.class),
            @ColumnResult(name = "DATE_DEBUT_PREVIOUS", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN_PREVIOUS", type = LocalDateTime.class),
            @ColumnResult(name = "STATUT_PREVIOUS", type = Integer.class),
            @ColumnResult(name = "DATE_NEXT_PREVU", type = LocalDateTime.class),
            @ColumnResult(name = "NB_JOURS_RESTANT_PREVU", type = Integer.class),
            @ColumnResult(name = "ID_NEXT", type = Integer.class),
            @ColumnResult(name = "LIBELLE_NEXT", type = String.class),
            @ColumnResult(name = "TYPE_NEXT", type = String.class),
            @ColumnResult(name = "LIBELLE_TYPE_NEXT", type = String.class),
            @ColumnResult(name = "DATE_DEBUT_NEXT", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN_NEXT", type = LocalDateTime.class),
            @ColumnResult(name = "STATUT_NEXT", type = String.class)}))
public class ImmobilisationAvion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "REG")
  private String reg;
  @Column(name = "DATE")
  private LocalDate date;
  @Size(max = 3)
  @Column(name = "AIRPORT")
  private String airport;
  @Column(name = "DISPONIBILITE")
  private Integer disponibilite;
  @Column(name = "DISPONIBILITE_RAW")
  private String disponibiliteRaw;
  @Column(name = "ARR")
  private LocalDateTime arr;
  @Column(name = "DEP")
  private LocalDateTime dep;

  public ImmobilisationAvion() {
  }

  public ImmobilisationAvion(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public Integer getDisponibilite() {
    return disponibilite;
  }

  public void setDisponibilite(Integer disponibilite) {
    this.disponibilite = disponibilite;
  }

  public String getDisponibiliteRaw() {
    return disponibiliteRaw;
  }

  public void setDisponibiliteRaw(String disponibiliteRaw) {
    this.disponibiliteRaw = disponibiliteRaw;
  }

  public LocalDateTime getArr() {
    return arr;
  }

  public void setArr(LocalDateTime arr) {
    this.arr = arr;
  }

  public LocalDateTime getDep() {
    return dep;
  }

  public void setDep(LocalDateTime dep) {
    this.dep = dep;
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
    if (!(object instanceof ImmobilisationAvion)) {
      return false;
    }
    ImmobilisationAvion other = (ImmobilisationAvion) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.vol.ImmobilisationAvion[ id=" + id + " ]";
  }

}
