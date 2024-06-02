/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "CLOTURE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Cloture.findAll", query = "SELECT c FROM Cloture c"),
    @NamedQuery(name = "Cloture.findByDateTrt",
        query = "SELECT c FROM Cloture c WHERE c.dateTrt = :dateTrt"),
    @NamedQuery(name = "Cloture.findByIscloture",
        query = "SELECT c FROM Cloture c WHERE c.iscloture = :iscloture")})
public class Cloture implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Column(name = "ISCLOTURE")
  private Boolean iscloture;

  public Cloture() {}

  public Cloture(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Boolean getIscloture() {
    return iscloture;
  }

  public void setIscloture(Boolean iscloture) {
    this.iscloture = iscloture;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dateTrt != null ? dateTrt.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cloture)) {
      return false;
    }
    Cloture other = (Cloture) object;
    if ((this.dateTrt == null && other.dateTrt != null)
        || (this.dateTrt != null && !this.dateTrt.equals(other.dateTrt))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Cloture[ dateTrt=" + dateTrt + " ]";
  }

}
