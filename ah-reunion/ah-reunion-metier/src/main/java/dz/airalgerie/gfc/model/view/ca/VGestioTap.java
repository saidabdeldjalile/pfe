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
@Table(name = "V_GESTIO_TAP", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VGestioTap.findAll", query = "SELECT v FROM VGestioTap v"),
    @NamedQuery(name = "VGestioTap.findById",
        query = "SELECT v FROM VGestioTap v WHERE v.id = :id"),
    @NamedQuery(name = "VGestioTap.findByDateTrt",
        query = "SELECT v FROM VGestioTap v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestioTap.findByReseau",
        query = "SELECT v FROM VGestioTap v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestioTap.findByCodeRelat",
        query = "SELECT v FROM VGestioTap v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestioTap.findByRelation",
        query = "SELECT v FROM VGestioTap v WHERE v.relation = :relation"),
    @NamedQuery(name = "VGestioTap.findByCoutRecetteAffaire",
        query = "SELECT v FROM VGestioTap v WHERE v.coutRecetteAffaire = :coutRecetteAffaire"),
    @NamedQuery(name = "VGestioTap.findByCoutTAP",
        query = "SELECT v FROM VGestioTap v WHERE v.coutTAP = :coutTAP"),
    @NamedQuery(name = "VGestioTap.findByRotation",
        query = "SELECT v FROM VGestioTap v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestioTap.findByNumLigne",
        query = "SELECT v FROM VGestioTap v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VGestioTap.findByTypeApp",
        query = "SELECT v FROM VGestioTap v WHERE v.typeApp = :typeApp")})
public class VGestioTap implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Size(max = 6)
  @Column(name = "RELATION")
  private String relation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "cout_recette_affaire")
  private BigDecimal coutRecetteAffaire;
  @Column(name = "Cout_TAP")
  private BigDecimal coutTAP;
  @Size(max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "NUM_LIGNE")
  private Short numLigne;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public VGestioTap() {}

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

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public BigDecimal getCoutRecetteAffaire() {
    return coutRecetteAffaire;
  }

  public void setCoutRecetteAffaire(BigDecimal coutRecetteAffaire) {
    this.coutRecetteAffaire = coutRecetteAffaire;
  }

  public BigDecimal getCoutTAP() {
    return coutTAP;
  }

  public void setCoutTAP(BigDecimal coutTAP) {
    this.coutTAP = coutTAP;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public Short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(Short numLigne) {
    this.numLigne = numLigne;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

}
