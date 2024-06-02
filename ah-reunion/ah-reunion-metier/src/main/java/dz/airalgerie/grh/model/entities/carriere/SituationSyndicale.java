/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "SIT_SYNDICALE")
public class SituationSyndicale implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected SituationSyndicalePK sitSyndicalePK;
  @JoinColumn(name = "CODE_SYN", referencedColumnName = "CODE_SYN")
  @ManyToOne(fetch = FetchType.LAZY)
  private Syndicat syndicat;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_FIN")
  private Date dateFin;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public SituationSyndicale() {}

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public SituationSyndicalePK getSitSyndicalePK() {
    return sitSyndicalePK;
  }

  public void setSitSyndicalePK(SituationSyndicalePK sitSyndicalePK) {
    this.sitSyndicalePK = sitSyndicalePK;
  }

  public Syndicat getSyndicat() {
    return syndicat;
  }

  public void setSyndicat(Syndicat syndicat) {
    this.syndicat = syndicat;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (sitSyndicalePK != null ? sitSyndicalePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SituationSyndicale)) {
      return false;
    }
    SituationSyndicale other = (SituationSyndicale) object;
    if ((this.sitSyndicalePK == null && other.sitSyndicalePK != null)
        || (this.sitSyndicalePK != null && !this.sitSyndicalePK.equals(other.sitSyndicalePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.SituationSyndicale[ matricule=" + sitSyndicalePK + " ]";
  }

}
