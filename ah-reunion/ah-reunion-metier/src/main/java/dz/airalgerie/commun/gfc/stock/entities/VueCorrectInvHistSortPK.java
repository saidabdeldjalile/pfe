/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class VueCorrectInvHistSortPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn")
  private String pn;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;

  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitement")
  private int dateTraitement;

  public VueCorrectInvHistSortPK() {}

  public VueCorrectInvHistSortPK(String pn, String codeAppareil, int dateTraitement) {
    this.pn = pn;
    this.codeAppareil = codeAppareil;
    this.dateTraitement = dateTraitement;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public int getDateTraitement() {
    return dateTraitement;
  }

  public void setDateTraitement(int dateTraitement) {
    this.dateTraitement = dateTraitement;
  }

}
