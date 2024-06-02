/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import dz.airalgerie.gfc.model.entities.ca.EcritureAnalytique;
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
@Table(name = "BALANCE_A360P_TT", schema = "CG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BalanceA360pTt.findAll", query = "SELECT b FROM BalanceA360pTt b"),
    @NamedQuery(name = "BalanceA360pTt.findByDateTrt",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.balanceA360pTtPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA360pTt.findByCptPart",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.balanceA360pTtPK.cptPart = :cptPart"),
    @NamedQuery(name = "BalanceA360pTt.findByIntitule",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeAntCh",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeAntCh = :soldeAntCh"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeMmCh",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeMmCh = :soldeMmCh"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeAntMmCh",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeAntMmCh = :soldeAntMmCh"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeAntPr",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeAntPr = :soldeAntPr"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeMmPr",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeMmPr = :soldeMmPr"),
    @NamedQuery(name = "BalanceA360pTt.findBySoldeAntMmPr",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.soldeAntMmPr = :soldeAntMmPr"),
    @NamedQuery(name = "BalanceA360pTt.findByEcartAnt",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.ecartAnt = :ecartAnt"),
    @NamedQuery(name = "BalanceA360pTt.findByEcartMm",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.ecartMm = :ecartMm"),
    @NamedQuery(name = "BalanceA360pTt.findByEcartAntMm",
        query = "SELECT b FROM BalanceA360pTt b WHERE b.ecartAntMm = :ecartAntMm")})
@SqlResultSetMapping(name = "EcritureAnalytiqueMapping",
    classes = @ConstructorResult(targetClass = EcritureAnalytique.class,
        columns = {@ColumnResult(name = "DATE_TRT", type = int.class),
            @ColumnResult(name = "CPT_PART", type = String.class),
            @ColumnResult(name = "INTITULE", type = String.class),
            @ColumnResult(name = "LIBELLE", type = String.class),
            @ColumnResult(name = "SOLDE_ANT_CH", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_MM_CH", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANT_MM_CH", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANT_PR", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_MM_PR", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANT_MM_PR", type = BigDecimal.class),
            @ColumnResult(name = "ECART_ANT", type = BigDecimal.class),
            @ColumnResult(name = "ECART_MM", type = BigDecimal.class),
            @ColumnResult(name = "ECART_ANT_MM", type = BigDecimal.class)}))
public class BalanceA360pTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA360pTtPK balanceA360pTtPK;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceA360pTt")
  private Collection<BalanceA360p> balanceA360pCollection;

  public BalanceA360pTt() {}

  public BalanceA360pTt(BalanceA360pTtPK balanceA360pTtPK) {
    this.balanceA360pTtPK = balanceA360pTtPK;
  }

  public BalanceA360pTt(BalanceA360pTtPK balanceA360pTtPK, BigDecimal soldeAntCh,
      BigDecimal soldeMmCh, BigDecimal soldeAntMmCh, BigDecimal soldeAntPr, BigDecimal soldeMmPr,
      BigDecimal soldeAntMmPr, BigDecimal ecartAnt, BigDecimal ecartMm, BigDecimal ecartAntMm) {
    this.balanceA360pTtPK = balanceA360pTtPK;
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

  public BalanceA360pTt(int dateTrt, String cptPart) {
    this.balanceA360pTtPK = new BalanceA360pTtPK(dateTrt, cptPart);
  }

  public BalanceA360pTtPK getBalanceA360pTtPK() {
    return balanceA360pTtPK;
  }

  public void setBalanceA360pTtPK(BalanceA360pTtPK balanceA360pTtPK) {
    this.balanceA360pTtPK = balanceA360pTtPK;
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
  public Collection<BalanceA360p> getBalanceA360pCollection() {
    return balanceA360pCollection;
  }

  public void setBalanceA360pCollection(Collection<BalanceA360p> balanceA360pCollection) {
    this.balanceA360pCollection = balanceA360pCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA360pTtPK != null ? balanceA360pTtPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA360pTt)) {
      return false;
    }
    BalanceA360pTt other = (BalanceA360pTt) object;
    if ((this.balanceA360pTtPK == null && other.balanceA360pTtPK != null)
        || (this.balanceA360pTtPK != null
            && !this.balanceA360pTtPK.equals(other.balanceA360pTtPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA360pTt[ balanceA360pTtPK=" + balanceA360pTtPK + " ]";
  }

}
