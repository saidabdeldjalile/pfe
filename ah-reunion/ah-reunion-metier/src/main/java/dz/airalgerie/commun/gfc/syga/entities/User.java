
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Nom_user")
  private String nom_user;

  @Column(name = "matricule_user")
  private int matriculeUser;

  @Column(name = "Password_user")
  private String password_user;

  @Column(name = "connect")
  private String connect;

  @Transient
  private String IP;

  // bi-directional many-to-many association to Role
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "roles_has_users", joinColumns = {@JoinColumn(name = "Nom_user")},
      inverseJoinColumns = {@JoinColumn(name = "Roles_Role")})

  @OrderBy("role desc")
  private Set<Role> roles;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  @Transient
  private Role role1;

  @Transient
  private boolean role2;

  @Transient
  private String all_roles;

  public User() {

  }

  public String getNom_user() {
    return this.nom_user;
  }

  public void setNom_user(String nom_user) {
    this.nom_user = nom_user;
  }

  public int getMatriculeUser() {
    return this.matriculeUser;
  }

  public void setMatriculeUser(int matriculeUser) {
    this.matriculeUser = matriculeUser;
  }

  public String getPassword_user() {
    return this.password_user;
  }

  public void setPassword_user(String password_user) {
    this.password_user = password_user;
  }

  public Set<Role> getRoles() {
    return this.roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public String getConnect() {
    return connect;
  }

  public void setConnect(String connect) {
    this.connect = connect;
  }

  public String getIP() {
    return IP;
  }

  public void setIP(String iP) {
    IP = iP;
  }

  public Role getRole1() {
    return role1;
  }

  public void setRole1(Role role1) {
    this.role1 = role1;
  }

  public boolean isRole2() {
    return role2;
  }

  public void setRole2(boolean role2) {
    this.role2 = role2;
  }

  public String getAll_roles() {
    return all_roles;
  }

  public void setAll_roles(String all_roles) {
    this.all_roles = all_roles;
  }

}
