/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "BULLETIN_TOTAL", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BulletinTotal.findAll", query = "SELECT b FROM BulletinTotal b"),
    @NamedQuery(name = "BulletinTotal.findByMatricule",
        query = "SELECT b FROM BulletinTotal b WHERE b.bulletinTotalPK.matricule = :matricule"),
    @NamedQuery(name = "BulletinTotal.findByDatePai",
        query = "SELECT b FROM BulletinTotal b WHERE b.bulletinTotalPK.datePai = :datePai"),
    @NamedQuery(name = "BulletinTotal.findByDateTrt",
        query = "SELECT b FROM BulletinTotal b WHERE b.bulletinTotalPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BulletinTotal.findByBulPrim",
        query = "SELECT b FROM BulletinTotal b WHERE b.bulletinTotalPK.bulPrim = :bulPrim"),
    @NamedQuery(name = "BulletinTotal.findByCodeFil",
        query = "SELECT b FROM BulletinTotal b WHERE b.bulletinTotalPK.codeFil = :codeFil"),
    @NamedQuery(name = "BulletinTotal.findByNetFisc",
        query = "SELECT b FROM BulletinTotal b WHERE b.netFisc = :netFisc"),
    @NamedQuery(name = "BulletinTotal.findByNetApay",
        query = "SELECT b FROM BulletinTotal b WHERE b.netApay = :netApay"),
    @NamedQuery(name = "BulletinTotal.findByVTotaux",
        query = "SELECT b FROM BulletinTotal b WHERE b.vTotaux = :vTotaux"),
    @NamedQuery(name = "BulletinTotal.findByToReten",
        query = "SELECT b FROM BulletinTotal b WHERE b.toReten = :toReten"),
    @NamedQuery(name = "BulletinTotal.findByToRImp",
        query = "SELECT b FROM BulletinTotal b WHERE b.toRImp = :toRImp"),
    @NamedQuery(name = "BulletinTotal.findByToRNim",
        query = "SELECT b FROM BulletinTotal b WHERE b.toRNim = :toRNim"),
    @NamedQuery(name = "BulletinTotal.findByTropPer",
        query = "SELECT b FROM BulletinTotal b WHERE b.tropPer = :tropPer"),
    @NamedQuery(name = "BulletinTotal.findByLibCnas",
        query = "SELECT b FROM BulletinTotal b WHERE b.libCnas = :libCnas"),
    @NamedQuery(name = "BulletinTotal.findByCodeWil",
        query = "SELECT b FROM BulletinTotal b WHERE b.codeWil = :codeWil"),
    @NamedQuery(name = "BulletinTotal.findByMenMgt",
        query = "SELECT b FROM BulletinTotal b WHERE b.menMgt = :menMgt"),
    @NamedQuery(name = "BulletinTotal.findByNssEmpr",
        query = "SELECT b FROM BulletinTotal b WHERE b.nssEmpr = :nssEmpr"),
    @NamedQuery(name = "BulletinTotal.findByCleNssEmpr",
        query = "SELECT b FROM BulletinTotal b WHERE b.cleNssEmpr = :cleNssEmpr"),
    @NamedQuery(name = "BulletinTotal.findByNssEmpe",
        query = "SELECT b FROM BulletinTotal b WHERE b.nssEmpe = :nssEmpe"),
    @NamedQuery(name = "BulletinTotal.findByCleNssEmpe",
        query = "SELECT b FROM BulletinTotal b WHERE b.cleNssEmpe = :cleNssEmpe"),
    @NamedQuery(name = "BulletinTotal.findByMgtEmpe",
        query = "SELECT b FROM BulletinTotal b WHERE b.mgtEmpe = :mgtEmpe"),
    @NamedQuery(name = "BulletinTotal.findByTotBrut",
        query = "SELECT b FROM BulletinTotal b WHERE b.totBrut = :totBrut"),
    @NamedQuery(name = "BulletinTotal.findByCharges",
        query = "SELECT b FROM BulletinTotal b WHERE b.charges = :charges"),
    @NamedQuery(name = "BulletinTotal.findBySecSoc",
        query = "SELECT b FROM BulletinTotal b WHERE b.secSoc = :secSoc"),
    @NamedQuery(name = "BulletinTotal.findByPrimInd",
        query = "SELECT b FROM BulletinTotal b WHERE b.primInd = :primInd"),
    @NamedQuery(name = "BulletinTotal.findBySalBrut",
        query = "SELECT b FROM BulletinTotal b WHERE b.salBrut = :salBrut"),
    @NamedQuery(name = "BulletinTotal.findByMensBrut",
        query = "SELECT b FROM BulletinTotal b WHERE b.mensBrut = :mensBrut")})
