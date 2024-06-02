/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "DETAIL_OPTIONS", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "DetailOptions.findAll", query = "SELECT o FROM DetailOptions o"),
    @NamedQuery(name = "DetailOptions.findById",
        query = "SELECT o FROM DetailOptions o WHERE o.id = :id"),
    @NamedQuery(name = "DetailOptions.findByLibelle",
        query = "SELECT o FROM DetailOptions o WHERE o.libelle = :libelle"),
    @NamedQuery(name = "DetailOptions.findByType",
        query = "SELECT o FROM DetailOptions o WHERE o.type = :type")})
public class DetailOptions implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 15)
  @Column(name = "TYPE")
  private String type;
  @OneToMany(mappedBy = "optionId", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<Solution> solutionList;
  @OneToMany(mappedBy = "optionId", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<EventOps> eventList;

  public DetailOptions() {
  }

  public DetailOptions(Integer id, String libelle, String type) {
    this.id = id;
    this.libelle = libelle;
    this.type = type;
  }

  public DetailOptions(Integer id) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @XmlTransient
  public List<Solution> getSolutionList() {
    return solutionList;
  }

  public void setSolutionList(List<Solution> solutionList) {
    this.solutionList = solutionList;
  }

  @XmlTransient
  public List<EventOps> getEventList() {
    return eventList;
  }

  public void setEventList(List<EventOps> eventList) {
    this.eventList = eventList;
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
    if (!(object instanceof DetailOptions)) {
      return false;
    }
    DetailOptions other = (DetailOptions) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.DetailOptions[ id=" + id + " ]";
  }

}
