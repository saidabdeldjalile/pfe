/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ref.model.entities.document;

import dz.airalgerie.commun.utils.ErpConstante;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.REF_DOC, name = "DOCUMENT")
@NamedQueries({@NamedQuery(name = "DocumentRef.findAll", query = "SELECT d FROM DocumentRef d")})
public class DocumentRef implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 150)
  @Column(name = "FILENAME")
  private String filename;
  @Size(max = 150)
  @Column(name = "TITRE")
  private String titre;
  @Size(max = 10)
  @Column(name = "EXTENSION")
  private String extension;
  @Column(name = "TAILLE")
  private Integer taille;
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Column(name = "CREATED")
  private LocalDateTime created;
  @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private DocumentCategorieRef categorieId;

  public DocumentRef() {
  }

  public DocumentRef(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public Integer getTaille() {
    return taille;
  }

  public void setTaille(Integer taille) {
    this.taille = taille;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DocumentCategorieRef getCategorieId() {
    return categorieId;
  }

  public void setCategorieId(DocumentCategorieRef categorieId) {
    this.categorieId = categorieId;
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
    if (!(object instanceof DocumentRef)) {
      return false;
    }
    DocumentRef other = (DocumentRef) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ref.model.entities.document.DocumentRef[ id=" + id + " ]";
  }

}
