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
public class PaieReport implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer matricule;
  private String nom;
  private Integer dateTrt;
  private String grpChap;
  private Integer nb;

  public PaieReport() {}

  public PaieReport(Integer matricule, String nom, Integer dateTrt, Integer nb) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.nb = nb;
  }

  public PaieReport(Integer matricule, String nom, Integer dateTrt, String grpChap, Integer nb) {
    this.matricule = matricule;
    this.nom = nom;
    this.dateTrt = dateTrt;
    this.grpChap = grpChap;
    this.nb = nb;
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

  public Integer getNb() {
    return nb;
  }

  public void setNb(Integer nb) {
    this.nb = nb;
  }

}
