/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cloture;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class RecapMois implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "CODE_APPLICATION")
  private String codeApplication;
  @Id
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "NBR_ECRITURES")
  private int nbrEcriture;

  public RecapMois() {
    // empty constructor
  }

  public RecapMois(String libelle, String codeApplication, int nbrEcriture) {
    this.libelle = libelle;
    this.codeApplication = codeApplication;
    this.nbrEcriture = nbrEcriture;
  }

  public String getCodeAppAndLibelle() {

    return this.codeApplication + " - " + this.libelle;
  }

  public String getCodeApplication() {
    return codeApplication;
  }

  public void setCodeApplication(String codeApplication) {
    this.codeApplication = codeApplication;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public int getNbrEcriture() {
    return nbrEcriture;
  }

  public void setNbrEcriture(int nbrEcriture) {
    this.nbrEcriture = nbrEcriture;
  }

}
