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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sofyane MAKERRI
 */
@Entity
@Table(name = "MODULE", schema = "AUTH")
@NamedEntityGraph(name = "domaine-entity-graph-with-sub-domaine-functions",
    attributeNodes = {@NamedAttributeNode("libelle"), @NamedAttributeNode("refFonctions"),
        @NamedAttributeNode(value = "refModules", subgraph = "function-subgraph"),},
    subgraphs = {@NamedSubgraph(name = "function-subgraph",
        attributeNodes = {@NamedAttributeNode("refFonctions")})})
public class RefModule implements Serializable {

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
  @NotNull
  @Column(name = "RANG")
  private Integer rang;
  @Column(name = "ICON")
  private String icon;
  @Column(name = "STATUT")
  private boolean statut;
  @JoinColumn(name = "ID_DOMAINE")
  @ManyToOne(fetch = FetchType.LAZY)
  private RefDomaine refDomaine;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "refModule")
  @OrderBy(value = "rang ASC")
  private Set<RefFonction> refFonctions;
  @JoinColumn(name = "ID_MODULE_PARENT")
  @ManyToOne(fetch = FetchType.LAZY)
  private RefModule refModuleParent;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "refModuleParent")
  @OrderBy(value = "rang ASC")
  private Set<RefModule> refModules;

  public RefModule() {
    this.statut = false;
  }

  public RefModule(Long id, String code, String libelle, String descr, Integer rang, String icon,
      boolean statut) {
    this.id = id;
    this.code = code;
    this.libelle = libelle;
    this.descr = descr;
    this.rang = rang;
    this.icon = icon;
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

  public Integer getRang() {
    return rang;
  }

  public void setRang(Integer rang) {
    this.rang = rang;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public boolean isStatut() {
    return statut;
  }

  public void setStatut(boolean statut) {
    this.statut = statut;
  }

  public RefDomaine getRefDomaine() {
    return refDomaine;
  }

  public void setRefDomaine(RefDomaine refDomaine) {
    this.refDomaine = refDomaine;
  }

  public Set<RefFonction> getRefFonctions() {
    return refFonctions;
  }

  public void setRefFonctions(Set<RefFonction> refFonctions) {
    this.refFonctions = refFonctions;
  }

  public RefModule getRefModuleParent() {
    return refModuleParent;
  }

  public void setRefModuleParent(RefModule refModuleParent) {
    this.refModuleParent = refModuleParent;
  }

  public Set<RefModule> getRefModules() {
    return refModules;
  }

  public void setRefModules(Set<RefModule> refModules) {
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
    if (!(object instanceof RefModule)) {
      return false;
    }
    RefModule other = (RefModule) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.ref.entities.RefModule[ id=" + id + " ]";
  }

}
