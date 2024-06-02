/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "BALANCE_312P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Balance312p.findAll", query = "SELECT b FROM Balance312p b"),
    @NamedQuery(name = "Balance312p.findByDateTrt",
        query = "SELECT b FROM Balance312p b WHERE b.balance312pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Balance312p.findByCptScf",
        query = "SELECT b FROM Balance312p b WHERE b.balance312pPK.cptScf = :cptScf"),
    @NamedQuery(name = "Balance312p.findByCptPart",
        query = "SELECT b FROM Balance312p b WHERE b.balance312pPK.cptPart = :cptPart"),
    @NamedQuery(name = "Balance312p.findByLibelle",
        query = "SELECT b FROM Balance312p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "Balance312p.findBySoldeOuv",
        query = "SELECT b FROM Balance312p b WHERE b.soldeOuv = :soldeOuv"),
    @NamedQuery(name = "Balance312p.findBySensOuv",
        query = "SELECT b FROM Balance312p b WHERE b.sensOuv = :sensOuv"),
    @NamedQuery(name = "Balance312p.findByDebitMm",
        query = "SELECT b FROM Balance312p b WHERE b.debitMm = :debitMm"),
    @NamedQuery(name = "Balance312p.findByCreditMm",
        query = "SELECT b FROM Balance312p b WHERE b.creditMm = :creditMm"),
    @NamedQuery(name = "Balance312p.findByDebitAnt",
        query = "SELECT b FROM Balance312p b WHERE b.debitAnt = :debitAnt"),
    @NamedQuery(name = "Balance312p.findByCreditAnt",
        query = "SELECT b FROM Balance312p b WHERE b.creditAnt = :creditAnt"),
    @NamedQuery(name = "Balance312p.findBySoldeAnt",
        query = "SELECT b FROM Balance312p b WHERE b.soldeAnt = :soldeAnt"),
    @NamedQuery(name = "Balance312p.findBySensAnt",
        query = "SELECT b FROM Balance312p b WHERE b.sensAnt = :sensAnt")})
public class Balance312p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected Balance312pPK balance312pPK;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
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
  @JoinColumns({
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "CPT_SCF", referencedColumnName = "CPT_SCF", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Balance312pTt balance312pTt;

  public Balance312p() {}

  public Balance312p(Balance312pPK balance312pPK) {
    this.balance312pPK = balance312pPK;
  }

  public Balance312p(int dateTrt, String cptScf, String cptPart) {
    this.balance312pPK = new Balance312pPK(dateTrt, cptScf, cptPart);
  }

  public Balance312pPK getBalance312pPK() {
    return balance312pPK;
  }

  public void setBalance312pPK(Balance312pPK balance312pPK) {
    this.balance312pPK = balance312pPK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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

  public Balance312pTt getBalance312pTt() {
    return balance312pTt;
  }

  public void setBalance312pTt(Balance312pTt balance312pTt) {
    this.balance312pTt = balance312pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balance312pPK != null ? balance312pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance312p)) {
      return false;
    }
    Balance312p other = (Balance312p) object;
    if ((this.balance312pPK == null && other.balance312pPK != null)
        || (this.balance312pPK != null && !this.balance312pPK.equals(other.balance312pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance312p[ balance312pPK=" + balance312pPK + " ]";
  }

}
