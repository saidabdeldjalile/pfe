/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.events;

import java.io.Serializable;

/**
 *
 */
public class EventCategorieDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String shortName;
  private String description;

  public EventCategorieDto() {
  }

  public EventCategorieDto(Integer id, String shortName, String description) {
    this.id = id;
    this.shortName = shortName;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
