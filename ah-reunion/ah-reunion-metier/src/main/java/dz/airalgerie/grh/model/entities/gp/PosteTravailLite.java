/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "CAR", name = "POSTE_TRAVAIL")
@XmlRootElement

public class PosteTravailLite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_PSTR")
  private Integer codePstr;
  @Size(max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "posteT")
  private List<PersonnelLite> persList;

  public PosteTravailLite() {}

  public List<PersonnelLite> getPersList() {
    return persList;
  }

  public void setPersList(List<PersonnelLite> persList) {
    this.persList = persList;
  }

  public PosteTravailLite(Integer codePstr) {
    this.codePstr = codePstr;
  }

  public Integer getCodePstr() {
    return codePstr;
  }

  public void setCodePstr(Integer codePstr) {
    this.codePstr = codePstr;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codePstr != null ? codePstr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PosteTravailLite)) {
      return false;
    }
    PosteTravailLite other = (PosteTravailLite) object;
    if ((this.codePstr == null && other.codePstr != null)
        || (this.codePstr != null && !this.codePstr.equals(other.codePstr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.PosteTravail[ codePstr=" + codePstr + " ]";
  }

}
