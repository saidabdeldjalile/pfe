/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "GRILLE")
public class Grille implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GrillePK grillePk;
  @Column(name = "ECHELLE")
  private Double echelle;
  @Column(name = "INDICE")
  private Integer indice;
  @Column(name = "SALAIRE_BASE")
  private Double salBase;

  public Grille() {}

  public GrillePK getGrillePk() {
    return grillePk;
  }

  public void setGrillePk(GrillePK grillePk) {
    this.grillePk = grillePk;
  }

  public Double getEchelle() {
    return echelle;
  }

  public void setEchelle(Double echelle) {
    this.echelle = echelle;
  }

  public Integer getIndice() {
    return indice;
  }

  public void setIndice(Integer indice) {
    this.indice = indice;
  }

  public Double getSalBase() {
    return salBase;
  }

  public void setSalBase(Double salBase) {
    this.salBase = salBase;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (grillePk != null ? grillePk.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Grille)) {
      return false;
    }
    Grille other = (Grille) object;
    if ((this.grillePk == null && other.grillePk != null)
        || (this.grillePk != null && !this.grillePk.equals(other.grillePk))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Grille{" + grillePk + ", echelle=" + echelle + ", indice=" + indice + ", salBase="
        + salBase + '}';
  }

}
