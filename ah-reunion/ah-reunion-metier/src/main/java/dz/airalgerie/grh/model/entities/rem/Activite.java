/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "ACTIVITE", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a")})
public class Activite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_ACT")
  private Integer codeAct;
  @Size(max = 250)
  @Column(name = "LIB_ACT")
  private String libAct;
  @Column(name = "TYPE_ACTIVITE")
  private String typeActivite;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "activite")
  private List<Element> elementList;

  public Activite() {}

  public Activite(Integer codeAct) {
    this.codeAct = codeAct;
  }

  public Integer getCodeAct() {
    return codeAct;
  }

  public void setCodeAct(Integer codeAct) {
    this.codeAct = codeAct;
  }

  public String getLibAct() {
    return libAct;
  }

  public void setLibAct(String libAct) {
    this.libAct = libAct;
  }

  public String getTypeActivite() {
    return typeActivite;
  }

  public void setTypeActivite(String typeActivite) {
    this.typeActivite = typeActivite;
  }

  @XmlTransient
  public List<Element> getElementList() {
    return elementList;
  }

  public void setElementList(List<Element> elementList) {
    this.elementList = elementList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeAct != null ? codeAct.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Activite)) {
      return false;
    }
    Activite other = (Activite) object;
    if ((this.codeAct == null && other.codeAct != null)
        || (this.codeAct != null && !this.codeAct.equals(other.codeAct))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.Activite[ codeAct=" + codeAct + " ]";
  }

}
