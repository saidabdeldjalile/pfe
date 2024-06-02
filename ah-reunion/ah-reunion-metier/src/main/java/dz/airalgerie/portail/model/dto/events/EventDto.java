/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.events;

import java.io.Serializable;

/**
 *
 */
public class EventDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer sectorId;
  private String sectorName;
  private String shortName;
  private String description;
  private Integer limitId;
  private String limit1;
  private String limit2;
  private String limit3;

  public EventDto() {
  }

  public EventDto(Integer id, Integer sectorId, String sectorName, String shortName,
      String description, Integer limitId, String limit1, String limit2, String limit3) {
    this.id = id;
    this.sectorId = sectorId;
    this.sectorName = sectorName;
    this.shortName = shortName;
    this.description = description;
    this.limitId = limitId;
    this.limit1 = limit1;
    this.limit2 = limit2;
    this.limit3 = limit3;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSectorId() {
    return sectorId;
  }

  public void setSectorId(Integer sectorId) {
    this.sectorId = sectorId;
  }

  public String getSectorName() {
    return sectorName;
  }

  public void setSectorName(String sectorName) {
    this.sectorName = sectorName;
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

  public Integer getLimitId() {
    return limitId;
  }

  public void setLimitId(Integer limitId) {
    this.limitId = limitId;
  }

  public String getLimit1() {
    return limit1;
  }

  public void setLimit1(String limit1) {
    this.limit1 = limit1;
  }

  public String getLimit2() {
    return limit2;
  }

  public void setLimit2(String limit2) {
    this.limit2 = limit2;
  }

  public String getLimit3() {
    return limit3;
  }

  public void setLimit3(String limit3) {
    this.limit3 = limit3;
  }


}
