/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.grh.model.dto.mld.DTORemboursementsMaladieRecap;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "CHEQUE", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Cheque.findAll", query = "SELECT c FROM Cheque c"),
    @NamedQuery(name = "Cheque.findByNumCheque",
        query = "SELECT c FROM Cheque c WHERE c.chequePK.numCheque = :numCheque"),
    @NamedQuery(name = "Cheque.findByDatePai",
        query = "SELECT c FROM Cheque c WHERE c.chequePK.datePai = :datePai"),
    @NamedQuery(name = "Cheque.findByMontCheq",
        query = "SELECT c FROM Cheque c WHERE c.montCheq = :montCheq"),
    @NamedQuery(name = "Cheque.findByDateSaise",
        query = "SELECT c FROM Cheque c WHERE c.dateSaise = :dateSaise")})
@SqlResultSetMapping(name = "Mld.findRecapRemboursements",
    classes = @ConstructorResult(targetClass = DTORemboursementsMaladieRecap.class,
        columns = {@ColumnResult(name = "DATE_PAI", type = int.class),
            @ColumnResult(name = "NUM_CHEQUE", type = String.class),
            @ColumnResult(name = "MONT_CHEQ", type = BigDecimal.class),
            @ColumnResult(name = "NUM_BDX", type = String.class),
            @ColumnResult(name = "MONT_BDX", type = BigDecimal.class),
            @ColumnResult(name = "MONTANT_REMB", type = BigDecimal.class),
            @ColumnResult(name = "MONTANT_REMB_MATRICULE", type = BigDecimal.class)}))
public class Cheque implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ChequePK chequePK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_CHEQ")
  private BigDecimal montCheq;
  @Column(name = "DATE_SAISE")
  @Temporal(TemporalType.DATE)
  private Date dateSaise;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cheque", fetch = FetchType.LAZY)
  private List<Bordereau> bordereauList;

  public Cheque() {
  }

  public Cheque(ChequePK chequePK) {
    this.chequePK = chequePK;
  }

  public Cheque(String numCheque, int datePai) {
    this.chequePK = new ChequePK(numCheque, datePai);
  }

  public ChequePK getChequePK() {
    return chequePK;
  }

  public void setChequePK(ChequePK chequePK) {
    this.chequePK = chequePK;
  }

  public BigDecimal getMontCheq() {
    return montCheq;
  }

  public void setMontCheq(BigDecimal montCheq) {
    this.montCheq = montCheq;
  }

  public Date getDateSaise() {
    return dateSaise;
  }

  public void setDateSaise(Date dateSaise) {
    this.dateSaise = dateSaise;
  }

  @XmlTransient
  public List<Bordereau> getBordereauList() {
    return bordereauList;
  }

  public void setBordereauList(List<Bordereau> bordereauList) {
    this.bordereauList = bordereauList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (chequePK != null ? chequePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cheque)) {
      return false;
    }
    Cheque other = (Cheque) object;
    if ((this.chequePK == null && other.chequePK != null)
        || (this.chequePK != null && !this.chequePK.equals(other.chequePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Cheque[ chequePK=" + chequePK + " ]";
  }

}
