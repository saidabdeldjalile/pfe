/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(schema = "CAR", name = "CHOIX_AVANCEMENT")
public class ChoixAvancement implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CHOIX_AVC")
  private String choixAvc;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "choixAvancement", fetch = FetchType.LAZY)
  private List<ChoixAvcCorps> choixAvcCorpsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "choixAvancement", fetch = FetchType.LAZY)
  private List<Avancement> avancementList;

  public ChoixAvancement() {}

  public ChoixAvancement(String choixAvc) {
    this.choixAvc = choixAvc;
  }

  public String getChoixAvc() {
    return choixAvc;
  }

  public void setChoixAvc(String choixAvc) {
    this.choixAvc = choixAvc;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @XmlTransient
  public List<ChoixAvcCorps> getChoixAvcCorpsList() {
    return choixAvcCorpsList;
  }

  public void setChoixAvcCorpsList(List<ChoixAvcCorps> choixAvcCorpsList) {
    this.choixAvcCorpsList = choixAvcCorpsList;
  }

  @XmlTransient
  public List<Avancement> getAvancementList() {
    return avancementList;
  }

  public void setAvancementList(List<Avancement> avancementList) {
    this.avancementList = avancementList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (choixAvc != null ? choixAvc.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ChoixAvancement)) {
      return false;
    }
    ChoixAvancement other = (ChoixAvancement) object;
    if ((this.choixAvc == null && other.choixAvc != null)
        || (this.choixAvc != null && !this.choixAvc.equals(other.choixAvc))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.ChoixAvancement[ choixAvc=" + choixAvc + " ]";
  }

}
