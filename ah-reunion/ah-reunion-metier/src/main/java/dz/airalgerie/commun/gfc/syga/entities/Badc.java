
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the badc database table.
 * 
 */
@Entity
@Table(name = "badc")
public class Badc implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_bor")
  private long num_bor;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_app")
  private Date date_app;

  private String expe;

  private int num_bor_u;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "badc", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  private Set<Billet> billets;

  public Badc() {}

  public long getNum_bor() {
    return this.num_bor;
  }

  public void setNum_bor(long num_bor) {
    this.num_bor = num_bor;
  }

  public Date getDate_app() {
    return this.date_app;
  }

  public void setDate_app(Date date_app) {
    this.date_app = date_app;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public String getExpe() {
    return expe;
  }

  public void setExpe(String expe) {
    this.expe = expe;
  }

  public int getNum_bor_u() {
    return num_bor_u;
  }

  public void setNum_bor_u(int num_bor_u) {
    this.num_bor_u = num_bor_u;
  }

}
