/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.io.Serializable;

/**
 *
 */
public class ChartModel implements Serializable {

  private static final long serialVersionUID = 1;

  private String label;
  private Number record;

  public ChartModel() {
    super();
  }

  public ChartModel(String label, Long record) {
    this.label = label;
    this.record = record;
  }

  public ChartModel(String label, Number record) {
    this.label = label;
    this.record = record;
  }

  public Number getRecord() {
    return record;
  }

  public void setRecord(Number record) {
    this.record = record;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
