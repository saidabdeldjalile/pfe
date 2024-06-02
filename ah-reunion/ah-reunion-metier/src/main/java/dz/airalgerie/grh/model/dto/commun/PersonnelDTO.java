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
  private String nomComplet;
  private String nom;
  private String nomJeuneFille;
  private String prenom;
  private Character codeTech;
  private Character sexe;
  private String codeFiliale;
  private String grpChap;
  private String libelleDirection;
  private String mail;

  public PersonnelDTO() {
  }

  public PersonnelDTO(Integer matricule, String nomComplet, String nom, String nomJeuneFille,
      String prenom, Character codeTech, Character sexe, String codeFiliale, String grpChap) {
    this.matricule = matricule;
    this.nomComplet = nomComplet;
    this.nom = nom;
    this.nomJeuneFille = nomJeuneFille;
    this.prenom = prenom;
    this.codeTech = codeTech;
    this.sexe = sexe;
    this.codeFiliale = codeFiliale;
    this.grpChap = grpChap;

  }

  public PersonnelDTO(Integer matricule, String nomComplet, String nom, String nomJeuneFille,
      String prenom, Character codeTech, Character sexe, String codeFiliale, String grpChap,
      String libelleDirection, String mail) {
    this.matricule = matricule;
    this.nomComplet = nomComplet;
    this.nom = nom;
    this.nomJeuneFille = nomJeuneFille;
    this.prenom = prenom;
    this.codeTech = codeTech;
    this.sexe = sexe;
    this.codeFiliale = codeFiliale;
    this.grpChap = grpChap;
    this.libelleDirection = libelleDirection;
    this.mail = mail;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNomComplet() {
    return nomComplet;
  }

  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNomJeuneFille() {
    return nomJeuneFille;
  }

  public void setNomJeuneFille(String nomJeuneFille) {
    this.nomJeuneFille = nomJeuneFille;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public Character getSexe() {
    return sexe;
  }

  public void setSexe(Character sexe) {
    this.sexe = sexe;
  }

  public String getCodeFiliale() {
    return codeFiliale;
  }

  public void setCodeFiliale(String codeFiliale) {
    this.codeFiliale = codeFiliale;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getLibelleDirection() {
    return libelleDirection;
  }

  public void setLibelleDirection(String libelleDirection) {
    this.libelleDirection = libelleDirection;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }



}
