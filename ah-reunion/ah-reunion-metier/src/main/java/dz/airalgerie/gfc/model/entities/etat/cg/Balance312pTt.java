/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "BALANCE_312P_TT", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Balance312pTt.findAll", query = "SELECT b FROM Balance312pTt b"),
    @NamedQuery(name = "Balance312pTt.findByDateTrt",
        query = "SELECT b FROM Balance312pTt b WHERE b.balance312pTtPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Balance312pTt.findByCptScf",
        query = "SELECT b FROM Balance312pTt b WHERE b.balance312pTtPK.cptScf = :cptScf"),
    @NamedQuery(name = "Balance312pTt.findByIntitule",
        query = "SELECT b FROM Balance312pTt b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "Balance312pTt.findBySoldeOuv",
        query = "SELECT b FROM Balance312pTt b WHERE b.soldeOuv = :soldeOuv"),
    @NamedQuery(name = "Balance312pTt.findBySensOuv",
        query = "SELECT b FROM Balance312pTt b WHERE b.sensOuv = :sensOuv"),
    @NamedQuery(name = "Balance312pTt.findByDebitMm",
        query = "SELECT b FROM Balance312pTt b WHERE b.debitMm = :debitMm"),
    @NamedQuery(name = "Balance312pTt.findByCreditMm",
        query = "SELECT b FROM Balance312pTt b WHERE b.creditMm = :creditMm"),
    @NamedQuery(name = "Balance312pTt.findByDebitAnt",
        query = "SELECT b FROM Balance312pTt b WHERE b.debitAnt = :debitAnt"),
    @NamedQuery(name = "Balance312pTt.findByCreditAnt",
        query = "SELECT b FROM Balance312pTt b WHERE b.creditAnt = :creditAnt"),
    @NamedQuery(name = "Balance312pTt.findBySoldeAnt",
        query = "SELECT b FROM Balance312pTt b WHERE b.soldeAnt = :soldeAnt"),
    @NamedQuery(name = "Balance312pTt.findBySensAnt",
        query = "SELECT b FROM Balance312pTt b WHERE b.sensAnt = :sensAnt")})
public class Balance312pTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected Balance312pTtPK balance312pTtPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "INTITULE")
  private String intitule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SOLDE_OUV")
  private BigDecimal soldeOuv;
  @Size(max = 1)
  @Column(name = "SENS_OUV")
  private String sensOuv;
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMm;
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMm;
  @Column(name = "DEBIT_ANT")
  private BigDecimal debitAnt;
  @Column(name = "CREDIT_ANT")
  private BigDecimal creditAnt;
  @Column(name = "SOLDE_ANT")
  private BigDecimal soldeAnt;
  @Size(max = 1)
  @Column(name = "SENS_ANT")
  private String sensAnt;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "balance312pTt")
  private Collection<Balance312p> balance312pCollection;

  public Balance312pTt() {}

  public Balance312pTt(Balance312pTtPK balance312pTtPK) {
    this.balance312pTtPK = balance312pTtPK;
  }

  public Balance312pTt(Balance312pTtPK balance312pTtPK, String intitule) {
    this.balance312pTtPK = balance312pTtPK;
    this.intitule = intitule;
  }

  public Balance312pTt(int dateTrt, String cptScf) {
    this.balance312pTtPK = new Balance312pTtPK(dateTrt, cptScf);
  }

  public Balance312pTtPK getBalance312pTtPK() {
    return balance312pTtPK;
  }

  public void setBalance312pTtPK(Balance312pTtPK balance312pTtPK) {
    this.balance312pTtPK = balance312pTtPK;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public BigDecimal getSoldeOuv() {
    return soldeOuv;
  }

  public void setSoldeOuv(BigDecimal soldeOuv) {
    this.soldeOuv = soldeOuv;
  }

  public String getSensOuv() {
    return sensOuv;
  }

  public void setSensOuv(String sensOuv) {
    this.sensOuv = sensOuv;
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

  @XmlTransient
  public Collection<Balance312p> getBalance312pCollection() {
    return balance312pCollection;
  }

  public void setBalance312pCollection(Collection<Balance312p> balance312pCollection) {
    this.balance312pCollection = balance312pCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balance312pTtPK != null ? balance312pTtPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance312pTt)) {
      return false;
    }
    Balance312pTt other = (Balance312pTt) object;
    if ((this.balance312pTtPK == null && other.balance312pTtPK != null)
        || (this.balance312pTtPK != null && !this.balance312pTtPK.equals(other.balance312pTtPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance312pTt[ balance312pTtPK=" + balance312pTtPK + " ]";
  }

}
