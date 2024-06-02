/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "FRM", name = "LANGUE")
public class Langue implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected LanguePK languePK;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_LNG", referencedColumnName = "CODE_LNG", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private RefLangue refLangue;
  @JoinColumn(name = "CODE_DEG", referencedColumnName = "CODE_DEG")
  @ManyToOne(fetch = FetchType.LAZY)
  private DegreLangue degreLangue;
  @Column(name = "STATUT")
  private Integer statut;

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Langue() {}

  public Langue(LanguePK languePK) {
    this.languePK = languePK;
  }

  public Langue(int matricule, String codeLng) {
    this.languePK = new LanguePK(matricule, codeLng);
  }

  public LanguePK getLanguePK() {
    return languePK;
  }

  public void setLanguePK(LanguePK languePK) {
    this.languePK = languePK;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public RefLangue getRefLangue() {
    return refLangue;
  }

  public void setRefLangue(RefLangue refLangue) {
    this.refLangue = refLangue;
  }

  public DegreLangue getDegreLangue() {
    return degreLangue;
  }

  public void setDegreLangue(DegreLangue degreLangue) {
    this.degreLangue = degreLangue;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (languePK != null ? languePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Langue)) {
      return false;
    }
    Langue other = (Langue) object;
    if ((this.languePK == null && other.languePK != null)
        || (this.languePK != null && !this.languePK.equals(other.languePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Langue[ languePK=" + languePK + " ]";
  }

}
