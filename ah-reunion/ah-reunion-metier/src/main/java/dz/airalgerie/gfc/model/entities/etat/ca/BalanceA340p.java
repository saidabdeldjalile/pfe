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
@Table(name = "BALANCE_A340P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BalanceA340p.findAll", query = "SELECT b FROM BalanceA340p b"),
    @NamedQuery(name = "BalanceA340p.findByDateTrt",
        query = "SELECT b FROM BalanceA340p b WHERE b.balanceA340pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA340p.findByCptPart4",
        query = "SELECT b FROM BalanceA340p b WHERE b.balanceA340pPK.cptPart4 = :cptPart4"),
    @NamedQuery(name = "BalanceA340p.findByCptScf",
        query = "SELECT b FROM BalanceA340p b WHERE b.balanceA340pPK.cptScf = :cptScf"),
    @NamedQuery(name = "BalanceA340p.findByLibelle",
        query = "SELECT b FROM BalanceA340p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "BalanceA340p.findBySlodeAnt",
        query = "SELECT b FROM BalanceA340p b WHERE b.slodeAnt = :slodeAnt"),
    @NamedQuery(name = "BalanceA340p.findBySoldeMm",
        query = "SELECT b FROM BalanceA340p b WHERE b.soldeMm = :soldeMm"),
    @NamedQuery(name = "BalanceA340p.findBySoldeAntMm",
        query = "SELECT b FROM BalanceA340p b WHERE b.soldeAntMm = :soldeAntMm")})
public class BalanceA340p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA340pPK balanceA340pPK;
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
      @JoinColumn(name = "CPT_PART_4", referencedColumnName = "CPT_PART_4", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private BalanceA340pTt balanceA340pTt;

  public BalanceA340p() {}

  public BalanceA340p(BalanceA340pPK balanceA340pPK) {
    this.balanceA340pPK = balanceA340pPK;
  }

  public BalanceA340p(BalanceA340pPK balanceA340pPK, String libelle, BigDecimal slodeAnt,
      BigDecimal soldeMm, BigDecimal soldeAntMm) {
    this.balanceA340pPK = balanceA340pPK;
    this.libelle = libelle;
    this.slodeAnt = slodeAnt;
    this.soldeMm = soldeMm;
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA340p(int dateTrt, String cptPart4, String cptScf) {
    this.balanceA340pPK = new BalanceA340pPK(dateTrt, cptPart4, cptScf);
  }

  public BalanceA340pPK getBalanceA340pPK() {
    return balanceA340pPK;
  }

  public void setBalanceA340pPK(BalanceA340pPK balanceA340pPK) {
    this.balanceA340pPK = balanceA340pPK;
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

  public BalanceA340pTt getBalanceA340pTt() {
    return balanceA340pTt;
  }

  public void setBalanceA340pTt(BalanceA340pTt balanceA340pTt) {
    this.balanceA340pTt = balanceA340pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA340pPK != null ? balanceA340pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA340p)) {
      return false;
    }
    BalanceA340p other = (BalanceA340p) object;
    if ((this.balanceA340pPK == null && other.balanceA340pPK != null)
        || (this.balanceA340pPK != null && !this.balanceA340pPK.equals(other.balanceA340pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA340p[ balanceA340pPK=" + balanceA340pPK + " ]";
  }

}
