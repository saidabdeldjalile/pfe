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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "BULLETIN_DETAIL", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BulletinDetail.findAll", query = "SELECT b FROM BulletinDetail b"),
    @NamedQuery(name = "BulletinDetail.findByCodeDtb",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.codeDtb = :codeDtb"),
    @NamedQuery(name = "BulletinDetail.findByMatricule",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.matricule = :matricule"),
    @NamedQuery(name = "BulletinDetail.findByDatePai",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.datePai = :datePai"),
    @NamedQuery(name = "BulletinDetail.findByDateTrt",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BulletinDetail.findByBulPrim",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.bulPrim = :bulPrim"),
    @NamedQuery(name = "BulletinDetail.findByCodeRub",
        query = "SELECT b FROM BulletinDetail b WHERE b.codeRub = :codeRub"),
    @NamedQuery(name = "BulletinDetail.findByLibRubr",
        query = "SELECT b FROM BulletinDetail b WHERE b.libRubr = :libRubr"),
    @NamedQuery(name = "BulletinDetail.findBySensRub",
        query = "SELECT b FROM BulletinDetail b WHERE b.sensRub = :sensRub"),
    @NamedQuery(name = "BulletinDetail.findByNbJrHr",
        query = "SELECT b FROM BulletinDetail b WHERE b.nbJrHr = :nbJrHr"),
    @NamedQuery(name = "BulletinDetail.findByRefTxas",
        query = "SELECT b FROM BulletinDetail b WHERE b.refTxas = :refTxas"),
    @NamedQuery(name = "BulletinDetail.findByGImposa",
        query = "SELECT b FROM BulletinDetail b WHERE b.gImposa = :gImposa"),
    @NamedQuery(name = "BulletinDetail.findByGNimpos",
        query = "SELECT b FROM BulletinDetail b WHERE b.gNimpos = :gNimpos"),
    @NamedQuery(name = "BulletinDetail.findByRImposa",
        query = "SELECT b FROM BulletinDetail b WHERE b.rImposa = :rImposa"),
    @NamedQuery(name = "BulletinDetail.findByRNimpos",
        query = "SELECT b FROM BulletinDetail b WHERE b.rNimpos = :rNimpos"),
    @NamedQuery(name = "BulletinDetail.findByCodeFil",
        query = "SELECT b FROM BulletinDetail b WHERE b.bulletinDetailPK.codeFil = :codeFil")})
public class BulletinDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BulletinDetailPK bulletinDetailPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIB_RUBR")
  private String libRubr;
  @Column(name = "SENS_RUB")
  private Character sensRub;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "NB_JR_HR")
  private BigDecimal nbJrHr;
  @Column(name = "REF_TXAS")
  private BigDecimal refTxas;
  @Column(name = "G_IMPOSA")
  private BigDecimal gImposa;
  @Column(name = "G_NIMPOS")
  private BigDecimal gNimpos;
  @Column(name = "R_IMPOSA")
  private BigDecimal rImposa;
  @Column(name = "R_NIMPOS")
  private BigDecimal rNimpos;

  public BulletinDetail() {}

  public BulletinDetail(BulletinDetailPK bulletinDetailPK) {
    this.bulletinDetailPK = bulletinDetailPK;
  }

  public BulletinDetail(BulletinDetailPK bulletinDetailPK, String codeRub, String libRubr) {
    this.bulletinDetailPK = bulletinDetailPK;
    this.codeRub = codeRub;
    this.libRubr = libRubr;
  }

  public BulletinDetail(int codeDtb, int matricule, int datePai, int dateTrt, boolean bulPrim,
      Character codeFil) {
    this.bulletinDetailPK =
        new BulletinDetailPK(codeDtb, matricule, datePai, dateTrt, bulPrim, codeFil);
  }

  public BulletinDetailPK getBulletinDetailPK() {
    return bulletinDetailPK;
  }

  public void setBulletinDetailPK(BulletinDetailPK bulletinDetailPK) {
    this.bulletinDetailPK = bulletinDetailPK;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public String getLibRubr() {
    return libRubr;
  }

  public void setLibRubr(String libRubr) {
    this.libRubr = libRubr;
  }

  public Character getSensRub() {
    return sensRub;
  }

  public void setSensRub(Character sensRub) {
    this.sensRub = sensRub;
  }

  public BigDecimal getNbJrHr() {
    return nbJrHr;
  }

  public void setNbJrHr(BigDecimal nbJrHr) {
    this.nbJrHr = nbJrHr;
  }

  public BigDecimal getRefTxas() {
    return refTxas;
  }

  public void setRefTxas(BigDecimal refTxas) {
    this.refTxas = refTxas;
  }

  public BigDecimal getGImposa() {
    return gImposa;
  }

  public void setGImposa(BigDecimal gImposa) {
    this.gImposa = gImposa;
  }

  public BigDecimal getGNimpos() {
    return gNimpos;
  }

  public void setGNimpos(BigDecimal gNimpos) {
    this.gNimpos = gNimpos;
  }

  public BigDecimal getRImposa() {
    return rImposa;
  }

  public void setRImposa(BigDecimal rImposa) {
    this.rImposa = rImposa;
  }

  public BigDecimal getRNimpos() {
    return rNimpos;
  }

  public void setRNimpos(BigDecimal rNimpos) {
    this.rNimpos = rNimpos;
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
    if (!(object instanceof BulletinDetail)) {
      return false;
    }
    BulletinDetail other = (BulletinDetail) object;
    if ((this.bulletinDetailPK == null && other.bulletinDetailPK != null)
        || (this.bulletinDetailPK != null
            && !this.bulletinDetailPK.equals(other.bulletinDetailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.BulletinDetail[ bulletinDetailPK=" + bulletinDetailPK + " ]";
  }

}
