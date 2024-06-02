/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.AGS_EV, name = "DOCUMENT")
@NamedQueries({@NamedQuery(name = "DocumentAgs.findAll", query = "SELECT d FROM DocumentAgs d")})
public class DocumentAgs implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "TITRE")
  private String titre;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "DESCRIPTION")
  private String description;
  @Size(max = 150)
  @Column(name = "LIEN")
  private String lien;
  @Size(max = 10)
  @Column(name = "TYPE")
  private String type;
  @Column(name = "EVENT_ID")
  private Integer eventId;
  @Column(name = "SECTOR_ID")
  private Integer sectorId;
  @Column(name = "VIEWS")
  private Integer views;
  @Column(name = "IS_ACTIVE")
  private Boolean isActive;
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private DocumentAgsCategories documentCategories;

  public DocumentAgs() {
  }

  public DocumentAgs(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  public Integer getSectorId() {
    return sectorId;
  }

  public void setSectorId(Integer sectorId) {
    this.sectorId = sectorId;
  }

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public DocumentAgsCategories getDocumentCategories() {
    return documentCategories;
  }

  public void setDocumentCategories(DocumentAgsCategories documentCategories) {
    this.documentCategories = documentCategories;
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
    if (!(object instanceof DocumentAgs)) {
      return false;
    }
    DocumentAgs other = (DocumentAgs) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.Document[ id=" + id + " ]";
  }

}
