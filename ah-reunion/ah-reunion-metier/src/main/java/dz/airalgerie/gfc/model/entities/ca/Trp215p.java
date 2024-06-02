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
@Table(name = "TRP215P", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Trp215p.findAll", query = "SELECT t FROM Trp215p t"),
    @NamedQuery(name = "Trp215p.findByDateTrt",
        query = "SELECT t FROM Trp215p t WHERE t.trp215pPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Trp215p.findByNumLigne",
        query = "SELECT t FROM Trp215p t WHERE t.trp215pPK.numLigne = :numLigne"),
    @NamedQuery(name = "Trp215p.findByDateAaMm",
        query = "SELECT t FROM Trp215p t WHERE t.dateAaMm = :dateAaMm"),
    @NamedQuery(name = "Trp215p.findByCpt", query = "SELECT t FROM Trp215p t WHERE t.cpt = :cpt"),
    @NamedQuery(name = "Trp215p.findByEscDep",
        query = "SELECT t FROM Trp215p t WHERE t.escDep = :escDep"),
    @NamedQuery(name = "Trp215p.findByEscArv",
        query = "SELECT t FROM Trp215p t WHERE t.escArv = :escArv"),
    @NamedQuery(name = "Trp215p.findByAhd", query = "SELECT t FROM Trp215p t WHERE t.ahd = :ahd"),
    @NamedQuery(name = "Trp215p.findByAhdev",
        query = "SELECT t FROM Trp215p t WHERE t.ahdev = :ahdev"),
    @NamedQuery(name = "Trp215p.findByCie", query = "SELECT t FROM Trp215p t WHERE t.cie = :cie"),
    @NamedQuery(name = "Trp215p.findByTotal",
        query = "SELECT t FROM Trp215p t WHERE t.total = :total")})
public class Trp215p implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected Trp215pPK trp215pPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "DATE_AA_MM")
  private String dateAaMm;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT")
  private String cpt;
  @Size(max = 3)
  @Column(name = "ESC_DEP")
  private String escDep;
  @Size(max = 3)
  @Column(name = "ESC_ARV")
  private String escArv;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "AHD")
  private BigDecimal ahd;
  @Column(name = "AHDEV")
  private BigDecimal ahdev;
  @Column(name = "CIE")
  private BigDecimal cie;
  @Column(name = "TOTAL")
  private BigDecimal total;

  public Trp215p() {}

  public Trp215p(Trp215pPK trp215pPK) {
    this.trp215pPK = trp215pPK;
  }

  public Trp215p(Trp215pPK trp215pPK, String dateAaMm, String cpt) {
    this.trp215pPK = trp215pPK;
    this.dateAaMm = dateAaMm;
    this.cpt = cpt;
  }

  public Trp215p(int dateTrt, String numLigne) {
    this.trp215pPK = new Trp215pPK(dateTrt, numLigne);
  }

  public Trp215pPK getTrp215pPK() {
    return trp215pPK;
  }

  public void setTrp215pPK(Trp215pPK trp215pPK) {
    this.trp215pPK = trp215pPK;
  }

  public String getDateAaMm() {
    return dateAaMm;
  }

  public void setDateAaMm(String dateAaMm) {
    this.dateAaMm = dateAaMm;
  }

  public String getCpt() {
    return cpt;
  }

  public void setCpt(String cpt) {
    this.cpt = cpt;
  }

  public String getEscDep() {
    return escDep;
  }

  public void setEscDep(String escDep) {
    this.escDep = escDep;
  }

  public String getEscArv() {
    return escArv;
  }

  public void setEscArv(String escArv) {
    this.escArv = escArv;
  }

  public BigDecimal getAhd() {
    return ahd;
  }

  public void setAhd(BigDecimal ahd) {
    this.ahd = ahd;
  }

  public BigDecimal getAhdev() {
    return ahdev;
  }

  public void setAhdev(BigDecimal ahdev) {
    this.ahdev = ahdev;
  }

  public BigDecimal getCie() {
    return cie;
  }

  public void setCie(BigDecimal cie) {
    this.cie = cie;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (trp215pPK != null ? trp215pPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Trp215p)) {
      return false;
    }
    Trp215p other = (Trp215p) object;
    if ((this.trp215pPK == null && other.trp215pPK != null)
        || (this.trp215pPK != null && !this.trp215pPK.equals(other.trp215pPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.Trp215p[ trp215pPK=" + trp215pPK + " ]";
  }

}
