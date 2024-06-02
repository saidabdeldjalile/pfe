/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.cg;

import dz.airalgerie.gfc.model.entities.commun.CentreComptablePK;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "V_CENTRE_CPT_DIRECTION", schema = "CF")
@XmlRootElement
public class CentreComptableDirection implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CentreComptablePK centreComptablePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 150)
  @Column(name = "LIBELLE")
  private String libelle;

  public CentreComptableDirection() {
    // Class init.
  }

  public CentreComptablePK getCentreComptablePK() {
    return centreComptablePK;
  }

  public void setCentreComptablePK(CentreComptablePK centreComptablePK) {
    this.centreComptablePK = centreComptablePK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

}
