/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

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
@Table(name = "CAE_ESCALE", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CompteEscale.findAll", query = "SELECT c FROM CompteEscale c"),
    @NamedQuery(name = "CompteEscale.findByCodeEsc",
        query = "SELECT c FROM CompteEscale c WHERE c.codeEsc = :codeEsc"),
    @NamedQuery(name = "CompteEscale.findByCaeEscale",
        query = "SELECT c FROM CompteEscale c WHERE c.caeEscale = :caeEscale")})
public class CompteEscale implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_ESC")
  private String codeEsc;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CAE_ESCALE")
  private String caeEscale;

  public CompteEscale() {}

  public CompteEscale(String codeEsc) {
    this.codeEsc = codeEsc;
  }

  public CompteEscale(String codeEsc, String caeEscale) {
    this.codeEsc = codeEsc;
    this.caeEscale = caeEscale;
  }

  public String getCodeEsc() {
    return codeEsc;
  }

  public void setCodeEsc(String codeEsc) {
    this.codeEsc = codeEsc;
  }

  public String getCaeEscale() {
    return caeEscale;
  }

  public void setCaeEscale(String caeEscale) {
    this.caeEscale = caeEscale;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeEsc != null ? codeEsc.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CompteEscale)) {
      return false;
    }
    CompteEscale other = (CompteEscale) object;
    if ((this.codeEsc == null && other.codeEsc != null)
        || (this.codeEsc != null && !this.codeEsc.equals(other.codeEsc))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CompteEscale[ codeEsc=" + codeEsc + " ]";
  }

}
