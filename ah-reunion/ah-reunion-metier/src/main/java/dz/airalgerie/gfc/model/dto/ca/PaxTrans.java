/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.ca;

/**
 *
 * @author Administrateur
 */
public class PaxTrans {

  private int num_ligne;
  private String Code_Relation;

  private String relation;
  private String reseau;
  private String rotation;
  private int paxF;
  private int paxC;
  private int paxY;
  private int Tpax;
  private int Grat;
  private int bebes;
  private int total_pass;

  public PaxTrans() {}

  public PaxTrans(int num_ligne, String Code_Relation, String relation) {
    this.num_ligne = num_ligne;
    this.Code_Relation = Code_Relation;
    this.relation = relation;
  }

  public int getPaxY() {
    return paxY;
  }

  public void setPaxY(int paxY) {
    this.paxY = paxY;
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

  public int getPaxF() {
    return paxF;
  }

  public void setPaxF(int paxF) {
    this.paxF = paxF;
  }

  public int getPaxC() {
    return paxC;
  }

  public void setPaxC(int paxC) {
    this.paxC = paxC;
  }

  public int getTpax() {
    return Tpax;
  }

  public void setTpax(int Tpax) {
    this.Tpax = Tpax;
  }

  public int getGrat() {
    return Grat;
  }

  public void setGrat(int Grat) {
    this.Grat = Grat;
  }

  public int getBebes() {
    return bebes;
  }

  public void setBebes(int bebes) {
    this.bebes = bebes;
  }

  public int getTotal_pass() {
    return total_pass;
  }

  public void setTotal_pass(int total_pass) {
    this.total_pass = total_pass;
  }

}
