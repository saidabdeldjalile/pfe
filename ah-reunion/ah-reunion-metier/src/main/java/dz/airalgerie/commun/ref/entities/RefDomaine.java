/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sofyane MAKERRI
 */
@Entity
@Table(name = "DOMAINE", schema = "AUTH")
public class RefDomaine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true)
  private Long id;
  @Size(max = 25)
  @Column(name = "CODE")
  private String code;
  @Size(max = 120)
  @Column(name = "NOM")
  private String nom;
  @NotNull
  @Column(name = "RANG")
  private Integer rang;
  @Column(name = "ICON")
  private String icon;
  @Column(name = "URL")
  private String url;
  @Column(name = "STATUT")
  private boolean statut;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "refDomaine")
  private Collection<RefModule> refModules;

  public RefDomaine() {
    this.statut = false;
  }

  public RefDomaine(Long id, String code, String nom, Integer rang, String icon, String url,
      boolean statut) {
    this.id = id;
    this.code = code;
    this.nom = nom;
    this.rang = rang;
    this.icon = icon;
    this.url = url;
    this.statut = statut;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Integer getRang() {
    return rang;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public void setRang(Integer rang) {
    this.rang = rang;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isStatut() {
    return statut;
  }

  public void setStatut(boolean statut) {
    this.statut = statut;
  }

  public Collection<RefModule> getRefModules() {
    return refModules;
  }

  public void setRefModules(Collection<RefModule> refModules) {
    this.refModules = refModules;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefDomaine)) {
      return false;
    }
    RefDomaine other = (RefDomaine) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.RefDomaine[ id=" + id + " ]";
  }

}
