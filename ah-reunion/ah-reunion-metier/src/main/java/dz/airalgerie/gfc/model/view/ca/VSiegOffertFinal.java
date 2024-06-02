/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.ca;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "V_SIEG_OFFERT_FINAL", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSiegOffertFinal.findAll", query = "SELECT v FROM VSiegOffertFinal v"),
    @NamedQuery(name = "VSiegOffertFinal.findByNbr",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.nbr = :nbr"),
    @NamedQuery(name = "VSiegOffertFinal.findByNumLigne",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VSiegOffertFinal.findByCodeRelat",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VSiegOffertFinal.findByRelation",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.relation = :relation"),
    @NamedQuery(name = "VSiegOffertFinal.findByRotation",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VSiegOffertFinal.findByDateTrt",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VSiegOffertFinal.findByReseau",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VSiegOffertFinal.findBySof",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.sof = :sof"),
    @NamedQuery(name = "VSiegOffertFinal.findBySoc",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.soc = :soc"),
    @NamedQuery(name = "VSiegOffertFinal.findBySoy",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.soy = :soy"),
    @NamedQuery(name = "VSiegOffertFinal.findByTotalsieg",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.totalsieg = :totalsieg"),
    @NamedQuery(name = "VSiegOffertFinal.findByTypeApp",
        query = "SELECT v FROM VSiegOffertFinal v WHERE v.typeApp = :typeApp")})
public class VSiegOffertFinal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "nbr")
  private BigInteger nbr;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "NUM_LIGNE")
  private Double numLigne;
  @Size(max = 255)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Size(max = 255)
  @Column(name = "RELATION")
  private String relation;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "reseau")
  private String reseau;
  @Column(name = "SOF")
  private Double sof;
  @Column(name = "SOC")
  private Double soc;
  @Column(name = "SOY")
  private Double soy;
  @Column(name = "Total_sieg")
  private Double totalsieg;
  @Column(name = "TYPE_APP")
  private Double typeApp;

  public VSiegOffertFinal() {}

  public BigInteger getNbr() {
    return nbr;
  }

  public void setNbr(BigInteger nbr) {
    this.nbr = nbr;
  }

  public Double getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(Double numLigne) {
    this.numLigne = numLigne;
  }

  public String getCodeRelat() {
    return codeRelat;
  }

  public void setCodeRelat(String codeRelat) {
    this.codeRelat = codeRelat;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public Double getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Double dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public Double getSof() {
    return sof;
  }

  public void setSof(Double sof) {
    this.sof = sof;
  }

  public Double getSoc() {
    return soc;
  }

  public void setSoc(Double soc) {
    this.soc = soc;
  }

  public Double getSoy() {
    return soy;
  }

  public void setSoy(Double soy) {
    this.soy = soy;
  }

  public Double getTotalsieg() {
    return totalsieg;
  }

  public void setTotalsieg(Double totalsieg) {
    this.totalsieg = totalsieg;
  }

  public Double getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(Double typeApp) {
    this.typeApp = typeApp;
  }

}
