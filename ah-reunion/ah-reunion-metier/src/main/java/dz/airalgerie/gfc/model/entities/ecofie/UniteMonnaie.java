/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

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
 * @author kehli
 */
@Entity
@Table(name = "UNITE_MONNAIE", schema = "CF")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "UniteMonnaie.findAll", query = "SELECT u FROM UniteMonnaie u"),
    @NamedQuery(name = "UniteMonnaie.findByUniteId",
        query = "SELECT u FROM UniteMonnaie u WHERE u.uniteId = :uniteId"),
    @NamedQuery(name = "UniteMonnaie.findByCodeMonnaie",
        query = "SELECT u FROM UniteMonnaie u WHERE u.codeMonnaie = :codeMonnaie")})
public class UniteMonnaie implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "UNITE_ID")
  private String uniteId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;

  public UniteMonnaie() {
  }

  public UniteMonnaie(String uniteId) {
    this.uniteId = uniteId;
  }

  public UniteMonnaie(String uniteId, String codeMonnaie) {
    this.uniteId = uniteId;
    this.codeMonnaie = codeMonnaie;
  }

  public String getUniteId() {
    return uniteId;
  }

  public void setUniteId(String uniteId) {
    this.uniteId = uniteId;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (uniteId != null ? uniteId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UniteMonnaie)) {
      return false;
    }
    UniteMonnaie other = (UniteMonnaie) object;
    if ((this.uniteId == null && other.uniteId != null)
        || (this.uniteId != null && !this.uniteId.equals(other.uniteId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.ecofie.UniteMonnaie[ uniteId=" + uniteId + " ]";
  }

}
