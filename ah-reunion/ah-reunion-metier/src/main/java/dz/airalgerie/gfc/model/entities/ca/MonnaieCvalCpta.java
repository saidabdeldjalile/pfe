/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "MONNAIE_CVAL", schema = "COM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonnaieCvalCpta.findAll", query = "SELECT m FROM MonnaieCvalCpta m"),
    @NamedQuery(name = "MonnaieCvalCpta.findByCodeMon",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.monnaieCvalPK.codeMon = :codeMon"),
    @NamedQuery(name = "MonnaieCvalCpta.findByDateTrt",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.monnaieCvalPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "MonnaieCvalCpta.findByCvalAld",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.cvalAld = :cvalAld"),
    @NamedQuery(name = "MonnaieCvalCpta.findByCvalUsd",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.cvalUsd = :cvalUsd"),
    @NamedQuery(name = "MonnaieCvalCpta.findByCvalNuc",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.cvalNuc = :cvalNuc"),
    @NamedQuery(name = "MonnaieCvalCpta.findByCvalRoe",
        query = "SELECT m FROM MonnaieCvalCpta m WHERE m.cvalRoe = :cvalRoe")})
public class MonnaieCvalCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected MonnaieCvalCptaPK monnaieCvalPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "CVAL_ALD")
  private BigDecimal cvalAld;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CVAL_USD")
  private BigDecimal cvalUsd;
  @Column(name = "CVAL_NUC")
  private BigDecimal cvalNuc;
  @Column(name = "CVAL_ROE")
  private BigDecimal cvalRoe;
  @JoinColumn(name = "CODE_MON", referencedColumnName = "CODE_MON", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private MonnaieCpta monnaie;

  public MonnaieCvalCpta() {}

  public MonnaieCvalCpta(MonnaieCvalCptaPK monnaieCvalPK) {
    this.monnaieCvalPK = monnaieCvalPK;
  }

  public MonnaieCvalCpta(MonnaieCvalCptaPK monnaieCvalPK, BigDecimal cvalAld, BigDecimal cvalUsd) {
    this.monnaieCvalPK = monnaieCvalPK;
    this.cvalAld = cvalAld;
    this.cvalUsd = cvalUsd;
  }

  public MonnaieCvalCpta(String codeMon, int dateTrt) {
    this.monnaieCvalPK = new MonnaieCvalCptaPK(codeMon, dateTrt);
  }

  public MonnaieCvalCptaPK getMonnaieCvalPK() {
    return monnaieCvalPK;
  }

  public void setMonnaieCvalPK(MonnaieCvalCptaPK monnaieCvalPK) {
    this.monnaieCvalPK = monnaieCvalPK;
  }

  public BigDecimal getCvalAld() {
    return cvalAld;
  }

  public void setCvalAld(BigDecimal cvalAld) {
    this.cvalAld = cvalAld;
  }

  public BigDecimal getCvalUsd() {
    return cvalUsd;
  }

  public void setCvalUsd(BigDecimal cvalUsd) {
    this.cvalUsd = cvalUsd;
  }

  public BigDecimal getCvalNuc() {
    return cvalNuc;
  }

  public void setCvalNuc(BigDecimal cvalNuc) {
    this.cvalNuc = cvalNuc;
  }

  public BigDecimal getCvalRoe() {
    return cvalRoe;
  }

  public void setCvalRoe(BigDecimal cvalRoe) {
    this.cvalRoe = cvalRoe;
  }

  public MonnaieCpta getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(MonnaieCpta monnaie) {
    this.monnaie = monnaie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (monnaieCvalPK != null ? monnaieCvalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MonnaieCvalCpta)) {
      return false;
    }
    MonnaieCvalCpta other = (MonnaieCvalCpta) object;
    if ((this.monnaieCvalPK == null && other.monnaieCvalPK != null)
        || (this.monnaieCvalPK != null && !this.monnaieCvalPK.equals(other.monnaieCvalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.MonnaieCvalCpta[ monnaieCvalPK=" + monnaieCvalPK + " ]";
  }

}
