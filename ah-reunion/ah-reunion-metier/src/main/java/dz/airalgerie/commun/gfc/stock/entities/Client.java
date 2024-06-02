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
@Table(name = "STK.client")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByCodeClient",
        query = "SELECT c FROM Client c WHERE c.codeClient = :codeClient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByTelephone",
        query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByFax", query = "SELECT c FROM Client c WHERE c.fax = :fax"),
    @NamedQuery(name = "Client.findByTelPortable",
        query = "SELECT c FROM Client c WHERE c.telPortable = :telPortable"),
    @NamedQuery(name = "Client.findByEmail",
        query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByAdresse1",
        query = "SELECT c FROM Client c WHERE c.adresse1 = :adresse1"),
    @NamedQuery(name = "Client.findByAdresse2",
        query = "SELECT c FROM Client c WHERE c.adresse2 = :adresse2")})
public class Client implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "codeClient")
  private String codeClient;
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
  @OneToMany(mappedBy = "codeClient")
  private Collection<BonSortie> bonSortieCollection;

  public Client() {}

  public Client(String codeClient) {
    this.codeClient = codeClient;
  }

  public String getCodeClient() {
    return codeClient;
  }

  public void setCodeClient(String codeClient) {
    this.codeClient = codeClient;
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
  public Collection<BonSortie> getBonSortieCollection() {
    return bonSortieCollection;
  }

  public void setBonSortieCollection(Collection<BonSortie> bonSortieCollection) {
    this.bonSortieCollection = bonSortieCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeClient != null ? codeClient.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Client)) {
      return false;
    }
    Client other = (Client) object;
    if ((this.codeClient == null && other.codeClient != null)
        || (this.codeClient != null && !this.codeClient.equals(other.codeClient))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Client[ codeClient=" + codeClient + " ]";
  }

}
