/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.events;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
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
@Table(schema = DbSchemaName.AGS_EV, name = "DOCUMENT_CATEGORIES")
@NamedQueries({@NamedQuery(name = "DocumentAgsCategories.findAll",
    query = "SELECT d FROM DocumentAgsCategories d")})
@SqlResultSetMapping(name = "DocumentAgsCategories.findDocumentsStats",
    classes = @ConstructorResult(targetClass = DocumentAgsCategoriesStatDto.class,
        columns = {@ColumnResult(name = "ID", type = Integer.class),
            @ColumnResult(name = "NOM", type = String.class),
            @ColumnResult(name = "NB_DOCUMENTS", type = Integer.class)}))
public class DocumentAgsCategories implements Serializable {

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
  @OneToMany(mappedBy = "documentCategories", fetch = FetchType.LAZY)
  private List<DocumentAgs> documentList;

  public DocumentAgsCategories() {
  }

  public DocumentAgsCategories(Integer id) {
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

  public List<DocumentAgs> getDocumentList() {
    return documentList;
  }

  public void setDocumentList(List<DocumentAgs> documentList) {
    this.documentList = documentList;
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
    if (!(object instanceof DocumentAgsCategories)) {
      return false;
    }
    DocumentAgsCategories other = (DocumentAgsCategories) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.events.DocumentCategories[ id=" + id + " ]";
  }

}
