/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.dto.cu.DTOJournalCaisse;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "PIECE_CAISSE")
@NamedQueries({@NamedQuery(name = "PieceCaisse.findAll", query = "SELECT p FROM PieceCaisse p"),
    @NamedQuery(name = "PieceCaisse.findById",
        query = "SELECT p FROM PieceCaisse p WHERE p.id = :id"),
    @NamedQuery(name = "PieceCaisse.findByTypeOperation",
        query = "SELECT p FROM PieceCaisse p WHERE p.typeOperation = :typeOperation"),
    @NamedQuery(name = "PieceCaisse.findByDateTrt",
        query = "SELECT p FROM PieceCaisse p WHERE p.dateTrt = :dateTrt"),
    @NamedQuery(name = "PieceCaisse.findByDatePiece",
        query = "SELECT p FROM PieceCaisse p WHERE p.datePiece = :datePiece"),
    @NamedQuery(name = "PieceCaisse.findByDecade",
        query = "SELECT p FROM PieceCaisse p WHERE p.decade = :decade"),
    @NamedQuery(name = "PieceCaisse.findByLibelle",
        query = "SELECT p FROM PieceCaisse p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "PieceCaisse.findByLibelleComp",
        query = "SELECT p FROM PieceCaisse p WHERE p.libelleComp = :libelleComp"),
    @NamedQuery(name = "PieceCaisse.findByDateSaisie",
        query = "SELECT p FROM PieceCaisse p WHERE p.dateSaisie = :dateSaisie")})
@SqlResultSetMapping(name = "PieceCaisse.findJournalCaisse",
    classes = @ConstructorResult(targetClass = DTOJournalCaisse.class,
        columns = {@ColumnResult(name = "CODE_CAISSE", type = Integer.class),
            @ColumnResult(name = "DATE_TRT", type = Date.class),
            @ColumnResult(name = "LIBELLE", type = String.class),
            @ColumnResult(name = "RECETTE", type = BigDecimal.class),
            @ColumnResult(name = "DEPENSE", type = BigDecimal.class)}))
public class PieceCaisse implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TYPE_OPERATION")
  private Character typeOperation;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PIECE")
  @Temporal(TemporalType.DATE)
  private Date datePiece;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DECADE")
  private Character decade;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 255)
  @Column(name = "LIBELLE_COMP")
  private String libelleComp;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;
  @Column(name = "UTILISATEUR")
  private String utilisateur;
  @Column(name = "IS_COMPTA")
  private boolean isCompta;
  @Column(name = "MONTANT_TOTAL")
  private BigDecimal montantTotal;
  @Column(name = "IS_UPLOAD")
  private boolean isUpload;
  @JoinColumn(name = "CODE_CAISSE", referencedColumnName = "CODE_CAISSE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Caisse codeCaisse;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pieceCaisse",
      fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<PieceCaisseDetails> pieceCaisseDetailsList;

  public PieceCaisse() {
    isSaisie = true;
  }

  public PieceCaisse(Integer id) {
    this.id = id;
    isSaisie = true;
  }

  public PieceCaisse(Integer id, Character typeOperation, int dateTrt, Date datePiece,
      Character decade, String libelle, String libelleComp, Date dateSaisie, Caisse codeCaisse) {
    this.id = id;
    this.typeOperation = typeOperation;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.decade = decade;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.dateSaisie = dateSaisie;
    this.codeCaisse = codeCaisse;
  }

  public PieceCaisse(Integer id, Character typeOperation, int dateTrt, Date datePiece,
      Character decade, String libelle, String libelleComp, Date dateSaisie, Caisse codeCaisse,
      boolean isSaisie, String utilisateur, boolean isCompta) {
    this.id = id;
    this.typeOperation = typeOperation;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.decade = decade;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.dateSaisie = dateSaisie;
    this.codeCaisse = codeCaisse;
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
    this.isCompta = isCompta;
  }

  public PieceCaisse(Integer id, Character typeOperation, int dateTrt, Date datePiece,
      Character decade, String libelle, String libelleComp, Date dateSaisie, Caisse codeCaisse,
      boolean isSaisie, String utilisateur, boolean isCompta, BigDecimal montantTotal) {
    this.id = id;
    this.typeOperation = typeOperation;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.decade = decade;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.dateSaisie = dateSaisie;
    this.codeCaisse = codeCaisse;
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
    this.isCompta = isCompta;
    this.montantTotal = montantTotal;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Character getTypeOperation() {
    return typeOperation;
  }

  public void setTypeOperation(Character typeOperation) {
    this.typeOperation = typeOperation;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Date getDatePiece() {
    return datePiece;
  }

  public void setDatePiece(Date datePiece) {
    this.datePiece = datePiece;
  }

  public Character getDecade() {
    return decade;
  }

  public void setDecade(Character decade) {
    this.decade = decade;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getLibelleComp() {
    return libelleComp;
  }

  public void setLibelleComp(String libelleComp) {
    this.libelleComp = libelleComp;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Caisse getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Caisse codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public List<PieceCaisseDetails> getPieceCaisseDetailsList() {
    return pieceCaisseDetailsList;
  }

  public void setPieceCaisseDetailsList(List<PieceCaisseDetails> pieceCaisseDetailsList) {
    this.pieceCaisseDetailsList = pieceCaisseDetailsList;
  }

  public boolean isIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  public String getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(String utilisateur) {
    this.utilisateur = utilisateur;
  }

  public boolean isIsCompta() {
    return isCompta;
  }

  public void setIsCompta(boolean isCompta) {
    this.isCompta = isCompta;
  }

  public BigDecimal getMontantTotal() {
    return montantTotal;
  }

  public void setMontantTotal(BigDecimal montantTotal) {
    this.montantTotal = montantTotal;
  }

  public boolean isIsUpload() {
    return isUpload;
  }

  public void setIsUpload(boolean isUpload) {
    this.isUpload = isUpload;
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
    if (!(object instanceof PieceCaisse)) {
      return false;
    }
    PieceCaisse other = (PieceCaisse) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.PieceCaisse[ id=" + id + " ]";
  }

}
