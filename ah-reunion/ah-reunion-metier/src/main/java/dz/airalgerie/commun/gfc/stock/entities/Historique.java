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
@Table(name = "STK.historique")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h"),
    @NamedQuery(name = "Historique.findByPn",
        query = "SELECT h FROM Historique h WHERE h.historiquePK.pn = :pn"),
    @NamedQuery(name = "Historique.findByCodeAppareil",
        query = "SELECT h FROM Historique h WHERE h.historiquePK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "Historique.findByDateTraitement",
        query = "SELECT h FROM Historique h WHERE h.historiquePK.dateTraitement = :dateTraitement"),
    @NamedQuery(name = "Historique.findByQuantite",
        query = "SELECT h FROM Historique h WHERE h.quantite = :quantite"),
    @NamedQuery(name = "Historique.findByValeur",
        query = "SELECT h FROM Historique h WHERE h.valeur = :valeur"),
    @NamedQuery(name = "Historique.findByPmp",
        query = "SELECT h FROM Historique h WHERE h.pmp = :pmp"),
    @NamedQuery(name = "Historique.findByEtat",
        query = "SELECT h FROM Historique h WHERE h.etat = :etat"),
    @NamedQuery(name = "Historique.findByDateDernierAchat",
        query = "SELECT h FROM Historique h WHERE h.dateDernierAchat = :dateDernierAchat"),
    @NamedQuery(name = "Historique.findByDateDernierMvt",
        query = "SELECT h FROM Historique h WHERE h.dateDernierMvt = :dateDernierMvt")})
public class Historique implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected HistoriquePK historiquePK;
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
  // @Basic(optional = false)
  // @NotNull
  @Column(name = "pmpReint")
  private BigDecimal pmpReint;
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
  @JoinColumns({
      @JoinColumn(name = "pn", referencedColumnName = "pn", insertable = false, updatable = false),
      @JoinColumn(name = "codeAppareil", referencedColumnName = "codeAppareil", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Article article;

  public Historique() {}

  public Historique(HistoriquePK historiquePK) {
    this.historiquePK = historiquePK;
  }

  public Historique(HistoriquePK historiquePK, BigDecimal quantite, BigDecimal valeur,
      BigDecimal pmp, int etat) {
    this.historiquePK = historiquePK;
    this.quantite = quantite;
    this.valeur = valeur;
    this.pmp = pmp;
    this.etat = etat;
  }

  public Historique(String pn, String codeAppareil, int dateTraitement) {
    this.historiquePK = new HistoriquePK(pn, codeAppareil, dateTraitement);
  }

  public HistoriquePK getHistoriquePK() {
    return historiquePK;
  }

  public void setHistoriquePK(HistoriquePK historiquePK) {
    this.historiquePK = historiquePK;
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

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (historiquePK != null ? historiquePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Historique)) {
      return false;
    }
    Historique other = (Historique) object;
    if ((this.historiquePK == null && other.historiquePK != null)
        || (this.historiquePK != null && !this.historiquePK.equals(other.historiquePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Historique[ historiquePK=" + historiquePK + " ]";
  }

  public BigDecimal getPmpReint() {
    return pmpReint;
  }

  public void setPmpReint(BigDecimal pmpReint) {
    this.pmpReint = pmpReint;
  }

}
