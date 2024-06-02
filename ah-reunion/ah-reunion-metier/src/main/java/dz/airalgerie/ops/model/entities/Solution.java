/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "SOLUTION", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Solution.findAll", query = "SELECT s FROM Solution s"),
    @NamedQuery(name = "Solution.findById", query = "SELECT s FROM Solution s WHERE s.id = :id"),
    @NamedQuery(name = "Solution.findByDate",
        query = "SELECT s FROM Solution s WHERE s.date = :date"),
    @NamedQuery(name = "Solution.findByDescription",
        query = "SELECT s FROM Solution s WHERE s.description = :description")})
public class Solution implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "DATE")
  private LocalDateTime date;
  @Size(max = 500)
  @Column(name = "DESCRIPTION")
  private String description;
  @Basic(optional = false)
  @Size(max = 100)
  @Column(name = "AGENT")
  private String agent;
  @JoinColumn(name = "OPTION_ID", referencedColumnName = "ID")
  @BatchFetch(BatchFetchType.IN)
  @ManyToOne(fetch = FetchType.LAZY)
  private DetailOptions optionId;
  @JoinColumn(name = "VOL_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Vol volId;
  @JoinColumn(name = "EVENT_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private EventOps event;

  public Solution() {
  }

  public Solution(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public DetailOptions getOptionId() {
    return optionId;
  }

  public void setOptionId(DetailOptions optionId) {
    this.optionId = optionId;
  }

  public Vol getVolId() {
    return volId;
  }

  public void setVolId(Vol volId) {
    this.volId = volId;
  }

  public EventOps getEvent() {
    return event;
  }

  public void setEvent(EventOps event) {
    this.event = event;
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
    if (!(object instanceof Solution)) {
      return false;
    }
    Solution other = (Solution) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.Solution[ id=" + id + " ]";
  }

}
