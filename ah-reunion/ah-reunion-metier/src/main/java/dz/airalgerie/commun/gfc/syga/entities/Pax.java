
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the pax database table.
 * 
 */
@Entity
@Table(name = "pax")
public class Pax implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billetNumBillet;

  @Column(name = "Bas_tari")
  private String bas_tari;

  @Column(name = "code_agent")
  private String codeAgent;

  @Column(name = "Gratuit_serv")
  private String gratuitServ;

  @Column(name = "Nom")
  private String nom;

  @Column(name = "Prenom")
  private String prenom;

  @Column(name = "Rem")
  private String remar;

  @Column(name = "Reseau")
  private String reseau;

  @Column(name = "Ven_Rem")
  private String venRem;

  // bi-directional many-to-one association to Bcb
  @OneToMany(mappedBy = "pax", fetch = FetchType.LAZY)
  private Set<Bcb> bcbs;

  // bi-directional many-to-one association to Mco
  @OneToMany(mappedBy = "pax", fetch = FetchType.LAZY)
  private Set<Mco> mcos;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  public Pax() {}

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public String getBas_tari() {
    return this.bas_tari;
  }

  public void setBas_tari(String bas_tari) {
    this.bas_tari = bas_tari;
  }

  public String getCodeAgent() {
    return this.codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
  }

  public String getGratuitServ() {
    return this.gratuitServ;
  }

  public void setGratuitServ(String gratuitServ) {
    this.gratuitServ = gratuitServ;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getRemar() {
    return this.remar;
  }

  public void setRemar(String rem) {
    this.remar = rem;
  }

  public String getReseau() {
    return this.reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getVenRem() {
    return this.venRem;
  }

  public void setVenRem(String venRem) {
    this.venRem = venRem;
  }

  public Set<Bcb> getBcbs() {
    return this.bcbs;
  }

  public void setBcbs(Set<Bcb> bcbs) {
    this.bcbs = bcbs;
  }

  public Set<Mco> getMcos() {
    return this.mcos;
  }

  public void setMcos(Set<Mco> mcos) {
    this.mcos = mcos;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

}
