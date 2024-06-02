/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "V_Distribution", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VDistribution.findAll", query = "SELECT v FROM VDistribution v"),
    @NamedQuery(name = "VDistribution.findById",
        query = "SELECT v FROM VDistribution v WHERE v.id = :id"),
    @NamedQuery(name = "VDistribution.findByDateTrt",
        query = "SELECT v FROM VDistribution v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VDistribution.findByCodeRelat",
        query = "SELECT v FROM VDistribution v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VDistribution.findByReseau",
        query = "SELECT v FROM VDistribution v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VDistribution.findByNumLigne",
        query = "SELECT v FROM VDistribution v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VDistribution.findByRelation",
        query = "SELECT v FROM VDistribution v WHERE v.relation = :relation"),
    @NamedQuery(name = "VDistribution.findByCoutRecetteAffaire",
        query = "SELECT v FROM VDistribution v WHERE v.coutRecetteAffaire = :coutRecetteAffaire"),
    @NamedQuery(name = "VDistribution.findByCoutDistrubution",
        query = "SELECT v FROM VDistribution v WHERE v.coutDistrubution = :coutDistrubution"),
    @NamedQuery(name = "VDistribution.findByRotation",
        query = "SELECT v FROM VDistribution v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VDistribution.findByTypeApp",
        query = "SELECT v FROM VDistribution v WHERE v.typeApp = :typeApp")})
public class VDistribution implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Size(max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Column(name = "NUM_LIGNE")
  private Short numLigne;
  @Size(max = 6)
  @Column(name = "RELATION")
  private String relation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "cout_recette_affaire")
  private BigDecimal coutRecetteAffaire;
  @Column(name = "cout_distrubution")
  private BigDecimal coutDistrubution;
  @Size(max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public VDistribution() {}

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

  public Short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(Short numLigne) {
    this.numLigne = numLigne;
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

  public BigDecimal getCoutDistrubution() {
    return coutDistrubution;
  }

  public void setCoutDistrubution(BigDecimal coutDistrubution) {
    this.coutDistrubution = coutDistrubution;
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
