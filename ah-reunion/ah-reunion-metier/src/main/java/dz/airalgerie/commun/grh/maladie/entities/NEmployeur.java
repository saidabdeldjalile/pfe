/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author user
 */
@Entity
@Table(name = "N_EMPLOYEUR")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "NEmployeur.findAll", query = "SELECT n FROM NEmployeur n"),
    @NamedQuery(name = "NEmployeur.findByCodeWil",
        query = "SELECT n FROM NEmployeur n WHERE n.nEmployeurPK.codeWil = :codeWil"),
    @NamedQuery(name = "NEmployeur.findByCodeFil",
        query = "SELECT n FROM NEmployeur n WHERE n.nEmployeurPK.codeFil = :codeFil"),
    @NamedQuery(name = "NEmployeur.findByDateDb",
        query = "SELECT n FROM NEmployeur n WHERE n.dateDb = :dateDb"),
    @NamedQuery(name = "NEmployeur.findByDateFin",
        query = "SELECT n FROM NEmployeur n WHERE n.dateFin = :dateFin"),
    @NamedQuery(name = "NEmployeur.findByNEmpr",
        query = "SELECT n FROM NEmployeur n WHERE n.nEmpr = :nEmpr")})
public class NEmployeur implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected NEmployeurPK nEmployeurPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DB")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateDb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateFin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "N_EMPR")
  private String nEmpr;

  public NEmployeur() {}

  public NEmployeur(NEmployeurPK nEmployeurPK) {
    this.nEmployeurPK = nEmployeurPK;
  }

  public NEmployeur(NEmployeurPK nEmployeurPK, Date dateDb, Date dateFin, String nEmpr) {
    this.nEmployeurPK = nEmployeurPK;
    this.dateDb = dateDb;
    this.dateFin = dateFin;
    this.nEmpr = nEmpr;
  }

  public NEmployeur(int codeWil, String codeFil) {
    this.nEmployeurPK = new NEmployeurPK(codeWil, codeFil);
  }

  public NEmployeurPK getNEmployeurPK() {
    return nEmployeurPK;
  }

  public void setNEmployeurPK(NEmployeurPK nEmployeurPK) {
    this.nEmployeurPK = nEmployeurPK;
  }

  public Date getDateDb() {
    return dateDb;
  }

  public void setDateDb(Date dateDb) {
    this.dateDb = dateDb;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getNEmpr() {
    return nEmpr;
  }

  public void setNEmpr(String nEmpr) {
    this.nEmpr = nEmpr;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (nEmployeurPK != null ? nEmployeurPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof NEmployeur)) {
      return false;
    }
    NEmployeur other = (NEmployeur) object;
    if ((this.nEmployeurPK == null && other.nEmployeurPK != null)
        || (this.nEmployeurPK != null && !this.nEmployeurPK.equals(other.nEmployeurPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.NEmployeur[ nEmployeurPK=" + nEmployeurPK + " ]";
  }

}
