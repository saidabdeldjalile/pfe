/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.atelier")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Atelier.findAll", query = "SELECT a FROM Atelier a"),
    @NamedQuery(name = "Atelier.findByCodeAtelier",
        query = "SELECT a FROM Atelier a WHERE a.codeAtelier= :codeAtelier"),
    @NamedQuery(name = "Atelier.findByLibelle",
        query = "SELECT a FROM Atelier a WHERE a.libelle = :libelle")})

public class Atelier implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 100)
  @Column(name = "codeAtelier")
  private String codeAtelier;
  @Size(max = 100)
  @Column(name = "libelle")
  private String libelle;

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.codeAtelier);
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
    final Atelier other = (Atelier) obj;
    if (!Objects.equals(this.codeAtelier, other.codeAtelier)) {
      return false;
    }
    return true;
  }

  @OneToMany(mappedBy = "codeAtelier")
  private Collection<BonSortie> bonSortieCollection;

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Collection<BonSortie> getBonSortieCollection() {
    return bonSortieCollection;
  }

  public void setBonSortieCollection(Collection<BonSortie> bonSortieCollection) {
    this.bonSortieCollection = bonSortieCollection;
  }

  public String getCodeAtelier() {
    return codeAtelier;
  }

  public void setCodeAtelier(String codeAtelier) {
    this.codeAtelier = codeAtelier;
  }

}
