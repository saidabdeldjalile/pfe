/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "FOURNISSEUR", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByCodefour",
        query = "SELECT f FROM Fournisseur f WHERE f.codefour = :codefour"),
    @NamedQuery(name = "Fournisseur.findByNom",
        query = "SELECT f FROM Fournisseur f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fournisseur.findByTele",
        query = "SELECT f FROM Fournisseur f WHERE f.tele = :tele"),
    @NamedQuery(name = "Fournisseur.findByTeleporta",
        query = "SELECT f FROM Fournisseur f WHERE f.teleporta = :teleporta"),
    @NamedQuery(name = "Fournisseur.findByEmail",
        query = "SELECT f FROM Fournisseur f WHERE f.email = :email"),
    @NamedQuery(name = "Fournisseur.findByAdresse",
        query = "SELECT f FROM Fournisseur f WHERE f.adresse = :adresse")})
public class Fournisseur implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "CODEFOUR")
  private String codefour;
  @Size(max = 60)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 45)
  @Column(name = "TELE")
  private String tele;
  @Size(max = 45)
  @Column(name = "TELEPORTA")
  private String teleporta;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Size(max = 100)
  @Column(name = "EMAIL")
  private String email;
  @Size(max = 70)
  @Column(name = "ADRESSE")
  private String adresse;
  @OneToMany(mappedBy = "codefour")
  private Collection<Facture> factureCollection;

  public Fournisseur() {}

  public Fournisseur(String codefour) {
    this.codefour = codefour;
  }

  public String getCodefour() {
    return codefour;
  }

  public void setCodefour(String codefour) {
    this.codefour = codefour;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getTele() {
    return tele;
  }

  public void setTele(String tele) {
    this.tele = tele;
  }

  public String getTeleporta() {
    return teleporta;
  }

  public void setTeleporta(String teleporta) {
    this.teleporta = teleporta;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  @XmlTransient
  public Collection<Facture> getFactureCollection() {
    return factureCollection;
  }

  public void setFactureCollection(Collection<Facture> factureCollection) {
    this.factureCollection = factureCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codefour != null ? codefour.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Fournisseur)) {
      return false;
    }
    Fournisseur other = (Fournisseur) object;
    if ((this.codefour == null && other.codefour != null)
        || (this.codefour != null && !this.codefour.equals(other.codefour))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Fournisseur[ codefour=" + codefour + " ]";
  }

}
