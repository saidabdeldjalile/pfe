
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the emd database table.
 * 
 */
@Entity
@Table(name = "emd")
public class Emd implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billetNumBillet;

  @Column(name = "Code_Agent")
  private String codeAgent;

  @Column(name = "Nom")
  private String nom;

  @Column(name = "Prenom")
  private String prenom;

  @Column(name = "Raison_Uti")
  private String raisonUti;

  @Column(name = "Reseau")
  private String reseau;

  @Column(name = "SERVICE")
  private String service;

  // @Transient
  @Column(name = "PNR")
  private String pnr;

  // @Transient
  @Column(name = "Remarque")
  private String remar;

  @Column(name = "Poids")
  private long poids;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  public Emd() {}

  public long getBilletNumBillet() {
    return this.billetNumBillet;
  }

  public void setBilletNumBillet(long billetNumBillet) {
    this.billetNumBillet = billetNumBillet;
  }

  public String getCodeAgent() {
    return codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
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

  public String getRaisonUti() {
    return this.raisonUti;
  }

  public void setRaisonUti(String raisonUti) {
    this.raisonUti = raisonUti;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public String getService() {
    return service;
  }

  public void setService(String sERVICE) {
    service = sERVICE;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pNR) {
    pnr = pNR;
  }

  public String getRemar() {
    return remar;
  }

  public void setRemar(String remarque) {
    remar = remarque;
  }

  public long getPoids() {
    return poids;
  }

  public void setPoids(long poids) {
    this.poids = poids;
  }

}
