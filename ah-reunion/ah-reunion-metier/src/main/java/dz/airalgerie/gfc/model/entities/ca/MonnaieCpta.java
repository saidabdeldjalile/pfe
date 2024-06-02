/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

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
 * @author Administrateur
 */
@Entity
@Table(name = "MONNAIE", schema = "COM")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "MonnaieCpta.findAll", query = "SELECT m FROM MonnaieCpta m"),
    @NamedQuery(name = "MonnaieCpta.findByCodeMon",
        query = "SELECT m FROM MonnaieCpta m WHERE m.codeMon = :codeMon"),
    @NamedQuery(name = "MonnaieCpta.findByCodeAlph",
        query = "SELECT m FROM MonnaieCpta m WHERE m.codeAlph = :codeAlph"),
    @NamedQuery(name = "MonnaieCpta.findByLibelle",
        query = "SELECT m FROM MonnaieCpta m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "MonnaieCpta.findByPays",
        query = "SELECT m FROM MonnaieCpta m WHERE m.pays = :pays")})
public class MonnaieCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MON")
  private String codeMon;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_ALPH")
  private String codeAlph;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "PAYS")
  private String pays;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "monnaie")
  private Collection<MonnaieCvalCpta> monnaieCvalCollection;

  public MonnaieCpta() {}

  public MonnaieCpta(String codeMon) {
    this.codeMon = codeMon;
  }

  public MonnaieCpta(String codeMon, String codeAlph, String libelle, String pays) {
    this.codeMon = codeMon;
    this.codeAlph = codeAlph;
    this.libelle = libelle;
    this.pays = pays;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public String getCodeAlph() {
    return codeAlph;
  }

  public void setCodeAlph(String codeAlph) {
    this.codeAlph = codeAlph;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getPays() {
    return pays;
  }

  public void setPays(String pays) {
    this.pays = pays;
  }

  @XmlTransient
  public Collection<MonnaieCvalCpta> getMonnaieCvalCollection() {
    return monnaieCvalCollection;
  }

  public void setMonnaieCvalCollection(Collection<MonnaieCvalCpta> monnaieCvalCollection) {
    this.monnaieCvalCollection = monnaieCvalCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeMon != null ? codeMon.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MonnaieCpta)) {
      return false;
    }
    MonnaieCpta other = (MonnaieCpta) object;
    if ((this.codeMon == null && other.codeMon != null)
        || (this.codeMon != null && !this.codeMon.equals(other.codeMon))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.MonnaieCpta[ codeMon=" + codeMon + " ]";
  }

}
