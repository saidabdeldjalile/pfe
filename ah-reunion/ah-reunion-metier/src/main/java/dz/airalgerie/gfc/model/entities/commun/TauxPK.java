/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Embeddable
public class TauxPK implements Serializable, Cloneable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRAITEMENT", insertable = false, nullable = false)
  // @Temporal(TemporalType.DATE)
  private int dateTraitement;
  @Column(name = "MONNAIE_ID", insertable = false, nullable = false)
  @Basic(optional = false)
  @NotNull
  private Integer monnaieId;

  public int getDateTraitement() {
    return dateTraitement;
  }

  public void setDateTraitement(int dateTraitement) {
    this.dateTraitement = dateTraitement;
  }

  public Integer getMonnaieId() {
    return monnaieId;
  }

  public void setMonnaieId(Integer monnaieId) {
    this.monnaieId = monnaieId;
  }

  public TauxPK() {}

}
