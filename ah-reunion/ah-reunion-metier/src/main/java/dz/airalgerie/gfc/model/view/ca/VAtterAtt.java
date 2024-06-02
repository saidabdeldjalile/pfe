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
@Table(name = "V_ATTER_ATT", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VAtterAtt.findAll", query = "SELECT v FROM VAtterAtt v"),
    @NamedQuery(name = "VAtterAtt.findById", query = "SELECT v FROM VAtterAtt v WHERE v.id = :id"),
    @NamedQuery(name = "VAtterAtt.findByDateTrt",
        query = "SELECT v FROM VAtterAtt v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VAtterAtt.findByNumLigne",
        query = "SELECT v FROM VAtterAtt v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VAtterAtt.findByCodeRelat",
        query = "SELECT v FROM VAtterAtt v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VAtterAtt.findByReseau",
        query = "SELECT v FROM VAtterAtt v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VAtterAtt.findByFraisAtterissage",
        query = "SELECT v FROM VAtterAtt v WHERE v.fraisAtterissage = :fraisAtterissage"),
    @NamedQuery(name = "VAtterAtt.findByRotation",
        query = "SELECT v FROM VAtterAtt v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VAtterAtt.findByTypeApp",
        query = "SELECT v FROM VAtterAtt v WHERE v.typeApp = :typeApp")})
public class VAtterAtt implements Serializable {

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
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Frais_Atterissage")
  private BigDecimal fraisAtterissage;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;

  public VAtterAtt() {}

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

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
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

  public BigDecimal getFraisAtterissage() {
    return fraisAtterissage;
  }

  public void setFraisAtterissage(BigDecimal fraisAtterissage) {
    this.fraisAtterissage = fraisAtterissage;
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
