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
@Table(name = "V_CAP_PAX_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VCapPaxReseau.findAll", query = "SELECT v FROM VCapPaxReseau v"),
    @NamedQuery(name = "VCapPaxReseau.findById",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VCapPaxReseau.findByDateTrt",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VCapPaxReseau.findByReseau",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VCapPaxReseau.findByPkt",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.pkt = :pkt"),
    @NamedQuery(name = "VCapPaxReseau.findBySko",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.sko = :sko"),
    @NamedQuery(name = "VCapPaxReseau.findByCr",
        query = "SELECT v FROM VCapPaxReseau v WHERE v.cr = :cr")})
public class VCapPaxReseau implements Serializable {

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
  @Column(name = "reseau")
  private String reseau;
  @Column(name = "PKT")
  private BigInteger pkt;
  @Column(name = "SKO")
  private BigInteger sko;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CR")
  private Double cr;

  public VCapPaxReseau() {}

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

  public BigInteger getPkt() {
    return pkt;
  }

  public void setPkt(BigInteger pkt) {
    this.pkt = pkt;
  }

  public BigInteger getSko() {
    return sko;
  }

  public void setSko(BigInteger sko) {
    this.sko = sko;
  }

  public Double getCr() {
    return cr;
  }

  public void setCr(Double cr) {
    this.cr = cr;
  }

}
