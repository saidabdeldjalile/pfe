/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.uniteMesure")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "UniteMesure.findAll", query = "SELECT u FROM UniteMesure u"),
    @NamedQuery(name = "UniteMesure.findByCodeMesure",
        query = "SELECT u FROM UniteMesure u WHERE u.codeMesure = :codeMesure"),
    @NamedQuery(name = "UniteMesure.findByLibelle",
        query = "SELECT u FROM UniteMesure u WHERE u.libelle = :libelle")})
public class UniteMesure implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "codeMesure")
  private String codeMesure;
  @Size(max = 60)
  @Column(name = "libelle")
  private String libelle;
  @OneToMany(mappedBy = "codeMesure")
  private Collection<Article> articleCollection;

  public UniteMesure() {}

  public UniteMesure(String codeMesure) {
    this.codeMesure = codeMesure;
  }

  public String getCodeMesure() {
    return codeMesure;
  }

  public void setCodeMesure(String codeMesure) {
    this.codeMesure = codeMesure;
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
    hash += (codeMesure != null ? codeMesure.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UniteMesure)) {
      return false;
    }
    UniteMesure other = (UniteMesure) object;
    if ((this.codeMesure == null && other.codeMesure != null)
        || (this.codeMesure != null && !this.codeMesure.equals(other.codeMesure))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.UniteMesure[ codeMesure=" + codeMesure + " ]";
  }

}
