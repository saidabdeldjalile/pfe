/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "IEP")
public class Iep implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected IepPK iepPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_IEP")
  private BigDecimal montIep;
  @Column(name = "TAUX_IEP")
  private BigDecimal tauxIep;
  @Size(max = 10)
  @Column(name = "DATE_FIN")
  private String dateFin;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;

  public Iep() {}

  public Iep(IepPK iepPK) {
    this.iepPK = iepPK;
  }

  public Iep(int matricule, String dateDeb) {
    this.iepPK = new IepPK(matricule, dateDeb);
  }

  public IepPK getIepPK() {
    return iepPK;
  }

  public void setIepPK(IepPK iepPK) {
    this.iepPK = iepPK;
  }

  public BigDecimal getMontIep() {
    return montIep;
  }

  public void setMontIep(BigDecimal montIep) {
    this.montIep = montIep;
  }

  public BigDecimal getTauxIep() {
    return tauxIep;
  }

  public void setTauxIep(BigDecimal tauxIep) {
    this.tauxIep = tauxIep;
  }

  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
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
    hash += (iepPK != null ? iepPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Iep)) {
      return false;
    }
    Iep other = (Iep) object;
    if ((this.iepPK == null && other.iepPK != null)
        || (this.iepPK != null && !this.iepPK.equals(other.iepPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Iep[ iepPK=" + iepPK + " ]";
  }

}
