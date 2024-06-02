
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the modeRemb database table.
 * 
 */
@Entity
@Table(name = "mode_remb")
public class ModeRemb implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Mode_remb")
  private String modeRemb;

  // bi-directional many-to-one association to BilletHasModeRemb
  @OneToMany(mappedBy = "modeRemb", fetch = FetchType.LAZY)
  private Set<BilletHasModeRemb> billetHasModeRembs;

  public ModeRemb() {}

  public String getModeRemb() {
    return this.modeRemb;
  }

  public void setModeRemb(String modeRemb) {
    this.modeRemb = modeRemb;
  }

  public Set<BilletHasModeRemb> getBilletHasModeRembs() {
    return this.billetHasModeRembs;
  }

  public void setBilletHasModeRembs(Set<BilletHasModeRemb> billetHasModeRembs) {
    this.billetHasModeRembs = billetHasModeRembs;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((modeRemb == null) ? 0 : modeRemb.hashCode());
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
    ModeRemb other = (ModeRemb) obj;
    if (modeRemb == null) {
      if (other.modeRemb != null)
        return false;
    } else if (!modeRemb.equals(other.modeRemb))
      return false;
    return true;
  }

}
