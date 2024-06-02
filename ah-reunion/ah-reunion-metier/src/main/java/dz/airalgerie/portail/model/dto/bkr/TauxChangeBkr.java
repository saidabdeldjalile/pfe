/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.bkr;

import java.io.Serializable;

/**
 *
 * @author kehli
 */
public class TauxChangeBkr implements Serializable {

  private String codeAlphNum;
  private String valeur;

  public TauxChangeBkr() {
  }

  public TauxChangeBkr(String codeAlphNum, String valeur) {
    this.codeAlphNum = codeAlphNum;
    this.valeur = valeur;
  }

  public String getCodeAlphNum() {
    return codeAlphNum;
  }

  public void setCodeAlphNum(String codeAlphNum) {
    this.codeAlphNum = codeAlphNum;
  }

  public String getValeur() {
    return valeur;
  }

  public void setValeur(String valeur) {
    this.valeur = valeur;
  }


}
