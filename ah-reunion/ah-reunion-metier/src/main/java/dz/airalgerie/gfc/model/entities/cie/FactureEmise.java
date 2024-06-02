/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "FACTURE_EMISE", catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "FactureEmise.findAll", query = "SELECT f FROM FactureEmise f"),
    @NamedQuery(name = "FactureEmise.findByNumCie",
        query = "SELECT f FROM FactureEmise f WHERE f.factureEmisePK.numCie = :numCie"),
    @NamedQuery(name = "FactureEmise.findByNumFct",
        query = "SELECT f FROM FactureEmise f WHERE f.factureEmisePK.numFct = :numFct"),
    @NamedQuery(name = "FactureEmise.findByDateFct",
        query = "SELECT f FROM FactureEmise f WHERE f.factureEmisePK.dateFct = :dateFct"),
    @NamedQuery(name = "FactureEmise.findBySensOp",
        query = "SELECT f FROM FactureEmise f WHERE f.sensOp = :sensOp"),
    @NamedQuery(name = "FactureEmise.findByCodeMon",
        query = "SELECT f FROM FactureEmise f WHERE f.codeMon = :codeMon"),
    @NamedQuery(name = "FactureEmise.findByDateComp",
        query = "SELECT f FROM FactureEmise f WHERE f.dateComp = :dateComp"),
    @NamedQuery(name = "FactureEmise.findByLieuPrest",
        query = "SELECT f FROM FactureEmise f WHERE f.lieuPrest = :lieuPrest"),
    @NamedQuery(name = "FactureEmise.findByTotPrest",
        query = "SELECT f FROM FactureEmise f WHERE f.totPrest = :totPrest"),
    @NamedQuery(name = "FactureEmise.findByObservation",
        query = "SELECT f FROM FactureEmise f WHERE f.observation = :observation")})
public class FactureEmise implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FactureEmisePK factureEmisePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "SENS_OP", nullable = false, length = 1)
  private String sensOp;
  @Size(max = 3)
  @Column(name = "CODE_MON", length = 3)
  private String codeMon;
  @Column(name = "DATE_COMP")

  private Integer dateComp;
  @Size(max = 50)
  @Column(name = "LIEU_PREST", length = 50)
  private String lieuPrest;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TOT_PREST", precision = 12, scale = 3)
  private BigDecimal totPrest;
  @Size(max = 250)
  @Column(length = 250)
  private String observation;
  @Size(max = 2)
  @Column(name = "PERIODE")
  private String periode;

  public String getPeriode() {
    return periode;
  }

  public void setPeriode(String periode) {
    this.periode = periode;
  }

  @JoinColumn(name = "CODE_COMP", referencedColumnName = "CODE_COMP", nullable = true)
  @ManyToOne(optional = false)
  private Compensation codeComp;
  @JoinColumn(name = "NUM_CIE", referencedColumnName = "NUM_CIE", nullable = false,
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Compagnie compagnie;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "factureEmise")
  private Collection<FactureEmiseDet> factureEmiseDetCollection;
  @JoinColumn(name = "NAT_PREST", referencedColumnName = "NAT_PREST")
  @ManyToOne
  private NaturePrestation natPrest;

  public NaturePrestation getNatPrest() {
    if (natPrest == null)
      natPrest = new NaturePrestation();
    return natPrest;
  }

  public void setNatPrest(NaturePrestation natPrest) {
    this.natPrest = natPrest;
  }

  public FactureEmise() {}

  public FactureEmise(FactureEmisePK factureEmisePK) {
    this.factureEmisePK = factureEmisePK;
  }

  public FactureEmise(FactureEmisePK factureEmisePK, String sensOp) {
    this.factureEmisePK = factureEmisePK;
    this.sensOp = sensOp;
  }

  public FactureEmise(String numCie, String numFct, Date dateFct) {
    this.factureEmisePK = new FactureEmisePK(numCie, numFct, dateFct);
  }

  public FactureEmisePK getFactureEmisePK() {
    if (factureEmisePK == null)
      factureEmisePK = new FactureEmisePK();
    return factureEmisePK;
  }

  public void setFactureEmisePK(FactureEmisePK factureEmisePK) {
    this.factureEmisePK = factureEmisePK;
  }

  public String getSensOp() {
    return sensOp;
  }

  public void setSensOp(String sensOp) {
    this.sensOp = sensOp;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public Integer getDateComp() {

    return dateComp;
  }

  public void setDateComp(Integer dateComp) {
    this.dateComp = dateComp;
  }

  public String getLieuPrest() {
    return lieuPrest;
  }

  public void setLieuPrest(String lieuPrest) {
    this.lieuPrest = lieuPrest;
  }

  public BigDecimal getTotPrest() {
    return totPrest;// .setScale(2, RoundingMode.CEILING);
  }

  public void setTotPrest(BigDecimal totPrest) {
    this.totPrest = totPrest;// .setScale(2, RoundingMode.CEILING);
  }

  public String getObservation() {
    if (observation != null)
      if (observation.length() > 10)
        observation = observation.substring(0, 10);
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Compensation getCodeComp() {
    if (codeComp == null)
      codeComp = new Compensation();
    return codeComp;
  }

  public void setCodeComp(Compensation codeComp) {
    this.codeComp = codeComp;
  }

  public Compagnie getCompagnie() {
    return compagnie;
  }

  public void setCompagnie(Compagnie compagnie) {
    this.compagnie = compagnie;
  }

  @XmlTransient
  public Collection<FactureEmiseDet> getFactureEmiseDetCollection() {
    return factureEmiseDetCollection;
  }

  public void setFactureEmiseDetCollection(Collection<FactureEmiseDet> factureEmiseDetCollection) {
    this.factureEmiseDetCollection = factureEmiseDetCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (factureEmisePK != null ? factureEmisePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FactureEmise)) {
      return false;
    }
    FactureEmise other = (FactureEmise) object;
    if ((this.factureEmisePK == null && other.factureEmisePK != null)
        || (this.factureEmisePK != null && !this.factureEmisePK.equals(other.factureEmisePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.FactureEmise[ factureEmisePK=" + factureEmisePK + " ]";
  }

}
