/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.model.dto.auth;

import java.io.Serializable;

/**
 *
 */
public class RefFonctionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String libelle;
  private String description;
  private String url;
  private Integer rang;
  private String icon;
  private boolean statut;
  private Long idModule;
  private String codeModule;

  public RefFonctionDTO() {}

  public RefFonctionDTO(Long id, String code, String libelle, String description, String url,
      Integer rang, String icon, boolean statut, Long idModule, String codeModule) {
    this.id = id;
    this.code = code;
    this.libelle = libelle;
    this.description = description;
    this.url = url;
    this.rang = rang;
    this.icon = icon;
    this.statut = statut;
    this.idModule = idModule;
    this.codeModule = codeModule;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  public Long getIdModule() {
    return idModule;
  }

  public void setIdModule(Long idModule) {
    this.idModule = idModule;
  }

  public String getCodeModule() {
    return codeModule;
  }

  public void setCodeModule(String codeModule) {
    this.codeModule = codeModule;
  }

}
