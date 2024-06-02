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
@Table(schema = "FRM", name = "REF_NIVEAU")
public class RefNiveau implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_NIV")
  private String codeNiv;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "refNiveau", fetch = FetchType.LAZY)
  private List<Niveau> niveauList;

  public RefNiveau() {}

  public RefNiveau(String codeNiv) {
    this.codeNiv = codeNiv;
  }

  public RefNiveau(String codeNiv, String libelle) {
    this.codeNiv = codeNiv;
    this.libelle = libelle;
  }

  public String getCodeNiv() {
    return codeNiv;
  }

  public void setCodeNiv(String codeNiv) {
    this.codeNiv = codeNiv;
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

  @XmlTransient
  public List<Niveau> getNiveauList() {
    return niveauList;
  }

  public void setNiveauList(List<Niveau> niveauList) {
    this.niveauList = niveauList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeNiv != null ? codeNiv.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefNiveau)) {
      return false;
    }
    RefNiveau other = (RefNiveau) object;
    if ((this.codeNiv == null && other.codeNiv != null)
        || (this.codeNiv != null && !this.codeNiv.equals(other.codeNiv))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.RefNiveau[ codeNiv=" + codeNiv + " ]";
  }

}
