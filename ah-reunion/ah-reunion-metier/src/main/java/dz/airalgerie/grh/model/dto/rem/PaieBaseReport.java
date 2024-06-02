/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.rem;

import java.io.Serializable;

/**
 *
 * @author Administrateur
 */
public class PaieBaseReport implements Serializable {

  private static final long serialVersionUID = 1L;

  protected Integer matricule;
  protected String nom;
  protected Integer dateTrt;
  protected String grpChap;

  public PaieBaseReport() {}

  public PaieBaseReport(Integer matricule, String nom, Integer dateTrt, String grpChap) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.grpChap = grpChap;
  }

  public PaieBaseReport(Integer matricule, String nom, String grpChap) {
    this.matricule = matricule;
    this.nom = nom;
    this.grpChap = grpChap;
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

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

}
