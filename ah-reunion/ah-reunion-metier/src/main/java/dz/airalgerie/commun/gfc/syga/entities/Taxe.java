
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the taxe database table.
 * 
 */
@Entity
@Table(name = "taxe")
public class Taxe implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Code_taxe")
  private String codeTaxe;

  // bi-directional many-to-one association to BilletHasTaxe
  @OneToMany(mappedBy = "taxe", fetch = FetchType.LAZY)
  private Set<BilletHasTaxe> billetHasTaxes;

  // bi-directional many-to-one association to TaxeHasBilletRem
  @OneToMany(mappedBy = "taxe", fetch = FetchType.LAZY)
  private Set<TaxeHasBilletRem> taxeHasBilletRems;

  public Taxe() {}

  public String getCodeTaxe() {
    try {
      return this.codeTaxe.replaceAll(" ", "");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return this.codeTaxe;
    }
  }

  public void setCodeTaxe(String codeTaxe) {
    this.codeTaxe = codeTaxe;
  }

  public Set<BilletHasTaxe> getBilletHasTaxes() {
    return this.billetHasTaxes;
  }

  public void setBilletHasTaxes(Set<BilletHasTaxe> billetHasTaxes) {
    this.billetHasTaxes = billetHasTaxes;
  }

  public Set<TaxeHasBilletRem> getTaxeHasBilletRems() {
    return this.taxeHasBilletRems;
  }

  public void setTaxeHasBilletRems(Set<TaxeHasBilletRem> taxeHasBilletRems) {
    this.taxeHasBilletRems = taxeHasBilletRems;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codeTaxe == null) ? 0 : codeTaxe.hashCode());
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
    Taxe other = (Taxe) obj;
    if (codeTaxe == null) {
      if (other.codeTaxe != null)
        return false;
    } else if (!codeTaxe.equals(other.codeTaxe))
      return false;
    return true;
  }

}
