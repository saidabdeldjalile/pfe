/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "GRAND_LIVRE_ANA300P", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrandLivreAna300p.findAll", query = "SELECT g FROM GrandLivreAna300p g"),
    @NamedQuery(name = "GrandLivreAna300p.findByDateTrt",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.grandLivreAna300pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "GrandLivreAna300p.findByCptPart",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.grandLivreAna300pPK.cptPart = :cptPart"),
    @NamedQuery(name = "GrandLivreAna300p.findByIntitule",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.intitule = :intitule"),
    @NamedQuery(name = "GrandLivreAna300p.findByDebitMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.debitMm = :debitMm"),
    @NamedQuery(name = "GrandLivreAna300p.findByCreditMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.creditMm = :creditMm"),
    @NamedQuery(name = "GrandLivreAna300p.findBySoldeMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.soldeMm = :soldeMm"),
    @NamedQuery(name = "GrandLivreAna300p.findByDebitAnt",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.debitAnt = :debitAnt"),
    @NamedQuery(name = "GrandLivreAna300p.findByCreditAnt",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.creditAnt = :creditAnt"),
    @NamedQuery(name = "GrandLivreAna300p.findByDebitAntMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.debitAntMm = :debitAntMm"),
    @NamedQuery(name = "GrandLivreAna300p.findByCreditAntMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.creditAntMm = :creditAntMm"),
    @NamedQuery(name = "GrandLivreAna300p.findBySoldeAntMm",
        query = "SELECT g FROM GrandLivreAna300p g WHERE g.soldeAntMm = :soldeAntMm")})
public class GrandLivreAna300p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GrandLivreAna300pPK grandLivreAna300pPK;
  @Size(max = 100)
  @Column(name = "INTITULE")
  private String intitule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;
  @Column(name = "SOLDE_MM")
  private BigDecimal soldeMm;
  @Column(name = "DEBIT_ANT")
  private BigDecimal debitAnt;
  @Column(name = "CREDIT_ANT")
  private BigDecimal creditAnt;
  @Column(name = "DEBIT_ANT_MM")
  private BigDecimal debitAntMm;
  @Column(name = "CREDIT_ANT_MM")
  private BigDecimal creditAntMm;
  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal soldeAntMm;

  public GrandLivreAna300p() {}

  public GrandLivreAna300p(GrandLivreAna300pPK grandLivreAna300pPK) {
    this.grandLivreAna300pPK = grandLivreAna300pPK;
  }

  public GrandLivreAna300p(int dateTrt, String cptPart) {
    this.grandLivreAna300pPK = new GrandLivreAna300pPK(dateTrt, cptPart);
  }

  public GrandLivreAna300pPK getGrandLivreAna300pPK() {
    return grandLivreAna300pPK;
  }

  public void setGrandLivreAna300pPK(GrandLivreAna300pPK grandLivreAna300pPK) {
    this.grandLivreAna300pPK = grandLivreAna300pPK;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
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

  public BigDecimal getSoldeMm() {
    return soldeMm;
  }

  public void setSoldeMm(BigDecimal soldeMm) {
    this.soldeMm = soldeMm;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (grandLivreAna300pPK != null ? grandLivreAna300pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GrandLivreAna300p)) {
      return false;
    }
    GrandLivreAna300p other = (GrandLivreAna300p) object;
    if ((this.grandLivreAna300pPK == null && other.grandLivreAna300pPK != null)
        || (this.grandLivreAna300pPK != null
            && !this.grandLivreAna300pPK.equals(other.grandLivreAna300pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.GrandLivreAna300p[ grandLivreAna300pPK=" + grandLivreAna300pPK + " ]";
  }

}
