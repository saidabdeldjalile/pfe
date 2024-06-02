/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.V_ART_INVENTAIRE")
@XmlRootElement
public class VueArtInventaire implements Serializable {
  @EmbeddedId
  private VueArtInventairePK vueArtInventairePK;
  private static final long serialVersionUID = 1L;
  @Column(name = "designation")
  private String designation;
  @Column(name = "codeMesure")
  private String codeMesure;
  @Column(name = "specification")
  private String specification;
  @Column(name = "typePN")
  private String typePN;
  @Column(name = "codeRepere1")
  private String codeRepere1;
  @Size(max = 15)
  @Column(name = "typeRepere1")
  private String typeRepere1;
  @Column(name = "codeMagasin1")
  private String codeMagasin1;
  @Column(name = "codeRepere2")
  private String codeRepere2;
  @Column(name = "typeRepere2")
  private String typeRepere2;
  @Column(name = "codeMagasin2")
  private String codeMagasin2;
  @Column(name = "codeRepere3")
  private String codeRepere3;
  @Column(name = "typeRepere3")
  private String typeRepere3;
  @Column(name = "codeMagasin3")
  private String codeMagasin3;
  @Column(name = "codeRepere4")
  private String codeRepere4;
  @Column(name = "typeRepere4")
  private String typeRepere4;
  @Column(name = "codeMagasin4")
  private String codeMagasin4;
  @Column(name = "pmpReint")
  private BigDecimal pmpReint;
  @Column(name = "dateDernierMvt")
  @Temporal(TemporalType.DATE)
  private Date dateDernierMvt;
  @Column(name = "dateTraitement")
  private int dateTraitement;
  @Column(name = "quantiteCpt")
  private BigDecimal quantiteCpt;
  @Column(name = "valeurCpt")
  private BigDecimal valeurCpt;
  @Column(name = "quantitePhy")
  private BigDecimal quantitePhy;
  @Column(name = "valeurPhy")
  private BigDecimal valeurPhy;
  @Column(name = "ecartQte")
  private BigDecimal ecartQte;
  @Column(name = "ecartVal")
  private BigDecimal ecartVal;
  @Basic(optional = false)
  @Column(name = "dateInventaire")
  @Temporal(TemporalType.DATE)
  private Date dateInventaire;
  @Column(name = "quantiteRamene")
  private BigDecimal quantiteRamene;

  public VueArtInventaire() {}

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public String getTypePN() {
    return typePN;
  }

  public void setTypePN(String typePN) {
    this.typePN = typePN;
  }

  public String getCodeRepere1() {
    return codeRepere1;
  }

  public void setCodeRepere1(String codeRepere1) {
    this.codeRepere1 = codeRepere1;
  }

  public String getTypeRepere1() {
    return typeRepere1;
  }

  public void setTypeRepere1(String typeRepere1) {
    this.typeRepere1 = typeRepere1;
  }

  public String getCodeMagasin1() {
    return codeMagasin1;
  }

  public void setCodeMagasin1(String codeMagasin1) {
    this.codeMagasin1 = codeMagasin1;
  }

  public String getCodeRepere2() {
    return codeRepere2;
  }

  public void setCodeRepere2(String codeRepere2) {
    this.codeRepere2 = codeRepere2;
  }

  public String getTypeRepere2() {
    return typeRepere2;
  }

  public void setTypeRepere2(String typeRepere2) {
    this.typeRepere2 = typeRepere2;
  }

  public String getCodeMagasin2() {
    return codeMagasin2;
  }

  public void setCodeMagasin2(String codeMagasin2) {
    this.codeMagasin2 = codeMagasin2;
  }

  public String getCodeRepere3() {
    return codeRepere3;
  }

  public void setCodeRepere3(String codeRepere3) {
    this.codeRepere3 = codeRepere3;
  }

  public String getTypeRepere3() {
    return typeRepere3;
  }

  public void setTypeRepere3(String typeRepere3) {
    this.typeRepere3 = typeRepere3;
  }

  public String getCodeMagasin3() {
    return codeMagasin3;
  }

  public void setCodeMagasin3(String codeMagasin3) {
    this.codeMagasin3 = codeMagasin3;
  }

  public String getCodeRepere4() {
    return codeRepere4;
  }

  public void setCodeRepere4(String codeRepere4) {
    this.codeRepere4 = codeRepere4;
  }

  public String getTypeRepere4() {
    return typeRepere4;
  }

  public void setTypeRepere4(String typeRepere4) {
    this.typeRepere4 = typeRepere4;
  }

  public String getCodeMagasin4() {
    return codeMagasin4;
  }

  public void setCodeMagasin4(String codeMagasin4) {
    this.codeMagasin4 = codeMagasin4;
  }

  public Date getDateDernierMvt() {
    return dateDernierMvt;
  }

  public BigDecimal getPmpReint() {
    return pmpReint;
  }

  public void setPmpReint(BigDecimal pmpReint) {
    this.pmpReint = pmpReint;
  }

  public void setDateDernierMvt(Date dateDernierMvt) {
    this.dateDernierMvt = dateDernierMvt;
  }

  public VueArtInventairePK getVueArtInventairePK() {
    return vueArtInventairePK;
  }

  public void setVueArtInventairePK(VueArtInventairePK vueArtInventairePK) {
    this.vueArtInventairePK = vueArtInventairePK;
  }

  public int getDateTraitement() {
    return dateTraitement;
  }

  public void setDateTraitement(int dateTraitement) {
    this.dateTraitement = dateTraitement;
  }

  public BigDecimal getQuantiteCpt() {
    return quantiteCpt;
  }

  public void setQuantiteCpt(BigDecimal quantiteCpt) {
    this.quantiteCpt = quantiteCpt;
  }

  public BigDecimal getValeurCpt() {
    return valeurCpt;
  }

  public void setValeurCpt(BigDecimal valeurCpt) {
    this.valeurCpt = valeurCpt;
  }

  public BigDecimal getQuantitePhy() {
    return quantitePhy;
  }

  public void setQuantitePhy(BigDecimal quantitePhy) {
    this.quantitePhy = quantitePhy;
  }

  public BigDecimal getValeurPhy() {
    return valeurPhy;
  }

  public void setValeurPhy(BigDecimal valeurPhy) {
    this.valeurPhy = valeurPhy;
  }

  public BigDecimal getEcartQte() {
    return ecartQte;
  }

  public void setEcartQte(BigDecimal ecartQte) {
    this.ecartQte = ecartQte;
  }

  public BigDecimal getEcartVal() {
    return ecartVal;
  }

  public void setEcartVal(BigDecimal ecartVal) {
    this.ecartVal = ecartVal;
  }

  public Date getDateInventaire() {
    return dateInventaire;
  }

  public void setDateInventaire(Date dateInventaire) {
    this.dateInventaire = dateInventaire;
  }

  public BigDecimal getQuantiteRamene() {
    return quantiteRamene;
  }

  public void setQuantiteRamene(BigDecimal quantiteRamene) {
    this.quantiteRamene = quantiteRamene;
  }

}
