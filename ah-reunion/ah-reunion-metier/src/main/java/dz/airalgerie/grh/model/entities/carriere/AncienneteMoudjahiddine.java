/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "ANC_MOUDJ")
public class AncienneteMoudjahiddine implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAUX_MOUDJ")
  private BigDecimal tauxMoudj;
  @Column(name = "MONT_MOUDJ")
  private BigDecimal montMoudj;
  @Column(name = "MONT_CHAID")
  private BigDecimal montChaid;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;

  public AncienneteMoudjahiddine() {}

  public AncienneteMoudjahiddine(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public BigDecimal getTauxMoudj() {
    return tauxMoudj;
  }

  public void setTauxMoudj(BigDecimal tauxMoudj) {
    this.tauxMoudj = tauxMoudj;
  }

  public BigDecimal getMontMoudj() {
    return montMoudj;
  }

  public void setMontMoudj(BigDecimal montMoudj) {
    this.montMoudj = montMoudj;
  }

  public BigDecimal getMontChaid() {
    return montChaid;
  }

  public void setMontChaid(BigDecimal montChaid) {
    this.montChaid = montChaid;
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
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AncienneteMoudjahiddine)) {
      return false;
    }
    AncienneteMoudjahiddine other = (AncienneteMoudjahiddine) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.AncienneteMoudjahiddine[ matricule=" + matricule + " ]";
  }

}
