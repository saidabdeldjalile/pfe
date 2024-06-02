/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 */
@Entity
@Table(name = "PERMISSION", schema = "AUTH")
@XmlRootElement
public class RefPermission implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "NAME")
  private String name;
  @Size(max = 150)
  @Column(name = "DESCRIPTION")
  private String description;
  @Basic(optional = false)
  @NotNull
  @Column(name = "IS_VIEW_ACCESS")
  private boolean viewAccess;
  @JoinColumn(name = "ID_FONCTION", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private RefFonction refFonction;
  @ManyToMany(mappedBy = "refPermissionSet", fetch = FetchType.LAZY)
  private Set<RefGroupe> refGroupeSet;

  public RefPermission() {}

  public RefPermission(Long id) {
    this.id = id;
  }

  public RefPermission(Long id, String name, boolean viewAccess) {
    this.id = id;
    this.name = name;
    this.viewAccess = viewAccess;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isViewAccess() {
    return viewAccess;
  }

  public void setViewAccess(boolean viewAccess) {
    this.viewAccess = viewAccess;
  }

  public RefFonction getRefFonction() {
    return refFonction;
  }

  public void setRefFonction(RefFonction refFonction) {
    this.refFonction = refFonction;
  }

  @XmlTransient
  public Set<RefGroupe> getRefGroupeSet() {
    return refGroupeSet;
  }

  public void setRefGroupeSet(Set<RefGroupe> refGroupeSet) {
    this.refGroupeSet = refGroupeSet;
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
    if (!(object instanceof RefPermission)) {
      return false;
    }
    RefPermission other = (RefPermission) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.RefPermission[ id=" + id + " ]";
  }

}