public class BulletinTotal implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BulletinTotalPK bulletinTotalPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "NET_FISC")
  private BigDecimal netFisc;
  @Column(name = "NET_APAY")
  private BigDecimal netApay;
  @Column(name = "V_TOTAUX")
  private BigDecimal vTotaux;
  @Column(name = "TO_RETEN")
  private BigDecimal toReten;
  @Column(name = "TO_R_IMP")
  private BigDecimal toRImp;
  @Column(name = "TO_R_NIM")
  private BigDecimal toRNim;
  @Column(name = "TROP_PER")
  private BigDecimal tropPer;
  @Size(max = 50)
  @Column(name = "LIB_CNAS")
  private String libCnas;
  @Column(name = "CODE_WIL")
  private Integer codeWil;
  @Size(max = 3)
  @Column(name = "MEN_MGT")
  private String menMgt;
  @Size(max = 50)
  @Column(name = "NSS_EMPR")
  private String nssEmpr;
  @Column(name = "CLE_NSS_EMPR")
  private Integer cleNssEmpr;
  @Size(max = 50)
  @Column(name = "NSS_EMPE")
  private String nssEmpe;
  @Column(name = "CLE_NSS_EMPE")
  private Integer cleNssEmpe;
  @Size(max = 10)
  @Column(name = "MGT_EMPE")
  private String mgtEmpe;
  @Column(name = "TOT_BRUT")
  private BigDecimal totBrut;
  @Column(name = "CHARGES")
  private BigDecimal charges;
  @Column(name = "SEC_SOC")
  private BigDecimal secSoc;
  @Column(name = "PRIM_IND")
  private BigDecimal primInd;
  @Column(name = "SAL_BRUT")
  private BigDecimal salBrut;
  @Column(name = "MENS_BRUT")
  private BigDecimal mensBrut;
  @JoinColumns({
      @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "BUL_PRIM", referencedColumnName = "BUL_PRIM", insertable = false,
          updatable = false),
      @JoinColumn(name = "CODE_FIL", referencedColumnName = "CODE_FIL", insertable = false,
          updatable = false)})
  @OneToOne(optional = false)
  private Bulletin bulletin;

  public BulletinTotal() {}

  public BulletinTotal(BulletinTotalPK bulletinTotalPK) {
    this.bulletinTotalPK = bulletinTotalPK;
  }

  public BulletinTotal(BulletinTotalPK bulletinTotalPK, BigDecimal netFisc) {
    this.bulletinTotalPK = bulletinTotalPK;
    this.netFisc = netFisc;
  }

  public BulletinTotal(int matricule, int datePai, int dateTrt, boolean bulPrim,
      Character codeFil) {
    this.bulletinTotalPK = new BulletinTotalPK(matricule, datePai, dateTrt, bulPrim, codeFil);
  }

  public BulletinTotalPK getBulletinTotalPK() {
    return bulletinTotalPK;
  }

  public void setBulletinTotalPK(BulletinTotalPK bulletinTotalPK) {
    this.bulletinTotalPK = bulletinTotalPK;
  }

  public BigDecimal getNetFisc() {
    return netFisc;
  }

  public void setNetFisc(BigDecimal netFisc) {
    this.netFisc = netFisc;
  }

  public BigDecimal getNetApay() {
    return netApay;
  }

  public void setNetApay(BigDecimal netApay) {
    this.netApay = netApay;
  }

  public BigDecimal getVTotaux() {
    return vTotaux;
  }

  public void setVTotaux(BigDecimal vTotaux) {
    this.vTotaux = vTotaux;
  }

  public BigDecimal getToReten() {
    return toReten;
  }

  public void setToReten(BigDecimal toReten) {
    this.toReten = toReten;
  }

  public BigDecimal getToRImp() {
    return toRImp;
  }

  public void setToRImp(BigDecimal toRImp) {
    this.toRImp = toRImp;
  }

  public BigDecimal getToRNim() {
    return toRNim;
  }

  public void setToRNim(BigDecimal toRNim) {
    this.toRNim = toRNim;
  }

  public BigDecimal getTropPer() {
    return tropPer;
  }

  public void setTropPer(BigDecimal tropPer) {
    this.tropPer = tropPer;
  }

  public String getLibCnas() {
    return libCnas;
  }

  public void setLibCnas(String libCnas) {
    this.libCnas = libCnas;
  }

  public Integer getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(Integer codeWil) {
    this.codeWil = codeWil;
  }

  public String getMenMgt() {
    return menMgt;
  }

  public void setMenMgt(String menMgt) {
    this.menMgt = menMgt;
  }

  public String getNssEmpr() {
    return nssEmpr;
  }

  public void setNssEmpr(String nssEmpr) {
    this.nssEmpr = nssEmpr;
  }

  public Integer getCleNssEmpr() {
    return cleNssEmpr;
  }

  public void setCleNssEmpr(Integer cleNssEmpr) {
    this.cleNssEmpr = cleNssEmpr;
  }

  public String getNssEmpe() {
    return nssEmpe;
  }

  public void setNssEmpe(String nssEmpe) {
    this.nssEmpe = nssEmpe;
  }

  public Integer getCleNssEmpe() {
    return cleNssEmpe;
  }

  public void setCleNssEmpe(Integer cleNssEmpe) {
    this.cleNssEmpe = cleNssEmpe;
  }

  public String getMgtEmpe() {
    return mgtEmpe;
  }

  public void setMgtEmpe(String mgtEmpe) {
    this.mgtEmpe = mgtEmpe;
  }

  public BigDecimal getTotBrut() {
    return totBrut;
  }

  public void setTotBrut(BigDecimal totBrut) {
    this.totBrut = totBrut;
  }

  public BigDecimal getCharges() {
    return charges;
  }

  public void setCharges(BigDecimal charges) {
    this.charges = charges;
  }

  public BigDecimal getSecSoc() {
    return secSoc;
  }

  public void setSecSoc(BigDecimal secSoc) {
    this.secSoc = secSoc;
  }

  public BigDecimal getPrimInd() {
    return primInd;
  }

  public void setPrimInd(BigDecimal primInd) {
    this.primInd = primInd;
  }

  public BigDecimal getSalBrut() {
    return salBrut;
  }

  public void setSalBrut(BigDecimal salBrut) {
    this.salBrut = salBrut;
  }

  public BigDecimal getMensBrut() {
    return mensBrut;
  }

  public void setMensBrut(BigDecimal mensBrut) {
    this.mensBrut = mensBrut;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  public void setBulletin(Bulletin bulletin) {
    this.bulletin = bulletin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bulletinTotalPK != null ? bulletinTotalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinTotal)) {
      return false;
    }
    BulletinTotal other = (BulletinTotal) object;
    if ((this.bulletinTotalPK == null && other.bulletinTotalPK != null)
        || (this.bulletinTotalPK != null && !this.bulletinTotalPK.equals(other.bulletinTotalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.BulletinTotal[ bulletinTotalPK=" + bulletinTotalPK + " ]";
  }

}
