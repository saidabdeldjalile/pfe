
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the document_has_demande_dadc database table.
 * 
 */
@Embeddable
public class DocumentHasDemandeDadcPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "Document_Nature_document", insertable = false, updatable = false)
  private String document_Nature_document;

  @Column(name = "Demande_DADC_Num_dem", insertable = false, updatable = false)
  private long demande_DADC_Num_dem;

  @Column(name = "Nbr_doc")
  private int nbr_doc;

  public DocumentHasDemandeDadcPK() {}

  public String getDocument_Nature_document() {
    return this.document_Nature_document;
  }

  public void setDocument_Nature_document(String document_Nature_document) {
    this.document_Nature_document = document_Nature_document;
  }

  public long getDemande_DADC_Num_dem() {
    return this.demande_DADC_Num_dem;
  }

  public void setDemande_DADC_Num_dem(long demande_DADC_Num_dem) {
    this.demande_DADC_Num_dem = demande_DADC_Num_dem;
  }

  public int getNbr_doc() {
    return nbr_doc;
  }

  public void setNbr_doc(int nbr_doc) {
    this.nbr_doc = nbr_doc;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (demande_DADC_Num_dem ^ (demande_DADC_Num_dem >>> 32));
    result = prime * result
        + ((document_Nature_document == null) ? 0 : document_Nature_document.hashCode());
    result = prime * result + nbr_doc;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DocumentHasDemandeDadcPK other = (DocumentHasDemandeDadcPK) obj;
    if (demande_DADC_Num_dem != other.demande_DADC_Num_dem)
      return false;
    if (document_Nature_document == null) {
      if (other.document_Nature_document != null)
        return false;
    } else if (!document_Nature_document.equals(other.document_Nature_document))
      return false;
    if (nbr_doc != other.nbr_doc)
      return false;
    return true;
  }

}
