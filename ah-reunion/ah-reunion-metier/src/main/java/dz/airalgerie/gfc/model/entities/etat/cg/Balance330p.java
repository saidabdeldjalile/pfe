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
@Table(name = "BALANCE_330P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Balance330p.findAll", query = "SELECT b FROM Balance330p b"),
    @NamedQuery(name = "Balance330p.findByDateTrt",
        query = "SELECT b FROM Balance330p b WHERE b.balance330pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Balance330p.findByClasse",
        query = "SELECT b FROM Balance330p b WHERE b.balance330pPK.classe = :classe"),
    @NamedQuery(name = "Balance330p.findByCptScf3",
        query = "SELECT b FROM Balance330p b WHERE b.balance330pPK.cptScf3 = :cptScf3"),
    @NamedQuery(name = "Balance330p.findByLibelle",
        query = "SELECT b FROM Balance330p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "Balance330p.findBySoldeOuv",
        query = "SELECT b FROM Balance330p b WHERE b.soldeOuv = :soldeOuv"),
    @NamedQuery(name = "Balance330p.findBySensOuv",
        query = "SELECT b FROM Balance330p b WHERE b.sensOuv = :sensOuv"),
    @NamedQuery(name = "Balance330p.findByDebitMm",
        query = "SELECT b FROM Balance330p b WHERE b.debitMm = :debitMm"),
    @NamedQuery(name = "Balance330p.findByCreditMm",
        query = "SELECT b FROM Balance330p b WHERE b.creditMm = :creditMm"),
    @NamedQuery(name = "Balance330p.findByDebitAnt",
        query = "SELECT b FROM Balance330p b WHERE b.debitAnt = :debitAnt"),
    @NamedQuery(name = "Balance330p.findByCreditAnt",
        query = "SELECT b FROM Balance330p b WHERE b.creditAnt = :creditAnt"),
    @NamedQuery(name = "Balance330p.findBySoldeAnt",
        query = "SELECT b FROM Balance330p b WHERE b.soldeAnt = :soldeAnt"),
    @NamedQuery(name = "Balance330p.findBySensAnt",
        query = "SELECT b FROM Balance330p b WHERE b.sensAnt = :sensAnt")})
public class Balance330p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected Balance330pPK balance330pPK;
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
      @JoinColumn(name = "CLASSE", referencedColumnName = "CLASSE", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Balance330340Tt balance330340Tt;

  public Balance330p() {}

  public Balance330p(Balance330pPK balance330pPK) {
    this.balance330pPK = balance330pPK;
  }

  public Balance330p(int dateTrt, String classe, String cptScf3) {
    this.balance330pPK = new Balance330pPK(dateTrt, classe, cptScf3);
  }

  public Balance330pPK getBalance330pPK() {
    return balance330pPK;
  }

  public void setBalance330pPK(Balance330pPK balance330pPK) {
    this.balance330pPK = balance330pPK;
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

  public Balance330340Tt getBalance330340Tt() {
    return balance330340Tt;
  }

  public void setBalance330340Tt(Balance330340Tt balance330340Tt) {
    this.balance330340Tt = balance330340Tt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balance330pPK != null ? balance330pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance330p)) {
      return false;
    }
    Balance330p other = (Balance330p) object;
    if ((this.balance330pPK == null && other.balance330pPK != null)
        || (this.balance330pPK != null && !this.balance330pPK.equals(other.balance330pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance330p[ balance330pPK=" + balance330pPK + " ]";
  }

}
