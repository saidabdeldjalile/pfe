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
@Table(name = "V_HEURE_VOL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VHeureVol.findAll", query = "SELECT v FROM VHeureVol v"),
    @NamedQuery(name = "VHeureVol.findByNbr",
        query = "SELECT v FROM VHeureVol v WHERE v.nbr = :nbr"),
    @NamedQuery(name = "VHeureVol.findByDateTrt",
        query = "SELECT v FROM VHeureVol v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VHeureVol.findByNumLigne",
        query = "SELECT v FROM VHeureVol v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VHeureVol.findByCodeRelat",
        query = "SELECT v FROM VHeureVol v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VHeureVol.findByReseau",
        query = "SELECT v FROM VHeureVol v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VHeureVol.findByHeureVol",
        query = "SELECT v FROM VHeureVol v WHERE v.heureVol = :heureVol"),
    @NamedQuery(name = "VHeureVol.findByRotation",
        query = "SELECT v FROM VHeureVol v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VHeureVol.findByTypeApp",
        query = "SELECT v FROM VHeureVol v WHERE v.typeApp = :typeApp")})
public class VHeureVol implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "nbr")
  private BigInteger nbr;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
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

  @Column(name = "Heure_Vol")
  private Double heureVol;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "TYPE_APP")
  private Integer typeApp;

  public VHeureVol() {}

  public BigInteger getNbr() {
    return nbr;
  }

  public void setNbr(BigInteger nbr) {
    this.nbr = nbr;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
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

  public Double getHeureVol() {
    return heureVol;
  }

  public void setHeureVol(Double heureVol) {
    this.heureVol = heureVol;
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
