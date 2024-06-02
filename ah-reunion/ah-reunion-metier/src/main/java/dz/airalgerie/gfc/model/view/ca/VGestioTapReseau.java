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
@Table(name = "V_GESTIO_TAP_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestioTapReseau.findAll", query = "SELECT v FROM VGestioTapReseau v"),
    @NamedQuery(name = "VGestioTapReseau.findById",
        query = "SELECT v FROM VGestioTapReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VGestioTapReseau.findByDateTrt",
        query = "SELECT v FROM VGestioTapReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestioTapReseau.findByReseau",
        query = "SELECT v FROM VGestioTapReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestioTapReseau.findByCoutRecetteAffaire",
        query = "SELECT v FROM VGestioTapReseau v WHERE v.coutRecetteAffaire = :coutRecetteAffaire"),
    @NamedQuery(name = "VGestioTapReseau.findByCoutTAP",
        query = "SELECT v FROM VGestioTapReseau v WHERE v.coutTAP = :coutTAP")})
public class VGestioTapReseau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "cout_recette_affaire")
  private BigDecimal coutRecetteAffaire;
  @Column(name = "Cout_TAP")
  private BigDecimal coutTAP;

  public VGestioTapReseau() {}

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

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
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
