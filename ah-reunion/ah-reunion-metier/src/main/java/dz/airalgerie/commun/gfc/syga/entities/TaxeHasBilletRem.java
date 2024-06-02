
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the taxe_has_billet_rem database table.
 * 
 */
@Entity
@Table(name = "taxe_has_billet_rem")
public class TaxeHasBilletRem implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private TaxeHasBilletRemPK id;

  @Column(name = "Montant")
  private double montant;

  // bi-directional many-to-one association to Billet
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Billet_Num_billet")
  private Billet billet;

  // bi-directional many-to-one association to Monnaie
  // @ManyToOne
  // @JoinColumn(name="Monnaie_Code_monnaie")
  // private Monnaie monnaie;

  // bi-directional many-to-one association to Taxe
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Taxe_Code_taxe")
  private Taxe taxe;

  @Transient
  private double sommeRia;

  @Transient
  private double sommeInt;

  public TaxeHasBilletRem() {}

  public TaxeHasBilletRemPK getId() {
    return this.id;
  }

  public void setId(TaxeHasBilletRemPK id) {
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

  // public Monnaie getMonnaie() {
  // return this.monnaie;
  // }

  // public void setMonnaie(Monnaie monnaie) {
  // this.monnaie = monnaie;
  // }

  public Taxe getTaxe() {
    return this.taxe;
  }

  public void setTaxe(Taxe taxe) {
    this.taxe = taxe;
  }

  public double getSommeRia() {
    return sommeRia;
  }

  public void setSommeRia(double sommeRia) {
    this.sommeRia = sommeRia;
  }

  public double getSommeInt() {
    return sommeInt;
  }

  public void setSommeInt(double sommeInt) {
    this.sommeInt = sommeInt;
  }

  public void PK()

  {
    id = new TaxeHasBilletRemPK();
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
    TaxeHasBilletRem other = (TaxeHasBilletRem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
