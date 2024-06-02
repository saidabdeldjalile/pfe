/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import dz.airalgerie.gfc.model.entities.commun.UniteImmo;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "DOSSIERTRANSFERT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossiertransfert.findAll", query = "SELECT d FROM Dossiertransfert d")})
public class Dossiertransfert implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DOSSIERTRANSFERTID")
  private Long dossiertransfertid;
  @Column(name = "DATETRANSFERT")
  @Temporal(TemporalType.DATE)
  private Date datetransfert;
  @Column(name = "DATEDEMANDE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datedemande;
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Size(max = 50)
  @Column(name = "STATUT")
  private String statut;
  @Column(name = "USERID")
  private Long userid;
  @JoinColumn(name = "UNITEPRENATE", referencedColumnName = "UNITEID")
  @ManyToOne(fetch = FetchType.LAZY)
  private UniteImmo unite;
  @JoinColumn(name = "UNITECEDANTE", referencedColumnName = "UNITEID")
  @ManyToOne(fetch = FetchType.LAZY)
  private UniteImmo unite1;

  public Dossiertransfert() {}

  public Dossiertransfert(Long dossiertransfertid) {
    this.dossiertransfertid = dossiertransfertid;
  }

  public Long getDossiertransfertid() {
    return dossiertransfertid;
  }

  public void setDossiertransfertid(Long dossiertransfertid) {
    this.dossiertransfertid = dossiertransfertid;
  }

  public Date getDatetransfert() {
    return datetransfert;
  }

  public void setDatetransfert(Date datetransfert) {
    this.datetransfert = datetransfert;
  }

  public Date getDatedemande() {
    return datedemande;
  }

  public void setDatedemande(Date datedemande) {
    this.datedemande = datedemande;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public UniteImmo getUnite() {
    return unite;
  }

  public void setUnite(UniteImmo unite) {
    this.unite = unite;
  }

  public UniteImmo getUnite1() {
    return unite1;
  }

  public void setUnite1(UniteImmo unite1) {
    this.unite1 = unite1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dossiertransfertid != null ? dossiertransfertid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Dossiertransfert)) {
      return false;
    }
    Dossiertransfert other = (Dossiertransfert) object;
    if ((this.dossiertransfertid == null && other.dossiertransfertid != null)
        || (this.dossiertransfertid != null
            && !this.dossiertransfertid.equals(other.dossiertransfertid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Dossiertransfert[ dossiertransfertid="
        + dossiertransfertid + " ]";
  }

}
