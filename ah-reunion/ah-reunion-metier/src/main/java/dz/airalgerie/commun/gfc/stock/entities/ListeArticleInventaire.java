/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author user
 */
public class ListeArticleInventaire {

  private String pn;
  private String codeAppareil;
  private int dateTraitInv;
  private String designation;
  private String specification;
  private String codeMesure;
  private String codeRepere1;
  private String typeRepere1;
  private String codeMagasin1;
  private String codeRepere2;
  private String typeRepere2;
  private String codeMagasin2;
  private String codeRepere3;
  private String typeRepere3;
  private String codeMagasin3;
  private Date dateInventaire;
  private BigDecimal quantitePhy;
  private BigDecimal valeurPhy;
  private BigDecimal quantiteCpt;
  private BigDecimal valeurCpt;
  private BigDecimal quantiteRamene;
  private BigDecimal ecartQte;
  private BigDecimal ecartVal;
  private BigDecimal pmpReint;
  private Date dateDernierMvt;
  private String typePN;

  public ListeArticleInventaire(String pn, String codeAppareil, String designation,
      String specification, String codeMesure, String codeRepere1, String typeRepere1,
      String codeMagasin1, String codeRepere2, String typeRepere2, String codeMagasin2,
      String codeRepere3, String typeRepere3, String codeMagasin3, BigDecimal quantitePhy,
      BigDecimal valeurPhy, BigDecimal quantiteCpt, BigDecimal valeurCpt, int dateTraitInv,
      BigDecimal quantiteRamene, BigDecimal pmpReint, String typePN, Date dateDernierMvt,
      Date dateInventaire, BigDecimal ecartQte, BigDecimal ecartVal) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.designation = designation;
    this.specification = specification;
    this.codeMesure = codeMesure;
    this.codeRepere1 = codeRepere1;
    this.typeRepere1 = typeRepere1;
    this.codeMagasin1 = codeMagasin1;
    this.codeRepere2 = codeRepere2;
    this.typeRepere2 = typeRepere2;
    this.codeMagasin2 = codeMagasin2;
    this.codeRepere3 = codeRepere3;
    this.typeRepere3 = typeRepere3;
    this.codeMagasin3 = codeMagasin3;
    this.quantitePhy = quantitePhy;
    this.valeurPhy = valeurPhy;
    this.quantiteCpt = quantiteCpt;
    this.valeurCpt = valeurCpt;
    this.quantiteRamene = quantiteRamene;
    this.pmpReint = pmpReint;
    this.dateTraitInv = dateTraitInv;
    this.typePN = typePN;
    this.dateDernierMvt = dateDernierMvt;
    this.dateInventaire = dateInventaire;
    this.ecartQte = ecartQte;
    this.ecartVal = ecartVal;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
  }

  public String getCodeRepere1() {
    return codeRepere1;
  }

  public void setCodeRepere1(String codeRepere1) {
    this.codeRepere1 = codeRepere1;
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

  public String getCodeMagasin3() {
    return codeMagasin3;
  }

  public void setCodeMagasin3(String codeMagasin3) {
    this.codeMagasin3 = codeMagasin3;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public String getTypeRepere1() {
    return typeRepere1;
  }

  public void setTypeRepere1(String typeRepere1) {
    this.typeRepere1 = typeRepere1;
  }

  public String getTypeRepere2() {
    return typeRepere2;
  }

  public void setTypeRepere2(String typeRepere2) {
    this.typeRepere2 = typeRepere2;
  }

  public String getTypeRepere3() {
    return typeRepere3;
  }

  public void setTypeRepere3(String typeRepere3) {
    this.typeRepere3 = typeRepere3;
  }

  public int getDateTraitInv() {
    return dateTraitInv;
  }

  public void setDateTraitInv(int dateTraitInv) {
    this.dateTraitInv = dateTraitInv;
  }

  public Date getDateDernierMvt() {
    return dateDernierMvt;
  }

  public void setDateDernierMvt(Date dateDernierMvt) {
    this.dateDernierMvt = dateDernierMvt;
  }

  public Date getDateInventaire() {
    return dateInventaire;
  }

  public void setDateInventaire(Date dateInventaire) {
    this.dateInventaire = dateInventaire;
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

  public BigDecimal getQuantiteRamene() {
    return quantiteRamene;
  }

  public void setQuantiteRamene(BigDecimal quantiteRamene) {
    this.quantiteRamene = quantiteRamene;
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

  public BigDecimal getPmpReint() {
    return pmpReint;
  }

  public void setPmpReint(BigDecimal pmpReint) {
    this.pmpReint = pmpReint;
  }

  public String getTypePN() {
    return typePN;
  }

  public void setTypePN(String typePN) {
    this.typePN = typePN;
  }
}
