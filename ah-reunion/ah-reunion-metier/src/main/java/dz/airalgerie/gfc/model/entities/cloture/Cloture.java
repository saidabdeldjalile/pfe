/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cloture;

import dz.airalgerie.commun.model.dto.ClotureDto;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CLOTURE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Cloture.findAll", query = "SELECT c FROM Cloture c"),
    @NamedQuery(name = "Cloture.findByDateTrt",
        query = "SELECT c FROM Cloture c WHERE c.dateTrt = :dateTrt"),
    @NamedQuery(name = "Cloture.findByCloture",
        query = "SELECT c FROM Cloture c WHERE c.cloture = :cloture")})
@SqlResultSetMapping(name = "ClotureEtatMapping",
    classes = @ConstructorResult(targetClass = ClotureDto.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = int.class),
            @ColumnResult(name = "EXERCICE", type = int.class),
            @ColumnResult(name = "CAN_CLOTURE", type = boolean.class),
            @ColumnResult(name = "CAN_CANCEL_CLOTURE", type = boolean.class)}))
public class Cloture implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CLOTURE")
  private boolean cloture;

  public Cloture() {}

  public Cloture(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Cloture(Integer dateTrt, boolean cloture) {
    this.dateTrt = dateTrt;
    this.cloture = cloture;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public boolean getCloture() {
    return cloture;
  }

  public void setCloture(boolean cloture) {
    this.cloture = cloture;
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
    return "ENTITY.Cloture[ dateTrt=" + dateTrt + " ]";
  }

}
