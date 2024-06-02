/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ref.model.entities.document;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.portail.model.dto.events.DocumentAgsCategoriesStatDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.REF_DOC, name = "DOCUMENT_CATEGORIE")
@NamedQueries({@NamedQuery(name = "DocumentCategorieRef.findAll",
    query = "SELECT d FROM DocumentCategorieRef d")})
@SqlResultSetMapping(name = "DocumentRefCategories.findDocumentsStats",
    classes = @ConstructorResult(targetClass = DocumentAgsCategoriesStatDto.class,
        columns = {@ColumnResult(name = "ID", type = Integer.class),
            @ColumnResult(name = "NOM", type = String.class),
            @ColumnResult(name = "NB_DOCUMENTS", type = Integer.class)}))
public class DocumentCategorieRef implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @OneToMany(mappedBy = "categorieId", fetch = FetchType.LAZY)
  private List<DocumentRef> documentRefList;

  public DocumentCategorieRef() {
  }

  public DocumentCategorieRef(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public List<DocumentRef> getDocumentRefList() {
    return documentRefList;
  }

  public void setDocumentRefList(List<DocumentRef> documentRefList) {
    this.documentRefList = documentRefList;
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
    if (!(object instanceof DocumentCategorieRef)) {
      return false;
    }
    DocumentCategorieRef other = (DocumentCategorieRef) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ref.model.entities.document.DocumentCategorieRef[ id=" + id + " ]";
  }

}
