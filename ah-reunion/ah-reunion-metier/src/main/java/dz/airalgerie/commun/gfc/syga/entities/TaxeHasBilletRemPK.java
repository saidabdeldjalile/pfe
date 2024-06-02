
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the taxe_has_billet_rem database table.
 * 
 */
@Embeddable
public class TaxeHasBilletRemPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "Taxe_Code_taxe", insertable = false, updatable = false)
  private String taxe_Code_taxe;

  @Column(name = "Billet_Num_billet", insertable = false, updatable = false)
  private long billet_Num_billet;

  // @Column(name="Monnaie_Code_monnaie",insertable=false,updatable=false)
  // private String monnaie_Code_monnaie;

  public TaxeHasBilletRemPK() {}

  public String getTaxe_Code_taxe() {
    return this.taxe_Code_taxe;
  }

  public void setTaxe_Code_taxe(String taxe_Code_taxe) {
    this.taxe_Code_taxe = taxe_Code_taxe;
  }

  public long getBillet_Num_billet() {
    return this.billet_Num_billet;
  }

  public void setBillet_Num_billet(long billet_Num_billet) {
    this.billet_Num_billet = billet_Num_billet;
  }

  /*
   * public String getMonnaie_Code_monnaie() { return this.monnaie_Code_monnaie; } public void
   * setMonnaie_Code_monnaie(String monnaie_Code_monnaie) { this.monnaie_Code_monnaie =
   * monnaie_Code_monnaie; }
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (billet_Num_billet ^ (billet_Num_billet >>> 32));
    result = prime * result + ((taxe_Code_taxe == null) ? 0 : taxe_Code_taxe.hashCode());
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
    TaxeHasBilletRemPK other = (TaxeHasBilletRemPK) obj;
    if (billet_Num_billet != other.billet_Num_billet)
      return false;
    if (taxe_Code_taxe == null) {
      if (other.taxe_Code_taxe != null)
        return false;
    } else if (!taxe_Code_taxe.equals(other.taxe_Code_taxe))
      return false;
    return true;
  }

}
