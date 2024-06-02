/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

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
 * @author user
 */
@Entity
@Table(name = "STK.fabricant")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Fabricant.findAll", query = "SELECT f FROM Fabricant f"),
    @NamedQuery(name = "Fabricant.findByCodeFabricant",
        query = "SELECT f FROM Fabricant f WHERE f.codeFabricant = :codeFabricant"),
    @NamedQuery(name = "Fabricant.findByNom",
        query = "SELECT f FROM Fabricant f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fabricant.findByTelephone",
        query = "SELECT f FROM Fabricant f WHERE f.telephone = :telephone"),
    @NamedQuery(name = "Fabricant.findByFax",
        query = "SELECT f FROM Fabricant f WHERE f.fax = :fax"),
    @NamedQuery(name = "Fabricant.findByTelPortable",
        query = "SELECT f FROM Fabricant f WHERE f.telPortable = :telPortable"),
    @NamedQuery(name = "Fabricant.findByEmail",
        query = "SELECT f FROM Fabricant f WHERE f.email = :email"),
    @NamedQuery(name = "Fabricant.findByAdresse1",
        query = "SELECT f FROM Fabricant f WHERE f.adresse1 = :adresse1"),
    @NamedQuery(name = "Fabricant.findByAdresse2",
        query = "SELECT f FROM Fabricant f WHERE f.adresse2 = :adresse2")})
public class Fabricant implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeFabricant")
  private String codeFabricant;
  @Size(max = 60)
  @Column(name = "nom")
  private String nom;
  @Size(max = 30)
  @Column(name = "telephone")
  private String telephone;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax
  // format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using
  // this annotation to enforce field validation
  @Size(max = 30)
  @Column(name = "fax")
  private String fax;
  @Size(max = 30)
  @Column(name = "telPortable")
  private String telPortable;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Size(max = 100)
  @Column(name = "email")
  private String email;
  @Size(max = 90)
  @Column(name = "adresse1")
  private String adresse1;
  @Size(max = 90)
  @Column(name = "adresse2")
  private String adresse2;
  @OneToMany(mappedBy = "codeFabricant")
  private Collection<Article> articleCollection;

  public Fabricant() {}

  public Fabricant(String codeFabricant) {
    this.codeFabricant = codeFabricant;
  }

  public String getCodeFabricant() {
    return codeFabricant;
  }

  public void setCodeFabricant(String codeFabricant) {
    this.codeFabricant = codeFabricant;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getTelPortable() {
    return telPortable;
  }

  public void setTelPortable(String telPortable) {
    this.telPortable = telPortable;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdresse1() {
    return adresse1;
  }

  public void setAdresse1(String adresse1) {
    this.adresse1 = adresse1;
  }

  public String getAdresse2() {
    return adresse2;
  }

  public void setAdresse2(String adresse2) {
    this.adresse2 = adresse2;
  }

  @XmlTransient
  public Collection<Article> getArticleCollection() {
    return articleCollection;
  }

  public void setArticleCollection(Collection<Article> articleCollection) {
    this.articleCollection = articleCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeFabricant != null ? codeFabricant.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Fabricant)) {
      return false;
    }
    Fabricant other = (Fabricant) object;
    if ((this.codeFabricant == null && other.codeFabricant != null)
        || (this.codeFabricant != null && !this.codeFabricant.equals(other.codeFabricant))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Fabricant[ codeFabricant=" + codeFabricant + " ]";
  }

}
