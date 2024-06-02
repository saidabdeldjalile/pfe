/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "STATUT_VOL", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "StatutVol.findAll", query = "SELECT s FROM StatutVol s"),
    @NamedQuery(name = "StatutVol.findByCodeStatut",
        query = "SELECT s FROM StatutVol s WHERE s.codeStatut = :codeStatut"),
    @NamedQuery(name = "StatutVol.findByDescription",
        query = "SELECT s FROM StatutVol s WHERE s.description = :description"),
    @NamedQuery(name = "StatutVol.findByDateDeb",
        query = "SELECT s FROM StatutVol s WHERE s.dateDeb = :dateDeb"),
    @NamedQuery(name = "StatutVol.findByDateFin",
        query = "SELECT s FROM StatutVol s WHERE s.dateFin = :dateFin")})
public class StatutVol implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "CODE_STATUT")
  private String codeStatut;
  @Size(max = 255)
  @Column(name = "DESCRIPTION")
  private String description;
  @Column(name = "DATE_DEB")
  private LocalDate dateDeb;
  @Column(name = "DATE_FIN")
  private LocalDate dateFin;
  @OneToMany(mappedBy = "statutVol", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<Vol> volList;

  public StatutVol() {
  }

  public StatutVol(String codeStatut) {
    this.codeStatut = codeStatut;
  }

  public String getCodeStatut() {
    return codeStatut;
  }

  public void setCodeStatut(String codeStatut) {
    this.codeStatut = codeStatut;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(LocalDate dateDeb) {
    this.dateDeb = dateDeb;
  }

  public LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public List<Vol> getVolList() {
    return volList;
  }

  public void setVolList(List<Vol> volList) {
    this.volList = volList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeStatut != null ? codeStatut.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof StatutVol)) {
      return false;
    }
    StatutVol other = (StatutVol) object;
    if ((this.codeStatut == null && other.codeStatut != null)
        || (this.codeStatut != null && !this.codeStatut.equals(other.codeStatut))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.StatutVol[ codeStatut=" + codeStatut + " ]";
  }

}
