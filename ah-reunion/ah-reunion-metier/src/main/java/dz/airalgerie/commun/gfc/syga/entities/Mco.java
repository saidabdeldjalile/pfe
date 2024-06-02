
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the mco database table.
 * 
 */
@Entity
@Table(name = "mco")
public class Mco implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billetNumBillet;

  @Column(name = "Motif_mco")
  private String motifMco;

  @Column(name = "Reseau")
  private String reseau;

  @Column(name = "code_agent")
  private String codeAgent;

  @Column(name = "Remar")
  private String remar;

  @Column(name = "Nom")
  private String nom;

  @Column(name = "Prenom")
  private String prenom;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  // bi-directional many-to-one association to Eticket
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "E_TICKET_Billet_Num_billet")
  private Eticket eticket;

  // bi-directional many-to-one association to Pax
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PAX_Billet_Num_billet")
  private Pax pax;

  public Mco() {}

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public String getMotifMco() {
    return this.motifMco;
  }

  public void setMotifMco(String motifMco) {
    this.motifMco = motifMco;
  }

  public String getReseau() {
    return this.reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Eticket getEticket() {
    return this.eticket;
  }

  public void setEticket(Eticket eticket) {
    this.eticket = eticket;
  }

  public Pax getPax() {
    return this.pax;
  }

  public void setPax(Pax pax) {
    this.pax = pax;
  }

  public String getCodeAgent() {
    return codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
  }

  public String getRemar() {
    return remar;
  }

  public void setRemar(String remar) {
    this.remar = remar;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

}
