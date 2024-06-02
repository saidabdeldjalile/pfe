/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STK.v_ficheStock")

public class FicheStock implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private FicheStockPK ficheStockPK;
  @Size(min = 1, max = 5)
  @Column(name = "typeStock")
  private String typeStock;
  @Size(max = 45)
  @Column(name = "designation")
  private String designation;
  @Column(name = "codeAH")
  private String codeAH;
  @Column(name = "codeATA")
  private String codeATA;
  @Column(name = "specification")
  private String specification;
  @Column(name = "stkMin")
  private BigDecimal stkMin;
  @Column(name = "stkMax")
  private BigDecimal stkMax;
  @Column(name = "codeMesure")
  private String codeMesure;
  @Column(name = "codeFabricant")
  private String codeFabricant;
  @Column(name = "codeRepere")
  private String codeRepere;
  @Column(name = "codeReserve")
  private String codeReserve;
  @Column(name = "codeMagasin")
  private String codeMagasin;

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + Objects.hashCode(this.ficheStockPK);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final FicheStock other = (FicheStock) obj;
    if (!Objects.equals(this.ficheStockPK, other.ficheStockPK)) {
      return false;
    }
    return true;
  }

  public FicheStockPK getFicheStockPK() {
    return ficheStockPK;
  }

  public void setFicheStockPK(FicheStockPK ficheStockPK) {
    this.ficheStockPK = ficheStockPK;
  }

  public String getTypeStock() {
    return typeStock;
  }

  public void setTypeStock(String typeStock) {
    this.typeStock = typeStock;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodeAH() {
    return codeAH;
  }

  public void setCodeAH(String codeAH) {
    this.codeAH = codeAH;
  }

  public String getCodeATA() {
    return codeATA;
  }

  public void setCodeATA(String codeATA) {
    this.codeATA = codeATA;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public BigDecimal getStkMin() {
    return stkMin;
  }

  public void setStkMin(BigDecimal stkMin) {
    this.stkMin = stkMin;
  }

  public BigDecimal getStkMax() {
    return stkMax;
  }

  public void setStkMax(BigDecimal stkMax) {
    this.stkMax = stkMax;
  }

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
  }

  public String getCodeFabricant() {
    return codeFabricant;
  }

  public void setCodeFabricant(String codeFabricant) {
    this.codeFabricant = codeFabricant;
  }

  public String getCodeRepere() {
    return codeRepere;
  }

  public void setCodeRepere(String codeRepere) {
    this.codeRepere = codeRepere;
  }

  public String getCodeMagasin() {
    return codeMagasin;
  }

  public void setCodeMagasin(String codeMagasin) {
    this.codeMagasin = codeMagasin;
  }

  public String getCodeReserve() {
    return codeReserve;
  }

  public void setCodeReserve(String codeReserve) {
    this.codeReserve = codeReserve;
  }

}
