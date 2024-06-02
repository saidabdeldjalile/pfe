/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "ERRORS_LOG", schema = "COM")
@NamedQueries({
    @NamedQuery(name = "CptaErrorsLog.findAll", query = "SELECT c FROM CptaErrorsLog c")})
public class CptaErrorsLog implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 100)
  @Column(name = "HANDLER")
  private String handler;
  @Column(name = "ERROR_NUMBER")
  private Integer errorNumber;
  @Column(name = "ERROR_STATE")
  private Integer errorState;
  @Column(name = "ERROR_SEVERITY")
  private Integer errorSeverity;
  @Column(name = "ERROR_LINE")
  private Integer errorLine;
  @Size(max = 2147483647)
  @Column(name = "ERROR_PROCEDURE")
  private String errorProcedure;
  @Size(max = 2147483647)
  @Column(name = "ERROR_MESSAGE")
  private String errorMessage;
  @Column(name = "ERROR_DATETIME")
  private LocalDateTime errorDatetime;

  public CptaErrorsLog() {
  }

  public CptaErrorsLog(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHandler() {
    return handler;
  }

  public void setHandler(String handler) {
    this.handler = handler;
  }

  public Integer getErrorNumber() {
    return errorNumber;
  }

  public void setErrorNumber(Integer errorNumber) {
    this.errorNumber = errorNumber;
  }

  public Integer getErrorState() {
    return errorState;
  }

  public void setErrorState(Integer errorState) {
    this.errorState = errorState;
  }

  public Integer getErrorSeverity() {
    return errorSeverity;
  }

  public void setErrorSeverity(Integer errorSeverity) {
    this.errorSeverity = errorSeverity;
  }

  public Integer getErrorLine() {
    return errorLine;
  }

  public void setErrorLine(Integer errorLine) {
    this.errorLine = errorLine;
  }

  public String getErrorProcedure() {
    return errorProcedure;
  }

  public void setErrorProcedure(String errorProcedure) {
    this.errorProcedure = errorProcedure;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public LocalDateTime getErrorDatetime() {
    return errorDatetime;
  }

  public void setErrorDatetime(LocalDateTime errorDatetime) {
    this.errorDatetime = errorDatetime;
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
    if (!(object instanceof CptaErrorsLog)) {
      return false;
    }
    CptaErrorsLog other = (CptaErrorsLog) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.commun.CptaErrorsLog[ id=" + id + " ]";
  }

}
