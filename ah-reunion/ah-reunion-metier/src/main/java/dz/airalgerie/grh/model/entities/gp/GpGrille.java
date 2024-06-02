/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "GP", name = "GP_GRILLE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "GpGrille.findAll", query = "SELECT g FROM GpGrille g"),
    @NamedQuery(name = "GpGrille.findByPstrLib",
        query = "SELECT g FROM GpGrille g WHERE g.gpGrillePK.pstrLib = :pstrLib"),
    @NamedQuery(name = "GpGrille.findByAnciennete",
        query = "SELECT g FROM GpGrille g WHERE g.gpGrillePK.anciennete = :anciennete"),
    @NamedQuery(name = "GpGrille.findByDateD",
        query = "SELECT g FROM GpGrille g WHERE g.gpGrillePK.dateD = :dateD"),
    @NamedQuery(name = "GpGrille.findByDateF",
        query = "SELECT g FROM GpGrille g WHERE g.gpGrillePK.dateF = :dateF"),
    @NamedQuery(name = "GpGrille.findByNbR1",
        query = "SELECT g FROM GpGrille g WHERE g.nbR1 = :nbR1"),
    @NamedQuery(name = "GpGrille.findByNbR2",
        query = "SELECT g FROM GpGrille g WHERE g.nbR2 = :nbR2"),
    @NamedQuery(name = "GpGrille.findByNbR3",
        query = "SELECT g FROM GpGrille g WHERE g.nbR3 = :nbR3"),
    @NamedQuery(name = "GpGrille.findByNbRn",
        query = "SELECT g FROM GpGrille g WHERE g.nbRn = :nbRn")})
public class GpGrille implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GpGrillePK gpGrillePK;
  @Column(name = "NB_R1")
  private Integer nbR1;
  @Column(name = "NB_R2")
  private Integer nbR2;
  @Column(name = "NB_R3")
  private Integer nbR3;
  @Column(name = "NB_RN")
  private Integer nbRn;

  public GpGrille() {}

  public GpGrille(GpGrillePK gpGrillePK) {
    this.gpGrillePK = gpGrillePK;
  }

  public GpGrille(String pstrLib, int anciennete, LocalDate dateD, LocalDate dateF) {
    this.gpGrillePK = new GpGrillePK(pstrLib, anciennete, dateD, dateF);
  }

  public GpGrillePK getGpGrillePK() {
    return gpGrillePK;
  }

  public void setGpGrillePK(GpGrillePK gpGrillePK) {
    this.gpGrillePK = gpGrillePK;
  }

  public Integer getNbR1() {
    return nbR1;
  }

  public void setNbR1(Integer nbR1) {
    this.nbR1 = nbR1;
  }

  public Integer getNbR2() {
    return nbR2;
  }

  public void setNbR2(Integer nbR2) {
    this.nbR2 = nbR2;
  }

  public Integer getNbR3() {
    return nbR3;
  }

  public void setNbR3(Integer nbR3) {
    this.nbR3 = nbR3;
  }

  public Integer getNbRn() {
    return nbRn;
  }

  public void setNbRn(Integer nbRn) {
    this.nbRn = nbRn;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (gpGrillePK != null ? gpGrillePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GpGrille)) {
      return false;
    }
    GpGrille other = (GpGrille) object;
    if ((this.gpGrillePK == null && other.gpGrillePK != null)
        || (this.gpGrillePK != null && !this.gpGrillePK.equals(other.gpGrillePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.GpGrille[ gpGrillePK=" + gpGrillePK + " ]";
  }

}
