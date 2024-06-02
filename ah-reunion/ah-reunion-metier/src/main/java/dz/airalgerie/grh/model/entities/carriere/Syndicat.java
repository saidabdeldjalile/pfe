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
@Table(schema = "CAR", name = "SYNDICAT")
public class Syndicat implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_SYN")
  private String codeSyn;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(mappedBy = "syndicat", fetch = FetchType.LAZY)
  private List<SituationSyndicale> SitSyndicaleList;

  public Syndicat() {}

  public Syndicat(String codeSyn) {
    this.codeSyn = codeSyn;
  }

  public String getCodeSyn() {
    return codeSyn;
  }

  public void setCodeSyn(String codeSyn) {
    this.codeSyn = codeSyn;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeSyn != null ? codeSyn.hashCode() : 0);
    return hash;
  }

  @XmlTransient
  public List<SituationSyndicale> getSitSyndicaleList() {
    return SitSyndicaleList;
  }

  public void setSitSyndicaleList(List<SituationSyndicale> SitSyndicaleList) {
    this.SitSyndicaleList = SitSyndicaleList;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Syndicat)) {
      return false;
    }
    Syndicat other = (Syndicat) object;
    if ((this.codeSyn == null && other.codeSyn != null)
        || (this.codeSyn != null && !this.codeSyn.equals(other.codeSyn))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Syndicat[ codeSyn=" + codeSyn + " ]";
  }

}