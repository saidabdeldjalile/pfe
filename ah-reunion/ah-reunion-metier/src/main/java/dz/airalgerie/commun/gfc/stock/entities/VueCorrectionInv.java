/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.v_correctionInv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VcorrectionInv.findAll", query = "SELECT v FROM VueCorrectionInv v"),
    @NamedQuery(name = "VcorrectionInv.findByQuantite",
        query = "SELECT v FROM VueCorrectionInv v WHERE v.quantite = :quantite")})
public class VueCorrectionInv implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private VueCorrectionInvPK vueCorrectionInvPK;

  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "quantite")
  private BigDecimal quantite;
  @Column(name = "valeur")
  private BigDecimal valeur;

  public VueCorrectionInv() {}

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public VueCorrectionInvPK getVueCorrectionInvPK() {
    return vueCorrectionInvPK;
  }

  public void setVueCorrectionInvPK(VueCorrectionInvPK vueCorrectionInvPK) {
    this.vueCorrectionInvPK = vueCorrectionInvPK;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + Objects.hashCode(this.vueCorrectionInvPK);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VueCorrectionInv other = (VueCorrectionInv) obj;
    if (!Objects.equals(this.vueCorrectionInvPK, other.vueCorrectionInvPK)) {
      return false;
    }
    return true;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

}
