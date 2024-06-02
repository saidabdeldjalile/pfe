/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "STK.magasin")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Magasin.findAll", query = "SELECT m FROM Magasin m"),
    @NamedQuery(name = "Magasin.findByCodeMagasin",
        query = "SELECT m FROM Magasin m WHERE m.codeMagasin = :codeMagasin"),
    @NamedQuery(name = "Magasin.findByLibelle",
        query = "SELECT m FROM Magasin m WHERE m.libelle = :libelle")})
public class Magasin implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeMagasin")
  private String codeMagasin;
  @Size(max = 60)
  @Column(name = "libelle")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeMagasin")
  private Collection<Repere> repereCollection;

  public Magasin() {}

  public Magasin(String codeMagasin) {
    this.codeMagasin = codeMagasin;
  }

  public String getCodeMagasin() {
    return codeMagasin;
  }

  public void setCodeMagasin(String codeMagasin) {
    this.codeMagasin = codeMagasin;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<Repere> getRepereCollection() {
    return repereCollection;
  }

  public void setRepereCollection(Collection<Repere> repereCollection) {
    this.repereCollection = repereCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeMagasin != null ? codeMagasin.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Magasin)) {
      return false;
    }
    Magasin other = (Magasin) object;
    if ((this.codeMagasin == null && other.codeMagasin != null)
        || (this.codeMagasin != null && !this.codeMagasin.equals(other.codeMagasin))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Magasin[ codeMagasin=" + codeMagasin + " ]";
  }

}
