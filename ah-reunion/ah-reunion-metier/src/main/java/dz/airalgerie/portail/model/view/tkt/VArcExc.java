/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.view.tkt;

import java.io.Serializable;
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
 * @author hp
 */
@Entity
@Table(schema = "dbo", name = "V_ARC_EXC")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VArcExc.findAll", query = "SELECT v FROM VArcExc v"),
    @NamedQuery(name = "VArcExc.findByEtkt",
        query = "SELECT v FROM VArcExc v WHERE v.etkt = :etkt"),
    @NamedQuery(name = "VArcExc.findByExcTkt1",
        query = "SELECT v FROM VArcExc v WHERE v.excTkt1 = :excTkt1"),
    @NamedQuery(name = "VArcExc.findByExcCp1",
        query = "SELECT v FROM VArcExc v WHERE v.excCp1 = :excCp1"),
    @NamedQuery(name = "VArcExc.findByExcTkt2",
        query = "SELECT v FROM VArcExc v WHERE v.excTkt2 = :excTkt2"),
    @NamedQuery(name = "VArcExc.findByExcCp2",
        query = "SELECT v FROM VArcExc v WHERE v.excCp2 = :excCp2"),
    @NamedQuery(name = "VArcExc.findByExcTkt3",
        query = "SELECT v FROM VArcExc v WHERE v.excTkt3 = :excTkt3"),
    @NamedQuery(name = "VArcExc.findByExcCp3",
        query = "SELECT v FROM VArcExc v WHERE v.excCp3 = :excCp3"),
    @NamedQuery(name = "VArcExc.findByExcTkt4",
        query = "SELECT v FROM VArcExc v WHERE v.excTkt4 = :excTkt4"),
    @NamedQuery(name = "VArcExc.findByExcCp4",
        query = "SELECT v FROM VArcExc v WHERE v.excCp4 = :excCp4"),
    @NamedQuery(name = "VArcExc.findByOrgFop",
        query = "SELECT v FROM VArcExc v WHERE v.orgFop = :orgFop"),
    @NamedQuery(name = "VArcExc.findByExcInfo",
        query = "SELECT v FROM VArcExc v WHERE v.excInfo = :excInfo")})
public class VArcExc implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "ETKT")
  @Id
  private String etkt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "EXC_TKT_1")
  private String excTkt1;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "EXC_CP_1")
  private String excCp1;
  @Size(max = 13)
  @Column(name = "EXC_TKT_2")
  private String excTkt2;
  @Size(max = 4)
  @Column(name = "EXC_CP_2")
  private String excCp2;
  @Size(max = 13)
  @Column(name = "EXC_TKT_3")
  private String excTkt3;
  @Size(max = 4)
  @Column(name = "EXC_CP_3")
  private String excCp3;
  @Size(max = 13)
  @Column(name = "EXC_TKT_4")
  private String excTkt4;
  @Size(max = 4)
  @Column(name = "EXC_CP_4")
  private String excCp4;
  @Size(max = 10)
  @Column(name = "ORG_FOP")
  private String orgFop;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 95)
  @Column(name = "EXC_INFO")
  private String excInfo;

  public VArcExc() {
  }

  public VArcExc(String etkt, String excTkt1, String excCp1, String excTkt2, String excCp2,
      String excTkt3, String excCp3, String excTkt4, String excCp4, String orgFop, String excInfo) {
    this.etkt = etkt;
    this.excTkt1 = excTkt1;
    this.excCp1 = excCp1;
    this.excTkt2 = excTkt2;
    this.excCp2 = excCp2;
    this.excTkt3 = excTkt3;
    this.excCp3 = excCp3;
    this.excTkt4 = excTkt4;
    this.excCp4 = excCp4;
    this.orgFop = orgFop;
    this.excInfo = excInfo;
  }



  public String getEtkt() {
    return etkt;
  }

  public void setEtkt(String etkt) {
    this.etkt = etkt;
  }

  public String getExcTkt1() {
    return excTkt1;
  }

  public void setExcTkt1(String excTkt1) {
    this.excTkt1 = excTkt1;
  }

  public String getExcCp1() {
    return excCp1;
  }

  public void setExcCp1(String excCp1) {
    this.excCp1 = excCp1;
  }

  public String getExcTkt2() {
    return excTkt2;
  }

  public void setExcTkt2(String excTkt2) {
    this.excTkt2 = excTkt2;
  }

  public String getExcCp2() {
    return excCp2;
  }

  public void setExcCp2(String excCp2) {
    this.excCp2 = excCp2;
  }

  public String getExcTkt3() {
    return excTkt3;
  }

  public void setExcTkt3(String excTkt3) {
    this.excTkt3 = excTkt3;
  }

  public String getExcCp3() {
    return excCp3;
  }

  public void setExcCp3(String excCp3) {
    this.excCp3 = excCp3;
  }

  public String getExcTkt4() {
    return excTkt4;
  }

  public void setExcTkt4(String excTkt4) {
    this.excTkt4 = excTkt4;
  }

  public String getExcCp4() {
    return excCp4;
  }

  public void setExcCp4(String excCp4) {
    this.excCp4 = excCp4;
  }

  public String getOrgFop() {
    return orgFop;
  }

  public void setOrgFop(String orgFop) {
    this.orgFop = orgFop;
  }

  public String getExcInfo() {
    return excInfo;
  }

  public void setExcInfo(String excInfo) {
    this.excInfo = excInfo;
  }

}
