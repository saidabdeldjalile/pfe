/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

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
 * @author kemikem
 */
@Entity
@Table(name = "FABRICANT", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Fabricant.findAll", query = "SELECT f FROM Fabricant f"),
    @NamedQuery(name = "Fabricant.findByCodefab",
        query = "SELECT f FROM Fabricant f WHERE f.codefab = :codefab"),
    @NamedQuery(name = "Fabricant.findByNom",
        query = "SELECT f FROM Fabricant f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fabricant.findByTele",
        query = "SELECT f FROM Fabricant f WHERE f.tele = :tele"),
    @NamedQuery(name = "Fabricant.findByTeleportable",
        query = "SELECT f FROM Fabricant f WHERE f.teleportable = :teleportable"),
    @NamedQuery(name = "Fabricant.findByEmail",
        query = "SELECT f FROM Fabricant f WHERE f.email = :email"),
    @NamedQuery(name = "Fabricant.findByAdresse",
        query = "SELECT f FROM Fabricant f WHERE f.adresse = :adresse")})
public class Fabricant implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "CODEFAB")
  private String codefab;
  @Size(max = 60)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 45)
  @Column(name = "TELE")
  private String tele;
  @Size(max = 45)
  @Column(name = "TELEPORTABLE")
  private String teleportable;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Size(max = 100)
  @Column(name = "EMAIL")
  private String email;
  @Size(max = 70)
  @Column(name = "ADRESSE")
  private String adresse;

  public Fabricant() {}

  public Fabricant(String codefab) {
    this.codefab = codefab;
  }

  public String getCodefab() {
    return codefab;
  }

  public void setCodefab(String codefab) {
    this.codefab = codefab;
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

  public String getTeleportable() {
    return teleportable;
  }

  public void setTeleportable(String teleportable) {
    this.teleportable = teleportable;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codefab != null ? codefab.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Fabricant)) {
      return false;
    }
    Fabricant other = (Fabricant) object;
    if ((this.codefab == null && other.codefab != null)
        || (this.codefab != null && !this.codefab.equals(other.codefab))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Fabricant[ codefab=" + codefab + " ]";
  }

}
