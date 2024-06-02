/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "CHOIX_AVC_CORPS")
public class ChoixAvcCorps implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ChoixAvcCorpsPK choixAvcCorpsPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR")
  private int valeur;
  @JoinColumn(name = "CODE_CORPS", referencedColumnName = "CODE_CORPS", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Corps corps;
  @JoinColumn(name = "CHOIX_AVC", referencedColumnName = "CHOIX_AVC", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private ChoixAvancement choixAvancement;

  public ChoixAvcCorps() {}

  public ChoixAvcCorps(ChoixAvcCorpsPK choixAvcCorpsPK) {
    this.choixAvcCorpsPK = choixAvcCorpsPK;
  }

  public ChoixAvcCorps(ChoixAvcCorpsPK choixAvcCorpsPK, int valeur) {
    this.choixAvcCorpsPK = choixAvcCorpsPK;
    this.valeur = valeur;
  }

  public ChoixAvcCorps(Character choixAvc, Character codeCorps) {
    this.choixAvcCorpsPK = new ChoixAvcCorpsPK(choixAvc, codeCorps);
  }

  public ChoixAvcCorpsPK getChoixAvcCorpsPK() {
    return choixAvcCorpsPK;
  }

  public void setChoixAvcCorpsPK(ChoixAvcCorpsPK choixAvcCorpsPK) {
    this.choixAvcCorpsPK = choixAvcCorpsPK;
  }

  public int getValeur() {
    return valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }

  public Corps getCorps() {
    return corps;
  }

  public void setCorps(Corps corps) {
    this.corps = corps;
  }

  public ChoixAvancement getChoixAvancement() {
    return choixAvancement;
  }

  public void setChoixAvancement(ChoixAvancement choixAvancement) {
    this.choixAvancement = choixAvancement;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (choixAvcCorpsPK != null ? choixAvcCorpsPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ChoixAvcCorps)) {
      return false;
    }
    ChoixAvcCorps other = (ChoixAvcCorps) object;
    if ((this.choixAvcCorpsPK == null && other.choixAvcCorpsPK != null)
        || (this.choixAvcCorpsPK != null && !this.choixAvcCorpsPK.equals(other.choixAvcCorpsPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ChoixAvcCorps[ choixAvcCorpsPK=" + choixAvcCorpsPK + " ]";
  }

}
