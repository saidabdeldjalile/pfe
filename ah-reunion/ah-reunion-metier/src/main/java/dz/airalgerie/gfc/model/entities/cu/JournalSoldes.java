/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "JOURNAL_SOLDES", schema = "CU")
@NamedQueries({
    @NamedQuery(name = "JournalSoldes.findAll", query = "SELECT j FROM JournalSoldes j")})
public class JournalSoldes implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Long id;
  @Size(max = 50)
  @Column(name = "CODE")
  private String code;
  @Size(max = 2)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TOTAL_CREDIT")
  private BigDecimal totalCredit;
  @Column(name = "TOTAL_DEBIT")
  private BigDecimal totalDebit;
  @Column(name = "SOLDE")
  private BigDecimal solde;
  @Column(name = "ID_STRUCTURE")
  private Integer idStructure;
  @Column(name = "TYPE_JOURNAL")
  private Integer typeJournal;

  public JournalSoldes() {
  }

  public JournalSoldes(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public BigDecimal getTotalCredit() {
    return totalCredit;
  }

  public void setTotalCredit(BigDecimal totalCredit) {
    this.totalCredit = totalCredit;
  }

  public BigDecimal getTotalDebit() {
    return totalDebit;
  }

  public void setTotalDebit(BigDecimal totalDebit) {
    this.totalDebit = totalDebit;
  }

  public BigDecimal getSolde() {
    return solde;
  }

  public void setSolde(BigDecimal solde) {
    this.solde = solde;
  }

  public Integer getIdStructure() {
    return idStructure;
  }

  public void setIdStructure(Integer idStructure) {
    this.idStructure = idStructure;
  }

  public Integer getTypeJournal() {
    return typeJournal;
  }

  public void setTypeJournal(Integer typeJournal) {
    this.typeJournal = typeJournal;
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
    if (!(object instanceof JournalSoldes)) {
      return false;
    }
    JournalSoldes other = (JournalSoldes) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.JournalSoldes[ id=" + id + ", code=" + code + " ]";
  }

}
