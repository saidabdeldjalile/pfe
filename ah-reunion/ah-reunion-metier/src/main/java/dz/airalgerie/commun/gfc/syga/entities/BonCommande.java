
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the bon_commande database table.
 * 
 */
@Entity
@Table(name = "bon_commande")
public class BonCommande implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_bon_cam")
  private long numBonCam;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_elaboration")
  private Date dateElaboration;

  @Column(name = "Num_chap_bu_a")
  private String numChapBu;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "bonCommande", fetch = FetchType.LAZY)
  private Set<Billet> billets;

  private String genere;

  // bi-directional many-to-one association to Clientencompte
  @ManyToOne(fetch = FetchType.LAZY/* ,cascade=CascadeType.MERGE */)
  @JoinColumn(name = "Client_en_compte_Num_client")
  private Clientencompte clientEnCompte;

  public BonCommande() {}

  public long getNumBonCam() {
    return this.numBonCam;
  }

  public void setNumBonCam(long numBonCam) {
    this.numBonCam = numBonCam;
  }

  public Date getDateElaboration() {
    return this.dateElaboration;
  }

  public void setDateElaboration(Date dateElaboration) {
    this.dateElaboration = dateElaboration;
  }

  public String getNumChapBu() {
    return this.numChapBu;
  }

  public void setNumChapBu(String numChapBu) {
    this.numChapBu = numChapBu;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public Clientencompte getClientEnCompte() {
    return this.clientEnCompte;
  }

  public void setClientEnCompte(Clientencompte clientEnCompte) {
    this.clientEnCompte = clientEnCompte;
  }

  public String getGenere() {
    return genere;
  }

  public void setGenere(String genere) {
    this.genere = genere;
  }

}
