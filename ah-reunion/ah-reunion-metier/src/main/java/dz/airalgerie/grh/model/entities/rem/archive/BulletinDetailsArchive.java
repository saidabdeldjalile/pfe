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
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "BULLETIN_DETAIL", schema = "T_BP")
public class BulletinDetailsArchive implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private BulletinDetailArchivePK bulletinDetailPK;

  @Column(name = "CODE_RUB")
  private String codeRubrique;

  @Column(name = "LIB_RUBR")
  private String libelleRubrique;

  @Column(name = "SENS_RUB")
  private String sensRubrique;

  @Column(name = "NB_JR_HR")
  private BigDecimal nbJrHr;

  @Column(name = "REF_TXAS")
  private BigDecimal tauxAssiette;

  @Column(name = "G_IMPOSA")
  private BigDecimal gainsImposables;

  @Column(name = "G_NIMPOS")
  private BigDecimal gainsNonImposables;

  @Column(name = "R_IMPOSA")
  private BigDecimal retenuesImposables;

  @Column(name = "R_NIMPOS")
  private BigDecimal retenuesNonImposables;

  public BulletinDetailArchivePK getBulletinDetailPK() {
    return bulletinDetailPK;
  }

  public void setBulletinDetailPK(BulletinDetailArchivePK bulletinDetailPK) {
    this.bulletinDetailPK = bulletinDetailPK;
  }

  public String getCodeRubrique() {
    return codeRubrique;
  }

  public void setCodeRubrique(String codeRubrique) {
    this.codeRubrique = codeRubrique;
  }

  public String getLibelleRubrique() {
    return libelleRubrique;
  }

  public void setLibelleRubrique(String libelleRubrique) {
    this.libelleRubrique = libelleRubrique;
  }

  public String getSensRubrique() {
    return sensRubrique;
  }

  public void setSensRubrique(String sensRubrique) {
    this.sensRubrique = sensRubrique;
  }

  public BigDecimal getNbJrHr() {
    return nbJrHr;
  }

  public void setNbJrHr(BigDecimal nbJrHr) {
    this.nbJrHr = nbJrHr;
  }

  public BigDecimal getTauxAssiette() {
    return tauxAssiette;
  }

  public void setTauxAssiette(BigDecimal tauxAssiette) {
    this.tauxAssiette = tauxAssiette;
  }

  public BigDecimal getGainsImposables() {
    return gainsImposables;
  }

  public void setGainsImposables(BigDecimal gainsImposables) {
    this.gainsImposables = gainsImposables;
  }

  public BigDecimal getGainsNonImposables() {
    return gainsNonImposables;
  }

  public void setGainsNonImposables(BigDecimal gainsNonImposables) {
    this.gainsNonImposables = gainsNonImposables;
  }

  public BigDecimal getRetenuesImposables() {
    return retenuesImposables;
  }

  public void setRetenuesImposables(BigDecimal retenuesImposables) {
    this.retenuesImposables = retenuesImposables;
  }

  public BigDecimal getRetenuesNonImposables() {
    return retenuesNonImposables;
  }

  public void setRetenuesNonImposables(BigDecimal retenuesNonImposables) {
    this.retenuesNonImposables = retenuesNonImposables;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bulletinDetailPK != null ? bulletinDetailPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinDetailsArchive)) {
      return false;
    }
    BulletinDetailsArchive other = (BulletinDetailsArchive) object;
    if ((this.bulletinDetailPK == null && other.bulletinDetailPK != null)
        || (this.bulletinDetailPK != null
            && !this.bulletinDetailPK.equals(other.bulletinDetailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BulletinDetailsArchive[ id=" + bulletinDetailPK + " ]";
  }

}
