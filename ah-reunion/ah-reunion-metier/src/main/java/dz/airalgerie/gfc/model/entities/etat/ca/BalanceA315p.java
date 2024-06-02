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
@Table(name = "BALANCE_A315P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BalanceA315p.findAll", query = "SELECT b FROM BalanceA315p b"),
    @NamedQuery(name = "BalanceA315p.findByDateTrt",
        query = "SELECT b FROM BalanceA315p b WHERE b.balanceA315pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA315p.findByCptPart1",
        query = "SELECT b FROM BalanceA315p b WHERE b.balanceA315pPK.cptPart1 = :cptPart1"),
    @NamedQuery(name = "BalanceA315p.findByCptScf",
        query = "SELECT b FROM BalanceA315p b WHERE b.balanceA315pPK.cptScf = :cptScf"),
    @NamedQuery(name = "BalanceA315p.findByLibelle",
        query = "SELECT b FROM BalanceA315p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "BalanceA315p.findBySlodeAnt",
        query = "SELECT b FROM BalanceA315p b WHERE b.slodeAnt = :slodeAnt"),
    @NamedQuery(name = "BalanceA315p.findBySoldeMm",
        query = "SELECT b FROM BalanceA315p b WHERE b.soldeMm = :soldeMm"),
    @NamedQuery(name = "BalanceA315p.findBySoldeAntMm",
        query = "SELECT b FROM BalanceA315p b WHERE b.soldeAntMm = :soldeAntMm")})
public class BalanceA315p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA315pPK balanceA315pPK;
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
      @JoinColumn(name = "CPT_PART_1", referencedColumnName = "CPT_PART_1", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private BalanceA315pTt balanceA315pTt;

  public BalanceA315p() {}

  public BalanceA315p(BalanceA315pPK balanceA315pPK) {
    this.balanceA315pPK = balanceA315pPK;
  }

  public BalanceA315p(BalanceA315pPK balanceA315pPK, String libelle, BigDecimal slodeAnt,
      BigDecimal soldeMm, BigDecimal soldeAntMm) {
    this.balanceA315pPK = balanceA315pPK;
    this.libelle = libelle;
    this.slodeAnt = slodeAnt;
    this.soldeMm = soldeMm;
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA315p(int dateTrt, String cptPart1, String cptScf) {
    this.balanceA315pPK = new BalanceA315pPK(dateTrt, cptPart1, cptScf);
  }

  public BalanceA315pPK getBalanceA315pPK() {
    return balanceA315pPK;
  }

  public void setBalanceA315pPK(BalanceA315pPK balanceA315pPK) {
    this.balanceA315pPK = balanceA315pPK;
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

  public BalanceA315pTt getBalanceA315pTt() {
    return balanceA315pTt;
  }

  public void setBalanceA315pTt(BalanceA315pTt balanceA315pTt) {
    this.balanceA315pTt = balanceA315pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA315pPK != null ? balanceA315pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA315p)) {
      return false;
    }
    BalanceA315p other = (BalanceA315p) object;
    if ((this.balanceA315pPK == null && other.balanceA315pPK != null)
        || (this.balanceA315pPK != null && !this.balanceA315pPK.equals(other.balanceA315pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA315p[ balanceA315pPK=" + balanceA315pPK + " ]";
  }

}
