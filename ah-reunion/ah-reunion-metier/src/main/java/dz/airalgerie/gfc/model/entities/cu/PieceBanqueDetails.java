/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "PIECE_BANQUE_DETAILS")
@NamedQueries({
    @NamedQuery(name = "PieceBanqueDetails.findAll", query = "SELECT p FROM PieceBanqueDetails p"),
    @NamedQuery(name = "PieceBanqueDetails.findById",
        query = "SELECT p FROM PieceBanqueDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PieceBanqueDetails.findByMontant",
        query = "SELECT p FROM PieceBanqueDetails p WHERE p.montant = :montant"),
    @NamedQuery(name = "PieceBanqueDetails.findByLibelle",
        query = "SELECT p FROM PieceBanqueDetails p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "PieceBanqueDetails.findByNatureDocument",
        query = "SELECT p FROM PieceBanqueDetails p WHERE p.natureDocument = :natureDocument"),
    @NamedQuery(name = "PieceBanqueDetails.findByNumDocument",
        query = "SELECT p FROM PieceBanqueDetails p WHERE p.numDocument = :numDocument")})
public class PieceBanqueDetails implements Serializable {

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
  @JoinColumn(name = "ID_CONTREPARTIE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BanqueContrepartie banqueContrepartie;
  @JoinColumn(name = "ID_PIECE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PieceBanque pieceBanque;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;
  @JoinColumn(name = "COMPTE_IMPUTATION", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CompteComptable compteComptable;

  public PieceBanqueDetails() {
      isSaisie = true; 
  }

  public PieceBanqueDetails(Integer id) {
    this.id = id;
    isSaisie = true; 
  }

  public PieceBanqueDetails(Integer id, BigDecimal montant, String libelle,
      Character natureDocument, String numDocument, BanqueContrepartie banqueContrepartie,
      PieceBanque pieceBanque, CompteComptable compteComptable) {
    this.id = id;
    this.montant = montant;
    this.libelle = libelle;
    this.natureDocument = natureDocument;
    this.numDocument = numDocument;
    this.banqueContrepartie = banqueContrepartie;
    this.pieceBanque = pieceBanque;
    this.compteComptable = compteComptable;
  }

  public PieceBanqueDetails(Integer id, BigDecimal montant, String libelle,
      Character natureDocument, String numDocument, BanqueContrepartie banqueContrepartie,
      PieceBanque pieceBanque, CompteComptable compteComptable, boolean isSaisie) {
    this.id = id;
    this.montant = montant;
    this.libelle = libelle;
    this.natureDocument = natureDocument;
    this.numDocument = numDocument;
    this.banqueContrepartie = banqueContrepartie;
    this.pieceBanque = pieceBanque;
    this.compteComptable = compteComptable;
    this.isSaisie = isSaisie;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
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

  public BanqueContrepartie getBanqueContrepartie() {
    return banqueContrepartie;
  }

  public void setBanqueContrepartie(BanqueContrepartie banqueContrepartie) {
    this.banqueContrepartie = banqueContrepartie;
  }

  public PieceBanque getPieceBanque() {
    return pieceBanque;
  }

  public void setPieceBanque(PieceBanque pieceBanque) {
    this.pieceBanque = pieceBanque;
  }

  public boolean isIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(boolean isSaisie) {
    this.isSaisie = isSaisie;
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
    if (!(object instanceof PieceBanqueDetails)) {
      return false;
    }
    PieceBanqueDetails other = (PieceBanqueDetails) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.PieceBanqueDetails[ id=" + id + " ]";
  }

  public PieceBanqueDetails getClone() {
    PieceBanqueDetails clone = new PieceBanqueDetails();
    clone.setMontant(this.montant);
    clone.setLibelle(this.libelle);
    clone.setNatureDocument(this.natureDocument);
    clone.setNumDocument(this.numDocument);
    clone.setBanqueContrepartie(this.banqueContrepartie);
    clone.setPieceBanque(this.pieceBanque);
    clone.setCompteComptable(this.compteComptable);
    return clone;
  }
}
