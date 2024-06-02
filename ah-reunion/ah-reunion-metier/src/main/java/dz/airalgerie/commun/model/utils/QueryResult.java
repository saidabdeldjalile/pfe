/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class QueryResult<T> implements Serializable {

  private static final long serialVersionUID = 1;

  private Long totalRecords;
  private List<?> records = new ArrayList<>();

  public QueryResult() {
    super();
  }

  public QueryResult(long totalRecords, List<T> records) {
    super();
    this.totalRecords = totalRecords;
    this.records = records;
  }

  public Long getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Long totalRecords) {
    this.totalRecords = totalRecords;
  }

  public List<?> getRecords() {
    return records;
  }

  public void setRecords(List<?> records) {
    this.records = records;
  }

}
