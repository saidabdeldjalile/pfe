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
@Table(schema = "CAR", name = "CATEGORIE")
public class Categorie implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_CATG")
  private String codeCatg;
  @Size(max = 50)
  @Column(name = "DESC_CATG")
  private String descCatg;
  @Basic(optional = false)
  @NotNull
  @Column(name = "STAT")
  private Character stat;
  @Column(name = "STATUT")
  private Integer statut;
  @Column(name = "DROIT_FIRST")
  private boolean droitFirst;
  @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
  private List<PosteTrvDet> posteTrvDetList;

  public Categorie() {}

  public Categorie(String codeCatg) {
    this.codeCatg = codeCatg;
  }

  public Categorie(String codeCatg, Character stat) {
    this.codeCatg = codeCatg;
    this.stat = stat;
  }

  public String getCodeCatg() {
    return codeCatg;
  }

  public void setCodeCatg(String codeCatg) {
    this.codeCatg = codeCatg;
  }

  public String getDescCatg() {
    return descCatg;
  }

  public void setDescCatg(String descCatg) {
    this.descCatg = descCatg;
  }

  public Character getStat() {
    return stat;
  }

  public void setStat(Character stat) {
    this.stat = stat;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public boolean isDroitFirst() {
    return droitFirst;
  }

  public void setDroitFirst(boolean droitFirst) {
    this.droitFirst = droitFirst;
  }

  @XmlTransient
  public List<PosteTrvDet> getPosteTrvDetList() {
    return posteTrvDetList;
  }

  public void setPosteTrvDetList(List<PosteTrvDet> posteTrvDetList) {
    this.posteTrvDetList = posteTrvDetList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeCatg != null ? codeCatg.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Categorie)) {
      return false;
    }
    Categorie other = (Categorie) object;
    if ((this.codeCatg == null && other.codeCatg != null)
        || (this.codeCatg != null && !this.codeCatg.equals(other.codeCatg))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Categorie[ codeCatg=" + codeCatg + " ]";
  }

}
