/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

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
@Table(name = "BALANCE_A330P_TT", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BalanceA330pTt.findAll", query = "SELECT b FROM BalanceA330pTt b"),
    @NamedQuery(name = "BalanceA330pTt.findByDateTrt",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.balanceA330pTtPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA330pTt.findByCptPart3",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.balanceA330pTtPK.cptPart3 = :cptPart3"),
    @NamedQuery(name = "BalanceA330pTt.findByIntitule",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeAntCh",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeAntCh = :soldeAntCh"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeMmCh",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeMmCh = :soldeMmCh"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeAntMmCh",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeAntMmCh = :soldeAntMmCh"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeAntPr",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeAntPr = :soldeAntPr"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeMmPr",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeMmPr = :soldeMmPr"),
    @NamedQuery(name = "BalanceA330pTt.findBySoldeAntMmPr",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.soldeAntMmPr = :soldeAntMmPr"),
    @NamedQuery(name = "BalanceA330pTt.findByEcartAnt",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.ecartAnt = :ecartAnt"),
    @NamedQuery(name = "BalanceA330pTt.findByEcartMm",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.ecartMm = :ecartMm"),
    @NamedQuery(name = "BalanceA330pTt.findByEcartAntMm",
        query = "SELECT b FROM BalanceA330pTt b WHERE b.ecartAntMm = :ecartAntMm")})
public class BalanceA330pTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA330pTtPK balanceA330pTtPK;
  @Size(max = 100)
  @Column(name = "INTITULE")
  private String intitule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_CH")
  private BigDecimal soldeAntCh;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_MM_CH")
  private BigDecimal soldeMmCh;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_MM_CH")
  private BigDecimal soldeAntMmCh;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_PR")
  private BigDecimal soldeAntPr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_MM_PR")
  private BigDecimal soldeMmPr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_MM_PR")
  private BigDecimal soldeAntMmPr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ECART_ANT")
  private BigDecimal ecartAnt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ECART_MM")
  private BigDecimal ecartMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ECART_ANT_MM")
  private BigDecimal ecartAntMm;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceA330pTt")
  private Collection<BalanceA330p> balanceA330pCollection;

  public BalanceA330pTt() {}

  public BalanceA330pTt(BalanceA330pTtPK balanceA330pTtPK) {
    this.balanceA330pTtPK = balanceA330pTtPK;
  }

  public BalanceA330pTt(BalanceA330pTtPK balanceA330pTtPK, BigDecimal soldeAntCh,
      BigDecimal soldeMmCh, BigDecimal soldeAntMmCh, BigDecimal soldeAntPr, BigDecimal soldeMmPr,
      BigDecimal soldeAntMmPr, BigDecimal ecartAnt, BigDecimal ecartMm, BigDecimal ecartAntMm) {
    this.balanceA330pTtPK = balanceA330pTtPK;
    this.soldeAntCh = soldeAntCh;
    this.soldeMmCh = soldeMmCh;
    this.soldeAntMmCh = soldeAntMmCh;
    this.soldeAntPr = soldeAntPr;
    this.soldeMmPr = soldeMmPr;
    this.soldeAntMmPr = soldeAntMmPr;
    this.ecartAnt = ecartAnt;
    this.ecartMm = ecartMm;
    this.ecartAntMm = ecartAntMm;
  }

  public BalanceA330pTt(int dateTrt, String cptPart3) {
    this.balanceA330pTtPK = new BalanceA330pTtPK(dateTrt, cptPart3);
  }

  public BalanceA330pTtPK getBalanceA330pTtPK() {
    return balanceA330pTtPK;
  }

  public void setBalanceA330pTtPK(BalanceA330pTtPK balanceA330pTtPK) {
    this.balanceA330pTtPK = balanceA330pTtPK;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public BigDecimal getSoldeAntCh() {
    return soldeAntCh;
  }

  public void setSoldeAntCh(BigDecimal soldeAntCh) {
    this.soldeAntCh = soldeAntCh;
  }

  public BigDecimal getSoldeMmCh() {
    return soldeMmCh;
  }

  public void setSoldeMmCh(BigDecimal soldeMmCh) {
    this.soldeMmCh = soldeMmCh;
  }

  public BigDecimal getSoldeAntMmCh() {
    return soldeAntMmCh;
  }

  public void setSoldeAntMmCh(BigDecimal soldeAntMmCh) {
    this.soldeAntMmCh = soldeAntMmCh;
  }

  public BigDecimal getSoldeAntPr() {
    return soldeAntPr;
  }

  public void setSoldeAntPr(BigDecimal soldeAntPr) {
    this.soldeAntPr = soldeAntPr;
  }

  public BigDecimal getSoldeMmPr() {
    return soldeMmPr;
  }

  public void setSoldeMmPr(BigDecimal soldeMmPr) {
    this.soldeMmPr = soldeMmPr;
  }

  public BigDecimal getSoldeAntMmPr() {
    return soldeAntMmPr;
  }

  public void setSoldeAntMmPr(BigDecimal soldeAntMmPr) {
    this.soldeAntMmPr = soldeAntMmPr;
  }

  public BigDecimal getEcartAnt() {
    return ecartAnt;
  }

  public void setEcartAnt(BigDecimal ecartAnt) {
    this.ecartAnt = ecartAnt;
  }

  public BigDecimal getEcartMm() {
    return ecartMm;
  }

  public void setEcartMm(BigDecimal ecartMm) {
    this.ecartMm = ecartMm;
  }

  public BigDecimal getEcartAntMm() {
    return ecartAntMm;
  }

  public void setEcartAntMm(BigDecimal ecartAntMm) {
    this.ecartAntMm = ecartAntMm;
  }

  @XmlTransient
  public Collection<BalanceA330p> getBalanceA330pCollection() {
    return balanceA330pCollection;
  }

  public void setBalanceA330pCollection(Collection<BalanceA330p> balanceA330pCollection) {
    this.balanceA330pCollection = balanceA330pCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA330pTtPK != null ? balanceA330pTtPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA330pTt)) {
      return false;
    }
    BalanceA330pTt other = (BalanceA330pTt) object;
    if ((this.balanceA330pTtPK == null && other.balanceA330pTtPK != null)
        || (this.balanceA330pTtPK != null
            && !this.balanceA330pTtPK.equals(other.balanceA330pTtPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA330pTt[ balanceA330pTtPK=" + balanceA330pTtPK + " ]";
  }

}
