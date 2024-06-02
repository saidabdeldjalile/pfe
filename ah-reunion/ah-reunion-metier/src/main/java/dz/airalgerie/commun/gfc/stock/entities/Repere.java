/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.repere")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Repere.findAll", query = "SELECT r FROM Repere r"),
    @NamedQuery(name = "Repere.findByCodeRepere",
        query = "SELECT r FROM Repere r WHERE r.codeRepere = :codeRepere"),
    @NamedQuery(name = "Repere.findByLibelle",
        query = "SELECT r FROM Repere r WHERE r.libelle = :libelle")})
public class Repere implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "codeRepere")
  private String codeRepere;
  @Size(max = 60)
  @Column(name = "libelle")
  private String libelle;
  @JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin")
  @ManyToOne(optional = false)
  private Magasin codeMagasin;

  public Repere() {}

  public Repere(String codeRepere) {
    this.codeRepere = codeRepere;
  }

  public String getCodeRepere() {
    return codeRepere;
  }

  public void setCodeRepere(String codeRepere) {
    this.codeRepere = codeRepere;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Magasin getCodeMagasin() {
    return codeMagasin;
  }

  public void setCodeMagasin(Magasin codeMagasin) {
    this.codeMagasin = codeMagasin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRepere != null ? codeRepere.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Repere)) {
      return false;
    }
    Repere other = (Repere) object;
    if ((this.codeRepere == null && other.codeRepere != null)
        || (this.codeRepere != null && !this.codeRepere.equals(other.codeRepere))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Repere[ codeRepere=" + codeRepere + " ]";
  }

}
