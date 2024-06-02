/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "RELIQUATS", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Reliquats.findAll", query = "SELECT r FROM Reliquats r"),
    @NamedQuery(name = "Reliquats.findByMatricule",
        query = "SELECT r FROM Reliquats r WHERE r.reliquatsPK.matricule = :matricule"),
    @NamedQuery(name = "Reliquats.findByCodeFil",
        query = "SELECT r FROM Reliquats r WHERE r.reliquatsPK.codeFil = :codeFil"),
    @NamedQuery(name = "Reliquats.findByDateTrt",
        query = "SELECT r FROM Reliquats r WHERE r.reliquatsPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Reliquats.findByNbReliquats",
        query = "SELECT r FROM Reliquats r WHERE r.nbReliquats = :nbReliquats"),
    @NamedQuery(name = "Reliquats.findByIsSaisie",
        query = "SELECT r FROM Reliquats r WHERE r.isSaisie = :isSaisie")})
public class Reliquats implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ReliquatsPK reliquatsPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "NB_RELIQUATS")
  private BigDecimal nbReliquats;
  @Column(name = "NB_RELIQUATS_ACQUIS")
  private BigDecimal nbReliquatsAcquis;
  @Column(name = "NB_RELIQUATS_PREVIS")
  private BigDecimal nbReliquatsPrevis;
  @Column(name = "IS_SAISIE")
  private Boolean isSaisie;
  @JoinColumn(name = "MATRICULE", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;

  public Reliquats() {
  }

  public Reliquats(ReliquatsPK reliquatsPK) {
    this.reliquatsPK = reliquatsPK;
  }

  public Reliquats(int matricule, Character codeFil, int dateTrt) {
    this.reliquatsPK = new ReliquatsPK(matricule, codeFil, dateTrt);
  }

  public ReliquatsPK getReliquatsPK() {
    return reliquatsPK;
  }

  public void setReliquatsPK(ReliquatsPK reliquatsPK) {
    this.reliquatsPK = reliquatsPK;
  }

  public BigDecimal getNbReliquats() {
    return nbReliquats;
  }

  public void setNbReliquats(BigDecimal nbReliquats) {
    this.nbReliquats = nbReliquats;
  }

  public Boolean getIsSaisie() {
    return isSaisie;
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  public void setIsSaisie(Boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  public BigDecimal getNbReliquatsAcquis() {
    return nbReliquatsAcquis;
  }

  public void setNbReliquatsAcquis(BigDecimal nbReliquatsAcquis) {
    this.nbReliquatsAcquis = nbReliquatsAcquis;
  }

  public BigDecimal getNbReliquatsPrevis() {
    return nbReliquatsPrevis;
  }

  public void setNbReliquatsPrevis(BigDecimal nbReliquatsPrevis) {
    this.nbReliquatsPrevis = nbReliquatsPrevis;
  }


  @Override
  public int hashCode() {
    int hash = 0;
    hash += (reliquatsPK != null ? reliquatsPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Reliquats)) {
      return false;
    }
    Reliquats other = (Reliquats) object;
    if ((this.reliquatsPK == null && other.reliquatsPK != null)
        || (this.reliquatsPK != null && !this.reliquatsPK.equals(other.reliquatsPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.grh.model.entities.rem.Reliquats[ reliquatsPK=" + reliquatsPK + " ]";
  }

}
