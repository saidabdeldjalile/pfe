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
@Table(name = "V_PASSAG_TRANSP_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPassagTranspReseau.findAll",
        query = "SELECT v FROM VPassagTranspReseau v"),
    @NamedQuery(name = "VPassagTranspReseau.findById",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.id = :id"),
    @NamedQuery(name = "VPassagTranspReseau.findByDateTrt",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VPassagTranspReseau.findByReseau",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VPassagTranspReseau.findByPaxc",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.paxc = :paxc"),
    @NamedQuery(name = "VPassagTranspReseau.findByPaxy",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.paxy = :paxy"),
    @NamedQuery(name = "VPassagTranspReseau.findByTPax",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.tPax = :tPax"),
    @NamedQuery(name = "VPassagTranspReseau.findByGrat",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.grat = :grat"),
    @NamedQuery(name = "VPassagTranspReseau.findByBb",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.bb = :bb"),
    @NamedQuery(name = "VPassagTranspReseau.findByTotpass",
        query = "SELECT v FROM VPassagTranspReseau v WHERE v.totpass = :totpass")})
public class VPassagTranspReseau implements Serializable {

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
  @Column(name = "PAXC")
  private Integer paxc;
  @Column(name = "PAXY")
  private Integer paxy;
  @Column(name = "TPax")
  private Integer tPax;
  @Column(name = "GRAT")
  private Integer grat;
  @Column(name = "BB")
  private Integer bb;
  @Column(name = "TOTPASS")
  private Integer totpass;

  public VPassagTranspReseau() {}

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

  public Integer getPaxc() {
    return paxc;
  }

  public void setPaxc(Integer paxc) {
    this.paxc = paxc;
  }

  public Integer getPaxy() {
    return paxy;
  }

  public void setPaxy(Integer paxy) {
    this.paxy = paxy;
  }

  public Integer getTPax() {
    return tPax;
  }

  public void setTPax(Integer tPax) {
    this.tPax = tPax;
  }

  public Integer getGrat() {
    return grat;
  }

  public void setGrat(Integer grat) {
    this.grat = grat;
  }

  public Integer getBb() {
    return bb;
  }

  public void setBb(Integer bb) {
    this.bb = bb;
  }

  public Integer getTotpass() {
    return totpass;
  }

  public void setTotpass(Integer totpass) {
    this.totpass = totpass;
  }

}
