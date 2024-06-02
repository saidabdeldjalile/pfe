/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "PIECE_CAISSE_DETAILS")
@NamedQueries({
    @NamedQuery(name = "PieceCaisseDetails.findAll", query = "SELECT p FROM PieceCaisseDetails p"),
    @NamedQuery(name = "PieceCaisseDetails.findById",
        query = "SELECT p FROM PieceCaisseDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PieceCaisseDetails.findByMontant",
        query = "SELECT p FROM PieceCaisseDetails p WHERE p.montant = :montant"),
    @NamedQuery(name = "PieceCaisseDetails.findByLibelle",
        query = "SELECT p FROM PieceCaisseDetails p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "PieceCaisseDetails.findByNatureDocument",
        query = "SELECT p FROM PieceCaisseDetails p WHERE p.natureDocument = :natureDocument"),
    @NamedQuery(name = "PieceCaisseDetails.findByNumDocument",
        query = "SELECT p FROM PieceCaisseDetails p WHERE p.numDocument = :numDocument")})
public class PieceCaisseDetails implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT")
  private BigDecimal montant;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "NATURE_DOCUMENT")
  private Character natureDocument;
  @Size(max = 15)
  @Column(name = "NUM_DOCUMENT")
  private String numDocument;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;
  @Column(name = "DATE_VERSEMENT")
  private LocalDate dateVersement;
  @Column(name = "MATRICULE")
  private String matricule;
  @JoinColumn(name = "ID_CONTREPARTIE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private CaisseContrepartie idContrepartie;
  @JoinColumn(name = "ID_PIECE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PieceCaisse pieceCaisse;
  @JoinColumn(name = "COMPTE_IMPUTATION", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private CompteComptable compteComptable;

  public PieceCaisseDetails() {
    isSaisie = true;
  }

  public PieceCaisseDetails(Integer id, BigDecimal montant, String libelle,
      Character natureDocument, String numDocument, CaisseContrepartie idContrepartie,
      PieceCaisse pieceCaisse, CompteComptable compteComptable) {
    this.id = id;
    this.montant = montant;
    this.libelle = libelle;
    this.natureDocument = natureDocument;
    this.numDocument = numDocument;
    this.idContrepartie = idContrepartie;
    this.pieceCaisse = pieceCaisse;
    this.compteComptable = compteComptable;
  }

  public PieceCaisseDetails(Integer id, BigDecimal montant, String libelle,
      Character natureDocument, String numDocument, CaisseContrepartie idContrepartie,
      PieceCaisse pieceCaisse, CompteComptable compteComptable, boolean isSaisie) {
    this.id = id;
    this.montant = montant;
    this.libelle = libelle;
    this.natureDocument = natureDocument;
    this.numDocument = numDocument;
    this.idContrepartie = idContrepartie;
    this.pieceCaisse = pieceCaisse;
    this.compteComptable = compteComptable;
    this.isSaisie = isSaisie;

  }

  public PieceCaisseDetails(Integer id) {
    this.id = id;
    isSaisie = true;
  }

  public PieceCaisseDetails(Integer id, BigDecimal montant, String libelle) {
    this.id = id;
    this.montant = montant;
    this.libelle = libelle;
  }

  public PieceCaisseDetails(PieceCaisseDetails oldPieceCaisseDetails) {
    this.montant = oldPieceCaisseDetails.montant;
    this.libelle = oldPieceCaisseDetails.libelle;
    this.natureDocument = oldPieceCaisseDetails.natureDocument;
    this.numDocument = oldPieceCaisseDetails.numDocument;
    this.idContrepartie = oldPieceCaisseDetails.idContrepartie;
    this.pieceCaisse = oldPieceCaisseDetails.pieceCaisse;
    this.compteComptable = oldPieceCaisseDetails.compteComptable;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Character getNatureDocument() {
    return natureDocument;
  }

  public void setNatureDocument(Character natureDocument) {
    this.natureDocument = natureDocument;
  }

  public String getNumDocument() {
    return numDocument;
  }

  public void setNumDocument(String numDocument) {
    this.numDocument = numDocument;
  }

  public CaisseContrepartie getIdContrepartie() {
    return idContrepartie;
  }

  public void setIdContrepartie(CaisseContrepartie idContrepartie) {
    this.idContrepartie = idContrepartie;
  }

  public PieceCaisse getPieceCaisse() {
    return pieceCaisse;
  }

  public void setPieceCaisse(PieceCaisse pieceCaisse) {
    this.pieceCaisse = pieceCaisse;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
  }

  public boolean isIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  public LocalDate getDateVersement() {
    return dateVersement;
  }

  public void setDateVersement(LocalDate dateVersement) {
    this.dateVersement = dateVersement;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
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
    if (!(object instanceof PieceCaisseDetails)) {
      return false;
    }
    PieceCaisseDetails other = (PieceCaisseDetails) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.PieceCaisseDetails[ id=" + id + " ]";
  }

  public void modify(PieceCaisseDetails pieceCaisseDetails) {
    this.montant = pieceCaisseDetails.montant;
    this.libelle = pieceCaisseDetails.libelle;
    this.natureDocument = pieceCaisseDetails.natureDocument;
    this.numDocument = pieceCaisseDetails.numDocument;
    this.idContrepartie = pieceCaisseDetails.idContrepartie;
    this.pieceCaisse = pieceCaisseDetails.pieceCaisse;
    this.compteComptable = pieceCaisseDetails.compteComptable;
  }

}
