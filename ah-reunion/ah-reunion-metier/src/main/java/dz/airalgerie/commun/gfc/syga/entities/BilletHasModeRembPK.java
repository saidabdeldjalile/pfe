
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the billet_has_mode_remb database table.
 * 
 */
@Embeddable
public class BilletHasModeRembPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "Billet_Num_billet", insertable = false, updatable = false)
  private long billet_Num_billet;

  @Column(name = "Mode_Remb_Mode_remb", insertable = false, updatable = false)
  private String mode_Remb_Mode_remb;

  public BilletHasModeRembPK() {}

  public long getBillet_Num_billet() {
    return this.billet_Num_billet;
  }

  public void setBillet_Num_billet(long billet_Num_billet) {
    this.billet_Num_billet = billet_Num_billet;
  }

  public String getMode_Remb_Mode_remb() {
    return this.mode_Remb_Mode_remb;
  }

  public void setMode_Remb_Mode_remb(String mode_Remb_Mode_remb) {
    this.mode_Remb_Mode_remb = mode_Remb_Mode_remb;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (billet_Num_billet ^ (billet_Num_billet >>> 32));
    result = prime * result + ((mode_Remb_Mode_remb == null) ? 0 : mode_Remb_Mode_remb.hashCode());
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
    BilletHasModeRembPK other = (BilletHasModeRembPK) obj;
    if (billet_Num_billet != other.billet_Num_billet)
      return false;
    if (mode_Remb_Mode_remb == null) {
      if (other.mode_Remb_Mode_remb != null)
        return false;
    } else if (!mode_Remb_Mode_remb.equals(other.mode_Remb_Mode_remb))
      return false;
    return true;
  }

}
