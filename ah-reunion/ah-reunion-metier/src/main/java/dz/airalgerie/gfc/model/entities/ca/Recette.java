/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

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
@Table(name = "V_RECETTE", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r"),
    @NamedQuery(name = "Recette.findById", query = "SELECT r FROM Recette r WHERE r.id = :id"),
    @NamedQuery(name = "Recette.findByDateTrt",
        query = "SELECT r FROM Recette r WHERE r.dateTrt = :dateTrt"),
    @NamedQuery(name = "Recette.findByNumLigne",
        query = "SELECT r FROM Recette r WHERE r.numLigne = :numLigne"),
    @NamedQuery(name = "Recette.findByReseau",
        query = "SELECT r FROM Recette r WHERE r.reseau = :reseau"),
    @NamedQuery(name = "Recette.findByCodeRelat",
        query = "SELECT r FROM Recette r WHERE r.codeRelat = :codeRelat"),
    @NamedQuery(name = "Recette.findByRotation",
        query = "SELECT r FROM Recette r WHERE r.rotation = :rotation"),
    @NamedQuery(name = "Recette.findByRecPax",
        query = "SELECT r FROM Recette r WHERE r.recPax = :recPax"),
    @NamedQuery(name = "Recette.findByRecFret",
        query = "SELECT r FROM Recette r WHERE r.recFret = :recFret"),
    @NamedQuery(name = "Recette.findByRecPoste",
        query = "SELECT r FROM Recette r WHERE r.recPoste = :recPoste"),
    @NamedQuery(name = "Recette.findByRecBcb",
        query = "SELECT r FROM Recette r WHERE r.recBcb = :recBcb"),
    @NamedQuery(name = "Recette.findByCharPax",
        query = "SELECT r FROM Recette r WHERE r.charPax = :charPax"),
    @NamedQuery(name = "Recette.findByCharFret",
        query = "SELECT r FROM Recette r WHERE r.charFret = :charFret"),
    @NamedQuery(name = "Recette.findByTotal",
        query = "SELECT r FROM Recette r WHERE r.total = :total")})
public class Recette implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
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
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
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
  @Column(name = "REC_PAX")
  private BigDecimal recPax;
  @Column(name = "REC_FRET")
  private BigDecimal recFret;
  @Column(name = "REC_POSTE")
  private BigDecimal recPoste;
  @Column(name = "REC_BCB")
  private BigDecimal recBcb;
  @Column(name = "CHAR_PAX")
  private BigDecimal charPax;
  @Column(name = "CHAR_FRET")
  private BigDecimal charFret;
  @Column(name = "TOTAL")
  private BigDecimal total;

  public Recette() {}

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

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
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

  public BigDecimal getRecPax() {
    return recPax;
  }

  public void setRecPax(BigDecimal recPax) {
    this.recPax = recPax;
  }

  public BigDecimal getRecFret() {
    return recFret;
  }

  public void setRecFret(BigDecimal recFret) {
    this.recFret = recFret;
  }

  public BigDecimal getRecPoste() {
    return recPoste;
  }

  public void setRecPoste(BigDecimal recPoste) {
    this.recPoste = recPoste;
  }

  public BigDecimal getRecBcb() {
    return recBcb;
  }

  public void setRecBcb(BigDecimal recBcb) {
    this.recBcb = recBcb;
  }

  public BigDecimal getCharPax() {
    return charPax;
  }

  public void setCharPax(BigDecimal charPax) {
    this.charPax = charPax;
  }

  public BigDecimal getCharFret() {
    return charFret;
  }

  public void setCharFret(BigDecimal charFret) {
    this.charFret = charFret;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

}
