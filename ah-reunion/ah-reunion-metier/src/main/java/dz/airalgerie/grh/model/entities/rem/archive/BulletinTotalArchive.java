/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem.archive;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "BULLETIN_TOTAL", schema = "T_BP")
public class BulletinTotalArchive implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private BulletinArchivePK bulletinTotalPK;

  @Column(name = "NET_FISC")
  private BigDecimal NET_FISC;

  @Column(name = "NET_APAY")
  private BigDecimal NET_APAY;

  @Column(name = "V_TOTAUX")
  private BigDecimal V_TOTAUX;

  @Column(name = "TO_G_NIM")
  private BigDecimal totalGainsNonImposables;

  @Column(name = "TO_RETEN")
  private BigDecimal TO_RETEN;

  @Column(name = "TO_R_IMP")
  private BigDecimal TO_R_IMP;

  @Column(name = "TO_R_NIM")
  private BigDecimal TO_R_NIM;

  @Column(name = "TROP_PER")
  private BigDecimal TROP_PER;

  @Column(name = "LIB_CNAS")
  private String LIB_CNAS;

  @Column(name = "CODE_WIL")
  private Integer CODE_WIL;

  @Column(name = "MEN_MGT")
  private String MEN_MGT;

  @Column(name = "NSS_EMPR")
  private String NSS_EMPR;

  @Column(name = "NSS_EMPE")
  private String NSS_EMPE;

  @Column(name = "CLE_NSS_EMPE")
  private Integer CLE_NSS_EMPE;

  @Column(name = "MGT_EMPE")
  private String MGT_EMPE;

  @Column(name = "SAL_BRUT")
  private BigDecimal SAL_BRUT;

  @Column(name = "SALAIRE_BRUT")
  private BigDecimal salaireBrut;

  @Column(name = "SALAIRE_POSTE")
  private BigDecimal salairePoste;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumns({
      @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false),
      @JoinColumn(name = "BUL_PRIM", referencedColumnName = "BUL_PRIM", insertable = false,
          updatable = false),
      @JoinColumn(name = "CODE_FIL", referencedColumnName = "CODE_FIL", insertable = false,
          updatable = false)})
  private BulletinArchive bulletinArchive;

  public BulletinArchivePK getBulletinTotalPK() {
    return bulletinTotalPK;
  }

  public void setBulletinTotalPK(BulletinArchivePK bulletinTotalPK) {
    this.bulletinTotalPK = bulletinTotalPK;
  }

  public BigDecimal getNET_FISC() {
    return NET_FISC;
  }

  public void setNET_FISC(BigDecimal NET_FISC) {
    this.NET_FISC = NET_FISC;
  }

  public BigDecimal getNET_APAY() {
    return NET_APAY;
  }

  public void setNET_APAY(BigDecimal NET_APAY) {
    this.NET_APAY = NET_APAY;
  }

  public BigDecimal getV_TOTAUX() {
    return V_TOTAUX;
  }

  public void setV_TOTAUX(BigDecimal V_TOTAUX) {
    this.V_TOTAUX = V_TOTAUX;
  }

    public BigDecimal getTotalGainsNonImposables() {
        return totalGainsNonImposables;
    }

    public void setTotalGainsNonImposables(BigDecimal totalGainsNonImposables) {
        this.totalGainsNonImposables = totalGainsNonImposables;
    }

  public BigDecimal getTO_RETEN() {
    return TO_RETEN;
  }

  public void setTO_RETEN(BigDecimal TO_RETEN) {
    this.TO_RETEN = TO_RETEN;
  }

  public BigDecimal getTO_R_IMP() {
    return TO_R_IMP;
  }

  public void setTO_R_IMP(BigDecimal TO_R_IMP) {
    this.TO_R_IMP = TO_R_IMP;
  }

  public BigDecimal getTO_R_NIM() {
    return TO_R_NIM;
  }

  public void setTO_R_NIM(BigDecimal TO_R_NIM) {
    this.TO_R_NIM = TO_R_NIM;
  }

  public BigDecimal getTROP_PER() {
    return TROP_PER;
  }

  public void setTROP_PER(BigDecimal TROP_PER) {
    this.TROP_PER = TROP_PER;
  }

  public String getLIB_CNAS() {
    return LIB_CNAS;
  }

  public void setLIB_CNAS(String LIB_CNAS) {
    this.LIB_CNAS = LIB_CNAS;
  }

  public Integer getCODE_WIL() {
    return CODE_WIL;
  }

  public void setCODE_WIL(Integer CODE_WIL) {
    this.CODE_WIL = CODE_WIL;
  }

  public String getMEN_MGT() {
    return MEN_MGT;
  }

  public void setMEN_MGT(String MEN_MGT) {
    this.MEN_MGT = MEN_MGT;
  }

  public String getNSS_EMPR() {
    return NSS_EMPR;
  }

  public void setNSS_EMPR(String NSS_EMPR) {
    this.NSS_EMPR = NSS_EMPR;
  }

  public String getNSS_EMPE() {
    return NSS_EMPE;
  }

  public void setNSS_EMPE(String NSS_EMPE) {
    this.NSS_EMPE = NSS_EMPE;
  }

  public Integer getCLE_NSS_EMPE() {
    return CLE_NSS_EMPE;
  }

  public void setCLE_NSS_EMPE(Integer CLE_NSS_EMPE) {
    this.CLE_NSS_EMPE = CLE_NSS_EMPE;
  }

  public String getMGT_EMPE() {
    return MGT_EMPE;
  }

  public void setMGT_EMPE(String MGT_EMPE) {
    this.MGT_EMPE = MGT_EMPE;
  }

  public BigDecimal getSAL_BRUT() {
    return SAL_BRUT;
  }

  public void setSAL_BRUT(BigDecimal SAL_BRUT) {
    this.SAL_BRUT = SAL_BRUT;
  }

  public BigDecimal getSalaireBrut() {
    return salaireBrut;
  }

  public void setSalaireBrut(BigDecimal salaireBrut) {
    this.salaireBrut = salaireBrut;
  }

  public BigDecimal getSalairePoste() {
    return salairePoste;
  }

  public void setSalairePoste(BigDecimal salairePoste) {
    this.salairePoste = salairePoste;
  }

  public BulletinArchive getBulletinArchive() {
    return bulletinArchive;
  }

  public void setBulletinArchive(BulletinArchive bulletinArchive) {
    this.bulletinArchive = bulletinArchive;
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
    if (!(object instanceof BulletinTotalArchive)) {
      return false;
    }
    BulletinTotalArchive other = (BulletinTotalArchive) object;
    if ((this.bulletinTotalPK == null && other.bulletinTotalPK != null)
        || (this.bulletinTotalPK != null && !this.bulletinTotalPK.equals(other.bulletinTotalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BulletinTotalArchive[ id=" + bulletinTotalPK + " ]";
  }
}
