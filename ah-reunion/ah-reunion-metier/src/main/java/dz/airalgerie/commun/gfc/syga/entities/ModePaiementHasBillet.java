
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.*;

/**
 * The persistent class for the mode_paiement_has_billet database table.
 * 
 */
@Entity
@Table(name = "mode_paiement_has_billet")
public class ModePaiementHasBillet implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private ModePaiementHasBilletPK id;

  @Column(name = "Montant")
  private double montant;

  @Column(name = "Num_CC")
  private long numCcc;

  @Column(name = "Num_CCC")
  private String numCc;

  @Transient
  private double montantGlo;

  @Transient
  private double montantHt;

  @Transient
  private long nombre;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  // bi-directional many-to-one association to ModePaiement
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Mode_paiement_Mode_paiement")
  private ModePaiement modePaiement;

  public ModePaiementHasBillet() {}

  public ModePaiementHasBilletPK getId() {
    return this.id;
  }

  public void setId(ModePaiementHasBilletPK id) {
    this.id = id;
  }

  public double getMontant() {
    return this.montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public String getNumCc() {
    return this.numCc;
  }

  public void setNumCc(String numCc) {
    this.numCc = numCc;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public ModePaiement getModePaiement() {
    return this.modePaiement;
  }

  public void setModePaiement(ModePaiement modePaiement) {
    this.modePaiement = modePaiement;
  }

  public double getMontantGlo() {
    return montantGlo;
  }

  public void setMontantGlo(double montantGlo) {
    this.montantGlo = montantGlo;
  }

  public double getMontantHt() {
    return montantHt;
  }

  public void setMontantHt(double montantHt) {
    this.montantHt = montantHt;
  }

  public long getNombre() {
    return nombre;
  }

  public void setNombre(long nombre) {
    this.nombre = nombre;
  }

  /**
   * Impression
   * 
   * @return
   */

  public String getModeP() {
    return this.modePaiement.getModePaiement();
  }

  public int getNCompte() {
    return this.billet.getBonCommande().getClientEnCompte().getNumClient();
  }

  public long getNDocument() {
    return this.billet.getNumBillet();
  }

  public String getObs() {
    return this.getBillet().getNote();
  }

  public long getNumCcc() {
    return numCcc;
  }

  public void setNumCcc(long numCcc) {
    this.numCcc = numCcc;
  }

  public String getMontantGloS() {
    String pattern = "###,###.##";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    return decimalFormat.format(montantGlo);
  }

  public void PK() {
    id = new ModePaiementHasBilletPK();
    id.setBillet_Num_billet(this.billet.getNumBillet());
    id.setMode_paiement_Mode_paiement(this.modePaiement.getModePaiement());

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
    ModePaiementHasBillet other = (ModePaiementHasBillet) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
