/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_APPAREIL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteAppareil.findAll", query = "SELECT c FROM CpteAppareil c"),
    @NamedQuery(name = "CpteAppareil.findByDateTrt",
        query = "SELECT c FROM CpteAppareil c WHERE c.cpteAppareilPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CpteAppareil.findByTypeApp",
        query = "SELECT c FROM CpteAppareil c WHERE c.cpteAppareilPK.typeApp = :typeApp"),
    @NamedQuery(name = "CpteAppareil.findByCarConsHlHdv",
        query = "SELECT c FROM CpteAppareil c WHERE c.carConsHlHdv = :carConsHlHdv"),
    @NamedQuery(name = "CpteAppareil.findByCarCoutHlInt",
        query = "SELECT c FROM CpteAppareil c WHERE c.carCoutHlInt = :carCoutHlInt"),
    @NamedQuery(name = "CpteAppareil.findByCarPartDevInt",
        query = "SELECT c FROM CpteAppareil c WHERE c.carPartDevInt = :carPartDevInt"),
    @NamedQuery(name = "CpteAppareil.findByCarCoutHlRia",
        query = "SELECT c FROM CpteAppareil c WHERE c.carCoutHlRia = :carCoutHlRia"),
    @NamedQuery(name = "CpteAppareil.findByAviCoutEco",
        query = "SELECT c FROM CpteAppareil c WHERE c.aviCoutEco = :aviCoutEco"),
    @NamedQuery(name = "CpteAppareil.findByAviCoutCpt",
        query = "SELECT c FROM CpteAppareil c WHERE c.aviCoutCpt = :aviCoutCpt"),
    @NamedQuery(name = "CpteAppareil.findByPartDevEco",
        query = "SELECT c FROM CpteAppareil c WHERE c.partDevEco = :partDevEco"),
    @NamedQuery(name = "CpteAppareil.findByPartDevCpt",
        query = "SELECT c FROM CpteAppareil c WHERE c.partDevCpt = :partDevCpt"),
    @NamedQuery(name = "CpteAppareil.findByEntCout",
        query = "SELECT c FROM CpteAppareil c WHERE c.entCout = :entCout"),
    @NamedQuery(name = "CpteAppareil.findByEntPartDev",
        query = "SELECT c FROM CpteAppareil c WHERE c.entPartDev = :entPartDev"),
    @NamedQuery(name = "CpteAppareil.findByPnCoutHdv",
        query = "SELECT c FROM CpteAppareil c WHERE c.pnCoutHdv = :pnCoutHdv"),
    @NamedQuery(name = "CpteAppareil.findByPnPartDevise",
        query = "SELECT c FROM CpteAppareil c WHERE c.pnPartDevise = :pnPartDevise")})
public class CpteAppareil implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CpteAppareilPK cpteAppareilPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CAR_CONS_HL_HDV")
  private BigDecimal carConsHlHdv;
  @Column(name = "CAR_COUT_HL_INT")
  private BigDecimal carCoutHlInt;
  @Column(name = "CAR_PART_DEV_INT")
  private BigDecimal carPartDevInt;
  @Column(name = "CAR_COUT_HL_RIA")
  private BigDecimal carCoutHlRia;
  @Column(name = "AVI_COUT_ECO")
  private BigDecimal aviCoutEco;
  @Column(name = "AVI_COUT_CPT")
  private BigDecimal aviCoutCpt;
  @Column(name = "PART_DEV_ECO")
  private BigDecimal partDevEco;
  @Column(name = "PART_DEV_CPT")
  private BigDecimal partDevCpt;
  @Column(name = "ENT_COUT")
  private BigDecimal entCout;
  @Column(name = "ENT_PART_DEV")
  private BigDecimal entPartDev;
  @Column(name = "PN_COUT_HDV")
  private BigDecimal pnCoutHdv;
  @Column(name = "PN_PART_DEVISE")
  private BigDecimal pnPartDevise;

  public CpteAppareil() {}

  public CpteAppareil(CpteAppareilPK cpteAppareilPK) {
    this.cpteAppareilPK = cpteAppareilPK;
  }

  public CpteAppareil(int dateTrt, String typeApp) {
    this.cpteAppareilPK = new CpteAppareilPK(dateTrt, typeApp);
  }

  public CpteAppareilPK getCpteAppareilPK() {
    if (cpteAppareilPK == null)
      cpteAppareilPK = new CpteAppareilPK();

    return cpteAppareilPK;
  }

  public void setCpteAppareilPK(CpteAppareilPK cpteAppareilPK) {
    this.cpteAppareilPK = cpteAppareilPK;
  }

  public BigDecimal getCarConsHlHdv() {
    return carConsHlHdv;
  }

  public void setCarConsHlHdv(BigDecimal carConsHlHdv) {
    this.carConsHlHdv = carConsHlHdv;
  }

  public BigDecimal getCarCoutHlInt() {
    return carCoutHlInt;
  }

  public void setCarCoutHlInt(BigDecimal carCoutHlInt) {
    this.carCoutHlInt = carCoutHlInt;
  }

  public BigDecimal getCarPartDevInt() {
    return carPartDevInt;
  }

  public void setCarPartDevInt(BigDecimal carPartDevInt) {
    this.carPartDevInt = carPartDevInt;
  }

  public BigDecimal getCarCoutHlRia() {
    return carCoutHlRia;
  }

  public void setCarCoutHlRia(BigDecimal carCoutHlRia) {
    this.carCoutHlRia = carCoutHlRia;
  }

  public BigDecimal getAviCoutEco() {
    return aviCoutEco;
  }

  public void setAviCoutEco(BigDecimal aviCoutEco) {
    this.aviCoutEco = aviCoutEco;
  }

  public BigDecimal getAviCoutCpt() {
    return aviCoutCpt;
  }

  public void setAviCoutCpt(BigDecimal aviCoutCpt) {
    this.aviCoutCpt = aviCoutCpt;
  }

  public BigDecimal getPartDevEco() {
    return partDevEco;
  }

  public void setPartDevEco(BigDecimal partDevEco) {
    this.partDevEco = partDevEco;
  }

  public BigDecimal getPartDevCpt() {
    return partDevCpt;
  }

  public void setPartDevCpt(BigDecimal partDevCpt) {
    this.partDevCpt = partDevCpt;
  }

  public BigDecimal getEntCout() {
    return entCout;
  }

  public void setEntCout(BigDecimal entCout) {
    this.entCout = entCout;
  }

  public BigDecimal getEntPartDev() {
    return entPartDev;
  }

  public void setEntPartDev(BigDecimal entPartDev) {
    this.entPartDev = entPartDev;
  }

  public BigDecimal getPnCoutHdv() {
    return pnCoutHdv;
  }

  public void setPnCoutHdv(BigDecimal pnCoutHdv) {
    this.pnCoutHdv = pnCoutHdv;
  }

  public BigDecimal getPnPartDevise() {
    return pnPartDevise;
  }

  public void setPnPartDevise(BigDecimal pnPartDevise) {
    this.pnPartDevise = pnPartDevise;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cpteAppareilPK != null ? cpteAppareilPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteAppareil)) {
      return false;
    }
    CpteAppareil other = (CpteAppareil) object;
    if ((this.cpteAppareilPK == null && other.cpteAppareilPK != null)
        || (this.cpteAppareilPK != null && !this.cpteAppareilPK.equals(other.cpteAppareilPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteAppareil[ cpteAppareilPK=" + cpteAppareilPK + " ]";
  }

}
