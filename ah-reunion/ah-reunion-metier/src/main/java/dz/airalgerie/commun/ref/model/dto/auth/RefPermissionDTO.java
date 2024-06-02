/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.model.dto.auth;

import java.io.Serializable;

/**
 *
 */
public class RefPermissionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String nom;
  private String description;
  private Long idFonction;
  private String codeFonction;
  private boolean viewAccess;

  public RefPermissionDTO() {}

  public RefPermissionDTO(Long id, String nom, String description, Long idFonction,
      String codeFonction, boolean viewAccess) {
    this.id = id;
    this.nom = nom;
    this.description = description;
    this.idFonction = idFonction;
    this.codeFonction = codeFonction;
    this.viewAccess = viewAccess;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getIdFonction() {
    return idFonction;
  }

  public void setIdFonction(Long idFonction) {
    this.idFonction = idFonction;
  }

  public String getCodeFonction() {
    return codeFonction;
  }

  public void setCodeFonction(String codeFonction) {
    this.codeFonction = codeFonction;
  }

  public boolean isViewAccess() {
    return viewAccess;
  }

  public void setViewAccess(boolean viewAccess) {
    this.viewAccess = viewAccess;
  }

}
