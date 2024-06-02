
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the billet_has_taxe database table.
 * 
 */
@Entity
@Table(name = "billet_has_taxe")
public class BilletHasTaxe implements Serializable {
  private static final long serialVersionUID = 1L;

  // @EJB

  // private Generer_billetLocal generer_billetLocal;

  @EmbeddedId
  private BilletHasTaxePK id;

  @Column(name = "Montant")
  private double montant;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Taxe_Code_taxe")
  private Taxe taxe;

  @Transient
  private double sommeRia;

  @Transient
  private double sommeInt;

  @Transient
  private String sommeRiaF;

  @Transient
  private String sommeIntF;

  public BilletHasTaxe() {}

  public BilletHasTaxePK getId() {
    return this.id;
  }

  public void setId(BilletHasTaxePK id) {
    this.id = id;
  }

  public double getMontant() {
    return this.montant;
  }

  public void setMontant(double montant) {

    // this.montant = (float) (Math.round(montant*100.0)/100.0);
    this.montant = montant;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Taxe getTaxe() {
    return this.taxe;
  }

  public void setTaxe(Taxe taxe) {
    this.taxe = taxe;
  }

  public double getSommeRia() {
    return sommeRia;
  }

  public void setSommeRia(double somme) {
    this.sommeRia = somme;
  }

  public double getSommeInt() {
    return sommeInt;
  }

  public void setSommeInt(double sommeInt) {
    this.sommeInt = sommeInt;
  }

  public String getSommeRiaF() {
    return sommeRiaF;
  }

  public void setSommeRiaF(String sommeRiaF) {
    this.sommeRiaF = sommeRiaF;
  }

  public String getSommeIntF() {
    return sommeIntF;
  }

  public void setSommeIntF(String sommeIntF) {
    this.sommeIntF = sommeIntF;
  }

  public void PK() {
    id = new BilletHasTaxePK();
    id.setBillet_Num_billet(this.billet.getNumBillet());
    // id.setMonnaie_Code_monnaie(this.monnaie.getCode_monnaie());
    id.setTaxe_Code_taxe(this.taxe.getCodeTaxe());

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
    BilletHasTaxe other = (BilletHasTaxe) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
