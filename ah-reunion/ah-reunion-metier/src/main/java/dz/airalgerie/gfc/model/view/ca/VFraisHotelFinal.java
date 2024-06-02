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
@Table(name = "V_FRAIS_HOTEL_FINAL", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFraisHotelFinal.findAll", query = "SELECT v FROM VFraisHotelFinal v"),
    @NamedQuery(name = "VFraisHotelFinal.findByNumb",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.numb = :numb"),
    @NamedQuery(name = "VFraisHotelFinal.findByNumLigne",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VFraisHotelFinal.findByCodeRelat",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VFraisHotelFinal.findByRelation",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.relation = :relation"),
    @NamedQuery(name = "VFraisHotelFinal.findByRotation",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VFraisHotelFinal.findByDateTrt",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VFraisHotelFinal.findByReseau",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VFraisHotelFinal.findByRecetteHotel",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.recetteHotel = :recetteHotel"),
    @NamedQuery(name = "VFraisHotelFinal.findByTypeApp",
        query = "SELECT v FROM VFraisHotelFinal v WHERE v.typeApp = :typeApp")})
public class VFraisHotelFinal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "NUMB")
  private BigInteger numb;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "NUM_LIGNE")
  private Double numLigne;
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
  @Column(name = "RESEAU")
  private String reseau;
  @Column(name = "RECETTE_HOTEL")
  private Double recetteHotel;
  @Column(name = "TYPE_APP")
  private Double typeApp;

  public VFraisHotelFinal() {}

  public BigInteger getNumb() {
    return numb;
  }

  public void setNumb(BigInteger numb) {
    this.numb = numb;
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

  public Double getRecetteHotel() {
    return recetteHotel;
  }

  public void setRecetteHotel(Double recetteHotel) {
    this.recetteHotel = recetteHotel;
  }

  public Double getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(Double typeApp) {
    this.typeApp = typeApp;
  }

}
