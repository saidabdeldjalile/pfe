
package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class TauxDeChangeGlobalPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "MONNAIE_ID")
  private long monnaieId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRAITEMENT")
  private int dateTraitement;

  public TauxDeChangeGlobalPK() {}

  public TauxDeChangeGlobalPK(long monnaieId, int dateTraitement) {
    this.monnaieId = monnaieId;
    this.dateTraitement = dateTraitement;
  }

  public long getMonnaieId() {
    return monnaieId;
  }

  public void setMonnaieId(long monnaieId) {
    this.monnaieId = monnaieId;
  }

  public int getDateTraitement() {
    return dateTraitement;
  }

  public void setDateTraitement(int dateTraitement) {
    this.dateTraitement = dateTraitement;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) monnaieId;
    hash += (int) dateTraitement;
    return hash;
  }

  @Override
  public String toString() {
    return "entity.TauxDeChangePK[ monnaieId=" + monnaieId + ", dateTraitement=" + dateTraitement
        + " ]";
  }

}
