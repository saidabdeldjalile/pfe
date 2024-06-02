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
@Table(name = "V_GEST_SURV", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VGestSurv.findAll", query = "SELECT v FROM VGestSurv v"),
    @NamedQuery(name = "VGestSurv.findById", query = "SELECT v FROM VGestSurv v WHERE v.id = :id"),
    @NamedQuery(name = "VGestSurv.findByReseau",
        query = "SELECT v FROM VGestSurv v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestSurv.findByDateTrt",
        query = "SELECT v FROM VGestSurv v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestSurv.findByNumLigne",
        query = "SELECT v FROM VGestSurv v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VGestSurv.findByCodeRelat",
        query = "SELECT v FROM VGestSurv v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestSurv.findByCoutSurvol",
        query = "SELECT v FROM VGestSurv v WHERE v.coutSurvol = :coutSurvol"),
    @NamedQuery(name = "VGestSurv.findByRelation",
        query = "SELECT v FROM VGestSurv v WHERE v.relation = :relation"),
    @NamedQuery(name = "VGestSurv.findByRotation",
        query = "SELECT v FROM VGestSurv v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestSurv.findByTypeApp",
        query = "SELECT v FROM VGestSurv v WHERE v.typeApp = :typeApp")})
public class VGestSurv implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Column(name = "NUM_LIGNE")
  private int numLigne;
  @Size(max = 255)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Column(name = "Cout_Survol")
  private Double coutSurvol;
  @Size(max = 255)
  @Column(name = "RELATION")
  private String relation;
  @Size(max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public VGestSurv() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public Double getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Double dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(int numLigne) {
    this.numLigne = numLigne;
  }

  public String getCodeRelat() {
    return codeRelat;
  }

  public void setCodeRelat(String codeRelat) {
    this.codeRelat = codeRelat;
  }

  public Double getCoutSurvol() {
    return coutSurvol;
  }

  public void setCoutSurvol(Double coutSurvol) {
    this.coutSurvol = coutSurvol;
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

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

}
