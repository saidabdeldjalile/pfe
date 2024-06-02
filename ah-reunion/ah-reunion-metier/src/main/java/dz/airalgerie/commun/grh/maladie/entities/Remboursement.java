/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import dz.airalgerie.grh.model.entities.commun.Personnel;
import dz.airalgerie.grh.model.entities.social.maladie.Bordereau;
import dz.airalgerie.grh.model.entities.social.maladie.Cheque;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "REMBOURSEMENT", schema = "MLD")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Remboursement.findAll", query = "SELECT r FROM Remboursement r"),
    @NamedQuery(name = "Remboursement.findByMatricule",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.matricule = :matricule"),
    @NamedQuery(name = "Remboursement.findByDatePai",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.datePai = :datePai"),
    @NamedQuery(name = "Remboursement.findByNumCheque",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.numCheque = :numCheque"),
    @NamedQuery(name = "Remboursement.findByNumBordereau",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.numBordereau = :numBordereau"),
    @NamedQuery(name = "Remboursement.findByCodeRub",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.codeRub = :codeRub"),
    @NamedQuery(name = "Remboursement.findByIdMontant",
        query = "SELECT r FROM Remboursement r WHERE r.remboursementPK.idMontant = :idMontant"),
    @NamedQuery(name = "Remboursement.findByValMontant",
        query = "SELECT r FROM Remboursement r WHERE r.valMontant = :valMontant"),
    @NamedQuery(name = "Remboursement.findByDateSaise",
        query = "SELECT r FROM Remboursement r WHERE r.dateSaise = :dateSaise")})
public class Remboursement implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RemboursementPK remboursementPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "VAL_MONTANT")
  private BigDecimal valMontant;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaise;
  @JoinColumns({
      @JoinColumn(name = "NUM_BDX", referencedColumnName = "NUM_BDX", insertable = false,
          updatable = false),
      @JoinColumn(name = "NUM_CHEQUE", referencedColumnName = "NUM_CHEQUE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Bordereau bordereau;
  @JoinColumns({
      @JoinColumn(name = "NUM_CHEQUE", referencedColumnName = "NUM_CHEQUE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Cheque cheque;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;

  public Remboursement() {
  }

  public Remboursement(RemboursementPK remboursementPK) {
    this.remboursementPK = remboursementPK;
  }

  public Remboursement(int matricule, int datePai, String numCheque, String numBordereau,
      String codeRub, int idMontant) {
    this.remboursementPK =
        new RemboursementPK(matricule, datePai, numCheque, numBordereau, codeRub, idMontant);
  }

  public RemboursementPK getRemboursementPK() {
    return remboursementPK;
  }

  public void setRemboursementPK(RemboursementPK remboursementPK) {
    this.remboursementPK = remboursementPK;
  }

  public BigDecimal getValMontant() {
    return valMontant;
  }

  public void setValMontant(BigDecimal valMontant) {
    this.valMontant = valMontant;
  }

  public Date getDateSaise() {
    return dateSaise;
  }

  public void setDateSaise(Date dateSaise) {
    this.dateSaise = dateSaise;
  }

  public Bordereau getBordereau() {
    return bordereau;
  }

  public void setBordereau(Bordereau bordereau) {
    this.bordereau = bordereau;
  }

  public Cheque getCheque() {
    return cheque;
  }

  public void setCheque(Cheque cheque) {
    this.cheque = cheque;
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (remboursementPK != null ? remboursementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Remboursement)) {
      return false;
    }
    Remboursement other = (Remboursement) object;
    if ((this.remboursementPK == null && other.remboursementPK != null)
        || (this.remboursementPK != null && !this.remboursementPK.equals(other.remboursementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Remboursement[ remboursementPK=" + remboursementPK + " ]";
  }

}
