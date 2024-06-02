/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities.vol;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.ops.model.dto.vol.PlanningNettoyageReportDTO;
import dz.airalgerie.ops.model.entities.Avion;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "PLANNING_NETTOYAGE", schema = ErpConstante.DbSchemaName.OPS)
@NamedQueries({
    @NamedQuery(name = "PlanningNettoyage.findAll", query = "SELECT p FROM PlanningNettoyage p")})
@SqlResultSetMapping(name = "PlanningNettoyageReportMapping",
    classes = @ConstructorResult(targetClass = PlanningNettoyageReportDTO.class,
        columns = {@ColumnResult(name = "ID", type = Integer.class),
            @ColumnResult(name = "REG", type = String.class),
            @ColumnResult(name = "LIBELLE", type = String.class),
            @ColumnResult(name = "TYPE_COD", type = String.class),
            @ColumnResult(name = "TYPE_LIBELLE", type = String.class),
            @ColumnResult(name = "DATE_DEBUT", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN", type = LocalDateTime.class),
            @ColumnResult(name = "STATUT", type = Integer.class),
            @ColumnResult(name = "DATE_DEBUT_PREV", type = LocalDateTime.class),
            @ColumnResult(name = "DATE_FIN_PREV", type = LocalDateTime.class),
            @ColumnResult(name = "NB_CHANGEMENTS", type = Integer.class)}))

public class PlanningNettoyage implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "NOTES")
  private String notes;
  @Column(name = "DATE_DEBUT")
  private LocalDateTime dateDebut;
  @Column(name = "DATE_FIN")
  private LocalDateTime dateFin;
  @Column(name = "STATUT")
  private Short statut;
  @Column(name = "CREATED")
  private LocalDateTime created;
  @Column(name = "VALIDATED_AT")
  private LocalDateTime validatedAt;
  @JoinColumn(name = "REG", referencedColumnName = "REG")
  @ManyToOne(fetch = FetchType.LAZY)
  private Avion reg;
  @OneToMany(mappedBy = "idParent", fetch = FetchType.LAZY)
  private List<PlanningNettoyage> planningNettoyageList;
  @JoinColumn(name = "ID_PARENT", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private PlanningNettoyage idParent;
  @JoinColumn(name = "TYPE", referencedColumnName = "TYPE")
  @ManyToOne(fetch = FetchType.LAZY)
  private TypeNettoyage typeNettoyage;

  public PlanningNettoyage() {
  }

  public PlanningNettoyage(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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

  public Short getStatut() {
    return statut;
  }

  public void setStatut(Short statut) {
    this.statut = statut;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getValidatedAt() {
    return validatedAt;
  }

  public void setValidatedAt(LocalDateTime validatedAt) {
    this.validatedAt = validatedAt;
  }

  public Avion getReg() {
    return reg;
  }

  public void setReg(Avion reg) {
    this.reg = reg;
  }

  public List<PlanningNettoyage> getPlanningNettoyageList() {
    return planningNettoyageList;
  }

  public void setPlanningNettoyageList(List<PlanningNettoyage> planningNettoyageList) {
    this.planningNettoyageList = planningNettoyageList;
  }

  public PlanningNettoyage getIdParent() {
    return idParent;
  }

  public void setIdParent(PlanningNettoyage idParent) {
    this.idParent = idParent;
  }

  public TypeNettoyage getTypeNettoyage() {
    return typeNettoyage;
  }

  public void setTypeNettoyage(TypeNettoyage typeNettoyage) {
    this.typeNettoyage = typeNettoyage;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
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
    if (!(object instanceof PlanningNettoyage)) {
      return false;
    }
    PlanningNettoyage other = (PlanningNettoyage) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("PlanningNettoyage{");
    sb.append("id=").append(id);
    sb.append(", libelle=").append(libelle);
    sb.append(", notes=").append(notes);
    sb.append(", dateDebut=").append(dateDebut);
    sb.append(", dateFin=").append(dateFin);
    sb.append(", statut=").append(statut);
    sb.append(", created=").append(created);
    sb.append(", validatedAt=").append(validatedAt);
    sb.append(", reg=").append(reg);
    sb.append(", planningNettoyageList=").append(planningNettoyageList);
    sb.append(", idParent=").append(idParent);
    sb.append(", typeNettoyage=").append(typeNettoyage);
    sb.append('}');
    return sb.toString();
  }

}
