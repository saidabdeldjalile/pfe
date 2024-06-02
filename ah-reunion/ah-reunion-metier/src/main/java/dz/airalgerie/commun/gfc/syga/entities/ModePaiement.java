
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the modePaiement database table.
 * 
 */
@Entity
@Table(name = "mode_paiement")
public class ModePaiement implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Mode_paiement")
  private String modePaiement;

  @Column(name = "Libelle")
  private String libelle;

  // bi-directional many-to-one association to ModePaiementHasBillet
  @OneToMany(mappedBy = "modePaiement", fetch = FetchType.LAZY)
  private Set<ModePaiementHasBillet> modePaiementHasBillets;

  // bi-directional many-to-one association to BilletRemb
  @OneToMany(mappedBy = "modePaiement", fetch = FetchType.LAZY)
  private Set<BilletRemb> billetRembs;

  public ModePaiement() {}

  public String getModePaiement() {
    return this.modePaiement;
  }

  public void setModePaiement(String modePaiement) {
    this.modePaiement = modePaiement;
  }

  public String getLibelle() {
    return this.libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Set<ModePaiementHasBillet> getModePaiementHasBillets() {
    return this.modePaiementHasBillets;
  }

  public void setModePaiementHasBillets(Set<ModePaiementHasBillet> modePaiementHasBillets) {
    this.modePaiementHasBillets = modePaiementHasBillets;
  }

  public Set<BilletRemb> getBilletRembs() {
    return billetRembs;
  }

  public void setBilletRembs(Set<BilletRemb> billetRembs) {
    this.billetRembs = billetRembs;
  }

}
