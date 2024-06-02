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
@Table(schema = "CAR", name = "CORPS")
public class Corps implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CODE_CORPS")
  private String codeCorps;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "DESC_CORPS")
  private String descCorps;
  @OneToMany(mappedBy = "corps", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(mappedBy = "corps", fetch = FetchType.LAZY)
  private List<PosteTrvDet> posteTrvDetList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "corps", fetch = FetchType.LAZY)
  private List<ChoixAvcCorps> choixAvcCorpsList;

  public Corps() {}

  public Corps(String codeCorps) {
    this.codeCorps = codeCorps;
  }

  public Corps(String codeCorps, String descCorps) {
    this.codeCorps = codeCorps;
    this.descCorps = descCorps;
  }

  public String getCodeCorps() {
    return codeCorps;
  }

  public void setCodeCorps(String codeCorps) {
    this.codeCorps = codeCorps;
  }

  public String getDescCorps() {
    return descCorps;
  }

  public void setDescCorps(String descCorps) {
    this.descCorps = descCorps;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<PosteTrvDet> getPosteTrvDetList() {
    return posteTrvDetList;
  }

  public void setPosteTrvDetList(List<PosteTrvDet> posteTrvDetList) {
    this.posteTrvDetList = posteTrvDetList;
  }

  @XmlTransient
  public List<ChoixAvcCorps> getChoixAvcCorpsList() {
    return choixAvcCorpsList;
  }

  public void setChoixAvcCorpsList(List<ChoixAvcCorps> choixAvcCorpsList) {
    this.choixAvcCorpsList = choixAvcCorpsList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeCorps != null ? codeCorps.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Corps)) {
      return false;
    }
    Corps other = (Corps) object;
    if ((this.codeCorps == null && other.codeCorps != null)
        || (this.codeCorps != null && !this.codeCorps.equals(other.codeCorps))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Corps[ codeCorps=" + codeCorps + " ]";
  }

}
