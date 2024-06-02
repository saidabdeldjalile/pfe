/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "FACTURE_RECUE", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "FactureRecue.findAll", query = "SELECT f FROM FactureRecue f")})
public class FactureRecue implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_COMP")
  private int dateComp;
  @Column(name = "IS_CPTA")
  private Boolean isCpta;

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FactureRecuePK factureRecuePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "SENS_OP")
  private String sensOp;
  @Size(max = 3)
  @Column(name = "CODE_MON")
  private String codeMon;
  @Size(max = 3)
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Basic(optional = false)

  @Column(name = "DATE_CPTA")

  private Integer dateCpta;
  @Column(name = "DATE_ENV")
  @Temporal(TemporalType.DATE)
  private Date dateEnv;
  @Column(name = "DATE_RET")
  @Temporal(TemporalType.DATE)
  private Date dateRet;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TOT_PREST")
  private BigDecimal totPrest;

  @Size(max = 2)
  @Column(name = "PERIODE")
  private String periode;

  public String getPeriode() {
    /*
     * if (factureRecuePK!=null) if (factureRecuePK.getDateFct()!=null) {
     * System.out.println("factureRecuePK.getDateFct().getDay()"+factureRecuePK.getDateFct().getDay(
     * )); if (factureRecuePK.getDateFct()!=null) {
     * System.out.println("factureRecuePK.getDateFct().getDay()"+factureRecuePK.getDateFct().getDay(
     * )); if (factureRecuePK.getDateFct().getDay()<7) periode="P1"; if
     * (factureRecuePK.getDateFct().getDay()>7) if (factureRecuePK.getDateFct().getDay()<14)
     * periode="P2"; if (factureRecuePK.getDateFct().getDay()>14) if
     * (factureRecuePK.getDateFct().getDay()<21) periode="P3"; if
     * (factureRecuePK.getDateFct().getDay()>21) if (factureRecuePK.getDateFct().getDay()<31)
     * periode="P4";}}
     */
    return periode;
  }

  public void setPeriode(String periode) {

    this.periode = periode;
  }

  // @Column(name = "DATE_CPTA1")
  // @Temporal(TemporalType.DATE)
  // private Date dateCpta1;
  @JoinColumn(name = "NAT_PREST", referencedColumnName = "NAT_PREST")
  @ManyToOne
  private NaturePrestation natPrest;
  @JoinColumn(name = "NUM_CIE", referencedColumnName = "NUM_CIE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Compagnie compagnie;

  public FactureRecue() {}

  public FactureRecue(FactureRecuePK factureRecuePK) {
    this.factureRecuePK = factureRecuePK;
  }

  public FactureRecue(FactureRecuePK factureRecuePK, String sensOp, int dateComp, int dateCpta) {
    this.factureRecuePK = factureRecuePK;
    this.sensOp = sensOp;
    this.dateComp = dateComp;
    this.dateCpta = dateCpta;
  }

  public FactureRecue(String numCie, String numFct, Date dateFct) {
    this.factureRecuePK = new FactureRecuePK(numCie, numFct, dateFct);
  }

  public FactureRecuePK getFactureRecuePK() {
    if (factureRecuePK == null)
      factureRecuePK = new FactureRecuePK();
    return factureRecuePK;
  }

  public void setFactureRecuePK(FactureRecuePK factureRecuePK) {
    this.factureRecuePK = factureRecuePK;
  }

  public String getSensOp() {
    return sensOp;
  }

  public void setSensOp(String sensOp) {
    this.sensOp = sensOp;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
  }

  public Integer getDateComp() {
    /*
     * System.out.println("fonction  getDateComp avant dateComp="+dateComp); if ((dateComp!=null)&&
     * (dateComp>190000)) {//System.out.println("item.datecpt"+dateComp); String dateCt;String
     * valmoist = null; String valannet = null;
     * 
     * 
     * //convertir dateCt=Integer.toString(dateComp); valannet =dateCt.substring(0, 4);
     * 
     * valmoist=dateCt.substring(4, 6); // System.out.println("valmoist"+dateCt); //
     * System.out.println("valannet"+valannet);
     * 
     * dateComp=Integer.valueOf(valmoist+valannet);
     * 
     * } System.out.println("fonction  getDateComp fin dateComp="+dateComp);
     */
    return dateComp;
  }

  public void setDateComp(Integer dateComp) {
    /*
     * System.out.println("fonction  setDateComp avant dateComp="+dateComp); //
     * System.out.println("item.datecpt"+dateComp); String dateCt;String valmoist = null; String
     * valannet = null; dateCt=Integer.toString(dateComp); Integer count =dateCt.length(); //
     * System.out.println("ancien date comp="+dateComp); //
     * System.out.println("count date comp="+count); if ((count==5)&&(dateComp<=130000))
     * 
     * {
     * 
     * //convertir dateCt=Integer.toString(dateComp); valmoist=dateCt.substring(0, 1);
     * valmoist="0"+valmoist; valannet=dateCt.substring(1, 5); //
     * System.out.println("valmoist"+valmoist); // System.out.println("valannet"+valannet);
     * 
     * } if ((count==6)&&(dateComp<=130000)) {
     * 
     * //convertir dateCt=Integer.toString(dateComp); valmoist=dateCt.substring(0, 2);
     * valannet=dateCt.substring(2, 6); // System.out.println("valmoist"+valmoist); //
     * System.out.println("valannet"+valannet);
     * 
     * } if (dateComp<=130000) { String datet=valannet+valmoist; dateComp=(Integer.valueOf(datet));
     * } System.out.println("fonction  setDateComp fin dateComp="+dateComp); //
     * System.out.println("nouveu date comp="+dateComp);
     */
    this.dateComp = dateComp;
  }

  public Integer getDateCpta() {
    /*
     * if ((dateCpta!=null)&& (dateCpta>190000)) { System.out.println("item.datecpt"+dateCpta);
     * String dateCt;String valmoist = null; String valannet = null;
     * 
     * 
     * //convertir dateCt=Integer.toString(dateCpta); valannet =dateCt.substring(0, 4);
     * 
     * valmoist=dateCt.substring(4, 6); System.out.println("valmoist"+valmoist);
     * System.out.println("valannet"+valannet);
     * 
     * dateCpta=Integer.valueOf(valmoist+valannet); System.out.println("nouveau dateCpta"+dateCpta);
     * }
     */
    return dateCpta;
  }

  public void setDateCpta(Integer dateCpta) {
    /*
     * System.out.println("item.datecpt"+dateCpta); String dateCt;String valmoist = null; String
     * valannet = null; dateCt=Integer.toString(dateCpta); Integer count =dateCt.length();
     * 
     * if ((count==5)&&(dateCpta<=200000))
     * 
     * {
     * 
     * //convertir dateCt=Integer.toString(dateCpta); valmoist=dateCt.substring(0, 1);
     * valmoist="0"+valmoist; valannet=dateCt.substring(1, 5);
     * System.out.println("valmoist"+valmoist); System.out.println("valannet"+valannet);
     * 
     * } if ((count==6)&&(dateCpta<=200000)) {
     * 
     * //convertir dateCt=Integer.toString(dateCpta); valmoist=dateCt.substring(0, 2);
     * valannet=dateCt.substring(2, 6); System.out.println("valmoist"+valmoist);
     * System.out.println("valannet"+valannet);
     * 
     * } if (dateCpta<=200000) { String datet=valannet+valmoist; dateCpta=(Integer.valueOf(datet));
     * }
     */
    this.dateCpta = dateCpta;
  }

  public Date getDateEnv() {
    return dateEnv;
  }

  public void setDateEnv(Date dateEnv) {
    this.dateEnv = dateEnv;
  }

  public Date getDateRet() {
    return dateRet;
  }

  public void setDateRet(Date dateRet) {
    this.dateRet = dateRet;
  }

  public BigDecimal getTotPrest() {
    if (totPrest != null)
      return totPrest;// .setScale(2, RoundingMode.CEILING);
    else
      return totPrest;
  }

  public void setTotPrest(BigDecimal totPrest) {
    this.totPrest = totPrest;// .setScale(2, RoundingMode.CEILING);
  }

  // public Date getDateCpta1() {
  // return dateCpta1;
  // }
  //
  // public void setDateCpta1(Date dateCpta1) {
  // this.dateCpta1 = dateCpta1;
  // }

  public NaturePrestation getNatPrest() {
    if (natPrest == null)
      natPrest = new NaturePrestation();
    return natPrest;
  }

  public void setNatPrest(NaturePrestation natPrest) {
    this.natPrest = natPrest;
  }

  public Compagnie getCompagnie() {
    return compagnie;
  }

  public void setCompagnie(Compagnie compagnie) {
    this.compagnie = compagnie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (factureRecuePK != null ? factureRecuePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FactureRecue)) {
      return false;
    }
    FactureRecue other = (FactureRecue) object;
    if ((this.factureRecuePK == null && other.factureRecuePK != null)
        || (this.factureRecuePK != null && !this.factureRecuePK.equals(other.factureRecuePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.FactureRecue[ factureRecuePK=" + factureRecuePK + " ]";
  }

  // public int getDateComp() {
  // return dateComp;
  // }
  //
  // public void setDateComp(int dateComp) {
  // this.dateComp = dateComp;
  // }

  public Boolean getIsCpta() {
    return isCpta;
  }

  public void setIsCpta(Boolean isCpta) {
    this.isCpta = isCpta;
  }

}
