/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "ETATSTOCK", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Etatstock.findAll", query = "SELECT e FROM Etatstock e"),
    @NamedQuery(name = "Etatstock.findByCodepn",
        query = "SELECT e FROM Etatstock e WHERE e.etatstockPK.codepn = :codepn"),
    @NamedQuery(name = "Etatstock.findByDatecloture",
        query = "SELECT e FROM Etatstock e WHERE e.etatstockPK.datecloture = :datecloture"),
    @NamedQuery(name = "Etatstock.findByCodemag",
        query = "SELECT e FROM Etatstock e WHERE e.etatstockPK.codemag = :codemag"),
    @NamedQuery(name = "Etatstock.findByValeur",
        query = "SELECT e FROM Etatstock e WHERE e.valeur = :valeur"),
    @NamedQuery(name = "Etatstock.findByQuantite",
        query = "SELECT e FROM Etatstock e WHERE e.quantite = :quantite"),
    @NamedQuery(name = "Etatstock.findByPmp",
        query = "SELECT e FROM Etatstock e WHERE e.pmp = :pmp")})
public class Etatstock implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EtatstockPK etatstockPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "VALEUR")
  private Float valeur;
  @Column(name = "QUANTITE")
  private Float quantite;
  @Column(name = "PMP")
  private Float pmp;

  @Column(name = "DATEDA")
  @Temporal(TemporalType.DATE)
  private Date dateda;

  @Column(name = "DATEDS")
  @Temporal(TemporalType.DATE)
  private Date dateds;

  @JoinColumn(name = "CODEMAG", referencedColumnName = "CODEMAG", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Magazine magazine;
  @JoinColumn(name = "DATECLOTURE", referencedColumnName = "DATECLOTURE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Cloture cloture;
  @JoinColumn(name = "CODEPN", referencedColumnName = "CODEPN", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Article article;

  public Etatstock() {}

  public Etatstock(EtatstockPK etatstockPK) {
    this.etatstockPK = etatstockPK;
  }

  public Etatstock(String codepn, int datecloture, int codemag) {
    this.etatstockPK = new EtatstockPK(codepn, datecloture, codemag);
  }

  public EtatstockPK getEtatstockPK() {
    return etatstockPK;
  }

  public void setEtatstockPK(EtatstockPK etatstockPK) {
    this.etatstockPK = etatstockPK;
  }

  public Float getValeur() {
    return valeur;
  }

  public void setValeur(Float valeur) {
    this.valeur = valeur;
  }

  public Float getQuantite() {
    return quantite;
  }

  public void setQuantite(Float quantite) {
    this.quantite = quantite;
  }

  public Float getPmp() {
    return pmp;
  }

  public void setPmp(Float pmp) {
    this.pmp = pmp;
  }

  public Cloture getCloture() {
    return cloture;
  }

  public void setCloture(Cloture cloture) {
    this.cloture = cloture;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public Magazine getMagazine() {
    return magazine;
  }

  public void setMagazine(Magazine magazine) {
    this.magazine = magazine;
  }

  // rajouter le 19-01-2020 pour historique dda et dds
  public Date getDateda() {
    return dateda;
  }

  public void setDateda(Date dateda) {
    this.dateda = dateda;
  }

  public Date getDateds() {
    return dateds;
  }

  public void setDateds(Date dateds) {
    this.dateds = dateds;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (etatstockPK != null ? etatstockPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Etatstock)) {
      return false;
    }
    Etatstock other = (Etatstock) object;
    if ((this.etatstockPK == null && other.etatstockPK != null)
        || (this.etatstockPK != null && !this.etatstockPK.equals(other.etatstockPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Etatstock[ etatstockPK=" + etatstockPK + " ]";
  }

}
