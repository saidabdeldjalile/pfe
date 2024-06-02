/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import dz.airalgerie.grh.model.dto.rem.PaieInfosReport;
import dz.airalgerie.portail.model.dto.bkr.TauxChangeBkr;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "TAUX_CHANGE_GLOBAL", schema = "CHANGE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "TauxDeChange.findAll", query = "SELECT t FROM TauxDeChange t"),
    @NamedQuery(name = "TauxDeChange.findByDateTraitement",
        query = "SELECT t FROM TauxDeChange t WHERE t.dateTraitement = :dateTraitement"),
    @NamedQuery(name = "TauxDeChange.findByValeur",
        query = "SELECT t FROM TauxDeChange t WHERE t.valeur = :valeur")})
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "TauxChangeBrkMapping",
        classes = @ConstructorResult(targetClass = TauxChangeBkr.class,
            columns = {@ColumnResult(name = "CODE_ALPH_NUM", type = String.class),
                @ColumnResult(name = "VALEUR", type = String.class)}))})
public class TauxDeChange implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private TauxPK TauxPK;

  // @Basic(optional = false)
  // @NotNull
  // @Column(name = "DATE_TRAITEMENT")
  // @Temporal(TemporalType.DATE)
  private int dateTraitement;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation

  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR")
  @Digits(integer = 15, fraction = 7)
  private BigDecimal valeur;

  @Column(name = "VALEUR_USD")
  private BigDecimal valeurUSD;

  public TauxDeChange() {}

  public TauxDeChange(int dateTraitement, BigDecimal valeur) {
    this.dateTraitement = dateTraitement;
    this.valeur = valeur;
  }

  public TauxPK getTauxPK() {
    return TauxPK;
  }

  public void setTauxPK(TauxPK TauxPK) {
    this.TauxPK = TauxPK;
  }

  // public int getDateTraitement() {
  // return dateTraitement;
  // }
  //
  // public void setDateTraitement(int dateTraitement) {
  // this.dateTraitement = dateTraitement;
  // }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public BigDecimal getValeurUSD() {
    return valeurUSD;
  }

  public void setValeurUSD(BigDecimal valeurUSD) {
    this.valeurUSD = valeurUSD;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (TauxPK != null ? TauxPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TauxDeChange)) {
      return false;
    }
    TauxDeChange other = (TauxDeChange) object;
    if ((this.TauxPK == null && other.TauxPK != null)
        || (this.TauxPK != null && !this.TauxPK.equals(other.TauxPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.dsi.immo.model.TauxDeChange[ TauxPK=" + TauxPK + " ]";
  }

}
