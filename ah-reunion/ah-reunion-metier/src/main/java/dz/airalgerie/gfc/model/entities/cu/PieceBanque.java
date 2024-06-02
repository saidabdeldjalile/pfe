/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(schema = "CU", name = "PIECE_BANQUE")
@NamedQueries({@NamedQuery(name = "PieceBanque.findAll", query = "SELECT p FROM PieceBanque p"),
    @NamedQuery(name = "PieceBanque.findById",
        query = "SELECT p FROM PieceBanque p WHERE p.id = :id"),
    @NamedQuery(name = "PieceBanque.findByDateTrt",
        query = "SELECT p FROM PieceBanque p WHERE p.dateTrt = :dateTrt"),
    @NamedQuery(name = "PieceBanque.findByDatePiece",
        query = "SELECT p FROM PieceBanque p WHERE p.datePiece = :datePiece"),
    @NamedQuery(name = "PieceBanque.findByTypeOperation",
        query = "SELECT p FROM PieceBanque p WHERE p.typeOperation = :typeOperation"),
    @NamedQuery(name = "PieceBanque.findByDecade",
        query = "SELECT p FROM PieceBanque p WHERE p.decade = :decade"),
    @NamedQuery(name = "PieceBanque.findByDateSaisie",
        query = "SELECT p FROM PieceBanque p WHERE p.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "PieceBanque.findByLibelle",
        query = "SELECT p FROM PieceBanque p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "PieceBanque.findByLibelleComp",
        query = "SELECT p FROM PieceBanque p WHERE p.libelleComp = :libelleComp")})
public class PieceBanque implements Serializable {

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
  @Column(name = "DATE_PIECE")
  @Temporal(TemporalType.DATE)
  private Date datePiece;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TYPE_OPERATION")
  private Character typeOperation;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DECADE")
  private Character decade;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 255)
  @Column(name = "LIBELLE_COMP")
  private String libelleComp;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;
  @Column(name = "UTILISATEUR")
  private String utilisateur;
  @Column(name = "MONTANT_TOTAL")
  private BigDecimal montantTotal;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pieceBanque",
      fetch = FetchType.LAZY)
  private List<PieceBanqueDetails> pieceBanqueDetailsList;
  @JoinColumn(name = "ID_CAISSE_BANQUE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CaisseBanque caisseBanque;

  public PieceBanque() {
    isSaisie = true;
  }

  public PieceBanque(Integer id) {
    this.id = id;
    isSaisie = true;
  }

  public PieceBanque(Integer id, int dateTrt, Date datePiece, Character typeOperation,
      Character decade, Date dateSaisie, String libelle, String libelleComp,
      CaisseBanque caisseBanque) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.typeOperation = typeOperation;
    this.decade = decade;
    this.dateSaisie = dateSaisie;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.caisseBanque = caisseBanque;
  }

  public PieceBanque(Integer id, int dateTrt, Date datePiece, Character typeOperation,
      Character decade, Date dateSaisie, String libelle, String libelleComp,
      CaisseBanque caisseBanque, boolean isSaisie, String utilisateur) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.typeOperation = typeOperation;
    this.decade = decade;
    this.dateSaisie = dateSaisie;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.caisseBanque = caisseBanque;
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
  }

  public PieceBanque(Integer id, int dateTrt, Date datePiece, Character typeOperation,
      Character decade, Date dateSaisie, String libelle, String libelleComp,
      CaisseBanque caisseBanque, boolean isSaisie, String utilisateur, BigDecimal montantTotal) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.datePiece = datePiece;
    this.typeOperation = typeOperation;
    this.decade = decade;
    this.dateSaisie = dateSaisie;
    this.libelle = libelle;
    this.libelleComp = libelleComp;
    this.caisseBanque = caisseBanque;
    this.isSaisie = isSaisie;
    this.utilisateur = utilisateur;
    this.montantTotal = montantTotal;
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

  public Date getDatePiece() {
    return datePiece;
  }

  public void setDatePiece(Date datePiece) {
    this.datePiece = datePiece;
  }

  public Character getTypeOperation() {
    return typeOperation;
  }

  public void setTypeOperation(Character typeOperation) {
    this.typeOperation = typeOperation;
  }

  public Character getDecade() {
    return decade;
  }

  public void setDecade(Character decade) {
    this.decade = decade;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
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

  public List<PieceBanqueDetails> getPieceBanqueDetailsList() {
    return pieceBanqueDetailsList;
  }

  public void setPieceBanqueDetailsList(List<PieceBanqueDetails> pieceBanqueDetailsList) {
    this.pieceBanqueDetailsList = pieceBanqueDetailsList;
  }

  public CaisseBanque getCaisseBanque() {
    return caisseBanque;
  }

  public void setCaisseBanque(CaisseBanque caisseBanque) {
    this.caisseBanque = caisseBanque;
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

  public BigDecimal getMontantTotal() {
    return montantTotal;
  }

  public void setMontantTotal(BigDecimal montantTotal) {
    this.montantTotal = montantTotal;
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
    if (!(object instanceof PieceBanque)) {
      return false;
    }
    PieceBanque other = (PieceBanque) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.PieceBanque[ id=" + id + " ]";
  }

}
