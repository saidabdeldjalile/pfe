/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

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
 * @author user
 */
@Entity
@Table(name = "COMPTE_AH", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CompteAh.findAll", query = "SELECT c FROM CompteAh c"),
    @NamedQuery(name = "CompteAh.findByCptScf",
        query = "SELECT c FROM CompteAh c WHERE c.cptScf = :cptScf"),
    @NamedQuery(name = "CompteAh.findByLibelle",
        query = "SELECT c FROM CompteAh c WHERE c.libelle = :libelle")})
public class CompteAh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_SCF")
  private String cptScf;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;

  public CompteAh() {}

  public CompteAh(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getCptScf() {
    return cptScf;
  }

  public void setCptScf(String cptScf) {
    this.cptScf = cptScf;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cptScf != null ? cptScf.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CompteAh)) {
      return false;
    }
    CompteAh other = (CompteAh) object;
    if ((this.cptScf == null && other.cptScf != null)
        || (this.cptScf != null && !this.cptScf.equals(other.cptScf))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.bean.journal.CompteAh[ cptScf=" + cptScf + " ]";
  }

}
