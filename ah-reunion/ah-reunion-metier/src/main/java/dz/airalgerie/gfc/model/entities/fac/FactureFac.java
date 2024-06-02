/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.fac;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.gfc.model.entities.cu.ClientCpta;
import dz.airalgerie.gfc.model.entities.cu.FournisseurCpta;
import dz.airalgerie.gfc.model.entities.cu.StructureCpta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "FACTURE", schema = ErpConstante.DbSchemaName.CPTA_FAC)
@NamedQueries({@NamedQuery(name = "FactureFac.findAll", query = "SELECT f FROM FactureFac f")})
public class FactureFac implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 16)
  @Column(name = "REFERENCE")
  private String reference;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NATURE_FACTURE")
  private Character natureFacture;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TYPE_FACTURE")
  private Character typeFacture;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FACTURE")
  private LocalDate dateFacture;
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "STATUT")
  private short statut;
  @Column(name = "IS_ENVOYE")
  private short envoye;
  @Column(name = "IS_CLOTURE")
  private short cloture;
  @Size(max = 150)
  @Column(name = "TERMES")
  private String termes;
  @Size(max = 150)
  @Column(name = "NOTES")
  private String notes;
  @Column(name = "DATE_ECHEANCE")
  private LocalDate dateEcheance;
  @Column(name = "DATE_PAIEMENT")
  private LocalDate datePaiement;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "TOTAL_HT")
  private BigDecimal totalHt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TOTAL_TTC")
  private BigDecimal totalTtc;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TOTAL_PAYE")
  private BigDecimal totalPaye;
  @Column(name = "IS_PSS")
  private boolean isPss;
  @Column(name = "NUM_BON")
  private String numBon;
  @Column(name = "CHAPITRE_BUDGETAIRE")
  private String chapitreBudgetaire;
  @Column(name = "FILENAME")
  private String filename;
  @JoinColumn(name = "CODE_CLIENT", referencedColumnName = "CODE_CLIENT")
  @ManyToOne(fetch = FetchType.LAZY)
  private ClientCpta client;
  @JoinColumn(name = "CODE_FOURNISSEUR", referencedColumnName = "CODE_FOURNISSEUR")
  @ManyToOne(fetch = FetchType.LAZY)
  private FournisseurCpta fournisseur;
  @OneToMany(mappedBy = "factureFac", fetch = FetchType.LAZY)
  private List<FactureFac> factureFacList;
  @JoinColumn(name = "ID_STRUCTURE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private StructureCpta structure;
  @JoinColumn(name = "ID_FACTURE", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private FactureFac factureFac;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "factureFac", fetch = FetchType.LAZY,
      orphanRemoval = true)
  @OrderBy("numLigne asc")
  private List<FactureDetail> factureDetailList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "factureFac", fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<FacturePaiement> facturePaiementList;

  public FactureFac() {
    this.isPss = false;
  }

  public FactureFac(Integer id) {
    this();
    this.id = id;
  }

  public FactureFac(Integer id, Character typeFacture, LocalDate dateFacture, String codeMonnaie,
      short envoye, short cloture, short statut, BigDecimal totalHt, BigDecimal totalTtc,
      BigDecimal totalPaye, boolean isPss, String chapitreBudgetaire) {
    this();
    this.id = id;
    this.typeFacture = typeFacture;
    this.dateFacture = dateFacture;
    this.codeMonnaie = codeMonnaie;
    this.statut = statut;
    this.envoye = envoye;
    this.cloture = cloture;
    this.totalHt = totalHt;
    this.totalTtc = totalTtc;
    this.totalPaye = totalPaye;
    this.isPss = isPss;
    this.chapitreBudgetaire = chapitreBudgetaire;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Character getNatureFacture() {
    return natureFacture;
  }

  public void setNatureFacture(Character natureFacture) {
    this.natureFacture = natureFacture;
  }

  public Character getTypeFacture() {
    return typeFacture;
  }

  public void setTypeFacture(Character typeFacture) {
    this.typeFacture = typeFacture;
  }

  public LocalDate getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(LocalDate dateFacture) {
    this.dateFacture = dateFacture;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public short getStatut() {
    return statut;
  }

  public void setStatut(short statut) {
    this.statut = statut;
  }

  public short getEnvoye() {
    return envoye;
  }

  public void setEnvoye(short envoye) {
    this.envoye = envoye;
  }

  public short getCloture() {
    return cloture;
  }

  public void setCloture(short cloture) {
    this.cloture = cloture;
  }

  public String getTermes() {
    return termes;
  }

  public void setTermes(String termes) {
    this.termes = termes;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public LocalDate getDateEcheance() {
    return dateEcheance;
  }

  public void setDateEcheance(LocalDate dateEcheance) {
    this.dateEcheance = dateEcheance;
  }

  public LocalDate getDatePaiement() {
    return datePaiement;
  }

  public void setDatePaiement(LocalDate datePaiement) {
    this.datePaiement = datePaiement;
  }

  public BigDecimal getTotalHt() {
    return totalHt;
  }

  public void setTotalHt(BigDecimal totalHt) {
    this.totalHt = totalHt;
  }

  public BigDecimal getTotalTtc() {
    return totalTtc;
  }

  public void setTotalTtc(BigDecimal totalTtc) {
    this.totalTtc = totalTtc;
  }

  public BigDecimal getTotalPaye() {
    return totalPaye;
  }

  public void setTotalPaye(BigDecimal totalPaye) {
    this.totalPaye = totalPaye;
  }

  public boolean isIsPss() {
    return isPss;
  }

  public void setIsPss(boolean isPss) {
    this.isPss = isPss;
  }

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public String getChapitreBudgetaire() {
    return chapitreBudgetaire;
  }

  public void setChapitreBudgetaire(String chapitreBudgetaire) {
    this.chapitreBudgetaire = chapitreBudgetaire;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public StructureCpta getStructure() {
    return structure;
  }

  public void setStructure(StructureCpta structure) {
    this.structure = structure;
  }

  public ClientCpta getClient() {
    return client;
  }

  public void setClient(ClientCpta client) {
    this.client = client;
  }

  public FournisseurCpta getFournisseur() {
    return fournisseur;
  }

  public void setFournisseur(FournisseurCpta fournisseur) {
    this.fournisseur = fournisseur;
  }

  public List<FactureFac> getFactureFacList() {
    return factureFacList;
  }

  public void setFactureFacList(List<FactureFac> factureFacList) {
    this.factureFacList = factureFacList;
  }

  public FactureFac getFactureFac() {
    return factureFac;
  }

  public void setFactureFac(FactureFac factureFac) {
    this.factureFac = factureFac;
  }

  public List<FactureDetail> getFactureDetailList() {
    return factureDetailList;
  }

  public void setFactureDetailList(List<FactureDetail> factureDetailList) {
    this.factureDetailList = factureDetailList;
  }

  public List<FacturePaiement> getFacturePaiementList() {
    return facturePaiementList;
  }

  public void setFacturePaiementList(List<FacturePaiement> facturePaiementList) {
    this.facturePaiementList = facturePaiementList;
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
    if (!(object instanceof FactureFac)) {
      return false;
    }
    FactureFac other = (FactureFac) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.FactureFac[ id=" + id + ", Ref: " + reference
        + " ]";
  }

}
