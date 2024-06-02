
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the document_has_demande_dadc database table.
 * 
 */
@Entity
@Table(name = "document_has_demande_dadc")
public class DocumentHasDemandeDadc implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private DocumentHasDemandeDadcPK id;

  @Transient
  private int nbr_doc;

  @Column(name = "Obs")
  private String obs;

  @Column(name = "Qte_dem")
  private int qte_dem;

  @Column(name = "Qte_stk")
  private int qte_stk;

  // bi-directional many-to-one association to DemandeDadc
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Demande_DADC_Num_dem")
  private DemandeDadc demandeDadc;

  // bi-directional many-to-one association to Document
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Document_Nature_document")
  private Document document;

  public DocumentHasDemandeDadc() {}

  public DocumentHasDemandeDadcPK getId() {
    return this.id;
  }

  public void setId(DocumentHasDemandeDadcPK id) {
    this.id = id;
  }

  public int getNbr_doc() {
    return this.nbr_doc;
  }

  public void setNbr_doc(int nbr_doc) {
    this.nbr_doc = nbr_doc;
  }

  public String getObs() {
    return this.obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public int getQte_dem() {
    return this.qte_dem;
  }

  public void setQte_dem(int qte_dem) {
    this.qte_dem = qte_dem;
  }

  public DemandeDadc getDemandeDadc() {
    return this.demandeDadc;
  }

  public void setDemandeDadc(DemandeDadc demandeDadc) {
    this.demandeDadc = demandeDadc;
  }

  public Document getDocument() {
    return this.document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public int getQte_stk() {
    return qte_stk;
  }

  public void setQte_stk(int qte_stk) {
    this.qte_stk = qte_stk;
  }

  public void PK()

  {
    id = new DocumentHasDemandeDadcPK();
    id.setDemande_DADC_Num_dem(this.demandeDadc.getNum_dem());
    id.setDocument_Nature_document(this.document.getNature_document());
    id.setNbr_doc(this.nbr_doc);

  }

}
