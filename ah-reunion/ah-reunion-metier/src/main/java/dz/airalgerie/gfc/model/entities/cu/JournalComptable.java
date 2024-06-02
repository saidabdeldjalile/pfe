/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.dto.cu.JournalTresorerieDTO;
import dz.airalgerie.gfc.model.entities.cg.EcritureBalance;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = "CU", name = "JOURNAL_COMPTABLE")
@NamedQueries({
    @NamedQuery(name = "JournalComptable.findAll", query = "SELECT j FROM JournalComptable j")})
@SqlResultSetMapping(name = "JournalAuxTresUniteMapping",
    classes = @ConstructorResult(targetClass = JournalTresorerieDTO.class,
        columns = {@ColumnResult(name = "CODE_JOURNAL", type = int.class),
            @ColumnResult(name = "TYPE_JOURNAL", type = String.class),
            @ColumnResult(name = "LIBELLE", type = String.class),
            @ColumnResult(name = "STRUCTURE_ID", type = int.class),
            @ColumnResult(name = "STRUCTURE_LIBELLE", type = String.class),
            @ColumnResult(name = "DEBIT", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE", type = BigDecimal.class),
            @ColumnResult(name = "SOLDE_ANTERIEUR", type = BigDecimal.class),
            @ColumnResult(name = "NEW_SOLDE", type = BigDecimal.class)}))
public class JournalComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Long id;
  @Size(max = 4)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Column(name = "ID_STRUCTURE")
  private Integer idStructure;
  @Column(name = "CODE_CAISSE")
  private Integer codeCaisse;
  @Size(max = 100)
  @Column(name = "LIBELLE_STRUCTURE")
  private String libelleStructure;
  @Column(name = "CODE_JOURNAL")
  private Integer codeJournal;
  @Size(max = 50)
  @Column(name = "LIBELLE_JOURNAL")
  private String libelleJournal;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Column(name = "DATE_OPERATION")
  private LocalDate dateOperation;
  @Size(max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Size(max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;
  @Size(max = 100)
  @Column(name = "LIBELLE_CPT")
  private String libelleCpt;
  @Column(name = "LIBELLE_OPERATION")
  private String libelleOperation;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DEBIT_ORIG")
  private BigDecimal debitOrig;
  @Column(name = "CREDIT_ORIG")
  private BigDecimal creditOrig;
  @Size(max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Column(name = "DEBIT")
  private BigDecimal debit;
  @Column(name = "CREDIT")
  private BigDecimal credit;

  public JournalComptable() {
  }

  public JournalComptable(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public Integer getIdStructure() {
    return idStructure;
  }

  public void setIdStructure(Integer idStructure) {
    this.idStructure = idStructure;
  }

  public Integer getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Integer codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public String getLibelleStructure() {
    return libelleStructure;
  }

  public void setLibelleStructure(String libelleStructure) {
    this.libelleStructure = libelleStructure;
  }

  public Integer getCodeJournal() {
    return codeJournal;
  }

  public void setCodeJournal(Integer codeJournal) {
    this.codeJournal = codeJournal;
  }

  public String getLibelleJournal() {
    return libelleJournal;
  }

  public void setLibelleJournal(String libelleJournal) {
    this.libelleJournal = libelleJournal;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public LocalDate getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(LocalDate dateOperation) {
    this.dateOperation = dateOperation;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public String getLibelleCpt() {
    return libelleCpt;
  }

  public void setLibelleCpt(String libelleCpt) {
    this.libelleCpt = libelleCpt;
  }

  public String getLibelleOperation() {
    return libelleOperation;
  }

  public void setLibelleOperation(String libelleOperation) {
    this.libelleOperation = libelleOperation;
  }

  public BigDecimal getDebitOrig() {
    return debitOrig;
  }

  public void setDebitOrig(BigDecimal debitOrig) {
    this.debitOrig = debitOrig;
  }

  public BigDecimal getCreditOrig() {
    return creditOrig;
  }

  public void setCreditOrig(BigDecimal creditOrig) {
    this.creditOrig = creditOrig;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof JournalComptable)) {
      return false;
    }
    JournalComptable other = (JournalComptable) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.JournalComptable[ id=" + id + " ]";
  }

}
