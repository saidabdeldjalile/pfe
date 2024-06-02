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
@Table(name = "V_PASSAG_TRANSP", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VPassagTransp.findAll", query = "SELECT v FROM VPassagTransp v"),
    @NamedQuery(name = "VPassagTransp.findByNbr",
        query = "SELECT v FROM VPassagTransp v WHERE v.nbr = :nbr"),
    @NamedQuery(name = "VPassagTransp.findByDateTrt",
        query = "SELECT v FROM VPassagTransp v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VPassagTransp.findByNumLigne",
        query = "SELECT v FROM VPassagTransp v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VPassagTransp.findByCodeRelat",
        query = "SELECT v FROM VPassagTransp v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VPassagTransp.findByReseau",
        query = "SELECT v FROM VPassagTransp v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VPassagTransp.findByPaxf",
        query = "SELECT v FROM VPassagTransp v WHERE v.paxf = :paxf"),
    @NamedQuery(name = "VPassagTransp.findByPaxc",
        query = "SELECT v FROM VPassagTransp v WHERE v.paxc = :paxc"),
    @NamedQuery(name = "VPassagTransp.findByPaxy",
        query = "SELECT v FROM VPassagTransp v WHERE v.paxy = :paxy"),
    @NamedQuery(name = "VPassagTransp.findByTPax",
        query = "SELECT v FROM VPassagTransp v WHERE v.tPax = :tPax"),
    @NamedQuery(name = "VPassagTransp.findByGrat",
        query = "SELECT v FROM VPassagTransp v WHERE v.grat = :grat"),
    @NamedQuery(name = "VPassagTransp.findByBb",
        query = "SELECT v FROM VPassagTransp v WHERE v.bb = :bb"),
    @NamedQuery(name = "VPassagTransp.findByTotpass",
        query = "SELECT v FROM VPassagTransp v WHERE v.totpass = :totpass"),
    @NamedQuery(name = "VPassagTransp.findByRotation",
        query = "SELECT v FROM VPassagTransp v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VPassagTransp.findByTypeApp",
        query = "SELECT v FROM VPassagTransp v WHERE v.typeApp = :typeApp")})
public class VPassagTransp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "nbr")
  private BigInteger nbr;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Column(name = "NUM_LIGNE")
  private Integer numLigne;
  @Size(max = 255)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;

  @Column(name = "PAXF")
  private Double paxf;
  @Column(name = "PAXC")
  private Double paxc;
  @Column(name = "PAXY")
  private Double paxy;
  @Column(name = "TPax")
  private Double tPax;
  @Column(name = "GRAT")
  private Double grat;
  @Column(name = "BB")
  private Double bb;
  @Column(name = "TOTPASS")
  private Double totpass;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "TYPE_APP")
  private Integer typeApp;

  public VPassagTransp() {}

  public BigInteger getNbr() {
    return nbr;
  }

  public void setNbr(BigInteger nbr) {
    this.nbr = nbr;
  }

  public Double getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Double dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Integer getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(Integer numLigne) {
    this.numLigne = numLigne;
  }

  public String getCodeRelat() {
    return codeRelat;
  }

  public void setCodeRelat(String codeRelat) {
    this.codeRelat = codeRelat;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public Double getPaxf() {
    return paxf;
  }

  public void setPaxf(Double paxf) {
    this.paxf = paxf;
  }

  public Double getPaxc() {
    return paxc;
  }

  public void setPaxc(Double paxc) {
    this.paxc = paxc;
  }

  public Double getPaxy() {
    return paxy;
  }

  public void setPaxy(Double paxy) {
    this.paxy = paxy;
  }

  public Double getTPax() {
    return tPax;
  }

  public void setTPax(Double tPax) {
    this.tPax = tPax;
  }

  public Double getGrat() {
    return grat;
  }

  public void setGrat(Double grat) {
    this.grat = grat;
  }

  public Double getBb() {
    return bb;
  }

  public void setBb(Double bb) {
    this.bb = bb;
  }

  public Double getTotpass() {
    return totpass;
  }

  public void setTotpass(Double totpass) {
    this.totpass = totpass;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public Integer getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(Integer typeApp) {
    this.typeApp = typeApp;
  }

}
