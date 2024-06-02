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
@Table(name = "V_VUE_AVION_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VVueAvionReseau.findAll", query = "SELECT v FROM VVueAvionReseau v"),
    @NamedQuery(name = "VVueAvionReseau.findById",
        query = "SELECT v FROM VVueAvionReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VVueAvionReseau.findByDateTrt",
        query = "SELECT v FROM VVueAvionReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VVueAvionReseau.findByReseau",
        query = "SELECT v FROM VVueAvionReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VVueAvionReseau.findByCoutAvion",
        query = "SELECT v FROM VVueAvionReseau v WHERE v.coutAvion = :coutAvion")})
public class VVueAvionReseau implements Serializable {

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
  @Column(name = "CoutAvion")
  private BigDecimal coutAvion;

  public VVueAvionReseau() {}

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

  public BigDecimal getCoutAvion() {
    return coutAvion;
  }

  public void setCoutAvion(BigDecimal coutAvion) {
    this.coutAvion = coutAvion;
  }

}
