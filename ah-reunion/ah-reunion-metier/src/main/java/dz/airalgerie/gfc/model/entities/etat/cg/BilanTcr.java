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
public class BilanTcr implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "SOLDE")
  private BigDecimal solde;
  @Column(name = "SOLDE_ANT")
  private BigDecimal soldeAnt;

  public BilanTcr() {}

  public BilanTcr(String libelle, BigDecimal solde, BigDecimal soldeAnt) {
    this.libelle = libelle;
    this.solde = solde;
    this.soldeAnt = soldeAnt;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getSolde() {
    return solde;
  }

  public void setSolde(BigDecimal solde) {
    this.solde = solde;
  }

  public BigDecimal getSoldeAnt() {
    return soldeAnt;
  }

  public void setSoldeAnt(BigDecimal soldeAnt) {
    this.soldeAnt = soldeAnt;
  }
}
