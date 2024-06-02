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
@Table(schema = "FRM", name = "REF_LANGUE")
public class RefLangue implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_LNG")
  private String codeLng;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "refLangue", fetch = FetchType.LAZY)
  private List<Langue> langueList;

  public RefLangue() {}

  public RefLangue(String codeLng) {
    this.codeLng = codeLng;
  }

  public RefLangue(String codeLng, String libelle) {
    this.codeLng = codeLng;
    this.libelle = libelle;
  }

  public String getCodeLng() {
    return codeLng;
  }

  public void setCodeLng(String codeLng) {
    this.codeLng = codeLng;
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
  public List<Langue> getLangueList() {
    return langueList;
  }

  public void setLangueList(List<Langue> langueList) {
    this.langueList = langueList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeLng != null ? codeLng.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefLangue)) {
      return false;
    }
    RefLangue other = (RefLangue) object;
    if ((this.codeLng == null && other.codeLng != null)
        || (this.codeLng != null && !this.codeLng.equals(other.codeLng))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.RefLangue[ codeLng=" + codeLng + " ]";
  }

}
