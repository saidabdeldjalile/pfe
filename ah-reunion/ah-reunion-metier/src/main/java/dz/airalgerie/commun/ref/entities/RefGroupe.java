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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 */
@Entity
@Table(name = "GROUPE", schema = "AUTH")
@XmlRootElement
public class RefGroupe implements Serializable {

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
  @JoinTable(name = "GROUPE_PERMISSION", schema = "AUTH",
      joinColumns = {@JoinColumn(name = "ID_GROUPE", referencedColumnName = "ID",
          insertable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "ID_PERMISSION", referencedColumnName = "ID",
          insertable = false, updatable = false)})
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<RefPermission> refPermissionSet;
  @ManyToMany(mappedBy = "refGroupeSet", fetch = FetchType.LAZY)
  private Set<RefUser> refUserSet;

  public RefGroupe() {}

  public RefGroupe(Long id) {
    this.id = id;
  }

  public RefGroupe(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public RefGroupe(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public void addPermission(RefPermission permission) {
    this.getRefPermissionSet().add(permission);
    permission.getRefGroupeSet().add(this);
  }

  public void deletePermission(RefPermission permission) {
    this.refPermissionSet.remove(permission);
    permission.getRefGroupeSet().remove(this);
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

  @XmlTransient
  public Set<RefPermission> getRefPermissionSet() {
    return refPermissionSet;
  }

  public void setRefPermissionSet(Set<RefPermission> refPermissionSet) {
    this.refPermissionSet = refPermissionSet;
  }

  @XmlTransient
  public Set<RefUser> getRefUserSet() {
    return refUserSet;
  }

  public void setRefUserSet(Set<RefUser> refUserSet) {
    this.refUserSet = refUserSet;
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
    if (!(object instanceof RefGroupe)) {
      return false;
    }
    RefGroupe other = (RefGroupe) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.RefGroupe[ id=" + id + " ]";
  }

}
