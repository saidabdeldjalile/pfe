/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.commun;

import java.io.Serializable;

/**
 *
 */
public class PersonnelDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer matricule;
  private String nom;
  private String prenom;
  private String mail;

  public PersonnelDTO() {
  }

  public PersonnelDTO(Integer matricule,String nom,String prenom) {
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
  }

  public PersonnelDTO(Integer matricule, String nom,String prenom, String mail) {
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
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

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}
