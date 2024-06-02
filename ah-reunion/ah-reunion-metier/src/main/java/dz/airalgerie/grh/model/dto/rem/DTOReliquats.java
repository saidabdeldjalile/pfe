/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.grh.model.dto.rem;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author AGHA Riadh
 */
public class DTOReliquats implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer matricule;
  private String nom;
  private String grpChap;
  private String dirLibelle;
  private Character codeTech;
  private BigDecimal nbReliquats;
  private BigDecimal nbReliquatsAcquis;
  private BigDecimal nbReliquatsPrevis;

  public DTOReliquats() {
  }

  public DTOReliquats(Integer matricule, String nom, String grpChap, String dirLibelle,
      Character codeTech, BigDecimal nbReliquats, BigDecimal nbReliquatsAcquis,
      BigDecimal nbReliquatsPrevis) {
    this.matricule = matricule;
    this.nom = nom;
    this.grpChap = grpChap;
    this.dirLibelle = dirLibelle;
    this.codeTech = codeTech;
    this.nbReliquats = nbReliquats;
    this.nbReliquatsAcquis = nbReliquatsAcquis;
    this.nbReliquatsPrevis = nbReliquatsPrevis;
  }


  public BigDecimal getNbReliquats() {
    return nbReliquats;
  }

  public void setNbReliquats(BigDecimal nbReliquats) {
    this.nbReliquats = nbReliquats;
  }



  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getDirLibelle() {
    return dirLibelle;
  }

  public void setDirLibelle(String dirLibelle) {
    this.dirLibelle = dirLibelle;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public BigDecimal getNbReliquatsAcquis() {
    return nbReliquatsAcquis;
  }

  public void setNbReliquatsAcquis(BigDecimal nbReliquatsAcquis) {
    this.nbReliquatsAcquis = nbReliquatsAcquis;
  }

  public BigDecimal getNbReliquatsPrevis() {
    return nbReliquatsPrevis;
  }

  public void setNbReliquatsPrevis(BigDecimal nbReliquatsPrevis) {
    this.nbReliquatsPrevis = nbReliquatsPrevis;
  }



}
