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
 * @author Administrateur
 */
@Entity
@Table(name = "CLASSE_COMPTE_AH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasseCompteAh.findAll", query = "SELECT c FROM ClasseCompteAh c"),
    @NamedQuery(name = "ClasseCompteAh.findByClasse",
        query = "SELECT c FROM ClasseCompteAh c WHERE c.classe = :classe"),
    @NamedQuery(name = "ClasseCompteAh.findByLibelle",
        query = "SELECT c FROM ClasseCompteAh c WHERE c.libelle = :libelle")})
public class ClasseCompteAh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "CLASSE")
  private String classe;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;

  public ClasseCompteAh() {}

  public ClasseCompteAh(String classe) {
    this.classe = classe;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
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
    hash += (classe != null ? classe.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClasseCompteAh)) {
      return false;
    }
    ClasseCompteAh other = (ClasseCompteAh) object;
    if ((this.classe == null && other.classe != null)
        || (this.classe != null && !this.classe.equals(other.classe))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.ClasseCompteAh[ classe=" + classe + " ]";
  }

}
