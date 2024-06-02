
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the mode_paiement_has_billet database table.
 * 
 */
@Embeddable
public class ModePaiementHasBilletPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "Mode_paiement_Mode_paiement", insertable = false, updatable = false)
  private String mode_paiement_Mode_paiement;

  @Column(name = "Billet_Num_billet", insertable = false, updatable = false)
  private long billet_Num_billet;

  public ModePaiementHasBilletPK() {}

  public String getMode_paiement_Mode_paiement() {
    return this.mode_paiement_Mode_paiement;
  }

  public void setMode_paiement_Mode_paiement(String mode_paiement_Mode_paiement) {
    this.mode_paiement_Mode_paiement = mode_paiement_Mode_paiement;
  }

  public long getBillet_Num_billet() {
    return this.billet_Num_billet;
  }

  public void setBillet_Num_billet(long billet_Num_billet) {
    this.billet_Num_billet = billet_Num_billet;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (billet_Num_billet ^ (billet_Num_billet >>> 32));
    result = prime * result
        + ((mode_paiement_Mode_paiement == null) ? 0 : mode_paiement_Mode_paiement.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ModePaiementHasBilletPK other = (ModePaiementHasBilletPK) obj;
    if (billet_Num_billet != other.billet_Num_billet)
      return false;
    if (mode_paiement_Mode_paiement == null) {
      if (other.mode_paiement_Mode_paiement != null)
        return false;
    } else if (!mode_paiement_Mode_paiement.equals(other.mode_paiement_Mode_paiement))
      return false;
    return true;
  }

}
