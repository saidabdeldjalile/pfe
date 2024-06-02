/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import dz.airalgerie.gfc.model.dto.cu.DTOCentreComptableDirection;
import java.io.Serializable;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CENTRE_CPT_DIR", schema = "CF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentreComptable.findAll", query = "SELECT c FROM CentreComptable c"),
    @NamedQuery(name = "CentreComptable.findByCodeCentreCpt",
        query = "SELECT c FROM CentreComptable c WHERE c.centreComptablePK.codeCentreCpt = :codeCentreCpt"),
    @NamedQuery(name = "CentreComptable.findByCodeDir",
        query = "SELECT c FROM CentreComptable c WHERE c.centreComptablePK.codeDir = :codeDir")})
@SqlResultSetMapping(name = "CentreCptDir.findDirectionCentreCpt",
    classes = @ConstructorResult(targetClass = DTOCentreComptableDirection.class,
        columns = {@ColumnResult(name = "CODE_DIR", type = String.class),
            @ColumnResult(name = "LIBELLE_DIRECTION", type = String.class),
            @ColumnResult(name = "CODE_CENTRE_CPT", type = String.class),
            @ColumnResult(name = "LIBELLE_CENTRE_CPT", type = String.class)}))
public class CentreComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CentreComptablePK centreComptablePK;

  public CentreComptable() {
  }

  public CentreComptable(CentreComptablePK centreComptablePK) {
    this.centreComptablePK = centreComptablePK;
  }

  public CentreComptable(String codeCentreCpt, String codeDir) {
    this.centreComptablePK = new CentreComptablePK(codeCentreCpt, codeDir);
  }

  public CentreComptablePK getCentreComptablePK() {
    return centreComptablePK;
  }

  public void setCentreComptablePK(CentreComptablePK centreComptablePK) {
    this.centreComptablePK = centreComptablePK;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (centreComptablePK != null ? centreComptablePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CentreComptable)) {
      return false;
    }
    CentreComptable other = (CentreComptable) object;
    if ((this.centreComptablePK == null && other.centreComptablePK != null)
        || (this.centreComptablePK != null
            && !this.centreComptablePK.equals(other.centreComptablePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.CentreComptable[ centreComptablePK=" + centreComptablePK
        + " ]";
  }

}
