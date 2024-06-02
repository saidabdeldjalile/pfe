
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the billet_has_mode_remb database table.
 * 
 */
@Entity
@Table(name = "billet_has_mode_remb")
public class BilletHasModeRemb implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private BilletHasModeRembPK id;

  @Column(name = "Montant")
  private double montant;

  @Column(name = "Num_CCC")
  private String numCc;

  @Column(name = "Num_CC")
  private long numCCc;

  @Transient
  private String remarq;

  @Transient
  private BilletRemb billetRemb;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  // bi-directional many-to-one association to ModeRemb
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Mode_Remb_Mode_remb")
  private ModeRemb modeRemb;

  public BilletHasModeRemb() {}

  public BilletHasModeRembPK getId() {
    return this.id;
  }

  public void setId(BilletHasModeRembPK id) {
    this.id = id;
  }

  public double getMontant() {
    return this.montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public ModeRemb getModeRemb() {
    return this.modeRemb;
  }

  public void setModeRemb(ModeRemb modeRemb) {
    this.modeRemb = modeRemb;
  }

  public String getNumCc() {
    return numCc;
  }

  public void setNumCc(String numCc) {
    this.numCc = numCc;
  }

  public BilletRemb getBilletRemb() {
    return billetRemb;
  }

  public void setBilletRemb(BilletRemb billetRemb) {
    this.billetRemb = billetRemb;
  }

  /**
   * Impression
   * 
   * @return
   */

  public String getModeP() {
    return this.modeRemb.getModeRemb();
  }

  public int getNCompte() {
    return this.billet.getBonCommande().getClientEnCompte().getNumClient();
  }

  public long getNDocument() {
    return this.billet.getNumBillet();
  }

  public String getObs() {

    if (this.getRemarq() == null)
      return "";
    else
      return this.getRemarq();
  }

  public String getRemarq() {
    return remarq;
  }

  public void setRemarq(String remarq) {
    this.remarq = remarq;
  }

  public long getNumCCc() {
    return numCCc;
  }

  public void setNumCCc(long numCCc) {
    this.numCCc = numCCc;
  }

  public void PK() {
    id = new BilletHasModeRembPK();
    id.setBillet_Num_billet(this.billet.getNumBillet());
    id.setMode_Remb_Mode_remb(this.modeRemb.getModeRemb());

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    BilletHasModeRemb other = (BilletHasModeRemb) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
