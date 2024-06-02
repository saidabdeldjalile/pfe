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
@Table(name = "V_cout_escal", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Vcoutescal.findAll", query = "SELECT v FROM Vcoutescal v"),
    @NamedQuery(name = "Vcoutescal.findById",
        query = "SELECT v FROM Vcoutescal v WHERE v.id = :id"),
    @NamedQuery(name = "Vcoutescal.findByDateTrt",
        query = "SELECT v FROM Vcoutescal v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "Vcoutescal.findByCodeRelat",
        query = "SELECT v FROM Vcoutescal v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "Vcoutescal.findByReseau",
        query = "SELECT v FROM Vcoutescal v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "Vcoutescal.findByNumLigne",
        query = "SELECT v FROM Vcoutescal v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "Vcoutescal.findByRelation",
        query = "SELECT v FROM Vcoutescal v WHERE v.relation = :relation"),
    @NamedQuery(name = "Vcoutescal.findByTypeApp",
        query = "SELECT v FROM Vcoutescal v WHERE v.typeApp = :typeApp"),
    @NamedQuery(name = "Vcoutescal.findByCoutFSCAL",
        query = "SELECT v FROM Vcoutescal v WHERE v.coutFSCAL = :coutFSCAL"),
    @NamedQuery(name = "Vcoutescal.findByRotation",
        query = "SELECT v FROM Vcoutescal v WHERE v.rotation = :rotation")})
public class Vcoutescal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Size(max = 255)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Column(name = "NUM_LIGNE")
  private int numLigne;
  @Size(max = 255)
  @Column(name = "RELATION")
  private String relation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Column(name = "cout_FSCAL")
  private Double coutFSCAL;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;

  public Vcoutescal() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public Double getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Double dateTrt) {
    this.dateTrt = dateTrt;
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

  public int getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(int numLigne) {
    this.numLigne = numLigne;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public Double getCoutFSCAL() {
    return coutFSCAL;
  }

  public void setCoutFSCAL(Double coutFSCAL) {
    this.coutFSCAL = coutFSCAL;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

}
