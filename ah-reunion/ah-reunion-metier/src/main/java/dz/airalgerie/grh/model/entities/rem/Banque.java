/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

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
 * @author kemikem
 */
@Entity
@Table(schema = "CAR", name = "BANQUE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Banque.findAll", query = "SELECT b FROM Banque b"),
    @NamedQuery(name = "Banque.findByCodeBanque",
        query = "SELECT b FROM Banque b WHERE b.codeBanque = :codeBanque"),
    @NamedQuery(name = "Banque.findByCodeAgence",
        query = "SELECT b FROM Banque b WHERE b.codeAgence = :codeAgence"),
    @NamedQuery(name = "Banque.findByLibelle",
        query = "SELECT b FROM Banque b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "Banque.findByAdresse",
        query = "SELECT b FROM Banque b WHERE b.adresse = :adresse")})
public class Banque implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_BANQUE")
  private Short codeBanque;
  @Size(max = 4)
  @Column(name = "CODE_AGENCE")
  private String codeAgence;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 1000)
  @Column(name = "Adresse")
  private String adresse;
  @OneToMany(mappedBy = "codeBanque")
  private Collection<CompteBancaire> compteBancaireCollection;

  public Banque() {}

  public Banque(Short codeBanque) {
    this.codeBanque = codeBanque;
  }

  public Short getCodeBanque() {
    return codeBanque;
  }

  public void setCodeBanque(Short codeBanque) {
    this.codeBanque = codeBanque;
  }

  public String getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(String codeAgence) {
    this.codeAgence = codeAgence;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  @XmlTransient
  public Collection<CompteBancaire> getCompteBancaireCollection() {
    return compteBancaireCollection;
  }

  public void setCompteBancaireCollection(Collection<CompteBancaire> compteBancaireCollection) {
    this.compteBancaireCollection = compteBancaireCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeBanque != null ? codeBanque.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Banque)) {
      return false;
    }
    Banque other = (Banque) object;
    if ((this.codeBanque == null && other.codeBanque != null)
        || (this.codeBanque != null && !this.codeBanque.equals(other.codeBanque))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.Banque[ codeBanque=" + codeBanque + " ]";
  }

}
