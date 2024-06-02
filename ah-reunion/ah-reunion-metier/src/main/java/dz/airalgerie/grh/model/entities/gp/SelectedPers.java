/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.time.LocalDate;

/**
 *
 * @author Administrateur
 */
public class SelectedPers {

  private String name;

  private String lastName;

  private String njfille;

  private String Lien;

  private LocalDate dateNaissance;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLien() {
    return Lien;
  }

  public void setLien(String Lien) {
    this.Lien = Lien;
  }

  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  public SelectedPers() {
  }

  @Override
  public String toString() {
    if (njfille != null && !njfille.isEmpty()) {
      return lastName + " " + name + " Née " + njfille + " ( " + Lien + " ) ";
    } else {
      return lastName + " " + name + " ( " + Lien + " ) ";
    }
  }
}
