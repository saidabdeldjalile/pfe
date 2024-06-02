/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "CAR", name = "DAIRA")
public class Daira implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CODE_DAIRA")
  private Integer codeDaira;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "[LIBELLE]")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getCodeDaira() {
    return codeDaira;
  }

  public void setCodeDaira(Integer codeDaira) {
    this.codeDaira = codeDaira;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeDaira != null ? codeDaira.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Daira)) {
      return false;
    }
    Daira other = (Daira) object;
    if ((this.codeDaira == null && other.codeDaira != null)
        || (this.codeDaira != null && !this.codeDaira.equals(other.codeDaira))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Daira[ id=" + codeDaira + " ]";
  }

}
