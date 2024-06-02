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
@Table(name = "V_SIEG_OFFERT_FINAL_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSiegOffertFinalReseau.findAll",
        query = "SELECT v FROM VSiegOffertFinalReseau v"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findById",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findByReseau",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findByDateTrt",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findBySof",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.sof = :sof"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findBySoc",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.soc = :soc"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findBySoy",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.soy = :soy"),
    @NamedQuery(name = "VSiegOffertFinalReseau.findByTotalsieg",
        query = "SELECT v FROM VSiegOffertFinalReseau v WHERE v.totalsieg = :totalsieg")})
public class VSiegOffertFinalReseau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "reseau")
  private String reseau;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Column(name = "SOF")
  private Integer sof;
  @Column(name = "SOC")
  private Integer soc;
  @Column(name = "SOY")
  private Integer soy;
  @Column(name = "Total_sieg")
  private Integer totalsieg;

  public VSiegOffertFinalReseau() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Integer getSof() {
    return sof;
  }

  public void setSof(Integer sof) {
    this.sof = sof;
  }

  public Integer getSoc() {
    return soc;
  }

  public void setSoc(Integer soc) {
    this.soc = soc;
  }

  public Integer getSoy() {
    return soy;
  }

  public void setSoy(Integer soy) {
    this.soy = soy;
  }

  public Integer getTotalsieg() {
    return totalsieg;
  }

  public void setTotalsieg(Integer totalsieg) {
    this.totalsieg = totalsieg;
  }

}
