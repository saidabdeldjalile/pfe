/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "CLOTURE_ECOFIE", schema = "CF")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ClotureEcofie.findAll", query = "SELECT c FROM ClotureEcofie c"),
    @NamedQuery(name = "ClotureEcofie.findByAnneeTrt",
        query = "SELECT c FROM ClotureEcofie c WHERE c.clotureEcofiePK.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "ClotureEcofie.findByTrimestreTrt",
        query = "SELECT c FROM ClotureEcofie c WHERE c.clotureEcofiePK.trimestreTrt = :trimestreTrt")})
public class ClotureEcofie implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ClotureEcofiePK clotureEcofiePK;

  public ClotureEcofie() {
  }

  public ClotureEcofie(ClotureEcofiePK clotureEcofiePK) {
    this.clotureEcofiePK = clotureEcofiePK;
  }

  public ClotureEcofie(int anneeTrt, int trimesterTrt) {
    this.clotureEcofiePK = new ClotureEcofiePK(anneeTrt, trimesterTrt);
  }

  public ClotureEcofiePK getClotureEcofiePK() {
    return clotureEcofiePK;
  }

  public void setClotureEcofiePK(ClotureEcofiePK clotureEcofiePK) {
    this.clotureEcofiePK = clotureEcofiePK;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (clotureEcofiePK != null ? clotureEcofiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClotureEcofie)) {
      return false;
    }
    ClotureEcofie other = (ClotureEcofie) object;
    if ((this.clotureEcofiePK == null && other.clotureEcofiePK != null)
        || (this.clotureEcofiePK != null && !this.clotureEcofiePK.equals(other.clotureEcofiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.ecofie.ClotureEcofie[ clotureEcofiePK="
        + clotureEcofiePK + " ]";
  }

}
