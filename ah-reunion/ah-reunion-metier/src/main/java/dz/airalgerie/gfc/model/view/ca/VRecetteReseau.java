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
@Table(name = "V_RECETTE_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRecetteReseau.findAll", query = "SELECT v FROM VRecetteReseau v"),
    @NamedQuery(name = "VRecetteReseau.findById",
        query = "SELECT v FROM VRecetteReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VRecetteReseau.findByDateTrt",
        query = "SELECT v FROM VRecetteReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VRecetteReseau.findByReseau",
        query = "SELECT v FROM VRecetteReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VRecetteReseau.findByRecPax",
        query = "SELECT v FROM VRecetteReseau v WHERE v.recPax = :recPax"),
    @NamedQuery(name = "VRecetteReseau.findByRecFret",
        query = "SELECT v FROM VRecetteReseau v WHERE v.recFret = :recFret"),
    @NamedQuery(name = "VRecetteReseau.findByRecPoste",
        query = "SELECT v FROM VRecetteReseau v WHERE v.recPoste = :recPoste"),
    @NamedQuery(name = "VRecetteReseau.findByRecBcb",
        query = "SELECT v FROM VRecetteReseau v WHERE v.recBcb = :recBcb"),
    @NamedQuery(name = "VRecetteReseau.findByCharPax",
        query = "SELECT v FROM VRecetteReseau v WHERE v.charPax = :charPax"),
    @NamedQuery(name = "VRecetteReseau.findByCharFret",
        query = "SELECT v FROM VRecetteReseau v WHERE v.charFret = :charFret"),
    @NamedQuery(name = "VRecetteReseau.findByTotal",
        query = "SELECT v FROM VRecetteReseau v WHERE v.total = :total")})
public class VRecetteReseau implements Serializable {

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

  public VRecetteReseau() {}

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
