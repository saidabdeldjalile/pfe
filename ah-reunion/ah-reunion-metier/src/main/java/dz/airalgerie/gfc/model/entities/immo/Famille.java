/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "FAMILLE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")})
public class Famille implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "FAMILLEID")
  private Long familleid;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAUX_AMORT")
  private Double tauxAmort;
  @Column(name = "COMPTE68")
  private Long compte68;
  @Column(name = "COMPTE28")
  private Long compte28;
  @Column(name = "CompteGenerale")
  private Long compteGenerale;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "famille", fetch = FetchType.LAZY)
  private List<Sousfamille> sousfamilleList;

  public Famille() {}

  public Famille(Long familleid) {
    this.familleid = familleid;
  }

  public Long getFamilleid() {
    return familleid;
  }

  public void setFamilleid(Long familleid) {
    this.familleid = familleid;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Double getTauxAmort() {
    return tauxAmort;
  }

  public void setTauxAmort(Double tauxAmort) {
    this.tauxAmort = tauxAmort;
  }

  public Long getCompte68() {
    return compte68;
  }

  public void setCompte68(Long compte68) {
    this.compte68 = compte68;
  }

  public Long getCompte28() {
    return compte28;
  }

  public void setCompte28(Long compte28) {
    this.compte28 = compte28;
  }

  public Long getCompteGenerale() {
    return compteGenerale;
  }

  public void setCompteGenerale(Long compteGenerale) {
    this.compteGenerale = compteGenerale;
  }

  @XmlTransient
  public List<Sousfamille> getSousfamilleList() {
    return sousfamilleList;
  }

  public void setSousfamilleList(List<Sousfamille> sousfamilleList) {
    this.sousfamilleList = sousfamilleList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (familleid != null ? familleid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Famille)) {
      return false;
    }
    Famille other = (Famille) object;
    if ((this.familleid == null && other.familleid != null)
        || (this.familleid != null && !this.familleid.equals(other.familleid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Famille[ familleid=" + familleid + " ]";
  }

}
