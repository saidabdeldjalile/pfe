/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "RAISON_TRANSFERT")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "RaisonRejet.findAll", query = "SELECT r FROM RaisonRejet r")})
public class RaisonRejetTransfert implements Serializable, Comparable<RaisonRejetTransfert> {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "SEQUENCE12", sequenceName = "SEQUENCE12", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE12")
  @Basic(optional = false)
  @Column(name = "raison_rejet_id")
  private Integer raisonRejetId;
  @JoinColumn(name = "dossierId", referencedColumnName = "dossierTransfertId")
  @ManyToOne(optional = false)
  private Dossiertransfert dossierId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1000)
  @Column(name = "content")
  private String content;

  public RaisonRejetTransfert() {}

  public RaisonRejetTransfert(Integer raisonRejetId) {
    this.raisonRejetId = raisonRejetId;
  }

  public RaisonRejetTransfert(Integer raisonRejetId, Dossiertransfert dossierId, String content) {
    this.raisonRejetId = raisonRejetId;
    this.dossierId = dossierId;
    this.content = content;
  }

  public Integer getRaisonRejetId() {
    return raisonRejetId;
  }

  public void setRaisonRejetId(Integer raisonRejetId) {
    this.raisonRejetId = raisonRejetId;
  }

  public Dossiertransfert getDossierId() {
    return dossierId;
  }

  public void setDossierId(Dossiertransfert dossierId) {
    this.dossierId = dossierId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (raisonRejetId != null ? raisonRejetId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RaisonRejet)) {
      return false;
    }
    RaisonRejetTransfert other = (RaisonRejetTransfert) object;
    if ((this.raisonRejetId == null && other.raisonRejetId != null)
        || (this.raisonRejetId != null && !this.raisonRejetId.equals(other.raisonRejetId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.dsi.immo.model.RaisonRejetTransfert[ raisonRejetId=" + raisonRejetId
        + " ]";
  }

  @Override
  public int compareTo(RaisonRejetTransfert o) {
    return this.getRaisonRejetId().compareTo(o.getRaisonRejetId());
  }

}
