/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ca;

import java.math.BigDecimal;

/**
 *
 * @author Administrateur
 */
public class heure_vol {

  private int num_ligne;
  private String Code_Relation;
  private BigDecimal heure_vol;
  private String type_app;
  private String relation;
  private String reseau;
  private String rotation;

  public BigDecimal getHeure_vol() {
    return heure_vol;
  }

  public void setHeure_vol(BigDecimal heure_vol) {
    this.heure_vol = heure_vol;
  }

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

  public heure_vol() {}

  public heure_vol(int num_ligne, String Code_Relation, String type_app) {
    this.num_ligne = num_ligne;
    this.Code_Relation = Code_Relation;
    this.type_app = type_app;

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

  public String getType_app() {
    return type_app;
  }

  public void setType_app(String type_app) {
    this.type_app = type_app;
  }

}
