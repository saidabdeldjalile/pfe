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
@Table(name = "V_VUE_AVION_ROTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VVueAvionRotation.findAll", query = "SELECT v FROM VVueAvionRotation v"),
    @NamedQuery(name = "VVueAvionRotation.findById",
        query = "SELECT v FROM VVueAvionRotation v WHERE v.id = :id"),
    @NamedQuery(name = "VVueAvionRotation.findByDateTrt",
        query = "SELECT v FROM VVueAvionRotation v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VVueAvionRotation.findByCodeRelat",
        query = "SELECT v FROM VVueAvionRotation v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VVueAvionRotation.findByRotation",
        query = "SELECT v FROM VVueAvionRotation v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VVueAvionRotation.findByCoutAvion",
        query = "SELECT v FROM VVueAvionRotation v WHERE v.coutAvion = :coutAvion")})
public class VVueAvionRotation implements Serializable {

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
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CoutAvion")
  private BigDecimal coutAvion;

  public VVueAvionRotation() {}

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

  public BigDecimal getCoutAvion() {
    return coutAvion;
  }

  public void setCoutAvion(BigDecimal coutAvion) {
    this.coutAvion = coutAvion;
  }

}
