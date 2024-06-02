/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import dz.airalgerie.gfc.model.entities.ca.EcritureAnalytiqueDetail;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "BALANCE_A360P", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BalanceA360p.findAll", query = "SELECT b FROM BalanceA360p b"),
    @NamedQuery(name = "BalanceA360p.findByDateTrt",
        query = "SELECT b FROM BalanceA360p b WHERE b.balanceA360pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BalanceA360p.findByCptPart",
        query = "SELECT b FROM BalanceA360p b WHERE b.balanceA360pPK.cptPart = :cptPart"),
    @NamedQuery(name = "BalanceA360p.findByCptScf",
        query = "SELECT b FROM BalanceA360p b WHERE b.balanceA360pPK.cptScf = :cptScf"),
    @NamedQuery(name = "BalanceA360p.findByLibelle",
        query = "SELECT b FROM BalanceA360p b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "BalanceA360p.findBySlodeAnt",
        query = "SELECT b FROM BalanceA360p b WHERE b.slodeAnt = :slodeAnt"),
    @NamedQuery(name = "BalanceA360p.findBySoldeMm",
        query = "SELECT b FROM BalanceA360p b WHERE b.soldeMm = :soldeMm"),
    @NamedQuery(name = "BalanceA360p.findBySoldeAntMm",
        query = "SELECT b FROM BalanceA360p b WHERE b.soldeAntMm = :soldeAntMm")})
@SqlResultSetMapping(name = "EcritureAnalytiqueDetailMapping",
    classes = @ConstructorResult(targetClass = EcritureAnalytiqueDetail.class,
        columns = {@ColumnResult(name = "CPT_PART", type = String.class),
            @ColumnResult(name = "CPT_SCF", type = String.class),
            @ColumnResult(name = "LIBELLE", type = String.class),
            @ColumnResult(name = "SLODE_ANT", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_MM", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANT_MM", type = BigDecimal.class)}))

public class BalanceA360p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BalanceA360pPK balanceA360pPK;
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
      @JoinColumn(name = "CPT_PART", referencedColumnName = "CPT_PART", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private BalanceA360pTt balanceA360pTt;

  public BalanceA360p() {}

  public BalanceA360p(BalanceA360pPK balanceA360pPK) {
    this.balanceA360pPK = balanceA360pPK;
  }

  public BalanceA360p(BalanceA360pPK balanceA360pPK, String libelle, BigDecimal slodeAnt,
      BigDecimal soldeMm, BigDecimal soldeAntMm) {
    this.balanceA360pPK = balanceA360pPK;
    this.libelle = libelle;
    this.slodeAnt = slodeAnt;
    this.soldeMm = soldeMm;
    this.soldeAntMm = soldeAntMm;
  }

  public BalanceA360p(int dateTrt, String cptPart, String cptScf) {
    this.balanceA360pPK = new BalanceA360pPK(dateTrt, cptPart, cptScf);
  }

  public BalanceA360pPK getBalanceA360pPK() {
    return balanceA360pPK;
  }

  public void setBalanceA360pPK(BalanceA360pPK balanceA360pPK) {
    this.balanceA360pPK = balanceA360pPK;
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

  public BalanceA360pTt getBalanceA360pTt() {
    return balanceA360pTt;
  }

  public void setBalanceA360pTt(BalanceA360pTt balanceA360pTt) {
    this.balanceA360pTt = balanceA360pTt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (balanceA360pPK != null ? balanceA360pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceA360p)) {
      return false;
    }
    BalanceA360p other = (BalanceA360p) object;
    if ((this.balanceA360pPK == null && other.balanceA360pPK != null)
        || (this.balanceA360pPK != null && !this.balanceA360pPK.equals(other.balanceA360pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BalanceA360p[ balanceA360pPK=" + balanceA360pPK + " ]";
  }

}
