/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "APPAREIL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Appareil.findAll", query = "SELECT a FROM Appareil a"),
    @NamedQuery(name = "Appareil.findByTypeApp",
        query = "SELECT a FROM Appareil a WHERE a.appareilPK.typeApp = :typeApp"),
    @NamedQuery(name = "Appareil.findByMatrApp",
        query = "SELECT a FROM Appareil a WHERE a.appareilPK.matrApp = :matrApp"),
    @NamedQuery(name = "Appareil.findBySiegesOffF",
        query = "SELECT a FROM Appareil a WHERE a.siegesOffF = :siegesOffF"),
    @NamedQuery(name = "Appareil.findBySiegesOffC",
        query = "SELECT a FROM Appareil a WHERE a.siegesOffC = :siegesOffC"),
    @NamedQuery(name = "Appareil.findBySiegesOffY",
        query = "SELECT a FROM Appareil a WHERE a.siegesOffY = :siegesOffY"),
    @NamedQuery(name = "Appareil.findByNbrPnt",
        query = "SELECT a FROM Appareil a WHERE a.nbrPnt = :nbrPnt"),
    @NamedQuery(name = "Appareil.findByNbrPnc",
        query = "SELECT a FROM Appareil a WHERE a.nbrPnc = :nbrPnc"),
    @NamedQuery(name = "Appareil.findByLibeApp",
        query = "SELECT a FROM Appareil a WHERE a.libeApp = :libeApp"),
    @NamedQuery(name = "Appareil.findByLibcApp",
        query = "SELECT a FROM Appareil a WHERE a.libcApp = :libcApp")})
public class Appareil implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AppareilPK appareilPK;
  @Column(name = "SIEGES_OFF_F")
  private Integer siegesOffF;
  @Column(name = "SIEGES_OFF_C")
  private Integer siegesOffC;
  @Column(name = "SIEGES_OFF_Y")
  private Integer siegesOffY;
  @Column(name = "NBR_PNT")
  private Integer nbrPnt;
  @Column(name = "NBR_PNC")
  private Integer nbrPnc;
  @Size(max = 100)
  @Column(name = "LIBE_APP")
  private String libeApp;
  @Size(max = 50)
  @Column(name = "LIBC_APP")
  private String libcApp;

  public Appareil() {}

  public Appareil(AppareilPK appareilPK) {
    this.appareilPK = appareilPK;
  }

  public Appareil(String typeApp, String matrApp) {
    this.appareilPK = new AppareilPK(typeApp, matrApp);
  }

  public AppareilPK getAppareilPK() {
    return appareilPK;
  }

  public void setAppareilPK(AppareilPK appareilPK) {
    this.appareilPK = appareilPK;
  }

  public Integer getSiegesOffF() {
    return siegesOffF;
  }

  public void setSiegesOffF(Integer siegesOffF) {
    this.siegesOffF = siegesOffF;
  }

  public Integer getSiegesOffC() {
    return siegesOffC;
  }

  public void setSiegesOffC(Integer siegesOffC) {
    this.siegesOffC = siegesOffC;
  }

  public Integer getSiegesOffY() {
    return siegesOffY;
  }

  public void setSiegesOffY(Integer siegesOffY) {
    this.siegesOffY = siegesOffY;
  }

  public Integer getNbrPnt() {
    return nbrPnt;
  }

  public void setNbrPnt(Integer nbrPnt) {
    this.nbrPnt = nbrPnt;
  }

  public Integer getNbrPnc() {
    return nbrPnc;
  }

  public void setNbrPnc(Integer nbrPnc) {
    this.nbrPnc = nbrPnc;
  }

  public String getLibeApp() {
    return libeApp;
  }

  public void setLibeApp(String libeApp) {
    this.libeApp = libeApp;
  }

  public String getLibcApp() {
    return libcApp;
  }

  public void setLibcApp(String libcApp) {
    this.libcApp = libcApp;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (appareilPK != null ? appareilPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Appareil)) {
      return false;
    }
    Appareil other = (Appareil) object;
    if ((this.appareilPK == null && other.appareilPK != null)
        || (this.appareilPK != null && !this.appareilPK.equals(other.appareilPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.Appareil[ appareilPK=" + appareilPK + " ]";
  }

}
