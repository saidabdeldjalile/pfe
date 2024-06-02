/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.view.commun;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "[V_POSTE_TRAVAIL]", schema = "CAR")
public class Fonction implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "[CODE_PSTR]")
  private String codeFonction;
  @Column(name = "[LIBELLE]")
  private String descriptionFonction;

  public String getCodeFonction() {
    return codeFonction;
  }

  public void setCodeFonction(String codeFonction) {
    this.codeFonction = codeFonction;
  }

  public String getDescriptionFonction() {
    return descriptionFonction;
  }

  public void setDescriptionFonction(String descriptionFonction) {
    this.descriptionFonction = descriptionFonction;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeFonction != null ? codeFonction.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Fonction)) {
      return false;
    }
    Fonction other = (Fonction) object;
    if ((this.codeFonction == null && other.codeFonction != null)
        || (this.codeFonction != null && !this.codeFonction.equals(other.codeFonction))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Fonction[ id=" + codeFonction + " ]";
  }

}
