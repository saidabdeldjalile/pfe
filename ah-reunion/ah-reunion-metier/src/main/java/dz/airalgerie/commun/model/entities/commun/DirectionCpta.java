/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "V_DIRECTION", schema = "CF")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "DirectionCpta.findAll", query = "SELECT d FROM DirectionCpta d"),
    @NamedQuery(name = "DirectionCpta.findByCodeDir",
        query = "SELECT d FROM DirectionCpta d WHERE d.codeDir = :codeDir"),
    @NamedQuery(name = "DirectionCpta.findByDescDir",
        query = "SELECT d FROM DirectionCpta d WHERE d.descDir = :descDir")})
public class DirectionCpta implements Serializable {

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

  public DirectionCpta() {
  }

  public DirectionCpta(String codeDir) {
    this.codeDir = codeDir;
  }

  public DirectionCpta(String codeDir, String descDir) {
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDir != null ? codeDir.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DirectionCpta)) {
      return false;
    }
    DirectionCpta other = (DirectionCpta) object;
    if ((this.codeDir == null && other.codeDir != null)
        || (this.codeDir != null && !this.codeDir.equals(other.codeDir))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.DirectionCpta[ codeDir=" + codeDir + " ]";
  }

}
