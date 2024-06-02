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
@Table(schema = "CAR", name = "SECTION")
public class Section implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_SEC")
  private Short codeSec;
  @Size(max = 30)
  @Column(name = "DESC_SEC")
  private String descSec;
  // @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  // private List<Carriere> carriereList;
  @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
  private List<PosteTrvDet> posteTrvDetList;

  public Section() {}

  public Section(Short codeSec) {
    this.codeSec = codeSec;
  }

  public Short getCodeSec() {
    return codeSec;
  }

  public void setCodeSec(Short codeSec) {
    this.codeSec = codeSec;
  }

  public String getDescSec() {
    return descSec;
  }

  public void setDescSec(String descSec) {
    this.descSec = descSec;
  }

  // @XmlTransient
  // public List<Carriere> getCarriereList() {
  // return carriereList;
  // }
  //
  // public void setCarriereList(List<Carriere> carriereList) {
  // this.carriereList = carriereList;
  // }

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
    hash += (codeSec != null ? codeSec.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Section)) {
      return false;
    }
    Section other = (Section) object;
    if ((this.codeSec == null && other.codeSec != null)
        || (this.codeSec != null && !this.codeSec.equals(other.codeSec))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Section[ codeSec=" + codeSec + " ]";
  }

}
