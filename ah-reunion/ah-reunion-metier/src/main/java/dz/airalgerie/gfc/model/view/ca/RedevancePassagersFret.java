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
@Table(name = "V_Redevance_Passagers_Fret", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedevancePassagersFret.findAll",
        query = "SELECT r FROM RedevancePassagersFret r"),
    @NamedQuery(name = "RedevancePassagersFret.findById",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.id = :id"),
    @NamedQuery(name = "RedevancePassagersFret.findByDateTrt",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.dateTrt = :dateTrt"),
    @NamedQuery(name = "RedevancePassagersFret.findByCodeRelat",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.codeRelat = :codeRelat"),
    @NamedQuery(name = "RedevancePassagersFret.findByReseau",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.reseau = :reseau"),
    @NamedQuery(name = "RedevancePassagersFret.findByNumLigne",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.numLigne = :numLigne"),
    @NamedQuery(name = "RedevancePassagersFret.findByRelation",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.relation = :relation"),
    @NamedQuery(name = "RedevancePassagersFret.findByRedpax",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.redpax = :redpax"),
    @NamedQuery(name = "RedevancePassagersFret.findByRotation",
        query = "SELECT r FROM RedevancePassagersFret r WHERE r.rotation = :rotation")})
public class RedevancePassagersFret implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
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
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "RELATION")
  private String relation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "REDPAX")
  private BigDecimal redpax;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;

  public RedevancePassagersFret() {}

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

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public BigDecimal getRedpax() {
    return redpax;
  }

  public void setRedpax(BigDecimal redpax) {
    this.redpax = redpax;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

}
