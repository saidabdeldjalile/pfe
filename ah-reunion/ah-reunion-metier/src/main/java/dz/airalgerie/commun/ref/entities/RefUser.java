/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.entities;

import dz.airalgerie.commun.model.utils.StringListConverter;
import dz.airalgerie.commun.utils.UserRole;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "USERS", schema = "AUTH")
public class RefUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 70)
  @Column(name = "LOGIN")
  private String login;
  @Size(max = 255)
  @Column(name = "PASSWORD")
  private String motDePasse;
  @Column(name = "FILIALE_AUTORISEE")
  @Convert(converter = StringListConverter.class)
  private Set<String> filialeAutorisee;
  @Column(name = "TECH_AUTORISEE")
  @Convert(converter = StringListConverter.class)
  private Set<String> techAutorisee;
  @Column(name = "DIRECTION_AUTORISEE")
  @Convert(converter = StringListConverter.class)
  private Set<String> directionAutorisee;
  @Column(name = "GROUPE_AUTORISE")
  @Convert(converter = StringListConverter.class)
  private Set<String> groupeAutorise;
  @Column(name = "JOURNAL_AUTORISE")
  @Convert(converter = StringListConverter.class)
  private Set<String> journalAutorise;
  @Column(name = "AGENCE_AUTORISEE")
  @Convert(converter = StringListConverter.class)
  private Set<String> agenceAutorisee;
  @Column(name = "IS_ADMIN")
  @NotNull
  private boolean isAdmin;
  @Column(name = "IS_PASSWORD_RESET")
  @NotNull
  private boolean isPasswordReset;
  @Column(name = "CONFIRMATION_CODE")
  private String confirmationCode;
  @Column(name = "IS_INSCRIPTION_PORTAIL")
  @NotNull
  private boolean isInscriptionPortail;
  @Column(name = "USER_ROLE")
  @Enumerated(EnumType.STRING)
  private UserRole userRole;
  @JoinTable(name = "USERS_GROUPE", schema = "AUTH",
      joinColumns = {@JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE",
          insertable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "ID_GROUPE", referencedColumnName = "ID",
          insertable = false, updatable = false)})
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<RefGroupe> refGroupeSet;

  public RefUser() {
    this.isAdmin = false;
    this.isInscriptionPortail = false;
  }

  public RefUser(Integer matricule) {
    this.matricule = matricule;
    this.isAdmin = false;
    this.isPasswordReset = true;
  }

  public RefUser(Integer matricule, String login) {
    this.matricule = matricule;
    this.login = login;
    this.isAdmin = false;
    this.isPasswordReset = true;
  }

  /**
   * Permet d'initialiser les listes de contraintes.
   */
  public void initConstraints() {
    this.filialeAutorisee = new HashSet<>();
    this.directionAutorisee = new HashSet<>();
    this.groupeAutorise = new HashSet<>();
    this.techAutorisee = new HashSet<>();
    this.agenceAutorisee = new HashSet<>();
    this.journalAutorise = new HashSet<>();
  }

  /**
   * Permet d'ajouter un groupe.
   *
   * @param groupe Groupe à ajouter.
   */
  public void addGroupe(RefGroupe groupe) {
    this.getRefGroupeSet().add(groupe);
    groupe.getRefUserSet().add(this);
  }

  /**
   * Permet de supprimer un groupe.
   *
   * @param groupe Groupe à supprimer.
   */
  public void deleteGroupe(RefGroupe groupe) {
    this.refGroupeSet.remove(groupe);
    groupe.getRefUserSet().remove(this);
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public Set<String> getFilialeAutorisee() {
    return filialeAutorisee;
  }

  public void setFilialeAutorisee(Set<String> filialeAutorisee) {
    this.filialeAutorisee = filialeAutorisee;
  }

  public Set<String> getTechAutorisee() {
    return techAutorisee;
  }

  public void setTechAutorisee(Set<String> techAutorisee) {
    this.techAutorisee = techAutorisee;
  }

  public Set<String> getDirectionAutorisee() {
    return directionAutorisee;
  }

  public void setDirectionAutorisee(Set<String> directionAutorisee) {
    this.directionAutorisee = directionAutorisee;
  }

  public Set<String> getGroupeAutorise() {
    return groupeAutorise;
  }

  public void setGroupeAutorise(Set<String> groupeAutorise) {
    this.groupeAutorise = groupeAutorise;
  }

  public Set<String> getJournalAutorise() {
    return journalAutorise;
  }

  public void setJournalAutorise(Set<String> journalAutorise) {
    this.journalAutorise = journalAutorise;
  }

  public Set<String> getAgenceAutorisee() {
    return agenceAutorisee;
  }

  public void setAgenceAutorisee(Set<String> agenceAutorisee) {
    this.agenceAutorisee = agenceAutorisee;
  }

  public boolean isIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public boolean isIsPasswordReset() {
    return isPasswordReset;
  }

  public void setIsPasswordReset(boolean isPasswordReset) {
    this.isPasswordReset = isPasswordReset;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public Set<RefGroupe> getRefGroupeSet() {
    return refGroupeSet;
  }

  public void setRefGroupeSet(Set<RefGroupe> refGroupeSet) {
    this.refGroupeSet = refGroupeSet;
  }

  public String getConfirmationCode() {
    return confirmationCode;
  }

  public void setConfirmationCode(String confirmationCode) {
    this.confirmationCode = confirmationCode;
  }

  public boolean isIsInscriptionPortail() {
    return isInscriptionPortail;
  }

  public void setIsInscriptionPortail(boolean isInscriptionPortail) {
    this.isInscriptionPortail = isInscriptionPortail;
  }

  @Override
  public String toString() {
    return "RefUser{" + "matricule=" + matricule + ", login=" + login + ", motDePAsse=" + motDePasse
        + ", filialeAutorisee=" + filialeAutorisee + ", techAutorisee=" + techAutorisee
        + ", directionAutorisee=" + directionAutorisee + ", groupeAutorise=" + groupeAutorise
        + ", journalAutorise=" + journalAutorise + ", agenceAutorisee=" + agenceAutorisee
        + ", isAdmin=" + isAdmin + '}';
  }


}
