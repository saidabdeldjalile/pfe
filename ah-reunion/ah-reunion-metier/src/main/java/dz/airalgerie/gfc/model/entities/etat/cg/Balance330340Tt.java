/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import dz.airalgerie.gfc.model.entities.cg.EcritureBalance;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "CG.BALANCE_330_340_TT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balance330340Tt.findAll", query = "SELECT b FROM Balance330340Tt b"),
    @NamedQuery(name = "Balance330340Tt.findByDateTrt",
        query = "SELECT b FROM Balance330340Tt b WHERE b.balance330340TtPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Balance330340Tt.findByClasse",
        query = "SELECT b FROM Balance330340Tt b WHERE b.balance330340TtPK.classe = :classe"),
    @NamedQuery(name = "Balance330340Tt.findByIntitule",
        query = "SELECT b FROM Balance330340Tt b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "Balance330340Tt.findBySoldeOuv",
        query = "SELECT b FROM Balance330340Tt b WHERE b.soldeOuv = :soldeOuv"),
    @NamedQuery(name = "Balance330340Tt.findBySensOuv",
        query = "SELECT b FROM Balance330340Tt b WHERE b.sensOuv = :sensOuv"),
    @NamedQuery(name = "Balance330340Tt.findByDebitMm",
        query = "SELECT b FROM Balance330340Tt b WHERE b.debitMm = :debitMm"),
    @NamedQuery(name = "Balance330340Tt.findByCreditMm",
        query = "SELECT b FROM Balance330340Tt b WHERE b.creditMm = :creditMm"),
    @NamedQuery(name = "Balance330340Tt.findByDebitAnt",
        query = "SELECT b FROM Balance330340Tt b WHERE b.debitAnt = :debitAnt"),
    @NamedQuery(name = "Balance330340Tt.findByCreditAnt",
        query = "SELECT b FROM Balance330340Tt b WHERE b.creditAnt = :creditAnt"),
    @NamedQuery(name = "Balance330340Tt.findBySoldeAnt",
        query = "SELECT b FROM Balance330340Tt b WHERE b.soldeAnt = :soldeAnt"),
    @NamedQuery(name = "Balance330340Tt.findBySensAnt",
        query = "SELECT b FROM Balance330340Tt b WHERE b.sensAnt = :sensAnt")})
@SqlResultSetMapping(name = "EcritureBalanceMapping",
    classes = @ConstructorResult(targetClass = EcritureBalance.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = int.class),
            @ColumnResult(name = "CLASSE", type = String.class),
            @ColumnResult(name = "CPT_PART", type = String.class),
            @ColumnResult(name = "INTITULE", type = String.class),
            @ColumnResult(name = "SOLDE_OUV", type = BigDecimal.class),
            @ColumnResult(name = "SENS_OUV", type = BigDecimal.class),
            @ColumnResult(name = "DEBIT_ANT", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT_ANT", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANT", type = BigDecimal.class),
            @ColumnResult(name = "SENS_ANT", type = BigDecimal.class),
            @ColumnResult(name = "DEBIT_MM", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT_MM", type = BigDecimal.class)}))
public class Balance330340Tt implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected Balance330340TtPK balance330340TtPK;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "balance330340Tt")
  private Collection<Balance330p> balance330pCollection;

  public Balance330340Tt() {}

  public Balance330340Tt(Balance330340TtPK balance330340TtPK) {
    this.balance330340TtPK = balance330340TtPK;
  }

  public Balance330340Tt(Balance330340TtPK balance330340TtPK, String intitule) {
    this.balance330340TtPK = balance330340TtPK;
    this.intitule = intitule;
  }

  public Balance330340Tt(int dateTrt, String classe) {
    this.balance330340TtPK = new Balance330340TtPK(dateTrt, classe);
  }

  public Balance330340TtPK getBalance330340TtPK() {
    return balance330340TtPK;
  }

  public void setBalance330340TtPK(Balance330340TtPK balance330340TtPK) {
    this.balance330340TtPK = balance330340TtPK;
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
  public Collection<Balance330p> getBalance330pCollection() {
    return balance330pCollection;
  }

  public void setBalance330pCollection(Collection<Balance330p> balance330pCollection) {
    this.balance330pCollection = balance330pCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balance330340TtPK != null ? balance330340TtPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Balance330340Tt)) {
      return false;
    }
    Balance330340Tt other = (Balance330340Tt) object;
    if ((this.balance330340TtPK == null && other.balance330340TtPK != null)
        || (this.balance330340TtPK != null
            && !this.balance330340TtPK.equals(other.balance330340TtPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Balance330340Tt[ balance330340TtPK=" + balance330340TtPK + " ]";
  }

}
