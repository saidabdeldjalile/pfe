/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
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
 * @author user
 */
@Entity
@Table(name = "ETAT_MLD", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "EtatMaladie.findAll", query = "SELECT e FROM EtatMaladie e"),
    @NamedQuery(name = "EtatMaladie.findByEtat",
        query = "SELECT e FROM EtatMaladie e WHERE e.etat = :etat"),
    @NamedQuery(name = "EtatMaladie.findByLibelle",
        query = "SELECT e FROM EtatMaladie e WHERE e.libelle = :libelle")})
public class EtatMaladie implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "ETAT")
  private String etat;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
  private List<Inactivite> inactiviteList;

  public EtatMaladie() {
  }

  public EtatMaladie(String etat) {
    this.etat = etat;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }


  @Override
  public int hashCode() {
    int hash = 0;
    hash += (etat != null ? etat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EtatMaladie)) {
      return false;
    }
    EtatMaladie other = (EtatMaladie) object;
    if ((this.etat == null && other.etat != null)
        || (this.etat != null && !this.etat.equals(other.etat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.EtatMaladie[ etat=" + etat + " ]";
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<Inactivite> getInactiviteList() {
    return inactiviteList;
  }

  public void setInactiviteList(List<Inactivite> inactiviteList) {
    this.inactiviteList = inactiviteList;
  }

}
