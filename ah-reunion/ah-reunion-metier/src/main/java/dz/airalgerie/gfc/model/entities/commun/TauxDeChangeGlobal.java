
package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "TAUX_CHANGE_GLOBAL", schema = "CHANGE")
@XmlRootElement

public class TauxDeChangeGlobal implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected TauxDeChangeGlobalPK TauxDeChangeGlobalPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR_USD")
  private BigDecimal valeurUsd;
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR_DZD")
  private BigDecimal valeurDzd;
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR")
  private BigDecimal valeur;

  public TauxDeChangeGlobal() {}

  public TauxDeChangeGlobal(TauxDeChangeGlobalPK TauxDeChangeGlobalPK) {
    this.TauxDeChangeGlobalPK = TauxDeChangeGlobalPK;
  }

  public TauxDeChangeGlobal(TauxDeChangeGlobalPK TauxDeChangeGlobalPK, BigDecimal valeur) {
    this.TauxDeChangeGlobalPK = TauxDeChangeGlobalPK;
    this.valeur = valeur;
  }

  public TauxDeChangeGlobal(long monnaieId, int dateTraitement) {
    this.TauxDeChangeGlobalPK = new TauxDeChangeGlobalPK(monnaieId, dateTraitement);
  }

  @Override
  public String toString() {
    return "entity.TauxDeChange[ tauxDeChangePK=" + TauxDeChangeGlobalPK + " ]";
  }

  public TauxDeChangeGlobalPK getTauxDeChangeGlobalPK() {
    return TauxDeChangeGlobalPK;
  }

  public void setTauxDeChangeGlobalPK(TauxDeChangeGlobalPK TauxDeChangeGlobalPK) {
    this.TauxDeChangeGlobalPK = TauxDeChangeGlobalPK;
  }

  public BigDecimal getValeurUsd() {
    return valeurUsd;
  }

  public void setValeurUsd(BigDecimal valeurUsd) {
    this.valeurUsd = valeurUsd;
  }

  public BigDecimal getValeurDzd() {
    return valeurDzd;
  }

  public void setValeurDzd(BigDecimal valeurDzd) {
    this.valeurDzd = valeurDzd;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

}
