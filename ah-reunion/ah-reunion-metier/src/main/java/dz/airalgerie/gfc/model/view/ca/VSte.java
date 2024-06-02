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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "HV.V_STE")
@XmlRootElement

public class VSte implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "ID")
  private BigInteger id;
  @Size(max = 2147483647)
  @Column(name = "TRAV_DATE")
  private String travDate;
  @Size(max = 2147483647)
  @Column(name = "TRAV_JJ")
  private String travJj;
  @Basic(optional = false)

  @Size(min = 1, max = 2147483647)
  @Column(name = "TRAV_DEP")

  private String travDep;
  @Basic(optional = false)

  @Size(min = 1, max = 2147483647)
  @Column(name = "TRAV_ARR")
  private String travArr;
  @Size(max = 3)
  @Column(name = "TRAV_ORI")
  private String travOri;
  @Size(max = 3)
  @Column(name = "TRAV_DES")
  private String travDes;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TRAV_TVT")
  private BigDecimal travTvt;
  @Basic(optional = false)

  @Column(name = "TRAV_VOY")
  private int travVoy;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  @Size(max = 2)
  @Column(name = "PAR")
  private String par;
  @Size(max = 2)
  @Column(name = "NATURE_VOL")
  private String natureVol;
  @Size(max = 2147483647)
  @Column(name = "TRAV_ETD")
  private String travEtd;
  @Basic(optional = false)

  @Column(name = "CODE_VOL")
  private short codeVol;
  @Column(name = "TEMPNUIT")
  private BigDecimal tempnuit;
  @Basic(optional = false)

  @Column(name = "NUM_VOL")
  private int NUM_VOL;

  public VSte() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getTravDate() {
    return travDate;
  }

  public void setTravDate(String travDate) {
    this.travDate = travDate;
  }

  public String getTravJj() {
    return travJj;
  }

  public void setTravJj(String travJj) {
    this.travJj = travJj;
  }

  public String getTravDep() {
    return travDep;
  }

  public void setTravDep(String travDep) {
    this.travDep = travDep;
  }

  public String getTravArr() {
    return travArr;
  }

  public void setTravArr(String travArr) {
    this.travArr = travArr;
  }

  public String getTravOri() {
    return travOri;
  }

  public void setTravOri(String travOri) {
    this.travOri = travOri;
  }

  public String getTravDes() {
    return travDes;
  }

  public void setTravDes(String travDes) {
    this.travDes = travDes;
  }

  public BigDecimal getTravTvt() {
    return travTvt;
  }

  public void setTravTvt(BigDecimal travTvt) {
    this.travTvt = travTvt;
  }

  public int getTravVoy() {
    return travVoy;
  }

  public void setTravVoy(int travVoy) {
    this.travVoy = travVoy;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public String getPar() {
    return par;
  }

  public void setPar(String par) {
    this.par = par;
  }

  public String getNatureVol() {
    return natureVol;
  }

  public void setNatureVol(String natureVol) {
    this.natureVol = natureVol;
  }

  public String getTravEtd() {
    return travEtd;
  }

  public void setTravEtd(String travEtd) {
    this.travEtd = travEtd;
  }

  public short getCodeVol() {
    return codeVol;
  }

  public void setCodeVol(short codeVol) {
    this.codeVol = codeVol;
  }

  public BigDecimal getTempnuit() {
    return tempnuit;
  }

  public void setTempnuit(BigDecimal tempnuit) {
    this.tempnuit = tempnuit;
  }

  public int getNUM_VOL() {
    return NUM_VOL;
  }

  public void setNUM_VOL(int NUM_VOL) {
    this.NUM_VOL = NUM_VOL;
  }

}
