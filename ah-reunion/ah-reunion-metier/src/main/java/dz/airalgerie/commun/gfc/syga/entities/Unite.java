
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the unite database table.
 * 
 */
@Entity
@Table(name = "unite")
public class Unite implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_uni")
  private int numUni;

  @Column(name = "Adresse")
  private String adresse;

  @Column(name = "Libelle")
  private String libelle;

  @Column(name = "Tel")
  private int tel;

  // bi-directional many-to-one association to Agence
  @OneToMany(mappedBy = "unite", fetch = FetchType.LAZY)
  private Set<Agence> agences;

  // bi-directional many-to-many association to Clientencompte
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "client_en_compte_has_unite",
      joinColumns = {@JoinColumn(name = "Unite_Num_uni")},
      inverseJoinColumns = {@JoinColumn(name = "Client_en_compte_Num_client")})
  private Set<Clientencompte> clientEnComptes;

  public Unite() {}

  public int getNumUni() {
    return this.numUni;
  }

  public void setNumUni(int numUni) {
    this.numUni = numUni;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getLibelle() {
    return this.libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public int getTel() {
    return this.tel;
  }

  public void setTel(int tel) {
    this.tel = tel;
  }

  public Set<Agence> getAgences() {
    return this.agences;
  }

  public void setAgences(Set<Agence> agences) {
    this.agences = agences;
  }

  public Set<Clientencompte> getClientEnComptes() {
    return this.clientEnComptes;
  }

  public void setClientEnComptes(Set<Clientencompte> clientEnComptes) {
    this.clientEnComptes = clientEnComptes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + numUni;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Unite other = (Unite) obj;
    if (numUni != other.numUni)
      return false;
    return true;
  }

}
