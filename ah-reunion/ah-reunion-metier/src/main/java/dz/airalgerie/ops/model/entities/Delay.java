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
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "DELAY", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Delay.findAll", query = "SELECT d FROM Delay d"),
    @NamedQuery(name = "Delay.findById", query = "SELECT d FROM Delay d WHERE d.id = :id"),
    @NamedQuery(name = "Delay.findByPosition",
        query = "SELECT d FROM Delay d WHERE d.position = :position"),
    @NamedQuery(name = "Delay.findByDuree", query = "SELECT d FROM Delay d WHERE d.duree = :duree"),
    @NamedQuery(name = "Delay.findByType", query = "SELECT d FROM Delay d WHERE d.type = :type")})
public class Delay implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "POSITION")
  private Short position;
  @Column(name = "DUREE")
  private Integer duree;
  @Column(name = "TYPE")
  private char type;
  @Size(max = 500)
  @Column(name = "COMMENTAIRE")
  private String commentaire;
  @Column(name = "IS_EDITED")
  private boolean isEdited;
  @Basic(optional = false)
  @Size(max = 100)
  @Column(name = "AGENT")
  private String agent;
  @JoinColumn(name = "CAUSE", referencedColumnName = "CODE_DL")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private DlCodes cause;
  @JoinColumn(name = "VOL_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Vol volId;

  public Delay() {
  }

  public Delay(Delay delay) {
    this.id = delay.getId();
    this.cause = delay.getCause();
    this.duree = delay.getDuree();
    this.position = delay.getPosition();
    this.type = delay.getType();
    this.commentaire = delay.getCommentaire();
    this.agent = delay.getAgent();
    this.isEdited = delay.isIsEdited();
  }

  public Delay(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Short getPosition() {
    return position;
  }

  public void setPosition(Short position) {
    this.position = position;
  }

  public Integer getDuree() {
    return duree;
  }

  public void setDuree(Integer duree) {
    this.duree = duree;
  }

  public char getType() {
    return type;
  }

  public void setType(char type) {
    this.type = type;
  }

  public DlCodes getCause() {
    return cause;
  }

  public void setCause(DlCodes cause) {
    this.cause = cause;
  }

  public Vol getVolId() {
    return volId;
  }

  public void setVolId(Vol volId) {
    this.volId = volId;
  }

  public String getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(String commentaire) {
    this.commentaire = commentaire;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Delay)) {
      return false;
    }
    Delay other = (Delay) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.Delay[ id=" + id + " ]";
  }

}
