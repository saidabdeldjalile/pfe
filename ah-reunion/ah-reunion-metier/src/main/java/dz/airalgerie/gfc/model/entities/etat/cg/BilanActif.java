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
public class BilanActif implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "BRUTE")
  private BigDecimal brute;
  @Column(name = "AMORTISSEMENT")
  private BigDecimal amortissement;
  @Column(name = "NET")
  private BigDecimal net;
  @Column(name = "NET_ANT")
  private BigDecimal netAnt;

  public BilanActif() {}

  public BilanActif(String libelle, BigDecimal brute, BigDecimal amortissement, BigDecimal net,
      BigDecimal netAnt) {
    this.libelle = libelle;
    this.brute = brute;
    this.amortissement = amortissement;
    this.net = net;
    this.netAnt = netAnt;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getBrute() {
    return brute;
  }

  public void setBrute(BigDecimal brute) {
    this.brute = brute;
  }

  public BigDecimal getAmortissement() {
    return amortissement;
  }

  public void setAmortissement(BigDecimal amortissement) {
    this.amortissement = amortissement;
  }

  public BigDecimal getNet() {
    return net;
  }

  public void setNet(BigDecimal net) {
    this.net = net;
  }

  public BigDecimal getNetAnt() {
    return netAnt;
  }

  public void setNetAnt(BigDecimal netAnt) {
    this.netAnt = netAnt;
  }

}
