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
@Table(schema = "CAR", name = "ANCIENNETE")
public class Anciennete implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AnciennetePK anciennetePK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAUX_MAJ")
  private BigDecimal tauxMaj;
  @Column(name = "MONT_MAJ")
  private BigDecimal montMaj;
  @Size(max = 10)
  @Column(name = "DATE_FIN")
  private String dateFin;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;

  public Anciennete() {}

  public Anciennete(AnciennetePK anciennetePK) {
    this.anciennetePK = anciennetePK;
  }

  public Anciennete(int matricule, String dateDeb) {
    this.anciennetePK = new AnciennetePK(matricule, dateDeb);
  }

  public AnciennetePK getAnciennetePK() {
    return anciennetePK;
  }

  public void setAnciennetePK(AnciennetePK anciennetePK) {
    this.anciennetePK = anciennetePK;
  }

  public BigDecimal getTauxMaj() {
    return tauxMaj;
  }

  public void setTauxMaj(BigDecimal tauxMaj) {
    this.tauxMaj = tauxMaj;
  }

  public BigDecimal getMontMaj() {
    return montMaj;
  }

  public void setMontMaj(BigDecimal montMaj) {
    this.montMaj = montMaj;
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
    hash += (anciennetePK != null ? anciennetePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Anciennete)) {
      return false;
    }
    Anciennete other = (Anciennete) object;
    if ((this.anciennetePK == null && other.anciennetePK != null)
        || (this.anciennetePK != null && !this.anciennetePK.equals(other.anciennetePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Anciennete[ anciennetePK=" + anciennetePK + " ]";
  }

}
