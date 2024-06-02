/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ca;

/**
 *
 * @author Administrateur
 */
public class kmparc {

  private int num_ligne;
  private String Code_Relation;
  private int troncon;
  private String type_app;
  private String libelle;
  private String reseau;
  private String rotation;
  private String relation;

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
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

  public int getTroncon() {
    return troncon;
  }

  public void setTroncon(int troncon) {
    this.troncon = troncon;
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

}
