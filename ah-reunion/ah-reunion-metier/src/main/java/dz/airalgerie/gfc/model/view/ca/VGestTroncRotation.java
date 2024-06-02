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
@Table(name = "V_GEST_TRONC_ROTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestTroncRotation.findAll", query = "SELECT v FROM VGestTroncRotation v"),
    @NamedQuery(name = "VGestTroncRotation.findById",
        query = "SELECT v FROM VGestTroncRotation v WHERE v.id = :id"),
    @NamedQuery(name = "VGestTroncRotation.findByDateTrt",
        query = "SELECT v FROM VGestTroncRotation v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestTroncRotation.findByCodeRelat",
        query = "SELECT v FROM VGestTroncRotation v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestTroncRotation.findByRotation",
        query = "SELECT v FROM VGestTroncRotation v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestTroncRotation.findByTroncon",
        query = "SELECT v FROM VGestTroncRotation v WHERE v.troncon = :troncon")})
public class VGestTroncRotation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "Troncon")
  private Integer troncon;

  public VGestTroncRotation() {}

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

  public Integer getTroncon() {
    return troncon;
  }

  public void setTroncon(Integer troncon) {
    this.troncon = troncon;
  }

}
