/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "OPERATION_CLOTURE", schema = "CG")
public class OperationCloture implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID_OPERATION")
  private Integer id;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "SENS_OPERATION")
  private String sensOperation;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "TYPE_OPERATION")
  private String typeOperation;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "CPT_MIN")
  private String cptMin;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "CPT_MAX")
  private String cptMax;

  @Size(min = 1, max = 12)
  @Column(name = "CPT_RESULTAT")
  private String cptResultat;

  public OperationCloture() {}

  public OperationCloture(Integer id, String sensOperation, String typeOperation, String cptMin,
      String cptMax, String cptResultat) {
    this.id = id;
    this.sensOperation = sensOperation;
    this.typeOperation = typeOperation;
    this.cptMin = cptMin;
    this.cptMax = cptMax;
    this.cptResultat = cptResultat;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSensOperation() {
    return sensOperation;
  }

  public void setSensOperation(String sensOperation) {
    this.sensOperation = sensOperation;
  }

  public String getTypeOperation() {
    return typeOperation;
  }

  public void setTypeOperation(String typeOperation) {
    this.typeOperation = typeOperation;
  }

  public String getCptMin() {
    return cptMin;
  }

  public void setCptMin(String cptMin) {
    this.cptMin = cptMin;
  }

  public String getCptMax() {
    return cptMax;
  }

  public void setCptMax(String cptMax) {
    this.cptMax = cptMax;
  }

  public String getCptResultat() {
    return cptResultat;
  }

  public void setCptResultat(String cptResultat) {
    this.cptResultat = cptResultat;
  }

  public String getSensOperationLibelle() {
    if (sensOperation.equals("D")) {
      return "Débiter";
    } else {
      return "Créditer";
    }
  }

  public String getTypeOperationLibelle() {
    if (typeOperation.equals("M")) {
      return "Mouvement";
    } else {
      return "Solde";
    }
  }
}
