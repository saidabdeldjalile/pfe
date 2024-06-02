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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_CHARTER", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteCharter.findAll", query = "SELECT c FROM CpteCharter c"),
    @NamedQuery(name = "CpteCharter.findByDateTrt",
        query = "SELECT c FROM CpteCharter c WHERE c.cpteCharterPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CpteCharter.findByNumLigne",
        query = "SELECT c FROM CpteCharter c WHERE c.cpteCharterPK.numLigne = :numLigne"),
    @NamedQuery(name = "CpteCharter.findByMatrApp",
        query = "SELECT c FROM CpteCharter c WHERE c.matrApp = :matrApp"),
    @NamedQuery(name = "CpteCharter.findByTypeApp",
        query = "SELECT c FROM CpteCharter c WHERE c.typeApp = :typeApp"),
    @NamedQuery(name = "CpteCharter.findByNatureVol",
        query = "SELECT c FROM CpteCharter c WHERE c.natureVol = :natureVol"),
    @NamedQuery(name = "CpteCharter.findByRelation",
        query = "SELECT c FROM CpteCharter c WHERE c.relation = :relation"),
    @NamedQuery(name = "CpteCharter.findByCharPax",
        query = "SELECT c FROM CpteCharter c WHERE c.charPax = :charPax"),
    @NamedQuery(name = "CpteCharter.findByVentbord",
        query = "SELECT c FROM CpteCharter c WHERE c.ventbord = :ventbord"),
    @NamedQuery(name = "CpteCharter.findByCharFret",
        query = "SELECT c FROM CpteCharter c WHERE c.charFret = :charFret")})
public class CpteCharter implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CpteCharterPK cpteCharterPK;
  @Size(max = 2)
  @Column(name = "MATR_APP")
  private String matrApp;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Column(name = "NATURE_VOL")
  private Character natureVol;
  @Size(max = 6)
  @Column(name = "RELATION")
  private String relation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CHAR_PAX")
  private BigDecimal charPax;
  @Column(name = "CHAR_FRET")
  private BigDecimal charFret;

  @Column(name = "VENT_BORD")
  private BigDecimal ventbord;

  public CpteCharter() {}

  public CpteCharter(CpteCharterPK cpteCharterPK) {
    this.cpteCharterPK = cpteCharterPK;
  }

  public CpteCharter(int dateTrt, short numLigne) {
    this.cpteCharterPK = new CpteCharterPK(dateTrt, numLigne);
  }

  public CpteCharterPK getCpteCharterPK() {
    if (cpteCharterPK == null)
      cpteCharterPK = new CpteCharterPK();

    return cpteCharterPK;
  }

  public void setCpteCharterPK(CpteCharterPK cpteCharterPK) {
    this.cpteCharterPK = cpteCharterPK;
  }

  public String getMatrApp() {
    return matrApp;
  }

  public void setMatrApp(String matrApp) {
    this.matrApp = matrApp;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public Character getNatureVol() {
    return natureVol;
  }

  public void setNatureVol(Character natureVol) {
    this.natureVol = natureVol;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public BigDecimal getCharPax() {
    return charPax;
  }

  public void setCharPax(BigDecimal charPax) {
    this.charPax = charPax;
  }

  public BigDecimal getCharFret() {
    return charFret;
  }

  public void setCharFret(BigDecimal charFret) {
    this.charFret = charFret;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cpteCharterPK != null ? cpteCharterPK.hashCode() : 0);
    return hash;
  }

  public BigDecimal getVentbord() {
    return ventbord;
  }

  public void setVentbord(BigDecimal ventbord) {
    this.ventbord = ventbord;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteCharter)) {
      return false;
    }
    CpteCharter other = (CpteCharter) object;
    if ((this.cpteCharterPK == null && other.cpteCharterPK != null)
        || (this.cpteCharterPK != null && !this.cpteCharterPK.equals(other.cpteCharterPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteCharter[ cpteCharterPK=" + cpteCharterPK + " ]";
  }

}
