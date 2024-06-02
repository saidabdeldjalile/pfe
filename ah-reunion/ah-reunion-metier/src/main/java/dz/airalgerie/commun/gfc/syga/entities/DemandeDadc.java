
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the demande_dadc database table.
 * 
 */
@Entity
@Table(name = "demande_dadc")
public class DemandeDadc implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_dem")
  private long num_dem;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_demande")
  private Date date_demande;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  // bi-directional many-to-one association to DocumentHasDemandeDadc
  @OneToMany(mappedBy = "demandeDadc", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  private Set<DocumentHasDemandeDadc> documentHasDemandeDadcs;

  public DemandeDadc() {}

  public long getNum_dem() {
    return this.num_dem;
  }

  public void setNum_dem(long num_dem) {
    this.num_dem = num_dem;
  }

  public Date getDate_demande() {
    return this.date_demande;
  }

  public void setDate_demande(Date date_demande) {
    this.date_demande = date_demande;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Set<DocumentHasDemandeDadc> getDocumentHasDemandeDadcs() {
    return this.documentHasDemandeDadcs;
  }

  public void setDocumentHasDemandeDadcs(Set<DocumentHasDemandeDadc> documentHasDemandeDadcs) {
    this.documentHasDemandeDadcs = documentHasDemandeDadcs;
  }

}
