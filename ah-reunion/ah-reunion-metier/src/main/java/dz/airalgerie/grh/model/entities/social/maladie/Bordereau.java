/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.grh.maladie.entities.Remboursement;
import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "BORDEREAU", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Bordereau.findAll", query = "SELECT b FROM Bordereau b"),
    @NamedQuery(name = "Bordereau.findByNumCheque",
        query = "SELECT b FROM Bordereau b WHERE b.bordereauPK.numCheque = :numCheque"),
    @NamedQuery(name = "Bordereau.findByNumBdx",
        query = "SELECT b FROM Bordereau b WHERE b.bordereauPK.numBdx = :numBdx"),
    @NamedQuery(name = "Bordereau.findByDatePai",
        query = "SELECT b FROM Bordereau b WHERE b.bordereauPK.datePai = :datePai"),
    @NamedQuery(name = "Bordereau.findByMontBdx",
        query = "SELECT b FROM Bordereau b WHERE b.montBdx = :montBdx"),
    @NamedQuery(name = "Bordereau.findByDateSaise",
        query = "SELECT b FROM Bordereau b WHERE b.dateSaise = :dateSaise")})
public class Bordereau implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BordereauPK bordereauPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONT_BDX")
  private BigDecimal montBdx;
  @Column(name = "DATE_SAISE")
  @Temporal(TemporalType.DATE)
  private Date dateSaise;
  @JoinColumns({
      @JoinColumn(name = "NUM_CHEQUE", referencedColumnName = "NUM_CHEQUE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Cheque cheque;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bordereau", fetch = FetchType.LAZY)
  private List<Remboursement> remboursementList;

  public Bordereau() {
  }

  public Bordereau(BordereauPK bordereauPK) {
    this.bordereauPK = bordereauPK;
  }

  public Bordereau(BordereauPK bordereauPK, BigDecimal montBdx) {
    this.bordereauPK = bordereauPK;
    this.montBdx = montBdx;
  }

  public Bordereau(String numCheque, String numBdx, int datePai) {
    this.bordereauPK = new BordereauPK(numCheque, numBdx, datePai);
  }

  public BordereauPK getBordereauPK() {
    return bordereauPK;
  }

  public void setBordereauPK(BordereauPK bordereauPK) {
    this.bordereauPK = bordereauPK;
  }

  public BigDecimal getMontBdx() {
    return montBdx;
  }

  public void setMontBdx(BigDecimal montBdx) {
    this.montBdx = montBdx;
  }

  public Date getDateSaise() {
    return dateSaise;
  }

  public void setDateSaise(Date dateSaise) {
    this.dateSaise = dateSaise;
  }

  public Cheque getCheque() {
    return cheque;
  }

  public void setCheque(Cheque cheque) {
    this.cheque = cheque;
  }

  public List<Remboursement> getRemboursementList() {
    return remboursementList;
  }

  public void setRemboursementList(List<Remboursement> remboursementList) {
    this.remboursementList = remboursementList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bordereauPK != null ? bordereauPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Bordereau)) {
      return false;
    }
    Bordereau other = (Bordereau) object;
    if ((this.bordereauPK == null && other.bordereauPK != null)
        || (this.bordereauPK != null && !this.bordereauPK.equals(other.bordereauPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Bordereau[ bordereauPK=" + bordereauPK + " ]";
  }

}
