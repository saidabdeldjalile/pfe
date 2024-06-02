/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "CREW", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CrewOps.findAll", query = "SELECT c FROM CrewOps c"),
    @NamedQuery(name = "CrewOps.findById", query = "SELECT c FROM CrewOps c WHERE c.id = :id"),
    @NamedQuery(name = "CrewOps.findByMatricule",
        query = "SELECT c FROM CrewOps c WHERE c.matricule = :matricule"),
    @NamedQuery(name = "CrewOps.findByNom", query = "SELECT c FROM CrewOps c WHERE c.nom = :nom"),
    @NamedQuery(name = "CrewOps.findByPosition",
        query = "SELECT c FROM CrewOps c WHERE c.position = :position"),
    @NamedQuery(name = "CrewOps.findByFonction",
        query = "SELECT c FROM CrewOps c WHERE c.fonction = :fonction")})
public class CrewOps implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 50)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 1)
  @Column(name = "POSITION")
  private String position;
  @Size(max = 2)
  @Column(name = "FONCTION")
  private String fonction;
  @Column(name = "IS_EDITED")
  private boolean isEdited;
  @Basic(optional = false)
  @Size(max = 100)
  @Column(name = "AGENT")
  private String agent;
  @JoinColumn(name = "VOL_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Vol volId;

  public CrewOps() {
  }

  public CrewOps(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public boolean isIsEdited() {
    return isEdited;
  }

  public void setIsEdited(boolean isEdited) {
    this.isEdited = isEdited;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public Vol getVolId() {
    return volId;
  }

  public void setVolId(Vol volId) {
    this.volId = volId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CrewOps)) {
      return false;
    }
    CrewOps other = (CrewOps) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.Crew[ id=" + id + " ]";
  }

}
