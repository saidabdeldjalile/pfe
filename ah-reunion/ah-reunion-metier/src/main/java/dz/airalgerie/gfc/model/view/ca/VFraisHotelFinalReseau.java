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
@Table(name = "V_FRAIS_HOTEL_FINAL_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFraisHotelFinalReseau.findAll",
        query = "SELECT v FROM VFraisHotelFinalReseau v"),
    @NamedQuery(name = "VFraisHotelFinalReseau.findById",
        query = "SELECT v FROM VFraisHotelFinalReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VFraisHotelFinalReseau.findByDateTrt",
        query = "SELECT v FROM VFraisHotelFinalReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VFraisHotelFinalReseau.findByReseau",
        query = "SELECT v FROM VFraisHotelFinalReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VFraisHotelFinalReseau.findByRecetteHotel",
        query = "SELECT v FROM VFraisHotelFinalReseau v WHERE v.recetteHotel = :recetteHotel")})
public class VFraisHotelFinalReseau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
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
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "RECETTE_HOTEL")
  private BigDecimal recetteHotel;

  public VFraisHotelFinalReseau() {}

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

  public BigDecimal getRecetteHotel() {
    return recetteHotel;
  }

  public void setRecetteHotel(BigDecimal recetteHotel) {
    this.recetteHotel = recetteHotel;
  }

}