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
@Table(name = "V_GEST_COUT_PN", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VGestCoutPn.findAll", query = "SELECT v FROM VGestCoutPn v"),
    @NamedQuery(name = "VGestCoutPn.findById",
        query = "SELECT v FROM VGestCoutPn v WHERE v.id = :id"),
    @NamedQuery(name = "VGestCoutPn.findByDateTrt",
        query = "SELECT v FROM VGestCoutPn v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestCoutPn.findByNumLigne",
        query = "SELECT v FROM VGestCoutPn v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VGestCoutPn.findByCodeRelat",
        query = "SELECT v FROM VGestCoutPn v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestCoutPn.findByReseau",
        query = "SELECT v FROM VGestCoutPn v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestCoutPn.findByCoutnavigant",
        query = "SELECT v FROM VGestCoutPn v WHERE v.coutnavigant = :coutnavigant"),
    @NamedQuery(name = "VGestCoutPn.findByRotation",
        query = "SELECT v FROM VGestCoutPn v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestCoutPn.findByTypeApp",
        query = "SELECT v FROM VGestCoutPn v WHERE v.typeApp = :typeApp")})
public class VGestCoutPn implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Column(name = "NUM_LIGNE")
  private Short numLigne;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Cout_navigant")
  private BigDecimal coutnavigant;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public VGestCoutPn() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(Short numLigne) {
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

  public BigDecimal getCoutnavigant() {
    return coutnavigant;
  }

  public void setCoutnavigant(BigDecimal coutnavigant) {
    this.coutnavigant = coutnavigant;
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
