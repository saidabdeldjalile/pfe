/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sofyane MAKERRI
 */
@Entity
@Table(name = "FONCTION", schema = "AUTH")
public class RefFonction implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, unique = true)
  private Long id;
  @Size(max = 10)
  @Column(name = "CODE")
  private String code;
  @Size(max = 120)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 120)
  @Column(name = "DESCR")
  private String descr;
  @Size(max = 250)
  @Column(name = "URL")
  private String url;
  @Size(max = 50)
  @Column(name = "ICON")
  private String icon;
  @NotNull
  @Column(name = "RANG")
  private Integer rang;
  @Column(name = "STATUT")
  private boolean statut;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "refFonction")
  private Set<RefPermission> refPermissions;
  @JoinColumn(name = "ID_MODULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private RefModule refModule;

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

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Integer getRang() {
    return rang;
  }

  public void setRang(Integer rang) {
    this.rang = rang;
  }

  public boolean isStatut() {
    return statut;
  }

  public void setStatut(boolean statut) {
    this.statut = statut;
  }

  public Set<RefPermission> getRefPermissions() {
    return refPermissions;
  }

  public void setRefPermissions(Set<RefPermission> refPermissions) {
    this.refPermissions = refPermissions;
  }

  public RefModule getRefModule() {
    return refModule;
  }

  public void setRefModule(RefModule refModule) {
    this.refModule = refModule;
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
    if (!(object instanceof RefFonction)) {
      return false;
    }
    RefFonction other = (RefFonction) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.RefFonction[ id=" + id + " ]";
  }

}
