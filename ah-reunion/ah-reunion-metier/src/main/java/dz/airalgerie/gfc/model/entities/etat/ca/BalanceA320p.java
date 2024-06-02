/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "BALANCE_A320P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BalanceA320p.findAll", query = "SELECT b FROM BalanceA320p b"),
    @NamedQuery(name = "BalanceA320p.findByDateTrt",
        query = "SELECT b FROM BalanceA320p b WHERE b.balanceA320pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA320p.findByCptPart2",
        query = "SELECT b FROM BalanceA320p b WHERE b.balanceA320pPK.cptPart2 = :cptPart2"),
    @NamedQuery(name = "BalanceA320p.findByCptScf",
        query = "SELECT b FROM BalanceA320p b WHERE b.balanceA320pPK.cptScf = :cptScf"),
    @NamedQuery(name = "BalanceA320p.findByLibelle",
        query = "SELECT b FROM BalanceA320p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "BalanceA320p.findBySlodeAnt",
        query = "SELECT b FROM BalanceA320p b WHERE b.slodeAnt = :slodeAnt"),
    @NamedQuery(name = "BalanceA320p.findBySoldeMm",
        query = "SELECT b FROM BalanceA320p b WHERE b.soldeMm = :soldeMm"),
    @NamedQuery(name = "BalanceA320p.findBySoldeAntMm",
        query = "SELECT b FROM BalanceA320p b WHERE b.soldeAntMm = :soldeAntMm")})
public class BalanceA320p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA320pPK balanceA320pPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "SLODE_ANT")
  private BigDecimal slodeAnt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_MM")
  private BigDecimal soldeMm;
  @Basic(optional = false)
  @NotNull
  @Column(name = "SOLDE_ANT_MM")
  private BigDecimal soldeAntMm;
  @JoinColumns({
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "CPT_PART_2", referencedColumnName = "CPT_PART_2", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private BalanceA320pTt balanceA320pTt;

  public BalanceA320p() {}

  public BalanceA320p(BalanceA320pPK balanceA320pPK) {
    this.balanceA320pPK = balanceA320pPK;
  }

  public BalanceA320p(BalanceA320pPK balanceA320pPK, String libelle, BigDecimal slodeAnt,
      BigDecimal soldeMm, BigDecimal soldeAntMm) {
    this.balanceA320pPK = balanceA320pPK;
    this.libelle = libelle;
    this.slodeAnt = slodeAnt;
    this.soldeMm = soldeMm;
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA320p(int dateTrt, String cptPart2, String cptScf) {
    this.balanceA320pPK = new BalanceA320pPK(dateTrt, cptPart2, cptScf);
  }

  public BalanceA320pPK getBalanceA320pPK() {
    return balanceA320pPK;
  }

  public void setBalanceA320pPK(BalanceA320pPK balanceA320pPK) {
    this.balanceA320pPK = balanceA320pPK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getSlodeAnt() {
    return slodeAnt;
  }

  public void setSlodeAnt(BigDecimal slodeAnt) {
    this.slodeAnt = slodeAnt;
  }

  public BigDecimal getSoldeMm() {
    return soldeMm;
  }

  public void setSoldeMm(BigDecimal soldeMm) {
    this.soldeMm = soldeMm;
  }

  public BigDecimal getSoldeAntMm() {
    return soldeAntMm;
  }

  public void setSoldeAntMm(BigDecimal soldeAntMm) {
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA320pTt getBalanceA320pTt() {
    return balanceA320pTt;
  }

  public void setBalanceA320pTt(BalanceA320pTt balanceA320pTt) {
    this.balanceA320pTt = balanceA320pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA320pPK != null ? balanceA320pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA320p)) {
      return false;
    }
    BalanceA320p other = (BalanceA320p) object;
    if ((this.balanceA320pPK == null && other.balanceA320pPK != null)
        || (this.balanceA320pPK != null && !this.balanceA320pPK.equals(other.balanceA320pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA320p[ balanceA320pPK=" + balanceA320pPK + " ]";
  }

}
