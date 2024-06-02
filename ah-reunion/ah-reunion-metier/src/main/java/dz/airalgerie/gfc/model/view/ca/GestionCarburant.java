/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.ca;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "V_GEST_CARB", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionCarburant.findAll", query = "SELECT g FROM GestionCarburant g"),
    @NamedQuery(name = "GestionCarburant.findById",
        query = "SELECT g FROM GestionCarburant g WHERE g.id = :id"),
    @NamedQuery(name = "GestionCarburant.findByDateTrt",
        query = "SELECT g FROM GestionCarburant g WHERE g.dateTrt = :dateTrt"),
    @NamedQuery(name = "GestionCarburant.findByReseau",
        query = "SELECT g FROM GestionCarburant g WHERE g.reseau = :reseau"),
    @NamedQuery(name = "GestionCarburant.findByCodeRelat",
        query = "SELECT g FROM GestionCarburant g WHERE g.codeRelat = :codeRelat"),
    @NamedQuery(name = "GestionCarburant.findByNumLigne",
        query = "SELECT g FROM GestionCarburant g WHERE g.numLigne = :numLigne"),
    @NamedQuery(name = "GestionCarburant.findByCoutcarburant",
        query = "SELECT g FROM GestionCarburant g WHERE g.coutcarburant = :coutcarburant"),
    @NamedQuery(name = "GestionCarburant.findByRotation",
        query = "SELECT g FROM GestionCarburant g WHERE g.rotation = :rotation"),
    @NamedQuery(name = "GestionCarburant.findByTypeApp",
        query = "SELECT g FROM GestionCarburant g WHERE g.typeApp = :typeApp")})
public class GestionCarburant implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "id")
  private BigInteger id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Cout_carburant")
  private BigDecimal coutcarburant;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public GestionCarburant() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getCodeRelat() {
    return codeRelat;
  }

  public void setCodeRelat(String codeRelat) {
    this.codeRelat = codeRelat;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
  }

  public BigDecimal getCoutcarburant() {
    return coutcarburant;
  }

  public void setCoutcarburant(BigDecimal coutcarburant) {
    this.coutcarburant = coutcarburant;
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
