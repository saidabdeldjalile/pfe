/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import dz.airalgerie.gfc.model.dto.cg.EcritureJournal;
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
 * @author user
 */
@Entity
@Table(name = "JOURNAL", schema = "CF")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j"),
    @NamedQuery(name = "Journal.findById", query = "SELECT j FROM Journal j WHERE j.id = :id"),
    @NamedQuery(name = "Journal.findByOrderId",
        query = "SELECT j FROM Journal j WHERE j.orderId = :orderId"),
    @NamedQuery(name = "Journal.findByCptUnite",
        query = "SELECT j FROM Journal j WHERE j.cptUnite = :cptUnite"),
    @NamedQuery(name = "Journal.findByDateTrt",
        query = "SELECT j FROM Journal j WHERE j.dateTrt = :dateTrt"),
    @NamedQuery(name = "Journal.findByCptScf",
        query = "SELECT j FROM Journal j WHERE j.cptScf = :cptScf"),
    @NamedQuery(name = "Journal.findByCptPart",
        query = "SELECT j FROM Journal j WHERE j.cptPart = :cptPart"),
    @NamedQuery(name = "Journal.findByLibelle",
        query = "SELECT j FROM Journal j WHERE j.libelle = :libelle"),
    @NamedQuery(name = "Journal.findByDebit",
        query = "SELECT j FROM Journal j WHERE j.debit = :debit"),
    @NamedQuery(name = "Journal.findByCredit",
        query = "SELECT j FROM Journal j WHERE j.credit = :credit"),
    @NamedQuery(name = "Journal.findByCodeMonnaie",
        query = "SELECT j FROM Journal j WHERE j.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "Journal.findByNumPiece",
        query = "SELECT j FROM Journal j WHERE j.numPiece = :numPiece"),
    @NamedQuery(name = "Journal.findByNumPage",
        query = "SELECT j FROM Journal j WHERE j.numPage = :numPage"),
    @NamedQuery(name = "Journal.findByNumJournal",
        query = "SELECT j FROM Journal j WHERE j.numJournal = :numJournal"),
    @NamedQuery(name = "Journal.findByCodeApplication",
        query = "SELECT j FROM Journal j WHERE j.codeApplication = :codeApplication"),
    @NamedQuery(name = "Journal.findByIsSaisie",
        query = "SELECT j FROM Journal j WHERE j.isSaisie = :isSaisie"),
    @NamedQuery(name = "Journal.findByUtilisateur",
        query = "SELECT j FROM Journal j WHERE j.utilisateur = :utilisateur"),
    @NamedQuery(name = "Journal.findByDateSaisie",
        query = "SELECT j FROM Journal j WHERE j.dateSaisie = :dateSaisie")})
public class Journal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "ORDER_ID")
  private Integer orderId;
  @Size(max = 2)
  @Column(name = "CPT_UNITE")
  private String cptUnite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Column(name = "DATE_OPERATION")
  @NotNull
  @Temporal(TemporalType.DATE)
  private Date dateOperation;
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
  @Column(name = "DEBIT")
  private BigDecimal debit;
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
  @Size(min = 1, max = 10)
  @Column(name = "CODE_APPLICATION")
  private String codeApplication;
  @Column(name = "IS_SAISIE")
  private Boolean isSaisie;
  @Column(name = "UTILISATEUR")
  private Integer utilisateur;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;

  public Journal() {}

  public Journal(Integer id) {
    this.id = id;
  }

  public Journal(Integer id, int dateTrt, String cptScf, String cptPart, String codeMonnaie,
      String codeApplication) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.cptScf = cptScf;
    this.cptPart = cptPart;
    this.codeMonnaie = codeMonnaie;
    this.codeApplication = codeApplication;
  }

  public Journal(Integer id, Integer orderId, String cptUnite, int dateTrt, Date dateOperation,
      String cptScf, String cptPart, String libelle, BigDecimal debit, BigDecimal credit,
      String codeMonnaie, String numPiece, String numPage, String numJournal,
      String codeApplication, Boolean isSaisie, Integer utilisateur, Date dateSaisie) {
    this.id = id;
    this.orderId = orderId;
    this.cptUnite = cptUnite;
    this.dateTrt = dateTrt;
    this.dateOperation = dateOperation;
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
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
    this.dateSaisie = dateSaisie;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Date getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(Date dateOperation) {
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

  public Boolean getIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(Boolean isSaisie) {
    this.isSaisie = isSaisie;
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
    if (!(object instanceof Journal)) {
      return false;
    }
    Journal other = (Journal) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  /**
   * Permet de mapper un objec en EcritureJournal
   * 
   * @param journal
   * 
   * @return EcritureJournal
   */
  public EcritureJournal toEcriture() {

    EcritureJournal ecriture =
        new EcritureJournal(this.getId(), this.getOrderId(), this.getCptUnite(), this.getDateTrt(),
            this.getDateOperation(), this.getCptScf() + "" + this.getCptPart(), this.getLibelle(),
            this.getDebit(), this.getCredit(), this.getCodeMonnaie(), this.getNumPiece(),
            this.getNumPage(), this.getNumJournal(), this.getCodeApplication(), this.getIsSaisie(),
            this.getUtilisateur(), this.getDateSaisie());

    if (this.getCredit().compareTo(BigDecimal.ZERO) != 0
        && this.getDebit().compareTo(BigDecimal.ZERO) == 0) {
      ecriture.setTypeOperation(2);
      ecriture.setMontant(this.getCredit());
    } else if (this.getDebit().compareTo(BigDecimal.ZERO) != 0
        && this.getCredit().compareTo(BigDecimal.ZERO) == 0) {
      ecriture.setTypeOperation(1);
      ecriture.setMontant(this.getDebit());
    } else {
      ecriture.setMontant(BigDecimal.ZERO);
    }

    if (ecriture.getNumPage() == null || ecriture.getNumPage().isEmpty()) {
      ecriture.setNumPage("noPage");
    }

    while (ecriture.getCodeMonnaie().charAt(0) == '0') {
      ecriture.setCodeMonnaie(ecriture.getCodeMonnaie().substring(1));
    }

    return ecriture;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.bean.journal.Journal{" + "id=" + id + ", orderId=" + orderId
        + ", cptUnite=" + cptUnite + ", dateTrt=" + dateTrt + ", dateOperation=" + dateOperation
        + ", cptScf=" + cptScf + ", cptPart=" + cptPart + ", libelle=" + libelle + ", debit="
        + debit + ", credit=" + credit + ", codeMonnaie=" + codeMonnaie + ", numPiece=" + numPiece
        + ", numPage=" + numPage + ", numJournal=" + numJournal + ", codeApplication="
        + codeApplication + ", isSaisie=" + isSaisie + ", utilisateur=" + utilisateur
        + ", dateSaisie=" + dateSaisie + '}';
  }

}
