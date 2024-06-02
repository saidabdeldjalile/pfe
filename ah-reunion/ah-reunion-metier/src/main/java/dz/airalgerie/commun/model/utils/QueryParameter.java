/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.io.Serializable;
import java.util.Set;

/**
 *
 */
public class QueryParameter implements Serializable {

  private static final long serialVersionUID = 1;

  private String alias;
  private Set<String> value;

  public QueryParameter() {}

  public QueryParameter(String alias, Set<String> value) {
    this.alias = alias;
    this.value = value;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public Set<String> getValue() {
    return value;
  }

  public void setValue(Set<String> value) {
    this.value = value;
  }

}
