/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem.archive;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "BULLETIN", schema = "T_BP")
public class BulletinArchive implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private BulletinArchivePK bulletinPK;

  @Column(name = "MOIS_PAI")
  private String MOIS_PAI;

  @Column(name = "ANNE_PAI")
  private Integer ANNE_PAI;

  @Column(name = "REF_ENTETE")
  private String REF_ENTETE;

  @Column(name = "CAT_ENTETE")
  private String CAT_ENTETE;

  @Column(name = "NOM")
  private String NOM;

  @Column(name = "FONCTION")
  private String FONCTION;

  @Column(name = "GRP_CHAP")
  private String GRP_CHAP;

  @Column(name = "AFFECTAT")
  private String AFFECTAT;

  @Column(name = "ADRESSE")
  private String ADRESSE;

  @Column(name = "BANQ_LIB")
  private String BANQ_LIB;

  @Column(name = "BNQ_NCPT")
  private String BNQ_NCPT;

  @Column(name = "COD_CATG")
  private String COD_CATG;

  @Column(name = "COD_ECHL")
  private String COD_ECHL;

  @Column(name = "DATE_ENT")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date DATE_ENT;

  @Column(name = "CODE_CIVIL")
  private String CODE_CIVIL;

  @Column(name = "ENFANTM10")
  private Integer ENFANTM10;

  @Column(name = "ENFANTP10")
  private Integer ENFANTP10;

  @Column(name = "CODE_ITS")
  private Integer CODE_ITS;

  @Column(name = "SAL_BASE")
  private BigDecimal SAL_BASE;

  @Column(name = "INDICE")
  private Integer INDICE;

  @Column(name = "TAUX")
  private String TAUX;

  @Column(name = "CODE_TECH")
  private String CODE_TECH;

  @Column(name = "PHV_REEL")
  private BigDecimal PHV_REEL;


  public BulletinArchivePK getBulletinPK() {
    return bulletinPK;
  }

  public void setBulletinPK(BulletinArchivePK bulletinPK) {
    this.bulletinPK = bulletinPK;
  }

  public String getMOIS_PAI() {
    return MOIS_PAI;
  }

  public void setMOIS_PAI(String MOIS_PAI) {
    this.MOIS_PAI = MOIS_PAI;
  }

  public Integer getANNE_PAI() {
    return ANNE_PAI;
  }

  public void setANNE_PAI(Integer ANNE_PAI) {
    this.ANNE_PAI = ANNE_PAI;
  }

  public String getREF_ENTETE() {
    return REF_ENTETE;
  }

  public void setREF_ENTETE(String REF_ENTETE) {
    this.REF_ENTETE = REF_ENTETE;
  }

  public String getCAT_ENTETE() {
    return CAT_ENTETE;
  }

  public void setCAT_ENTETE(String CAT_ENTETE) {
    this.CAT_ENTETE = CAT_ENTETE;
  }

  public String getNOM() {
    return NOM;
  }

  public void setNOM(String NOM) {
    this.NOM = NOM;
  }

  public String getFONCTION() {
    return FONCTION;
  }

  public void setFONCTION(String FONCTION) {
    this.FONCTION = FONCTION;
  }

  public String getGRP_CHAP() {
    return GRP_CHAP;
  }

  public void setGRP_CHAP(String GRP_CHAP) {
    this.GRP_CHAP = GRP_CHAP;
  }

  public String getAFFECTAT() {
    return AFFECTAT;
  }

  public void setAFFECTAT(String AFFECTAT) {
    this.AFFECTAT = AFFECTAT;
  }

  public String getADRESSE() {
    return ADRESSE;
  }

  public void setADRESSE(String ADRESSE) {
    this.ADRESSE = ADRESSE;
  }

  public String getBANQ_LIB() {
    return BANQ_LIB;
  }

  public void setBANQ_LIB(String BANQ_LIB) {
    this.BANQ_LIB = BANQ_LIB;
  }

  public String getBNQ_NCPT() {
    return BNQ_NCPT;
  }

  public void setBNQ_NCPT(String BNQ_NCPT) {
    this.BNQ_NCPT = BNQ_NCPT;
  }

  public String getCOD_CATG() {
    return COD_CATG;
  }

  public void setCOD_CATG(String COD_CATG) {
    this.COD_CATG = COD_CATG;
  }

  public String getCOD_ECHL() {
    return COD_ECHL;
  }

  public void setCOD_ECHL(String COD_ECHL) {
    this.COD_ECHL = COD_ECHL;
  }

  public Date getDATE_ENT() {
    return DATE_ENT;
  }

  public void setDATE_ENT(Date DATE_ENT) {
    this.DATE_ENT = DATE_ENT;
  }

  public String getCODE_CIVIL() {
    return CODE_CIVIL;
  }

  public void setCODE_CIVIL(String CODE_CIVIL) {
    this.CODE_CIVIL = CODE_CIVIL;
  }

  public Integer getENFANTM10() {
    return ENFANTM10;
  }

  public void setENFANTM10(Integer ENFANTM10) {
    this.ENFANTM10 = ENFANTM10;
  }

  public Integer getENFANTP10() {
    return ENFANTP10;
  }

  public void setENFANTP10(Integer ENFANTP10) {
    this.ENFANTP10 = ENFANTP10;
  }

  public Integer getCODE_ITS() {
    return CODE_ITS;
  }

  public void setCODE_ITS(Integer CODE_ITS) {
    this.CODE_ITS = CODE_ITS;
  }

  public BigDecimal getSAL_BASE() {
    return SAL_BASE;
  }

  public void setSAL_BASE(BigDecimal SAL_BASE) {
    this.SAL_BASE = SAL_BASE;
  }

  public Integer getINDICE() {
    return INDICE;
  }

  public void setINDICE(Integer INDICE) {
    this.INDICE = INDICE;
  }

  public String getTAUX() {
    return TAUX;
  }

  public void setTAUX(String TAUX) {
    this.TAUX = TAUX;
  }

  public String getCODE_TECH() {
    return CODE_TECH;
  }

  public void setCODE_TECH(String CODE_TECH) {
    this.CODE_TECH = CODE_TECH;
  }

  public BigDecimal getPHV_REEL() {
    return PHV_REEL;
  }

  public void setPHV_REEL(BigDecimal PHV_REEL) {
    this.PHV_REEL = PHV_REEL;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bulletinPK != null ? bulletinPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinArchive)) {
      return false;
    }
    BulletinArchive other = (BulletinArchive) object;
    if ((this.bulletinPK == null && other.bulletinPK != null)
        || (this.bulletinPK != null && !this.bulletinPK.equals(other.bulletinPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BulletinArchive[ id=" + bulletinPK + " ]";
  }

}
