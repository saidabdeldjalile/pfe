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
@Table(name = "V_REDEVANCE_PASSAGERS_FRET_FINAL", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRedevancePassagersFretFinal.findAll",
        query = "SELECT v FROM VRedevancePassagersFretFinal v"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByNumb",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.numb = :numb"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByNumLigne",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.numLigne = :numLigne"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByCodeRelat",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByRelation",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.relation = :relation"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByRotation",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByDateTrt",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByReseau",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VRedevancePassagersFretFinal.findByRedpax",
        query = "SELECT v FROM VRedevancePassagersFretFinal v WHERE v.redpax = :redpax")})
public class VRedevancePassagersFretFinal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "NUMB")
  private BigInteger numb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String codeRelat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "RELATION")
  private String relation;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
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
  @Column(name = "REDPAX")
  private BigDecimal redpax;

  public VRedevancePassagersFretFinal() {}

  public BigInteger getNumb() {
    return numb;
  }

  public void setNumb(BigInteger numb) {
    this.numb = numb;
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

  public BigDecimal getRedpax() {
    return redpax;
  }

  public void setRedpax(BigDecimal redpax) {
    this.redpax = redpax;
  }

}
