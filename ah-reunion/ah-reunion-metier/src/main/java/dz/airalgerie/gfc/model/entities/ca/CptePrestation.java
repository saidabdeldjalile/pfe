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
@Table(name = "CPTE_PRESTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CptePrestation.findAll", query = "SELECT c FROM CptePrestation c"),
    @NamedQuery(name = "CptePrestation.findByDateTrt",
        query = "SELECT c FROM CptePrestation c WHERE c.cptePrestationPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CptePrestation.findByCodePre",
        query = "SELECT c FROM CptePrestation c WHERE c.cptePrestationPK.codePre = :codePre"),
    @NamedQuery(name = "CptePrestation.findByCoutUnitFirst",
        query = "SELECT c FROM CptePrestation c WHERE c.coutUnitFirst = :coutUnitFirst"),
    @NamedQuery(name = "CptePrestation.findByCoutUnitEco",
        query = "SELECT c FROM CptePrestation c WHERE c.coutUnitEco = :coutUnitEco"),
    @NamedQuery(name = "CptePrestation.findByCoutUnitAff",
        query = "SELECT c FROM CptePrestation c WHERE c.coutUnitAff = :coutUnitAff"),
    @NamedQuery(name = "CptePrestation.findByHeureDeb",
        query = "SELECT c FROM CptePrestation c WHERE c.heureDeb = :heureDeb"),
    @NamedQuery(name = "CptePrestation.findByHeureFin",
        query = "SELECT c FROM CptePrestation c WHERE c.heureFin = :heureFin")})
public class CptePrestation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CptePrestationPK cptePrestationPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "COUT_UNIT_FIRST")
  private BigDecimal coutUnitFirst;
  @Basic(optional = false)
  @NotNull
  @Column(name = "COUT_UNIT_ECO")
  private BigDecimal coutUnitEco;
  @Basic(optional = false)
  @NotNull
  @Column(name = "COUT_UNIT_AFF")
  private BigDecimal coutUnitAff;
  @Column(name = "HEURE_DEB")
  private Short heureDeb;
  @Column(name = "HEURE_FIN")
  private Short heureFin;
  @JoinColumn(name = "CODE_PRE", referencedColumnName = "CODE_PRE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Prestation prestation;

  public CptePrestation() {}

  public CptePrestation(CptePrestationPK cptePrestationPK) {
    this.cptePrestationPK = cptePrestationPK;
  }

  public CptePrestation(CptePrestationPK cptePrestationPK, BigDecimal coutUnitFirst,
      BigDecimal coutUnitEco, BigDecimal coutUnitAff) {
    this.cptePrestationPK = cptePrestationPK;
    this.coutUnitFirst = coutUnitFirst;
    this.coutUnitEco = coutUnitEco;
    this.coutUnitAff = coutUnitAff;
  }

  public CptePrestation(int dateTrt, int codePre) {
    this.cptePrestationPK = new CptePrestationPK(dateTrt, codePre);
  }

  public CptePrestationPK getCptePrestationPK() {
    if (cptePrestationPK == null)
      cptePrestationPK = new CptePrestationPK();

    return cptePrestationPK;
  }

  public void setCptePrestationPK(CptePrestationPK cptePrestationPK) {
    this.cptePrestationPK = cptePrestationPK;
  }

  public BigDecimal getCoutUnitFirst() {
    return coutUnitFirst;
  }

  public void setCoutUnitFirst(BigDecimal coutUnitFirst) {
    this.coutUnitFirst = coutUnitFirst;
  }

  public BigDecimal getCoutUnitEco() {
    return coutUnitEco;
  }

  public void setCoutUnitEco(BigDecimal coutUnitEco) {
    this.coutUnitEco = coutUnitEco;
  }

  public BigDecimal getCoutUnitAff() {
    return coutUnitAff;
  }

  public void setCoutUnitAff(BigDecimal coutUnitAff) {
    this.coutUnitAff = coutUnitAff;
  }

  public Short getHeureDeb() {
    return heureDeb;
  }

  public void setHeureDeb(Short heureDeb) {
    this.heureDeb = heureDeb;
  }

  public Short getHeureFin() {
    return heureFin;
  }

  public void setHeureFin(Short heureFin) {
    this.heureFin = heureFin;
  }

  public Prestation getPrestation() {
    return prestation;
  }

  public void setPrestation(Prestation prestation) {
    this.prestation = prestation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cptePrestationPK != null ? cptePrestationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CptePrestation)) {
      return false;
    }
    CptePrestation other = (CptePrestation) object;
    if ((this.cptePrestationPK == null && other.cptePrestationPK != null)
        || (this.cptePrestationPK != null
            && !this.cptePrestationPK.equals(other.cptePrestationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CptePrestation[ cptePrestationPK=" + cptePrestationPK + " ]";
  }

}
