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
@Table(name = "BALANCE_A320P_TT", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BalanceA320pTt.findAll", query = "SELECT b FROM BalanceA320pTt b"),
    @NamedQuery(name = "BalanceA320pTt.findByDateTrt",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.balanceA320pTtPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA320pTt.findByCptPart2",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.balanceA320pTtPK.cptPart2 = :cptPart2"),
    @NamedQuery(name = "BalanceA320pTt.findByIntitule",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeAntCh",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeAntCh = :soldeAntCh"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeMmCh",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeMmCh = :soldeMmCh"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeAntMmCh",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeAntMmCh = :soldeAntMmCh"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeAntPr",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeAntPr = :soldeAntPr"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeMmPr",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeMmPr = :soldeMmPr"),
    @NamedQuery(name = "BalanceA320pTt.findBySoldeAntMmPr",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.soldeAntMmPr = :soldeAntMmPr"),
    @NamedQuery(name = "BalanceA320pTt.findByEcartAnt",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.ecartAnt = :ecartAnt"),
    @NamedQuery(name = "BalanceA320pTt.findByEcartMm",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.ecartMm = :ecartMm"),
    @NamedQuery(name = "BalanceA320pTt.findByEcartAntMm",
        query = "SELECT b FROM BalanceA320pTt b WHERE b.ecartAntMm = :ecartAntMm")})
public class BalanceA320pTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA320pTtPK balanceA320pTtPK;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceA320pTt")
  private Collection<BalanceA320p> balanceA320pCollection;

  public BalanceA320pTt() {}

  public BalanceA320pTt(BalanceA320pTtPK balanceA320pTtPK) {
    this.balanceA320pTtPK = balanceA320pTtPK;
  }

  public BalanceA320pTt(BalanceA320pTtPK balanceA320pTtPK, BigDecimal soldeAntCh,
      BigDecimal soldeMmCh, BigDecimal soldeAntMmCh, BigDecimal soldeAntPr, BigDecimal soldeMmPr,
      BigDecimal soldeAntMmPr, BigDecimal ecartAnt, BigDecimal ecartMm, BigDecimal ecartAntMm) {
    this.balanceA320pTtPK = balanceA320pTtPK;
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

  public BalanceA320pTt(int dateTrt, String cptPart2) {
    this.balanceA320pTtPK = new BalanceA320pTtPK(dateTrt, cptPart2);
  }

  public BalanceA320pTtPK getBalanceA320pTtPK() {
    return balanceA320pTtPK;
  }

  public void setBalanceA320pTtPK(BalanceA320pTtPK balanceA320pTtPK) {
    this.balanceA320pTtPK = balanceA320pTtPK;
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
  public Collection<BalanceA320p> getBalanceA320pCollection() {
    return balanceA320pCollection;
  }

  public void setBalanceA320pCollection(Collection<BalanceA320p> balanceA320pCollection) {
    this.balanceA320pCollection = balanceA320pCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA320pTtPK != null ? balanceA320pTtPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA320pTt)) {
      return false;
    }
    BalanceA320pTt other = (BalanceA320pTt) object;
    if ((this.balanceA320pTtPK == null && other.balanceA320pTtPK != null)
        || (this.balanceA320pTtPK != null
            && !this.balanceA320pTtPK.equals(other.balanceA320pTtPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA320pTt[ balanceA320pTtPK=" + balanceA320pTtPK + " ]";
  }

}
