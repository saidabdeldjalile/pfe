/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

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
@Table(name = "REFORME")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Reforme.findAll", query = "SELECT r FROM Reforme r")})
public class Reforme implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "CODENOM")
  private String codeNom;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DOSSIERREFORMEID")
  private long dossierreformeid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "USERID")
  private long userid;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "STATUT")
  private String statut;

  public Reforme() {}

  public Reforme(String codeNom) {
    this.codeNom = codeNom;
  }

  public Reforme(String codeNom, long dossierreformeid, long userid, String statut) {
    this.codeNom = codeNom;
    this.dossierreformeid = dossierreformeid;
    this.userid = userid;
    this.statut = statut;
  }

  public String getCodeNom() {
    return codeNom;
  }

  public void setCodeNom(String codeNom) {
    this.codeNom = codeNom;
  }

  public long getDossierreformeid() {
    return dossierreformeid;
  }

  public void setDossierreformeid(long dossierreformeid) {
    this.dossierreformeid = dossierreformeid;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeNom != null ? codeNom.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Reforme)) {
      return false;
    }
    Reforme other = (Reforme) object;
    if ((this.codeNom == null && other.codeNom != null)
        || (this.codeNom != null && !this.codeNom.equals(other.codeNom))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Reforme[ codeNom=" + codeNom + " ]";
  }

}
