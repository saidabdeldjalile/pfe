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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "V_VUE_AVION", schema = "CA")
@XmlRootElement

public class VVueAvion implements Serializable {

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
  @Column(name = "NUM_LIGNE")
  private int numLigne;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Column(name = "CoutAvion")
  private Double coutAvion;

  public VVueAvion() {}

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

  public int getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(int numLigne) {
    this.numLigne = numLigne;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public Double getCoutAvion() {
    return coutAvion;
  }

  public void setCoutAvion(Double coutAvion) {
    this.coutAvion = coutAvion;
  }

}
