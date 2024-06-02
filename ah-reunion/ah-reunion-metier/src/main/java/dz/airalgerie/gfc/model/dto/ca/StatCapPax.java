/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ca;

/**
 *
 * @author Administrateur
 */
public class StatCapPax {
  private int num_ligne;
  private String Code_Relation;
  private int pkt;
  private int SKO;
  private float CR;
  private String type_app;
  private String lib;
  private String reseau;
  private String rotation;

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

  public StatCapPax() {}

  public StatCapPax(int num_ligne, String Code_Relation, String type_app, String lib) {
    this.num_ligne = num_ligne;
    this.Code_Relation = Code_Relation;
    this.type_app = type_app;
    this.lib = lib;
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

  public int getPkt() {
    return pkt;
  }

  public void setPkt(int pkt) {
    this.pkt = pkt;
  }

  public int getSKO() {
    return SKO;
  }

  public void setSKO(int SKO) {
    this.SKO = SKO;
  }

  public float getCR() {
    return CR;
  }

  public void setCR(float CR) {
    this.CR = CR;
  }

  public String getType_app() {
    return type_app;
  }

  public void setType_app(String type_app) {
    this.type_app = type_app;
  }

  public String getLib() {
    return lib;
  }

  public void setLib(String lib) {
    this.lib = lib;
  }

}
