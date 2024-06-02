
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the monnaie database table.
 * 
 */
@Entity
public class Monnaie implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Code_monnaie")
  private String codeMonnaie;

  private String monnaie;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "monnaie", fetch = FetchType.LAZY)
  private List<Billet> billets;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "monnaie", fetch = FetchType.LAZY)
  private List<BilletRemb> billetRembs;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "monnaie", fetch = FetchType.LAZY)
  // @Transient
  private List<Coupon> coupons;

  // bi-directional many-to-many association to Agence
  @ManyToMany(mappedBy = "monnaies", fetch = FetchType.LAZY)

  private List<Agence> agences;

  public Monnaie() {}

  public String getCodeMonnaie() {
    return this.codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public String getMonnaie() {
    return this.monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public List<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(List<Billet> billets) {
    this.billets = billets;
  }

  public Billet addBillet(Billet billet) {
    getBillets().add(billet);
    billet.setMonnaie(this);

    return billet;
  }

  public Billet removeBillet(Billet billet) {
    getBillets().remove(billet);
    billet.setMonnaie(null);

    return billet;
  }

  public List<Agence> getAgences() {
    return this.agences;
  }

  public void setAgences(List<Agence> agences) {
    this.agences = agences;
  }

  public List<BilletRemb> getBilletRembs() {
    return billetRembs;
  }

  public void setBilletRembs(List<BilletRemb> billetRembs) {
    this.billetRembs = billetRembs;
  }

  public List<Coupon> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<Coupon> Coupons) {
    this.coupons = Coupons;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codeMonnaie == null) ? 0 : codeMonnaie.hashCode());
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
    Monnaie other = (Monnaie) obj;
    if (codeMonnaie == null) {
      if (other.codeMonnaie != null)
        return false;
    } else if (!codeMonnaie.equals(other.codeMonnaie))
      return false;
    return true;
  }

}
