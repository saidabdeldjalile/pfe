/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.dto.vol;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 */
public class PlanningFlightOpsDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  protected Logger log;

  private Integer id;
  private String flt;
  private String dep;
  private String arr;
  private LocalDateTime std;
  private LocalDateTime sta;
  private Integer nId;
  private String nFlt;
  private LocalDateTime nStd;
  private LocalDateTime nSta;
  private String nDep;
  private String nArr;
  private Integer totalHours;
  private Integer totalMin;

  public PlanningFlightOpsDTO() {
  }

  public PlanningFlightOpsDTO(Integer id) {
    this.id = id;
  }

  public PlanningFlightOpsDTO(Integer id, String flt, String dep, String arr,
      LocalDateTime std, LocalDateTime sta, Integer nId, String nFlt, LocalDateTime nStd,
      LocalDateTime nSta, String nDep, String nArr, Integer totalHours, Integer totalMin) {
    this.id = id;
    this.flt = flt;
    this.dep = dep;
    this.arr = arr;
    this.std = std;
    this.sta = sta;
    this.nId = nId;
    this.nFlt = nFlt;
    this.nStd = nStd;
    this.nSta = nSta;
    this.nDep = nDep;
    this.nArr = nArr;
    this.totalHours = totalHours;
    this.totalMin = totalMin;
  }

  public Logger getLog() {
    return log;
  }

  public void setLog(Logger log) {
    this.log = log;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getArr() {
    return arr;
  }

  public void setArr(String arr) {
    this.arr = arr;
  }

  public LocalDateTime getStd() {
    return std;
  }

  public void setStd(LocalDateTime std) {
    this.std = std;
  }

  public LocalDateTime getSta() {
    return sta;
  }

  public void setSta(LocalDateTime sta) {
    this.sta = sta;
  }

  public Integer getnId() {
    return nId;
  }

  public void setnId(Integer nId) {
    this.nId = nId;
  }

  public String getnFlt() {
    return nFlt;
  }

  public void setnFlt(String nFlt) {
    this.nFlt = nFlt;
  }

  public LocalDateTime getnStd() {
    return nStd;
  }

  public void setnStd(LocalDateTime nStd) {
    this.nStd = nStd;
  }

  public LocalDateTime getnSta() {
    return nSta;
  }

  public void setnSta(LocalDateTime nSta) {
    this.nSta = nSta;
  }

  public String getnDep() {
    return nDep;
  }

  public void setnDep(String nDep) {
    this.nDep = nDep;
  }

  public String getnArr() {
    return nArr;
  }

  public void setnArr(String nArr) {
    this.nArr = nArr;
  }

  public Integer getTotalHours() {
    return totalHours;
  }

  public void setTotalHours(Integer totalHours) {
    this.totalHours = totalHours;
  }

  public Integer getTotalMin() {
    return totalMin;
  }

  public void setTotalMin(Integer totalMin) {
    this.totalMin = totalMin;
  }

}
