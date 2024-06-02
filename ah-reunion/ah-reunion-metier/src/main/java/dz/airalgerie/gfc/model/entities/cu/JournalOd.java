/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "JOURNAL_OD")
@NamedQueries({@NamedQuery(name = "JournalOd.findAll", query = "SELECT j FROM JournalOd j"),
    @NamedQuery(name = "JournalOd.findById", query = "SELECT j FROM JournalOd j WHERE j.id = :id"),
    @NamedQuery(name = "JournalOd.findByDateTrt",
        query = "SELECT j FROM JournalOd j WHERE j.dateTrt = :dateTrt"),
    @NamedQuery(name = "JournalOd.findByCodeMonnaie",
        query = "SELECT j FROM JournalOd j WHERE j.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "JournalOd.findByDebit",
        query = "SELECT j FROM JournalOd j WHERE j.debit = :debit"),
    @NamedQuery(name = "JournalOd.findByCredit",
        query = "SELECT j FROM JournalOd j WHERE j.credit = :credit"),
    @NamedQuery(name = "JournalOd.findByNumPage",
        query = "SELECT j FROM JournalOd j WHERE j.numPage = :numPage"),
    @NamedQuery(name = "JournalOd.findByLibelle",
        query = "SELECT j FROM JournalOd j WHERE j.libelle = :libelle"),
    @NamedQuery(name = "JournalOd.findByDateSaisie",
        query = "SELECT j FROM JournalOd j WHERE j.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "JournalOd.findByUtilisateur",
        query = "SELECT j FROM JournalOd j WHERE j.utilisateur = :utilisateur"),
    @NamedQuery(name = "JournalOd.findByDateOperation",
        query = "SELECT j FROM JournalOd j WHERE j.dateOperation = :dateOperation")})
public class JournalOd implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "DEBIT")
  private BigDecimal debit;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREDIT")
  private BigDecimal credit;
  @Column(name = "NUM_PAGE")
  private Integer numPage;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;
  @Size(max = 50)
  @Column(name = "UTILISATEUR")
  private String utilisateur;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_OPERATION")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOperation;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;
  @Column(name = "REF_FACTURE")
  private String refFacture;
  @Column(name = "DATE_FACTURE")
  private Date dateFacture;
  @JoinColumn(name = "CODE_JOURNAL", referencedColumnName = "CODE_JOURNAL")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private JournalUnite codeJournal;
  @JoinColumn(name = "COMPTE_IMPUTATION", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CompteComptable compteComptable;
  @JoinColumn(name = "CODE_STRUCTURE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private StructureCpta structure;

  public JournalOd() {
    this.isSaisie = true;
  }

  public JournalOd(Integer id) {
    this.id = id;
    this.isSaisie = true;
  }

  public JournalOd(Integer id, int dateTrt, String codeMonnaie, BigDecimal debit, BigDecimal credit,
      Integer numPage, String libelle, Date dateSaisie, String utilisateur, Date dateOperation,
      JournalUnite codeJournal, CompteComptable compteComptable, StructureCpta structure,
      boolean isSaisie) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.codeMonnaie = codeMonnaie;
    this.debit = debit;
    this.credit = credit;
    this.numPage = numPage;
    this.libelle = libelle;
    this.dateSaisie = dateSaisie;
    this.utilisateur = utilisateur;
    this.dateOperation = dateOperation;
    this.codeJournal = codeJournal;
    this.compteComptable = compteComptable;
    this.structure = structure;
    this.isSaisie = isSaisie;
  }

  public JournalOd(Integer id, int dateTrt, String codeMonnaie, BigDecimal debit, BigDecimal credit,
      Integer numPage, String libelle, Date dateSaisie, String utilisateur, Date dateOperation,
      JournalUnite codeJournal, CompteComptable compteComptable, StructureCpta structure,
      boolean isSaisie, String refFacture, Date dateFacture) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.codeMonnaie = codeMonnaie;
    this.debit = debit;
    this.credit = credit;
    this.numPage = numPage;
    this.libelle = libelle;
    this.dateSaisie = dateSaisie;
    this.utilisateur = utilisateur;
    this.dateOperation = dateOperation;
    this.codeJournal = codeJournal;
    this.compteComptable = compteComptable;
    this.structure = structure;
    this.isSaisie = isSaisie;
    this.refFacture = refFacture;
    this.dateFacture = dateFacture;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public BigDecimal getDebit() {
    return debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public Integer getNumPage() {
    return numPage;
  }

  public void setNumPage(Integer numPage) {
    this.numPage = numPage;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(String utilisateur) {
    this.utilisateur = utilisateur;
  }

  public Date getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(Date dateOperation) {
    this.dateOperation = dateOperation;
  }

  public JournalUnite getCodeJournal() {
    return codeJournal;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
  }

  public void setCodeJournal(JournalUnite codeJournal) {
    this.codeJournal = codeJournal;
  }

  public StructureCpta getStructure() {
    return structure;
  }

  public void setStructure(StructureCpta structure) {
    this.structure = structure;
  }

  public boolean isIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  public String getRefFacture() {
    return refFacture;
  }

  public void setRefFacture(String refFacture) {
    this.refFacture = refFacture;
  }

  public Date getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(Date dateFacture) {
    this.dateFacture = dateFacture;
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
    if (!(object instanceof JournalOd)) {
      return false;
    }
    JournalOd other = (JournalOd) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.JournalOd[ id=" + id + " ]";
  }

}
