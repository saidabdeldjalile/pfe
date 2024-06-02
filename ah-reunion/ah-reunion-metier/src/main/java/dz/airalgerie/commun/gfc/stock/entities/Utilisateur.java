/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.utilisateur")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByEmail",
        query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByMotPasse",
        query = "SELECT u FROM Utilisateur u WHERE u.motPasse = :motPasse"),
    @NamedQuery(name = "Utilisateur.findByMatricule",
        query = "SELECT u FROM Utilisateur u WHERE u.matricule = :matricule"),
    @NamedQuery(name = "Utilisateur.findByRoles",
        query = "SELECT u FROM Utilisateur u WHERE u.roles = :roles"),
    @NamedQuery(name = "Utilisateur.findByObservation",
        query = "SELECT u FROM Utilisateur u WHERE u.observation = :observation")})
public class Utilisateur implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "motPasse")
  private String motPasse;
  @Basic(optional = false)
  @NotNull
  @Column(name = "matricule")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "roles")
  private String roles;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  public Utilisateur() {}

  public Utilisateur(String email) {
    this.email = email;
  }

  public Utilisateur(String email, String motPasse, int matricule, String roles) {
    this.email = email;
    this.motPasse = motPasse;
    this.matricule = matricule;
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMotPasse() {
    return motPasse;
  }

  public void setMotPasse(String motPasse) {
    this.motPasse = motPasse;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (email != null ? email.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Utilisateur)) {
      return false;
    }
    Utilisateur other = (Utilisateur) object;
    if ((this.email == null && other.email != null)
        || (this.email != null && !this.email.equals(other.email))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Utilisateur[ email=" + email + " ]";
  }

}
