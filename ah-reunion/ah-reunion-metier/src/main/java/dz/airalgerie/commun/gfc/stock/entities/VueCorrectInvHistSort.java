/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
@Table(name = "STK.v_correctInvHistSort")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VcorrectInvHistSort.findAll",
        query = "SELECT v FROM VueCorrectInvHistSort v"),
    @NamedQuery(name = "VcorrectInvHistSort.findByQuantite",
        query = "SELECT v FROM VueCorrectInvHistSort v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "VcorrectInvHistSort.findByValeur",
        query = "SELECT v FROM VueCorrectInvHistSort v WHERE v.valeur = :valeur")})
public class VueCorrectInvHistSort implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private VueCorrectInvHistSortPK VueCorrectInvHistSortPK;

  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantite")
  private BigDecimal quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeur")
  private BigDecimal valeur;

  public VueCorrectInvHistSort() {}

  public VueCorrectInvHistSort(VueCorrectInvHistSortPK VueCorrectInvHistSortPK, BigDecimal quantite,
      BigDecimal valeur) {
    this.VueCorrectInvHistSortPK = VueCorrectInvHistSortPK;
    this.quantite = quantite;
    this.valeur = valeur;

  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.VueCorrectInvHistSortPK);
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
    final VueCorrectInvHistSort other = (VueCorrectInvHistSort) obj;
    if (!Objects.equals(this.VueCorrectInvHistSortPK, other.VueCorrectInvHistSortPK)) {
      return false;
    }
    return true;
  }

}
