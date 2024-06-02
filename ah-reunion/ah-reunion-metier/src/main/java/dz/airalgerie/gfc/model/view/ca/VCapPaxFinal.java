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
@Table(name = "V_CAP_PAX_FINAL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VCapPaxFinal.findAll", query = "SELECT v FROM VCapPaxFinal v"),
    @NamedQuery(name = "VCapPaxFinal.findByNbr",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.nbr = :nbr"),
    @NamedQuery(name = "VCapPaxFinal.findByNumLigne",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VCapPaxFinal.findByCodeRelat",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VCapPaxFinal.findByRelation",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.relation = :relation"),
    @NamedQuery(name = "VCapPaxFinal.findByRotation",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VCapPaxFinal.findByDateTrt",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VCapPaxFinal.findByReseau",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VCapPaxFinal.findByPkt",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.pkt = :pkt"),
    @NamedQuery(name = "VCapPaxFinal.findBySko",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.sko = :sko"),
    @NamedQuery(name = "VCapPaxFinal.findByCr",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.cr = :cr"),
    @NamedQuery(name = "VCapPaxFinal.findByTypeApp",
        query = "SELECT v FROM VCapPaxFinal v WHERE v.typeApp = :typeApp")})
public class VCapPaxFinal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "nbr")
  private BigInteger nbr;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "NUM_LIGNE")
  private BigInteger numLigne;
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
  @Column(name = "PKT")
  private BigInteger pkt;
  @Column(name = "SKO")
  private BigInteger sko;
  @Column(name = "CR")
  private Double cr;
  @Column(name = "TYPE_APP")
  private BigInteger typeApp;

  public VCapPaxFinal() {}

  public BigInteger getNbr() {
    return nbr;
  }

  public void setNbr(BigInteger nbr) {
    this.nbr = nbr;
  }

  public BigInteger getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(BigInteger numLigne) {
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

  public BigInteger getPkt() {
    return pkt;
  }

  public void setPkt(BigInteger pkt) {
    this.pkt = pkt;
  }

  public BigInteger getSko() {
    return sko;
  }

  public void setSko(BigInteger sko) {
    this.sko = sko;
  }

  public Double getCr() {
    return cr;
  }

  public void setCr(Double cr) {
    this.cr = cr;
  }

  public BigInteger getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(BigInteger typeApp) {
    this.typeApp = typeApp;
  }

}
