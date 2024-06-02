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
@Table(name = "V_FRAIS_HOTEL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VFraisHotel.findAll", query = "SELECT v FROM VFraisHotel v"),
    @NamedQuery(name = "VFraisHotel.findById",
        query = "SELECT v FROM VFraisHotel v WHERE v.id = :id"),
    @NamedQuery(name = "VFraisHotel.findByDateTrt",
        query = "SELECT v FROM VFraisHotel v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VFraisHotel.findByNumLigne",
        query = "SELECT v FROM VFraisHotel v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VFraisHotel.findByReseau",
        query = "SELECT v FROM VFraisHotel v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VFraisHotel.findByCodeRelat",
        query = "SELECT v FROM VFraisHotel v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VFraisHotel.findByRelation",
        query = "SELECT v FROM VFraisHotel v WHERE v.relation = :relation"),
    @NamedQuery(name = "VFraisHotel.findByRotation",
        query = "SELECT v FROM VFraisHotel v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VFraisHotel.findByTypeApp",
        query = "SELECT v FROM VFraisHotel v WHERE v.typeApp = :typeApp"),
    @NamedQuery(name = "VFraisHotel.findByRecettehotel",
        query = "SELECT v FROM VFraisHotel v WHERE v.recettehotel = :recettehotel")})
public class VFraisHotel implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_TRT")
  private Double dateTrt;
  @Column(name = "NUM_LIGNE")
  private int numLigne;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
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
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Column(name = "Recette_hotel")
  private Double recettehotel;

  public VFraisHotel() {}

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

  public int getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(int numLigne) {
    this.numLigne = numLigne;
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

  public Double getRecettehotel() {
    return recettehotel;
  }

  public void setRecettehotel(Double recettehotel) {
    this.recettehotel = recettehotel;
  }

}
