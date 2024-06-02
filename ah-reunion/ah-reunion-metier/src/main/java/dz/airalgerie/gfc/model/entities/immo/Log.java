/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogId", query = "SELECT l FROM Log l WHERE l.logId = :logId"),
    @NamedQuery(name = "Log.findByLogin", query = "SELECT l FROM Log l WHERE l.login = :login"),
    @NamedQuery(name = "Log.findByOperation",
        query = "SELECT l FROM Log l WHERE l.operation = :operation"),
    @NamedQuery(name = "Log.findByIp", query = "SELECT l FROM Log l WHERE l.ip = :ip"),
    @NamedQuery(name = "Log.findByDate", query = "SELECT l FROM Log l WHERE l.date = :date")})
public class Log implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "SEQcl", sequenceName = "SEQUENCE7", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQcl")
  @Basic(optional = false)
  @Column(name = "log_id")
  private Integer logId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "login")
  private String login;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "operation")
  private String operation;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "ip")
  private String ip;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  public Log() {}

  public Log(Integer logId) {
    this.logId = logId;
  }

  public Log(Integer logId, String login, String operation, String ip, Date date) {
    this.logId = logId;
    this.login = login;
    this.operation = operation;
    this.ip = ip;
    this.date = date;
  }

  public Integer getLogId() {
    return logId;
  }

  public void setLogId(Integer logId) {
    this.logId = logId;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (logId != null ? logId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Log)) {
      return false;
    }
    Log other = (Log) object;
    if ((this.logId == null && other.logId != null)
        || (this.logId != null && !this.logId.equals(other.logId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.dsi.immo.model.Log[ logId=" + logId + " ]";
  }

}
