/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.grh.model.entities.rem.Bulletin;
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
 * @author kemikem
 */
@Entity
@Table(name = "FILIALE", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Filiale.findAll", query = "SELECT f FROM Filiale f"),
    @NamedQuery(name = "Filiale.findByCodeFil",
        query = "SELECT f FROM Filiale f WHERE f.codeFil = :codeFil"),
    @NamedQuery(name = "Filiale.findByLibelle",
        query = "SELECT f FROM Filiale f WHERE f.libelle = :libelle")})
public class Filiale implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_FIL")
  private String codeFil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "filiale")
  private Collection<Bulletin> bulletinCollection;

  public Filiale() {}

  public Filiale(String codeFil) {
    this.codeFil = codeFil;
  }

  public Filiale(String codeFil, String libelle) {
    this.codeFil = codeFil;
    this.libelle = libelle;
  }

  public String getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public Collection<Bulletin> getBulletinCollection() {
    return bulletinCollection;
  }

  public void setBulletinCollection(Collection<Bulletin> bulletinCollection) {
    this.bulletinCollection = bulletinCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeFil != null ? codeFil.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Filiale)) {
      return false;
    }
    Filiale other = (Filiale) object;
    if ((this.codeFil == null && other.codeFil != null)
        || (this.codeFil != null && !this.codeFil.equals(other.codeFil))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.Filiale[ codeFil=" + codeFil + " ]";
  }

}
