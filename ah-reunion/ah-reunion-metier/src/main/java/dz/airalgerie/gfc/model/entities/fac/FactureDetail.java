/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.fac;

import dz.airalgerie.commun.utils.ErpConstante;
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
 */
@Entity
@Table(name = "FACTURE_DETAIL", schema = ErpConstante.DbSchemaName.CPTA_FAC)
@NamedQueries({
    @NamedQuery(name = "FactureDetail.findAll", query = "SELECT f FROM FactureDetail f")})
public class FactureDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NATURE")
  private Character nature;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "QUANTITE")
  private BigDecimal quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "PRIX_UNITAIRE_HT")
  private BigDecimal prixUnitaireHt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT_HT")
  private BigDecimal montantHt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT_TOTAL")
  private BigDecimal montantTotal;
  @Basic(optional = false)
  @Column(name = "NUM_LIGNE")
  private short numLigne;
  @JoinColumn(name = "ID_FACTURE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private FactureFac factureFac;
  @JoinColumn(name = "ID_TAXE", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private TaxeFac taxe;

  public FactureDetail() {
  }

  public FactureDetail(Integer id) {
    this.id = id;
  }

  public FactureDetail(Integer id, Character nature, String libelle, BigDecimal quantite,
      BigDecimal prixUnitaireHt, BigDecimal montantHt, BigDecimal montantTotal) {
    this.id = id;
    this.nature = nature;
    this.libelle = libelle;
    this.quantite = quantite;
    this.prixUnitaireHt = prixUnitaireHt;
    this.montantHt = montantHt;
    this.montantTotal = montantTotal;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Character getNature() {
    return nature;
  }

  public void setNature(Character nature) {
    this.nature = nature;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getPrixUnitaireHt() {
    return prixUnitaireHt;
  }

  public void setPrixUnitaireHt(BigDecimal prixUnitaireHt) {
    this.prixUnitaireHt = prixUnitaireHt;
  }

  public BigDecimal getMontantHt() {
    return montantHt;
  }

  public void setMontantHt(BigDecimal montantHt) {
    this.montantHt = montantHt;
  }

  public BigDecimal getMontantTotal() {
    return montantTotal;
  }

  public void setMontantTotal(BigDecimal montantTotal) {
    this.montantTotal = montantTotal;
  }

  public short getNumLigne() {
    return numLigne;
  }

  public void setNumLigne(short numLigne) {
    this.numLigne = numLigne;
  }

  public FactureFac getFactureFac() {
    return factureFac;
  }

  public void setFactureFac(FactureFac factureFac) {
    this.factureFac = factureFac;
  }

  public TaxeFac getTaxe() {
    return taxe;
  }

  public void setTaxe(TaxeFac taxe) {
    this.taxe = taxe;
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
    if (!(object instanceof FactureDetail)) {
      return false;
    }
    FactureDetail other = (FactureDetail) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.FactureDetail[ id=" + id + " ]";
  }

}
