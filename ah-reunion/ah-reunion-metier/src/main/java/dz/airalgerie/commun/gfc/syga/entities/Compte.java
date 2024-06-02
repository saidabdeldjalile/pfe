
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@Table(name = "compte")
public class Compte implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "No_compte")
  private long no_compte;

  @Column(name = "Libelle")
  private String libelle;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
  private Set<Clientencompte> clientEnComptes;

  public Compte() {}

  public long getNo_compte() {
    return this.no_compte;
  }

  public void setNo_compte(long no_compte) {
    this.no_compte = no_compte;
  }

  public String getLibelle() {
    return this.libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Set<Clientencompte> getClientEnComptes() {
    return clientEnComptes;
  }

  public void setClientEnComptes(Set<Clientencompte> clientEnComptes) {
    this.clientEnComptes = clientEnComptes;
  }

}
