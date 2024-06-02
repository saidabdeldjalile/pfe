/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AGHA Riadh
 */
@Entity
@Table(name = "INSCRIPTION", schema = "AUTH")
public class RefInscription implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE", nullable = false)
  private Integer matricule;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 70)
  @Column(name = "LOGIN", nullable = false, length = 70)
  private String login;
  @Size(max = 255)
  @Column(name = "INSCRIPTION_CODE", length = 255)
  private String inscriptionCode;

  public RefInscription() {
  }

  public RefInscription(Integer matricule) {
    this.matricule = matricule;
  }

  public RefInscription(Integer matricule, String login) {
    this.matricule = matricule;
    this.login = login;
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

  public String getInscriptionCode() {
    return inscriptionCode;
  }

  public void setInscriptionCode(String inscriptionCode) {
    this.inscriptionCode = inscriptionCode;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefInscription)) {
      return false;
    }
    RefInscription other = (RefInscription) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.Inscription[ matricule=" + matricule + " ]";
  }

}
