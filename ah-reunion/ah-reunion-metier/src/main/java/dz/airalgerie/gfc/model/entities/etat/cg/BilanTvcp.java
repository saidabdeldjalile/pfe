/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class BilanTvcp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "ID")
  private int id;
  @Id
  @Column(name = "LIBELLE")
  private String libelle;
  @Id
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Column(name = "NOTE")
  private String note;
  @Column(name = "CAPITAL_SOCIAL")
  private BigDecimal capitaleSocial;
  @Column(name = "PRIME_EMISSION")
  private BigDecimal primeEmission;
  @Column(name = "ECART_EVALUATION")
  private BigDecimal ecartEvaluation;
  @Column(name = "ECART_REEVALUATION")
  private BigDecimal ecartReevaluation;
  @Column(name = "RESERVES_RESULTAT")
  private BigDecimal reservesResultat;

  public BilanTvcp() {}

  public BilanTvcp(int id, String libelle, int dateTrt, String note, BigDecimal capitaleSocial,
      BigDecimal primeEmission, BigDecimal ecartEvaluation, BigDecimal ecartReevaluation,
      BigDecimal reservesResultat) {
    this.id = id;
    this.libelle = libelle;
    this.dateTrt = dateTrt;
    this.note = note;
    this.capitaleSocial = capitaleSocial;
    this.primeEmission = primeEmission;
    this.ecartEvaluation = ecartEvaluation;
    this.ecartReevaluation = ecartReevaluation;
    this.reservesResultat = reservesResultat;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public BigDecimal getCapitaleSocial() {
    return capitaleSocial;
  }

  public void setCapitaleSocial(BigDecimal capitaleSocial) {
    this.capitaleSocial = capitaleSocial;
  }

  public BigDecimal getPrimeEmission() {
    return primeEmission;
  }

  public void setPrimeEmission(BigDecimal primeEmission) {
    this.primeEmission = primeEmission;
  }

  public BigDecimal getEcartEvaluation() {
    return ecartEvaluation;
  }

  public void setEcartEvaluation(BigDecimal ecartEvaluation) {
    this.ecartEvaluation = ecartEvaluation;
  }

  public BigDecimal getEcartReevaluation() {
    return ecartReevaluation;
  }

  public void setEcartReevaluation(BigDecimal ecartReevaluation) {
    this.ecartReevaluation = ecartReevaluation;
  }

  public BigDecimal getReservesResultat() {
    return reservesResultat;
  }

  public void setReservesResultat(BigDecimal reservesResultat) {
    this.reservesResultat = reservesResultat;
  }

}
