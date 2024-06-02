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
@Table(name = "BALANCE_A330P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BalanceA330p.findAll", query = "SELECT b FROM BalanceA330p b"),
    @NamedQuery(name = "BalanceA330p.findByDateTrt",
        query = "SELECT b FROM BalanceA330p b WHERE b.balanceA330pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA330p.findByCptPart3",
        query = "SELECT b FROM BalanceA330p b WHERE b.balanceA330pPK.cptPart3 = :cptPart3"),
    @NamedQuery(name = "BalanceA330p.findByCptScf",
        query = "SELECT b FROM BalanceA330p b WHERE b.balanceA330pPK.cptScf = :cptScf"),
    @NamedQuery(name = "BalanceA330p.findByLibelle",
        query = "SELECT b FROM BalanceA330p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "BalanceA330p.findBySlodeAnt",
        query = "SELECT b FROM BalanceA330p b WHERE b.slodeAnt = :slodeAnt"),
    @NamedQuery(name = "BalanceA330p.findBySoldeMm",
        query = "SELECT b FROM BalanceA330p b WHERE b.soldeMm = :soldeMm"),
    @NamedQuery(name = "BalanceA330p.findBySoldeAntMm",
        query = "SELECT b FROM BalanceA330p b WHERE b.soldeAntMm = :soldeAntMm")})
public class BalanceA330p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA330pPK balanceA330pPK;
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
      @JoinColumn(name = "CPT_PART_3", referencedColumnName = "CPT_PART_3", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private BalanceA330pTt balanceA330pTt;

  public BalanceA330p() {}

  public BalanceA330p(BalanceA330pPK balanceA330pPK) {
    this.balanceA330pPK = balanceA330pPK;
  }

  public BalanceA330p(BalanceA330pPK balanceA330pPK, String libelle, BigDecimal slodeAnt,
      BigDecimal soldeMm, BigDecimal soldeAntMm) {
    this.balanceA330pPK = balanceA330pPK;
    this.libelle = libelle;
    this.slodeAnt = slodeAnt;
    this.soldeMm = soldeMm;
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA330p(int dateTrt, String cptPart3, String cptScf) {
    this.balanceA330pPK = new BalanceA330pPK(dateTrt, cptPart3, cptScf);
  }

  public BalanceA330pPK getBalanceA330pPK() {
    return balanceA330pPK;
  }

  public void setBalanceA330pPK(BalanceA330pPK balanceA330pPK) {
    this.balanceA330pPK = balanceA330pPK;
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

  public BalanceA330pTt getBalanceA330pTt() {
    return balanceA330pTt;
  }

  public void setBalanceA330pTt(BalanceA330pTt balanceA330pTt) {
    this.balanceA330pTt = balanceA330pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA330pPK != null ? balanceA330pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA330p)) {
      return false;
    }
    BalanceA330p other = (BalanceA330p) object;
    if ((this.balanceA330pPK == null && other.balanceA330pPK != null)
        || (this.balanceA330pPK != null && !this.balanceA330pPK.equals(other.balanceA330pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA330p[ balanceA330pPK=" + balanceA330pPK + " ]";
  }

}
