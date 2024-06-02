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
@Table(name = "FACTURE_PAIEMENT", schema = ErpConstante.DbSchemaName.CPTA_FAC)
@NamedQueries({
    @NamedQuery(name = "FacturePaiement.findAll", query = "SELECT f FROM FacturePaiement f")})
public class FacturePaiement implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT")
  private BigDecimal montant;
  @JoinColumn(name = "ID_FACTURE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private FactureFac factureFac;
  @JoinColumn(name = "ID_METHODE_PAIEMENT", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private MethodePaiement methodePaiement;

  public FacturePaiement() {
  }

  public FacturePaiement(Integer id) {
    this.id = id;
  }

  public FacturePaiement(Integer id, BigDecimal montant) {
    this.id = id;
    this.montant = montant;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public FactureFac getFactureFac() {
    return factureFac;
  }

  public void setFactureFac(FactureFac factureFac) {
    this.factureFac = factureFac;
  }

  public MethodePaiement getMethodePaiement() {
    return methodePaiement;
  }

  public void setMethodePaiement(MethodePaiement methodePaiement) {
    this.methodePaiement = methodePaiement;
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
    if (!(object instanceof FacturePaiement)) {
      return false;
    }
    FacturePaiement other = (FacturePaiement) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.fac.FacturePaiement[ id=" + id + " ]";
  }

}
