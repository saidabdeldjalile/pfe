/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "GRAND_LIVRE_310P_TT", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrandLivre310pTt.findAll", query = "SELECT g FROM GrandLivre310pTt g"),
    @NamedQuery(name = "GrandLivre310pTt.findByDateTrt",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.dateTrt = :dateTrt"),
    @NamedQuery(name = "GrandLivre310pTt.findByDebitMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.debitMm = :debitMm"),
    @NamedQuery(name = "GrandLivre310pTt.findByCreditMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.creditMm = :creditMm"),
    @NamedQuery(name = "GrandLivre310pTt.findByDebitAntMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.debitAntMm = :debitAntMm"),
    @NamedQuery(name = "GrandLivre310pTt.findByCreditAntMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.creditAntMm = :creditAntMm"),
    @NamedQuery(name = "GrandLivre310pTt.findBySoldeAntMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.soldeAntMm = :soldeAntMm"),
    @NamedQuery(name = "GrandLivre310pTt.findBySensAntMm",
        query = "SELECT g FROM GrandLivre310pTt g WHERE g.sensAntMm = :sensAntMm")})
public class GrandLivre310pTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DEBIT_ANT_MM")
  private BigDecimal debitAntMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREDIT_ANT_MM")
  private BigDecimal creditAntMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal soldeAntMm;
  @Size(max = 1)
  @Column(name = "SENS_ANT_MM")
  private String sensAntMm;

  public GrandLivre310pTt() {}

  public GrandLivre310pTt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public GrandLivre310pTt(Integer dateTrt, BigDecimal debitMm, BigDecimal creditMm,
      BigDecimal debitAntMm, BigDecimal creditAntMm, BigDecimal soldeAntMm) {
    this.dateTrt = dateTrt;
    this.debitMm = debitMm;
    this.creditMm = creditMm;
    this.debitAntMm = debitAntMm;
    this.creditAntMm = creditAntMm;
    this.soldeAntMm = soldeAntMm;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public BigDecimal getDebitMm() {
    return debitMm;
  }

  public void setDebitMm(BigDecimal debitMm) {
    this.debitMm = debitMm;
  }

  public BigDecimal getCreditMm() {
    return creditMm;
  }

  public void setCreditMm(BigDecimal creditMm) {
    this.creditMm = creditMm;
  }

  public BigDecimal getDebitAntMm() {
    return debitAntMm;
  }

  public void setDebitAntMm(BigDecimal debitAntMm) {
    this.debitAntMm = debitAntMm;
  }

  public BigDecimal getCreditAntMm() {
    return creditAntMm;
  }

  public void setCreditAntMm(BigDecimal creditAntMm) {
    this.creditAntMm = creditAntMm;
  }

  public BigDecimal getSoldeAntMm() {
    return soldeAntMm;
  }

  public void setSoldeAntMm(BigDecimal soldeAntMm) {
    this.soldeAntMm = soldeAntMm;
  }

  public String getSensAntMm() {
    return sensAntMm;
  }

  public void setSensAntMm(String sensAntMm) {
    this.sensAntMm = sensAntMm;
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
    if (!(object instanceof GrandLivre310pTt)) {
      return false;
    }
    GrandLivre310pTt other = (GrandLivre310pTt) object;
    if ((this.dateTrt == null && other.dateTrt != null)
        || (this.dateTrt != null && !this.dateTrt.equals(other.dateTrt))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.GrandLivre310pTt[ dateTrt=" + dateTrt + " ]";
  }

}
