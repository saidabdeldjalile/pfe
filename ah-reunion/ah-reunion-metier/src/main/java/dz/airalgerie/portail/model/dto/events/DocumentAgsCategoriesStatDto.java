/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.events;

import java.io.Serializable;

/**
 *
 */
public class DocumentAgsCategoriesStatDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nom;
  private Integer nbDocument;

  public DocumentAgsCategoriesStatDto() {
  }

  public DocumentAgsCategoriesStatDto(Integer id, String nom, Integer nbDocument) {
    this.id = id;
    this.nom = nom;
    this.nbDocument = nbDocument;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Integer getNbDocument() {
    return nbDocument;
  }

  public void setNbDocument(Integer nbDocument) {
    this.nbDocument = nbDocument;
  }

}
