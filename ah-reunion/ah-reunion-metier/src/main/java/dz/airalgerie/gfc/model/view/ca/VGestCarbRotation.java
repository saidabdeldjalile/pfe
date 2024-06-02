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
@Table(name = "V_GEST_CARB_ROTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestCarbRotation.findAll", query = "SELECT v FROM VGestCarbRotation v"),
    @NamedQuery(name = "VGestCarbRotation.findById",
        query = "SELECT v FROM VGestCarbRotation v WHERE v.id = :id"),
    @NamedQuery(name = "VGestCarbRotation.findByDateTrt",
        query = "SELECT v FROM VGestCarbRotation v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestCarbRotation.findByCodeRelat",
        query = "SELECT v FROM VGestCarbRotation v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestCarbRotation.findByRotation",
        query = "SELECT v FROM VGestCarbRotation v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestCarbRotation.findByCoutcarburant",
        query = "SELECT v FROM VGestCarbRotation v WHERE v.coutcarburant = :coutcarburant")})
public class VGestCarbRotation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Size(max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Cout_carburant")
  private BigDecimal coutcarburant;

  public VGestCarbRotation() {}

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

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public BigDecimal getCoutcarburant() {
    return coutcarburant;
  }

  public void setCoutcarburant(BigDecimal coutcarburant) {
    this.coutcarburant = coutcarburant;
  }

}
