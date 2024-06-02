/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.facture")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findByNumFacture",
        query = "SELECT f FROM Facture f WHERE f.facturePK.numFacture = :numFacture"),
    @NamedQuery(name = "Facture.findByDateFacture",
        query = "SELECT f FROM Facture f WHERE f.facturePK.dateFacture = :dateFacture")})
public class Facture implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FacturePK facturePK;
  @JoinColumn(name = "codeFournisseur", referencedColumnName = "codeFournisseur")
  @ManyToOne(optional = false)
  private Fournisseur codeFournisseur;
  @OneToMany(mappedBy = "facture")
  private Collection<BonAchat> bonAchatCollection;

  public Facture() {}

  public Facture(FacturePK facturePK) {
    this.facturePK = facturePK;
  }

  public Facture(String numFacture, Date dateFacture) {
    this.facturePK = new FacturePK(numFacture, dateFacture);
  }

  public FacturePK getFacturePK() {
    return facturePK;
  }

  public void setFacturePK(FacturePK facturePK) {
    this.facturePK = facturePK;
  }

  public Fournisseur getCodeFournisseur() {
    return codeFournisseur;
  }

  public void setCodeFournisseur(Fournisseur codeFournisseur) {
    this.codeFournisseur = codeFournisseur;
  }

  @XmlTransient
  public Collection<BonAchat> getBonAchatCollection() {
    return bonAchatCollection;
  }

  public void setBonAchatCollection(Collection<BonAchat> bonAchatCollection) {
    this.bonAchatCollection = bonAchatCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (facturePK != null ? facturePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Facture)) {
      return false;
    }
    Facture other = (Facture) object;
    if ((this.facturePK == null && other.facturePK != null)
        || (this.facturePK != null && !this.facturePK.equals(other.facturePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Facture[ facturePK=" + facturePK + " ]";
  }

}
