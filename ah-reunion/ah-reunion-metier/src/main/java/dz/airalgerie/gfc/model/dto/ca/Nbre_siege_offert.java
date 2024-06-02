/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ca;

/**
 *
 * @author Administrateur
 */
public class Nbre_siege_offert {

  private int num_ligne;
  private String Code_Relation;

  private String type_app;
  private String libelle;
  private String reseau;
  private String rotation;
  private String relation;
  private int SOF;
  private int SOC;
  private int SOY;
  private int TOT_siege;

  public int getNum_ligne() {
    return num_ligne;
  }

  public void setNum_ligne(int num_ligne) {
    this.num_ligne = num_ligne;
  }

  public String getCode_Relation() {
    return Code_Relation;
  }

  public void setCode_Relation(String Code_Relation) {
    this.Code_Relation = Code_Relation;
  }

  public String getType_app() {
    return type_app;
  }

  public void setType_app(String type_app) {
    this.type_app = type_app;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public int getSOF() {
    return SOF;
  }

  public void setSOF(int SOF) {
    this.SOF = SOF;
  }

  public int getSOC() {
    return SOC;
  }

  public void setSOC(int SOC) {
    this.SOC = SOC;
  }

  public int getSOY() {
    return SOY;
  }

  public void setSOY(int SOY) {
    this.SOY = SOY;
  }

  public int getTOT_siege() {
    return TOT_siege;
  }

  public void setTOT_siege(int TOT_siege) {
    this.TOT_siege = TOT_siege;
  }

}
