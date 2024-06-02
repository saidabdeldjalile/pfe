
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the bodoan database table.
 * 
 */
@Entity
@Table(name = "bodoan")
public class Bodoan implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_Bor")
  private long num_Bor;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date")
  private Date date;

  @Transient
  private List<Atb> atbs = new ArrayList<Atb>();

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "bodoan", fetch = FetchType.LAZY)
  private Set<Billet> billets;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public Bodoan() {}

  public long getNum_Bor() {
    return this.num_Bor;
  }

  public void setNum_Bor(long num_Bor) {
    this.num_Bor = num_Bor;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
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

  public List<Atb> getAtbs() {
    return atbs;
  }

  public void setAtbs(List<Atb> atbs) {
    this.atbs = atbs;
  }

}
