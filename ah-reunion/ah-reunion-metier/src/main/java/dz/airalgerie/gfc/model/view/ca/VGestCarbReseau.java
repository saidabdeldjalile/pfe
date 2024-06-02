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
@Table(name = "V_GEST_CARB_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestCarbReseau.findAll", query = "SELECT v FROM VGestCarbReseau v"),
    @NamedQuery(name = "VGestCarbReseau.findById",
        query = "SELECT v FROM VGestCarbReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VGestCarbReseau.findByDateTrt",
        query = "SELECT v FROM VGestCarbReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestCarbReseau.findByReseau",
        query = "SELECT v FROM VGestCarbReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestCarbReseau.findByCoutcarburant",
        query = "SELECT v FROM VGestCarbReseau v WHERE v.coutcarburant = :coutcarburant")})
public class VGestCarbReseau implements Serializable {

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
  @Column(name = "Cout_carburant")
  private BigDecimal coutcarburant;

  public VGestCarbReseau() {}

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

  public BigDecimal getCoutcarburant() {
    return coutcarburant;
  }

  public void setCoutcarburant(BigDecimal coutcarburant) {
    this.coutcarburant = coutcarburant;
  }

}
