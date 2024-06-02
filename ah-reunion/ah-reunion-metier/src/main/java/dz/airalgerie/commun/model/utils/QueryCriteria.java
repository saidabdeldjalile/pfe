/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.io.Serializable;

/**
 *
 */
public class QueryCriteria implements Serializable {

  private static final long serialVersionUID = 1;

  public final static int LIKE = 0;
  public final static int EQUALS = 1;
  public final static int GREATER = 2;
  public final static int LOWER = 3;
  public final static int BETWEEN = 4;
  public final static int IS_NULL = 5;
  public final static int IS_NOT_NULL = 6;
  public final static int IN = 7;
  public final static int STARTS_WITH = 8;
  public final static int NOT_STARTS_WITH = 9;
  public final static int ENDS_WITH = 10;
  public final static int NOT_ENDS_WITH = 11;

  private Object value;
  private Object valueB;
  private int type;

  public QueryCriteria(Object value) {
    this.value = value;
    this.type = this.LIKE;
  }

  public QueryCriteria(Object value, int type) {
    this.value = value;
    this.type = type;
  }

  public QueryCriteria(Object valueA, Object valueB, int type) {
    this.value = valueA;
    this.valueB = valueB;
    this.type = type;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public Object getValueB() {
    return valueB;
  }

  public void setValueB(Object valueB) {
    this.valueB = valueB;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

}
