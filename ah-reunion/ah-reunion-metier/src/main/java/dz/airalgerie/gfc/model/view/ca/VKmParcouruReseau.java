/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.ca;

import java.io.Serializable;
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
@Table(name = "V_KM_PARCOURU_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VKmParcouruReseau.findAll", query = "SELECT v FROM VKmParcouruReseau v"),
    @NamedQuery(name = "VKmParcouruReseau.findById",
        query = "SELECT v FROM VKmParcouruReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VKmParcouruReseau.findByDateTrt",
        query = "SELECT v FROM VKmParcouruReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VKmParcouruReseau.findByReseau",
        query = "SELECT v FROM VKmParcouruReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VKmParcouruReseau.findByTroncon",
        query = "SELECT v FROM VKmParcouruReseau v WHERE v.troncon = :troncon")})
public class VKmParcouruReseau implements Serializable {

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
  @Column(name = "Troncon")
  private Integer troncon;

  public VKmParcouruReseau() {}

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

  public Integer getTroncon() {
    return troncon;
  }

  public void setTroncon(Integer troncon) {
    this.troncon = troncon;
  }

}