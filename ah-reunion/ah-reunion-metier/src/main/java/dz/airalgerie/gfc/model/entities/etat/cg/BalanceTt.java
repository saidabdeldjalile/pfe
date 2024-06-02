/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "BALANCE_TT", schema = "CG")
@XmlRootElement
public class BalanceTt implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SOLDE_OUV")
  private BigDecimal soldeOuverture;
  @Size(max = 1)
  @Column(name = "SENS_OUV")
  private String sensOuverture;
  @Column(name = "DEBIT_MM")
  private BigDecimal debitMois;
  @Column(name = "CREDIT_MM")
  private BigDecimal creditMois;
  @Column(name = "DEBIT_ANT")
  private BigDecimal debitCumule;
  @Column(name = "CREDIT_ANT")
  private BigDecimal creditCumule;
  @Column(name = "SOLDE_ANT")
  private BigDecimal soldeCumule;
  @Size(max = 1)
  @Column(name = "SENS_ANT")
  private String sensCumule;

  public BalanceTt() {}

  public BalanceTt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public BigDecimal getSoldeOuverture() {
    return soldeOuverture;
  }

  public void setSoldeOuverture(BigDecimal soldeOuverture) {
    this.soldeOuverture = soldeOuverture;
  }

  public String getSensOuverture() {
    return sensOuverture;
  }

  public void setSensOuverture(String sensOuverture) {
    this.sensOuverture = sensOuverture;
  }

  public BigDecimal getDebitMois() {
    return debitMois;
  }

  public void setDebitMois(BigDecimal debitMois) {
    this.debitMois = debitMois;
  }

  public BigDecimal getCreditMois() {
    return creditMois;
  }

  public void setCreditMois(BigDecimal creditMois) {
    this.creditMois = creditMois;
  }

  public BigDecimal getDebitCumule() {
    return debitCumule;
  }

  public void setDebitCumule(BigDecimal debitCumule) {
    this.debitCumule = debitCumule;
  }

  public BigDecimal getCreditCumule() {
    return creditCumule;
  }

  public void setCreditCumule(BigDecimal creditCumule) {
    this.creditCumule = creditCumule;
  }

  public BigDecimal getSoldeCumule() {
    return soldeCumule;
  }

  public void setSoldeCumule(BigDecimal soldeCumule) {
    this.soldeCumule = soldeCumule;
  }

  public String getSensCumule() {
    return sensCumule;
  }

  public void setSensCumule(String sensCumule) {
    this.sensCumule = sensCumule;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dateTrt != null ? dateTrt.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BalanceTt)) {
      return false;
    }
    BalanceTt other = (BalanceTt) object;
    if ((this.dateTrt == null && other.dateTrt != null)
        || (this.dateTrt != null && !this.dateTrt.equals(other.dateTrt))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.gfc.entities.BalanceTt[ dateTrt=" + dateTrt + " ]";
  }

}
