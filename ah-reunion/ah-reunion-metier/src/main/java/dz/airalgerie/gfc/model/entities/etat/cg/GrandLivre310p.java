/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "GRAND_LIVRE_310P", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrandLivre310p.findAll", query = "SELECT g FROM GrandLivre310p g"),
    @NamedQuery(name = "GrandLivre310p.findByDateTrt",
        query = "SELECT g FROM GrandLivre310p g WHERE g.grandLivre310pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "GrandLivre310p.findByCptScf",
        query = "SELECT g FROM GrandLivre310p g WHERE g.grandLivre310pPK.cptScf = :cptScf"),
    @NamedQuery(name = "GrandLivre310p.findByIntitule",
        query = "SELECT g FROM GrandLivre310p g WHERE g.intitule = :intitule"),
    @NamedQuery(name = "GrandLivre310p.findByDebitAnt",
        query = "SELECT g FROM GrandLivre310p g WHERE g.debitAnt = :debitAnt"),
    @NamedQuery(name = "GrandLivre310p.findByCreditAnt",
        query = "SELECT g FROM GrandLivre310p g WHERE g.creditAnt = :creditAnt"),
    @NamedQuery(name = "GrandLivre310p.findBySoldeAnt",
        query = "SELECT g FROM GrandLivre310p g WHERE g.soldeAnt = :soldeAnt"),
    @NamedQuery(name = "GrandLivre310p.findBySensAnt",
        query = "SELECT g FROM GrandLivre310p g WHERE g.sensAnt = :sensAnt"),
    @NamedQuery(name = "GrandLivre310p.findByDebitMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.debitMm = :debitMm"),
    @NamedQuery(name = "GrandLivre310p.findByCreditMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.creditMm = :creditMm"),
    @NamedQuery(name = "GrandLivre310p.findByDebitAntMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.debitAntMm = :debitAntMm"),
    @NamedQuery(name = "GrandLivre310p.findByCreditAntMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.creditAntMm = :creditAntMm"),
    @NamedQuery(name = "GrandLivre310p.findBySoldeAntMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.soldeAntMm = :soldeAntMm"),
    @NamedQuery(name = "GrandLivre310p.findBySensAntMm",
        query = "SELECT g FROM GrandLivre310p g WHERE g.sensAntMm = :sensAntMm")})
public class GrandLivre310p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GrandLivre310pPK grandLivre310pPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "INTITULE")
  private String intitule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DEBIT_ANT")
  private BigDecimal debitAnt;
  @Column(name = "CREDIT_ANT")
  private BigDecimal creditAnt;
  @Column(name = "SOLDE_ANT")
  private BigDecimal soldeAnt;
  @Size(max = 1)
  @Column(name = "SENS_ANT")
  private String sensAnt;
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;
  @Column(name = "DEBIT_ANT_MM")
  private BigDecimal debitAntMm;
  @Column(name = "CREDIT_ANT_MM")
  private BigDecimal creditAntMm;
  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal soldeAntMm;
  @Size(max = 1)
  @Column(name = "SENS_ANT_MM")
  private String sensAntMm;

  public GrandLivre310p() {}

  public GrandLivre310p(GrandLivre310pPK grandLivre310pPK) {
    this.grandLivre310pPK = grandLivre310pPK;
  }

  public GrandLivre310p(GrandLivre310pPK grandLivre310pPK, String intitule) {
    this.grandLivre310pPK = grandLivre310pPK;
    this.intitule = intitule;
  }

  public GrandLivre310p(int dateTrt, String cptScf) {
    this.grandLivre310pPK = new GrandLivre310pPK(dateTrt, cptScf);
  }

  public GrandLivre310pPK getGrandLivre310pPK() {
    return grandLivre310pPK;
  }

  public void setGrandLivre310pPK(GrandLivre310pPK grandLivre310pPK) {
    this.grandLivre310pPK = grandLivre310pPK;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public BigDecimal getDebitAnt() {
    return debitAnt;
  }

  public void setDebitAnt(BigDecimal debitAnt) {
    this.debitAnt = debitAnt;
  }

  public BigDecimal getCreditAnt() {
    return creditAnt;
  }

  public void setCreditAnt(BigDecimal creditAnt) {
    this.creditAnt = creditAnt;
  }

  public BigDecimal getSoldeAnt() {
    return soldeAnt;
  }

  public void setSoldeAnt(BigDecimal soldeAnt) {
    this.soldeAnt = soldeAnt;
  }

  public String getSensAnt() {
    return sensAnt;
  }

  public void setSensAnt(String sensAnt) {
    this.sensAnt = sensAnt;
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
    hash += (grandLivre310pPK != null ? grandLivre310pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GrandLivre310p)) {
      return false;
    }
    GrandLivre310p other = (GrandLivre310p) object;
    if ((this.grandLivre310pPK == null && other.grandLivre310pPK != null)
        || (this.grandLivre310pPK != null
            && !this.grandLivre310pPK.equals(other.grandLivre310pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.GrandLivre310p[ grandLivre310pPK=" + grandLivre310pPK + " ]";
  }

}
