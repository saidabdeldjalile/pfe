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
@Table(name = "V_GESTIO_TAP_ROTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestioTapRotation.findAll", query = "SELECT v FROM VGestioTapRotation v"),
    @NamedQuery(name = "VGestioTapRotation.findById",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.id = :id"),
    @NamedQuery(name = "VGestioTapRotation.findByDateTrt",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestioTapRotation.findByCodeRelat",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VGestioTapRotation.findByRotation",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VGestioTapRotation.findByCoutRecetteAffaire",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.coutRecetteAffaire = :coutRecetteAffaire"),
    @NamedQuery(name = "VGestioTapRotation.findByCoutTAP",
        query = "SELECT v FROM VGestioTapRotation v WHERE v.coutTAP = :coutTAP")})
public class VGestioTapRotation implements Serializable {

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
  @Column(name = "cout_recette_affaire")
  private BigDecimal coutRecetteAffaire;
  @Column(name = "Cout_TAP")
  private BigDecimal coutTAP;

  public VGestioTapRotation() {}

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

}
