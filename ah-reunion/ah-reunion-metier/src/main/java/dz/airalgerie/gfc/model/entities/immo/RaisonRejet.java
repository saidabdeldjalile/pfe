/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "RAISON_REJET")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "RaisonRejet.findAll", query = "SELECT r FROM RaisonRejet r")})
public class RaisonRejet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "RAISON_REJET_ID")
  private Long raisonRejetId;
  @Size(max = 1000)
  @Column(name = "CONTENT")
  private String content;
  @JoinColumn(name = "DOSSIERID", referencedColumnName = "DOSSIERID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Dossier dossier;

  public RaisonRejet() {}

  public RaisonRejet(Long raisonRejetId) {
    this.raisonRejetId = raisonRejetId;
  }

  public Long getRaisonRejetId() {
    return raisonRejetId;
  }

  public void setRaisonRejetId(Long raisonRejetId) {
    this.raisonRejetId = raisonRejetId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Dossier getDossier() {
    return dossier;
  }

  public void setDossier(Dossier dossier) {
    this.dossier = dossier;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (raisonRejetId != null ? raisonRejetId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof RaisonRejet)) {
      return false;
    }
    RaisonRejet other = (RaisonRejet) object;
    if ((this.raisonRejetId == null && other.raisonRejetId != null)
        || (this.raisonRejetId != null && !this.raisonRejetId.equals(other.raisonRejetId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.RaisonRejet[ raisonRejetId=" + raisonRejetId + " ]";
  }

}
