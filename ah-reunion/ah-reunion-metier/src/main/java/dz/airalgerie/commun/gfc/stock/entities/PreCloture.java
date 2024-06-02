/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "STK.preCloture")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "PreCloture.findAll", query = "SELECT p FROM PreCloture p"),
    @NamedQuery(name = "PreCloture.findByPn",
        query = "SELECT p FROM PreCloture p WHERE p.preCloturePK.pn = :pn"),
    @NamedQuery(name = "PreCloture.findByCodeAppareil",
        query = "SELECT p FROM PreCloture p WHERE p.preCloturePK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "PreCloture.findByDateTraitement",
        query = "SELECT p FROM PreCloture p WHERE p.preCloturePK.dateTraitement = :dateTraitement"),
    @NamedQuery(name = "PreCloture.findByQuantite",
        query = "SELECT p FROM PreCloture p WHERE p.quantite = :quantite"),
    @NamedQuery(name = "PreCloture.findByValeur",
        query = "SELECT p FROM PreCloture p WHERE p.valeur = :valeur"),
    @NamedQuery(name = "PreCloture.findByPmp",
        query = "SELECT p FROM PreCloture p WHERE p.pmp = :pmp"),
    @NamedQuery(name = "PreCloture.findByEtat",
        query = "SELECT p FROM PreCloture p WHERE p.etat = :etat"),
    @NamedQuery(name = "PreCloture.findByDateDernierAchat",
        query = "SELECT p FROM PreCloture p WHERE p.dateDernierAchat = :dateDernierAchat"),
    @NamedQuery(name = "PreCloture.findByDateDernierMvt",
        query = "SELECT p FROM PreCloture p WHERE p.dateDernierMvt = :dateDernierMvt"),
    @NamedQuery(name = "PreCloture.findByPmpReint",
        query = "SELECT p FROM PreCloture p WHERE p.pmpReint = :pmpReint")})
public class PreCloture implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected PreCloturePK preCloturePK;
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
  @Basic(optional = false)
  @NotNull
  @Column(name = "pmp")
  private BigDecimal pmp;
  @Basic(optional = false)
  @NotNull
  @Column(name = "etat")
  private int etat;
  @Column(name = "dateDernierAchat")
  @Temporal(TemporalType.DATE)
  private Date dateDernierAchat;
  @Column(name = "dateDernierMvt")
  @Temporal(TemporalType.DATE)
  private Date dateDernierMvt;
  @Column(name = "pmpReint")
  private BigDecimal pmpReint;
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public PreCloture() {}

  public PreCloture(PreCloturePK preCloturePK) {
    this.preCloturePK = preCloturePK;
  }

  public PreCloture(PreCloturePK preCloturePK, BigDecimal quantite, BigDecimal valeur,
      BigDecimal pmp, int etat) {
    this.preCloturePK = preCloturePK;
    this.quantite = quantite;
    this.valeur = valeur;
    this.pmp = pmp;
    this.etat = etat;
  }

  public PreCloture(String pn, String codeAppareil, int dateTraitement) {
    this.preCloturePK = new PreCloturePK(pn, codeAppareil, dateTraitement);
  }

  public PreCloturePK getPreCloturePK() {
    return preCloturePK;
  }

  public void setPreCloturePK(PreCloturePK preCloturePK) {
    this.preCloturePK = preCloturePK;
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

  public BigDecimal getPmp() {
    return pmp;
  }

  public void setPmp(BigDecimal pmp) {
    this.pmp = pmp;
  }

  public int getEtat() {
    return etat;
  }

  public void setEtat(int etat) {
    this.etat = etat;
  }

  public Date getDateDernierAchat() {
    return dateDernierAchat;
  }

  public void setDateDernierAchat(Date dateDernierAchat) {
    this.dateDernierAchat = dateDernierAchat;
  }

  public Date getDateDernierMvt() {
    return dateDernierMvt;
  }

  public void setDateDernierMvt(Date dateDernierMvt) {
    this.dateDernierMvt = dateDernierMvt;
  }

  public BigDecimal getPmpReint() {
    return pmpReint;
  }

  public void setPmpReint(BigDecimal pmpReint) {
    this.pmpReint = pmpReint;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (preCloturePK != null ? preCloturePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PreCloture)) {
      return false;
    }
    PreCloture other = (PreCloture) object;
    if ((this.preCloturePK == null && other.preCloturePK != null)
        || (this.preCloturePK != null && !this.preCloturePK.equals(other.preCloturePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.PreCloture[ preCloturePK=" + preCloturePK + " ]";
  }

}
