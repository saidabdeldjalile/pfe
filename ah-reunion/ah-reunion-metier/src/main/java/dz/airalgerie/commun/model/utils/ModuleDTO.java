/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO pour l'entité RefModule
 */
public class ModuleDTO {

  private Integer id;
  private String libelle;
  private String description;
  private Integer rang;
  private String icon;
  private List<ModuleDTO> subModule;
  private List<FunctionDTO> fonctions;

  public ModuleDTO() {}

  public ModuleDTO(Integer id, String libelle, String description, Integer rang, String icon) {
    this.id = id;
    this.libelle = libelle;
    this.description = description;
    this.rang = rang;
    this.icon = icon;
    this.subModule = new ArrayList<>();
    this.fonctions = new ArrayList<>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public List<ModuleDTO> getSubModule() {
    return subModule;
  }

  public void setSubModule(List<ModuleDTO> subModule) {
    this.subModule = subModule;
  }

  public List<FunctionDTO> getFonctions() {
    return fonctions;
  }

  public void setFonctions(List<FunctionDTO> fonctions) {
    this.fonctions = fonctions;
  }
}
