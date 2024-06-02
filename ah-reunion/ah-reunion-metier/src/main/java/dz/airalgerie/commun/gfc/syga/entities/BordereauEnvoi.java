
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the bordereauenvoi database table.
 * 
 */
@Entity
@Table(name = "bordereauenvoi")
public class BordereauEnvoi implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_Bor")
  private long num_Bor;

  @Temporal(TemporalType.DATE)
  @Column(name = "Debut")
  private Date debut;

  @Temporal(TemporalType.DATE)
  @Column(name = "Fin")
  private Date fin;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "bordereauEnvoi"/* ,cascade=CascadeType.MERGE */, fetch = FetchType.LAZY)
  private Set<Billet> billets;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  @Transient
  private List<ModePaiementHasBillet> billeti = new ArrayList<ModePaiementHasBillet>();

  @Transient
  private double total;

  public BordereauEnvoi() {}

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

  public List<ModePaiementHasBillet> getBilleti() {
    return billeti;
  }

  public void setBilleti(List<ModePaiementHasBillet> billeti) {
    this.billeti = billeti;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}
