/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "TRACE")
public class Trace implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  @Basic(optional = false)
  @NotNull
  @Column(name = "USER_MAT")
  private int userMat;
  @Size(max = 50)
  @Column(name = "ACTION")
  private String action;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "OLD_ENR")
  private String oldEnr;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "NEW_ENR")
  private String newEnr;

  public Trace() {}

  public Trace(Integer id) {
    this.id = id;
  }

  public Trace(Integer id, Date date, int userMat) {
    this.id = id;
    this.date = date;
    this.userMat = userMat;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getUserMat() {
    return userMat;
  }

  public void setUserMat(int userMat) {
    this.userMat = userMat;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getOldEnr() {
    return oldEnr;
  }

  public void setOldEnr(String oldEnr) {
    this.oldEnr = oldEnr;
  }

  public String getNewEnr() {
    return newEnr;
  }

  public void setNewEnr(String newEnr) {
    this.newEnr = newEnr;
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
    if (!(object instanceof Trace)) {
      return false;
    }
    Trace other = (Trace) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Trace[ id=" + id + " ]";
  }

}
