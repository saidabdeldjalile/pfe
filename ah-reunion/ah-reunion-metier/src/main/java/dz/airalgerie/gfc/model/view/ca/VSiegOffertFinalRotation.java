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
@Table(name = "V_SIEG_OFFERT_FINAL_ROTATION", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSiegOffertFinalRotation.findAll",
        query = "SELECT v FROM VSiegOffertFinalRotation v"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findById",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.id = :id"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findByDateTrt",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findByCodeRelat",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.codeRelat = :codeRelat"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findByRotation",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.rotation = :rotation"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findBySof",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.sof = :sof"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findBySoc",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.soc = :soc"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findBySoy",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.soy = :soy"),
    @NamedQuery(name = "VSiegOffertFinalRotation.findByTotalsieg",
        query = "SELECT v FROM VSiegOffertFinalRotation v WHERE v.totalsieg = :totalsieg")})
public class VSiegOffertFinalRotation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
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
  @Size(min = 1, max = 30)
  @Column(name = "ROTATION")
  private String rotation;
  @Column(name = "SOF")
  private Integer sof;
  @Column(name = "SOC")
  private Integer soc;
  @Column(name = "SOY")
  private Integer soy;
  @Column(name = "Total_sieg")
  private Integer totalsieg;

  public VSiegOffertFinalRotation() {}

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

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
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
