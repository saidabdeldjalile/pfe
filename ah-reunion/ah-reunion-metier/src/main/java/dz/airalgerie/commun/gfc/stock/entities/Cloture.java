/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.cloture")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Cloture.findAll", query = "SELECT c FROM Cloture c"),
    @NamedQuery(name = "Cloture.findByDateTraitCloture",
        query = "SELECT c FROM Cloture c WHERE c.cloturePK.dateTraitCloture = :dateTraitCloture"),
    @NamedQuery(name = "Cloture.findByTypeEngin",
        query = "SELECT c FROM Cloture c WHERE c.cloturePK.typeEngin = :typeEngin"),
    @NamedQuery(name = "Cloture.findByDateReelCloture",
        query = "SELECT c FROM Cloture c WHERE c.dateReelCloture = :dateReelCloture"),
    @NamedQuery(name = "Cloture.findByNbrArtLus",
        query = "SELECT c FROM Cloture c WHERE c.nbrArtLus = :nbrArtLus"),
    @NamedQuery(name = "Cloture.findByValArtLus",
        query = "SELECT c FROM Cloture c WHERE c.valArtLus = :valArtLus"),
    @NamedQuery(name = "Cloture.findByNbrMvt",
        query = "SELECT c FROM Cloture c WHERE c.nbrMvt = :nbrMvt"),
    @NamedQuery(name = "Cloture.findByNbrEntree",
        query = "SELECT c FROM Cloture c WHERE c.nbrEntree = :nbrEntree"),
    @NamedQuery(name = "Cloture.findByValEntree",
        query = "SELECT c FROM Cloture c WHERE c.valEntree = :valEntree"),
    @NamedQuery(name = "Cloture.findByNbrSortie",
        query = "SELECT c FROM Cloture c WHERE c.nbrSortie = :nbrSortie"),
    @NamedQuery(name = "Cloture.findByValSortie",
        query = "SELECT c FROM Cloture c WHERE c.valSortie = :valSortie"),
    @NamedQuery(name = "Cloture.findByNbrArtEcr",
        query = "SELECT c FROM Cloture c WHERE c.nbrArtEcr = :nbrArtEcr"),
    @NamedQuery(name = "Cloture.findByValArtEcr",
        query = "SELECT c FROM Cloture c WHERE c.valArtEcr = :valArtEcr"),
    @NamedQuery(name = "Cloture.findByObservation",
        query = "SELECT c FROM Cloture c WHERE c.observation = :observation")})
public class Cloture implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CloturePK cloturePK;
  @Column(name = "dateReelCloture")
  @Temporal(TemporalType.DATE)
  private Date dateReelCloture;
  @Size(max = 15)
  @Column(name = "nbrArtLus")
  private String nbrArtLus;
  @Size(max = 18)
  @Column(name = "valArtLus")
  private String valArtLus;
  @Size(max = 15)
  @Column(name = "nbrMvt")
  private String nbrMvt;
  @Size(max = 15)
  @Column(name = "nbrEntree")
  private String nbrEntree;
  @Size(max = 18)
  @Column(name = "valEntree")
  private String valEntree;
  @Size(max = 15)
  @Column(name = "nbrSortie")
  private String nbrSortie;
  @Size(max = 18)
  @Column(name = "valSortie")
  private String valSortie;
  @Size(max = 15)
  @Column(name = "nbrArtEcr")
  private String nbrArtEcr;
  @Size(max = 18)
  @Column(name = "valArtEcr")
  private String valArtEcr;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  public Cloture() {}

  public Cloture(CloturePK cloturePK) {
    this.cloturePK = cloturePK;
  }

  public Cloture(int dateTraitCloture, String typeEngin) {
    this.cloturePK = new CloturePK(dateTraitCloture, typeEngin);
  }

  public CloturePK getCloturePK() {
    return cloturePK;
  }

  public void setCloturePK(CloturePK cloturePK) {
    this.cloturePK = cloturePK;
  }

  public Date getDateReelCloture() {
    return dateReelCloture;
  }

  public void setDateReelCloture(Date dateReelCloture) {
    this.dateReelCloture = dateReelCloture;
  }

  public String getNbrArtLus() {
    return nbrArtLus;
  }

  public void setNbrArtLus(String nbrArtLus) {
    this.nbrArtLus = nbrArtLus;
  }

  public String getValArtLus() {
    return valArtLus;
  }

  public void setValArtLus(String valArtLus) {
    this.valArtLus = valArtLus;
  }

  public String getNbrMvt() {
    return nbrMvt;
  }

  public void setNbrMvt(String nbrMvt) {
    this.nbrMvt = nbrMvt;
  }

  public String getNbrEntree() {
    return nbrEntree;
  }

  public void setNbrEntree(String nbrEntree) {
    this.nbrEntree = nbrEntree;
  }

  public String getValEntree() {
    return valEntree;
  }

  public void setValEntree(String valEntree) {
    this.valEntree = valEntree;
  }

  public String getNbrSortie() {
    return nbrSortie;
  }

  public void setNbrSortie(String nbrSortie) {
    this.nbrSortie = nbrSortie;
  }

  public String getValSortie() {
    return valSortie;
  }

  public void setValSortie(String valSortie) {
    this.valSortie = valSortie;
  }

  public String getNbrArtEcr() {
    return nbrArtEcr;
  }

  public void setNbrArtEcr(String nbrArtEcr) {
    this.nbrArtEcr = nbrArtEcr;
  }

  public String getValArtEcr() {
    return valArtEcr;
  }

  public void setValArtEcr(String valArtEcr) {
    this.valArtEcr = valArtEcr;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cloturePK != null ? cloturePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cloture)) {
      return false;
    }
    Cloture other = (Cloture) object;
    if ((this.cloturePK == null && other.cloturePK != null)
        || (this.cloturePK != null && !this.cloturePK.equals(other.cloturePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Cloture[ cloturePK=" + cloturePK + " ]";
  }

}
