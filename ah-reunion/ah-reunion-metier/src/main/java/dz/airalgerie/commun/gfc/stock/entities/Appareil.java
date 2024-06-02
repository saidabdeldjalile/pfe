/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.appareil")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Appareil.findAll", query = "SELECT a FROM Appareil a"),
    @NamedQuery(name = "Appareil.findByCodeAppareil",
        query = "SELECT a FROM Appareil a WHERE a.appareilPK.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "Appareil.findByTypeStock",
        query = "SELECT a FROM Appareil a WHERE a.appareilPK.typeStock = :typeStock"),
    @NamedQuery(name = "Appareil.findByLibelle",
        query = "SELECT a FROM Appareil a WHERE a.libelle = :libelle")})
public class Appareil implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AppareilPK appareilPK;
  @Size(max = 60)
  @Column(name = "libelle")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "appareil")
  private Collection<Article> articleCollection;

  public Appareil() {}

  public Appareil(AppareilPK appareilPK) {
    this.appareilPK = appareilPK;
  }

  public Appareil(String codeAppareil, String typeStock) {
    this.appareilPK = new AppareilPK(codeAppareil, typeStock);
  }

  public AppareilPK getAppareilPK() {
    return appareilPK;
  }

  public void setAppareilPK(AppareilPK appareilPK) {
    this.appareilPK = appareilPK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<Article> getArticleCollection() {
    return articleCollection;
  }

  public void setArticleCollection(Collection<Article> articleCollection) {
    this.articleCollection = articleCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (appareilPK != null ? appareilPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Appareil)) {
      return false;
    }
    Appareil other = (Appareil) object;
    if ((this.appareilPK == null && other.appareilPK != null)
        || (this.appareilPK != null && !this.appareilPK.equals(other.appareilPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Appareil[ appareilPK=" + appareilPK + " ]";
  }

}
