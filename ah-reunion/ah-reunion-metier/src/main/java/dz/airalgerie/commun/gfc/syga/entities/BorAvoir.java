
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the boravoir database table.
 * 
 */
@Entity
@Table(name = "boravoir")
public class BorAvoir implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_Bor")
  private long num_Bor;

  @Temporal(TemporalType.DATE)
  private Date debut;

  @Temporal(TemporalType.DATE)
  private Date fin;

  @Transient
  private List<BilletHasModeRemb> billeti = new ArrayList<BilletHasModeRemb>();

  @Transient
  private double total;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "borAvoir", /* cascade=CascadeType.MERGE, */fetch = FetchType.LAZY)
  private Set<Billet> billets;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public BorAvoir() {}

  public long getNum_Bor() {
    return this.num_Bor;
  }

  public void setNum_Bor(long num_Bor) {
    this.num_Bor = num_Bor;
  }

  public Date getDebut() {
    return this.debut;
  }

  public void setDebut(Date debut) {
    this.debut = debut;
  }

  public Date getFin() {
    return this.fin;
  }

  public void setFin(Date fin) {
    this.fin = fin;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public List<BilletHasModeRemb> getBilleti() {
    return billeti;
  }

  public void setBilleti(List<BilletHasModeRemb> billeti) {
    this.billeti = billeti;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}
