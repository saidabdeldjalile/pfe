/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nabila
 */
@Embeddable
public class RubSpecifiquePK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer DATE_TRT;

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getDATE_TRT() {
    return DATE_TRT;
  }

  public void setDATE_TRT(Integer DATE_TRT) {
    this.DATE_TRT = DATE_TRT;
  }

  public RubSpecifiquePK() {}

  public RubSpecifiquePK(Integer matricule, Integer DATE_TRT) {
    this.matricule = matricule;
    this.DATE_TRT = DATE_TRT;
  }

  @Override
  public String toString() {
    return "RubSpecifiquePK{" + "matricule=" + matricule + ", DATE_TRT=" + DATE_TRT + '}';
  }

}
