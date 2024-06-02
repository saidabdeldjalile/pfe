/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

/**
 * DTO pour l'entité RefFonction.
 */
public class FunctionDTO {

  private Integer id;
  private String libelle;
  private String description;
  private String url;
  private Integer rang;

  public FunctionDTO() {}

  public FunctionDTO(Integer id, String libelle, String description, String url, Integer rang) {
    this.id = id;
    this.libelle = libelle;
    this.description = description;
    this.url = url;
    this.rang = rang;
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

}
