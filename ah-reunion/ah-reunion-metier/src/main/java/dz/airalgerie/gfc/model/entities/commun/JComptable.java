/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "J_COMPTABLE", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "JComptable.findAll", query = "SELECT j FROM JComptable j"),
    @NamedQuery(name = "JComptable.findById",
        query = "SELECT j FROM JComptable j WHERE j.id = :id"),
    @NamedQuery(name = "JComptable.findByCptUnite",
        query = "SELECT j FROM JComptable j WHERE j.cptUnite = :cptUnite"),
    @NamedQuery(name = "JComptable.findByDateTrt",
        query = "SELECT j FROM JComptable j WHERE j.dateTrt = :dateTrt"),
    @NamedQuery(name = "JComptable.findByCptScf",
        query = "SELECT j FROM JComptable j WHERE j.cptScf = :cptScf"),
    @NamedQuery(name = "JComptable.findByCptPart",
        query = "SELECT j FROM JComptable j WHERE j.cptPart = :cptPart"),
    @NamedQuery(name = "JComptable.findByLibelle",
        query = "SELECT j FROM JComptable j WHERE j.libelle = :libelle"),
    @NamedQuery(name = "JComptable.findByDebit",
        query = "SELECT j FROM JComptable j WHERE j.debit = :debit"),
    @NamedQuery(name = "JComptable.findByCredit",
        query = "SELECT j FROM JComptable j WHERE j.credit = :credit"),
    @NamedQuery(name = "JComptable.findByCodeMonnaie",
        query = "SELECT j FROM JComptable j WHERE j.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "JComptable.findByNumPiece",
        query = "SELECT j FROM JComptable j WHERE j.numPiece = :numPiece"),
    @NamedQuery(name = "JComptable.findByNumPage",
        query = "SELECT j FROM JComptable j WHERE j.numPage = :numPage"),
    @NamedQuery(name = "JComptable.findByNumJournal",
        query = "SELECT j FROM JComptable j WHERE j.numJournal = :numJournal"),
    @NamedQuery(name = "JComptable.findByCodeApplication",
        query = "SELECT j FROM JComptable j WHERE j.codeApplication = :codeApplication"),
    @NamedQuery(name = "JComptable.findByDebitOrg",
        query = "SELECT j FROM JComptable j WHERE j.debitOrg = :debitOrg"),
    @NamedQuery(name = "JComptable.findByCreditOrg",
        query = "SELECT j FROM JComptable j WHERE j.creditOrg = :creditOrg"),
    @NamedQuery(name = "JComptable.findByUtilisateur",
        query = "SELECT j FROM JComptable j WHERE j.utilisateur = :utilisateur"),
    @NamedQuery(name = "JComptable.findByDateSaisie",
        query = "SELECT j FROM JComptable j WHERE j.dateSaisie = :dateSaisie")})

public class JComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 2)
  @Column(name = "CPT_UNITE")
  private String cptUnite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_PART")
  private String cptPart;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
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
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Size(max = 5)
  @Column(name = "NUM_PIECE")
  private String numPiece;
  @Size(max = 4)
  @Column(name = "NUM_PAGE")
  private String numPage;
  @Size(max = 2)
  @Column(name = "NUM_JOURNAL")
  private String numJournal;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_APPLICATION")
  private String codeApplication;
  @Column(name = "DEBIT_ORG")
  private BigDecimal debitOrg;
  @Column(name = "CREDIT_ORG")
  private BigDecimal creditOrg;
  @Column(name = "UTILISATEUR")
  private Integer utilisateur;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;

  public JComptable() {}

  public JComptable(Integer id) {
    this.id = id;
  }

  public JComptable(Integer id, int dateTrt, String cptScf, String cptPart, BigDecimal debit,
      BigDecimal credit, String codeMonnaie, String codeApplication) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
    this.debit = debit;
    this.credit = credit;
    this.codeMonnaie = codeMonnaie;
    this.codeApplication = codeApplication;
  }

  public JComptable(Integer id, String cptUnite, Integer dateTrt, String cptScf, String cptPart,
      String libelle, BigDecimal debit, BigDecimal credit, String codeMonnaie, String numPiece,
      String numPage, String numJournal, String codeApplication, BigDecimal debitOrg,
      BigDecimal creditOrg, Integer utilisateur, Date dateSaisie) {
    this.id = id;
    this.cptUnite = cptUnite;
    this.dateTrt = dateTrt;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
    this.libelle = libelle;
    this.debit = debit;
    this.credit = credit;
    this.codeMonnaie = codeMonnaie;
    this.numPiece = numPiece;
    this.numPage = numPage;
    this.numJournal = numJournal;
    this.codeApplication = codeApplication;
    this.debitOrg = debitOrg;
    this.creditOrg = creditOrg;
    this.utilisateur = utilisateur;
    this.dateSaisie = dateSaisie;
  }

  public JComptable(int dateTrt, String cptPart, String numJournal, String numPage, String numPiece,
      String libelle, String cptScf, BigDecimal debit, BigDecimal credit) {
    this.dateTrt = dateTrt;
    this.cptPart = cptPart;
    this.numJournal = numJournal;
    this.numPage = numPage;
    this.numPiece = numPiece;
    this.libelle = libelle;
    this.cptScf = cptScf;
    this.debit = debit;
    this.credit = credit;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
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

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public String getNumPiece() {
    return numPiece;
  }

  public void setNumPiece(String numPiece) {
    this.numPiece = numPiece;
  }

  public String getNumPage() {
    return numPage;
  }

  public void setNumPage(String numPage) {
    this.numPage = numPage;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getCodeApplication() {
    return codeApplication;
  }

  public void setCodeApplication(String codeApplication) {
    this.codeApplication = codeApplication;
  }

  public BigDecimal getDebitOrg() {
    return debitOrg;
  }

  public void setDebitOrg(BigDecimal debitOrg) {
    this.debitOrg = debitOrg;
  }

  public BigDecimal getCreditOrg() {
    return creditOrg;
  }

  public void setCreditOrg(BigDecimal creditOrg) {
    this.creditOrg = creditOrg;
  }

  public Integer getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(Integer utilisateur) {
    this.utilisateur = utilisateur;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
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
    if (!(object instanceof JComptable)) {
      return false;
    }
    JComptable other = (JComptable) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.JComptable[ id=" + id + " ]";
  }

}
