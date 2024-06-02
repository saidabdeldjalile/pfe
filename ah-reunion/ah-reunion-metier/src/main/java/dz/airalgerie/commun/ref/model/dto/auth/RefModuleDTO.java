/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.model.dto.auth;

import java.io.Serializable;

/**
 *
 */
public class RefModuleDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String libelle;
  private String description;
  private Integer rang;
  private String icon;
  private boolean statut;
  private Long idDomaine;
  private String codeDomaine;
  private Long idModuleParent;

  public RefModuleDTO() {}

  public RefModuleDTO(Long id, String code, String libelle, String description, Integer rang,
      String icon, boolean statut, Long idDomaine, String codeDomaine, Long idModuleParent) {
    this.id = id;
    this.code = code;
    this.libelle = libelle;
    this.description = description;
    this.rang = rang;
    this.icon = icon;
    this.statut = statut;
    this.idDomaine = idDomaine;
    this.codeDomaine = codeDomaine;
    this.idModuleParent = idModuleParent;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getRang() {
    return rang;
  }

  public void setRang(Integer rang) {
    this.rang = rang;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public boolean isStatut() {
    return statut;
  }

  public void setStatut(boolean statut) {
    this.statut = statut;
  }

  public Long getIdDomaine() {
    return idDomaine;
  }

  public void setIdDomaine(Long idDomaine) {
    this.idDomaine = idDomaine;
  }

  public String getCodeDomaine() {
    return codeDomaine;
  }

  public void setCodeDomaine(String codeDomaine) {
    this.codeDomaine = codeDomaine;
  }

  public Long getIdModuleParent() {
    return idModuleParent;
  }

  public void setIdModuleParent(Long idModuleParent) {
    this.idModuleParent = idModuleParent;
  }

  @Override
  public String toString() {
    return "RefModuleDTO{" + "id=" + id + ", code=" + code + ", libelle=" + libelle
        + ", description=" + description + ", rang=" + rang + ", icon=" + icon + ", statut="
        + statut + ", idDomaine=" + idDomaine + ", idModuleParent=" + idModuleParent + '}';
  }

}
