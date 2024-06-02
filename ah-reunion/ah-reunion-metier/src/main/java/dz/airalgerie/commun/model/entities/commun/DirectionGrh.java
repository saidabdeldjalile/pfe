/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import dz.airalgerie.grh.model.entities.carriere.Carriere;
import dz.airalgerie.grh.model.entities.carriere.Discipline;
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
@Table(schema = "CAR", name = "DIRECTION")
public class DirectionGrh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "DESC_DIR")
  private String descDir;
  @OneToMany(mappedBy = "direction", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(mappedBy = "direction", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList;

  public DirectionGrh() {}

  public DirectionGrh(String codeDir) {
    this.codeDir = codeDir;
  }

  public DirectionGrh(String codeDir, String descDir) {
    this.codeDir = codeDir;
    this.descDir = descDir;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
  }

  public String getDescDir() {
    return descDir;
  }

  public void setDescDir(String descDir) {
    this.descDir = descDir;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList() {
    return disciplineList;
  }

  public void setDisciplineList(List<Discipline> disciplineList) {
    this.disciplineList = disciplineList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDir != null ? codeDir.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DirectionGrh)) {
      return false;
    }
    DirectionGrh other = (DirectionGrh) object;
    if ((this.codeDir == null && other.codeDir != null)
        || (this.codeDir != null && !this.codeDir.equals(other.codeDir))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.DirectionGrh[ codeDir=" + codeDir + " ]";
  }

}
