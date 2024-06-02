/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "NATIONALITE")
public class Nationalite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_NAT")
  private String codeNat;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "nationalite", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList;
  @OneToMany(mappedBy = "nationalite", fetch = FetchType.LAZY)
  private List<Signalitique> signalitiqueList;

  public Nationalite() {}

  public Nationalite(String codeNat) {
    this.codeNat = codeNat;
  }

  public String getCodeNat() {
    return codeNat;
  }

  public void setCodeNat(String codeNat) {
    this.codeNat = codeNat;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Conjoint> getConjointList() {
    return conjointList;
  }

  public void setConjointList(List<Conjoint> conjointList) {
    this.conjointList = conjointList;
  }

  @XmlTransient
  public List<Signalitique> getSignalitiqueList() {
    return signalitiqueList;
  }

  public void setSignalitiqueList(List<Signalitique> signalitiqueList) {
    this.signalitiqueList = signalitiqueList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeNat != null ? codeNat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Nationalite)) {
      return false;
    }
    Nationalite other = (Nationalite) object;
    if ((this.codeNat == null && other.codeNat != null)
        || (this.codeNat != null && !this.codeNat.equals(other.codeNat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Nationalite[ codeNat=" + codeNat + " ]";
  }

}
