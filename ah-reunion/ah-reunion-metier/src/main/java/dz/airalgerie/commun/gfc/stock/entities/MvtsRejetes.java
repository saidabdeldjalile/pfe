/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.MVTS_REJETES")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "MvtsRejetes.findAll", query = "SELECT m FROM MvtsRejetes m"),
    @NamedQuery(name = "MvtsRejetes.findByPn",
        query = "SELECT m FROM MvtsRejetes m WHERE m.mvtsRejetesPK.pn = :pn"),
    @NamedQuery(name = "MvtsRejetes.findByCodeAppareil",
        query = "SELECT m FROM MvtsRejetes m WHERE m.mvtsRejetesPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "MvtsRejetes.findByNumBonSortie",
        query = "SELECT m FROM MvtsRejetes m WHERE m.mvtsRejetesPK.numBonSortie = :numBonSortie"),
    @NamedQuery(name = "MvtsRejetes.findByDateTraitSortie",
        query = "SELECT m FROM MvtsRejetes m WHERE m.mvtsRejetesPK.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "MvtsRejetes.findByQuantiteMVTS",
        query = "SELECT m FROM MvtsRejetes m WHERE m.quantiteMVTS = :quantiteMVTS"),
    @NamedQuery(name = "MvtsRejetes.findByValeurMVTS",
        query = "SELECT m FROM MvtsRejetes m WHERE m.valeurMVTS = :valeurMVTS"),
    @NamedQuery(name = "MvtsRejetes.findByQuantiteSTK",
        query = "SELECT m FROM MvtsRejetes m WHERE m.quantiteSTK = :quantiteSTK"),
    @NamedQuery(name = "MvtsRejetes.findByValeurSTK",
        query = "SELECT m FROM MvtsRejetes m WHERE m.valeurSTK = :valeurSTK")})
public class MvtsRejetes implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected MvtsRejetesPK mvtsRejetesPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantiteMVTS")
  private BigDecimal quantiteMVTS;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeurMVTS")
  private BigDecimal valeurMVTS;
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantiteSTK")
  private BigDecimal quantiteSTK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeurSTK")
  private BigDecimal valeurSTK;

  public MvtsRejetes() {}

  public MvtsRejetes(MvtsRejetesPK mvtsRejetesPK) {
    this.mvtsRejetesPK = mvtsRejetesPK;
  }

  public MvtsRejetes(MvtsRejetesPK mvtsRejetesPK, BigDecimal quantiteMVTS, BigDecimal valeurMVTS,
      BigDecimal quantiteSTK, BigDecimal valeurSTK) {
    this.mvtsRejetesPK = mvtsRejetesPK;
    this.quantiteMVTS = quantiteMVTS;
    this.valeurMVTS = valeurMVTS;
    this.quantiteSTK = quantiteSTK;
    this.valeurSTK = valeurSTK;
  }

  public MvtsRejetes(String pn, String codeAppareil, String numBonSortie, int dateTraitSortie) {
    this.mvtsRejetesPK = new MvtsRejetesPK(pn, codeAppareil, numBonSortie, dateTraitSortie);
  }

  public MvtsRejetesPK getMvtsRejetesPK() {
    return mvtsRejetesPK;
  }

  public void setMvtsRejetesPK(MvtsRejetesPK mvtsRejetesPK) {
    this.mvtsRejetesPK = mvtsRejetesPK;
  }

  public BigDecimal getQuantiteMVTS() {
    return quantiteMVTS;
  }

  public void setQuantiteMVTS(BigDecimal quantiteMVTS) {
    this.quantiteMVTS = quantiteMVTS;
  }

  public BigDecimal getValeurMVTS() {
    return valeurMVTS;
  }

  public void setValeurMVTS(BigDecimal valeurMVTS) {
    this.valeurMVTS = valeurMVTS;
  }

  public BigDecimal getQuantiteSTK() {
    return quantiteSTK;
  }

  public void setQuantiteSTK(BigDecimal quantiteSTK) {
    this.quantiteSTK = quantiteSTK;
  }

  public BigDecimal getValeurSTK() {
    return valeurSTK;
  }

  public void setValeurSTK(BigDecimal valeurSTK) {
    this.valeurSTK = valeurSTK;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (mvtsRejetesPK != null ? mvtsRejetesPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MvtsRejetes)) {
      return false;
    }
    MvtsRejetes other = (MvtsRejetes) object;
    if ((this.mvtsRejetesPK == null && other.mvtsRejetesPK != null)
        || (this.mvtsRejetesPK != null && !this.mvtsRejetesPK.equals(other.mvtsRejetesPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.MvtsRejetes[ mvtsRejetesPK=" + mvtsRejetesPK + " ]";
  }

}
