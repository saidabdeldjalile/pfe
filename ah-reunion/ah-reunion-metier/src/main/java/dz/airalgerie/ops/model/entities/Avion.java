/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.ops.model.entities.vol.PlanningNettoyage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "AVION", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a"),
    @NamedQuery(name = "Avion.findByReg", query = "SELECT a FROM Avion a WHERE a.reg = :reg"),
    @NamedQuery(name = "Avion.findByDateEntree",
        query = "SELECT a FROM Avion a WHERE a.dateEntree = :dateEntree")})
public class Avion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "REG")
  private String reg;
  @Column(name = "DATE_ENTREE")
  private LocalDate dateEntree;
  @JoinColumn(name = "TYPE_AVION_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private TypeAvion typeAvionId;
  @OneToMany(mappedBy = "reg", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<Vol> volList;
  @OneToMany(mappedBy = "reg", fetch = FetchType.LAZY)
  private List<PlanningNettoyage> planningNettoyageList;

  public Avion() {
  }

  public Avion(String reg) {
    this.reg = reg;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public LocalDate getDateEntree() {
    return dateEntree;
  }

  public void setDateEntree(LocalDate dateEntree) {
    this.dateEntree = dateEntree;
  }

  public TypeAvion getTypeAvionId() {
    return typeAvionId;
  }

  public void setTypeAvionId(TypeAvion typeAvionId) {
    this.typeAvionId = typeAvionId;
  }

  @XmlTransient
  public List<Vol> getVolList() {
    return volList;
  }

  public void setVolList(List<Vol> volList) {
    this.volList = volList;
  }

  public List<PlanningNettoyage> getPlanningNettoyageList() {
    return planningNettoyageList;
  }

  public void setPlanningNettoyageList(List<PlanningNettoyage> planningNettoyageList) {
    this.planningNettoyageList = planningNettoyageList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (reg != null ? reg.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Avion)) {
      return false;
    }
    Avion other = (Avion) object;
    if ((this.reg == null && other.reg != null)
        || (this.reg != null && !this.reg.equals(other.reg))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.Avion[ reg=" + reg + " ]";
  }

}
