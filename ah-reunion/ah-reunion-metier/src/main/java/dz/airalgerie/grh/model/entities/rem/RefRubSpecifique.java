/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "REF_RUB_SPECIFIQUE", schema = Utils.dbSchema)
public class RefRubSpecifique implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RefRubSpecifiquePK refRubSpecifiquePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;

  public RefRubSpecifique() {}

  public RefRubSpecifique(RefRubSpecifiquePK refRubSpecifiquePK) {
    this.refRubSpecifiquePK = refRubSpecifiquePK;
  }

  public RefRubSpecifique(RefRubSpecifiquePK refRubSpecifiquePK, String libelle) {
    this.refRubSpecifiquePK = refRubSpecifiquePK;
    this.libelle = libelle;
  }

  public RefRubSpecifique(String codeRubSp, Character codeVal) {
    this.refRubSpecifiquePK = new RefRubSpecifiquePK(codeRubSp, codeVal);
  }

  public RefRubSpecifiquePK getRefRubSpecifiquePK() {
    return refRubSpecifiquePK;
  }

  public void setRefRubSpecifiquePK(RefRubSpecifiquePK refRubSpecifiquePK) {
    this.refRubSpecifiquePK = refRubSpecifiquePK;
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
    hash += (refRubSpecifiquePK != null ? refRubSpecifiquePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RefRubSpecifique)) {
      return false;
    }
    RefRubSpecifique other = (RefRubSpecifique) object;
    if ((this.refRubSpecifiquePK == null && other.refRubSpecifiquePK != null)
        || (this.refRubSpecifiquePK != null
            && !this.refRubSpecifiquePK.equals(other.refRubSpecifiquePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.RefRubSpecifique[ refRubSpecifiquePK=" + refRubSpecifiquePK + " ]";
  }

}
