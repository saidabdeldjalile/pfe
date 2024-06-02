/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "SIGNALITIQUE")
public class Signalitique implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "NJFILLE")
  private String njfille;
  @Size(max = 50)
  @Column(name = "PRENOMS")
  private String prenoms;
  @Column(name = "SEXE")
  private Character sexe;
  @Column(name = "DATE_NAIS")
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateNais;
  @Size(max = 100)
  @Column(name = "ADRESSE_ALG")
  private String adresse;
  @Column(name = "NUM_SS")
  private String numSS;
  @Size(max = 100)
  @Column(name = "ADRESSE_ETRG")
  private String adresseEtrg;
  @Size(max = 10)
  @Column(name = "CODE_POSTAL")
  private String codePostal;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Signalitique() {}

  public Signalitique(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom.toUpperCase(Locale.FRANCE);
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    if (njfille != null) {
      njfille = njfille.toUpperCase(Locale.FRANCE);
    }
    this.njfille = njfille;
  }

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms.toUpperCase(Locale.FRANCE);
  }

  public Character getSexe() {
    return sexe;
  }

  public void setSexe(Character sexe) {
    this.sexe = sexe;
    this.njfille = null;
  }

  public Date getDateNais() {
    // if (dateNais == null) {
    // dateNais = new Date();
    // }
    return dateNais;
  }

  public void setDateNais(Date dateNais) {
    this.dateNais = dateNais;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getNumSS() {
    return numSS;
  }

  public void setNumSS(String numSS) {
    this.numSS = numSS;
  }

  public String getAdresseEtrg() {
    return adresseEtrg;
  }

  public void setAdresseEtrg(String adresseEtrg) {
    this.adresseEtrg = adresseEtrg;
  }

  public String getCodePostal() {
    if (codePostal == null) {
      codePostal = "";
    }
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    if (codePostal != null && codePostal.isEmpty()) {
      this.codePostal = null;
    } else {
      this.codePostal = codePostal;
    }

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
    if (!(object instanceof Signalitique)) {
      return false;
    }
    Signalitique other = (Signalitique) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Signalitique[ matricule=" + matricule + " ]";
  }

}
