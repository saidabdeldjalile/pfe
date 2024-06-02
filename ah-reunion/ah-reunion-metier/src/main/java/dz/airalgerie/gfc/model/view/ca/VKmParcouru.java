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
@Table(name = "V_KM_PARCOURU", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VKmParcouru.findAll", query = "SELECT v FROM VKmParcouru v"),
    @NamedQuery(name = "VKmParcouru.findByNbr",
        query = "SELECT v FROM VKmParcouru v WHERE v.nbr = :nbr"),
    @NamedQuery(name = "VKmParcouru.findByDateTrt",
        query = "SELECT v FROM VKmParcouru v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VKmParcouru.findByNumLigne",
        query = "SELECT v FROM VKmParcouru v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VKmParcouru.findByCodeRelat",
        query = "SELECT v FROM VKmParcouru v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VKmParcouru.findByReseau",
        query = "SELECT v FROM VKmParcouru v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VKmParcouru.findByRelation",
        query = "SELECT v FROM VKmParcouru v WHERE v.relation = :relation"),
    @NamedQuery(name = "VKmParcouru.findByTroncon",
        query = "SELECT v FROM VKmParcouru v WHERE v.troncon = :troncon"),
    @NamedQuery(name = "VKmParcouru.findByRotation",
        query = "SELECT v FROM VKmParcouru v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VKmParcouru.findByTypeApp",
        query = "SELECT v FROM VKmParcouru v WHERE v.typeApp = :typeApp")})
public class VKmParcouru implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "nbr")
  private BigInteger nbr;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Column(name = "NUM_LIGNE")
  private Double numLigne;
  @Size(max = 255)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Size(max = 255)
  @Column(name = "RELATION")
  private String relation;
  @Column(name = "Troncon")
  private Double troncon;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "TYPE_APP")
  private Double typeApp;

  public VKmParcouru() {}

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

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public Double getTroncon() {
    return troncon;
  }

  public void setTroncon(Double troncon) {
    this.troncon = troncon;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public Double getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(Double typeApp) {
    this.typeApp = typeApp;
  }

}
