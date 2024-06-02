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
@Table(name = "V_GEST_SURV_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGestSurvReseau.findAll", query = "SELECT v FROM VGestSurvReseau v"),
    @NamedQuery(name = "VGestSurvReseau.findById",
        query = "SELECT v FROM VGestSurvReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VGestSurvReseau.findByDateTrt",
        query = "SELECT v FROM VGestSurvReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VGestSurvReseau.findByReseau",
        query = "SELECT v FROM VGestSurvReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VGestSurvReseau.findByCoutSurvol",
        query = "SELECT v FROM VGestSurvReseau v WHERE v.coutSurvol = :coutSurvol")})
public class VGestSurvReseau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Size(max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Cout_Survol")
  private BigDecimal coutSurvol;

  public VGestSurvReseau() {}

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

  public BigDecimal getCoutSurvol() {
    return coutSurvol;
  }

  public void setCoutSurvol(BigDecimal coutSurvol) {
    this.coutSurvol = coutSurvol;
  }

}
