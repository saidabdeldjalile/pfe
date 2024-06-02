
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Nature_document")
  private String nature_document;

  @Column(name = "Description")
  private String description;

  // bi-directional many-to-one association to DocumentHasDemandeDadc
  @OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
  private Set<DocumentHasDemandeDadc> documentHasDemandeDadcs;

  public Document() {}

  public String getNature_document() {
    return this.nature_document;
  }

  public void setNature_document(String nature_document) {
    this.nature_document = nature_document;
  }

  public Set<DocumentHasDemandeDadc> getDocumentHasDemandeDadcs() {
    return this.documentHasDemandeDadcs;
  }

  public void setDocumentHasDemandeDadcs(Set<DocumentHasDemandeDadc> documentHasDemandeDadcs) {
    this.documentHasDemandeDadcs = documentHasDemandeDadcs;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
